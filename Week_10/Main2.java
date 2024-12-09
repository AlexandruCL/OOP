import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {

        Employee e1= new full_time("Alex",1,2000);
        Employee e2= new full_time("Bob",2,1800);
        Employee e3= new Freelancers("John",3,200,15);
        Employee e4=new Freelancers("Jane",4,200,15);

        Organization org1=new Organization();
        org1.addEmployee(e1);
        org1.addEmployee(e2);
        org1.addEmployee(e3);
        org1.addEmployee(e1);
        org1.removeEmployee(e1);
        org1.removeEmployee(e4);
        org1.addEmployee(e1);


        System.out.println("\n"+"Company members:"+"\n"+org1.print());
        Condition c1=new checkName("Alex");
        Condition c2=new checkName("Bob");
        Condition c3=new checkName("Bibanu");
        Condition c4=new monthly_earnings(e1.calculateEarnings());

        System.out.println("Is alex in the organization? "+org1.hasMember(c1));
        System.out.println("Is bob in the organization? "+org1.hasMember(c2));
        System.out.println("Has bob a fixed salary of 2000? "+org1.hasMember(c4));
        System.out.println("Is Bibanu in the organization? "+org1.hasMember(c3));

    }
}
abstract class Employee{
    String name;
    int unique_id;
    public Employee(String name, int unique_id){
        this.name = name;
        this.unique_id = unique_id;
    }
    public String getName(){
        return name;
    }
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Employee){
            Employee other=(Employee) o;
            return other.getName().equals(this.getName());
        }
        return false;
    }
    public abstract double calculateEarnings();
}
class full_time extends Employee{
    double fixed_month_salary;
    public full_time(String name,int unique_id, double fixed_month_salary){
        super(name, unique_id);
        this.fixed_month_salary=fixed_month_salary;
    }
    @Override
    public double calculateEarnings() {
        return this.fixed_month_salary;
    }
    @Override
    public String toString() {
        return "Name: "+this.name+", UniqueID: "+this.unique_id+" Fixed_Salary: "+this.fixed_month_salary;
    }
}
class Freelancers extends Employee{
    int no_of_h_worked;
    int rate;
    public Freelancers(String name, int unique_id, int no_of_h_worked, int rate){
        super(name, unique_id);
        this.no_of_h_worked=no_of_h_worked;
        this.rate=rate;
    }
    @Override
    public double calculateEarnings() {
        return this.no_of_h_worked*rate;
    }
    @Override
    public String toString() {
        return "name: "+this.name+" id:"+this.unique_id+" rate: "+this.rate+" no_of_h_worked: "+this.no_of_h_worked;
    }
}
interface Condition{
    public boolean test(Employee employee);
}
class checkName implements Condition{

    String name;
    public checkName(String name){
        this.name=name;
    }
    @Override
    public boolean test(Employee employee) {
        if(name.equals(employee.getName())){
            return true;
        }
        return false;
    }
}
class monthly_earnings implements Condition{
    double salary;
    public monthly_earnings(double salary){
        this.salary=2000;
    }

    @Override
    public boolean test(Employee employee) {
        if(employee.calculateEarnings()==this.salary){
            return true;
        }
        return false;
    }
}
class Organization{
    ArrayList<Employee> Employees;
    public Organization(){
        Employees=new ArrayList<>();
    }
    void addEmployee(Employee employee){
        for(Employee emp:Employees){
            if(emp.equals(employee)){
                System.out.println("Employee already exists");
                return;
            }
        }
        Employees.add(employee);
        System.out.println("Employee added");
    }

    void removeEmployee(Employee employee){
        int ok=0;
        for(Employee emp:Employees){
            if(emp.getName().equals(employee.getName())){
                Employees.remove(emp);
                System.out.println("Employee removed");
                ok=1;
                break;
            }
        }
        if(ok==0){
            System.out.println("Employee not found");
        }
    }
    public String print(){
        String result="";
        for(Employee emp:Employees) {
            result+="Employee with id:" + emp.unique_id + " name:" + emp.name + "Total earnings:" + emp.calculateEarnings();
            result+="\n";
        }
        return result;
    }

    public boolean hasMember(Condition condition) {
        for(Employee emp:Employees){
            if(condition.test(emp)){
                return true;
            }
        }
        return false;
    }
}