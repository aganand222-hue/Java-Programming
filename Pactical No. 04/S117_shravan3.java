package s117_shravan;
import java.util.HashMap;
import java.util.Map;

public class S117_shravan3{

    public static void main(String[] args) {

        Map<String, Integer> studentMarks = new HashMap<>();

        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 90);
        studentMarks.put("Charlie", 78);

        System.out.println("Student Marks: " + studentMarks);

        System.out.println("Marks of Bob: " + studentMarks.get("Bob"));

        studentMarks.put("Alice", 95);
        System.out.println("After updating Alice's marks: " + studentMarks);

        studentMarks.remove("Charlie");
        System.out.println("After removing Charlie: " + studentMarks);
        System.out.println("Contains key Bob? " + studentMarks.containsKey("Bob"));
        System.out.println("Contains value 95? " + studentMarks.containsValue(95));
        System.out.println("Keys: " + studentMarks.keySet());

        System.out.println("Values: " + studentMarks.values());

        System.out.println("Entries: " + studentMarks.entrySet());

        System.out.println("Size of map: " + studentMarks.size());

        studentMarks.clear();
        System.out.println("Map after clearing: " + studentMarks);
    }
}
