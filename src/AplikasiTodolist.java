public class AplikasiTodolist {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        testInput();
    }


    /**
     * Menampilkan TodoList
     */
    public static void showTodoList(){
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
    public static void viewShowTodoList(){

    }

    /**
     * Menampilkan view Tambah todo list
     */
    public static void viewAddTodoList(){

    }

    /**
     * Menampilkan view Hapus todo list
     */
    public static void  viewRemoveTodoList(){

    }

}
