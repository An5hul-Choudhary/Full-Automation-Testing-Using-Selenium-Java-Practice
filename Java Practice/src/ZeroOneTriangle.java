import java.util.Scanner;

public class ZeroOneTriangle {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = input.nextInt();


        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {


                if(row%2 == 0 && col%2==0 || row%2==1 && col%2==1) {
                    System.out.print(1);
                }
                else{
                    System.out.print(0);
                }

            }
            System.out.println();
        }

    }
}
