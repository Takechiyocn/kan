package logic.algorithms.queue;

/**
 * @ClassName ArrayCircleQueue
 * @Description 数组实现环形队列
 * @Author moku
 * @Date 2023/2/16 9:29
 * @Version 1.0
 */
public class ArrayCircleQueue {
    // 最大容量
    private final int maxSize;
    // 默认为0
    private int start;
    // 默认为0，指向空元素位置，end+1指向start
    private int end;
    private int arr[];

    public ArrayCircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return start == end;
    }

    /**
     * 判断队列是否满
     */
    public boolean isFul() {
        return (end + 1) % maxSize == start;
    }

    /**
     * 队列中有效数据个数
     */
    public int size() {
        return (end + maxSize - start) % maxSize;
    }

    /**
     * 队列中添加数据：队列尾添加，生产者
     */
    public void add(int n) {
        if (isFul()) {
            System.out.println("队列满");
            return;
        }
        arr[end] = n;
        end = (end + 1) % maxSize;
    }

    /**
     * 队列中删除数据：队列头删除，消费者
     */
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列空无法获取数据");
        }
        int temp = arr[start];
        start = (start + 1) % maxSize;
        return temp;
    }

    /**
     * 显示队列中所有元素
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("队列空无法显示");
            return;
        }

        for (int i = 0; i < start + size(); i++) {
            System.out.printf("arr[%d]=%d", i % maxSize, arr[i % maxSize]);
        }
    }
}
