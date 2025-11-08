public class rotatedsorted {

    public static int search(int arr[],int tar, int si,int ei){
      if(si>ei){
        return -1;
        }
      
        int mid=si+(ei-si)/2;

        if(arr[mid]==tar){
            return mid;
        }

        //mid on L1
        if(arr[si]<=arr[mid]){
            // case a: left
            if(tar>=arr[si] && tar<=arr[mid]){
                return search(arr, tar, si, mid-1);
        }else{
            //case b: right
            return search(arr, tar, mid+1, ei);
        }
     }
        //mid on L2
        else{
            //case c: right
            if(tar>=arr[mid] && tar<=arr[ei]){
                return search(arr, tar, mid+1, ei);
            }else{
                //case d: left
                return search(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {15, 18, 2, 3, 6, 12};
        int target = 3;
        int result = search(arr, target, 0, arr.length - 1);
        System.out.println("Element found at index: " + result);
    }
}
