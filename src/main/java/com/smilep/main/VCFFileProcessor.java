package com.smilep.main;

import java.io.BufferedReader;
import java.util.Map;
import java.util.TreeMap;

import com.smilep.util.Util;

/**
 * @author SmileP
 * 
 *         Main class for processing of VCF contact files
 * 
 */
public class VCFFileProcessor {

    private static final String FILE_NAME = "Smile_24Dec2015.vcf";

    public static void main(String[] args) {
        printVCFContacts();
    }

    /**
     * Prints VCF contacts in Name - Phone number pairs. It also prints relevant
     * errors in processing conatacts.
     */
    private static void printVCFContacts() {
        boolean begin = false;
        String name = "";
        String number = "";
        int namesNum = 0;
        int numbersNum = 0;
        Map<String, String> contactsMap = new TreeMap<String, String>();
        try {
            // Open the file
            BufferedReader br = Util.getFileAsBufferedReader(FILE_NAME);
            String strLine;

            // Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("BEGIN:VCARD")) {
                    begin = true;
                } else if (strLine.contains("END:VCARD")) {
                    begin = false;
                    contactsMap.put(name, number);
                    if (namesNum > 1) {
                        System.err.println("Multiple names : " + name);
                    }
                    if (numbersNum > 1) {
                        System.err.println("Multiple numbers : " + number);
                    }
                    name = "";
                    number = "";
                    namesNum = 0;
                    numbersNum = 0;
                }
                if (begin && strLine.contains("FN:")) {
                    namesNum++;
                    name = strLine.substring(3);
                }
                if (begin && strLine.contains("TEL;")) {
                    numbersNum++;
                    if (strLine.contains("TEL;CELL:")) {
                        number = strLine.substring(9);
                    } else if (strLine.contains("TEL;CELL;PREF:")) {
                        number = strLine.substring(14);
                    } else if (strLine.contains("TEL;X-Mobile:")) {
                        number = strLine.substring(13);
                    } else if (strLine.contains("TEL;X-OTHER:")) {
                        number = strLine.substring(12);
                    } else if (strLine.contains("TEL;X-Other:")) {
                        number = strLine.substring(12);
                    } else if (strLine.contains("TEL;HOME:")) {
                        number = strLine.substring(9);
                    } else {
                        System.err.println("Number cannot be formatted : " + strLine);
                        number = strLine;
                    }
                }
            }

            // Print the content on the console
            for (String contactName : contactsMap.keySet()) {
                System.out.println(contactName + " " + contactsMap.get(contactName));
            }

            // Close the input stream
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
