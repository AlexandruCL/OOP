class problem1{
    private int capacity;
    private problem1(int c){
        System.out.println("This is a private constructor");
        capacity=c;
    }
    public static void main(String[] args){
        problem1 obj=new problem1(10);
        System.out.println("Capacity: "+obj.capacity);
    }
}

// class pb1{
//     public static void main(String[] args){
//         problem1 obj=new problem1(10);
//         System.out.println("Capacity: "+obj.capacity);
//     }
// }

//If the main is in the same class with the private constructor, it will work.
//If the main is in another class as the private constructor, it will give us an error.


//Problem 2

// Engine e1, e2;
// e1 = new Engine(5);
// e2 = e1;
// e2.setCapacity(10);
// e1.print();
// class Engine {
//  private int capacity;
//  public Engine(int c) {
//  capacity = c;
//  }
//  public void setCapacity(int c) {
//  capacity = c;
//  }
//  public void print() {
//  System.out.println(“My capacity is ” + capacity);
//  }
// }


//Problem 2 will have the output 10 because e2 is a reference to e1. So, when we change the capacity of e2, it will also change the capacity of e1.