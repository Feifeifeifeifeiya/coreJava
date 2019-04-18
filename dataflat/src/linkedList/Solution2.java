package linkedList;

public class Solution2 {
    public ListNode removeElement(ListNode head,int val){
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        while(dummyNode.next!=null){
            if(dummyNode.next.val==val){
                dummyNode.next=dummyNode.next.next;
            }else{
                dummyNode=dummyNode.next;
            }
        }
        return head;
    }


}
