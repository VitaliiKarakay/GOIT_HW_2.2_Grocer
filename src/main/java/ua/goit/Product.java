package ua.goit;

public class Product {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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
    private double cost;
    private double discountCount;
    private double discountPrice;

    public Product(String name, double cost, double discountCount, double discountPrice) {
        this.name = name;
        this.cost = cost;
        this.discountCount = discountCount;
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", discountCount=" + discountCount +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
