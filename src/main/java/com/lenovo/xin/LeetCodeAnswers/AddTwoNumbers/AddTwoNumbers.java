package com.lenovo.xin.LeetCodeAnswers.AddTwoNumbers;


public class AddTwoNumbers {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	ListNode res = null;
    	ListNode tail = null;
    	int carrayNum = 0;
    	
    	while(l1!=null && l2!=null){
    		ListNode curNode;
    		int curVal = l1.val + l2.val + carrayNum;
    		if(curVal >= 10){
                curNode = new ListNode(curVal-10);
                carrayNum = 1;
    		}else{
    			curNode = new ListNode(curVal);
    			carrayNum =0;
    		}
    		if(res==null){
    			res = curNode;
    			tail = curNode;
    		}else{
    			tail.next = curNode;
    			tail = tail.next;
    		}
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	
    	ListNode longL = null;
    	if(l1==null){
    		if(l2!=null){
    		    longL = l2;	
    		}
    	}else{
    		longL = l1;
    	}
    	
    	while(carrayNum==1 && longL!=null){
    	    ListNode curNode;
    	    int curVal = longL.val + carrayNum;
    		if(curVal >= 10){
    		    curNode = new ListNode(curVal-10);
    		    carrayNum = 1;	
    		}else{
    			curNode = new ListNode(curVal);
    		    carrayNum = 0;	
    		}
    		tail.next = curNode;
		    tail = tail.next;
		    longL = longL.next;
    	}
    	
    	if(longL!=null){
    	    tail.next = longL;	
    	}else if(carrayNum==1){
    		tail.next = new ListNode(1);
    	}
		
		return res;
    }

}