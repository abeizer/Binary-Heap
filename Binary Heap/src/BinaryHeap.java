import java.util.ArrayList;

//Min heap
public class BinaryHeap <Key extends Comparable<Key>>
{
	
	private ArrayList<Key> heap;
	
	//Constructor
	public BinaryHeap()
	{
		heap = new ArrayList<>();
	}
	
	//Add an element to the heap
	public void insert(Key key)
	{
		heap.add(key);
		heapifyUp(heap.size() - 1);
	}//end insert
	
	//As long as a child is smaller than its parent, swaps the child and parent until
	//the min heap condition is satisfied
	private void heapifyUp(int index)
	{
		for(int i = index; i > 0; i--)
		{
			int comparison = heap.get(i).compareTo(heap.get((i-1)/2));
			if(comparison > 0)
			{
				return;
			}
			swap(i, (i-1)/2);
		}
	}//end heapifyUp

	//swaps items in two positions of the heap ArrayList
	private void swap(int a, int b)
	{
		Key temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b,  temp);
	}
	
	//remove the min element from the heap and return it
	public Key deleteMin()
	{
		if(heap.isEmpty())
		{
			return null;
		}

		Key root = heap.get(0);
			
		//TODO: Delete
		
		return root;
	}
	
	//Remove an item from the heap
	//If the item exists, return true
	//If the item does not exist, return false
	public boolean remove(Key key)
	{
		if(heap.isEmpty())
		{
			return false;
		}
		
		int index = heap.indexOf(key);
		
		if(index == -1)
		{
			return false;
		}
		
		heap.set(index, heap.get(heap.size() - 1));	//Replace the removed item with the last item in the array
		heap.remove(heap.size() - 1);				//Remove the duplicate item from the end of the array
		
		//If the last item in the array is removed, then heapifyDown is not needed
		if(index != heap.size() - 1)
		{
			heapifyDown(0);
		}
		return true;
	}
	
	private void heapifyDown(int index)
	{
		//TODO: heapifyDown
	}
	
	//Return an array that is a sorted representation of the data in the heap (destructive)
	public Key[] heapSort()
	{
		//TODO: heapSort
		return null;
	}
	
	//Create a union of this heap with the parameter heap
	public void union(BinaryHeap b)
	{
		//TODO: union
	}
	
	public String toString()
	{
		return heap.toString();
	}//end toString
}
