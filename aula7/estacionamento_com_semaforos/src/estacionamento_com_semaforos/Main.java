package estacionamento_com_semaforos;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		// meu semáforo tem 10 permissões
		// ou seja, somente 10 carros podem
		// estar no estacionamento simultaneamente
		Semaphore estacionamento = new Semaphore(10);
		
		for(int i = 0;i < 20;i++) {
			new Carro("carro " + i, estacionamento).start();
		}
	}
}
