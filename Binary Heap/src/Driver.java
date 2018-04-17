
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryHeap<Integer> a = new BinaryHeap<>();
		a.insert(100);	System.out.println(a.toString());
		a.insert(2);	System.out.println(a.toString());
		a.insert(1);	System.out.println(a.toString());
		
		
		
		
		BinaryHeap<Integer> b = new BinaryHeap<>();
		
		b.insert(8);	System.out.println(b.toString());
		b.insert(3);	System.out.println(b.toString());
		b.insert(4);	System.out.println(b.toString());
		b.insert(6);	System.out.println(b.toString());
		b.insert(7);	System.out.println(b.toString() + "\n");

		b.union(a);
		
		System.out.println(b.toString());
		

	}

}
