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
		if (head == null || head.next == null) {
			return true;
		}

		ListNode slow, fast;
		slow = fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode second = reverse(slow);
		ListNode secondHead = second;
		ListNode first = head;

		boolean check = true;

		while (second != null) {
			if (first.val != second.val) {
				check = false;
				break;
			}

			first = first.next;
			second = second.next;
		}

		reverse(secondHead);
		return check;
	}

	private ListNode reverse(ListNode head) {
		ListNode curr, prev, next;
		curr = head;
		prev = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}
}