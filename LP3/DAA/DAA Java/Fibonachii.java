import java.util.*;
 
 class fibo {

    public static int fibonacci(int num){
        /* Exit condition of recursion*/
        if(num < 2)
            return num;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static void fibo(int n){

        int last = 1, secondLast = 0, current;
        for(int i = 0; i < n; i++){
            if(i < 2){
                current = i;
            } else {
                current = last + secondLast;
                secondLast = last;
                last = current;
            }
            System.out.print(current + " ");
        }
    }

    public static void main(String args[]) {
      
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of terms in Fibonacci Series");
        int terms = in.nextInt();
 
        /*
         *  Nth term = (N-1)th thrm + (N-2)th term;
         */
        System.out.println("Fibonacci without Recursion ");
         fibo(terms);
         System.out.println();
        System.out.println("Fibonacci with Recursion ");
         for(int i=0;i<terms;i++){
            System.out.print(fibonacci(i) +" ");
         }
         System.out.println();

    }
}
