import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

public class DataManager extends JFrame
{
	JButton calculate;
	JTextField totalIn, usedIn;
	JLabel total, used;
	JPanel inputPanel, titles, textFields;
	JTextArea output;
	ButtonClicked onClick;
	Calendar cal;
    public DataManager()
    {
    	calculate = new JButton("Calculate");
    	totalIn = new JTextField();
    	usedIn = new JTextField();
    	total = new JLabel("Total");
    	used = new JLabel("Used");
    	inputPanel = new JPanel();
    	titles = new JPanel();
    	textFields = new JPanel();
    	output = new JTextArea();
    	onClick = new ButtonClicked();
    	cal = Calendar.getInstance();
    	
    	output.setEditable(false);
    	add(inputPanel,BorderLayout.NORTH);
    	add(output,BorderLayout.CENTER);
    	
    	titles.setLayout(new GridLayout(2,1));
    	titles.add(used);
    	titles.add(total);
    	
    	inputPanel.setLayout(new BorderLayout());
    	inputPanel.add(titles, BorderLayout.WEST);
    	inputPanel.add(textFields, BorderLayout.CENTER);
    	inputPanel.add(calculate, BorderLayout.EAST);
    	calculate.addActionListener(onClick);
    	
    	textFields.setLayout(new GridLayout(2,1));
    	textFields.add(usedIn);
    	textFields.add(totalIn);
    	
    
    	
    	setSize(400,200);
    	setDefaultCloseOperation(3);
    	setTitle("Mobile Data Manager");
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    
    private class ButtonClicked implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		try
    		{
	    		String outputString;
	    		int year = cal.get(Calendar.YEAR);
	    		int month = cal.get(Calendar.MONTH)+1;
	    		int day = cal.get(Calendar.DAY_OF_MONTH);
	    		int tDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    		
	    		int tData = Integer.parseInt(totalIn.getText());
	    		int uData = Integer.parseInt(usedIn.getText());
	    		
	    		
	    		
	    		outputString = String.format("Data statistics for %02d/%02d/%04d (DD/MM/YYYY)",day,month,year);
	    		outputString += String.format("\nDays Remaining: %d ",tDays-day+1);
	    		outputString += String.format("\nData Remaining: %d MB (%d%% used)",tData-uData,(int)((float)uData/(float)tData*100));
	    		outputString += String.format("\nAvailable data per day: %d MB",(tData-uData)/(tDays-day+1));
	    		outputString += String.format("\nToday's optimal usage for current period: %d MB",uData+(tData-uData)/(tDays-day+1));
	    		
	    		output.setText(outputString);
    		}
    		catch(NumberFormatException nfe)
    		{
    			output.setText("error");
    		}
    		
    	}
    }

	public static void main(String[]args)
	{
		new DataManager();
	}
    
}