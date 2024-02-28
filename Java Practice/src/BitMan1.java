public class BitMan1 {
    //Write a program to find if a number is a power of 2 or not.
    public static boolean notPower(int num){
        while(num>1){
            int check = num%2;
//            System.out.println("Check is "+ check);
            num=num/2;
//            System.out.println("Num is " + num);
            if(check!=0){
                return true;

            }
        }
        return false;
    }
    public static void main(String[] args) {
        int num = 258;

        if(notPower(num)){
            System.out.println(num + " is not the power of 2");
        }
        else{
            System.out.println(num + " is the power of 2");
        }
    }
}
