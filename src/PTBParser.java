import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by bernardog on 28/05/14.
 */
public class PTBParser {

    private String fileContent;

    public PTBParser(String file) throws FileNotFoundException {
        this.fileContent = new Scanner(new File(file)).useDelimiter("\\Z").next();
    }

    public void parse(TreeMap tree) throws IOException{
        String[] result = fileContent.replace("\n", " ").split(" ");
        for (String s : result) {
            if (s.contains(")") && (s.charAt(0)) != '.') {
                while(s.charAt(s.length()-1) == ')') {
                    s = s.substring(0, s.length()-1);
                }
                tree.put(s, s);
            }
        }
    }
}
