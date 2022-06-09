import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        final double[] newTotal = {0.00};

        TextField milk = new TextField();
        milk.setMaxWidth(50);
        Label milkLabel = new Label("Milk: ");

        TextField bread = new TextField();
        bread.setMaxWidth(50);
        Label breadLabel = new Label("Bread: ");

        TextField water = new TextField("");
        water.setMaxWidth(50);
        Label waterLabel = new Label("Water: ");

        TextField shampoo = new TextField("");
        shampoo.setMaxWidth(50);
        Label shampooLabel = new Label("Shampoo: ");

        TextField ramen = new TextField();
        ramen.setMaxWidth(50);
        Label ramenLabel = new Label("Ramen: ");

        TextField changeAmount = new TextField("");
        changeAmount.setMaxWidth(50);

        Label totalCol = new Label("Total");
        Button calculate = new Button("Calculate");
        Label change = new Label("Change ");
        Button changeCal = new Button("Calculate Change");

        HBox hbox1 = new HBox(new Label(), milkLabel, milk);
        HBox hbox2 = new HBox(new Label(), breadLabel, bread);
        HBox hbox3 = new HBox(new Label(), waterLabel, water);
        HBox hbox4 = new HBox(new Label(), shampooLabel, shampoo);
        HBox hbox5 = new HBox(new Label(), ramenLabel, ramen);
        hbox1.setSpacing(15);
        hbox2.setSpacing(15);
        hbox3.setSpacing(15);
        hbox4.setSpacing(15);
        hbox5.setSpacing(15);

        HBox hbox6 = new HBox(hbox1, calculate);
        HBox hbox7 = new HBox(hbox2, totalCol);
        HBox hbox8 = new HBox(hbox3, changeAmount);
        HBox hbox9 = new HBox(hbox4, change);
        HBox hbox10 = new HBox(hbox5, changeCal);
        hbox6.setSpacing(105);
        hbox7.setSpacing(100);
        hbox8.setSpacing(98);
        hbox9.setSpacing(80);
        hbox10.setSpacing(90);

        Image image = new Image(new FileInputStream("src/Logo-removebg-preview.png"));

        ImageView view = new ImageView(image);
        view.setFitHeight(105);
        view.setFitWidth(225);

        Group root = new Group(view);
        HBox image2 = new HBox(new Label(), root);
        image2.setSpacing(40);

        VBox vbox = new VBox(image2, hbox6, hbox7, hbox8, hbox9, hbox10, new HBox());
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.BOTTOM_CENTER);

        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        vbox.setBackground(background);

        Scene scene = new Scene(vbox, 425, 449);

        primaryStage.setTitle("Grocery");
        primaryStage.setScene(scene);
        primaryStage.show();

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Calculate calculate1 = new Calculate();
                calculate1.calculateCost(milk, bread, water, shampoo, ramen, totalCol, newTotal);
            }
        });

        changeCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                int money = Integer.parseInt(changeAmount.getText());
                double amtLeft = Math.round((money - newTotal[0]) * 100.0) / 100.0;
                if(amtLeft >= 0) {
                    String price = amtLeft + "";
                    change.setText("Change: $" + price);
                    NewStage newStage = new NewStage();
                    newStage.newScene(amtLeft, primaryStage, scene);
                } else {
                    String price = amtLeft + "";
                    String price1 = price.substring(price.indexOf("-") + 1);
                    change.setText("New Total: $" + price1);
                    newTotal[0] = amtLeft * -1;
                }
            }
        });


    }
    public static void main(String[] args) {
        launch(args);
    }
}