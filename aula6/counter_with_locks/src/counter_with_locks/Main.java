package counter_with_locks;

import java.util.concurrent.locks.ReentrantLock;

import counter_with_locks.Counter;
import counter_with_locks.Incrementer;

public class Main {
	public static void main(String[] args) {
		Integer numExec = 0;
		while(true) {
			ReentrantLock lock = new ReentrantLock();
			Counter counter = new Counter(0, lock);
			
			Incrementer inc1 = new Incrementer(counter);
			Incrementer inc2 = new Incrementer(counter);
			Incrementer inc3 = new Incrementer(counter);
			Incrementer inc4 = new Incrementer(counter);

			inc1.start();
			inc2.start();
			inc3.start();
			inc4.start();
			
			try {
				inc1.join();
				inc2.join();
				inc3.join();
				inc4.join();
			} catch (InterruptedException e) {
				System.out.println("Opa, deu erro!!!");
			}
			numExec++;
			System.out.println("Valor final do contador: " + counter.getValue());

			if(counter.getValue() != 4) {
				System.out.println("Número de execuções: " + numExec);
				break;
			}
		}


		
	}
}
