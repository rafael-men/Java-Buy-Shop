package Model;

import Helper.Utils;

public class Product {
    private static int Contador = 1;

    private int code;
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.code = Product.Contador;
        this.name = name;
        this.price = price;
        Product.Contador += 1;
    }

    public int getcode() {
        return this.code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return "Código: " + this.getcode() + "\n Nome: " + this.getName() + "\nPreço: "
                + Utils.DoubleforString(this.getPrice());
    }

}
