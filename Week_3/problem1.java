class Book{
    private int nopages;
    public Book(int value){
        nopages=value;
    }
    boolean compare(Book other){
        return (this.nopages==other.nopages);
    }
    public static void main(String[] args){
        Book b1=new Book(100);
        Book b2=new Book(200);
        Book b3=new Book(100);
        System.out.println("Are the first and second book the same? "+b1.compare(b2));
        System.out.println("Are the first and third book the same? "+b1.compare(b3));
    }
}