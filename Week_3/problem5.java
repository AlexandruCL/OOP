class Book{
    private int numberOf_pages;
    private String title;
    private String author;
    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
    }


    public String toString(){
        return "title: '" + this.title + "', author: " + this.author;
    }
}

class Set{
    private int max_num;
    private Book[] books;
    private int current_num;

    public Set(int max_num){
        this.max_num = max_num;
        this.books = new Book[max_num];
        this.current_num = 0;
    }

    public boolean addBook(Book b){
        if(current_num >= max_num){
            return false;
        }

        for(int i=0; i<current_num; i++){
            if(books[i].equals(b)) return false;
        }

        books[current_num] = b;
        current_num++;
        return true;
    }

    public Set union(Set other){
        Set unionSet = new Set(this.max_num + other.max_num);

        for(int i=0; i<this.current_num; i++){
            unionSet.addBook(this.books[i]);
        }

        for(int i=0; i<other.current_num; i++){
            unionSet.addBook(other.books[i]);
        }
        return unionSet;
    }

    public void print(){
        for(int i=0; i<this.current_num; i++){
            int book_no = i+1;
            System.out.println(books[i]);
        }
    }


}

class Client{
    public static void main(String[] args){
    Set set1 = new Set(2);
    Set set2 = new Set(3);
    Book b1 = new Book("Ion", "Liviu Rebreanu");
    Book b2 = new Book("Moara cu noroc", "Ioan Slavici");
    Book b3 = new Book("Ion", "Mihail Sadoveanu");
    Book b4 = new Book("Enigma Otiliei", "George Calinescu"); 
    Book b5 = new Book("Ultima noapte de dragoste, intaia noapte de razboi", "Camil Petrescu");
    Book b6 = b5;

    System.out.println("Adding book1: " + set1.addBook(b1));
    System.out.println("Adding book2: " + set1.addBook(b2));
    System.out.println("Adding book3: " + set1.addBook(b3));
    System.out.println("Adding book3: " + set2.addBook(b4));
    System.out.println("Adding book5: " + set2.addBook(b5));
    System.out.println("Adding book6: " + set2.addBook(b6));

    Set unionSet = set1.union(set2);
    unionSet.print();
    

    }
    
    
}