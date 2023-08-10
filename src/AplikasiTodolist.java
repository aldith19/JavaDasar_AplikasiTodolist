public class AplikasiTodolist {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }


    /**
     * Menampilkan TodoList
     */
    public static void showTodoList(){
        System.out.println("TodoList");
     for ( var i = 0; i < model.length; i++) {
         var todo = model[i];
         var no = i + 1;

         if (todo != null) {
             System.out.println(no + ". " + todo);
         }
     }
    }

    public static  void testShowTodoLIst(){
        model[0] = "belajar dasar java";
        model[1] = "main kasus ";
        testAddTodoList();
    }

    /**
     * Menambah TodoList
     */
    public static void addTododoList(String todo){
        // cek apakah model penuh?
        var penuh = true;
        for (int i = 0; i < model.length; i++){
            if (model[i] == null){
                // model masih ada yang kosong
                penuh = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran array 2x lipat
        if (penuh){
            var temp = model;
            model= new String[model.length * 2];

            for (int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

    //tambahkan ke posisi yang data array nya null
        for(var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++){
            addTododoList("contoh Todo ke" + i );
        }
        showTodoList();
    }
    /**
     * Menghapus TodoList
     */
    public static boolean removeTodoList(Integer number){
        if ((number - 1 ) >= model.length){
            return false;
        }
        if (model[number - 1] == null){
            return false;
        }else {
            for (int i = (number - 1); i < model.length; i++){
                if (i == (model.length - 1 )){
                    model[i] = null;
                } else {
                    model[i] = model[i+1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTododoList("satu");
        addTododoList("dua");
        addTododoList("tiga");
        addTododoList("empat");
        addTododoList("lima");

       var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println();

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var data = input("nama");
        System.out.println("Hi" + data);
    }

    /**
     * Menampilkan veiw todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("Menu : ");
            System.out.println("1.Tambah");
            System.out.println("2.Hapus");
            System.out.println("x.Keluar ");

            var input = input("pilih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTododoList("satu");
        addTododoList("dua");
        addTododoList("tiga");
        addTododoList("empat");
        addTododoList("lima");

        viewShowTodoList();
    }

    /**
     * Menampilkan view Tambah todo list
     */
    public static void viewAddTodoList(){
        System.out.println("Menambah ToDoList");

        var todo = input("Todo (x jika batal)");

        if (todo.equals("x")){
        }else{
            addTododoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTododoList("satu");
        addTododoList("dua");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * Menampilkan view Hapus todo list
     */
    public static void  viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang Dihapus (x jika batal)");

        if (number.equals("x")){
            //batal
        }else {
            boolean succses = removeTodoList(Integer.valueOf(number));
        if (!succses){
            System.out.println("Gagal Menghapus todolist : " + number );
        }
        }
    }
    public static void  testviewRemoveTodoList(){
        addTododoList("satu");
        addTododoList("dua");
        addTododoList("tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
