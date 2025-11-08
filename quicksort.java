public class quicksort {

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void quickssort(int arr[],int si,int ei){
      if(si>ei){
        return;
      }
      int pIdx=partition(arr,si,ei);
      quickssort(arr, si, pIdx-1);//left
      quickssort(arr, pIdx+1, ei);//right
    }
    public static int partition(int arr[],int si,int ei){
        int pivot=arr[ei];
        int i=si-1;//to keep track of smaller element
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
            i++;
            //swap
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
            }
        }
         i++;
         int temp=pivot;
         arr[ei]=arr[i];
         arr[i]=temp;
         return i;
    }
    public static void main(String[] args) {
        int arr[] = {38, 27, 43, 3, 9, 82, 10};
        quickssort(arr, 0, arr.length - 1);
        printarr(arr);
    }
}