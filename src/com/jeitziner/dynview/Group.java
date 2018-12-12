package com.jeitziner.dynview;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Region;

class Group extends ComponentDecorator {
	private int id;
	private String orientation;

	int getId() {
		return this.id;
	}

	void setId(int id) {
		this.id = id;
	}

	String getOrientation() {
		return this.orientation;
	}

	void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public void show() {
		System.out.println(String.format("id: %d, Orientation: %s", id, orientation));
		for (Component component: this.components) {
			if (component != null) {
				component.show();
			}
		}
	}
	
	public Region getRegion() {
		if (this.components.size() > 1) {
			final SplitPane splitPane = new SplitPane();
			if (this.getOrientation().toLowerCase().equals("horizontal")) {
				splitPane.setOrientation(Orientation.HORIZONTAL);				
			} else {
				splitPane.setOrientation(Orientation.VERTICAL);				
			}
			splitPane.setPadding(new Insets(10));
			for (Component component : this.components) {
				splitPane.getItems().add(component.getRegion());
			}
			return splitPane;
		} else if (this.components.size() == 1) {
			return this.components.get(0).getRegion();
		}

		return null;
	} 		
	
}
