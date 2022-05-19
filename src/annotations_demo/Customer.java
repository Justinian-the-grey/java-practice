package annotations_demo;

import java.util.List;

@VeryImportantClass
public class Customer {

    @VeryImportantString
    String name;
    String email;
    Integer age;
    List<String> products;

    public Customer(String name, String email, Integer age, List<String> products) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    @VeryImportantMethod(times = 3)
    public void printCustomer() {
        System.out.println("Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", products=" + products +
                '}');
    }
}
