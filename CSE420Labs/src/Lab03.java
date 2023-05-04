
import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ShamimMSAS7
 */
public class Lab03 {

    public static void main(String[] args) {
        try {
            File in = new File("D://MSAS//7th Semester//CSE420//Labs//CSE420Labs//src//Lab03ReadingFile.txt");
            Scanner sc = new Scanner(in);
            int x = sc.nextInt();
            sc.nextLine();
            Pattern[] p = new Pattern[x];
            for (int i = 0; i < x; i++) {
                p[i] = Pattern.compile(sc.nextLine());
            }
            int y = sc.nextInt();
            sc.nextLine();
            
            String[] str = new String[y];
            for (int i = 0; i < y; i++) {
                str[i] = sc.nextLine();
            }

            for (int i = 0; i < str.length; i++) {
                boolean flag = true;
                for (int j = 0; j < p.length; j++) {
                    Matcher m = p[j].matcher(str[i]);
                    if (m.find()) {
                        System.out.println("YES, " + (j + 1));
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("NO, 0");
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
