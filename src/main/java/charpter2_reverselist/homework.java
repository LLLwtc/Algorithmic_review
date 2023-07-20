package charpter2_reverselist;

public class homework {
    public static void main(String[] args) {

        ListNode listNode = init();
        ListNode res = split(listNode);

        while (res != null) {
            System.out.println(res.data);
            res = res.next;
        }
    }

    /**
     * 拆分链表，使用头插法，拆分出来的链表2无需反转
     *
     * @param head1
     */
    static ListNode split(ListNode head1) {

        ListNode tmp = head1;
        ListNode dummyNode = new ListNode(-1);

        //判断换偶数位节点是否为空
        while (tmp.next != null && tmp.next.next != null) {
            //不为空，拆分链表
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;

            node1.next = dummyNode.next;
            tmp.next = node2;
            dummyNode.next = node1;

            tmp = node2;//跳到奇数位节点
        }

        //将最后一个节点拆分到链表2
        ListNode finalNode = tmp.next;
        finalNode.next = dummyNode.next;
        dummyNode.next = finalNode;
        tmp.next = null;

        //合并链表1和链表2
        ListNode res = merge(head1, dummyNode);
        return res;
    }

    /**
     * 合并链表
     *
     * @param head1
     * @param dummyNode
     */
    private static ListNode merge(ListNode head1, ListNode dummyNode) {
        ListNode tmp1 = head1;
        ListNode tmp2 = dummyNode.next;

        while (tmp1.next != null && tmp2.next != null) {
            ListNode tmp1_next = tmp1.next;
            ListNode tmp2_next = tmp2.next;

            tmp1.next = tmp2;
            tmp2.next = tmp1_next;
            tmp1 = tmp1_next;
            tmp2 = tmp2_next;
        }
        //合并剩余的尾节点
        tmp1.next = tmp2;

        return head1;
    }

    public static ListNode init() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(10);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = null;

        return listNode1;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}
