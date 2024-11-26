public class ex3_test {
    public static void main(String[] args) {
        // Create department
        Department department = new Department();

        // Create employees
        Employee manager = new Manager("Alice", 60000, "HR", 5000);
        Employee staff1 = new Staff("Bob", 40000, "HR");
        Employee staff2 = new Staff("Charlie", 45000, "HR");

        // Add employees to department
        department.addEmployee(manager);
        department.addEmployee(staff1);
        department.addEmployee(staff2);
        department.addEmployee(staff2);

        // Get total salary of all employees in the department
        System.out.println("Total Salary of Department: $" + department.getTotalSalary());

        // Get salary of individual employees
        System.out.println("manager salary is: "+manager.getSalary());
        System.out.println("Staff salary is: "+staff1.getSalary());
    }
}
/*Problem 2: Employee and Department System (Inheritance and Polymorphism)
Problem:

You are tasked with modeling employees in an organization and managing their departments. The system will demonstrate the use of inheritance and polymorphism.

Create an abstract class Employee with the following attributes and methods:

String name, double salary, and String department.
A constructor to set the name, salary, and department.
An abstract method public double getSalary() to return the salary of the employee (which may be adjusted for certain employee types).
Create two classes that inherit from Employee:

Manager class with an additional attribute bonus and a method public double getSalary() that calculates the salary as the base salary plus the bonus.
Staff class with no additional attributes, but override getSalary() to return the base salary without any modification.
Create a class Department that:

Contains an array employees of type Employee[] with a maximum capacity of 50.
Provides a method to add an employee: public void addEmployee(Employee employee). If the department is full, print “Department is full”.
Provides a method public double getTotalSalary() that calculates and returns the total salary of all employees in the department.
 */
abstract class Employee{
    String name;
    double salary;
    String departament;
    public Employee(String name,double salary,String departament) {
        this.name = name;
        this.salary = salary;
        this.departament = departament;
    }
    public double getSalary()
    {
        return this.salary;
    }
    public String getDetails()
    {
        return this.name+" "+this.salary+" "+this.departament;
    }
    public boolean equals(Object o)
    {
        if(o instanceof Employee)
        {
            Employee other = (Employee)o;
            return other.getDetails().equals(this.getDetails());
        }
        return false;
    }
}
class Manager extends Employee{

    double bonus;
    public Manager(String name, double salary, String departament,double bonus) {
        super(name, salary, departament);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary()+bonus;
    }
}
class Staff extends Employee{
    public Staff(String name, double salary, String departament) {
        super(name,salary,departament);
    }
    @Override
    public double getSalary() {
        return super.getSalary();
    }
}
/*Create a class Department that:

Contains an array employees of type Employee[] with a maximum capacity of 50.
Provides a method to add an employee: public void addEmployee(Employee employee). If the department is full, print “Department is full”.
Provides a method public double getTotalSalary() that calculates and returns the total salary of all employees in the department.

 */
class Department
{
    Employee[] employees;
    int noOfEmployees;
    public Department(){
        employees = new Employee[51];
        noOfEmployees = 0;
    }
    public void addEmployee(Employee employee)
    {
        if(noOfEmployees >=50)
        {
            System.out.println("Departament is full");
            return;
        }
        for(Employee e:employees)
        {
            if(e!=null && e.getDetails().equals(employee.getDetails()))
            {
                System.out.println("employee already exists");
                return;
            }
        }
        Employee[] new_employees = new Employee[noOfEmployees+1];
        for(int i=0;i<noOfEmployees;i++)
        {
            new_employees[i]=employees[i];
        }
        new_employees[noOfEmployees]=employee;
        employees = new_employees;
        noOfEmployees++;
    }
    public double getTotalSalary()
    {
        double total_salaries = 0;
        for(Employee e:employees)
        {
            total_salaries +=e.getSalary();
        }
        return total_salaries;
    }
}