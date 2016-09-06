package com.smilep.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author SmileP
 * 
 *         This class holds all the utility methods.
 * 
 */
public class Util {

    public static Properties properties = new Properties();

    static {
        InputStream input;
        try {
            input = new FileInputStream("config.properties");
            properties.load(input);
        } catch (Exception e) {
            System.out.println("property file not found");
            e.printStackTrace();
        }
    }

    /**
     * Reads the file in resources folder and returns its BufferedReader
     * 
     * @param fileName
     * @return
     * @throws IOException
     */
    public static BufferedReader getFileAsBufferedReader(String fileName) throws IOException {
        File file = new File(fileName);
        // Uncomment following code if file needs to be copied from resources to
        // execution folder
        /*
         * OutputStream outputStream = new FileOutputStream(file); InputStream
         * inputStream =
         * Util.class.getClassLoader().getResourceAsStream(fileName);
         * IOUtils.copy(inputStream, outputStream);
         */
        return new BufferedReader(new FileReader(file));
    }

    /**
     * Generates output filename
     * 
     * @param clazz
     * @return
     */
    public static String getOutputFilename(Class<? extends Object> clazz) {
        return clazz.getSimpleName() + ".out";
    }

    /**
     * Generates input filename
     * 
     * @param clazz
     * @return
     */
    public static String getInutFilename(Class<? extends Object> clazz) {
        return clazz.getSimpleName() + ".in";
    }

    /**
     * Executes the method with annotation annotationClass and prints out to a
     * file with name ClassName.out if outputToFile is true else prints to
     * console
     * 
     * It takes an input file of the name ClassName.in which has to be placed in
     * resources
     * 
     * @param clazz
     * @param annotationClass
     * @param outputToFile
     * @throws Exception
     */
    public static void executeMethods(Class<? extends Object> clazz, Class<? extends Annotation> annotationClass,
            boolean outputToFile) throws Exception {
        PrintStream ps = new PrintStream(getOutputFilename(clazz));
        PrintStream orig = System.out;
        if (outputToFile) {
            System.setOut(ps);
        }

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                method.invoke(clazz, getFileAsBufferedReader(Util.getInutFilename(clazz)));
            }
        }

        System.setOut(orig);
        ps.close();
    }

}
