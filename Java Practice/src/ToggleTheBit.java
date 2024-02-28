public class ToggleTheBit {

    public static void main(String[] args) {
        int num=10;
        int pos =2;

        // To toggle the bit at position pos first we have to get the bit at position
        //get Bit

        int BitmaskGet = 1<<pos;
        if((BitmaskGet & num) == 0){
            System.out.println("The bit at position " + pos + " is zero");
            num = num | BitmaskGet;
            System.out.println(num);
        }
        else{
            System.out.println("The bit at position " + pos + " is not zero");
            int newBitMask = ~(BitmaskGet);
            num = num & newBitMask;
            System.out.println(num);
        }
    }

}
