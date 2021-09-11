import java.io.IOException;
import java.util.Arrays;

public class ConcpetOfJava {
    // 类常量：添加public后可在其他类中调用 -> 静态常量
    public static final Double PI = 3.14;

    public static void main(String[] args) throws IOException {
        String greeting = "hello\uD801\uDC37";
        System.out.println(greeting);
        // 代码单元数量
        System.out.println("Code Unit: " + greeting.length());
        // 码点数量，实际长度
        System.out.println("Code Point:" + greeting.codePointCount(0, greeting.length()));

        // 码点
        int index = greeting.offsetByCodePoints(0,1);
        int cp = greeting.codePointAt(index);
        System.out.println(cp);

        // 遍历码点
        int[] codePoints = greeting.codePoints().toArray();
        System.out.println(codePoints[1]);
        // 码点转换成字符串
        String codePointsToString = new String(codePoints, 0, codePoints.length);
        System.out.println(codePointsToString);

        // Java虚拟机启动路径
        System.out.println(System.getProperty("user.dir"));

        // 读文件
//        Scanner in = new Scanner(Paths.get("test.txt"), "UTF-8");
        // 写文件
//        PrintWriter out = new PrintWriter("outFile.txt","UTF-8");

        // 多维数组
        int[][] matrix = {
                {1, 3, 5},
                {2, 4, 6},
                {3, 6, 9}
        };
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.println(value);
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        // 不规则数组
        int [][] odds = new int[10][];
        for (int i = 0; i < 10; i++) {
            odds[i] = new int[i + 1];
        }

        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        // 引用类型，==比较地址
        System.out.println((a == c));
        System.out.println((a == e));

        int t1 = 1;
        final int t2 = 2;
        int t3 = 2;
        int t4 = t2 -1;
        int t5 = t3 - 1;
        System.out.println(t1 == t4);
        System.out.println(t1 == t5);

        // 封装（数据隐藏encapsulation）：将数据和行为组合在一个包中，并对对象的使用者隐藏了数据的实现方式
        // 实例域：对象中的数据成为实例域instance field
        // 对象的当前状态：对于每个特定的类实例（对象）都有一组特定的实例域值，这些值的集合就叫对象的当前状态state

        // 访问器方法accessor method：只访问对象而不修改对象的方法
        //    eg： LocalDate cal = LocalDate.now();  --> 静态工厂方法， 而不用构造器来（new Object类）构造对象
        //         LocalDate calAdd = cal.plusDays(1000);
        //  更改器mutator方法： 使用后对象状态可能会变更


        //   一个方法不能让对象参数引用一个新的对象

        // 重载: 如果多个方法有相同的名字，不同的参数，便产生了重载。
        // 重载解析overloading resolution：对于有产生重载的方法，编译器匹配相应方法的过程
        // 方法签名signature：完整地描述一个方法，需要指出方法名以及参数类型。
        //   ⇒　返回类型不是方法签名的一部分。亦即不能有两个名字相同，参数类型也相同的却返回不同类型值的方法。


        // 包密封：package sealing

        // 类的设计技巧
        //  1. 保证数据私有：亦即不要破坏封装性。如保持实例域的私有性
        //  2. 对数据初始化：提供默认或者在构造器中设置默认值
        //  3. 不要再类中使用过多的基本类型：用其他的类代替多个相关的基本型的使用
        //     如Address新类替换一个Customer类中的street，city，state等信息。以便于增加其他基本信息如国际地址等
        //  4. 不是所有的类都需要独立的域访问器和域更改器
        //     如雇员对象一旦生成就应禁止更改雇佣日期，并且某些不希望别人获得或设置的实例域：Address中存放州缩写的数组
        //  5. 将职责过多的类进行分解
        //     如一副牌的类可拆解为：1.一副牌（洗牌/发牌） 2.单张牌（牌值/花色）
        //  6. 类名和方法要能够体现它们的职责
        //     好的命名类的习惯：
        //       名词（Order）
        //       形容词修饰的名词（RushOrder）
        //       动名词（ing形式）修饰名词（BillingAddress）
        //     方法：
        //       访问器:小写get开头
        //       更改器：小写set开头
        //  7. 优先使用不可变的类
        //     LocalDate类以及java.time包中的其他类是不可变的：没有方法能够修改对象的状态。
        //       -> plusDays方法并不是更改对象，而是返回状态已修改的新对象
        //     --> 多个线程试图同时更新一个对象，就会发生改变

        //  类之间的关系
        //    依赖：uses-a：如果一个类的方法操纵另一个类的对象，我们就说一个类依赖于另一个类
        //        如Order类对象查看用户信用状态需要访问Account类对象，则称Order类依赖于Account类
        //    聚合：has-a：对象包含关系。如Order对象包含一些Item对象
        //    继承：is-a：特殊与一般关系。如RushOrder类由Order继承而来
        //  耦合度减小：将相互依赖的类减至最少。如果类A不知道B的存在，它就不会关心B的任何改变（亦即B的改变不会导致A产生任何bug）
        //

        //  反射：程序在运行期间发现更多的类及其属性的能力
        //

        //  多态：一个对象变量（例如变量e）可以指示多种实际类型的的现象被称为多态polymorphism
        //  动态绑定：运行时能够自动选择调用哪个方法的现象称为动态绑定dynamic binding
        //        --> 调用的方法依赖于隐式参数的实际类型，并且在运行时实现动态绑定
        //  继承层次：由一个公共超类派生出来的所有类的集合被称为继承层次inheritance hierarchy
        //  继承链：从某个特定的类到其祖先的路径被称为该类的继承链inheritance chain
        //  重载解析：枚举目标类（子类）及超类中访问属性为public且名为xxx的方法（超类的私有方法不可访问），
        //           并进行匹配。overloading resolution
        //      --> 如果子类定义了与超类签名相同的方法，则子类方法覆盖超类中相同签名的方法
        //      --> 允许子类将覆盖方法的返回类型定义为原(超类)返回类型的子类型，称这两个方法具有可协变的返回类型
        //  静态绑定：private方法，static方法，final方法或者构造器，编译器可以准确知道应该调用哪个方法
        //  final类：不允许扩展的类被称为final类
        //    --> 1.final类中的所有方法自动地称为final方法，而不包括域
        //    --> 2.可将特定的方法声明为final，则子类就不能覆盖这个方法。
        //    --> 3. 目的：确保他们不会在子类中改变语义
        //  final域：构造对象之后就不允许改变他们的值

        // 内联：如果一个方法没有被覆盖并且很短且被频繁调用，编译器就能够对它进行优化处理，这个过程称为内联inlining

        // 不能构造抽象类的对象。


        // 方法调用过程：
        //    1. 编译器查看对象的声明类型（public等）和方法名。如x.f(param)，x为C类的对象
        //       编译器会列举所有C类中名为f的方法和超类中public类型的f方法，获得候选方法
        //    2. 编译器查看调用方法时提供的参数类型。
        //       选择与提供参数类型完全匹配的方法（这个过程称为重载解析overloading resolution）
        //       允许类型转换，如int-->double，Manager-->Employee
        //    --> 过程1，2即匹配方法签名
        //        子类方法可覆盖超类相同签名(方法名和参数类型)的方法，且子类覆盖的方法的返回类型可为超类返回类型的子类型（即子类对象）
        //         -->public Employee getBuddy(){...}
        //         -->public Manager getBuddy(){...} // 这两个方法具有可协变的返回类型
        //    3. 如果是private，static，final方法或者构造器，编译器可准确知道应该调用哪个方法。称静态绑定
        //       --> 动态绑定：调用的方法依赖于隐式参数的实际类型，并且在运行时实现动态绑定
        //    4. 如果采用动态绑定，虚拟机调用与x所引用对象的实际类型最合适的那个类的方法。
        //       如:x实际类型是D，D为C的子类。如果D定义了该方法，则调用D.f，否则查找超类的C.f
        //    --> 虚拟机为每个类创建方法表method table，列出了方法签名和实际调用的方法。

        // 包装器：wrapper基本类型都有一个与之对应的类。final类型。不能定义子类
        //   Byte，Short，Integer，Long，Float，Double派生于公共超类Number
        //   Character,Boolean
        // 自动装箱：autoboxing。将(类型)值直接添加到包装器实例中，内部进行类型自动转换的过程
        //    ArrayList<Integer> list = new ArrayLst<>();
        //    list.add(3);  --> 自动转换成list.add(Ingeger.valueOf(3));
        // 自动拆箱：自动装箱的逆过程
        //    int n = list.get(i);   --> 自动转换成list.get(i).intValue();
        // Ingeger n = 3;   // 自动装箱
        // n++; // 自动拆箱-->自加-->自动装箱
        // 自动装箱规范将下列范围内的值被装箱到固定对象中，亦即Integer a=100;Integer b=100; a==b：
        //   boolean，byte，char < 127
        //   short,int {-128,127}

        // 当前类名
        //   getClass();   <==> this.getClass();
        //   --> 静态方法没有this，对于静态方法类名的获取：
        //      --> new Object(){}.getClass().getEnclosingClass();


        // TODO：protected使用
        // TODO: 反射/代理/克隆


    }
}
