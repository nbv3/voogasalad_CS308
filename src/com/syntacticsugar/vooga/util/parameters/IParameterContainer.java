package com.syntacticsugar.vooga.util.parameters;

import java.util.Collection;

import javafx.beans.property.ObjectProperty;

public interface IParameterContainer {

	public Collection<ObjectProperty<?>> getParameters();
}
