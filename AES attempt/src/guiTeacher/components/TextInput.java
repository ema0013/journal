package guiTeacher.components;

import java.awt.event.KeyEvent;

public class TextInput extends TextField {

	public TextInput(int x, int y, int w, int h, String text) {
		super(50, 500, 350, 50, "text in here");
		// TODO Auto-generated constructor stub
	}
	public void keyTyped(KeyEvent e){
		super.keyTyped(e);
		char c = e.getKeyChar();
		String t = getText();
		
	}
	

}
