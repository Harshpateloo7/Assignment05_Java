package assignment05_000852665;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *The view class is used for the GUI Component and have a main method and calls PlayerDetails Class by creating its object
 *  and some of the methods from PalyerDetails class are called here.
 * @author Harshadkumar Patel, 000852665
 */
public class View extends Application {
    // Instance variables for the view components and model
    private Canvas canvas;
    private Label message; // display the Maths Game
    private Label line; // display the details of the game
    private Label value; // display the math question
    private Label result; // display the result of the operation after user input
    private Label user; // Display the Username with score
    private TextField userName; // Use to take input from the user
    private Button submitButton; // user to submit user detail and start the game
    private Button plusButton; // take user input from the user for the + operation
    private Button minusButton; // take user input from the user for the - operation
    private Button multiButton; // take user input from the user for the * operation
    private Button divButton; // take user input from the user for the / operation
    private PlayerDetails playerDetails; // This is the model class, which is use store the user details

    /**
     * Update the GUI when user click on the submit button
     *
     * @param actionEvent of the submit button
     */
    private void updateGUI(ActionEvent actionEvent) {
        playerDetails.sUN(userName.getText());
        // set the username with the score on the screen
        user.setText(playerDetails.gUN() + " score: " + playerDetails.getScore() + "/100");
        // Hide the component
        //This method reference taken from https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#setVisible-boolean-
        userName.setVisible(false);
        submitButton.setVisible(false);
        // show the component
        value.setVisible(true);
        plusButton.setVisible(true);
        minusButton.setVisible(true);
        multiButton.setVisible(true);
        divButton.setVisible(true);
        // Display the question on screen
        value.setText(playerDetails.getDisplayText());
    }

    /**
     * @param actionEvent of the plus button
     */
    private void plus(ActionEvent actionEvent) {
        validateAndUpdateGUI(1);
    }

    /**
     * @param actionEvent of the minus button
     */
    private void minus(ActionEvent actionEvent) {
        validateAndUpdateGUI(2);
    }

    /**
     * @param actionEvent of the multiplication button
     */
    private void multi(ActionEvent actionEvent) {
        validateAndUpdateGUI(3);
    }

    /**
     * @param actionEvent of the division button
     */
    private void div(ActionEvent actionEvent) {
        validateAndUpdateGUI(4);
    }

    /**
     *
     * @param op take an input like [ 1 for + ], [ 2 for - ], [ 3 for * ], [4  for / ]
     */
    private void validateAndUpdateGUI(int op) {
        // set the result on the screen
        if (playerDetails.checkResult(op)) {
            result.setText("Right");
        } else {
            result.setText("Wrong");
        }
        // update the user score on the screen
        user.setText(playerDetails.gUN() + " score: " + playerDetails.getScore() + "/100");
        try {
            Thread.sleep(500);
            if (playerDetails.checkTrial()) {
                value.setText(playerDetails.getDisplayText());
                user.requestFocus();
            } else {
                // Hide the component
                plusButton.setVisible(false);
                minusButton.setVisible(false);
                multiButton.setVisible(false);
                divButton.setVisible(false);
                value.setVisible(false);
                result.setText("Game Over");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    /**
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 450); // set size
        stage.setTitle("Game"); // set the windows title
        stage.setScene(scene);

        // 1. Create the model
        playerDetails = new PlayerDetails();

        // 2. Create the GUI components
        canvas = new Canvas(500, 450);
        message = new Label("Math Game");
        line = new Label("Test your Maths Skill playing this Game:");
        user = new Label("Enter your name:");
        userName = new TextField("");
        submitButton = new Button("Submit");
        value = new Label("");
        result = new Label("");
        value.setVisible(false);
        plusButton = new Button("+");
        minusButton = new Button("-");
        multiButton = new Button("*");
        divButton = new Button("/");
        plusButton.setVisible(false);
        minusButton.setVisible(false);
        multiButton.setVisible(false);
        divButton.setVisible(false);

        // 3. Add components to the root
        root.getChildren().addAll(canvas, message, line, user, userName, submitButton, value, plusButton, minusButton, multiButton, divButton, result);

        // 4. Config the components (colors, fonts, size, location)
        canvas.relocate(0, 0);
        message.relocate(200, 10);
        message.setFont(new Font("System", 28));
        message.setStyle("-fx-text-fill:red;");
        line.relocate(150, 50);
        line.setStyle("-fx-text-fill:blue;");
        user.relocate(70, 100);
        user.setFont(new Font("System", 18));
        user.setStyle("-fx-text-fill:red;");
        userName.relocate(210, 100);
        submitButton.relocate(370, 100);
        value.relocate(150, 150);
        value.setStyle("-fx-text-fill:blue;");
        value.setFont(new Font("System", 30));
        result.relocate(210, 250);
        result.setStyle("-fx-text-fill:red;");
        result.setFont(new Font("System", 28));
        plusButton.relocate(150, 200);
        plusButton.setStyle("-fx-border-color:black; -fx-border-width:8px;");
        minusButton.relocate(200, 200);
        minusButton.setStyle("-fx-border-color:black; -fx-border-width:8px;");
        multiButton.relocate(250, 200);
        multiButton.setStyle("-fx-border-color:black; -fx-border-width:8px;");
        divButton.relocate(300, 200);
        divButton.setStyle("-fx-border-color:black; -fx-border-width:8px;");

        // 5. Set event handler
        submitButton.setOnAction(this::updateGUI);
        plusButton.setOnAction(this::plus);
        minusButton.setOnAction(this::minus);
        multiButton.setOnAction(this::multi);
        divButton.setOnAction(this::div);

        // 6. Stage Show
        stage.show();
    }

    /**
     * Main method
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
}
