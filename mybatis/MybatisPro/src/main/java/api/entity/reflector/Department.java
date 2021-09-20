package api.entity.reflector;

import java.util.List;

public class Department {

    private Long id;
    private String name;

    // 以部门为中心：一个部门对应多个与员工，一对多关系
    private List<Employee> emps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }
}
