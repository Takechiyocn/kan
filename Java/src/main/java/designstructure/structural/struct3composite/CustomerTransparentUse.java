package designstructure.structural.struct3composite;

import designstructure.structural.struct3composite.transparent.absclazz.Component;
import designstructure.structural.struct3composite.transparent.Employee;
import designstructure.structural.struct3composite.transparent.Manager;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/22 18:04
 * @Version 1.0
 */
public class CustomerTransparentUse {
    public static void main(String[] args) {

        Component boss = new Manager("老板", "玩！");
        Component hr = new Employee("人力资源", "招聘");
        Component pm = new Manager("产品经理", "管理项目");
        Component cfo = new Manager("财务主管", "管理财务");
        Component cto = new Manager("技术主管", "管理技术");
        Component ui = new Employee("设计师", "设计");
        Component operator = new Employee("运营人员", "运营");
        Component webpg = new Employee("程序员", "干活(前端)");
        Component backpg = new Employee("后端程序员", "干活(后端)");
        Component accountant = new Employee("会计", "干活(财务)");
        Component clerk = new Employee("文员", "瞎逛");
        boss.addComponent(hr);
        boss.addComponent(pm);
        boss.addComponent(cfo);
        pm.addComponent(ui);
        pm.addComponent(cto);
        pm.addComponent(operator);
        cto.addComponent(webpg);
        cto.addComponent(backpg);
        cfo.addComponent(accountant);
        cfo.addComponent(clerk);
        boss.check();
    }
}
