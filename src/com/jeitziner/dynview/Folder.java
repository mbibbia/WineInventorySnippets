package com.jeitziner.dynview;

import javafx.scene.layout.Region;

public class Folder implements Component {
	private int id;
	private String type;

	public Folder(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public void show() {
		System.out.println(String.format("Folder: %d %s", this.id, this.type));
	}
	
	public Region getRegion() {
		return FolderFactory.getRegion(this.id);
	}
	

}
