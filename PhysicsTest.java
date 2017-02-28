import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PhysicsTest extends JFrame //no clue what this is
{
	Canvas drawArea;
	CButton start;
	MouseWatcher mouse;
	
    public PhysicsTest()
    {
    	drawArea = new Canvas();
    	start = new CButton(200,200,300,300);
    	mouse = new MouseWatcher();
    	
    	add(drawArea, BorderLayout.CENTER);
    	drawArea.addMouseListener(mouse);
    	drawArea.setBackground(new Color(255,180,0));
    	
    	setDefaultCloseOperation(3);
    	setSize(600,600);
    	setLocationRelativeTo(null);
    	setVisible(true);
    	
    	//repaint();
    }
    
    public void paint(Graphics g)
    {
    	g = drawArea.getGraphics();
    	g.setColor(new Color(255,180,0));
    	g.fillRect(0,0,600,600);
    	g.setColor(new Color(180,255,0));
    	start.draw(g);

    }
    
    private class MouseWatcher implements MouseListener
    {
    	public void mouseClicked(MouseEvent e)
    	{
    		int x = e.getX();
    		int y = e.getY();
    		if(start.checkCoords(x,y))
    			System.out.println("start");
    	}
		public void mousePressed(MouseEvent e)
		{}
		public void mouseReleased(MouseEvent e)
		{}
		public void mouseEntered(MouseEvent e)
		{}
		public void mouseExited(MouseEvent e)
		{}
    }
    
    public class CButton
    {
    	int x,y,h,w;
    	public CButton()
    	{
    		x=y=h=w=0;
    	}
    	public CButton(int xIn,int yIn,int hIn,int wIn)
    	{
    		x = xIn;
    		y = yIn;
    		h = hIn;
    		w = wIn;
    	}
    	
    	public boolean checkCoords(int xIn,int yIn)
    	{
    		boolean intersect = false;
    		if(xIn >= x && xIn <= x+w && yIn >= y && yIn <= y+h)
    			intersect = true;
    		return intersect;
    	}
    	
    	public void draw(Graphics g)
    	{
    		g.fillRect(x,y,w,h);
    	}
    }
    
    public static void main(String[]args)
    {
    	new PhysicsTest();
    }
    
}