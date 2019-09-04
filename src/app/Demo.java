package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Card;
import model.PazaakCard;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Card pc1 = new PazaakCard();
		pc1.setOnDragDetected(e -> {
			System.out.println("onDragDetected");
            /* allow any transfer mode */
            Dragboard db = pc1.startDragAndDrop(TransferMode.ANY);
            /* put a string on dragboard */
            ClipboardContent content = new ClipboardContent();
            content.put(new DataFormat("0"), pc1);
            db.setContent(content);
            e.consume();
		});
		Card pc2 = new PazaakCard(null);
		pc2.setOnDragOver(e -> {
			System.out.println("onDragOver");
            
            /* accept it only if it is  not dragged from the same node 
             * and if it has a string data */
            if (e.getGestureSource() != pc2 &&
                    e.getDragboard().hasContent(new DataFormat("0"))) {
                /* allow for both copying and moving, whatever user chooses */
                e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            
            e.consume();
		});
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
