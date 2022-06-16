package VTTPWorkshop;

import java.io.Console;
import java.util.LinkedList;

public class cart {

    public static void main(String[] args) {
        Console cons = System.console();
        boolean stop = false;
        System.out.println("Welcome to your shopping cart");
        LinkedList<String> shoppingCart = new LinkedList<String>();

        while (!stop) {
            //format user's input to lowercase and remove
            String input = cons.readLine("Enter something here>").toLowerCase().trim();
            String[] terms = input.split(" ");
            String cmd = terms[0];

            switch (cmd) {
                case "add":
                    for (int i = 1; i < terms.length; i++) {
                        boolean found = false;
                        for (int j = 0; j < shoppingCart.size(); j++) {
                            if (terms[i].equals(shoppingCart.get(j))) {
                                System.out.println("Item " + shoppingCart.get(j) + " already exist.");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            shoppingCart.add(terms[i]);
                            System.out.println(terms[i] + " has been added");
                        }
                    }
                    break;

                case "list":
                    if (shoppingCart.isEmpty()) {
                        System.out.println("Your cart is empty");
                    } else {
                        for (int i = 0; i < shoppingCart.size(); i++) {
                            System.out.println(i + 1 + ". " + shoppingCart.get(i));
                        }
                    }
                    break;

                case "delete":
                    if (terms.length<2){
                        System.out.println("Please provide a number to delete");
                    }
                    try{
                        int indexToDelete = Integer.parseInt(terms[1]);
                        if (indexToDelete > shoppingCart.size()) {
                            System.out.println("You cannot delete something that is not in your cart.");
                        } else {
                            String s = shoppingCart.remove(indexToDelete - 1);
                            System.out.println(s + " removed from cart");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Please only key a NUMBER to delete");
                    }
                    break;

                case "end":
                    stop = true;
                    System.out.println("Thank you for shopping with us.");
                    break;

                default:
                    System.out.println("Invalid command");
            }

        }

    }

}
