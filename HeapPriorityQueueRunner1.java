

public class HeapPriorityQueueRunner1 {

	public static void main(String[] args) 
	{
		HeapPriorityQueue hpq = new HeapPriorityQueue(10);
		
		System.out.println(hpq);
		System.out.println(hpq.isEmpty());
		System.out.println(hpq.peekMax());
		System.out.println(hpq.isFull());
		System.out.println(hpq.getCount());
		System.out.println(hpq.removeMax());
		System.out.println();
		
		System.out.println(hpq.add(15));
		System.out.println(hpq.getCount());
		System.out.println(hpq.isEmpty());
		System.out.println(hpq);
		System.out.println();
		
		System.out.println(hpq.add(18));
		System.out.println(hpq.getCount());
		System.out.println(hpq.isEmpty());
		System.out.println(hpq.peekMax());
		System.out.println(hpq);
		System.out.println();
		
		System.out.println(hpq.add(2));
		System.out.println(hpq.getCount());
		System.out.println(hpq);
		System.out.println();
		
		System.out.println(hpq.add(103));
		System.out.println(hpq);
		System.out.println();
		
		System.out.println(hpq.add(23));
		System.out.println(hpq.add(15));
		System.out.println("Is Full = " + hpq.isFull());
		System.out.println(hpq.add(15));
		System.out.println(hpq.add(7));
		System.out.println(hpq.add(0));
		System.out.println("Is Empty = " + hpq.isEmpty());
		System.out.println(hpq.add(53));
		System.out.println(hpq);
		System.out.println();
		
		System.out.println(hpq.add(5));
		System.out.println(hpq);
		while(!hpq.isEmpty())
			System.out.print(hpq.removeMax() + " ");
		System.out.println();
		System.out.println(hpq.removeMax());
		System.out.println();
		
		System.out.println(hpq.add(5));
		System.out.println(hpq.add(9));
		System.out.println(hpq.add(1));
		while(!hpq.isEmpty())
			System.out.print(hpq.removeMax() + " ");
		System.out.println();
			
		System.out.println(hpq.add(5));
		System.out.println(hpq.add(1));
		System.out.println(hpq.add(9));
		while(!hpq.isEmpty())
			System.out.print(hpq.removeMax() + " ");
		System.out.println();
		
		System.out.println(hpq.add(1));
		System.out.println(hpq.add(9));
		System.out.println(hpq.add(5));
		while(!hpq.isEmpty())
			System.out.print(hpq.removeMax() + " ");
		System.out.println();
		
		System.out.println(hpq.add(1));
		System.out.println(hpq.add(5));
		System.out.println(hpq.add(9));
		while(!hpq.isEmpty())
			System.out.print(hpq.removeMax() + " ");
		System.out.println();
		
		System.out.println(hpq.add(9));
		System.out.println(hpq.add(1));
		System.out.println(hpq.add(5));
		while(!hpq.isEmpty())
			System.out.print(hpq.removeMax() + " ");
		System.out.println();
		
		System.out.println(hpq.add(9));
		System.out.println(hpq.add(5));
		System.out.println(hpq.add(1));
		while(!hpq.isEmpty())
			System.out.print(hpq.removeMax() + " ");
		System.out.println();
		
		System.out.println(hpq.add(1));
		System.out.println(hpq.add(1));
		System.out.println(hpq.add(2));
		System.out.println(hpq.add(5));
		System.out.println(hpq.add(8));
		System.out.println(hpq.add(13));
		while(!hpq.isEmpty())
			System.out.print(hpq.removeMax() + " ");
		//check duplicates using runners
		
	}

}
