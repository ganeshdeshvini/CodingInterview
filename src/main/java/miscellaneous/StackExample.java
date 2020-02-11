package miscellaneous;

public class StackExample {
	private int[] data = new int[10];
	private int tos;

	public StackExample(int size) {
		// TODO Auto-generated constructor stub
		data = new int[size];
		tos = -1;
	}

	// Push an item
	void push(int item) {
		if (tos == data.length - 1) {
			System.out.println("Stack is Full!!!");
		} else {
			data[++tos] = item;
		}
	}

	int pop() {
		if (tos < 0) {
			System.out.println("Stack underflow");
			return 0;
		} else {
			return data[tos--];
		}
	}

	public static void main(String[] args) {
		StackExample stackExample1 = new StackExample(10);
		StackExample stackExample2 = new StackExample(10);

		// push items in stack
		for (int i = 0; i < 10; i++) {
			stackExample1.push(i);
		}
		for (int i = 10; i < 20; i++) {
			stackExample2.push(i);
		}

		// pop
		for (int i = 0; i < 10; i++) {
			System.out.println(stackExample1.pop());
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(stackExample2.pop());
		}
	}
}
