class Book{
    private int nopages;
    public Book(int value){
        nopages=value;
    }
    boolean compare(Book other){
        return (this.nopages==other.nopages);
    }
    public String toString(){
        return "Number of pages: "+nopages;
    }
}
class Set{
    private int maxno;
    private Book[] books;
    private int currentno;
    public Set(int maxno){
        this.maxno=maxno;
        this.books=new Book[maxno];
        this.currentno=0;
    }
    public boolean addBook(Book b){
        if(currentno>=maxno){
            return false;
        }
        for(int i=0;i<currentno;i++){
            if(books[i].compare(b)){
                return false;
            }
        }
        books[currentno]=b;
        currentno++;
        return true;
    }
    public Set union(Set other){
        Set result=new Set(this.maxno+other.maxno);
        for(int i=0;i<this.currentno;i++){
            result.addBook(this.books[i]);
        }
        for(int i=0;i<other.currentno;i++){
            result.addBook(other.books[i]);
        }
        return result;
    }
    public void print(){
        for(int i=0;i<currentno;i++){
            int book_no=i+1;
            System.out.println("Book "+book_no+": "+books[i]+ " pages");
        }
    }
}
class SetClient{
    public static void main(String[] args){
        Book b1=new Book(100);
        Book b2=new Book(200);
        Book b3=new Book(100);
        Book b4=new Book(300);
        Set s1=new Set(3);
        Set s2=new Set(2);
        s1.addBook(b1);
        s1.addBook(b2);
        s1.addBook(b3);
        s2.addBook(b2);
        s2.addBook(b4);
        Set s3=s1.union(s2);
        s3.print();
    }
}