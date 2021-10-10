package ua.goit;

import java.util.*;

public class CostCalculate {

    public static final Map<String, double[]> prices = new HashMap<>();

    static {
        prices.put("A", new double[]{1.25, 3, 3});
        prices.put("B", new double[]{4.25, 4.25, 4.25});
        prices.put("C", new double[]{1, 6, 5});
        prices.put("D", new double[]{0.75, 0.75, 0.75});
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

        for (String buy : buys) {
            switch (buy) {
                case "A" -> count.put("A", count.get("A") + 1);
                case "B" -> count.put("B", count.get("B") + 1);
                case "C" -> count.put("C", count.get("C") + 1);
                case "D" -> count.put("D", count.get("D") + 1);
                default -> System.out.println("This good " + buy + " isn't from our store");
            }
        }

        System.out.println(buys[0]);
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
}

