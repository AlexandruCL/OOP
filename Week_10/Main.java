import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        // Adding employees
        Employee e1 = new PermanentEmployee("Patric", 123, 1500);
        hourlyEmployee e2 = new hourlyEmployee("Alex", 456, 25);
        e2.set_workedHours(40);

        hourlyEmployee e3 = new hourlyEmployee("Ionut", 789, 50);
        e3.set_workedHours(20);

        company.addEmployee(e1);
        company.addEmployee(e2);
        company.addEmployee(e3);
        company.addEmployee(e1);

        System.out.println("\n" + company);

        Strategy nameStrategy = new MatchName("Patric");
        System.out.println("Is there an employee named Patric? " + company.isInCompany(nameStrategy));

        Strategy nameStrategy2 = new MatchName("Florin");
        System.out.println("Is there an employee named Florin? " + company.isInCompany(nameStrategy2));

        Strategy salaryStrategy = new MatchSalary();
        System.out.println("Is there an employee earning exactly $1000? " + company.isInCompany(salaryStrategy));
    }
}


abstract class Employee{

    protected final String name;
    protected final int pnc;
    protected double salary;

    public Employee(String name, int pnc){

        this.name = name;
        this.pnc = pnc;
    }

    public abstract double getSalary();

    @Override
    public boolean equals(Object o) {
        if(o instanceof Employee employee){
            return (this.name.equals(employee.name) && this.pnc == employee.pnc);
        }
        return false;
    }

}
class PermanentEmployee extends Employee{

    public PermanentEmployee(String name, int pnc, double salary){

        super(name , pnc);
        this.salary = salary;
    }


    @Override
    public double getSalary() {

        return salary;
    }

    @Override
    public String toString() {

        return "Name: " + this.name + "; personal numeric code: " + this.pnc + "; salary: " + this.getSalary();
    }

}

class hourlyEmployee extends Employee{

    private  int workedHours;
    private final int rate;

    public hourlyEmployee(String name, int pnc,  int rate){
        super(name, pnc);
        this.rate = rate;
        this.workedHours = 0;
    }

    public void set_workedHours(int hours){

        this.workedHours = hours;
    }

    @Override
    public double getSalary() {
        return workedHours * rate;
    }

    @Override
    public String toString() {

        return "Name: " + this.name + "; personal numeric code: " + this.pnc + "; salary: " + this.getSalary();
    }
}

interface Strategy{

     boolean isCondition(Employee employee);
}

class MatchName implements Strategy{

    private final String name;
    public MatchName(String name) {
        this.name = name;
    }

    @Override
    public boolean isCondition(Employee employee) {
        return employee.name.equalsIgnoreCase(name);
    }
}

class MatchSalary implements Strategy{

    @Override
    public boolean isCondition(Employee employee) {
        return employee.getSalary() == 1000.00;
    }
}

class Company{

    private final ArrayList<Employee> employees;

    public Company(){
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee e){

        for(Employee emp : employees){

            if(emp.equals(e)){
                System.out.println("Employee already added");
                return;
            }
        }
        employees.add(e);
        System.out.println("Employee added");

    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        for(Employee emp:employees){

            result.append(emp.toString()).append("\n");
        }
        return result.toString();
    }

    public boolean isInCompany(Strategy strategy){

            for(Employee emp:employees){

                if(strategy.isCondition(emp)){
                    return true;
                }
            }
            return false;
    }

}

