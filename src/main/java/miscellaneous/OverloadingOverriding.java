package miscellaneous;

import java.io.IOException;
import java.sql.SQLException;

public class OverloadingOverriding {

	void fix(int x) {
		System.out.println("INT " + x);
	}

	void fix(long x) {
		System.out.println("LONG" + x);
	}

//	String get(String s) {
//		System.out.println("String");
//		return s;
//	}

	Integer get(Integer s) {
		System.out.println("Integer");
		return s;
	}

	Object get(Object s) {
		System.out.println("Object");
		return s;
	}

	public static void main(String[] args) {
		OverloadingOverriding obj = new OverloadingOverriding();
		long l = 6;
		obj.fix(1);
		obj.get(null);
	}

}
