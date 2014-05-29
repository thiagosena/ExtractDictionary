import java.util.*;

/**
 * Created by bernardog on 28/05/14.
 */
public class WordsTree extends TreeMap<String, String> {

    private ArrayList<WordGroup> groups;

    public WordsTree() {
        this.groups = new ArrayList<WordGroup>();
    }

    public WordsTree(Comparator<? super String> comparator) {
        super(comparator);
        this.groups = new ArrayList<WordGroup>();
    }

    public void groupWords(){
        for (Map.Entry<String, String> entry : this.entrySet()) {
            if (groups.size() == 0) {
                groups.add(new WordGroup(entry.getValue()));
            }
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i).isSimilar(entry.getValue())) {
                    groups.get(i).getWords().add(entry.getValue());
                } else {
                    groups.add(new WordGroup(entry.getValue()));
                }
            }
//            for (Iterator<WordGroup> it = groups.iterator(); it.hasNext();) {
//                WordGroup group = it.next();
//                if (group.isSimilar(entry.getValue())) {
//                    group.getWords().add(entry.getValue());
//                } else {
//                    groups.add(new WordGroup(entry.getValue()));
//                }
//            }
        }
    }

    public void printGroups(){
        for (WordGroup group : groups) {
            System.out.println("======GRUPO====");
            for (String s : group.getWords()) {
                System.out.println(s);
            }
        }
    }

}
