package logic.algorithms.list;

/**
 * @ClassName ListNode
 * @Description 单向链表
 * @Author moku
 * @Date 2023/2/16 12:43
 * @Version 1.0
 */
class ListNode {
    // 节点数据
    public int val;
    // 下一个节点对象，默认null
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class ListNodeImpl {
    private ListNode head = null;

    /**
     * 添加节点
     */
    public boolean add(int n) {
        ListNode newNode = new ListNode(n);
        if (head == null) {
            head = newNode;
            return true;
        }

        // 保存当前移动节点
        ListNode cur = head;
        // 寻找插入节点位置
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;

        return true;
    }

    /**
     * 删除节点
     */
    public boolean delete(int val) {
        if (head == null) {
            return false;
        }

        // 删除头节点
        if (head.val == val) {
            head = head.next;
            return true;
        }

        // 删除其他节点
        // 保存当前移动节点
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                return true;
            }
        }

        return false;
    }

    /**
     * 查找节点值返回下标
     */
    public int find(int val) {
        // 头节点
        if (head == null) {
            return -1;
        }
        if (head.val == val) {
            return 0;
        }

        ListNode cur = head;
        int idx = 0;
        // 此处头节点不为空
        while (cur.next != null) {
            if (cur.val != val) {
                idx++;
                cur = cur.next;
            } else {
                return idx;
            }
        }

        return -1;
    }

    /**
     * 用下标查找节点
     */
    public ListNode get(int idx) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 链表长度
     */
    public int size() {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    /**
     * 显示链表
     */
    public void show() {
        ListNode cur = head;
        while (cur != null) {
            System.out.println("节点数据：" + cur.val);
            cur = cur.next;
        }
    }
}
