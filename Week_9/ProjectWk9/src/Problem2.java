public class Problem2 {
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
        System.out.println("Total Staff Salary: $" + department.getTotalStaffSalary());

        // Get salary of individual employees
        System.out.println("manager salary is: "+manager.getSalary());
        System.out.println("Staff salary is: "+staff1.getSalary());
    }
}

abstract class Employee {
    private String name;
    private double salary;
    private String department;

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    public double getSalary() {
        return this.salary;
    }
    public String getDetails() {
        return this.name + " " + this.department + " " + this.salary;
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof  Employee){
            Employee other = (Employee)o;
            return other.getDetails().equals(this.getDetails());
        }
        return false;
    }
}

class Manager extends Employee {
    private int bonus;
    public Manager(String name, double salary, String department, int bonus) {
        super(name, salary, department);
        this.bonus = bonus;
    }
    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }
}
class Staff extends Employee {
    public Staff(String name, double salary, String department){
        super(name, salary, department);
    }
    @Override
    public double getSalary() {
        return super.getSalary();
    }
}

class Department{
    Employee[] employees;
    int noofEmployees;
    public Department() {
        employees = new Employee[50];
        noofEmployees = 0;
    }

    public void addEmployee(Employee employee) {
        if(noofEmployees >= 50){
            System.out.println("Department is full");
            return;
        }

        for(Employee e : employees){
            if(e!= null && e.getDetails().equals(employee.getDetails())) {
                System.out.println("Emploee already exists");
                return;
            }
        }
        Employee[] temp = new Employee[noofEmployees+1];
        System.arraycopy(employees, 0, temp, 0, noofEmployees);
        temp[noofEmployees] = employee;
        employees = temp;
        noofEmployees++;
    }

    public double getTotalSalary() {
        double totalSalary = 0;
        for(Employee e : employees){
            totalSalary += e.getSalary();
        }
        return totalSalary;
    }
    public double getTotalStaffSalary(){
        double totalSalary = 0;
        for(Employee e : employees){
            if(e instanceof Staff){
                totalSalary += e.getSalary();
            }
        }
        return totalSalary;
    }
}