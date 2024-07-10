package glassgiver.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringWebApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringWebApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Application started");
        System.out.println("----------------------------------------------------------------------------------------");

        while(true){

            System.out.println("\n1. Show all available products");
            System.out.println("2. Add product to the cart");
            System.out.println("3. Remove product from the cart");
            System.out.println("4. Show cart");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(productRepository.getAll().stream()
                            .map(product -> product.getId() + ": " + product.getName() + ";")
                            .collect(Collectors.joining("\n")));

                    break;
                case 2:
                    System.out.println("\nEnter product ID to add:");
                    int addId = scanner.nextInt();
                    cart.addProduct(addId);
                    break;
                case 3:
                    System.out.println("\nEnter product ID to remove from the card:");
                    int removeId = scanner.nextInt();
                    cart.removeProduct(removeId);
                    break;
                case 4:
                    if(cart.getProducts().isEmpty()){
                        System.out.println("\nYour cart is empty.");
                    }
                    System.out.println(cart.showProd());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }

    }

}
