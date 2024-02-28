import java.util.Scanner;

public class ButterflyPattern {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        for (int row = 0; row < n; row++) {
            //first inverted half pyramid
            for (int col = 0; col <=row; col++) {
                System.out.print("*");
            }
            //spaces
            for(int col=2*(2*(n-row-1)); col>0;col= col-2){
                System.out.print(" ");
            }
            //second half pyramid
            for (int col = 0; col <=row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }


        for (int row = n; row >= 1; row--) {

            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            //spaces
//            for(int col=n-row; col<(2*(2*(n-row)));col= col+3){
//                System.out.print("  ");
//            }
            int spaces = 2 * (n - row);
            for (int col = 0; col < spaces; col++) {
                System.out.print(" ");
            }
            //second half pyramid
            for (int col = 0; col <row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
