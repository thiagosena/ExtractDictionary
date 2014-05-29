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
                if (isWord(s)) {
                    while(s.charAt(s.length()-1) == ')') {
                        s = s.substring(0, s.length()-1);
                    }
                    // Por enquanto estou colocando a palavra tanto
                    // como valor como chave. A vantagem de usar chave
                    // é que ele já organiza comparando as strings de
                    // um jeito otimizado.
                    tree.put(s, s);
                }
            }

        }
    }

    public void parseSubstantives(TreeMap tree) throws IOException {

        BufferedReader br = new BufferedReader(file);
        String line = null;

        while((line = br.readLine()) != null) {
            String[] elements = line.split(" ");

            for (int i = 0; i < elements.length; i++) {

                // Verifica se o elemento é uma palavra
                // – ou seja, termina com ')'.
                String word = elements[i];

                if (isWord(word)) {
                    if (isSubstantive(elements[i-1])){
                        // Remove os últimos parênteses
                        while (word.charAt(word.length() - 1) == ')') {
                            word = word.substring(0, word.length() - 1);
                        }
                        tree.put(word,word);
                    }
                }
            }
        }
    }

    public void parseVerbs(TreeMap tree) throws IOException {

        BufferedReader br = new BufferedReader(file);
        String line = null;

        while((line = br.readLine()) != null) {
            String[] elements = line.split(" ");

            for (int i = 0; i < elements.length; i++) {

                // Verifica se o elemento é uma palavra
                // – ou seja, termina com ')'.
                String word = elements[i];

                if (isWord(word)) {
                    if (isVerb(elements[i - 1])){
                        // Remove os últimos parênteses
                        while (word.charAt(word.length() - 1) == ')') {
                            word = word.substring(0, word.length() - 1);
                        }
                        tree.put(word,word);
                    }
                }
            }
        }
    }

    public void parseAdverbs(TreeMap tree) throws IOException {

        BufferedReader br = new BufferedReader(file);
        String line = null;

        while((line = br.readLine()) != null) {
            String[] elements = line.split(" ");

            for (int i = 0; i < elements.length; i++) {

                // Verifica se o elemento é uma palavra
                // – ou seja, termina com ')'.
                String word = elements[i];

                if (isWord(word)) {
                    if (isAdverb(elements[i-1])){
                        // Remove os últimos parênteses
                        while (word.charAt(word.length() - 1) == ')') {
                            word = word.substring(0, word.length() - 1);
                        }
                        tree.put(word,word);
                    }
                }
            }
        }
    }

    public void parseAdjectives(TreeMap tree) throws IOException {

        BufferedReader br = new BufferedReader(file);
        String line = null;

        while((line = br.readLine()) != null) {
            String[] elements = line.split(" ");

            for (int i = 0; i < elements.length; i++) {

                // Verifica se o elemento é uma palavra
                // – ou seja, termina com ')'.
                String word = elements[i];

                if (isWord(word)) {
                    if (isAdjective(elements[i - 1])){
                        // Remove os últimos parênteses
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

    private boolean isVerb(String s) {
        return s.contains("V");
    }

    private boolean isAdverb(String s) {
        return s.contentEquals("(RB");
    }

    private boolean isAdjective(String s) {
        return s.contains("JJ");
    }
}
