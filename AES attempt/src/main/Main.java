package main;

//import aes.AES;
import guiTeacher.GUIApplication;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

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
				Main g = new Main(800,600);
				Thread game = new Thread(g);
				game.start();
				g.setVisible(true);
		

	}

}
