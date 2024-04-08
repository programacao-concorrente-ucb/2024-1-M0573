package sender_receiver;

public class Data {
	private String message;
	private boolean isSending = true;
	
	
	public synchronized void send(String message) {
		// enquanto o recebimento não termina, eu espero
		while(!isSending) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
		}
		// posso enviar minha mensagem
		System.out.println("Mensagem enviada: " + message);

		this.message = message;
		
		// já enviei, não tô mais enviando
		isSending = false;
		
		// aviso para a thread de recebimento que o envio terminou
		notify();	
	}
	public synchronized String receive() {
		// enquanto o envio não termina, eu espero
		while(isSending) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
		}
		
		// posso receber minha mensagem
		String receivedMessage = this.message;
		System.out.println("Mensagem recebida: " + receivedMessage);

		// já recebi, pode enviar a próxima mensagem
		isSending = true;
		
		// aviso para a thread de envio que o recebimento terminou
		notify();
		
		return receivedMessage;
	}
}
