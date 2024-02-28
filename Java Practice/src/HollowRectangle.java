import java.util.Scanner;

public class HollowRectangle {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || row == n - 1 || col == 0 || col == n - 1) {
                    System.out.print("*");
                } else {

                    System.out.print(" ");
                }


            }
            System.out.println();

        }

    }
}
