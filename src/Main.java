import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        WordsTree tree = new WordsTree();

        PTBParser parser = new PTBParser("ptb-flat.txt");

        parser.parseVerbs(tree);

        /*for (Map.Entry<String, String> entry : tree.entrySet()) {
            System.out.println(entry.getKey());
        }*/

        /*tree.put("pray","pray");
        tree.put("rise","rise");
        tree.put("ring","ring");
        tree.put("play","play");
        tree.put("raise","raise");
        tree.put("rint","rint");
        */
        tree.groupWords();
        //tree.printGroups();
    }
}
