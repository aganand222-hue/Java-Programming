class StudentB {

    void display() {
        System.out.println("Anand Ramesh Vishwakarma");
    }
}

class EngineeringStudentB extends StudentB {

    @Override
    void display() {
        System.out.println("Shravan Ramesh Vishwakarma");
    }
}

public class B {
    public static void main(String[] args) {
        EngineeringStudentB s = new EngineeringStudentB();
        s.display();
    }
}
