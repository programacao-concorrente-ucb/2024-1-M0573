package counter;

public class Counter {
	private Integer value;
	
	public Counter(Integer value) {
		this.value = value;
	}
	
	public void increment() {
		this.value++;
		// "this.value++" equivale a fazer:
		// int tmp = this.value;
		// this.value = tmp + 1;
	}
	
	public Integer getValue() {
		return this.value;
	}
}
