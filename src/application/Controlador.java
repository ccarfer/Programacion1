package application;

import java.util.Date;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Intento;

public class Controlador {
	@FXML
	TextField fxml_intentos;
	@FXML
	TextField fxml_numeroIntento;
	@FXML
	TextField fxml_minimo;
	@FXML
	TextField fxml_maximo;
	@FXML
	TextField fxml_mensaje;
	@FXML
	TextField fxml_numeroJugar;
	@FXML
	Button fxml_botongenerar;
	@FXML
	Button fxml_Probar;
	int numeroBuscar;
	
	public void manejaBoton(ActionEvent evento) {
		// resultado.setText(minimo.getText() + "/" + maximo.getText());
		try {
			int numMinimo = Integer.parseInt(fxml_minimo.getText());
			int numMaximo = Integer.parseInt(fxml_maximo.getText());
			if (numMinimo >= numMaximo) {
				fxml_mensaje.setText("min < max  !!");
			} else {
				numeroBuscar = numMinimo + new Random().nextInt(numMaximo - numMinimo);
				fxml_botongenerar.setDisable(true);
				fxml_mensaje.setText("numero correcto");
			}
		} catch (NumberFormatException e) {
			fxml_mensaje.setText("numero erroneo");
		}
	}

	public void manejaBotonJugar(ActionEvent evt) {
		try {
			int numeroJugado = Integer.parseInt(fxml_numeroJugar.getText());
			Intento intento = new Intento(numeroJugado, new Date());
			if (numeroJugado > numeroBuscar) {
				intento.setRespuesta("Pruebe menor");

			} else if (numeroJugado < numeroBuscar) {
				intento.setRespuesta("Pruebe mayor");
				
			} else{
				intento.setRespuesta("¡HAS ACERTADO!");
				fxml_botongenerar.setDisable(false);
				fxml_Probar.setDisable(true);	
			}
			fxml_intentos.appendText(intento.toString());
			

		} catch (NumberFormatException excepcion) {
		}

	}

}

