import java.util.ArrayList;

//Min heap
public class BinaryHeap <Key extends Comparable<Key>>
{
	
	private ArrayList<Key> heap;
	
	public BinaryHeap()
	{
		heap = new ArrayList<>();
	}//end constructor
	
	
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
		while(true)
		{
			int parent = (index - 1)/2;
			int comparison = heap.get(index).compareTo(heap.get(parent));
			if(comparison < 0)
			{
				swap(index, parent);
				index = parent;
				continue;
			}
			return;
		}
	}//end heapifyUp

	
	//swaps items in two positions of the heap ArrayList
	private void swap(int a, int b)
	{
		Key temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b,  temp);
	}//end swap
	
	
	//remove the min element from the heap and return it
	public Key deleteMin()
	{
		if(heap.isEmpty())
		{
			return null;
		}

		Key root = heap.get(0);
			
		heap.set(0, heap.get(heap.size() - 1));	//replace root with last item in array
		heap.remove(heap.size() - 1);
		heapifyDown(0);
		
		return root;
	}//end deleteMin
	
	
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
		if(index != heap.size())
		{
			heapifyDown(index);
		}
		return true;
	}//end remove
	
	
	private void heapifyDown(int index)
	{
		int size = heap.size() - 1;
		
		while(true)
		{
			int leftChild = 2 * index + 1;
			int rightChild = 2 * index + 2;
			
			if(rightChild > size)
			{
				//neither child exists, then at bottom level of heap
				if(leftChild >= size)
				{
					return;
				}
				//only the left child exists
				else	
				{
					int comparison = (heap.get(leftChild).compareTo(heap.get(index)));
					if(comparison < 0)
					{
						swap(leftChild, index);
						index = leftChild;
						continue;
					}
					else
					{
						return;
					}
					
				}
			}
			//both children exist
			else
			{
				//find smallest
				int comparison = (heap.get(leftChild).compareTo(heap.get(rightChild)));
				if(comparison < 0)	//left < right
				{
					comparison = (heap.get(leftChild).compareTo(heap.get(index)));
					if(comparison < 0)
					{
						swap(leftChild, index);
						index = leftChild;
						continue;
					}
					else
					{
						return;
					}
				}
				else	//right < left
				{
					comparison = (heap.get(rightChild).compareTo(heap.get(index)));
					if(comparison < 0)
					{
						swap(rightChild, index);
						index = rightChild;
						continue;
					}
					else
					{
						return;
					}
				}
			}//end if
		}//end while
	}//end heapifyDown
	
	
	//Return an array that is a sorted representation of the data in the heap (destructive)
	public Key[] heapSort()
	{
		Comparable[] array = new Comparable[heap.size()];
		for(int i = 0; heap.size() > 0; i++)
		{
			array[i] = deleteMin();
		}
		return (Key[]) array;
	}//end heapSort
	
	//Create a union of this heap with the parameter heap
	public void union(BinaryHeap<Key> b)
	{
		Comparable[] array = (Key[]) b.toArray();
		
		for(int i = 0; i < array.length; i++)
		{
			this.insert((Key) array[i]);
		}
	}//end union
	
	
	public String toString()
	{
		return heap.toString();
	}//end toString
	
	
	public boolean isEmpty()
	{
		return heap.isEmpty();
	}//end isEmpty
	
	//returns the current unsorted heap
	private Comparable[] toArray()
	{
		Comparable[] array = new Comparable[heap.size()];
		for(int i = 0; i < heap.size(); i++)
		{
			array[i] = heap.get(i);
		}
		
		return array;
	}//end toArray
}
