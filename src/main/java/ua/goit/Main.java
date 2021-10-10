package ua.goit;

public class Main {

    public static void main(String[] args) {

        CostCalculate bag = new CostCalculate();
        String totalCost = bag.getCost("AB");
        System.out.println(totalCost);
    }


}
