package p876;

public class LinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode currentNode = head;
        ListNode middleNode = head;
        int size = 1;

        while (currentNode.next != null) {
            size++;
            currentNode = currentNode.next;
            if (size % 2 == 0) {
                middleNode = middleNode.next;
            }
        }

        return middleNode;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
