package sender_receiver;

public class Main {
	public static void main(String[] args) {
		Data packet = new Data();
		String[] messages = {
				"primeira mensagem",
				"segunda mensagem",
				"terceira mensagem",
				"END"
		};

		Sender sender = new Sender(packet, messages);

		Receiver receiver = new Receiver(packet);
		
		sender.start();
		receiver.start();
		
	}
}
