package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Created by bernardog on 29/05/14.
 */
public class SubstantivePTBParser implements PTBParser {

    private FileReader file;

    public SubstantivePTBParser(String file) throws FileNotFoundException {
        this.file = new FileReader(file);
    }

    @Override
    public void parse(TreeMap tree) throws IOException {
        BufferedReader br = new BufferedReader(file);
        String line = null;
        while((line = br.readLine()) != null) {
            String[] elements = line.split(" ");
            for (int i = 0; i < elements.length; i++) {
                String word = elements[i];
                if (isWord(word)) {
                    if (isSubstantive(elements[i-1])){
                        while (word.charAt(word.length() - 1) == ')') {
                            word = word.substring(0, word.length() - 1);
                        }
                        tree.put(word,word);
                    }
                }
            }
        }
    }

    private boolean isWord(String s) {
        return s.contains(")") && (s.charAt(0) != '.');
    }

    private boolean isSubstantive(String s) {
        return s.contains("NN");
    }
}
