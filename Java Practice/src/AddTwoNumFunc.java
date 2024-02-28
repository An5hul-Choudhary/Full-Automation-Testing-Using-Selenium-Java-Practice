import java.util.Scanner;

public class AddTwoNumFunc {

//    public static int addTwoNum(int a, int b){
//        int sumIs = a+b;
//        return sumIs;
//    }

//    public static int factorial(int num1){
//        if(num1==0 || num1==1){
//            return 1;
//        }
//        return num1 * factorial(num1-1);
//    }

//    public static void average(float num1, float num2, float num3){
//        System.out.println((num2+ num1+ num3)/3);
//    }

//    public static void oddNumSum(int n){
//        int sum = 0;
//        for(int i=n;i>=0;i--) {
//            sum += (i % 2 == 1) ? i:0;
//        }
//        System.out.println(sum);
//    }

//    public static void powerTo(int a, int b){
//        System.out.println( Math.pow(a,b));
//    }

    public static int gcd(int a, int b){

        int n =Math.min(a,b);

        int ans =0;
        for(int i=1; i<=n; i++){
            if((a%i==0) && (b%i==0)){
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number 1: ");
//        float num1 = sc.nextInt();
//        System.out.println("Enter number 2: ");
//        float num2 = sc.nextInt();
//        System.out.println("Enter number 3: ");
//        float num3 = sc.nextInt();

        /*
        AddTwoNumFunc obj = new AddTwoNumFunc();
        int sum = obj.addTwoNum(num1, num2);
         */

//        int sum = addTwoNum(num1, num2);
//        System.out.println(sum);

//        average(num1, num2,num3);

//        oddNumSum(6);

//        powerTo(2,3);

        System.out.println(gcd(54,24));

    }
}
