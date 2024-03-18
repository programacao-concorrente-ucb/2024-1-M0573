package aula2;

public class Ola extends Thread {
	public void run() {
		System.out.println("Entrou na " + this.getName() );

		System.out.println("Ola!" );
		
		System.out.println("Saiu da " + this.getName() );

	}
}
