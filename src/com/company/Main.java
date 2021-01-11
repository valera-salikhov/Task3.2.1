package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File fl1 = new File("C:\\Users\\Valery\\IdeaProjects\\Sravnenie_dvyh_failov\\src\\com\\company\\File1.in");
            File fl2 = new File("C:\\Users\\Valery\\IdeaProjects\\Sravnenie_dvyh_failov\\src\\com\\company\\File2.in");
            BufferedReader br1 = new BufferedReader(new FileReader(fl1));
            BufferedReader br2 = new BufferedReader(new FileReader(fl2));
            char[] c1 = new char[(int)fl1.length()];
            char[] c2 = new char[(int)fl2.length()];
            int counter = 0;
            while (br1.ready()) {
                c1[counter] = (char)br1.read();
                counter++;
            }
            br1.close();
            counter = 0;
            while (br2.ready()) {
                c2[counter] = (char)br2.read();
                counter++;
            }
            br2.close();
            System.out.println("Ten " + c2[10]);
            int len_min = Math.min(c1.length, c2.length);
            int count_diff = 0;
            for (int i = 0; i < len_min; i++) {
                if (c1[i] != c2[i]) {
                    count_diff++;
                    String a = new String();
                    String b = new String();
                    if (c1[i] == ' ') {
                        a = "space";
                    }
                    if (c1[i] == '\n' || c1[i] == '\r') {
                        a = "enter";
                    }
                    if (c2[i] == ' ') {
                        b = "space";
                    }
                    if (c2[i] == '\n' || c2[i] == '\r') {
                        b = "enter";
                    }
                    if (a.isEmpty()) {
                        if (b.isEmpty()) {
                            System.out.println(count_diff + ")" + c1[i] + " " + c2[i]);
                        } else {
                            System.out.println(count_diff + ")" + c1[i] + " " + b);
                        }
                    } else if (b.isEmpty()) {
                        System.out.println(count_diff + ")" + a + " " + c2[i]);
                    } else {
                        System.out.println(count_diff + ")" + a + " " + b);
                    }
                    System.out.println();
                }
            }
            count_diff += Math.max(c1.length, c2.length) - Math.min(c1.length, c2.length);
            System.out.println("Количество разных элементов: " + count_diff);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}