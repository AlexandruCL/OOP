class Square{
    private int side;
    public Square(){
        side=15;
    }
    public Square(int value){
        side=value;
    }
    public void myprint(){
        System.out.println("The side of the square is: "+side+" Area: "+side*side);
    }
    public static void main(String[] args){
        Square s1=new Square();
        Square s2=new Square(10);
        s1.myprint();
        s2.myprint();
    }
}