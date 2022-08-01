package gr.ballis.service;

import gr.ballis.model.TodoData;
import gr.ballis.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem addItem);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem updateItem);

    TodoData getData();
}
