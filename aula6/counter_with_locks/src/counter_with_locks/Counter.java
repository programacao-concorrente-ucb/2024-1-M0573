package counter_with_locks;

import java.util.concurrent.locks.Lock;

public class Counter {
	private Integer value;
	private Lock lock;
	
	public Counter(Integer value, Lock lock) {
		this.value = value;
		this.lock = lock;
	}
	
	public void increment(String threadName) {
		// Bloqueando a trava
		this.lock.lock();
		// essa seção deve ter acesso exclusivo

		System.out.println(threadName + " Entrando no método increment...");
		this.value++;
		// "this.value++" equivale a fazer:
		// int tmp = this.value;
		// this.value = tmp + 1;
		
		System.out.println(threadName + " Incrementou o valor para: " + this.value);
		System.out.println(threadName + " Saindo no método increment...");
		
		// Liberando a trava
		this.lock.unlock();
	}
	
	public Integer getValue() {
		return this.value;
	}
}
