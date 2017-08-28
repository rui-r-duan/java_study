import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    PriorityQueue<Student> pq;

    public Priorities() {
        pq = new PriorityQueue<>(Comparator.comparing(Student::getCGPA).reversed()
        .thenComparing(Student::getName).thenComparing(Student::getID));
    }

    public List<Student> getStudents(List<String> events) {
        for (String evt : events) {
            String op;
            String name;
            double cgpa;
            int id;
            String[] words = evt.split(" ");
            op = words[0];
            if (op.equals("ENTER")) {
                name = words[1];
                cgpa = Double.parseDouble(words[2]);
                id = Integer.parseInt(words[3]);
                Student student = new Student(id, name, cgpa);
                pq.add(student);
            }
            else if (op.equals("SERVED")) {
                Student s = pq.poll();
            }
        }
        Student[] stuArray = pq.toArray(new Student[0]);
        Arrays.sort(stuArray, pq.comparator());
        return Arrays.asList(stuArray);
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
