package multithread;

/**
 * 传递性：如果A happens-before B, B happens-before C，那 A happens-before C
 *  x并不需要定义为volatile, 程序里可以有需要类似x的变量，我们只需要一个volatile变量b来确保线程a能看到线程1对x的修改：
 *    1.根据代码顺序规则，线程1的x=5; happens-before b=1;; 线程2的int dummy = b; happens-before while(x!=5);
 *    2.根据volatile变量规则，线程2的b=1; happens-before int dummy=b;
 *    3.根据传递性，x=5; happens-before while(x!=5);
 */
class VolatileExample {
    int x = 0;
    volatile int b = 0;

    private void write() {
        x = 5;
        b = 1;
    }

    private void read() {
        int dummy = b;
        while (x != 5) {
        }
        System.out.println(x);
        System.out.println(b);
        System.out.println(dummy);
    }

    public static void main(String[] args) throws Exception {
        final VolatileExample example = new VolatileExample();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                example.write();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                example.read();
            }
        });
        thread1.start();
        thread2.start();
        // 主线程挂起，等待线1程正常终了
        thread1.join();
        // 主线程挂起，等待线2程正常终了
        thread2.join();
    }
}