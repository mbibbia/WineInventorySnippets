package com.jeitziner.dynview;

import java.util.ArrayList;

abstract class ComponentDecorator implements Component {
	protected ArrayList<Component> components;

	public ComponentDecorator() {
		this.components = new ArrayList<>();
	}

	public void addChild(Component component) {
		this.components.add(component);
	}
}
