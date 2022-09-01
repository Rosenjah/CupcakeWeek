import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();
        List<Object> order = new ArrayList<>();

        if (placeOrder.equalsIgnoreCase("Y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu.");
            System.out.println("CUPCAKES:");
            int itemNumber = 0;

            for (int i = 0; i < cupcakeMenu.size(); i++) {
                itemNumber++;
                System.out.println(itemNumber);
                cupcakeMenu.get(i).type();
                System.out.println("\n");
                System.out.println("Price: ");
                System.out.println(cupcakeMenu.get(i).getPrice());
                System.out.println("\n");
            }

            System.out.println("DRINKS: ");
            for(int i = 0; i < drinkMenu.size(); i++) {
                itemNumber++;
                System.out.println(itemNumber);
                drinkMenu.get(i).type();
                System.out.println("\n");
                System.out.println("Price: ");
                System.out.println(drinkMenu.get(i).getPrice());
                System.out.println("\n");
            }

            boolean ordering = true;
            while ( ordering ) {
                System.out.println("What would you like to order? Please use the number associated with each item to order.");
                int orderChoice = input.nextInt();
                input.nextLine();

                if (orderChoice == 1) {
                    order.add(cupcakeMenu.get(0));
                    System.out.println("Item added to order");
                } else if (orderChoice == 2) {
                    order.add(cupcakeMenu.get(1));
                    System.out.println("Item added to order");
                } else if (orderChoice == 3) {
                    order.add(cupcakeMenu.get(2));
                    System.out.println("Item added to order");
                } else if (orderChoice == 4) {
                    order.add(cupcakeMenu.get(3));
                    System.out.println("Item added to order");
                } else if (orderChoice == 5) {
                    order.add(cupcakeMenu.get(4));
                    System.out.println("Item added to order");
                } else if (orderChoice == 6) {
                    order.add(cupcakeMenu.get(5));
                    System.out.println("Item added to order");
                } else {
                    System.out.println("Sorry, we don’t seem to have that on the menu.");
                }

                System.out.println("Would you like to continue ordering? (Y/N)");
                placeOrder = input.nextLine();

                if (!placeOrder.equalsIgnoreCase("Y")){
                    ordering = false;
                }

            }

        }
        else {
            System.out.println("Have a nice day then");
        }



        System.out.println(order.get(0));
        System.out.println(order.get(1));
        double subtotal = 0.0;
        for (int i = 2; i < order.size(); i++) {
            for (int j = 0; j < cupcakeMenu.size(); j++) {
                if (order.get(i).equals(cupcakeMenu.get(j))) {
                    cupcakeMenu.get(j).type();
                    System.out.println("Cupcake Price: " + cupcakeMenu.get(j).getPrice());
                    subtotal = subtotal + cupcakeMenu.get(j).getPrice();
                }
            }

//            for (int k = 0; k < drinkMenu.size(); k++) {
//                if (order.get(i).equals(drinkMenu.get(k))) {
//                    drinkMenu.get(k).type();
//                    System.out.println("Drink Price: " + drinkMenu.get(k).getPrice());
//                    subtotal = subtotal + drinkMenu.get(k).getPrice();
//                }
//            }
        }

        System.out.println("Subtotal: " + subtotal);
        new CreateFile();
        new WriteToFile(order);

    }
}

class CreateFile {
    public CreateFile() {
        try {
            File salesData = new File("salesData.txt");
            if(salesData.createNewFile()) {
                System.out.println("File created:");
            } else {
                System.out.println("File already exists");
            }

        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
}

class WriteToFile {
    public WriteToFile(List<Object> order) {
        try {
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);

            for (int i = 0; i < order.size(); i++){
                salesWriter.println(order.get(i));
            }
            salesWriter.close();

            System.out.println("Successfully wrote to the file");

        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
}
