package occupation;

import logic.occupation.Employee;
import logic.occupation.Manager;

/**
 * This program demonstrates the equals method.
 * @version 1.12 2012-01-26
 * @author Cay Horstmann
 */
public class ObjectEqualsTest
{
   public static void main(String[] args)
   {
      Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
      Employee alice2 = alice1;
      Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
      Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

      System.out.println("alice1 == alice2: " + (alice1 == alice2));

      System.out.println("alice1 == alice3: " + (alice1 == alice3));

      System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));

      System.out.println("alice1.equals(bob): " + alice1.equals(bob));

      System.out.println("bob.toString(): " + bob);

      Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      Employee tom = new Employee("Alice Adams", 75000, 1987, 12, 15);
      System.out.println("boss getClass: " + carl.getClass());
      System.out.println("employee getClass: " + boss.getClass());
      boss.setBonus(5000);
      carl.setBonus(2000);
      System.out.println("boss.toString(): " + boss);
      System.out.println("carl.equals(boss): " + carl.equals(boss));
      // 如果不重写Object.equals方法而是另外生成Employee.equals(Employee other)和Manager.equals(XXX other)方法，
      // 则根据动态绑定，下面可能会调用到超类的方法，而不是预想的子类方法
      System.out.println("carl.equals(tom): " + carl.equals(tom));
      System.out.println("alice1.hashCode(): " + alice1.hashCode());
      System.out.println("alice3.hashCode(): " + alice3.hashCode());
      System.out.println("bob.hashCode(): " + bob.hashCode());
      System.out.println("carl.hashCode(): " + carl.hashCode());
      System.out.println("boss.hashCode(): " + boss.hashCode());
      System.out.println("tom.hashCode(): " + tom.hashCode());
   }
}