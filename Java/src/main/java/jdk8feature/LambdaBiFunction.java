package jdk8feature;

import occupation.Employee;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class LambdaBiFunction {
    public static void main(String[] args) {
        Employee[] staff = new Employee[6];
        staff[0] = new Employee("Carl", 90000, 2000, 10, 1);
        staff[1] = new Employee("Harry", 85000, 2001, 10, 1);
        staff[2] = new Employee("Alice", 50000);
        staff[3] = new Employee("Alice", 60000);
        staff[4] = new Employee(60000);
        staff[5] = new Employee();
        ArrayList<Employee> staffList = new ArrayList<>(Arrays.asList(staff));

        LambdaBiFunction lambdaBiFunction = new LambdaBiFunction();

        // 1.lambda表达式处理list：姓名
        List<Employee> nameList = lambdaBiFunction.getEmployeeByName("Alice", staffList);
        System.out.println(nameList);

        // 2.lambda表达式处理list：薪资
        List<Employee> salaryList = lambdaBiFunction.getEmployeeByFixedSalaryUseLambda(85000, staffList);
        System.out.println(salaryList);

        // 3、函数式接口biFunction处理list
        List<Employee> salaryList2 = lambdaBiFunction.getEmployeeByFixedSalary(85000, staffList);
        System.out.println(salaryList2);

        // 4、函数式接口biFunction处理list（调用处定义比较方法：大于）
        List<Employee> salaryListBigger = lambdaBiFunction.getEmployeeBiggerThanSalary(85000, staffList);
        System.out.println(salaryListBigger);

        // 5、函数式接口biFunction处理list（调用处定义比较方法：小于）
        List<Employee> salaryListSmaller = lambdaBiFunction.getEmployeeSmallerThanSalary(85000, staffList);
        System.out.println(salaryListSmaller);

        // 6、函数式接口biFunction处理list（调用处定义比较方法：等于）
        List<Employee> salaryListEqual = lambdaBiFunction.getEmployeeEqualSalary(85000, staffList);
        System.out.println(salaryListEqual);
    }

    /**
     * lambda表达式处理list
     *
     * @param name
     * @param employeeList
     * @return
     */
    public List<Employee> getEmployeeByName(String name, List<Employee> employeeList) {
        if (StringUtils.isBlank(name)) {
            return new ArrayList<Employee>();
        } else {
            // 获取名字一致的职员列表
            return employeeList.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList());
        }
    }

    /**
     * lambda表达式处理list
     *
     * @param salary
     * @param employeeList
     * @return
     */
    public List<Employee> getEmployeeByFixedSalaryUseLambda(double salary, List<Employee> employeeList) {
        // 获取薪资一致的职员列表
        return employeeList.stream().filter(e -> Double.compare(e.getSalary(), salary) >= 0).collect(Collectors.toList());
    }

    /**
     * 函数式接口biFunction处理list（不能显示表示出BiFunction为函数式接口）
     *
     * @param salary
     * @param staffList
     * @return
     */
    public List<Employee> getEmployeeByFixedSalary(double salary, List<Employee> staffList) {
        BiFunction<Double, List<Employee>, List<Employee>> listBiFunction =
                (salaryOfEmployee, employeeList) ->
                        employeeList.stream().filter(employee -> Double.compare(employee.getSalary(), salaryOfEmployee) >= 0).collect(Collectors.toList());
        return listBiFunction.apply(salary, staffList);
    }

    /**
     * 函数式接口biFunction处理list(调用处定义比较方法：大于，小于)
     *
     * @param salary
     * @param staffList
     * @param listBiFunction
     * @return
     */
    public List<Employee> getEmployeeSalaryBase(double salary, List<Employee> staffList, BiFunction<Double, List<Employee>, List<Employee>> listBiFunction) {
        return listBiFunction.apply(salary, staffList);
    }

    /**
     * Dynamic salary bigger than specified
     *
     * @param salary
     * @param staffList
     * @return
     */
    public List<Employee> getEmployeeBiggerThanSalary(double salary, List<Employee> staffList) {
        return getEmployeeSalaryBase(salary, staffList,
                (salaryOfEmployee, staffListInside) ->
                        staffListInside.stream().filter(staff1 -> (Double.compare(staff1.getSalary(), salaryOfEmployee) > 0)).collect(Collectors.toList()));
    }

    /**
     * Dynamic salary smaller than specified
     *
     * @param salary
     * @param staffList
     * @return
     */
    public List<Employee> getEmployeeSmallerThanSalary(double salary, List<Employee> staffList) {
        return getEmployeeSalaryBase(salary, staffList,
                (salaryOfEmployee, staffListInside) ->
                        staffListInside.stream().filter(staff1 -> (Double.compare(staff1.getSalary(), salaryOfEmployee) < 0)).collect(Collectors.toList()));
    }

    /**
     * Dynamic salary equal than specified
     *
     * @param salary
     * @param staffList
     * @return
     */
    public List<Employee> getEmployeeEqualSalary(double salary, List<Employee> staffList) {
        return getEmployeeSalaryBase(salary, staffList,
                (salaryOfEmployee, staffListInside) ->
                        staffListInside.stream().filter(staff1 -> (Double.compare(staff1.getSalary(), salaryOfEmployee) == 0)).collect(Collectors.toList()));
    }
}
