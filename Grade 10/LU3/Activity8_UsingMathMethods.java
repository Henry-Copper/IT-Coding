// H Klopper 18 May 2022 LU3_Activity8

import com.sun.xml.internal.messaging.saaj.soap.impl.TextImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Arrays;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.Math.abs;
import static java.lang.Math.pow;


public class Activity8_UsingMathMethods extends Application {
//    String input;
//
//    @Override
//    public void start(Stage stage){
//        VBox root = new VBox();
//        Scene scene = new Scene(root);
//        TextField textBox = new TextField("Input any real number");
//        Label label = new Label();
//
//        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent e)
//            {
//                try{
//                    double num = Double.parseDouble(textBox.getText());
//                    System.out.println(num);
//                    System.exit(0);
//                }
//                catch (Exception except){
//                    System.out.println("That's not a number!");
//                    label.setText("That's not a number!");
//                }
//                input = textBox.getText();
//                System.out.println(input);
//            }
//        };
//
//        // when enter is pressed
//        textBox.setOnAction(event);
//        TilePane p1 = new TilePane(label);
//        p1.setAlignment(Pos.TOP_CENTER);
//        TilePane p2 = new TilePane(textBox);
//        p2.setAlignment(Pos.BOTTOM_CENTER);
//
//
//        root.getChildren().addAll(p1, p2);
//        root.setAlignment(Pos.CENTER);
//        AnchorPane anchor = new AnchorPane();
////        root.setAlignment(Pos.CENTER);
////        root.getItems().addAll(p1, p2);
////
////        root.setOrientation(Orientation.VERTICAL);
//////        AnchorPane.setBottomAnchor(textBox, 50.0);
////        AnchorPane.setTopAnchor(label, 50.0);
////        VBox.setVgrow(label, Priority.ALWAYS);
////        VBox.setVgrow(textBox, Priority.ALWAYS);
////        VBox.setMargin(label, new Insets(Pos.CENTER));
//        stage.setScene(scene);
//        root.setPrefSize(200, 200);
//        stage.show();
//    }

    String input;

    @Override
    public void start(Stage stage){

        Label errorLabel = new Label();
        errorLabel.setWrapText(true);
        HBox topChildBox = new HBox(errorLabel);
        TextField textInput = new TextField();
        textInput.setPromptText("Please enter a real number (not a fake one, like many girls have given to me before)");
        textInput.setFocusTraversable(false);

        HBox bottomChildBox = new HBox(textInput);
        bottomChildBox.setAlignment(Pos.CENTER);
        HBox.setHgrow(textInput, Priority.ALWAYS);
        VBox.setVgrow(bottomChildBox, Priority.ALWAYS);
        VBox root = new VBox( bottomChildBox);

        Scene scene = new Scene(root);

        Text text = new Text();
        HBox textContainer = new HBox(text);

        textInput.setOnAction((ActionEvent event) ->
        {
            root.getChildren().remove(textContainer);
            try {
                errorLabel.setText("");
                double num = Double.parseDouble(textInput.getText());
                double[] mathOps = {round(num), sqrt(num), abs(num), pow(num, 3)};
                text.setText("" + " " + Arrays.toString(mathOps).replaceAll(", ", "\n").replaceAll("\\[", "").replaceAll("\\]", ""));
                text.setTextAlignment(TextAlignment.CENTER);
                textContainer.setAlignment(Pos.CENTER);
                root.getChildren().add(textContainer);
                VBox.setVgrow(textContainer, Priority.ALWAYS);
                String copyText = text.getText();
                final Clipboard clipboard = Clipboard.getSystemClipboard();
                final ClipboardContent content = new ClipboardContent();
                content.putString(copyText);
                clipboard.setContent(content);
            }
            catch (Exception e){
                topChildBox.setAlignment(Pos.CENTER);
                VBox.setVgrow(topChildBox, Priority.ALWAYS);
                root.getChildren().add(topChildBox);
                errorLabel.setText("That's not a number you silly billy! Try again please.");
                bottomChildBox.requestFocus();
                textInput.clear();
                textInput.setPromptText("Please enter a real number (this time, don't lie to us)");
                System.out.println(scene.getFocusOwner());
            }
        });
//        textInput.setOnMousePressed((EventHandler<MouseEvent>) me -> errorLabel.setText(""));
        textInput.setOnMousePressed(mouseEvent -> {
            errorLabel.setText("");
            root.getChildren().remove(topChildBox);
    }

);



//        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent e)
//            {
//                try{
//                }
//                catch (Exception except){
//                }
//            }
//        };

        // when enter is pressed
//        textBox.setOnAction(() -> {});

        root.setPrefSize(300, 300);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    } // main method

} // Activity8_UsingMathMethods class


/* Activity 8: write down the output

num = 16.75
round = 17.0 (.0 because the Math class returns doubles)
sqrt = 4.092676385936225
abs = 16.75
pow(num, 2) = 280.5625

num = 4
round = 4.0
sqrt = 2.0
abs = 4.0
pow num ^ 2 = 16.0
pow num ^ num = 256.0

num = -23.45
round = -23.0
sqrt = NaN
abs = 23.45
pow num ^ 2 = 549.9024999999999
pow num ^ 3 = -12895.213624999999
 */
