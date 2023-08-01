package logic.algorithms.guide;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/25 23:20
 */
@Slf4j
public class TestMemoryCell {
    public static void main(String[] args) {
        MemoryCell m = new MemoryCell();
        m.write("37");
        // 自动装箱
        m.write(123);
        // m.write(new Integer(123));
        Integer wrapperVal = (Integer) m.read();
        log.info(wrapperVal.toString());
    }
}
