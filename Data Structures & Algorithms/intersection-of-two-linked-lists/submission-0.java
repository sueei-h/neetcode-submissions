/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		ListNode head1 = headA;
		ListNode head2 = headB;
		int length1 = 0;
		int length2 = 0;

		while (head1 != null) {
			head1 = head1.next;
			length1++;
		}

		while (head2 != null) {
			head2 = head2.next;
			length2++;
		}

		head1 = headA;
		head2 = headB;

		if (length1 > length2) {
			for (int i = 0; i < length1 - length2; i++) {
				head1 = head1.next;
			}
		} else if (length1 < length2) {
			for (int i = 0; i < length2 - length1; i++) {
				head2 = head2.next;
			}
		}

		while (head1 != null && head2 != null) {
			if (head1 == head2) {
				return head1;
			}

			head1 = head1.next;
			head2 = head2.next;
		}

		return null;
	}
}