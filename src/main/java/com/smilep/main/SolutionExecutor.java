package com.smilep.main;

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

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("SolutionExecutor execution started");
        Class<RunThisMethod> annotation = RunThisMethod.class;
        try {
            Util.executeMethods(SheepCounter.class, annotation, true);
            Util.executeMethods(RevengeOfPancakes.class, annotation, true);
            Util.executeMethods(TheLastWord.class, annotation, true);
            Util.executeMethods(PrimePrime.class, annotation, true);
            Util.executeMethods(DLInfoGatherer.class, annotation, true);
            Util.executeMethods(StringGenerator.class, annotation, true);
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
