
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Person{

    private final String name;
    private int age;
    private final int id;
    private String email;

    public Person(int id,String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }

    @Override
    public String toString(){
        return "Name: " + name + " Age: " + age + " ID: " + id + " Email: " + email;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Person){
            Person p = (Person)o;
            return this.id == p.id;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}


public class Main {

    public static void main(String[] args) {

        String path = "D:\\An_2\\OOP\\Week_11\\assignment9PersonList.csv";
        Set<Person> people = readCSV(path);

        System.out.println(people);

    }

    public static Set<Person> readCSV(String filename) {

        Set<Person> people = new HashSet<>();

        try{
            List<String> lines = Files.readAllLines(Paths.get(filename));

            for(String s : lines) {
                try{
                    String[] line = s.split(",");
                    if(line.length != 4) {
                        throw  new InvalidDataFormatException( "The line is invalid: " + Arrays.toString(line) + ". It has " + line.length + " fields instead of 4.");
                    }

                    //trying to extract the id
                    //making sure that the string from the csv table is a number using the custom parseInt method
                    int id = parseInt(line[0].trim());

                    //extracting the name
                    String name = line[1].trim();

                    //doing the same for age as I did for the id
                    int age = parseInt(line[2].trim());

                    //finally, extracting the email
                    String email = line[3].trim();

                    //adding a new person with the extracted fields
                    people.add(new Person(id,name,age,email));

                }catch (InvalidDataFormatException | DataTypeException e){ //possible exceptions to catch from this block (line75)
                    // data type exception will be caught this time in order for the program not to crash when such an exception is thrown
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) { //this catches the exception caused by input file (checked exception)
            System.out.println(e.getMessage());
        }
        return people;
    }

    //I made this method in order to not agglomerate my code
    //basically, by having this I don't have to throw exceptions when I try to extract id and age from the file
    private static int parseInt(String s) {

        try{
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new DataTypeException("Invalid Data type found with cause: " + e.getMessage(), e);
        }
    }
}


class DataTypeException extends RuntimeException{

    public DataTypeException(String message, Throwable cause) {

        super(message, cause);
    }
}

class InvalidDataFormatException extends Exception{
    public InvalidDataFormatException(String message){

        super(message);
    }
}
