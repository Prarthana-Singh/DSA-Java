class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}
class Singloten{
 static Node head;

    public static void main(String[] args) {
     insert(1);
        insert(2);
      //  insert(2);
        //insert(1);
        print();
        System.out.println(isPalindrome(head));
       }
       static void print(){
        Node temmp=head;
        while (temmp!=null){
            System.out.print(temmp.data+"->");
            temmp=temmp.next;
        }
           System.out.print("null");
       }

        static void insert(int data){
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
        }
    public static boolean isPalindrome(Node head) {
        if(head == null || head.next==null){
            return true;
        }
        Node slow = head;
        Node fast=head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node curr = slow;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while(right != null){
            if(right.data != left.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }