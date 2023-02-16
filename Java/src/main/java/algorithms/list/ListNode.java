package algorithms.list;

/**
 * @ClassName ListNode
 * @Description 链表
 * @Author moku
 * @Date 2023/2/16 12:43
 * @Version 1.0
 */
public class ListNode {
    // 节点数据
    int val;
    // 下一个节点对象
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 创建链表
     */
    public ListNode create() {
        // 声明首节点
        ListNode nodeFirst = new ListNode(0);
        // 声明移动节点，创建链表的移动过程中指向当前节点
        ListNode movedNode = nodeFirst;

        for (int i = 1; i < 10; i++) {
            // 生成下一个节点
            ListNode node = new ListNode(i);
            movedNode.next = node;
            movedNode = movedNode.next;
        }

        // 链表创建完成后，移动节点指向首节点
        movedNode = nodeFirst;
        return nodeFirst;
    }

    /**
     * 插入节点
     */
    public void add(ListNode listNode, ListNode newNode, int position) {
        // 保存首节点
        ListNode firstNode = listNode;
        // 寻找插入节点位置
        int i = 0;
        while (listNode != null) {
            // 在指定位置插入节点
            if (i == position) {
                // 保存当前节点的下一个节点
                ListNode node = listNode.next;
                // 插入新节点
                listNode.next = newNode;
                // 新节点的下一结点指向：之前保存的结点
                newNode.next = node;
                break;
            }
            i++;
            listNode = listNode.next;
        }
    }

    /**
     * 替换节点
     */
    public void replace(ListNode listNode, ListNode newNode, int position) {
        // 保存首节点
        ListNode firstNode = listNode;
        // 寻找替换节点位置
        int i = 0;
        while (listNode != null) {
            // 替换指定位置节点
            if (i == (position - 1)) {
                // 保存待替换节点的下一个节点
                ListNode node = listNode.next.next;
                // 切断待替换节点的next指向，等待jvm回收
                listNode.next.next = null;
                // 插入新节点节点
                listNode.next = newNode;
                // 新节点的下一结点指向：之前保存的结点
                newNode.next = node;
                break;
            }
            i++;
            listNode = listNode.next;
        }
    }

    /**
     * 删除节点
     */
    public void delete(ListNode listNode, int position) {
        // 保存首节点
        ListNode firstNode = listNode;
        // 寻找删除节点位置
        int i = 0;
        while (listNode != null) {
            if (i == (position - 1)) {
                // 保存待删除节点的下一个节点
                ListNode node = listNode.next.next;
                // 切断待删除节点的next指向，等待jvm回收
                listNode.next.next = null;
                // 当前节点的下一节点指向删除节点后一节点
                listNode.next = node;
                break;
            }
            i++;
            listNode = listNode.next;
        }
    }

    /**
     * 显示链表
     */
    public void show(ListNode listNode) {
        while (listNode != null) {
            System.out.println("节点数据：" + listNode.val);
            listNode = listNode.next;
        }
    }
}
