/** ****************************************************
 * NAME: KEVAL VARIA
 * CLASS: CS4B
 * PROGRAM: BLACKJACK PART 1
 * FILE: BLACKJACK.JAVA
 ***************************************************** */
package blackjack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

/**
 *
 * @author keval
 */
public class Blackjack extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Play New Turn");
        Label result = new Label("Label");
        ImageView imv1 = new ImageView();
        ImageView imv2 = new ImageView();
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Cards card = new Cards();
                card.perpareHands();
                result.setText(card.toString());
                imv1.setImage(card.getImageCard1());
                imv2.setImage(card.getImageCard2());
                System.out.println(card.toString());
            }

        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(result);
        root.getChildren().add(imv1);
        root.getChildren().add(imv2);

        root.setAlignment(btn, Pos.BOTTOM_RIGHT);
        root.setAlignment(result, Pos.BOTTOM_LEFT);
        root.setAlignment(imv1, Pos.TOP_LEFT);
        root.setAlignment(imv2, Pos.TOP_RIGHT);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("BLACKJACK GAME!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
