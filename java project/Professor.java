import java.time.LocalDate;
public class Professor {
    private String name;
    private String surname;
    private int am;
    private String[] courses;
    private LocalDate[] examDates;
    public Professor(String name, String surname, int am, String[] courses) {
        this.name=name;
        this.surname=surname;
        this.am=am;
        this.courses=courses;
        this.examDates = new LocalDate[courses.length];
        }
        public void assignExamDate(int index, LocalDate date) {
            if (index >= 0 && index < courses.length) {
                examDates[index] = date;
            }
        }
        public void displayInformation() {
            System.out.println("Όνομα καθηγητή:" + name);
            System.out.println("Επίθετο καθηγητή:" + surname);
            System.out.println("Αριθμός Μητρώου Καθηγητή:" + am);
            System.out.println("Μαθήματα και ημερομηνίες εξέτασης:");
            for (int i=0; i < courses.length; i++) {
                System.out.println("-" + courses[i] + ":" + (examDates[i]!= null ? examDates[i] : "Not set"));
            }
        }
}