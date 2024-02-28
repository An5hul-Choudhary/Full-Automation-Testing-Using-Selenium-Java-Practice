import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        for (int row = 1; row<=n; row++) {

            //Spaces
            for (int col = n-row; col >=1; col--) {
                System.out.print(" ");
            }
            //Number
            for(int col = 1; col <= row; col++){
                System.out.print( row +" " );
            }
            System.out.println();
        }

    }
}
