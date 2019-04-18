package linkedList;

public class Solution {
    public ListNode removeElement(ListNode head, int val){
        while (head!=null&&head.val==val){
            ListNode delNode=head;
            head=head.next;
            delNode.next=null;
        }
        //也有可能这个链表里面全是这个元素val
        if(head==null){
            return null;
        }
        ListNode pre=head;
        while (pre.next!=null){
            if(pre.next.val==val){
                ListNode delNode=pre.next;
                pre.next=delNode.next;
                delNode.next=null;
            }else{
                pre=pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] cur={1,2,3,4,5,6,7,8,9};
        ListNode listNode = new ListNode(cur);
        System.out.println(listNode);
        Solution solution = new Solution();
        ListNode listNode1 = solution.removeElement(listNode, 2);
        System.out.println(listNode);

    }
}
