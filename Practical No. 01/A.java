class StudentA {
    int id;
    String name;

    StudentA() {
        id = 0;
        name = "Unknown";
        System.out.println("F120 Shravan Ramesh Vishwakarma");
    }

    StudentA(int i, String n) {
        id = i;
        name = n;
        System.out.println("Java is best for DSA");
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    void show() {
        System.out.println("No parameters method");
    }

    void show(int x) {
        System.out.println("Integer parameter: " + x);
    }

    void show(String msg) {
        System.out.println("String parameter: " + msg);
    }

    static void collegeName() {
        System.out.println("College: MVLU College of Science");
    }
}

public class A {
    public static void main(String[] args) {

        StudentA.collegeName();

        StudentA s1 = new StudentA();
        s1.display();

        StudentA s2 = new StudentA(120, "Shravam");
        s2.display();

        s2.show();
        s2.show(50);
        s2.show("Hello Java");
    }
}
