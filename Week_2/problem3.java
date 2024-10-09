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
        c1.print();
        c2.print();
        c1.modulus();
        c2.modulus();
        Complex sum=c1.add(c2);
        System.out.print("This is the sum of the numbers: ");sum.print();
        System.out.println("This is how many numbers were printed: "+Complex.countMethod());
    }
}