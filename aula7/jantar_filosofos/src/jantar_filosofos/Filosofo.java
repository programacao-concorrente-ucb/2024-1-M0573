package jantar_filosofos;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Filosofo extends Thread {
	
	private Prato prato;
	private Semaphore semaforoJantar;
	private Lock garfoEsq;
	private Lock garfoDir;
	
	public Filosofo(String nome, Prato prato, Semaphore semaforoJantar, Lock garfoEsq, Lock garfoDir) {
		super(nome);
		this.prato = prato;
		this.semaforoJantar = semaforoJantar;
		this.garfoDir = garfoDir;
		this.garfoEsq = garfoEsq;
	}
	
	public void pensar() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");

		}
	}
  public void run(){
     while (this.prato.temMacarrao()) {
    	 
        // Tentando adquirir semáforo
        try {
        	System.out.println(this.getName() + " tentando adquirir semáforo!");

			this.semaforoJantar.acquire();
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");
		}
            // Tentar adquirir garfo da esquerda
            if (this.garfoEsq.tryLock()) {
            	System.out.println(this.getName() + " pegou garfo da esquerda!");
                try {
                    // Tentar adquirir garfo da direita
                    if (this.garfoDir.tryLock()) {
                    	System.out.println(this.getName() + " pegou garfo da direita!");

                        try {
                        	System.out.println(this.getName() + " está comendo");

                            // Ambos os garfos foram adquiridos. Pode comer!
                            this.prato.comer();
                        } finally {
                            // Liberar garfo da direita
                        	System.out.println(this.getName() + " liberou garfo da direita!");

                            this.garfoDir.unlock();
                        }
                    }
                } finally {
                	System.out.println(this.getName() + " liberou garfo da esquerda!");

                    // Liberar garfo da esquerda
                	this.garfoEsq.unlock();
                }
            	System.out.println(this.getName() + " liberou semáforo!");

            // liberando semáforo
            this.semaforoJantar.release();
           }
            
            this.pensar();
            
        }
   }

}
