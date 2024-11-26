public class ex2_test {
    public static void main(String[] args) {
            // Create library
            Library library = new Library();

            // Create some books, magazines, and journals
            LibraryItem book1 = new Book("Java Programming", "John Doe", 2020);
            LibraryItem book2 = new Book("Learning Algorithms", "Jane Smith", 2021);
            LibraryItem magazine1 = new Magazine("Tech World", 5, "January");
            LibraryItem journal1 = new Journal("Research on AI", 2, 2022);

            // Add items to library
            library.addItem(book1);
            library.addItem(book2);
            library.addItem(magazine1);
            library.addItem(journal1);
            library.addItem(book1);

            // Get details of all items in the library
            System.out.println("Library Items Details: ");
            System.out.println(library.getAllItemDetails());

    }
}
/*
Problem 1: Library Management System (Inheritance, Polymorphism, and Arrays)
Problem:

You are tasked with implementing a simple library management system where you need to handle different types of items in a library, such as books, magazines, and journals. The system should manage a collection of library items and demonstrate the advantages of inheritance and polymorphism.

Create an interface LibraryItem that contains the method String getDetails().

Implement the LibraryItem interface with three classes:

Book class with attributes title, author, and yearPublished. Implement the getDetails() method to return a string representation of the book's details.
Magazine class with attributes title, issueNumber, and monthPublished. Implement the getDetails() method to return a string representation of the magazine's details.
Journal class with attributes title, volumeNumber, and yearPublished. Implement the getDetails() method to return a string representation of the journal's details.
Create a class Library that:

Contains an array libraryItems of type LibraryItem[] with a maximum capacity of 100.
Provides a method to add items to the library: public void addItem(LibraryItem item). If the library is full, print “Library is full”.
Provides a method public String getAllItemDetails() that concatenates the details of all items in the library and returns the result.
 */
interface LibraryItem{
    String getDetails();
}
class Book implements LibraryItem{
    String title;
    String author;
    int yearPublished;
    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Book)
        {
            Book other=(Book)o;
            return other.getDetails().equals(this.getDetails());
        }
        return false;
    }
    @Override
    public String getDetails() {
        return this.title+","+this.author+","+this.yearPublished;
    }
}
class Magazine implements LibraryItem{
    String title;
    int issueNumber;
    String monthPublished;
    public Magazine(String title, int issueNumber, String monthPublished) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.monthPublished = monthPublished;
    }
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Magazine)
        {
            Magazine other=(Magazine)o;
            return other.getDetails().equals(this.getDetails());
        }
        return false;
    }

    @Override
    public String getDetails() {
        return this.title+","+this.issueNumber+","+this.monthPublished;
    }
}
class Journal implements LibraryItem{
    String title;
    int volumeNumber;
    int yearPublished;
    public Journal(String title, int volumeNumber, int yearPublished) {
        this.title = title;
        this.volumeNumber = volumeNumber;
        this.yearPublished = yearPublished;
    }
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Journal)
        {
            Journal other=(Journal)o;
            return other.getDetails().equals(this.getDetails());
        }
        return false;
    }
    @Override
    public String getDetails() {
        return this.title+","+this.volumeNumber+","+this.yearPublished;
    }
}
/*
Contains an array libraryItems of type LibraryItem[] with a maximum capacity of 100.
Provides a method to add items to the library: public void addItem(LibraryItem item). If the library is full, print “Library is full”.
Provides a method public String getAllItemDetails() that concatenates the details of all items in the library and returns the result.
 */
class Library{
    LibraryItem[] libraryItems;
    int totalItems;
    public Library() {
        libraryItems = new LibraryItem[100];
        totalItems = 0;
    }
    public void addItem(LibraryItem item) {
        if(totalItems >= 100) {
            System.out.println("library is full");
            return;
        }
        for(LibraryItem i : libraryItems) {
            if(i!=null && i.equals(item)) {
                System.out.println("Item already exists");
                return;
            }
        }
        LibraryItem[] newItems = new LibraryItem[totalItems+1];
        for(int i=0;i<totalItems;i++) {
            newItems[i]=libraryItems[i];
        }
        newItems[totalItems]=item;
        libraryItems = newItems;
        totalItems++;
    }
    public String getAllItemDetails()
    {
        String result = "";
        for(int i=0;i<totalItems;i++) {
            LibraryItem item=libraryItems[i];
            //if book no paranthesis
            if(item instanceof Book) {
                result+=item.getDetails()+"\n";
            }
            else if(item instanceof Magazine) {
                //if magazine simple paranthesis
                result+="( "+item.getDetails()+" )"+"\n";
            }
            else {
                //if journal 2nd paranthesis type
                result+="[ "+item.getDetails()+" ]"+"\n";
            }
        }
        return result;
    }
}