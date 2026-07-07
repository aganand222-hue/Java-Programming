package practicalno.pkg02;

interface Student {
    void study();
    void attendClass();
}

class EngineeringStudent implements Student {

    @Override
    public void study() {
        System.out.println("BSc CS studies Java programming.");
    }

    @Override
    public void attendClass() {
        System.out.println("BSc CS student attends the class.");
    }
}

public class PracticalNo02 {
    public static void main(String[] args) {
        Student s = new EngineeringStudent();
        s.study();
        s.attendClass();
    }
}