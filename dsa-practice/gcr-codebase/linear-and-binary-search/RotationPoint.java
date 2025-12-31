public class RotationPoint {

    public static void main(String[] args) {
        //define arr
        int[] arr = {4, 5, 6, 1, 2, 3};
        //function call here
        

        int index = findRotationPoint(arr);
//output

        System.out.println("Rotation Point Index: " + index);

    }

    public static int findRotationPoint(int[] arr) 
    { //classic binary search approach done here 

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;



            if (arr[mid] > arr[right]) {


                left = mid + 1;
            } else {

                right = mid;
            }
        }


        return left;
    }
}