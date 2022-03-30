package com.leetcode.linkedlist; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* LeetCode206Iterator Tester.
* 
* @author <Authors name> 
* @since <pre>03/24/2019</pre> 
* @version 1.0 
*/ 
public class LeetCode206IteratorTest {
    private  ListNode node3=new ListNode(3,null);
    private  ListNode node2=new ListNode(2,node3);
   private  ListNode node1=new ListNode(1,node2);
   private LeetCode206Iterator leetCode206Iterator =new LeetCode206Iterator();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: reverseList(ListNode head) 
* 
*/ 
@Test
public void testReverseList() throws Exception { 
//TODO: Test goes here...
    ListNode node=  leetCode206Iterator.reverseList(node1);
    int count=0;
    while (node.next!=null && count<10) {
        System.out.println(node.val);
        node=node.next;
        count++;
    }
}


} 
