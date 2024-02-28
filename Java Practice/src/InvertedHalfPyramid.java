import java.util.Scanner;

public class InvertedHalfPyramid {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        for (int row = n; row>0; row--) {
            for (int col =1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
