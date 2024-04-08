package sender_receiver;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver extends Thread {
	private Data packet;
	private int numSenders;
	
	public Receiver(Data packet, int numSenders) {
		this.packet = packet;
		this.numSenders = numSenders;
	}
	
	public void run() {
		while(true) {
			String message = this.packet.receive();
			
			if(message == "END") {
				numSenders--;
				if(numSenders == 0) {
					break;
				}
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
