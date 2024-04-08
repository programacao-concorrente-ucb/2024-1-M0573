package sender_receiver;

import java.util.concurrent.ThreadLocalRandom;

public class Sender extends Thread {
	private Data packet;
	private String[] messages;
	
	public Sender(Data packet, String[] messages) {
		this.packet = packet;
		this.messages = messages;
	}
	
	public void run() {
		// para casa mensagem na lista de mensagens (this.messages)-
		for(String message: this.messages) {

			// gerando um valor entre 3 e 7 s
			int randomDelay = ThreadLocalRandom.current().nextInt(3000, 8000);
			
			try {
				Thread.sleep(randomDelay);
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
			this.packet.send(message);

		}
	}
}
