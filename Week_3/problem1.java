class Book {
    private int nopages;

    public Book(int value) {
        this.nopages = value;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Book) {
            Book otherBook = (Book) other;
            return this.nopages == otherBook.nopages; 
        }
        return false; 
    }

    public static void main(String[] args) {
        Book b1 = new Book(100);
        Book b2 = new Book(200);
        Book b3 = new Book(100);

        System.out.println("Are the first and second books the same? " + b1.equals(b2));
        System.out.println("Are the first and third books the same? " + b1.equals(b3));
    }
}
