package estacionamento_com_semaforos;

import java.util.concurrent.Semaphore;

public class Carro extends Thread {
	private Semaphore estacionamento;
	
	public Carro(String nome, Semaphore estacionamento) {
		// chamar o construtor da classe pai (Thread)
		super(nome);
		this.estacionamento = estacionamento;
		
	}
	
	public void run() {
		// entrar no estacionamento, SE TIVEREM VAGAS DISPONÍVEIS
		try {
			this.estacionamento.acquire();
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");
		}
		System.out.println(this.getName() + " entrou no estacionamento");
		try {
			// carro fica 10 s no estacionamento
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");

		}
		
		System.out.println(this.getName() + " saindo do estacionamento");
		// depois de um tempo, deixar o estacionamento
		this.estacionamento.release();
	}
}
