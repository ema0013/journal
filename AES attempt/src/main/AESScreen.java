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
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.OptionAccordion;
import guiTeacher.components.ScrollablePane;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextColoredLabel;
import guiTeacher.components.TextField;
import guiTeacher.components.TextLabel;
import guiTeacher.userInterfaces.FullFunctionScreen;
import interfaces.Visible;

import main.Main;

public class AESScreen extends FullFunctionScreen implements MouseListener,KeyListener{
	private TextColoredLabel title;
	private ClickableGraphic toNotes;
	private Button encrypt;
	private Button decrypt;
	private Button copyOutput;
	private TextField keyInput;
	private TextField stateInput;
	private TextColoredLabel output;
	private TextColoredLabel whatThis;
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
		title = new TextColoredLabel(300,50,150,30,"AES Cipher in Javax", Color.BLUE, Color.yellow);
		
		toNotes = new ClickableGraphic(10,400,250,100,"resources/development arrow.png");
		toNotes.setAction(new Action(){
			
			public void act(){
				Main.g.setScreen(Main.development);
			}
		});
		encrypt = new Button(50, 300, 60, 50, "Encrypt", Color.red, new Action(){
			public void act(){
				if(keyInput.getText().length()!=16){
					output.setText("Please refrain from using keys that aren't of length 16.");
				}
				else{
					String test = AESJavaX.encrypt(stateInput.getText(),keyInput.getText());
					output.setText(test);
				}
			}
		});
		decrypt = new Button(120,300,60,50,"Decrypt",Color.red,new Action(){
			public void act(){
				if(keyInput.getText().length()!=16){
					output.setText("Please refrain from using keys that aren't of length 16.");
				}
				else{
					String test = AESJavaX.decrypt(stateInput.getText(),keyInput.getText());
					output.setText(test);
				}
				
			}
		});
		copyOutput = new Button(190,300,100,50,"Copy Output",Color.blue,new Action(){
			public void act(){
				stateInput.setText(output.getText());
			}
		});
		stateInput = new TextField(50, 200, 350, 40, "Input in here");
		keyInput = new TextField(50,250,350,40,"Key in here");
		output = new TextColoredLabel(50,100,400,100,"Output will be displayed here", Color.white, Color.black);
		whatThis = new TextColoredLabel(470,50,300,400,
				"The AES Cipher(Advanced Encryption Standard)"
				+ "is a popular form of modern encryption that has many real life applications."
				+ " It is a symmetric block cipher, meaning it has numerous blocks(mini-steps) which"
				+ " will result in a final output. Try and create your own encrypted message for your friends to"
				+ " crack!"
				,Color.white,Color.black);
		viewObjects.add(bg);
		viewObjects.add(title);
		viewObjects.add(toNotes);
		viewObjects.add(stateInput);
		viewObjects.add(keyInput);
		viewObjects.add(output);
		viewObjects.add(encrypt);
		viewObjects.add(decrypt);
		viewObjects.add(copyOutput);
		viewObjects.add(whatThis);
	}

	
	
	
	
	
}
