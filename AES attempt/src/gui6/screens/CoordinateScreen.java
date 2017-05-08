package gui6.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui6.Screen;
import gui6.components.TextLabel;
import gui6.components.Visible;
import gui6.sampleGames.MouseFollower;
import gui6.components.Action;
import gui6.components.Button;
import gui6.components.Graphic;
import gui6.components.MovingComponent;
import gui6.components.TextArea;

public class CoordinateScreen extends Screen implements MouseMotionListener,MouseListener{

	private Button button;
	private TextLabel text;
	private TextArea area;
	private Graphic plumbus;
	
	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(20, 200, 500, 40, "Some text");
		viewObjects.add(text);
		button = new Button(200,200,80,40,"Button",new Color(100,100,250),new Action() {
			public void act() {
				MouseFollower.game.setScreen(MouseFollower.sad);
			}
		});
		viewObjects.add(button);
		area = new TextArea(20,300,500,100,"This is really long text."
				+ "It prints over multiple lines, as you can see."
				+ "We worked on this in class. It is called TextArea.");
		viewObjects.add(area);
		plumbus = new Graphic(500,30,200,200,"resources/sampleImages/plumbus.jpg");
		viewObjects.add(plumbus);
		MovingComponent c = new MovingComponent(20,20,100,100);
		viewObjects.add(c);
		c.setVx(2);
		c.setVy(1);
		c.play();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx = e.getX();
		int my = e.getY();
		text.setText("Mouse at "+mx+", "+my);
	}

	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	public MouseListener getMouseListener(){
		return this;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(button.isHovered(e.getX(), e.getY())){
			button.act();
			}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
