package com.smilep.main;

import com.smilep.google.codejam.RevengeOfPancakes;
import com.smilep.google.codejam.SheepCounter;
import com.smilep.google.codejam.TheLastWord;
import com.smilep.hackerearth.PrimePrime;
import com.smilep.model.RunThisMethod;
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
        try {
            Util.executeMethods(SheepCounter.class, RunThisMethod.class, true);
            Util.executeMethods(RevengeOfPancakes.class, RunThisMethod.class, true);
            Util.executeMethods(TheLastWord.class, RunThisMethod.class, true);
            Util.executeMethods(PrimePrime.class, RunThisMethod.class, true);
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
