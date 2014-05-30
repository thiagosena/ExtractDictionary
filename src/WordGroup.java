import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bernardog on 28/05/14.
 */
public class WordGroup {

    private ArrayList<String> words;

    public WordGroup(String s) {
        this.words = new ArrayList<String>();
        this.words.add(s);
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public boolean isSimilar(String s){
        for (Iterator<String> it = words.iterator(); it.hasNext();) {
            String word = it.next();
            if (computeEditDistance(word, s) == 1){
                return true;
            }
        }
        return false;
    }

    public static int computeEditDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }

}
