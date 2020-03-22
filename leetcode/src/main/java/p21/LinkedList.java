package p21;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode rootNode = null;
        ListNode currentNode = null;
        ListNode currentLeftNode = l1;
        ListNode currentRightNode = l2;

        while (currentLeftNode != null || currentRightNode != null) {
            if (rootNode == null) {
                rootNode = new ListNode(0);
                currentNode = rootNode;
            }

            if (currentLeftNode == null)  {
                currentNode.next = currentRightNode;
                return rootNode.next;
            }
            if (currentRightNode == null) {
                currentNode.next = currentLeftNode;
                return rootNode.next;
            }

            if (currentLeftNode.val <= currentRightNode.val) {
                currentNode.next = new ListNode(currentLeftNode.val);
                currentNode = currentNode.next;
                currentLeftNode = currentLeftNode.next;
            } else {
                currentNode.next = new ListNode(currentRightNode.val);
                currentNode = currentNode.next;
                currentRightNode = currentRightNode.next;
            }
        }

        if (rootNode == null) {
            return null;
        }

        return rootNode.next;
    }
}
