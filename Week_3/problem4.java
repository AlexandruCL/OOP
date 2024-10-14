class Sum{
    public static int sum2(int a,int b){
        return a+b;
    }
    public static int sum3(int a,int b,int c){
        return sum2(a,b)+c;
    }
    public static int sum4(int a,int b, int c, int d){
        return sum3(a, b, c)+d;
    }
    public static void main(String[] args){
        int sum1=Sum.sum2(3,4);
        int sum2=Sum.sum3(3,4,5);
        int sum3=Sum.sum4(3,4,5,6);
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }
}