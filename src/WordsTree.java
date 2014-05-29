import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bernardog on 28/05/14.
 */
public class WordsTree extends TreeMap<String, String> {

    private WordGroup[] groups;

    public void groupWords(){
        for (Map.Entry<String, String> entry : this.entrySet()) {
            String word = entry.getKey();

        }
    }

}
