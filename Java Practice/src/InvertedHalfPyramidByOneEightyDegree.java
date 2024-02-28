import java.util.Scanner;

public class InvertedHalfPyramidByOneEightyDegree {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        for (int row = 0; row<n; row++) {
            for (int col =0; col <n; col++) {
                if(n-col-1 <= row) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
