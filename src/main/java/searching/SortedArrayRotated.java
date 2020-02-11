package searching;

public class SortedArrayRotated {

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int numMid = nums[mid];
			if (target == numMid)
				return mid;

			int numLeft = nums[left];
			int numRight = nums[right];
			if (numLeft <= numMid) {
				if (numLeft <= target && target < numMid) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (numMid < target && target <= numRight) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] x = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(x, 0));
	}

}
