public class librarysystem {
abstract class libraryitem {
    private String title;
    private int itemID;
    private boolean isCheckedOut;

    //the below constructor is one that does take arguments. The arguments are the values that will be assigned upon creation of the object
    //the values are passed in the order they are declared in the class
    //useful for when you want to create an object whose values will be different for each instance of the class
    //this is the constructor we will be using in this project

    public libraryitem(String title, int itemID, boolean isCheckedOut) {
        this.title = title;
        this.itemID = itemID;
        this.isCheckedOut = false;
    }

    // for educational reference, the below constructor is one that does not take any arguments.
    //useful when you want to create an object whose values will remain the same for all instances of the class
    //we will not be using this constructor in this project

    /*public libraryitem(){
        this.title = "";
        this.itemID = 0;
        this.isCheckedOut = false;
    }*/

    //below are the getter methods for the class
    //these methods are used to access the values of the private variables
    public String getTitle(){
        return title;
    }
    public int getItemID(){
        return itemID;
    }
    public boolean getIsCheckedOut(){
        return isCheckedOut;
    }

    //below are the setter methods for the class
    //these methods are used to change the values of the private variables
    public void setTitle(String title){
        this.title = title;
    }
    public void setItem(int itemID){
        this.itemID = itemID;
    }
    public void setIsCheckedOut(boolean isCheckedOut){
        this.isCheckedOut = isCheckedOut;
    }
    
    abstract void displayinfo();
    
}
public class book extends libraryitem {
    private String author;

    public book(String title, int itemID, String author) {
        super(title, itemID, false);
        this.author = author;
    }

    @Override
    void displayinfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Item ID: " + getItemID());
        System.out.println("Author: " + author);
    }
}

public class DVD extends libraryitem {
    private String director;

    public DVD(String title, int itemID, String director) {
        super(title, itemID, false);
        this.director = director;
    }

    public String getDirector(){
        return director;
    }
    



    @Override
    void displayinfo (){
        System.out.println("Title: " + getTitle());
        System.out.println("Item ID: " + getItemID());
        System.out.println("Director:" +getDirector() );
    }

}

interface Borrowable {
    public void checkout();
    public void returnitem();
}

public class librarymanager {
    public void manageLibraryItem(libraryitem item){
        item.displayinfo();
        if (item instanceof Borrowable){
            Borrowable borrowableItem = (Borrowable) item;
            borrowableItem.checkout();
            borrowableItem.returnitem();
        }
            
        //to ask the lecturer
        /*if (item instanceof Borrowable) {
                ((Borrowable) item).checkout();
        }
        /* */
    }
    
}
    
}