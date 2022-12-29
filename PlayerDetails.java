package assignment05_000852665;
import java.util.Random;
/**
 * The PlayerDetails class is use store player details and have a main logic. This class is called in View class.
 * @author Harshadkumar Patel, 000852665
 */
public class PlayerDetails {
    // Use to store the username
    private String un; // un = username
    // Use to store the number of trial out of 10
    private int trial = 1;
    // Use to store the user score out of 100
    private int score = 0;
    // Use to store the first number which is generated randomly
    private int fn; // fn = first number
    // Use to store the second number which is generated randomly
    private int sn; // sn = second number
    // Use to store the answer of two number operation result
    private double ans; // ans = answer
    // Use to store the correct operation
    private int op; // op = operator

    /**
     * This method is used to set the username
     * @return un means Username
     */
    public String gUN() {
        return un;
    }

    /**
     * This method is used to set the username
     * @param un set the Username
     */
    public void sUN(String un) {
        this.un = un;
    }

    /**
     * This method is used to check the available trial
     * @return Check the number of trial and return the boolean value
     */
    public boolean checkTrial() {
        return trial <= 10; // return true if trial less than or equal 10 , else return false
    }

    /**
     *
     * @return The score of the User
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param op receive the operation which user want to perform
     * @return boolean value base on the user operation right or wrong
     */
    public boolean checkResult(int op) {
        boolean isSuccess = (op == this.op);  // check user input operation with correct operation and base on that return true or false
        if (isSuccess) {
            score += 10; // if user input right, then increase the score
        }
        trial++; // Increase the trial value with one
        return isSuccess;
    }

    /**
     *
     * @return the display value with two number and its answer
     */
    public String getDisplayText() {
        fn = gFRN(); // generate the first random number
        sn = gSRN(); // generate the second random number
        op = gRNO(); // generate the random operation like [ 1 for + ], [ 2 for - ], [ 3 for * ], [4  for / ]
        if (op == 1) {
            ans = fn + sn;
        } else if (op == 2) {
            ans = fn - sn;
        } else if (op == 3) {
            ans = fn * sn;
        } else if (op == 4) {
            ans = fn / sn;
        }
        return fn + "  ?  " + sn + "  =  " + ans;
    }

    /**
     * Generate random number between 10 to 20
     *
     * @return random number
     */
    public int gFRN() {
        return new Random().nextInt(20 - 10) + 10;
    }

    /**
     * Generate random number between 1 to 5
     *
     * @return random number
     */
    public int gSRN() {
        return new Random().nextInt(5 - 1) + 1;
    }

    /**
     * Generate random number between 1 to 4
     *
     * @return random number
     */
    public int gRNO() {
        return new Random().nextInt(4) + 1;
    }
}
