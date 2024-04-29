package jantar_filosofos;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforoJantar = new Semaphore(4);
		ArrayList<ReentrantLock> garfos = new ArrayList<ReentrantLock>();
		Filosofo[] filosofos = null;
		
		for(int i = 0; i < 5;i++) {
			garfos.add(new ReentrantLock());
		}
		
		for(int i = 0; i < 5;i++) {
			new Filosofo("filósofo " + i, new Prato(10), semaforoJantar, garfos.get(i), garfos.get((i+1)%5)).start();
		}
	}
}
