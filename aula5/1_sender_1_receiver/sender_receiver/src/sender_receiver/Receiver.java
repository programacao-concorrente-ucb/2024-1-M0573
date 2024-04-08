package sender_receiver;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver extends Thread {
	private Data packet;
	
	public Receiver(Data packet) {
		this.packet = packet;
	}
	
	public void run() {
		while(true) {
			String message = this.packet.receive();
			
			if(message == "END") {
				break;
			}
			
			// gerando um valor entre 3 e 7 s
			int randomDelay = ThreadLocalRandom.current().nextInt(3000, 7000);
			
			try {
				Thread.sleep(randomDelay);
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
		}
	}
}
