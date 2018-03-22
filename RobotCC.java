
/**
 * Recursive Exhaustive Search of Robot Coin Collection Problem
 *
 * @author (Tucker Tavarone)
 * @version (3/22/18)
 */
public class RobotCC
{
    public int robotCoinCollection( int r, int c, int[][] C)
    {
        if(r == C.length-1 && c == C[0].length-1){
            return C[r][c];
        }
        if(r == C.length-1){
            return robotCoinCollection(r, c+1, C)+C[r][c];
        }
        else if(c == C[0].length-1){
            return robotCoinCollection(r+1, c, C)+C[r][c];
        }
        else{
            return Math.max(robotCoinCollection(r+1, c, C),
                robotCoinCollection(r, c+1, C))+C[r][c];
        }    
    }

    public static void main(String[] args)
    {
        int[][] A = new int[4][4];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                A[i][j] = 1;
            }
        }
        

        RobotCC test = new RobotCC();
        System.out.println(test.robotCoinCollection(0,0,A));
    }
}
