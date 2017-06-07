package gui6.components;
//FIELDS

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import interfaces.Action;
import interfaces.Visible;

public abstract class Component implements Visible {

	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage image;
	private BufferedImage buffer;
	private Color foreground;
	private Color background;
	private Visible containingComponent;
	private boolean visible;
	private Action hoverAction;

	public Component(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		foreground = Color.black;
		visible = true;
		background = null;
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	}


	public BufferedImage getImage() {
		return image;
	}

	public void setContainer(Visible container){
		containingComponent = container;
	}

	public void clear(){
		image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		//		return image.createGraphics();
	}


	public Color getForeground() {
		return foreground;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
		update();
	}



	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public int getX() {
		return x;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}


	public Graphics2D resize(){
		clear();
		return image.createGraphics();
	}

	public void update(){
		BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = buffer.createGraphics();
		applyStyles(g);
		update(g);
		image.createGraphics().drawImage(buffer, 0, 0, null);
		if(containingComponent != null)containingComponent.update();
	}

	protected void applyStyles(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public abstract void update(Graphics2D g);

	public boolean isAnimated() {
		return false;
	}



	public Visible getContainingComponent() {
		return containingComponent;
	}


	public void setContainingComponent(Visible containingComponent) {
		this.containingComponent = containingComponent;
	}


	public void hoverAction(){
		doHoverAction();
	}

	public void doHoverAction(){
		if(hoverAction!=null)hoverAction.act();
	}

	public void setHoverAction(Action a){
		this.hoverAction = a;
	}


	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		update();
		this.visible = visible;
	}

}
