package main;

//import aes.AES;
import gui6.GUIApplication;

import java.security.Key;

import javax.crypto.Cipher;

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
		 String j = "1a25s8fe5dsg65ad";
		 Cipher test = Cipher.getInstance("AES");
		 Key keyTest = j.getBytes().getEncoded();
		 System.out.println("Original Text: "+textClar);
//		 byte[] encr = AES.aesEncrypt(textClar.getBytes(), j.getBytes());
		 System.out.println("Encrypted text "+new String(encr));
	}

}
