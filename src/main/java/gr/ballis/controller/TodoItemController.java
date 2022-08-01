package gr.ballis.controller;

import gr.ballis.model.TodoData;
import gr.ballis.model.TodoItem;
import gr.ballis.service.TodoItemService;
import gr.ballis.service.TodoItemServiceImpl;
import gr.ballis.util.AttributeNames;
import gr.ballis.util.Mappings;
import gr.ballis.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@Slf4j
public class TodoItemController {

    TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // == handler methods ==
    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model) {
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(todoItem);
        return ViewNames.ITEM;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,  Model model){
        TodoItem todoItem;
        if (id == -1){
            todoItem = new TodoItem("", "", LocalDate.now());
        }else {
            todoItem = todoItemService.getItem(id);
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.debug("todoItem from form = {}", todoItem);
        if (todoItem.getId() != 0){
            todoItemService.updateItem(todoItem);
        }else{
            todoItemService.addItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @RequestMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam("id") int itemId){
        todoItemService.removeItem(itemId);
        return "redirect:/"+ Mappings.ITEMS;
    }
}
