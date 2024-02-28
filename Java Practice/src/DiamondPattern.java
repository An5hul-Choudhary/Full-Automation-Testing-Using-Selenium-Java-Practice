import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        for (int row = 1; row<=n; row++) {

            //Spaces
            for (int col = n-row; col >=1; col--) {
                System.out.print(" ");
            }

            for(int col = 1; col <= row; col++){
                System.out.print("*");
            }
            for(int col=2;col<=row;col++){
                System.out.print("*");
            }

            System.out.println();
        }

        //Second half
        for (int row = n; row>=1; row--) {

            //Spaces
            for (int col = n-row; col >=1; col--) {
                System.out.print(" ");
            }

            for(int col = 1; col <= row; col++){
                System.out.print("*");
            }
            for(int col=2;col<=row;col++){
                System.out.print("*");
            }

            System.out.println();
        }

    }
}
