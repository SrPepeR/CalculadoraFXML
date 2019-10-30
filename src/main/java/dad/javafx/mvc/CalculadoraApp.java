package dad.javafx.mvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraApp extends Application{
	
	private CalculadoraController controller;
	
	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new CalculadoraController();
		
		Scene scene = new Scene(controller.getRoot(), 450, 550);
		
		primaryStage.setTitle("Calculadora FXML");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
