
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
public class Lab04 {

    public static void main(String[] args) {
        try {
            File in = new File("D://MSAS//7th Semester//CSE420//Labs//CSE420Labs//src//input.txt");
            Scanner sc = new Scanner(in);
            String input = "";

            while (sc.hasNextLine()) {
                input += sc.nextLine();
            }
            String inputL = input.toLowerCase();
            String typeAndName = "((byte|short|int|long|float|double|boolean|char|void|string)\\s+[a-z][a-z0-9]*)";
            String pattern ="((public|private|protected)\\s+)?(static\\s+)?"+ typeAndName + "\\s*\\(((" + typeAndName + "\\s*,\\s*)*" + typeAndName + "\\s*)?\\)";

            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(inputL);
            String result = "";

            while (m.find()) {
                int start = m.start();
                int end = m.end();
                Scanner s = new Scanner(input.substring(start, end));
                String type = s.next();
                while(type.equalsIgnoreCase("public") || type.equalsIgnoreCase("private") || type.equalsIgnoreCase("protected") || type.equalsIgnoreCase("static")){
                  type=s.next();
                }
                String nameAndParameter = s.nextLine().trim();
                result += nameAndParameter + ", return type: " + type + "\n";
            }
            System.out.print("Methods:\n" + result);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
