import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> iterator1 = strings.listIterator();
        ListIterator<String> iterator2 = strings.listIterator();

        for (int j = 0; j < strings.size(); j++) {
            iterator2.next();
        }

        for (int k = 0; k < strings.size()/2; k++) {
            String name1 = iterator1.next();
            String name2 = iterator2.previous();

            iterator1.set(name2);
            iterator2.set(name1);
        }

    }
}