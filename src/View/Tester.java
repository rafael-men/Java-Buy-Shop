package View;

import Model.Product;

public class Tester {
    public static void main(String[] args) {
        Product produto = new Product("Refrigerante", 4.99);

        Product produto2 = new Product("Pizza", 8.00);

        System.out.println(produto);
        System.out.println(produto2);
    }
}
