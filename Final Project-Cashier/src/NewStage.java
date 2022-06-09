import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NewStage {

    public void newScene(double amtLeft, Stage primaryStage, Scene scene) {
        Label thanks = new Label("Thank You For Shopping Here! Here is your change: ");
        Label change = new Label("$" + amtLeft);
        Label again = new Label("Do you wish to make any additional purchases?");
        Button yes = new Button("Yes");
        Button no = new Button("No");
        VBox vbox2 = new VBox(thanks, change, again, yes, no);
        vbox2.setAlignment(Pos.CENTER);
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        vbox2.setBackground(background);
        Scene scene2 = new Scene(vbox2, 450, 420);
        primaryStage.setTitle("Thank You!");
        primaryStage.setScene(scene2);
        primaryStage.show();
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

