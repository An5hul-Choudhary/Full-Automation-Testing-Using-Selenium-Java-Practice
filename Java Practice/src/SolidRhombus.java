import java.util.Scanner;

public class SolidRhombus {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        for (int row = n-1; row>=0; row--) {
            for (int col =1; col <= row; col++) {
                System.out.print(" ");
            }
            for(int col =0; col<n;col++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
