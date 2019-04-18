package linkedList;

public class ListNode {

    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }

    public ListNode(int[] arr){
        if(arr==null){
            throw new IllegalArgumentException("数组为空");
        }
        this.val=arr[0];
        ListNode cur=this;
        for(int i=0;i<arr.length;i++){
            cur.next=new ListNode(arr[i]);
            cur=cur.next;
        }
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        ListNode cur=this;
        sb.append("head：[");
        while(cur!=null){
            sb.append(cur.val+"->");
            cur=cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
