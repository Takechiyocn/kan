package logic.comparator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author moku
 */
@Setter
@Getter
public class Person extends AbstractHuman {
    private final Integer age;

    public Person(String lastName, String middleName, String firstName,int age) {
        super(lastName, middleName, firstName);
        this.age = age;
    }

    public Person(String lastName, int age) {
        super(lastName, null, null);
        this.age = age;
    }

    public Person(String lastName) {
        super(lastName, null, null);
        this.age = 0;
    }

    @Override
    public String getDescription() {
        return super.toString() + "," + this.toString();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
