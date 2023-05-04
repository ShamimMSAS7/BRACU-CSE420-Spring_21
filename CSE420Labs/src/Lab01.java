/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author ShamimMSAS7
 */
public class Lab01 {

    public static void main(String[] args) {
        
        //making arrays of java keywords and other default expressions
        String[] keywords = {"abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"};
        String[] mathOperators = {"+", "-", "*", "/", "="};
        String[] logicalOperators = {"<", ">", "<=", ">=", "=="};
        String[] others = {",", ";", "(", ")", "{", "}", "[", "]"};

        String[][] array1 = {keywords, mathOperators, logicalOperators, others};
        
        //making arrayList for storing
        ArrayList<String> foundKeywords = new ArrayList<String>();
        ArrayList<String> foundMathOperators = new ArrayList<String>();
        ArrayList<String> foundLogicalOperators = new ArrayList<String>();
        ArrayList<String> foundOthers = new ArrayList<String>();
        ArrayList<String> foundIdentifiers = new ArrayList<String>();
        ArrayList<String> foundNumbers = new ArrayList<String>();

        ArrayList[] array2 = {foundKeywords, foundMathOperators, foundLogicalOperators, foundOthers};

        try {
            File in = new File("D://MSAS//7th Semester//CSE420//Labs//CSE420Labs//src//Lab01ReadingFile.txt");
            Scanner sc = new Scanner(in);
            String str = "";
            while (sc.hasNextLine()) {
                str += sc.nextLine() + " ";
            }

            //storing values in the first four arrayLists
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array1[i].length; j++) {
                    if (str.contains(array1[i][j])) {
                        array2[i].add(array1[i][j]);
                        str = str.replace(array1[i][j], " ");
                    }
                }
            }

            //passing rest of the string to scanner for identifying each and every word
            Scanner msas = new Scanner(str);
            while (msas.hasNext()) {
                String s = msas.next();
                if (s.startsWith("0") || s.startsWith("1") || s.startsWith("2") || s.startsWith("3") || s.startsWith("4") || s.startsWith("5") || s.startsWith("6") || s.startsWith("7") || s.startsWith("8") || s.startsWith("9")) {
                    foundNumbers.add(s);
                } else {
                    foundIdentifiers.add(s);
                }
            }

            //making the arrayLists unique
            foundNumbers = (ArrayList) foundNumbers.stream().distinct().collect(Collectors.toList());
            foundIdentifiers = (ArrayList) foundIdentifiers.stream().distinct().collect(Collectors.toList());

            //printing the arrayLists
            int size;
            ArrayList list;
            for (int i = 0; i < 5; i++) {

                if (i == 0) {
                    list = foundKeywords;
                    System.out.print("Keywords: ");
                } else if (i == 1) {
                    list = foundIdentifiers;
                    System.out.print("Identifiers: ");
                } else if (i == 2) {
                    list = foundMathOperators;
                    System.out.print("Math Operators: ");
                } else if (i == 3) {
                    list = foundLogicalOperators;
                    System.out.print("Logical Operators: ");
                } else {
                    list = foundNumbers;
                    System.out.print("Numerical Values: ");
                }
                size = list.size();
                for (int j = 0; j < size - 1; j++) {
                    System.out.print(list.get(j) + ", ");
                }
                System.out.println(list.get(size - 1));
            }

            System.out.print("Others: ");
            list = foundOthers;
            size = list.size();
            for (int j = 0; j < size - 1; j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println(list.get(size - 1));

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
