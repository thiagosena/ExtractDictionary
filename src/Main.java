import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        WordsTree tree = new WordsTree();

        PTBParser parser = new PTBParser("ptb-flat.txt");

        parser.parseSubstantives(tree);

        tree.groupWords();
    }
}
