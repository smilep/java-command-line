package com.smilep.kickstart;

import java.util.*;
import java.io.*;

public class Plates {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            for (int j = 1; j <= t; j++) {
                int numStacks = in.nextInt();
                int numPlates = in.nextInt();
                int platesNeeded = in.nextInt();
                int beautyValue = 0;
                
                for(int i=0;i<numStacks;i++) {
                    
                }
                System.out.println("Case #" + j + ": " + beautyValue);
            }
        } finally {
            in.close();
        }
    }

}