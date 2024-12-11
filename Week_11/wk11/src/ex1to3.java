public class ex1to3 {
    public static void main(String[] args) {
//        for (int i=0; i<4; i++) {
//            try {
//                if(i==0) throw new L1();
//                else throw new L2();                  // Will print L1 L2 L2 L2 on different lines because the loop is outside try catch
//            }
//            catch (Exception e) {
//                System.out.println(e);
//            }
//        }

//        try {
//            for(int i = 0; i < 100; i++) {
//                throw new Exception("FOR " + i);
//            }                                         // Will print only FOR 0 because the for is inside the try catch and it will stop at first exception
//        }
//        catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
        Operation.performDivision(20,0);
    }
}

class Operation {
    public static void performDivision(int number, int divisor)
    {
        int result = 0;
        try{
            result = number / divisor;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("The result of the division is " + result);
    }
}

class L1 extends Exception {
    public String toString() { return "L1"; }}
class L2 extends Exception {
    public String toString() { return "L2"; }}