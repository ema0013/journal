package main;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class NoteScreen extends FullFunctionScreen implements MouseListener {
	private TextArea notes;
	private Button toAES;

	public NoteScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		notes = new TextArea(250,100,250,400,
				"NOTICE: This implementation of the AES encryption Cipher is NOT "
				+ "my own code. This has been recreated through the JavaX Cipher Class "
				+ "and NOT through my own algorithm. I do not claim to own any of this code "
				+ "nor do I intend on monetizing it. Any part of this program can be used by others "
				+ "of free will w/o any chance of facing copyright infringment. Enjoy your day!");
		toAES = new Button(200,450,100,70,"Return to AES Encryption Screen",Color.CYAN,new Action(){
			public void act(){
				Main.g.setScreen(Main.mainScreen);;
			}
		});
		viewObjects.add(notes);
		viewObjects.add(toAES);
		
	}

}
