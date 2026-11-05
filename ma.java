class Student {
    private String usn;
    private String name;
    private int m1, m2, m3;

    static int count = 0;
    final int MAX_MARKS = 100;

    Student(String usn, String name, int m1, int m2, int m3) {
        this.usn = usn;
        this.name = name;

        if (validate(m1) && validate(m2) && validate(m3)) {
            this.m1 = m1;
            this.m2 = m2;
            this.m3 = m3;
        } else {
            System.out.println("Invalid marks!");
        }

        count++;
    }

    boolean validate(int marks) {
        return marks >= 0 && marks <= MAX_MARKS;
    }

    public String getUsn() {
        return usn;
    }

    public String getName() {
        return name;
    }

    int calculateTotal() {
        return m1 + m2 + m3;
    }

    double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    void display() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
    }

    void display(boolean result) {
        display();
        System.out.println("Total: " + calculateTotal());
        System.out.println("Average: " + calculateAverage());
    }

    Result getResult() {
        return new Result(name, calculateTotal(), calculateAverage());
    }

    class Result {
        String studentName;
        int total;
        double average;

        Result(String studentName, int total, double average) {
            this.studentName = studentName;
            this.total = total;
            this.average = average;
        }

        void showResult() {
            System.out.println("Result Summary");
            System.out.println("Name: " + studentName);
            System.out.println("Total: " + total);
            System.out.println("Average: " + average);
        }
    }
}

public class ma{
    public static void main(String[] args) {

        Student s1 = new Student("101", "Mohan", 85, 90, 80);
        Student s2 = new Student("102", "Rahul", 75, 80, 85);

        System.out.println("Student Details:");
        s1.display();

        System.out.println("\nStudent Result:");
        s1.display(true);

        System.out.println("\nNew Result Object:");
        Student.Result r = s1.getResult();
        r.showResult();

        System.out.println("\nTotal Students: " + Student.count);
    }
}