class Sum{
    public static int sum(int a,int b){
        return a+b;
    }
    public static int sum(int a,int b,int c){
        return sum(a,b)+c;
    }
    public static int sum(int a,int b, int c, int d){
        return sum(a, b, c)+d;
    }
    public static void main(String[] args){
        int sum1=Sum.sum(3,4);
        int sum2=Sum.sum(3,4,5);
        int sum3=Sum.sum(3,4,5,6);
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }
}