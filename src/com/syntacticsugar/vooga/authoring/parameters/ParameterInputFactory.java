package com.syntacticsugar.vooga.authoring.parameters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ParameterInputFactory {
	
	public static Node createInputFields(Object toEdit) {
		Collection<Node> inputFields = inspectEditableFields(toEdit);
		VBox container = new VBox();
		container.getChildren().addAll(inputFields);
		container.setSpacing(10);
		container.setAlignment(Pos.CENTER);
		container.setPadding(new Insets(10));
		return container;
	}
	
	private static Collection<Node> inspectEditableFields(Object toEdit) {
		Collection<Node> inputNodes = new ArrayList<>();
		Class<?> c;
		while (true) {
			c = toEdit.getClass();
			for (Method m : toEdit.getClass().getDeclaredMethods()) {
				if (m.isAnnotationPresent(EditableField.class)) {
					m.setAccessible(true);
					EditableField a = m.getAnnotation(EditableField.class);
					String editLabel = a.inputLabel();
					String defaultVal = a.defaultVal();
					inputNodes.add(createTextField(toEdit, editLabel, defaultVal, m));
				}
			}
			if (c.getSuperclass().getAnnotation(EditableField.class) != null) {
				
			}
		}
		return inputNodes;
	}
	
	private static Node createTextField(Object toEdit, String inputLabel, String defaultVal, Method toCall) {
		TextField t = new TextField();
		t.setText(defaultVal);
		HBox anchor = new HBox();
		Button b = new Button("OK");
		t.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {
				processInput(toEdit, t.getText(), toCall);
			}
		});
		b.setOnAction(e -> processInput(toEdit, t.getText(), toCall));
		Label label = new Label(inputLabel);
		anchor.getChildren().addAll(label, t, b);
		anchor.setSpacing(10);
		anchor.setAlignment(Pos.CENTER);
		HBox.setHgrow(label, Priority.ALWAYS);
		return anchor;
	}
	
	private static void processInput(Object toEdit, String input, Method toCall) {
		try {
			toCall.invoke(toEdit, input);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			AlertBoxFactory.createObject("Assignment unsuccessful - Java Reflection error");
		}
	}
}
