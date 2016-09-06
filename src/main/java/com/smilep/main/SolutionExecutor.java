package com.smilep.main;

import java.util.Properties;

import com.smilep.google.codejam.RevengeOfPancakes;
import com.smilep.google.codejam.SheepCounter;
import com.smilep.google.codejam.TheLastWord;
import com.smilep.hackerearth.PrimePrime;
import com.smilep.model.RunThisMethod;
import com.smilep.random.DLInfoGatherer;
import com.smilep.random.StringGenerator;
import com.smilep.util.Util;

/**
 * @author SmileP
 * 
 *         Main class for coding problems
 * 
 */
public class SolutionExecutor {

    private static Properties properties = Util.properties;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("SolutionExecutor execution started");
        Class<RunThisMethod> annotation = RunThisMethod.class;
        try {
            switch (Integer.parseInt(properties.getProperty("processId"))) {
            case 1:
                Util.executeMethods(SheepCounter.class, annotation, true);
                break;
            case 2:
                Util.executeMethods(RevengeOfPancakes.class, annotation, true);
                break;
            case 3:
                Util.executeMethods(TheLastWord.class, annotation, true);
                break;
            case 4:
                Util.executeMethods(PrimePrime.class, annotation, true);
                break;
            case 5:
                Util.executeMethods(DLInfoGatherer.class, annotation, true);
                break;
            case 6:
                Util.executeMethods(StringGenerator.class, annotation, true);
                break;

            default:
                System.out.println("No process for matching processId found");
                break;
            }
            System.out.println("SolutionExecutor execution complete without errors");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SolutionExecutor execution complete with errors");
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total Time : " + totalTime + " millisecs");
    }

}
