package com.smilep.practice;

import java.time.LocalTime;

public class MainExample {

    public static void main(String[] args) {
        LocalTime a = LocalTime.of(0, 15);
        LocalTime b = LocalTime.of(0, 14);
        System.out.println(a.isAfter(b));

    }

}
