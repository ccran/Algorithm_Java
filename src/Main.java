public class Main {
	public static int binarySearch(int[] a, int key) {
		int low = 0, high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
//		Integer.MAX_VALUE
		int[] arr = new int[Integer.MAX_VALUE];
		for(int i=0;i<Integer.MAX_VALUE;i++){
			arr[i] = i;
		}
		System.out.println(binarySearch(arr, 1));
	}
}
