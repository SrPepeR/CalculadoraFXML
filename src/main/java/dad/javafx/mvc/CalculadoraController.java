package dad.javafx.mvc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CalculadoraController implements Initializable{
	
	Calculadora calc = new Calculadora();
	
	//Properties del MODEL
	DoubleProperty resultadoProperty = new SimpleDoubleProperty(0.0);
	
	//Componentes del VIEW
	@FXML
	GridPane contenido;
	
	@FXML
	Label resultadoLabel;
	
	@FXML
	Button ceroButton;
	@FXML
	Button unoButton;
	@FXML
	Button dosButton;
	@FXML
	Button tresButton;
	@FXML
	Button cuatroButton;
	@FXML
	Button cincoButton;
	@FXML
	Button seisButton;
	@FXML
	Button sieteButton;
	@FXML
	Button ochoButton;
	@FXML
	Button nueveButton;

	@FXML
	Button sumaButton;
	@FXML
	Button restaButton;
	@FXML
	Button multiplicacionButton;
	@FXML
	Button divisionButton;
	@FXML
	Button puntoButton;
	@FXML
	Button resultadoButton;
	@FXML
	Button cButton;
	@FXML
	Button ceButton;
	
	public CalculadoraController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Calculadora.fxml"));
 		loader.setController(this);
		loader.load();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ceroButton.setOnAction(e -> onBotonAction('0'));
		unoButton.setOnAction(e -> onBotonAction('1'));
		dosButton.setOnAction(e -> onBotonAction('2'));
		tresButton.setOnAction(e -> onBotonAction('3'));
		cuatroButton.setOnAction(e -> onBotonAction('4'));
		cincoButton.setOnAction(e -> onBotonAction('5'));
		seisButton.setOnAction(e -> onBotonAction('6'));
		sieteButton.setOnAction(e -> onBotonAction('7'));
		ochoButton.setOnAction(e -> onBotonAction('8'));
		nueveButton.setOnAction(e -> onBotonAction('9'));
		
		puntoButton.setOnAction(e -> onBotonAction(','));
		sumaButton.setOnAction(e -> onBotonAction('+'));
		restaButton.setOnAction(e -> onBotonAction('-'));
		multiplicacionButton.setOnAction(e -> onBotonAction('*'));
		divisionButton.setOnAction(e -> onBotonAction('/'));
		resultadoButton.setOnAction(e -> onBotonAction('='));
		cButton.setOnAction(e -> onBotonAction('c'));
		ceButton.setOnAction(e -> onBotonAction('C'));
		
	}
	
	

	private void onBotonAction(char c) {
		if (Character.isDigit(c)) {
			calc.insertar(c);
		}else {
			if(c == ',') {
				calc.insertarComa();
			}else {
				switch (c) {
				case '+':
					calc.operar(Calculadora.SUMAR);
					break;
				case '-':
					calc.operar(Calculadora.RESTAR);
					break;
				case '*':
					calc.operar(Calculadora.MULTIPLICAR);
					break;
				case '/':
					calc.operar(Calculadora.DIVIDIR);
					break;
				case '=':
					calc.operar(Calculadora.IGUAL);
					break;
				case 'c':
					calc.borrar();
					break;
				case 'C':
					calc.borrarTodo();
					break;
				}
			}
		}
		resultadoLabel.setText(calc.getPantalla());
	}

	public GridPane getRoot() {
		return contenido;
	}
	
}
