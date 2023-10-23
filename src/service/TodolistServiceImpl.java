package service;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService {

    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {
        Todolist[] model = todolistRepository.getAll();
        System.out.println("TodoList");
        for ( var i = 0; i < model.length; i++) {
            var todolist = model[i];
            var no = i + 1;

            if (todolist != null) {
                System.out.println(no + ". " + todolist.getTodo());
            }
        }
    }

    @Override
    public void addTodolist(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);
        System.out.println("Sukses Menambah TODO: "+ todo);

    }

    @Override
    public void romoveTodolist(Integer number) {
        boolean succes = todolistRepository.remove(number);
        if (succes){
            System.out.println("Sukses Menghapus TODO: " + number);
        } else {
            System.out.println("Gagal Menghapus TODO: " + number);
        }
    }
}
