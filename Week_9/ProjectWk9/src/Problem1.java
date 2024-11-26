public class Problem1 {
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
        System.out.println(library.getAllDetails());
    }
}

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
    public String getDetails(){
        return title + " | " + author + " | " + yearPublished;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Book){
            Book other = (Book) o;
            return other.getDetails().equals(this.getDetails());
        }
        return false;
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
    public String getDetails(){
        return title + " | " + issueNumber + " | " + monthPublished;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Magazine){
            Magazine other = (Magazine) o;
            return other.getDetails().equals(this.getDetails());
        }
        return false;
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
    public String getDetails(){
        return title + " | " + volumeNumber + " | " + yearPublished;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Journal){
            Journal other = (Journal) o;
            return other.getDetails().equals(this.getDetails());
        }
        return false;
    }
}

class Library{
    LibraryItem[]  libraryItems;
    int totalItems;
    public Library() {
        libraryItems = new LibraryItem[100];
        totalItems = 0;
    }

    public void addItem(LibraryItem item){
        if(totalItems >= 100)
            System.out.println("Library is full");

        for(LibraryItem i : libraryItems) {
            if (i != null && i.equals(item)) {
                System.out.println("Item already added");
                return;
            }
        }
            LibraryItem[] temp = new LibraryItem[totalItems + 1];
            System.arraycopy(libraryItems, 0, temp, 0, totalItems);
            temp[totalItems] = item;
            libraryItems = temp;
            totalItems++;
    }
    public String getAllDetails(){
        String result = "";
        for(LibraryItem i : libraryItems) {
            if(i instanceof Book){
                result += i.getDetails();
                result += "\n";
            }
            else if(i instanceof Magazine){
                result +="( " + i.getDetails() + " )";
                result += "\n";
            }
            else if(i instanceof Journal){
                result +="[ " + i.getDetails() + " ]";
                result += "\n";
            }
        }
        return result;
    }
}
































