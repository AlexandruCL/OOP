class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book other = (Book) obj;
            return this.title.equals(other.title) && this.author.equals(other.author);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Book: " + title + " by " + author;
    }
}
class Set {
    private Book[] books;
    private int size;
    private int capacity;

    public Set(int capacity) {
        this.capacity = capacity;
        this.books = new Book[capacity];
        this.size = 0;
    }

    public boolean addBook(Book book) {
        if (size >= capacity) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (books[i].equals(book)) {
                return false;
            }
        }

        books[size] = book;
        size++;
        return true;
    }

    public static Set union(Set set1, Set set2) {
        Set resultSet = new Set(set1.capacity + set2.capacity);

        for (int i = 0; i < set1.size; i++) {
            resultSet.addBook(set1.books[i]);
        }

        for (int i = 0; i < set2.size; i++) {
            resultSet.addBook(set2.books[i]);
        }

        return resultSet;
    }

    public void printSet() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
}
public class problem5 {
    public static void main(String[] args) {
        Set set1 = new Set(5);
        Set set2 = new Set(5);

        Book book1 = new Book("Baltagul", "Mihail Sadoveanu");
        Book book2 = new Book("Ion", "Liviu Rebreanu");
        Book book3 = new Book("Morometii", "Marin Preda");
        Book book4 = new Book("Enigma Otiliei", "George Călinescu");
        Book book5 = new Book("La Medeleni", "Ionel Teodoreanu");

        System.out.println(set1.addBook(book1));
        System.out.println(set1.addBook(book2));
        System.out.println(set1.addBook(book3));
        System.out.println(set1.addBook(book1));

        System.out.println(set2.addBook(book3));
        System.out.println(set2.addBook(book4));
        System.out.println(set2.addBook(book5));

        System.out.println("Set 1:");
        set1.printSet();
        
        System.out.println("Set 2:");
        set2.printSet();

        Set unionSet = Set.union(set1, set2);

        System.out.println("Union of Set 1 and Set 2:");
        unionSet.printSet();
    }
}
