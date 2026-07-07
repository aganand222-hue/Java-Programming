package practicalno.pkg02;

abstract class Student {

    abstract void study();

    void attendClass() {
        System.out.println("Student attends the class.");
    }
}

class EngineeringStudent extends Student {

    @Override
    void study() {
        System.out.println("Engineering student studies Java programming.");
    }
}

public class PracticalNo02 {

    public static void main(String[] args) {

        EngineeringStudent s = new EngineeringStudent();

        s.study();
        s.attendClass();
    }
}