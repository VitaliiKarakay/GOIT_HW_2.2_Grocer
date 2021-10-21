package ua.goit;

import java.util.*;

public class CostCalculate {

    public static final Map<String, double[]> prices = new HashMap<>();

    static {
        Product a = new Product("A", 1.25, 3, 3);
        Product b = new Product("B", 4.25, 4.25, 4.25);
        Product c = new Product("C", 1, 6, 5);
        Product d = new Product("D", 0.75, 0.75, 0.75);

        prices.put(a.getName(), new double[]{a.getCost(), a.getDiscountCount(), a.getDiscountPrice()});
        prices.put(b.getName(), new double[]{b.getCost(), b.getDiscountCount(), b.getDiscountPrice()});
        prices.put(c.getName(), new double[]{c.getCost(), c.getDiscountCount(), c.getDiscountPrice()});
        prices.put(d.getName(), new double[]{d.getCost(), d.getDiscountCount(), d.getDiscountPrice()});
    }

    /*
    Написать приложение по ТЗ:
Приложение «Продуктовый магазин». У каждого товара в магазине есть своя цена.
Есть также товары, для которых предусмотрена акционная цена для N количества.
Например, 1 яблоко стоит 1 $, 6 яблок стоят 5 $. У каждого продукта есть свой код - буква английского алфавита.
Рассчитать стоимость корзины с учетом скидок.
На данный момент «склад» магазина и расценки выглядят следующим образом:
     */
    public Map<String, Integer> splitBag(String bag) {
        String[] buys = bag.toUpperCase().split("");
        Map<String, Integer> count = new HashMap<>();
        count.put("A", 0);
        count.put("B", 0);
        count.put("C", 0);
        count.put("D", 0);
        if (bag.length() == 0) System.out.println("Bag is empty");
        else{
            for (String buy : buys) {
                switch (buy) {
                    case "A" -> count.put("A", count.get("A") + 1);
                    case "B" -> count.put("B", count.get("B") + 1);
                    case "C" -> count.put("C", count.get("C") + 1);
                    case "D" -> count.put("D", count.get("D") + 1);
                    default -> System.out.println("This good " + buy + " isn't from our store");
                }
            }
        }
        return count;
    }

    public double calculateTotalCost(String bag) {
        double totalCost = 0;
        Map<String, Integer> count = splitBag(bag);

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            double[] costs = prices.get(entry.getKey());

            if (entry.getKey().equals("A")) {
                if (entry.getValue() >= costs[1]) {
                    double div = (entry.getValue() - entry.getValue() % costs[1]) / costs[1];
                    totalCost += div * costs[2] + (entry.getValue() % costs[1]) * costs[0];
                } else {
                    totalCost += entry.getValue() * costs[0];
                }
            }
            if (entry.getKey().equals("B")) {
                totalCost += entry.getValue() * costs[0];
            }
            if (entry.getKey().equals("C")) {
                if (entry.getValue() >= costs[1]) {
                    double div = (entry.getValue() - entry.getValue() % costs[1]) / costs[1];
                    totalCost += div * costs[2] + entry.getValue() % costs[1] * costs[0];
                } else {
                    totalCost += entry.getValue() * costs[0];
                }
            }
            if (entry.getKey().equals("D")) {
                totalCost += entry.getValue() * costs[0];
            }
        }

        return totalCost;
    }

    public String getCost (String bag) {
        return "Total cost: " + calculateTotalCost(bag);
    }
}

