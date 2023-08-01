package logic.algorithms.guide;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/25 23:21
 */
public class MemoryCell {
    public Object read() {
        return storedValue;
    }
    public void write(Object x){
        storedValue = x;
    }
    private Object storedValue;
}
