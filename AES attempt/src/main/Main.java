package main;

import gui6.GUIApplication;

public class Main extends GUIApplication{

	public Main(int width, int height) {
		super(width,height);
	}

	@Override
	public void initScreen() {
		AESScreen mainScreen = new AESScreen(600, 800);
		setScreen(mainScreen);
	}

}
