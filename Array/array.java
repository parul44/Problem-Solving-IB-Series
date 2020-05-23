import java.util.*;
public class array {
    
    //min step grid
    public int coverPoints(int[] A, int[] B) {
        int ans = 0;
        for(int i=0;i<A.length-1;i++){
            int x = A[i]-A[i+1];
            // int x2 = A[i+1];
            int y = B[i]-B[i+1];
            int small= Math.max(Math.abs(x), Math.abs(y));
            // ans+=small;
           
            ans = ans+ small;
        }
        return ans;
        
    }

    // aadd one to a number

    public int[] plusOne(int[] A) {
        StringBuilder ans =  new StringBuilder();
        boolean carry = true;
        for(int i=A.length-1;i>=0;i--){
            ans.append(""+(A[i] + (carry?1:0) )%10);
            if(A[i]==9 && carry ){
                carry = true;
            }
            else carry = false;
        }
        if(carry) ans.append(""+1);
        int k = 0;
        int j  = ans.length()-1;
        while(ans.charAt(j)==0)j--;
        int[] ansArray = new int[j+1];
        for(int i= j;i>=0;i--){
            ansArray[k++] = ans.charAt(i)-'0';
        }
        return ansArray;
    }

    //kadene's algo
    public int maxSubArray(final int[] A) {
        int maxAns = Integer.MIN_VALUE;
        int curr = 0;
        for(int i=0;i<A.length;i++){
            curr+=A[i];
            maxAns = Math.max(maxAns, curr);
            if(curr<0) curr=0;
            
        }
        return maxAns;
        
    }
//max abs diff
public int maxArr(int[] arr) {
    // Integer.MIN_VALUE;
    int max1=Integer.MIN_VALUE,min1=Integer.MAX_VALUE;
    int max2=Integer.MIN_VALUE,min2=Integer.MAX_VALUE;
    for(int i=0; i<arr.length; i++)
    {
    max1=Math.max(max1,arr[i]+i);
    min1=Math.min(min1,arr[i]+i);
    max2=Math.max(max2,arr[i]-i);
    min2=Math.min(min2,arr[i]-i);
    }
    return Math.max(Math.abs(max1-min1),Math.abs(max2-min2));
}

//repeat and missing number array
public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
    int[] arr = new int[A.size()];
ArrayList<Integer>resultArray = new ArrayList<>();

     for(int i=0;i<A.size();i++) {
         if(arr[A.get(i)-1] == 0) {
             arr[A.get(i)-1] = -1;
         }
         else {
             resultArray.add(A.get(i));
         }
     }
     for(int i=0;i<A.size();i++) {
         if(arr[i] == 0) {resultArray.add(i+1);}
     }
     return resultArray;
 }

    public ArrayList<Integer> flip(String A) {
        if (!A.contains("0")) {
            return new ArrayList<Integer>() {};
        }

        int maxDiff = 0, diff = 0;
        int start = 0;
        int res[] = new int[2];

        for (int i = 0; i < A.length(); i++) {
            diff += A.charAt(i) == '0' ? 1 : -1;

            if (diff < 0) {
                diff = 0;
                start = i + 1;
                continue;
            }

            if (diff > maxDiff) {
                maxDiff = diff;
                res[0] = start+1;
                res[1] = i+1;
            }
        }

    ArrayList<Integer> ans = new ArrayList<>();
    for(int i=0;i<res.length;i++){
        ans.add(res[i]);
    }

        return ans;
    }
    
    //wave
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i=0;i<A.size()-1;i++){
            int ele = A.get(i);
            if(i%2==0 && ele<A.get(i+1)){
                int temp =ele;
                A.set(i, A.get(i+1));
                A.set(i+1, temp);
            }
            
        }
     return A;

    }

    public static void main(String[] args) {
        
    }    
}