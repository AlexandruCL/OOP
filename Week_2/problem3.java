class Complex{
    private double re,im;
    public static int count=0;
    public Complex(double re,double im){
        this.re=re;
        this.im=im;
    }
    public void modulus(){
        System.out.println("This is the modulus: "+Math.sqrt(re*re+im*im));
    }
    public void print(){
        System.out.println(re+"i*"+im);
        count++;
    }
    public static int countMethod(){
        return count;
    }
    public Complex add(Complex other){
        return new Complex(this.re+other.re,this.im+other.im);
    }
}

class ClientComplex{
    public static void main(String[] args){
        Complex c1=new Complex(3,4);
        Complex c2=new Complex(-8,10);
        Complex c3=new Complex(5,6);
        c1.print();
        c2.print();
        c3.print();
        c1.modulus();
        c2.modulus( );
        c3.modulus();
        Complex sum12=c1.add(c2);
        Complex sum13=c1.add(c3);
        Complex sum23=c2.add(c3);
        Complex sumall=sum12.add(c3);
        System.out.print("This is the sum of the first and second nr: ");sum12.print();
        System.out.print("This is the sum of the first and last nr: ");sum13.print();
        System.out.print("This is the sum of the second and third nr: ");sum23.print();
        System.out.print("This is the sum of all the numbers: ");sumall.print();
        System.out.println("This is how many numbers were printed: "+Complex.countMethod());
    }
}