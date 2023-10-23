package test.view;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

public class TodolistViewTest {

    public static void main(String[] args) {
     testRemoveViewTodolist();
    }

    public static void testViewTodolist(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);


        todolistService.addTodolist("Java Dasar");
        todolistService.addTodolist("Java Classes");
        todolistService.addTodolist("Java Oop");
        todolistService.addTodolist("Java Lambda");

        todolistView.showTodoList();
    }

    public static void testViewAddTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistView.addTodolist();
        todolistView.showTodoList();
    }

    public static void testRemoveViewTodolist(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);


        todolistService.addTodolist("Java Dasar");
        todolistService.addTodolist("Java Classes");
        todolistService.addTodolist("Java Oop");
        todolistService.addTodolist("Java Lambda");

        todolistService.showTodolist();
        todolistView.removeTodolist();
        todolistService.showTodolist();
    }
}
