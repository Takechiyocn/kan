package test;

/**
 * @ClassName Test
 * @Description
 * @Author moku
 * @Date 2023/2/4 21:57
 * @Version 1.0
 */
public class Test {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public Test(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFul() {
        return rear == maxSize - 1;
    }

    public void add(int n) {
        if (isFul()) {
            return;
        }
        arr[rear++] = n;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return arr[front++];
    }

    public int size() {
        return rear - front;
    }

    public void show() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }



    public static void main(String[] args) {
        Test test = new Test(5);
        int[] arr = {1, 5, 6, 2, 3, 7, 4};

    }
}
