import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StringFormatter extends JFrame
{
	JTextArea input, output;
	JScrollPane inputPane, outputPane;
	JPanel textFields, optionPane, checkBoxes;
	JButton convert;
	JCheckBox spaces, returns;
	ButtonClicked onClick;
	
    public StringFormatter()
    {
    	input = new JTextArea();
    	input.setLineWrap(true);
    	output = new JTextArea();
    	output.setLineWrap(true);
    	output.setEditable(false);
    	onClick = new ButtonClicked();
    	
    	inputPane = new JScrollPane(input,20,30);
    	outputPane = new JScrollPane(output,20,30);
    	
    	textFields = new JPanel();
    	textFields.setLayout(new GridLayout(2,1));
    	textFields.add(inputPane);
    	textFields.add(outputPane);
    	
    	spaces = new JCheckBox("Spaces");
    	returns = new JCheckBox("Returns");
    	
    	checkBoxes = new JPanel();
    	checkBoxes.setLayout(new GridLayout(1,2));
    	checkBoxes.add(spaces);
    	checkBoxes.add(returns);
    	
    	convert = new JButton("Format");
    	convert.addActionListener(onClick);
    	
    	optionPane = new JPanel();
    	optionPane.setLayout(new GridLayout(2,1));
    	optionPane.add(checkBoxes);
    	optionPane.add(convert);
    	
    	add(textFields, BorderLayout.CENTER);
    	add(optionPane, BorderLayout.SOUTH);
    	
    	setTitle("String Formatter");
    	setSize(400,300);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(3);
    	setVisible(true);
    }
    
    private class ButtonClicked implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		StringBuilder editString = new StringBuilder(input.getText());
    		long time = System.currentTimeMillis();
    		
    		if(spaces.isSelected())
    		{
	    		try
	    		{
	    			while(true)
	    			{
	    				editString.deleteCharAt(editString.indexOf(" "));
	    			}
	    		}
	    		catch(Exception o){}
    		}
    		
    		if(returns.isSelected())
    		{
    			try
	    		{
	    			while(true)
	    			{
	    				editString.deleteCharAt(editString.indexOf("\n"));
	    			}
	    		}
	    		catch(Exception o){}
    		}
    		output.setText(editString.toString());
    		
    		time = System.currentTimeMillis() - time;
    		System.out.println("Execution Time: " + time);
    	}
    }
    
    public static void main(String[]args)
    {
    	new StringFormatter();
    }
    
}