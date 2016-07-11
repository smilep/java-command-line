package com.smilep.main;

import java.io.PrintStream;
import java.lang.reflect.Method;

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
            executeSolution(SheepCounter.class, true);
            executeSolution(RevengeOfPancakes.class, true);
            executeSolution(TheLastWord.class, true);
            executeSolution(PrimePrime.class, true);
            System.out.println("SolutionExecutor execution complete without errors");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SolutionExecutor execution complete with errors");
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total Time : " + totalTime + " millisecs");
    }

    /**
     * Executes the method with annotation RunThisMethod and prints out to a
     * file with name ClassName.out
     * 
     * It takes an input file of the name ClassName.in which has to be placed in
     * resources
     * 
     * @param clazz
     * @param outputToFile
     * @throws Exception
     */
    private static void executeSolution(Class<? extends Object> clazz, boolean outputToFile) throws Exception {
        PrintStream ps = new PrintStream(Util.getOutputFilename(clazz));
        PrintStream orig = System.out;
        if (outputToFile) {
            System.setOut(ps);
        }

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RunThisMethod.class)) {
                method.invoke(clazz, Util.getFileAsBufferedReader(Util.getInutFilename(clazz)));
            }
        }

        System.setOut(orig);
        ps.close();
    }
}
