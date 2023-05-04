/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ShamimMSAS7
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Lab02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of cases you want to check");
        int n = sc.nextInt();
        sc.nextLine();
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();

        }
        ArrayList<Integer> mail = new ArrayList<Integer>();
        ArrayList<Integer> web = new ArrayList<Integer>();
        ArrayList<Integer> invalid = new ArrayList<Integer>();
        for (int i = 0; i < str.length; i++) {
            String s = str[i].toLowerCase();
            if (s.contains("@") && checkMail(s)) {
                mail.add(i + 1);
            } else if (s.startsWith("www.") && checkWeb(s)) {
                web.add(i + 1);
            } else {
                invalid.add(i + 1);
            }

        }
        System.out.print("Email");
        for (int i : mail) {
            System.out.print(", " + i);
        }
        System.out.println();

        System.out.print("Web");
        for (int i : web) {
            System.out.print(", " + i);
        }
        System.out.println();

        System.out.print("Invalid");
        for (int i : invalid) {
            System.out.print(", " + i);
        }
        System.out.println();

    }

    static boolean checkMail(String s) {
        String first = "", last = "", middle = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '@') {
                first = s.substring(0, i);
                last = s.substring(i + 1);
                if (last.contains(".") && last.charAt(0) != '.' && last.charAt(0) != '-') {
                    for (int j = last.length() - 1; j >= 0; j--) {
                        if (last.charAt(j) == '.') {
                            middle = last.substring(0, j);
                            last = last.substring(j + 1);
                            break;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return firstCheck(first) && middleCheck(middle) && lastCheck(last);
    }

    static boolean checkWeb(String s) {
        String first = "", last = "";
        last = s.substring(4, s.length());
        if (last.contains(".") && last.charAt(0) != '.' && last.charAt(0) != '-') {
            for (int j = last.length() - 1; j >= 0; j--) {
                if (last.charAt(j) == '.') {
                    first = last.substring(0, j);
                    last = last.substring(j + 1);
                    break;
                }
            }
        } else {
            return false;
        }

        return firstCheck(first) && lastCheck(last);
    }

    static boolean firstCheck(String s) {
        if (s.length() == 0 || !isLetter(s.charAt(0))) {
            return false;
        }
        return check(s);

    }

    static boolean middleCheck(String s) {
        if (s.length() == 0 || !isLetter(s.charAt(0))) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (isNumber(s.charAt(i))) {
                return false;
            }
        }
        return check(s);
    }

    static boolean lastCheck(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static boolean check(String s) {
        boolean previousDot = false;
        boolean previousOther = false;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (previousDot || previousOther) {
                    return false;
                } else {
                    previousDot = true;
                }
            } else if (c == '-') {
                if (previousDot) {
                    return false;
                } else {
                    previousOther = true;
                }
            } else if (isLetter(c) || isNumber(c)) {
                previousDot = false;
                previousOther = false;
            } else {
                return false;
            }
        }
        return !(previousDot || previousOther);
    }

    static boolean isLetter(char c) {
        return (int) c >= 97 && (int) c <= 122;
    }

    static boolean isNumber(char c) {
        return (int) c >= 48 && (int) c <= 57;
    }

}
