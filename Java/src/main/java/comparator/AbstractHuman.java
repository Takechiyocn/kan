package comparator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author moku
 */
@Getter
@Setter
public abstract class AbstractHuman {

    private final String firstName;
    private final String middleName;
    private final String lastName;

    public AbstractHuman(String lastName, String middleName, String firstName) {
        // 姓
        this.lastName = lastName;
        // 中间名
        this.middleName = middleName;
        // 名
        this.firstName = firstName;
    }

    /**
     * 使用abstract修饰的方法不能有方法体
     *
     * @return 实现类定义的String字符串
     */
    public abstract String getDescription();

    /**
     * 未使用abstract修饰的方法可以有方法体
     * final：不允许子类覆盖这个方法(改变语义，亦即修改name值)
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "AbstractHuman{" +
                "lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
