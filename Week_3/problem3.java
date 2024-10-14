class Pyramid{
    private int noofrows;
    public Pyramid(int value){
        noofrows=value;
    }
    public void print(){
        for(int i=noofrows;i>=1;i--){
            int k=i;
            while(k>0){
                System.out.print(i+ " ");
                k--;
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Pyramid p1=new Pyramid(5);
        //Pyramid p2=new Pyramid(3);
        p1.print();
        //p2.print();
    }
}