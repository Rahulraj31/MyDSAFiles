public class BinarySearch {

  public static void main(String[] args) {
     int[] arr = { -22, -18, -1, 0, 23, 34, 45, 56, 67, 78, 89 };
    int target = 45;

    int index = binarySearch(arr, target);

    System.out.println("Element found at index= " + index);
  }

  // return index

  static int binarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      // find middle element

      /*int mid= (start+end)/2; but for large value can exceed while calculation
            so use formula MID = S + (E-S)/2
            */

      int mid = start + (end - start) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (target < arr[mid]) {
        end = mid - 1;
      } else { // target>mid
        start = mid + 1;
      }
    }
    return -1;
  }
}
