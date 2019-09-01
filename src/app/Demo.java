package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.CardInfo;
import view.PazaakCard;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		GridPane gridPane = new GridPane();
//		displayPosCards(gridPane);
//		displayNegCards(gridPane);
//		displayCards(gridPane);
		int row = 0;
		int col = 0;
		while (true) {
			gridPane.add(new PazaakCard(), col, row);
			col++;
			if (col >= 3) {
				col = 0;
				row++;
			}
			
			if (row >= 3) {
				break;
			}
		}
		
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10));
		Scene scene = new Scene(gridPane);
		stage.setScene(scene);
		stage.show();
	}
	
//	public void displayPosCards(GridPane gridPane) {
//		PazaakCard card1 = new PazaakCard(new CardInfo(1));
//		PazaakCard card2 = new PazaakCard(new CardInfo(2));
//		PazaakCard card3 = new PazaakCard(new CardInfo(3));
//		PazaakCard card4 = new PazaakCard(new CardInfo(4));
//		PazaakCard card5 = new PazaakCard(new CardInfo(5));
//		PazaakCard card6 = new PazaakCard(new CardInfo(6));
//		gridPane.addRow(0, card1, card2, card3, card4, card5, card6);
//	}
//	
//	public void displayNegCards(GridPane gridPane) {
//		PazaakCard card1 = new PazaakCard(new CardInfo(-1));
//		PazaakCard card2 = new PazaakCard(new CardInfo(-2));
//		PazaakCard card3 = new PazaakCard(new CardInfo(-3));
//		PazaakCard card4 = new PazaakCard(new CardInfo(-4));
//		PazaakCard card5 = new PazaakCard(new CardInfo(-5));
//		PazaakCard card6 = new PazaakCard(new CardInfo(-6));
//		gridPane.addRow(1, card1, card2, card3, card4, card5, card6);
//	}
//	
//	public void displayCards(GridPane gridPane) {
//		PazaakCard card1 = new PazaakCard(null);
//		PazaakCard card2 = new PazaakCard();
//		PazaakCard card3 = new PazaakCard();
//		PazaakCard card4 = new PazaakCard();
//		PazaakCard card5 = new PazaakCard();
//		PazaakCard card6 = new PazaakCard();
//		gridPane.addRow(2, card1, card2, card3, card4, card5, card6);
//	}
	
	public static void main(String[] args) {
		launch();
	}
}
