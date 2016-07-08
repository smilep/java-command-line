package com.smilep.main;

import java.io.PrintStream;
import java.lang.reflect.Method;

import com.smilep.google.codejam.SheepCounter;
import com.smilep.model.RunThisMethod;
import com.smilep.util.Util;

/**
 * @author SmileP
 * 
 *         Main class for Google CodeJam problems
 * 
 */
public class GoogleCodeJam {

    public static void main(String[] args) {
        try {
            executeSolution(SheepCounter.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("GoogleCodeJam execution complete with errors");
        }
        System.out.println("GoogleCodeJam execution complete without errors");
    }

    /**
     * Executes the method with annotation RunThisMethod and prints out to a
     * file with name ClassName.out
     * 
     * It takes an input file of the name ClassName.in which has to be placed in
     * resources
     * 
     * @param clazz
     * @throws Exception
     */
    private static void executeSolution(Class<? extends Object> clazz) throws Exception {
        PrintStream ps = new PrintStream(Util.getOutputFilename(clazz));
        PrintStream orig = System.out;
        System.setOut(ps);

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
