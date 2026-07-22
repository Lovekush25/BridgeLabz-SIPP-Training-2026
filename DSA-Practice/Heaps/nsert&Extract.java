import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class Main {

    static PriorityQueue<Patient> triageQueue =
            new PriorityQueue<>((a, b) -> b.severity - a.severity);

    static void addPatient(Patient p) {
        triageQueue.offer(p);
    }

    static Patient treatNext() {
        return triageQueue.poll();
    }

    public static void main(String[] args) {

        addPatient(new Patient("A", 5));
        addPatient(new Patient("B", 10));
        addPatient(new Patient("C", 7));

        while (!triageQueue.isEmpty()) {
            Patient p = treatNext();
            System.out.println(p.name + " " + p.severity);
        }
    }
}