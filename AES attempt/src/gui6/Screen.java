package gui6;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui6.components.Visible;

public abstract class Screen implements Runnable{

	private BufferedImage image;
	protected ArrayList<Visible> viewObjects;


	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initObjects(viewObjects);
		initImage(width, height);
	}

	public abstract void 
	initObjects(ArrayList<Visible> viewObjects);

	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
	}

	public BufferedImage getImage(){
		return image;
	}

	public int getWidth(){
		return image.getWidth();
	}

	public int getHeight(){
		return image.getHeight();
	}

	public void update() {
		Graphics2D g = image.createGraphics();
		//smooth the graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
//		for(int i = 0; i < viewObjects.size(); i++){
//			
//		}
		for(int i = 0; i < viewObjects.size(); i ++){
			Visible v = viewObjects.get(i);
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
	}
	//REPRESENTS ABILITY TO LISTEN TO MOUSE
	//DOESN'T DO ANYTHING YET
	public MouseMotionListener getMouseMotionListener(){
		return null;
	}
	public MouseListener getMouseListener(){
		return null;
	}

	public KeyListener getKeyListener(){
		return null;
	}
	public void addObjects(Visible v){
		viewObjects.add(v);
	}
	
	public void remove(Visible v){
		viewObjects.remove(v);
	}
	
	
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			//the "back" is index 0
			viewObjects.add(0,v);
			// this moves everything else forward in the list.
		}
	}
	
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(v);
		}
	}
	
	
	
	
	
	
	
	
	
	
}














