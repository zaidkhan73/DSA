/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow.next);

        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean isPalindrome = true;
        while(p2 != null){
            if (p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        slow.next = reverseList(secondHalf);

        return isPalindrome;

    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode nextTemp = head.next;
        head.next = prev;      
        prev = head;
        head = nextTemp;
        }
        return prev;
    }
}