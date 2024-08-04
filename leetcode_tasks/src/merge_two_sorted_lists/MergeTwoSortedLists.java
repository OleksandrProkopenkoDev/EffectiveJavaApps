package merge_two_sorted_lists;

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] ints1 = {1, 2, 4};
        int[] ints2 = {1, 3, 4, 5, 7,45};
        ListNode list1 = fillListNode(ints1);
        ListNode list2 = fillListNode(ints2);
        printNode(list1);
        printNode(list2);

//        ListNode merged = mergeTwoLists(list1, list2);
        ListNode merged = mergeTwoListsV2(list1, list2);
        printNode(merged);
    }

    private static ListNode mergeTwoListsV2(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode();
        ListNode head = answer;

        while(list1 != null && list2 != null){
            if (list1.val <= list2.val){
                answer.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                answer.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            answer = answer.next;
        }

        while (list1 != null){
            answer.next = new ListNode(list1.val);
            list1 = list1.next;
            answer = answer.next;
        }

        while (list2 != null){
            answer.next = new ListNode(list2.val);
            list2 = list2.next;
            answer = answer.next;
        }


        return head.next;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;
        if(list1.val >= list2.val){
            head = list2;
            head.next = list1;
            list2 = list2.next;
            list1 = list1.next;
        }else {
            head = list1;
            head.next = list2;
            list2 = list2.next;
            list1 = list1.next;
        }

        while(list1 != null || list2.next != null){
            if(list1 == null){
                tail.next = list2;
                continue;
            }
            if(list1.val >= list2.val){
                tail = list2;
                tail.next = list1;
                list2 = list2.next;
                list1 = list1.next;
            }else {
                tail = list1;
                tail.next = list2;
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        return head;
    }

    private static void printNode(ListNode list) {
       ListNode node = list;
        System.out.print("[");
        while (node.next != null){
            System.out.print(node.val+", ");
            node = node.next;
        }
        System.out.println(node.val+"]");
    }

    private static ListNode fillListNode(int[] ints) {
        ListNode tail = null;
        ListNode head = null;
        if(ints.length>0) {
            tail = head = new ListNode(ints[0]);
        }
        for (int i = 1; i < ints.length; i++) {
            tail.next = new ListNode(ints[i]);
            tail = tail.next;
        }
        return head;
    }
}
