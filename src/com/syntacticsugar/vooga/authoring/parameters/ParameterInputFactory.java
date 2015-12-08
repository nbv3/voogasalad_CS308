package com.syntacticsugar.vooga.authoring.parameters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.WarningDialogFactory;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ParameterInputFactory {

	private static Map<Node, Boolean> isSet;
	private static Stage myStage;
	private static Map<Node, Method> myMethodFields;

	public static void createInputFields(Object toEdit) {
		isSet = new HashMap<>();
		myMethodFields = new HashMap<>();
		EditableClass a = toEdit.getClass().getDeclaredAnnotation(EditableClass.class);
		if (a == null)
			return;
		myStage = new Stage();
		Collection<Node> inputFields = inspectEditableFields(toEdit);
		VBox container = new VBox();
		container.getChildren().addAll(inputFields);
		container.setSpacing(10);
		container.setAlignment(Pos.CENTER);
		container.setPadding(new Insets(10));
		Scene scene = new Scene(container);
		myStage.setScene(scene);
		myStage.setTitle(a.className());
		myStage.setOnCloseRequest(e -> checkValidity(e));
		myStage.showAndWait();

	}

	private static void checkValidity(WindowEvent e) {
		for (Boolean b : isSet.values())
			if (!b) {
				boolean result = WarningDialogFactory.createWarningDialog("Not all parameters have been set!");
				if (result) 
					e.consume();
				break;
			}
	}

	private static Collection<Node> inspectEditableFields(Object toEdit) {
		Collection<Node> inputNodes = new ArrayList<>();
		Class<?> c = toEdit.getClass();
		Collection<Method> myMethods = new ArrayList<Method>();
		while (c.getAnnotation(EditableClass.class) != null) {
			Collection<Node> inputFields = new ArrayList<>();
			for (Method m : c.getDeclaredMethods()) {
				if (m.isAnnotationPresent(EditableField.class)) {
					m.setAccessible(true);
					myMethods.add(m);
					EditableField a = m.getAnnotation(EditableField.class);
					String editLabel = a.inputLabel();
					String defaultVal = a.defaultVal();
					inputFields.add(createTextField(toEdit, editLabel, defaultVal, m));
				}
			}
			if (inputFields.size() > 0) {
				Label classLabel = new Label(c.getAnnotation(EditableClass.class).className());
				classLabel.setAlignment(Pos.CENTER);
				inputNodes.add(classLabel);
				inputNodes.addAll(inputFields);
			}
			c = c.getSuperclass();
		}
		Button accept = new Button("ACCEPT");
		accept.setOnAction(e-> checkInputFields(toEdit));
		inputNodes.add(accept);

		return inputNodes;
	}
	
	private static void checkInputFields(Object toEdit)
	{
		int count = 0;
		for(Node key: myMethodFields.keySet())
		{
				Method m = myMethodFields.get(key);
				if(!((TextField)key).getText().equals(null) && !((TextField)key).getText().equals(""))
				{
					try {
						m.invoke(toEdit, ((TextField)key).getText());
						count ++;
					}
						catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							AlertBoxFactory.createObject("Assignment unsuccessful - Java Reflection error");
						}

				}

		}
		if(count == myMethodFields.keySet().size())
		{
			myStage.close();
		}
		else
		{
			WarningDialogFactory.createWarningDialog("All parameters have not been set yet!");
		}

	}

	private static Node createTextField(Object toEdit, String inputLabel, String defaultVal, Method toCall) {
		TextField t = new TextField();
		t.setText(defaultVal);
		GridPane anchor = new GridPane();
		addConstraints(anchor);
		Label label = new Label(inputLabel);
		anchor.getChildren().addAll(label, t);
		GridPane.setConstraints(label, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER, Priority.ALWAYS, Priority.NEVER, new Insets(5));
		GridPane.setConstraints(t, 1, 0, 1, 1, HPos.CENTER, VPos.CENTER, Priority.NEVER, Priority.NEVER, new Insets(5));
		anchor.setAlignment(Pos.CENTER);

		isSet.put(t, false);
		myMethodFields.put(t, toCall);

		return anchor;
	}
	

	private static void addConstraints(GridPane grid) {
		grid.getColumnConstraints().addAll(
				colWithWidth(25), 
				colWithWidth(50),
				colWithWidth(25));
	}

	private static ColumnConstraints colWithWidth(double percentWidth) {
		ColumnConstraints c = new ColumnConstraints();
		c.setPercentWidth(percentWidth);
		return c;
	}

}
