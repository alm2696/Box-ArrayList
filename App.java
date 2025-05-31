package mod06_01;

import java.util.ArrayList;

/**
 * The App class demonstrates the use of the Box class with generic types.
 * It creates two instances of Box, one for Strings and one for Integers,
 * and performs various operations such as adding items, displaying items, 
 * and picking random items from the Box.
 * 
 * @author angel
 */
public class App {

    /**
     * The main method where execution starts. It demonstrates the functionality 
     * of the Box class using both String and Integer types. It also includes 
     * examples of generic methods for displaying and comparing elements.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        
        System.out.println("Box with Strings");
        System.out.println("");

        // Create a Box to store Strings
        Box<String> stringBox = new Box<String>();
        
        // Add some names to the stringBox
        stringBox.add("Bill");
        stringBox.add("Jane");
        stringBox.add("Sue");
        
        // Display all items in the stringBox
        displayBox(stringBox);
        
        System.out.println("");
        // Randomly pick and display a name from the stringBox
        System.out.println("Winner: " + stringBox.pick());
        
        
        System.out.println("Box with Integers");
        System.out.println("");
        
        // Create a Box to store Integers
        Box<Integer> intBox = new Box<Integer>();
        
        // Add integers 0 to 9 to the intBox
        for (int i = 0; i < 10; i++) {
            intBox.add(i);
        }
        
        // Display all items in the intBox
        displayBox(intBox);
        
        System.out.println("");    
        // Randomly pick and display an integer from the intBox
        System.out.println("Number: " + intBox.pick());
        
        System.out.println("");
        
        // Demonstrate the use of a generic method to display different types
        App.<String, String>display("Hello", "World");
        App.<Integer, Double>display(10, 3.14);
        
        // Demonstrate the use of a generic method to compare two strings
        System.out.println("Result: " + App.<String>compare("Hello", "World"));
        
        // Uncommenting the line below would cause a compile-time error 
        // because Box<?> does not implement Comparable
        // System.out.println("Result: " + App.<Box<?>>compare(stringBox, intBox));
    }
    
    /**
     * Displays all items in a Box. This method is generic and can handle a Box of any type.
     * 
     * @param box the Box containing the items to be displayed
     */
    public static void displayBox(Box<?> box) {
        // Cast the list from the Box to an ArrayList
        ArrayList<?> list = (ArrayList<?>) box.getList();
        
        // Loop through the list and print each item
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Item: " + list.get(i));
        }
    }
    
    /**
     * A generic method that displays two items of potentially different types.
     * 
     * @param <A> the type of the first item
     * @param <B> the type of the second item
     * @param item1 the first item to be displayed
     * @param item2 the second item to be displayed
     */
    public static <A, B> void display(A item1, B item2) {
        // Display the first item
        System.out.println(item1);
        // Display the second item
        System.out.println(item2);
    }
    
    /**
     * A generic method that compares two items of the same type.
     * The items must implement the Comparable interface.
     * 
     * @param <A> the type of the items being compared, which must be comparable
     * @param item1 the first item to compare
     * @param item2 the second item to compare
     * @return an integer result of the comparison (negative if item1 < item2, 
     *         zero if item1 equals item2, positive if item1 > item2)
     */
    public static <A extends Comparable<A>> int compare(A item1, A item2) {
        // Compare the two items and return the result
        return item1.compareTo(item2);
    }
}
