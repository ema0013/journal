package gui6.screens;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui6.Screen;
import interfaces.Clickable;
import interfaces.Visible;

public abstract class ClickableScreen extends Screen implements MouseListener{

	private ArrayList<Clickable> clickables;

	public ClickableScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();
		for(int i = 0; i < viewObjects.size(); i++){
			if(viewObjects.get(i) instanceof Clickable){
				clickables.add((Clickable) viewObjects.get(i));
			}
		}

	}

	public abstract void initAllObjects(ArrayList<Visible> viewObjects);

	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < clickables.size(); i++){
			if(clickables.get(i).isHovered(e.getX(),e.getY())){
				clickables.get(i).act();
				break;
			}
		}

	}

	public void addObjects(Visible v){
		super.addObjects(v);
		if(v instanceof Clickable){
			clickables.add((Clickable) v);
		}
	}



	public void remove(Visible v){
		super.remove(v);
		clickables.remove(v);
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

	public MouseListener getMouseListener(){
		return this;
	}

}
