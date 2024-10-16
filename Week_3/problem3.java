class Pyramid{
    private int noofrows;
    public Pyramid(int value){
        noofrows=value;
    }
    public String  toString(){
        String rez="";
        for(int i=noofrows;i>=1;i--){
            int k=i;
            while(k>0){
                rez=rez + i;
                rez+=" ";
                k--;
            }
            rez+="\n";
        }
        return rez;
    }
    public static void main(String[] args){
        Pyramid p1=new Pyramid(5);
        System.out.println(p1);
    }
}