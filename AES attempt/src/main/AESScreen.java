package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import aes.AESJavaX;

import guiTeacher.components.Action;
import guiTeacher.components.Accordion;
import guiTeacher.userInterfaces.Screen;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.OptionAccordion;
import guiTeacher.components.ScrollablePane;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextField;
import guiTeacher.components.TextLabel;
import guiTeacher.userInterfaces.FullFunctionScreen;
import interfaces.Visible;

import main.Main;

public class AESScreen extends FullFunctionScreen implements MouseListener,KeyListener{
	private TextArea title;
	private Button toNotes;
	private Button encrypt;
	private Button decrypt;
	private Button copyOutput;
	private TextField keyInput;
	private TextField stateInput;
	private TextLabel output; 
	private Graphic bg;
	//private ScrollablePane cipherType;
	

	public AESScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<guiTeacher.interfaces.Visible> viewObjects) {
		bg = new Graphic(0, 0,getWidth(),getHeight(), "resources/test.png");
		AESJavaX cipher = new AESJavaX();
		title = new TextArea(300,50,200,100,"AES Cipher in Javax");
		
		toNotes = new Button(25,400,200,100,"Development Notes",Color.blue, new Action(){
			
			public void act(){
				Main.g.setScreen(Main.development);
			}
		});
		encrypt = new Button(200, 300, 60, 50, "Encrypt", Color.red, new Action(){
			public void act(){
				String test = cipher.encrypt(stateInput.getText(),keyInput.getText());
				output.setText(test);
			}
		});
		decrypt = new Button(270,300,60,50,"Decrypt",Color.red,new Action(){
			public void act(){
				String test = cipher.decrypt(stateInput.getText(),keyInput.getText());
				output.setText(test);
			}
		});
		copyOutput = new Button(340,300,100,50,"Copy Output",Color.blue,new Action(){
			public void act(){
				stateInput.setText(output.getText());
			}
		});
		stateInput = new TextField(50, 150, 350, 40, "Input in here");
		keyInput = new TextField(50,200,350,40,"Key in here");
		output = new TextLabel(100,100,400,100,"Output will be displayed here");
		viewObjects.add(title);
		viewObjects.add(toNotes);
		viewObjects.add(stateInput);
		viewObjects.add(keyInput);
		viewObjects.add(output);
		viewObjects.add(encrypt);
		viewObjects.add(decrypt);
		viewObjects.add(copyOutput);
	}

	
	
	
	
	
}
