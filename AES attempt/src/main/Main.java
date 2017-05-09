package main;

import gui6.GUIApplication;

public class Main extends GUIApplication{

	public Main(int width, int height) {
		super(width,height);
	}

	@Override
	public void initScreen() {
		AESScreen mainScreen = new AESScreen(getWidth(), getHeight());
		setScreen(mainScreen);
	}
	public static void Main(String[] args){
		Main g = new Main(800,600);
		Thread game = new Thread(g);
		game.start();
	}

}
