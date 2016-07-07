package com.smilep.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

/**
 * @author SmileP
 * 
 *         This class holds all the utility methods.
 * 
 */
public class Util {

    /**
     * Reads the file in resources folder and returns its BufferedReader
     * 
     * @param fileName
     * @return
     * @throws IOException
     */
    public static BufferedReader getFileAsBufferedReader(String fileName) throws IOException {
        File file = new File(fileName);
        OutputStream outputStream = new FileOutputStream(file);
        InputStream inputStream = Util.class.getClassLoader().getResourceAsStream(fileName);
        IOUtils.copy(inputStream, outputStream);
        return new BufferedReader(new FileReader(file));
    }

}
