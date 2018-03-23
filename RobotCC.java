import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 * Recursive Exhaustive Search of Robot Coin Collection Problem
 *
 * @author (Tucker Tavarone)
 * @version (3/22/18)
 */
public class RobotCC
{
    static int comparisonsRecDyn = 0;
    static int comparisonsRec = 0;
    public int robotCoinCollection( int r, int c, int[][] C, int[][] S)
    {
        if(S[r][c] != -1){
            comparisonsRecDyn++;
            return S[r][c];
        }
        if(r == C.length-1 && c == C[0].length-1){
            comparisonsRecDyn++;
            S[r][c]= C[r][c];
            return S[r][c];
        }
        if(r == C.length-1){
            comparisonsRecDyn++;
            S[r][c] = robotCoinCollection( r, c+1, C, S )+C[r][c];
            return S[r][c];
        }
        else if(c == C[0].length-1){
            comparisonsRecDyn++;
            S[r][c] = robotCoinCollection(r+1, c, C, S)+C[r][c];
            return S[r][c];
        }
        else{
            S[r][c] = Math.max(robotCoinCollection(r+1, c, C, S),
                robotCoinCollection(r, c+1, C, S))+C[r][c];
            return S[r][c];
        }    
    }

    public int robotCoinCollectionR( int r, int c, int[][] C)
    {

        if(r == C.length-1 && c == C[0].length-1){
            comparisonsRec++;
            return C[r][c];
        }

        if(r == C.length-1){
            comparisonsRec++;
            return robotCoinCollectionR(r, c+1, C)+C[r][c];
        }

        else if(c == C[0].length-1){
            comparisonsRec++;
            return robotCoinCollectionR(r+1, c, C)+C[r][c];
        }
        else{

            return Math.max(robotCoinCollectionR(r+1, c, C),
                robotCoinCollectionR(r, c+1, C))+C[r][c];
        }    
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        int n = 8;
        int[][] A = new int[n][n];
        int[][] S = new int[n][n];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                A[i][j] = 0;
                S[i][j] = -1;
            }
        }
        A[0][0] = 1;
        A[1][1] = 1;
        A[2][2] = 1;
        A[3][3] = 1;
        A[4][4] = 1;
        A[5][5] = 1;
        //A[6][6] = 1;
        //A[7][7] = 1;
        //A[8][8] = 1;
        //A[9][9] = 1;
        
        RobotCC test = new RobotCC();
        System.out.println(test.robotCoinCollection(0,0,A,S));
        System.out.println(test.robotCoinCollectionR(0,0,A));

        System.out.println("n:   "+n);
        System.out.println("Exhaustive Recursive RCC:   "+comparisonsRec);
        System.out.println("DynProg. Recursive RCC:   "+comparisonsRecDyn);
    }
}
