package s117_shravan;
import java.util.HashMap;
import java.util.Map;

public class S117_shravan3{

    public static void main(String[] args) {

        // Creating a HashMap
        Map<String, Integer> studentMarks = new HashMap<>();

        // Adding key-value pairs
        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 90);
        studentMarks.put("Charlie", 78);

        // Displaying the map
        System.out.println("Student Marks: " + studentMarks);

        // Accessing a value
        System.out.println("Marks of Bob: " + studentMarks.get("Bob"));

        // Updating a value
        studentMarks.put("Alice", 95);
        System.out.println("After updating Alice's marks: " + studentMarks);

        // Removing a key-value pair
        studentMarks.remove("Charlie");
        System.out.println("After removing Charlie: " + studentMarks);

        // Checking if a key exists
        System.out.println("Contains key Bob? " + studentMarks.containsKey("Bob"));

        // Checking if a value exists
        System.out.println("Contains value 95? " + studentMarks.containsValue(95));

        // Displaying keys
        System.out.println("Keys: " + studentMarks.keySet());

        // Displaying values
        System.out.println("Values: " + studentMarks.values());

        // Displaying key-value pairs
        System.out.println("Entries: " + studentMarks.entrySet());

        // Displaying size
        System.out.println("Size of map: " + studentMarks.size());

        // Clearing the map
        studentMarks.clear();
        System.out.println("Map after clearing: " + studentMarks);
    }
}
