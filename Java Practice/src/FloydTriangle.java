import java.util.Scanner;

public class FloydTriangle {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = input.nextInt();
        int count=1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }

    }
}
