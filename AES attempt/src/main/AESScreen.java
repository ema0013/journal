package main;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import guiTeacher.components.Action;
import guiTeacher.components.Accordion;
import guiTeacher.userInterfaces.Screen;
import guiTeacher.components.Button;
import guiTeacher.components.OptionAccordion;
import guiTeacher.components.ScrollablePane;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.components.TextInput;
import guiTeacher.userInterfaces.FullFunctionScreen;
import interfaces.Visible;

import main.Main;

public class AESScreen extends FullFunctionScreen implements MouseListener,KeyListener{
	private TextArea title;
	private Button toNotes;
	private Button encrypt;
	private Button decrypt;
	private Cipher cipher;
	private TextField keyInput;
	private TextField stateInput;
	private ScrollablePane cipherType;
	

	public AESScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		// TODO Auto-generated method stub

	}
	public String AESencrypt(String text,String key){ // 128 bit key
		byte[] encrypted = null;

		// Create key and cipher
		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// encrypt the text
		try {
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			encrypted = cipher.doFinal(text.getBytes());
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(Base64.getEncoder().encodeToString(encrypted));

	}
	public String aesDecrypt(String input,String key){// 128 bit key
		String decrypted = null;
		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			decrypted = new String(cipher.doFinal(input.getBytes()));
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return decrypted;
	}


	@Override
	public void initAllObjects(List<guiTeacher.interfaces.Visible> viewObjects) {
		cipher = null;
//		cipherType = new OptionAccordion(this,40,40,100,100);
//		viewObjects.add(cipherType);
		title = new TextArea(300,50,200,100,"AES Cipher in Javax");
		
		toNotes = new Button(25,400,200,100,"Development Notes",Color.blue, new Action(){
			
			public void act(){
				Main.g.setScreen(Main.development);
			}
		});
		encrypt = new Button(200, 50, 50, 50, "Encrypt", Color.red, new Action(){
			public void act(){
				
			}
		});
		stateInput = new TextInput(50, 150, 350, 50, "Input in here");
		keyInput = new TextInput(50,200,350,50,"Key in here");
		viewObjects.add(title);
		viewObjects.add(toNotes);
		viewObjects.add(stateInput);
		viewObjects.add(keyInput);
	}

	
	
	
	
	
}
