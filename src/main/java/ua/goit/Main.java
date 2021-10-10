package ua.goit;

public class Main {

    public static void main(String[] args) {

        CostCalculate urn = new CostCalculate();
        double totalCost = urn.calculateTotalCost("abcdaba");
        System.out.println(totalCost);
    }


}
