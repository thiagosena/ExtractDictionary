import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        TreeMap<String, String> tree = new TreeMap();

        PTBParser parser = new PTBParser("ptb-flat.txt");

        parser.parseVerbs(tree);

        for (Map.Entry<String, String> entry : tree.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
