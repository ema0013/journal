package guiTeacher.components;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.KeyedComponent;
import guiTeacher.interfaces.Visible;

public class OptionAccordion extends ScrollablePane{


	
	public OptionAccordion(FocusController focusController, int x, int y, int w, int h) {
		super(focusController, x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public static final int CONTENT_HEIGHT = 310;
	public static final int LATEX_TAB_INDEX = 4;//index of LateX Tab, use for shifting focus to LateX tab
	
	public void initAllObjects(List<Visible> viewObjects){
		TextArea text = new TextArea(20,20,100,25,"With an interest for theatre still at heart, he decided to focus on directing. During this time directing was not a focus point in English theatre, but he used the building blocks of Antoine and Reinhardt to his advantage and contributed to changing the dynamics of production in English theatre. Some of his first assignments were with the Stage Society, but it wasn't until 1904 when he worked with the Royal Court Theatre that his directing career took off. From 1904 to 1907 he was considered to be one of the major reformers of the Edwardian Stage. While working with the Royal Court, he collaborated with J.E. Vedrenne to mount almost 1,000 performances. Many of these performances were classics while some were new pieces work. Among the new pieces of work, were eleven plays written by George Bernard Shaw. Granville-Barker often worked with Shaw to assist in staging his plays and directing them as well.As the Vedrenne-Barker seasons closed with the Royal Court, new opportunities opened with the Duke of York's Theatre in 1910. This new opportunity reminded Granville-Barker of the need for more repertory companies. In 1904 he collaborated with William Archer to write"
				+ " a book that argued for a national theatre, unfortunately it was a lost cause that became one of the biggest disappointments in his life. However, his efforts did not go to waste but added to the growth"
				+ " of the regional repertory movement in Britain.Granville-Barker's directing career boomed with three famous productions of Shakespeare at the Savoy Theatre The Winter's Tale and Twelfth Night during 1912 and A Midsummer Night's Dream in 1914. Granville-Barker took these productions and removed all classic scenery and replaced it with symbolic scenery, as well as enforcing ensemble acting.");
		viewObjects.add(text);
	}
	


}
