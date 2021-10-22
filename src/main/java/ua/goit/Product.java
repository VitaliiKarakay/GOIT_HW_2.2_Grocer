package ua.goit;

public class Product {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountCount() {
        return discountCount;
    }

    public void setDiscountCount(double discountCount) {
        this.discountCount = discountCount;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    private String name;
    private double price;
    private double discountCount;
    private double discountPrice;

    public Product(String name, double price, double discountCount, double discountPrice) {
        this.name = name;
        this.price = price;
        this.discountCount = discountCount;
        this.discountPrice = discountPrice;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + price +
                ", discountCount=" + discountCount +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
