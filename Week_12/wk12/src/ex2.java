import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ex2 {
    public static void main(String[] args) {
        String path = "D:\\An_2\\OOP\\Week_12\\ex2.csv";
        Set<Product> products = readCSV(path);

        System.out.println(products);
    }

    public static Set<Product> readCSV(String path) {
        Set<Product> products = new HashSet<>();

        try{
            List<String> lines = Files.readAllLines(Paths.get(path));

            for(String s : lines){
                try {
                    String[] line = s.split(",");
                    if (line.length > 4 || line.length < 3) {
                        throw new InvalidDataFormatException2("The line is invalid: " + Arrays.toString(line) + ". It has " + line.length + " fields.");
                    }

                    int id;
                    try {
                        id = Integer.parseInt(line[0]);
                    } catch (NumberFormatException e) {
                        throw new InvalidDataFormatException2("The integer value is invalid: " + e.getMessage());
                    }

                    String name = line[1].trim();

                    double price = checkparse(line[2].trim());

                    double discount;

                    if(line.length == 4){
                        discount = checkparse(line[3].trim());
                        products.add(new DiscountedProduct(id, name, price,discount));
                    } else
                        products.add(new Product(id, name, price));


                } catch(InvalidDataFormatException2 | DataTypeException2 e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e){
            System.out.printf(e.getMessage());
        }
        return products;
    }

    private static double checkparse(String s){
        try{
            return Double.parseDouble(s);
        } catch(NumberFormatException e){
            throw new DataTypeException2("The integer value is invalid: " + s);
        }
    }
}

class Product{
    protected final int id;
    protected final String name;
    protected double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Product){
            Product p = (Product)obj;
            return p.getId() == this.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product [ID=" + id + ", Name=" + name + ", Price=" + price + "]";
    }

}

class DiscountedProduct extends Product{
    private double discount;
    public DiscountedProduct(int id, String name, double price, double discount) {
        super(id, name, price);
        this.discount = discount;
    }

    private double calculatePrice() {
        return price - (price * discount / 100);
    }

    @Override
    public String toString() {
       return "Discounted Product [ID=" + id + ", Name=" + name +
                ", Original Price=" + price + ", Discount=" + discount + "%" +
                ", Final Price=" + calculatePrice() + "]";
    }
}

class InvalidDataFormatException2 extends Exception {
    public InvalidDataFormatException2(String message) {
        super(message);
    }
}

class DataTypeException2 extends RuntimeException {
    public DataTypeException2(String message) {
        super(message);
    }
}