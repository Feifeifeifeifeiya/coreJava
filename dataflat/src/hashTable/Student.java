package hashTable;

import java.util.Objects;

public class Student {
    private int gradle;
    private int cls;
    private String firstName;
    private String lastName;

    public Student(int gradle, int cls, String firstName, String lastName) {
        this.gradle = gradle;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return gradle == student.gradle &&
                cls == student.cls &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        int B=31;
        int hash=0;
        hash=hash*B+gradle;
        hash=hash*B+cls;
        hash=hash*B+firstName.toLowerCase().hashCode();
        hash=hash*B+lastName.toLowerCase().hashCode();
        return hash;
    }
}
