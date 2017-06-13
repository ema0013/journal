package guiTeacher.components;

import java.awt.event.KeyEvent;

public class TextInput extends TextField {

	public TextInput(int x, int y, int width, int height, String text) {
		super(x, y, width, height, text);
		// TODO Auto-generated constructor stub
	}
	public void keyTyped(KeyEvent e){
		super.keyTyped(e);
		char c = e.getKeyChar();
		String t = getText();
		
	}
	

}
