package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import Helper.Utils;
import Model.Product;

public class Market {
    private static Scanner teclado = new Scanner(System.in);
    private static ArrayList<Product> products;
    private static Map<Product, Integer> Cart;

    public static void main(String[] args) {
        products = new ArrayList<Product>();
        Cart = new HashMap<Product, Integer>();
        Market.menu();
    }

    private static void menu() {
        System.out.println("===================================JAVA SHOP==========================================");
        System.out.println("========================   WELCOME, CLIENT ==================================");
        System.out.println("=============================================================================");

        System.out.println("=========================== SELECT A OPTION BELOW ============================");
        System.out.println("1 - Insert Product");
        System.out.println("2 - Show Products");
        System.out.println("3 - Buy Product");
        System.out.println("4 - View Cart");
        System.out.println("5 - Exit");

        int opt = 0;

        try {
            opt = Integer.parseInt(Market.teclado.nextLine());
        } catch (InputMismatchException e) {
            Market.menu();
        } catch (NumberFormatException f) {
            Market.menu();
        }

        switch (opt) {
            case 1:
                Market.Insert();
                break;
            case 2:
                Market.Show();
                break;
            case 3:
                Market.Buy();
                break;
            case 4:
                Market.View();
                break;
            case 5:
                System.out.println("Good Bye : )");
                Utils.pausar(2);
                System.exit(0);
            default:
                System.out.println("Invalid Option :(");
                Utils.pausar(2);
                Market.menu();
                break;
        }
    }

    private static void Insert() {
        System.out.println("=======Insert new Products=======");
        System.out.println("Inform the name: ");
        String nome = Market.teclado.nextLine();

        System.out.println("Inform the price you want for: ");
        Double price = Market.teclado.nextDouble();

        Product product = new Product(nome, price);

        Market.products.add(product);
        System.out.println("Inserting " + product.getName() + ", please wait...");
        Utils.pausar(1);
        Market.menu();
    }

    private static void Show() {
        if (Market.products.size() > 0) {
            System.out.println("=======Show Avaliable Products=======");
            for (Product p : Market.products) {
                System.out.println("OK, here they are...");
                System.out.println(p);
            }
        } else {
            System.out.println("There is no products here...");
        }
        Utils.pausar(1);
        Market.menu();
    }

    private static void Buy() {
        if (Market.products.size() > 0) {
            System.out.println("Inform the product name or code: ");
            System.out.println("=======Avaliable Products=======");
            for (Product p : Market.products) {
                System.out.println(p);
                System.out.println("-----------------------");
            }
            int code = Integer.parseInt(Market.teclado.nextLine());
            Boolean Has = false;

            for (Product p : Market.products) {
                if (p.getcode() == code) {
                    int quant = 0;
                    try {
                        quant = Market.Cart.get(p);
                        Market.Cart.put(p, quant + 1);
                    } catch (NullPointerException e) {
                        Market.Cart.put(p, 1);
                    }

                    System.out.println("The Product was added to your cart...");
                    Has = true;
                }
                if (Has) {
                    System.out.println("Want to add more? 1 - Yes , 2 - No, Exit buy option.");
                    int op = Integer.parseInt(Market.teclado.nextLine());

                    if (op == 1) {
                        Market.Buy();
                    } else {
                        System.out.println("Parsing your order, please wait...");
                        Utils.pausar(1);
                        Market.MakeOrder();
                    }
                } else {
                    System.out.println("The code " + code + " Doesnt exist");
                }
            }
        } else {
            System.out.println("This Product is Unavaliable");
        }
        Utils.pausar(0);
        Market.menu();
        System.out.println("Processing your Order");
    }

    private static void View() {
        if (Market.Cart.size() > 0) {
            System.out.println("=======Your Cart======");
            for (Product p : Market.Cart.keySet()) {
                System.out.println(p + "\n Quantity: " + Market.Cart.get(p));
            }
        } else {
            System.out.println("There is no items on your cart, go buy some");
        }
        Utils.pausar(1);
        Market.menu();
    }

    private static void MakeOrder() {
        Double total = 0.0;
        System.out.println("=======YOUR CART=======");
        for (Product p : Market.Cart.keySet()) {
            int quant = Market.Cart.get(p);
            total += p.getPrice() * quant;
            System.out.println(p);
            System.out.println("Quantity: " + quant);
        }
        System.out.println("Your Order Costs: " + Utils.DoubleforString(total));
        Market.Cart.clear();
        System.out.println("Thank you for buying with us :D");
        Utils.pausar(6);
        Market.menu();

    }
}
