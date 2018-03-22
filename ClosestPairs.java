
/**
 * Finds the closest pair of values that are distinct.  Empirically analyses an array
 * of data to find the closest pairs whose different does not equal 0.
 * 
 * (May cause problems if there are two of the same values in the array)
 * (Would need to ensure that l and r are different even though A[l] and A[r]
 * have the same value)
 *
 * @author (Tucker Tavarone)
 * @version (3/22/18)
 */
public class ClosestPairs
{
    public static void main(String[] args)
    {
        double[] A = {15.8, 9.8, 5.5, 7.5, 16.8, 12.0, 10.8, 7.8, 44.0, 23.0, 18.4};

        
        for(int i = 0; i < A.length-2; i++){
            for(int j = 0; j < A.length-1-i; j++){
                if(A[j+1] < A[j]){
                    double temp  = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                }
            }
        }

        int[] valueChecked = new int[A.length];
        for(int i = 0; i < valueChecked.length; i++){valueChecked[i] = 0;}
        int r = A.length-1;
        int l = 0;
        double smallDiff = Double.MAX_VALUE;
        double first = 0.0;
        double last = 0.0;
        int comparisonCount = 0;
        //makes sure that we do not exceed array bounds
        while( r > 1 && l < A.length){
            // if the abs value of A[l] & A[r] is less than lowest diff, set it
            //also makes sure it is not going to be zero, the values have to be distinct
            valueChecked[l]+=2;
            valueChecked[r]+=2;
            //comparisonCount++;
            if(Math.abs(A[l]-A[r]) < smallDiff && Math.abs(A[l]-A[r]) > 0){
                //sets the small diff to the best diff found
                smallDiff = Math.abs(A[l] - A[r]);
                first = A[l]; //saves the 
                last  = A[r];

            }
            //comparisonCount++;
            if(Math.abs(A[l]-A[r]) > smallDiff){ r--;  }//look at smaller values
            else{
                l++;// look at bigger values

            }
            // resets r if l is not finished searching
            
            
        }
        System.out.println("Solutions:");
        System.out.println(first);
        System.out.println(last+"\n");
        System.out.println("length of array:  "+A.length);
        System.out.println("comparisons made: "+comparisonCount);

        System.out.println("How many times each element was checked: \n");
        for(int i = 0; i < valueChecked.length; i++){
            System.out.print(valueChecked[i]+", ");
        }

        
        /*
        for(int i = 0; i < A.length; i++){
        System.out.print(A[i]+", ");
        }

        for(int i = 0; i < A.length-2; i++){
        for(int j = 0; j < A.length-1-i; j++){
        if(A[j+1] < A[j]){
        double temp  = A[j+1];
        A[j+1] = A[j];
        A[j] = temp;
        }
        }
        }
        System.out.println();
        for(int i = 0; i < A.length; i++){
        System.out.print(A[i]+", ");
        }
         */
    }
}
