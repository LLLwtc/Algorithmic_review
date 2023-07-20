//package charpter2_reverselist;
//
//public class Swap_two_adjacent_nodes {
//
//    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=null;
//
//        ListNode res = listNode1.swapPairs(listNode1);
//
//        ListNode tmp=res;
//        while(tmp!=null){
//            System.out.println(tmp.data);
//            tmp=tmp.next;
//        }
//    }
//}
//
//class ListNode {
//
//    int data;
//    ListNode next;
//
//    public ListNode(int data) {
//        this.data = data;
//    }
//
//    public ListNode swapPairs(ListNode head) {
//
//        ListNode dummyNode = new ListNode(0);
//        dummyNode.next = head;
//        ListNode temp = dummyNode;
//
//        while (temp.next != null && temp.next.next != null) {
//            ListNode node1 = temp.next;
//            ListNode node2 = temp.next.next;
//            temp.next = node2;//虚拟头结点->2
//            node1.next = node2.next;//1->3
//            node2.next = node1;//2->1
//            temp = node1;
//        }
//        return dummyNode.next;
//    }
//}