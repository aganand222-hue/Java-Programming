package practicalno_2b;

interface Student {
    void study();
    void attendClass();
}

class EngineeringStudent implements Student {

    @Override
    public void study() {
        System.out.println("BSc CS student studies Java programming.");
    }

    @Override
    public void attendClass() {
        System.out.println("BSc CS student attends the class.");
    }
}

public class PracticalNo_2B {

    public static void main(String[] args) {

        Student s = new EngineeringStudent();

        s.study();
        s.attendClass();
    }
}