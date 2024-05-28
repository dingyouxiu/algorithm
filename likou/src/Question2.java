package src;

import javax.xml.ws.soap.Addressing;

/**
 * 力扣第二题 两数之和
 */
public class Question2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        Integer carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            Integer sum1 = l1 == null ? 0 : l1.val;
            Integer sum2 = l2 == null ? 0 : l2.val;
            Integer sum = sum1 + sum2 + carry;
            carry = sum / 10;
            Integer takeover = sum % 10;
            temp.next = new ListNode(takeover);
            temp = temp.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return listNode.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

