package class01;
//在一个有序数组中，找某个数是否存在
public class Code04_BSExist {

	public static boolean exist(int[] sortedArr, int num) {
		if (sortedArr == null || sortedArr.length == 0) {
			return false;
		}
		int L = 0;
		int R = sortedArr.length - 1;
		int mid = 0;
		// L..R
		// 这里while可以是<,因为最后判断了sortedArr[L] == num，打了补丁，否则while中要<=
		while (L <= R) {
			mid = L + ((R - L) >> 1); // mid = (L + R) / 2
			if (sortedArr[mid] == num) {
				return true;
			} else if (sortedArr[mid] > num) {
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return sortedArr[L] == num;
	}

	public static void main(String[] args) {
		int[] sortedArr = new int[]{1,2,3,4,5};
		System.out.println(exist(sortedArr, 5));
	}


}
