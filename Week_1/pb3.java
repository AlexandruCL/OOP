class pb3{
    public static void main(String[] args){
        int i=1;
        int sum=0;
        for(i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
            }
            else
                sum+=i;
        }
        System.out.println("Sum of odd numbers from 1 to 100 is: "+sum);
    }
}