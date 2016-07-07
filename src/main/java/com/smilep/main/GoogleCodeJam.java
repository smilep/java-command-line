package com.smilep.main;

import java.io.IOException;
import java.io.PrintStream;

import com.smilep.google.codejam.SheepCounter;
import com.smilep.util.Util;

/**
 * @author SmileP
 * 
 *         Main class for Google CodeJam problems
 * 
 */
public class GoogleCodeJam {

    private static final String INPUT_FILE_NAME = "google-codejam-input.in";
    private static final String OUTPUT_FILE_NAME = "google-codejam-output.in";

    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream(OUTPUT_FILE_NAME);
        PrintStream orig = System.out;
        System.setOut(ps);

        SheepCounter.countSheep(Util.getFileAsBufferedReader(INPUT_FILE_NAME));

        System.setOut(orig);
        ps.close();
    }
}
