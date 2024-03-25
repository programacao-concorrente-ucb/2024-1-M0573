package aula2;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello, World!");
		
		Ola ola = new Ola();
		Ola ola2 = new Ola();
		Ola ola3 = new Ola();

		Tchau tchau = new Tchau();
		Tchau tchau2 = new Tchau();
		Tchau tchau3 = new Tchau();
		Tchau tchau4 = new Tchau();

		ola.start();
		ola2.start();
		ola3.start();

		tchau.start();
		tchau2.start();
		tchau3.start();
		tchau4.start();
		
		//ola.join();
		//ola2.join();
		//ola3.join();
		
		System.out.println("Acabou a main!!!");
	}
}
