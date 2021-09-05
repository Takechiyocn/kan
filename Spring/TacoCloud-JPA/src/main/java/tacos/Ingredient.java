package tacos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @author kan
 */
// Data注解会添加一个有参构造器
@Data
// NoArgsConstructor注解会移除Data添加的有参构造器，
// 显示添加RequiredArgsConstructor可以确保会生成一个有参构造器
@RequiredArgsConstructor
// NoArgsConstructor注解会添加一个无参构造器
// （因有final字段，所以force设置true以确保Lombok无参构造器会将final字段为null）
//  --> JPA需要实体有一个无参构造器，Lombok的RequiredArgsConstructor注解正好合适
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
// Entity注解：声明为JPA实体
@Entity
public class Ingredient {
    // 确保id为数据库中唯一标识该实体的属性
    @Id
    private final String id;
    private final String name;
    @Enumerated(EnumType.STRING)
    private final Type type;
    public static enum Type {
      WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
