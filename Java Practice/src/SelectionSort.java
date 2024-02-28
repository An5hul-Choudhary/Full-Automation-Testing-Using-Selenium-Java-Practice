public class SelectionSort {

    public static void main(String[] args) {

        int arr[] = {7,8,3,1,2};

        for(int i=0; i<arr.length; i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }

    }
}
