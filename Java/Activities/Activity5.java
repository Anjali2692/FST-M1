package activities;
abstract class Book {
    String title;

 
    abstract void setTitle(String title);

    
    String getTitle() {
        return title;
    }
}


class MyBook extends Book {


    void setTitle(String title) {
        this.title = title;
    }
}


public class Activity5 {
    public static void main(String[] args) {

        
        MyBook newNovel = new MyBook();

       
        String title = "The Alchemist";
        newNovel.setTitle(title);
        System.out.println(newNovel.getTitle());
    }
}