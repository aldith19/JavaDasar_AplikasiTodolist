package view;
import service.TodolistService;
import util.InputUtil;



public class TodolistView {
private TodolistService todolistService;

public TodolistView(TodolistService todolistService){
    this.todolistService = todolistService;
}


    public void showTodoList(){
        while (true) {
            todolistService.showTodolist();

            System.out.println("Menu : ");
            System.out.println("1.Tambah");
            System.out.println("2.Hapus");
            System.out.println("x.Keluar ");

            var input = InputUtil.input("pilih");

            if (input.equals("1")) {
                addTodolist();
            } else if (input.equals("2")) {
                removeTodolist();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }

    public void addTodolist(){
        System.out.println("Menambah ToDoList");

        var todo = InputUtil.input("Todo (x jika batal)");

        if (todo.equals("x")){
        }else{
            todolistService.addTodolist(todo);
        }
    }

    public void removeTodolist(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = InputUtil.input("Nomor yang Dihapus (x jika batal)");

        if (number.equals("x")){
            //batal
        }else {
            todolistService.romoveTodolist(Integer.valueOf(number));
            }
        }
    }


