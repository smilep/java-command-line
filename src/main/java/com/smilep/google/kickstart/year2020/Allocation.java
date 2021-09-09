package com.smilep.google.kickstart.year2020;

import java.util.*;
import java.io.*;

public class Allocation {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            for (int j = 1; j <= t; j++) {
                int numHouses = in.nextInt();
                int budget = in.nextInt();
                List<Integer> costs = new ArrayList<>();
                for (int i = 0; i < numHouses; i++) {
                    costs.add(in.nextInt());
                }
                Collections.sort(costs);
                int housesBought = 0;
                int moneySpent = 0;
                for (int i = 0; i < costs.size(); i++) {
                    int cost = costs.get(i);
                    if ((moneySpent + cost) <= budget) {
                        moneySpent = moneySpent + cost;
                        housesBought++;
                    } else {
                        break;
                    }
                }
                System.out.println("Case #" + j + ": " + housesBought);
            }
        } finally {
            in.close();
        }
    }

}