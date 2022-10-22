

public class Test1 {
    public static void main(String[] args)
    {
        int[] arr = { 0,1,0,3,1,2 };
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
               
                swap(arr, j, i); 
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " "); 
        }
    }
 
    //  swap the elements of an array
    public static void swap(int[] arr, int a, int b)
    {
        int temp =arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}