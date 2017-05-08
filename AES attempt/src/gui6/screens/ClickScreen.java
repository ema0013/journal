package gui6.screens;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui6.Screen;
import gui6.components.Action;
import gui6.components.ClickableGraphic;
import gui6.components.Visible;

public class ClickScreen extends Screen implements MouseMotionListener,MouseListener{

	private ClickableGraphic pic;

	public ClickScreen(int width, int height) {
		super(width, height);

	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		pic = new ClickableGraphic(500,30,200,200,"resources/sampleImages/plumbus.jpg");
		pic.setAction(new Action(){
			public void act(){
				pic.setX(pic.getX()+10);
			}
		});
		viewObjects.add(pic);

	}

	public MouseListener getMouseListener(){
		return this;
	}

	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(pic.isHovered(e.getX(), e.getY())){
			pic.act();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
