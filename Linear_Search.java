import java.util.*;

public class Linear_Search {
    public static void main(String[] args) {
        int [] arr = new int[10];
        int target,index;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array");
        for (int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        System.out.print("Enter target-");
        target=sc.nextInt();

       index= linear_search(arr, target);

       System.out.println("index " + index);
    }
    
    // search in the array ; return the index else -1

    static int linear_search(int[] arr, int target){

        if(arr.length==0){
            return -1;
        }

        for (int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
            
        }
  
        return -1;
       

    }
}

/*
For char in string 

static boolean search(String str,char target){
    if (str.length==0){
        return false;
    }
    for (int i=0;i<str.length();i++){ or for( char ch: str.toCharArray())
        if(target == str.charAt(i))
        return true;
    }

    return false;
}





*/