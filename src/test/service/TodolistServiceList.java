package test.service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;

public class TodolistServiceList {
    public static void main(String[] args) {


        testRemoveTodoList();
    }

    public static void testshowtodolist(){
        TodolistRepositoryImpl todolistRepository = new TodolistRepositoryImpl();
        todolistRepository.data[0] = new Todolist("Belajar java");

        TodolistService todolistService  = new TodolistServiceImpl(todolistRepository);

        todolistService.showTodolist();
    }

    public static void  testAadTodoList(){
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.addTodolist("Java");
        todolistService.addTodolist("JavaScript");

        todolistService.showTodolist();
    }

    public static void  testRemoveTodoList() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.addTodolist("Java");
        todolistService.addTodolist("JavaScript");

        todolistService.showTodolist();
        todolistService.romoveTodolist(2);
        todolistService.showTodolist();
        todolistService.romoveTodolist(1);
        todolistService.showTodolist();
    }
}
