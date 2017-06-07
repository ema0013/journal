package interfaces;

import java.awt.event.KeyListener;

public interface KeyedComponent extends KeyListener,Visible {

	public boolean isHovered(int x, int y);

	public void setFocus(boolean b);

}
