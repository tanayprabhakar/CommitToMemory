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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        int index = 1;
        int[] result = {-1, -1};

        while (temp != null && temp.next != null && temp.next.next != null) {
            ListNode prev = temp;
            ListNode curr = temp.next;
            ListNode next = temp.next.next;

            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {
                list.add(index);
            }

            temp = temp.next;
            index++;
        }

        int n = list.size();
        if (n < 2) {
            return result;
        }

        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            minDistance = Math.min(minDistance, list.get(i) - list.get(i - 1));
        }

        int maxDistance = list.get(n - 1) - list.get(0);

        result[0] = minDistance;
        result[1] = maxDistance;

        return result;
    }
}
