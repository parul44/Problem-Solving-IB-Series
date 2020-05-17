import java.util.*;
import java.math.BigInteger;

class maths{

    //////////////////////////////////adhoc....///////////////////////////
    //prime Sum
    public boolean isPrime(int n){
    if(n<=1) return false;
    if(n==2) return true;
    if(n%2==0) return false;
    for(int i=3;i*i<=n;i++){
        if(n%i==0) return false;
    }
    return true;
    }
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=2;i<=A;i++){
            if(isPrime(i) && isPrime(A-i)){
                ans.add(i);
                ans.add(A-i);
                return ans;
            }
        }
        return ans;
    }


//Sum of pairwise Hamming Distance
    
    public int hammingDistance(final List<Integer> A) {
        int n = A.size();
        int dist = 0;
        for(int i = 0; i < 31; i++) {
            int oneCount = 0;
            for(int j = 0; j < n; j++) {
                int num = A.get(j);
                oneCount += (num & 1 << i) != 0? 1 : 0;
            }
            int zeroCount = n - oneCount;
            dist += (2L * oneCount * zeroCount) % 1000000007;
            dist = dist % 1000000007;
        }
        return dist;
    }

    //fizzbuzz
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> arr = new ArrayList<>();
        for(int i=1;i<=A;i++){
            if(i%15==0){
                
                arr.add("FizzBuzz");
            }
            else if(i%5==0){
                arr.add("Buzz");
            }
            else if(i%3==0){arr.add("Fizz");}
            else arr.add( ""+i) ;
        }
        return arr;
    }
    //power of two integers
    public int isPower(int A) {
        int j;
        if(A==1) return 1;
        for(int i=2;i<=Math.sqrt(A);i++)
          { j=0;
            while(A%i==0 && j<=Math.sqrt(A))
            {
                if(Math.pow(i,j)==A)
               { return 1;}
               j++;
            }
          }
          return 0;
    }

    
    //////////////////////////////////base conversion....///////////////////////////
    //Excel Coulmn number
    public int titleToNumber(String A) {
        
        int ans = 0;
        for(int i=0;i<A.length();i++){
            ans*=26;
            ans+=A.charAt(i)-'A'+1;
        }
        return ans;
    }


    //excel column title
    public String convertToTitle(int A) {
        
        char[] map = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        String ans = "";
       // if(div==0){
        //     return ans+map[d2-1];
        // }
        // ans+=map[div-1];
        // if(d2==0){
        //     ans+="Z";
        //     return ans;
        // }
        while(A>0){
             // int div = A/26;
            int d2 = A%26;
            if(d2==0){
                ans = "Z"+ans;
                A= A/26-1;
            }
            else{
                ans = map[d2-1]+ans;
                A/=26;
            }
            
        
        }
        return ans;
    }
//////////////////////////////////digit op....///////////////////////////
    

    //Palindrome Integer
    public int reverseP(int n){
        int ans = 0;
        int digit;
        while(n>0){
            digit = n%10;
            n/=10;
            ans = ans*10+digit;
        }
        return ans;
    }
    public int isPalindrome(int A) {
        int B = reverseP(A);
        if(B==A) return 1;
        return 0;
        
    }
   
    //Reverse Integer
    public int reverse(int A) {
        boolean sign = false;
        
        if(A<0) sign = true;
        int temp=0;
        int revv = 0;
        A = Math.abs(A);
        while(A!=0){
            int x=A%10;
            revv = revv*10+x;
            if(temp!=  (revv-x)/10){
                return 0;
            }
            temp = revv;
            A=A/10;
           
        }
        return (sign?-revv:revv);

    }

    ///////////////////////////////////////////Number Theory///////////////////////////////

    //Greatest Common Divisor
    void swap(int A, int B){
        int temp;
        temp = A;
        A = B;
        B = temp;
    }
    public int gcd(int A, int B) {
        if(A>B){
            swap(A,B);
        }
        //keeping A small
        if(B%A==0) return A;
        while( A>0){
            B = B%A;
            int temp = A;
            A = B;
            B = temp;
            // swap(A,B);
        }
        return B;
    }

    //Trailing Zeros in Factorial
    public int trailingZeroes(int A) {
        int ans =0;
        int k = 1;
        int fives = 5;
        while(fives<=A){
            ans+= Math.floor(A/fives);
            fives*=5;
        }
        return ans;
    }

    //Sorted Permutation Rank
    public int findRank(String A) {
        long ans = 0;
        long temp = 1;
        for (int i = A.length() - 1; i >= 0; --i) {
            char ch = A.charAt(i);
            long small = 0;
            for (int j = i + 1; j < A.length(); ++j) {
                if (ch > A.charAt(j)) small++;
            }
            ans += (small * temp) % 1000003;
            ans *= (A.length() - i);
            ans %= 1000003;
        }
        
        return (int)((ans + 1) % 1000003);
    }

    //Largest Coprime Divisor

    public int gcdD(int x, int y){
        if(x==0) return y;
        return gcd(y%x, x);
        
    }
    public int cpFact(int A, int B) {
        // int ans = gcd(6,12);
        int x=gcdD(A,B);
        if(x==1)
        {
        return A;
        }
        return cpFact(A/x,B);
        
    }

    //Sorted Permutation Rank with Repeats
    public int findRankR(String A) {
        int n = A.length();
        char[] chars = A.toCharArray();
        byte[] ascii = new byte[256];

        BigInteger[] factors = new BigInteger[n + 1];
        factors[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factors[i] = factors[i - 1].multiply(new BigInteger(String.valueOf(i)));
            // System.out.printf("%s!  = %s\n", i, factors[i].toString());
        }
        factors[0] = BigInteger.ZERO;

        BigInteger rank = BigInteger.ONE;
        BigInteger denominator, numerator;
        BigInteger MOD = new BigInteger(String.valueOf(1000003));
        for (int i = 0; i < n; i++) {
            long count = 0;
            Arrays.fill(ascii, (byte)0); // clear
            ascii[ chars[i] ]++;
            for (int j = i + 1; j < n; j++) {
                if (chars[j] < chars[i]) {
                    count++;
                }
                ascii[ chars[j] ]++;
            }
            numerator = factors[n - i - 1].multiply(new BigInteger(String.valueOf(count)));
            // numerator %= 1000003;

            denominator = BigInteger.ONE;
            for (int j = 0; j < 256; j++) {
                if (ascii[j] > 0) {
                    // System.out.printf("  %c = %s -> %s!\n", (char)j, ascii[j], factors[ ascii[j] ]);
                    // denominator *= factors[ ascii[j] ];
                    // denominator %= 1000003;
                    denominator = denominator.multiply(factors[ ascii[j] ]);
                }
            }
            // denominator = Math.max(denominator, 1);
            // System.out.printf("(%s * %s) / %s\n", count, factors[ n - i - 1], denominator);

            //rank += (numerator / denominator) ;
            rank = rank.add(numerator.divide(denominator));
            rank = rank.mod(MOD);
            // rank %= 1000003;
        }
        return Integer.parseInt(rank.toString());
    }


    //////////////////////Array DP////////////////////////////////////
    //Numbers of length N and value less than K

    public ArrayList<Integer> numToList(int C){
        ArrayList<Integer> ans = new ArrayList<>();
        while(C!=0){
            ans.add(C%10);
            C/=10;
        }
        Collections.reverse(ans);
        return ans;
    }
    public int digits(int C){
        int ans = 0;
        while(C>0){
            ans++;
            C/=10;
            
        }
        return ans;
    }
    public int solve(ArrayList<Integer> A, int B, int C) {
        int MAX = Integer.MAX_VALUE;
        int n = digits(C);
        if(n<B) return 0;
        if(n>B && A.get(0)!=0) {
            return (int)Math.pow(n,B);
        }
        if(n>B && A.get(0)==0){
            return (n-1)*((int)Math.pow(n,B-1));
        }
        ArrayList<Integer>digit = numToList(C); 
        int d = A.size(); 
         int []dp = new int[B + 1]; 
        int []lower = new int[MAX + 1]; 
  
        // Update the lower[] array such that 
        // lower[i] stores the count of elements 
        // in A[] which are less than i 
        for (int i = 0; i < d; i++) 
            lower[A.get(i) + 1] = 1; 
        for (int i = 1; i <= MAX; i++) 
            lower[i] = lower[i - 1] + lower[i]; 
  
        boolean flag = true; 
        dp[0] = 0; 
        int d2;
        for (int i = 1; i <= B; i++)  
        { 
            d2 = lower[digit.get(i - 1)]; 
            dp[i] = dp[i - 1] * d; 
  
            // For first index we can't use 0 
            if (i == 1 && A.get(0) == 0 && B != 1) 
                d2 = d2 - 1; 
  
            // Whether (i-1) digit of generated number 
            // can be equal to (i - 1) digit of C 
            if (flag) 
                dp[i] += d2; 
  
            // Is digit[i - 1] present in A ? 
            flag = (flag & (lower[digit.get(i - 1) + 1] ==  
                            lower[digit.get(i - 1)] + 1)); 
        } 
        return dp[B]; 
           
    }

    /////////////////////number encoding///////////////////////////////////////////////

    //rearrange Array
    public void arrange(ArrayList<Integer> A) {
        for(int i=0; i<A.size(); i++) {
          //  int val = A.get(i);
            A.set(i, A.get(i)+ (A.get(A.get(i))%A.size())*A.size()) ;
        }
       for(int i=0; i<A.size(); i++)
           // int val = A.get(i);
           A.set(i, A.get(i)/ A.size());
    }

    ///////////////////////////combinatronics//////////////////////////////////////////////

    //City Tour
    long comb[][] = new long[1001][1001];
    long exp[] = new long[1001];
    public void process(){
        for(int i = 0; i < 1001; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || i == j) comb[i][j] = 1;
                else{
                    comb[i][j] = (comb[i-1][j] + comb[i-1][j-1])%1000000007;
                }
            }
        }
        exp[0] = 1;
        for(int i = 1; i < 1001; i++){
            exp[i] = (exp[i-1]*2)%1000000007;
        }
    }
    public int cityTour(int A, int[] B) {
        // Collections.sort(B);
        process();
        Arrays.sort(B);
        long ans = 1;
        int cnt = B[0]-1;
        for(int i = 1; i < B.length; i++){
            int t = B[i]-B[i-1]-1;
            if(t > 0){
                ans = ((ans*exp[t-1])%1000000007 * comb[cnt+t][t])%1000000007;
                cnt += t;
            }
            //System.out.print(i+" "+t+" ")
        }
        int t = A-B[B.length-1];
        ans = (ans * comb[cnt+t][t])%1000000007;
        return (int)ans;
    }

    //Grid Unique Paths
    public int uniquePaths(int A, int B) {
        return rec(0,0,A-1, B-1);
    }
    public int rec(int sr, int sc, int er, int ec){
        if(sr==er && sc==ec) return 1;
        int ans = 0;
        if(sr+1<=er){
            ans+=rec(sr+1, sc, er, ec);
        }
        if(sc+1<=ec){
            ans+=rec(sr, sc+1, er, ec);
        }
        
        return ans;
    }



    public static void main(String[] args) {
        
    }

}