package mod06_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Generic class Box that can store and manipulate a collection of elements.
 * The type of elements is defined by the generic type parameter <E>.
 * 
 * @param <E> the type of elements stored in this Box
 * 
 * @author angel
 */
public class Box<E> {

    // List to store elements of generic type E
    private ArrayList<E> list = new ArrayList<E>();

    /**
     * Adds an item to the list stored in the Box.
     * 
     * @param item the item to be added to the list
     */
    public void add(E item) {
        // Add the item to the list
        list.add(item);
    }

    /**
     * Randomly selects and returns an item from the list.
     * The list is shuffled to ensure randomness before picking.
     * 
     * @return the randomly picked item from the list
     */
    public E pick() {
        // Shuffle the list to randomize element order
        Collections.shuffle(list);
        
        // Return the first item from the shuffled list
        return list.get(0);
    }

    /**
     * Retrieves the entire list of items stored in the Box.
     * 
     * @return a list of all items in the Box
     */
    public List<E> getList() {
        // Return the list of stored items
        return list;
    }

}
