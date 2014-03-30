/**
 * source:http://oj.leetcode.com/problems/lru-cache/
 * report:
 * Problem Description:
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * @author: tobielf
 * @date: 2014/03/22
 */

import java.util.Map;
import java.util.HashMap;
/**
 * 
 * @author tobielf
 */
class Node {
	Integer value;										/** Store value */
	Integer next;										/** next key */
	Integer previous;									/** previous key */
	Node() {											/** constructor */
		this.value = 0;
		this.next = 0;
		this.previous = 0;
	}
}

public class LRUCache {
	private int capacity;								/** cache capacity */
	private int size;									/** current cache size */
	private Map<Integer, Node> cache;					/** cache storage */
	private int head;									/** least recently used key */
	private int tail;									/** last recently used key */
	
	public LRUCache(int capacity) {						/** Constructor */
		this.capacity = capacity;
		this.size = 0;
		this.head = 0;
		this.tail = 0;
		cache = new HashMap<Integer, Node>(capacity * 2);
	}
	
	public int get(int key) {
		
		if (cache.containsKey(key)) {					/** if the key is in the cache, return it's value */
														/** update the LRU double end linked list */
			Node current = remove(key);					/** remove from current list */
			append(key, current);						/** append to the tail */
			return current.value;
		}
		
		return -1;										/** otherwise return -1 */
	}
	
	public void set(int key, int value) {
		
		if (cache.containsKey(key)) {					/** if the key is in the cache */
														/** update the LRU double end linked list */
			Node current = remove(key);					/** remove from current list */
			append(key, current);						/** append to the tail */
			current.value = value;						/** update value */
		} else {
			Node p = new Node();						/** otherwise it must be a new key */
			p.value = value;
			append(key, p);								/** append to the tail */
			cache.put(key, p);							/** put into the cache */
			this.size++;
		}

		if (this.size > this.capacity) {				/** resize */
			int removeKey = head;						/** remove the oldest key */
			remove(head);
			cache.remove(removeKey);
			this.size--;
		}
	}
	
	private void append(int key, Node current) {
		Node tail = this.cache.get(this.tail);
		if (isEmpty()) {								/** if list is empty */
			this.head = key;							/** head and tail point to the same key */
			this.tail = key;
			current.next = key;							/** only one node next point to itself */
			current.previous = key;						/** only one node prev point to itself */
			return;
		}
		if (this.tail == key) {							/** remain on the tail */
			return;										/** do nothing */
		}
		
		current.previous = this.tail;					/** insert a new node into double end linked list */
		tail.next = key;
		current.next = key;
		this.tail = key;
	}
	
	private Node remove(int key) {
		Node current = this.cache.get(key);
		Node next = this.cache.get(current.next);
		Node previous = this.cache.get(current.previous);
		if (this.head == key) {							/** remove the head */
			next.previous = current.next;				/** head point must point to itself. */
			this.head = current.next;					/** update head to head.next */
			return current;
		}
		if (this.tail == key) {							/** remove the tail */
			return current;
		}
		previous.next = current.next;					/** remove a node from double end linked list */
		next.previous = current.previous;
		return current;
	}
	
	private boolean isEmpty() {
		return this.size == 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lruc = new LRUCache(10);
		System.out.println("set(7,28)");
    	lruc.set(7,28);
    	
    	System.out.println("set(7,1)");
    	lruc.set(7,1);
    	
    	System.out.println("set(8,15)");
    	lruc.set(8,15);
    	
    	System.out.println("get(6)");
    	System.out.println(lruc.get(6));
    	
    	
    	lruc.set(10,27);
    	lruc.set(8,10);
    	System.out.println(lruc.get(8));
    	lruc.set(6,29);
    	lruc.set(1,9);
    	System.out.println(lruc.get(6));
    	lruc.set(10,7);
    	System.out.println(lruc.get(1));
    	System.out.println(lruc.get(2));
    	System.out.println(lruc.get(13));
    	lruc.set(8,30);
    	lruc.set(1,5);
    	System.out.println(lruc.get(1));
    	lruc.set(13,2);
    	System.out.println(lruc.get(12));
	}

}
