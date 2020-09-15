public class LinkedList {
    private ListNode head;

    public ListNode insert(int key, ListNode a) {
        ListNode ln = new ListNode(key);
        if(null != a.prev) {
            ln.prev = a.prev;
            a.prev = ln;
            ln.next = a;
            ln.prev.next = ln;

        }
        else {
            head = ln;
            ln.next = a;
            a.prev = ln;
        }
        return ln;
    }

    public ListNode delete(ListNode x) {
        if(null != x.prev) {
            x.prev.next = x.next;
        }
        else {
            head = x.next;
        }
        if(null != x.next) {
            x.next.prev = x.prev;
        }
        return x;
    }

    public ListNode search(int key) {
        ListNode i = head;
        while(i != null && i.key != key) {
            i = i.next;
        }
        return i;
    }
}
