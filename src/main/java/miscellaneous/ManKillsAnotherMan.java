package miscellaneous;

import java.util.ArrayList;
import java.util.List;

/*
 * alternate method for calculating is as follow 
 * if Even nos then 2*X + 1 
 * els Odd nos then 2*X + 3
 * where X is 2 raise to any number which is less than N - N
 * eg:- N=100
 * then X=100-64=36
 * 2*36+1=73
 * @author ganesh deshvini
 *
 */
public class ManKillsAnotherMan {
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		int n = 1001;
		for (int i = 1; i <= n; i++) {
			arr.add(i);
		}

		int cnt = 0;
		while (arr.size() != 1) {
			cnt = 0;
			int len = arr.size();
			// here retainDeletedIndex is important, as when you remove element
			// from arrayList, the size get decreased, hence you will end up
			// with IndexOutOfBoundException
			for (int i = 0, retainDeletedIndex = 0; i < len; i++, retainDeletedIndex++) {
				if (cnt-- == 1) {
					arr.remove(retainDeletedIndex);
					retainDeletedIndex--;
				} else {
					cnt = 1;
					if (i == (len - 1)) {
						arr.remove(0);
					}
				}
			}
		}
		System.out.println(arr);
	}
}
