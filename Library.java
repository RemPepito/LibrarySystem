
interface LibraryItem {
    void borrowItem();
    void returnItem();
    boolean isBorrowed();
}


class Book implements LibraryItem {

    private String bookTitle;
    private String author;
    private boolean borrowStatus;

    public Book(String bookTile, String author, boolean borrowStatus){
        this.bookTitle = bookTile;
        this.author = author;
        this.borrowStatus = borrowStatus;
    }

    @Override
    public void borrowItem() {
        if(!borrowStatus){
            borrowStatus=true;
            //System.out.println("Book "+bookTitle+" is now borrowed");
        }else{
            System.out.println("Book "+ bookTitle+" is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if(borrowStatus){
            borrowStatus=false;
            System.out.println("Book "+bookTitle+" has been successfully returned.");
        }else{
            System.out.println("Book "+bookTitle+" is not yet borrowed.");
        }
    }

    @Override
    public String toString() {
        return "DVD - " + bookTitle + " directed by " + author;
    }

    @Override
    public boolean isBorrowed() {
        return borrowStatus;
    } 
}

class DVD implements LibraryItem{
    private String DVDTitle;
    private String director;
    private boolean borrowStatus;

    public DVD(String DVDTitle, String director, boolean borrowStatus){
        this.DVDTitle = DVDTitle;
        this.director = director;
        this.borrowStatus = borrowStatus;
    }

    @Override
    public void borrowItem() {
        if(!borrowStatus){
            borrowStatus=true;
            //System.out.println("Movie "+DVDTitle+" is is now borrowed.");
        }else{
            System.out.println("Movie "+ DVDTitle+" is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if(borrowStatus){
            borrowStatus=false;
            System.out.println("Movie "+DVDTitle+" has been successfully returned.");
        }else{
            System.out.println("Movie "+DVDTitle+" is not yet borrowed.");
        }
    }

    @Override
    public String toString() {
        return "DVD - " + DVDTitle + " directed by " + director;
    }

    @Override
    public boolean isBorrowed() {
        return borrowStatus;
    } 

}

abstract class LibraryUser{
    abstract void borrowItem(LibraryItem Item);
    abstract void returnItem(LibraryItem Item);
    abstract void printItemsBorrowed();
}

class Student extends LibraryUser{
    private String studentName;
    private int idNumber;
    private LibraryItem[] borrowedItems = new LibraryItem[5];
    private int borrowedItemCount=0;

    public Student(String studentName, int idNumber){
        this.studentName = studentName;
        this.idNumber = idNumber;
    }
    public void borrowItem(LibraryItem item){
        if (borrowedItemCount < 5) {
            item.borrowItem();
            borrowedItems[borrowedItemCount++] = item;
        } else {
            System.out.println("Cannot borrow more items. Limit reached.");
        }

    }

    public void returnItem(LibraryItem item) {
        item.returnItem();
        for (int i = 0; i < borrowedItemCount; i++) {
            if (borrowedItems[i] == item) {
                borrowedItems[i] = borrowedItems[borrowedItemCount - 1];
                borrowedItems[borrowedItemCount - 1] = null;
                borrowedItemCount--;
                break;
            }
        }
    }

    
    public void printItemsBorrowed(){
        System.out.println("Student " + studentName + " has borrowed:");
        for (int i = 0; i < borrowedItemCount; i++) {
            System.out.println("- " + borrowedItems[i]);
        }

    }
}

class Teacher extends LibraryUser{
    private String teacherName;
    private int idNumber;
    private LibraryItem[] borrowedItems = new LibraryItem[5];
    private int borrowedItemCount=0;

    public Teacher(String teacherName, int idNumber){
        this.teacherName = teacherName;
        this.idNumber = idNumber;
    }

    public void borrowItem(LibraryItem item){
        if (borrowedItemCount < 5) {
            item.borrowItem();
            borrowedItems[borrowedItemCount++] = item;
        } else {
            System.out.println("Cannot borrow more items. Limit reached.");
        }

    }

    public void returnItem(LibraryItem item) {
        item.returnItem();
        for (int i = 0; i < borrowedItemCount; i++) {
            if (borrowedItems[i] == item) {
                borrowedItems[i] = borrowedItems[borrowedItemCount - 1];
                borrowedItems[borrowedItemCount - 1] = null;
                borrowedItemCount--;
                break;
            }
        }


    }
    public String getTeacherName() {
        return teacherName;
    }

    
    public void printItemsBorrowed(){
        System.out.println("Teacher " + teacherName + " has borrowed:");
        for (int i = 0; i < borrowedItemCount; i++) {
            System.out.println("- " + borrowedItems[i]);
        }

    }
} 


class Library{
    public static void main(String[] args) {
       Book book1 = new Book("Kimii No Nyawi", "Fushiguro Asim", false);
       Book book2 = new Book("Black Lavender", "Sakura Mishubishi", false);
       DVD dvd1 = new DVD("Transpattern", "Micheal Ocean", false);
       DVD dvd2 = new DVD("Mission Possible", "Tony Stonks", false);
       Student student1 = new Student("Remwell Pepito", 01);
       Student student2 = new Student("Calpito Welkins", 02);
       Teacher teacher1 = new Teacher("Welmer Sumahod", 101);
       Teacher teacher2 = new Teacher("Shelly Simp", 102);

        student1.borrowItem(dvd1);
        student2.borrowItem(dvd2);
        teacher1.borrowItem(book1);
        teacher1.borrowItem(book2);

        System.out.println("======================Library System======================");
        student1.printItemsBorrowed();
        System.out.println("==========================================================");
        student2.printItemsBorrowed();
        System.out.println("==========================================================");
        teacher1.printItemsBorrowed();
        System.out.println("==========================================================");
        teacher2.printItemsBorrowed();
    }
}