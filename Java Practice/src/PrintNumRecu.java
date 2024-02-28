public class PrintNumRecu {

    public static int numbers(int x, int n){

        if(n==0){
            return 1;
        }
        if(x==0){
            return 1;
        }

        // if n is even
        if(n%2==0){
            return numbers(x,n/2)*numbers(x,n/2);
        }
        else{
            // n is odd
            return numbers(x,n/2)*numbers(x,n/2)*x;
        }

    }

    public static void main(String[] args) {

        System.out.println(numbers(3,5));


    }
}
