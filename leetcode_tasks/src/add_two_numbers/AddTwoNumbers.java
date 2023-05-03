package add_two_numbers;

public class AddTwoNumbers {

	public static void main(String[] args) {
		
		ListNode l1 = generateNode(1);
		ListNode l2 = generateNode(1);
		ListNode result = addTwoNumbers(l1, l2);
		System.out.print("l1: "); printNode(l1);
		System.out.print("l2: "); printNode(l2);
		System.out.print("sum:"); printNode(result);
		result = addTwoNumbersMalik(l1, l2);
		System.out.print("Mal:"); printNode(result);
	}
	
	static void printNode(ListNode node) {
		System.out.print("["+node.val);
		while(node!=null) {
			System.out.print(", "+node.val);
			node = node.next;
		}
		System.out.println("]");
	}
	
	static ListNode generateNode(int digits) {
		int val = (int)Math.round(Math.random()*10);
		if (val == 10) val = 0;
		
		ListNode result = new ListNode( val);
		ListNode current = new ListNode();
		result.next = current;
		for(int i=1; i<digits-1;i++) {
			val = (int)Math.round(Math.random()*10);
			if (val == 10) val = 0;
			current.val = val;
			current.next = new ListNode();
			current = current.next;
		}
		return result;
	}

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int nextValue = l1.val+l2.val;
		int prevAdditionalValue = 0;
		int nextAdditionalValue = 0;
		if(nextValue>9) {
			nextAdditionalValue = 1;
			nextValue = nextValue%10;  		
		}
		
		ListNode result = new ListNode(nextValue);
		prevAdditionalValue = nextAdditionalValue;
		ListNode current = null;
		
		l1 = l1.next;
		l2 = l2.next;
		if(l1!=null || l2!=null)
		current = result.next = new ListNode();
		
		
		while(l1!=null || l2!=null || nextAdditionalValue == 1) {
		//	go from start to end, sum both nodes
			if(l1 == null) l1 = new ListNode(0);
			if(l2 == null) l2 = new ListNode(0);
			nextAdditionalValue = 0;
			nextValue = l1.val+l2.val+prevAdditionalValue;
			if(nextValue>9) {
				nextAdditionalValue = 1;
				nextValue = nextValue%10;  		
			}
			current.val = nextValue;
			
			l1 = l1.next;
			l2 = l2.next;
			if(nextAdditionalValue == 1) current.next = new ListNode(1);
			if(l1==null && l2==null && nextAdditionalValue == 0 ) {
				break;
			}
			current.next = new ListNode();
			current = current.next;
			prevAdditionalValue = nextAdditionalValue;

			
		};
		
		
		
		return result;
    	
    }
    
    static ListNode addTwoNumbersMalik(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // creating an dummy list
        ListNode curr = dummy; // intialising an pointer
        int carry = 0; // intialising our carry with 0 intiall
        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it. 
		// We will add that as well into our list
        while(l1 != null || l2 != null || carry == 1){
            int sum = 0; // intialising our sum
            if(l1 != null){ // adding l1 to our sum & moving l1
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){ // adding l2 to our sum & moving l2
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry; // if we have carry then add it into our sum
            carry = sum/10; // if we get carry, then divide it by 10 to get the carry
            ListNode node = new ListNode(sum % 10); // the value we'll get by moduloing it, will become as new node so. add it to our list
            curr.next = node; // curr will point to that new node if we get
            curr = curr.next; // update the current every time
        }
        return dummy.next; // return dummy.next bcz, we don't want the value we have consider in it intially!!
    }
}
