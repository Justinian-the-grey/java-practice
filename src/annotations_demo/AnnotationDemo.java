package annotations_demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationDemo {

    public static void main(String[] args) {

        String[] productsArray = {"Keyboard", "mouse", "screen"};

        Customer customer = new Customer(
                "Tony",
                "tony23@examplemail.com",
                43,
                Arrays.asList(productsArray));

        if (customer.getClass().isAnnotationPresent(VeryImportantClass.class))
            System.out.println("Customer is important ");

        for (Method method : customer.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(VeryImportantMethod.class)) {
                System.out.println(method.getName() + " is very important");
                try {
                    VeryImportantMethod importantMethod = method.getAnnotation(VeryImportantMethod.class);
                    for (int i = 0; i < importantMethod.times(); i++) {
                        method.invoke(customer);
                    }
                } catch (InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        Arrays.asList(customer.getClass().getDeclaredFields()).forEach(field -> {
            if (field.isAnnotationPresent(VeryImportantString.class)) {
                try {
                    System.out.println(field.getName() + " is very important and its value is: "
                            + field.get(customer));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
