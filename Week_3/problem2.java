class Square{
    private int side;
    public Square(){
        side=15;
    }
    public Square(int value){
        side=value;
    }
    public String toString(){
        return ("side: " + side + "area " + side*side);
    }
    public static void main(String[] args){
        Square s1=new Square();
        Square s2=new Square(10);
        System.out.println(s1);
        System.out.println(s2);
    }
}