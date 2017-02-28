import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SuhDude extends JFrame implements ActionListener
{
	JPanel buttonPanel, textPanel;
	JButton encode, decode;
	JTextArea inputText, outputText;
	JScrollPane inputPane, outputPane;
	
	//encoded by letter in base 5
	//suh 5's unit, dude 1's unit
	//extra u so 'a' = suh dude
	//suuuh 	duude
	//2 u=10	1 u=1
	// 10 + 1 = 11
	//   'l'
	
    public SuhDude()
    {
    	buttonPanel = new JPanel();
    	encode = new JButton("Encode");
    	decode = new JButton("Decode");
    	buttonPanel.setLayout(new GridLayout(1,2));
    	buttonPanel.add(encode);
    	buttonPanel.add(decode);
    	
    	encode.addActionListener(this);
    	decode.addActionListener(this);
    	
    	textPanel = new JPanel();
    	inputText = new JTextArea();
    	inputText.setLineWrap(true);
    	outputText = new JTextArea();
    	outputText.setEditable(false);
    	outputText.setLineWrap(true);
    	
    	inputPane = new JScrollPane(inputText,20,30);
    	outputPane = new JScrollPane(outputText,20,30);
    	
    	textPanel.setLayout(new GridLayout(2,1));
    	textPanel.add(inputPane);
    	textPanel.add(outputPane);
    	
    	setLayout(new BorderLayout());
    	add(textPanel, BorderLayout.CENTER);
    	add(buttonPanel, BorderLayout.SOUTH);
    	
    	setSize(400,300);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(3);
    	setTitle("Suh Dude");
    	setVisible(true);
    	
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	String message = inputText.getText().toLowerCase();
    	message = message.replace("\n","");
    	String output = "";
    	JButton button = (JButton)e.getSource();
    	
    	if(button == encode)
    	{
	    	for(int i=0;i < message.length();i++)
	    	{
	    		char letter = message.charAt(i);
	    		
	    		if(letter >= 'a' && letter <= 'z')
	    		{
		    		output += "su";
		    		for(int j=0;j < (letter - 'a') / 5;j++)
		    			output += "u";
		    		
		    		output += "h du";
		    		for(int j=0;j < (letter - 'a') % 5;j++)
		    			output += "u";
		    		
		    		output += "de ";
	    		}
	    		else if(letter == ' ')
	    			output += "yea ";
	    		else if(letter == ',')
	    			output += "uh ";
	    		else if(letter == '.')
	    			output += "later dude ";
	    		else if(letter == '!')
	    			output += "woah dude ";
	    	}
    	}
    	else
    	{
			String letter;
			for(int i=0;i < 26;i++)
			{
				letter = "su";
		    	for(int j=0;j < i / 5;j++)
		    		letter += "u";
		    		
		    	letter += "h du";
		    	for(int j=0;j < i % 5;j++)
		    		letter += "u";
		    		
		    	letter += "de ";
		    	message = message.replace(letter, "" + (char)(i+'a'));
		    	System.out.println(message);
			}
			
    		output = message.replace("yea ", " ").replace(" uh ", " ,").replace("later dude ", ".").replace("woah dude ", "!");
    	}
    	
    	outputText.setText(output);
    	
    }
    
    public static void main(String[]args)
    {
    	new SuhDude();
    }
    
}