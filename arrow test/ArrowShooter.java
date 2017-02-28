import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArrowShooter extends JFrame
{
	Canvas drawArea;
	GameLoop loop;
	PlayerObject player;
	Timer clock; 
	
    public ArrowShooter()
    {
    	drawArea = new Canvas();
    	loop = new GameLoop();
    	player = new PlayerObject(50,50,drawArea);
    	clock = new Timer(30, loop);
    	
    	add(drawArea, BorderLayout.CENTER);
    	player.setColor(new Color(180,60,200));
    	
    	setSize(800,800);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(3);
    	setTitle("Jumpy Man XD v2.34.458.co.uk");
    	
    	clock.start();
    	setVisible(true);
    }
    
    public void paint(Graphics g)
    {
    	g = drawArea.getGraphics();
    	g.setColor(new Color(255,255,255));
    	g.fillRect(0,0,drawArea.getWidth(), drawArea.getHeight());
    	
    	player.draw(g);
    }
    
    public class GameLoop implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		player.runMovement();
    		repaint();
    	}
    }
    
    public class PlayerObject implements KeyListener
    {
    	private boolean up, down, left, right;
    	int x, y;
    	int vSpeed, hSpeed;
    	private int gravity = 2;
    	private int moveSpeed = 8;
    	private int	jumpSpeed = -10;
    	private Rectangle shape;
    	private int interval;
    	private Color shapeColor;
    	
    	public PlayerObject()
    	{
    		up = down = left = right = false;
    		x = y = 0;
    		vSpeed = hSpeed = 0;
    		shape = new Rectangle(0,0,20,20);
    		shapeColor = Color.black;
    	}
    	
    	public PlayerObject(int a, int b,Canvas c)
    	{
    		up = down = left = right = false;
    		x = a;
    		y = b;
    		vSpeed = hSpeed = 0;
    		shape = new Rectangle(0,0,20,20);
    		shapeColor = Color.black;
    		c.addKeyListener(this);
    	}
    	
    	public void runMovement()
    	{
    		hSpeed = ((right ? 1 : 0) - (left ? 1 : 0)) * moveSpeed;
    		vSpeed = (up ? jumpSpeed : vSpeed + gravity);
    		
    		x += hSpeed;
    		y += vSpeed;
    	}
    	
    	public void draw(Graphics g)
    	{
    		g.setColor(shapeColor);
    		g.fillRect(x,y,(int)shape.getWidth(), (int)shape.getHeight());
    	}
    	
    	public void setColor(Color c)
    	{
    		shapeColor = c;
    	}
    	public Color getColor()
    	{
    		return shapeColor;
    	}
    	public void setGravity(int g)
    	{
    		gravity = g;
    	}
    	public int getGravity()
    	{
    		return gravity;
    	}
    	public void setMoveSpeed(int s)
    	{
    		moveSpeed = s;
    	}
    	public int getMoveSpeed()
    	{
    		return moveSpeed;
    	}
    	public void setJumpSpeed(int s)
    	{
    		jumpSpeed = s;
    	}
    	public int getJumpSpeed()
    	{
    		return jumpSpeed;
    	}
    	public void setShape(Rectangle p)
    	{
    		shape = p;
    	}
    	public Rectangle getShape()
    	{
    		return shape;
    	}
    	
    	public void keyTyped(KeyEvent e){}
    	public void keyPressed(KeyEvent e)
    	{
    		int key = e.getKeyCode();
    		
    		if(key == KeyEvent.VK_UP)
    			up = true;
    		else if(key == KeyEvent.VK_DOWN)
    			down = true;
    		else if(key == KeyEvent.VK_LEFT)
    			left = true;
    		else if(key == KeyEvent.VK_RIGHT)
    			right = true;
    	}
    	public void keyReleased(KeyEvent e)
    	{
    		int key = e.getKeyCode();
    		
    		if(key == KeyEvent.VK_UP)
    			up = false;
    		else if(key == KeyEvent.VK_DOWN)
    			down = false;
    		else if(key == KeyEvent.VK_LEFT)
    			left = false;
    		else if(key == KeyEvent.VK_RIGHT)
    			right = false;
    	}
    	
    }
    
    public static void main(String[]args)
    {
    	new ArrowShooter();
    }
    
}