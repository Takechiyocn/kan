package occupation;

import interfacecustomize.AnotherNamed;
import interfacecustomize.Named;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/27 23:04
 */
public class Teacher implements Named, AnotherNamed {
    private final String school;

    public Teacher(String school) {
        this.school = school;
    }

    @Override
    public String getName() {
        return AnotherNamed.super.getName();
    }

    @Override
    public String getDescription() {
        return "A teacher in " + school +  " High School.";
    }
}
