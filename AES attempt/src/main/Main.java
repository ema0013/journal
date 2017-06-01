package main;

import aes.AES;
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
	public static void main(String[] args){
//		Main g = new Main(800,600);
//		Thread game = new Thread(g);
//		game.start();
		String textClar = "AES attempt to encrypt";
		 //AES
		 String j = "1a25s8fe5dsg65ad";
		 System.out.println("Original Text: "+textClar);
		 byte[] encr = AES.aesEncrypt(textClar.getBytes(), j.getBytes());
		 System.out.println("Encrypted text "+new String(encr));
	}

}
