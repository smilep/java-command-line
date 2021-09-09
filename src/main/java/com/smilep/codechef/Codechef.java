package com.smilep.codechef;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
// https://www.codechef.com/MAY20B/problems/CORUS'ss
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int j = 0; j < t; j++) {
            int people = in.nextInt();
            int queries = in.nextInt();
            String str = in.next();
            Map<String, Long> map = new HashMap<>();
            String[] strArray = str.split("");
            for (int i = 0; i < strArray.length; i++) {
                String element = strArray[i];
                if (null != map.get(element)) {
                    map.put(element, map.get(element) + 1l);
                } else {
                    map.put(element, 1l);
                }
            }
            for (int i = 0; i < queries; i++) {
                long isolationCenters = in.nextLong();
                long queue = 0;
                for (Map.Entry<String, Long> entry : map.entrySet()) {
                    if (entry.getValue() > isolationCenters) {
                        queue = queue + (entry.getValue() - isolationCenters);
                    }
                }
                System.out.println(queue);
            }
        }
    }
}