package util.bigdata.bitMap;

/**
 * TODO
 *
 * @author moku
 * @date 2024/2/7 17:46:49
 * @version 1.0
 */
public class BitMap {
    private byte[] bytes;
    // 最大值
    private int maxValue;
    // 容量
    private int capacity;

    public BitMap(int maxValue) {
        this.maxValue = maxValue;
        // 1bit存储8个数据，存储最大值需maxValue/8+1个byte，即最大值右移3位+1
        this.capacity = maxValue >> 3 + 1;
        bytes = new byte[capacity];
    }
    // https://blog.csdn.net/LJJZJ/article/details/84994653?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-5-84994653-blog-122028608.235^v43^pc_blog_bottom_relevance_base4&spm=1001.2101.3001.4242.4&utm_relevant_index=8
    // https://blog.csdn.net/weixin_28929303/article/details/114858040?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-8-114858040-blog-122028608.235^v43^pc_blog_bottom_relevance_base4&spm=1001.2101.3001.4242.5&utm_relevant_index=11
    // https://www.cnblogs.com/cjsblog/p/11613708.html
}
