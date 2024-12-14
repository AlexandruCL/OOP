import java.time.DateTimeException;
import java.time.LocalDate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ex1 {
    public static void main(String[] args) {
        String path="D:\\An_2\\OOP\\Week_12\\ex1.csv";
        Set<Employee> employees = readCSV(path);

        System.out.println(employees);
    }

    public static Set<Employee> readCSV(String path) {
        Set<Employee> employees = new HashSet<>();

        try{
            List<String> lines = Files.readAllLines(Paths.get(path));

            for(String s : lines){
                try{
                  String[] line = s.split(",");
                  if(line.length != 5){
                      throw new InvalidDataFormatException("The lins is invalid: " + Arrays.toString(line) + ". It has " + line.length + " fields instead of 5." + "\n");
                  }
                  int id = checkInt(line[0].trim());

                  String name = line[1].trim();

                  int age = checkInt(line[2].trim());

                  String email = line[3].trim();

                  try{
                      LocalDate hireDate = LocalDate.parse(line[4].trim());
                      employees.add(new Employee(id, name, age, email, hireDate));
                  } catch (DateTimeParseException e){
                      throw new InvalidDateFormatException("Hire date is not in the correct format (yyyy-MM-dd)." + e.getMessage() + "\n");
                  }

                } catch (InvalidDataFormatException | DataTypeException | InvalidDateFormatException e) {
                    System.out.printf(e.getMessage());
                }
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return employees;
    }

    private static int checkInt(String s){
        try{
            return Integer.parseInt(s);
        } catch(NumberFormatException e){
            throw new DataTypeException("The field is invalid: " + e.getMessage() + "\n");
        }
    }
}

class Employee{
    private final int id;
    private final String name;
    private int age;
    private String email;
    private LocalDate hireDate;

    public Employee(int id, String name, int age, String email, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", hireDate=" + hireDate + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employee){
            Employee e = (Employee)obj;
            return this.id == e.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}

class DataTypeException extends RuntimeException{
    public DataTypeException(String message) {
        super(message);
    }
}

class InvalidDateFormatException extends Exception{
    public InvalidDateFormatException(String message) {
        super(message);
    }
}


