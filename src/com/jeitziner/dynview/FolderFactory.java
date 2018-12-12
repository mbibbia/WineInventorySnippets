package com.jeitziner.dynview;

import javafx.scene.layout.Region;

class FolderFactory {	
	static Region getRegion(int type) {
		Region region = null;

		switch (type) {
		case 1:
			region = Main.createButtonPane("redBackground");
			break;

		case 2:
			region = Main.createButtonPane("blueBackground");
			break;

		case 3:
			region = Main.createButtonPane("yellowBackground");
			break;

		case 4:
			region = Main.createButtonPane("greenBackground");
			break;

		default:
			// log
			region = null;
		}

		return region;
	}
}
