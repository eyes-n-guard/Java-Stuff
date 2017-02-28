import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinaryClock extends JFrame
{
	JButton plus,minus,plus10,minus10;
	JPanel bits,buttons;
	JLabel[] labels = new JLabel[8];
	JTextField numIn;
	int count = 0;
	Timer time;
	ButtonClicked onClick;
	
    public BinaryClock()
    {
    	plus = new JButton("+");
    	minus = new JButton("-");
    	plus10 = new JButton("+10");
    	minus10 = new JButton("-10");
    	numIn = new JTextField();
    	bits = new JPanel();
    	buttons = new JPanel();
    	onClick = new ButtonClicked();
    	time = new Timer(1000,onClick);
    	
    	add(bits,BorderLayout.CENTER);
    	add(buttons,BorderLayout.SOUTH);
    	
    	bits.setLayout(new GridLayout(1,8));
    	for(int i=7;i>=0;i--)
    	{
    		labels[i] = new JLabel("0");
    		labels[i].setFont(labels[i].getFont().deriveFont(30.0f));
    		labels[i].setHorizontalAlignment(0);
    		bits.add(labels[i]);
    	}
    	
    	buttons.setLayout(new GridLayout(1,5));
    	buttons.add(plus10);
    	buttons.add(plus);
    	buttons.add(numIn);
    	buttons.add(minus);
    	buttons.add(minus10);
    	
    	plus.setFont(plus.getFont().deriveFont(20.0f));
    	plus.addActionListener(onClick);
    	
    	minus.setFont(minus.getFont().deriveFont(20.0f));
    	minus.addActionListener(onClick);
    	
    	plus10.setFont(plus10.getFont().deriveFont(20.0f));
    	plus10.addActionListener(onClick);
    	
    	minus10.setFont(minus10.getFont().deriveFont(20.0f));
    	minus10.addActionListener(onClick);
    	
    	numIn.setFont(numIn.getFont().deriveFont(20.0f));
    	numIn.addActionListener(onClick);
    	numIn.setHorizontalAlignment(0);
    	
    	setSize(1000,150);
    	setDefaultCloseOperation(3);
    	setTitle("Binary Counter");
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    
    private class ButtonClicked implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		JButton button = null;
    		try
    		{
    			button = (JButton)e.getSource();
    		}
    		catch(Exception ex){}
    		
    		if(plus == button)
    			count = Math.min(255,count + 1);
    		else if(minus == button)
    			count = Math.max(0,count - 1);
    		else if(plus10 == button)
    			count = Math.min(255,count + 10);
    		else if(minus10 == button)
    			count = Math.max(0,count - 10);
    		else if(e.getSource() == time)
    		{
    			numIn.setText("");
    			numIn.setEditable(true);
    			time.stop();
    		}
    		else
    			try
    			{
    				count = Math.max(0,Math.min(255,Integer.parseInt(numIn.getText())));
    				numIn.setText("");
    			}
    			catch(NumberFormatException nfe)
    			{
    				numIn.setEditable(false);
    				numIn.setText("ERROR");
    				time.start();
    			}
    		
    		for(int i=0;i<8;i++)
    			labels[i].setText("" + Math.min(1,(int)Math.pow(2,i) & count));
    	}
    }
    
    public static void main(String[]args)
    {
    	new BinaryClock();
    }
    
}