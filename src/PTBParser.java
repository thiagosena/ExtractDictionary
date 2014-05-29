import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by bernardog on 28/05/14.
 */
public class PTBParser {

    private FileReader file;

    public PTBParser(String file) throws FileNotFoundException {
        this.file = new FileReader(file);
    }

    public void parseAll(TreeMap tree) throws IOException {

        BufferedReader br = new BufferedReader(file);
        String line = null;

        while((line = br.readLine()) != null) {
            String[] elements = line.split(" ");

            for (String s : elements) {
                if (s.contains(")") && (s.charAt(0)) != '.') {
                    while(s.charAt(s.length()-1) == ')') {
                        s = s.substring(0, s.length()-1);
                    }
                    tree.put(s, s);
                }
            }

        }
    }

    public void parseSubstantives(TreeMap tree) throws IOException {

    }
}
