package api.entity.reflector;

/**
 * N + 1方式：
 * N+1：N 就是当前需要查询结果对应发送的SQL语句的条数
 * +1：关联查询数据需要额外多发一条SQL语句才能查询出对应的结果
 */
public class Employee {

    private Long id;
    private String name;
    private Long deptId;
    // 以员工为中心：多个员工对应一个部门，多对一关系，many2noe
    private Department dept;

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

    public Long getDept_id() {
        return deptId;
    }

    public void setDept_id(Long deptId) {
        this.deptId = deptId;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
