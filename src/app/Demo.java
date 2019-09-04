package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Card;
import model.PazaakCard;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Card pc1 = new PazaakCard();
		Card pc2 = new Card();

		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(pc1, pc2);
		Scene scene = new Scene(hBox);
		stage.setScene(scene);
		stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
