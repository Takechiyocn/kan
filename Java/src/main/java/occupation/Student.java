package occupation;

import abstclass.Person;
import interfacecustomize.Named;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/16 0:57
 */
public class Student extends Person implements Named {
    private final String major;
    private final String middleName;
    private final String lastName;

    public Student(String name, String middleName, String lastName, String major) {
        super(name);
        this.middleName = middleName;
        this.lastName = lastName;
        this.major = major;
    }

    public Student(String name, String major) {
        super(name);
        this.middleName = null;
        this.lastName = null;
        this.major = major;
    }

    public Student(String name) {
        super(name);
        this.middleName = null;
        this.lastName = null;
        this.major = "NULL";
    }

    public String getMajor() {
        return major;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String getDescription() {
        return major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
