/*

 .....................     Split Array Largest Sum             ..............................

 Leetcode Link-  https://leetcode.com/problems/split-array-largest-sum/

Asked in Google 
Out of all the possible sub array sums we need to find the minimum of it. 
Video exp link  3:29:00  https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=11633s


eg.  
[7,2,5,10,8]              largest sum 
1.  [7,2,5,10]  [8]  =       24   
2. [7,2,5], [10,8]  =       18      <------So this Minimum largest Sum 
3. [7,2], [5,10,8] =          23
4. [2], [7,5,10,8]  =         40 

This question also used Binary Search under the hood. (For Range based questions we also use Binary search)

1. Now min number of m is 1 i.e. take all array.  Ans will be sum all elements 
2. Max number of m is equal to number of elements in that array.  Ans for this will be largest number in the array.
3. So for above taken array Min ans possible=10and Max ans possible is 32

So for any question our ans will lie between ans of case 2 to ans of case 1 
min Ans = max value in array  max ans= sum of all values in array. And ans lie between these two value.

*/



public class SplitArray_LargestSum {
    public static void main(String[] args) {

        int[] arr ={7,2,5,10,8};
        int m=2;   // m is no. of subarrays allowed


        int ans=splitArray( arr, m);

        System.out.println(ans);
        
    }
    public static int splitArray(int[] arr, int m) {

        int start=0;
        int end=0;

        for (int i=0;i<arr.length;i++){
            start = Math.max(start,arr[i]) ;// int the end of the loop this will contain the max item from the array

            end +=arr[i];
        }
        // Binary Search

        while(start<end){
            int mid = start + (end-start)/2;
            
            // Calculate how many peices you  can divide this in with this max sum
            int sum=0;
            int pieces=1;

            for(int num:arr){
                if(sum+num>mid){
                     // you cannot add this in subarry make u one create new array

                     sum=num;
                     pieces++;
                }else{
                    sum +=num;
                }
            }

            if(pieces>m){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }

        return end; //here start will equal to end causing break in loop 
    }
}
