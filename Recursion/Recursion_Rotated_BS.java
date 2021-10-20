//                                 === Recursion Rotated Binary Search ===

public class Recursion_Rotated_BS {

  public static void main(String[] args) {
    int arr[] = { 5, 6, 7, 8, 9, 1, 2, 3 };

    System.out.println(search(arr, 3, 0, arr.length));
    System.out.println(search(arr, 2, 0, arr.length));
    System.out.println(search(arr, 6, 0, arr.length));
  }

  static int search(int[] arr, int target, int s, int e) {
    if (s > e) {
      return -1;
    }
    int m = s + (e - s) / 2;

    if (arr[m] == target) {
      return m;
    }

    if (arr[s] <= arr[m]) {                         // from start to mid

      if (target >= arr[s] && target <= arr[m]) { // search in the sorted 1st half
        return search(arr, target, s, m - 1);
      } 
      else 
      {                                             // search in the sorted 1st half
        return search(arr, target, m + 1, e);
      }
    }

    if (target >= arr[m] && target <= arr[e]) { // from mid to end
      return search(arr, target, m + 1, e);
    } 
   
    return search(arr, target, s, m - 1);
  }
}
