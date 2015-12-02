package com.syntacticsugar.vooga.util.gui.factory;

import java.net.URL;
import java.util.Optional;

import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class SliderDialogFactory {

	public static double createSliderDialog(String header, double min, double max, double step) {
		// Create the custom dialog.
		Dialog<Double> dialog = new Dialog<Double>();
		dialog.setHeaderText(header);


		// Set the button types.
		ButtonType done = new ButtonType("Done", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(done, ButtonType.CANCEL);

		Slider slider = buildSlider(min, max, step);
		
//		// Create the username and password labels and fields.
//		GridPane grid = new GridPane();
//		grid.setHgap(10);
//		grid.setVgap(10);
		slider.setPadding(new Insets(30));

//		grid.add(slider, 1, 0);

		dialog.getDialogPane().setContent(slider);

		// Request focus on the username field by default.
		slider.requestFocus();

		// Convert the result to a username-password-pair when the login button is clicked.
		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == done) {
		        return slider.getValue();
		    }
		    return Double.MIN_VALUE;
		});

		Optional<Double> result = dialog.showAndWait();
		return result.isPresent() ? result.get() : Double.MIN_VALUE;
	}

	private static Slider buildSlider(double min, double max, double step) {
		Slider slider = new Slider();
		slider.setMin(min);
		slider.setMax(max);
		slider.setMajorTickUnit(step);
		slider.setMinorTickCount(0);
		slider.setShowTickLabels(true);
		slider.setSnapToTicks(true);
		slider.setShowTickMarks(true);
		slider.setValue((min+max)/2.0);
		return slider;
	}
	
}
