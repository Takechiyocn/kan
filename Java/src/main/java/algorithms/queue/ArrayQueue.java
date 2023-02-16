package algorithms.queue;

/**
 * @ClassName ArrayQueue
 * @Description
 * @Author moku
 * @Date 2023/2/16 1:03
 * @Version 1.0
 */
public class ArrayQueue {
    // 数组最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 存储数据，模拟队列
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        // 指向队列头的前一个位置
        front = -1;
        // 指向队列尾
        rear = -1;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }


    /**
     * 判断队列是否满
     */
    public boolean isFul() {
        // 数组下标从0开始
        return rear == maxSize - 1;
    }

    /**
     * 队列中有效数据个数
     */
    public int size() {
        return rear - front;
    }

    /**
     * 队列中添加数据：队列尾添加，生产者
     */
    public void add(int n) {
        if (isFul()) {
            System.out.println("队列满");
            return;
        }
        arr[++rear] = n;
    }

    /**
     * 队列中删除数据：队列头删除，消费者
     */
    public int remove() throws Exception {
        if (isEmpty()) {
            System.out.println("队列空");
            throw new Exception("队列空无法获取数据");
        }
        return arr[++front];
    }

    /**
     * 显示队列中所有元素
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }

        // 队列先进先出FIFO，尽量不用增强for循环
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue queue = new ArrayQueue(5);
        // 判空
        System.out.println("isEmpty：" + queue.isEmpty());
        // 空队列删除
//        queue.delete();
        // 空队列增加元素
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(0);
        queue.add(1);
        // 队列满，无法增加元素
//        queue.add(2);
        queue.show();
    }
}
