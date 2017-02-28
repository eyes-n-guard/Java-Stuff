import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RockPaperScissors extends JFrame implements ActionListener
{
	JLabel humanScore;
	JLabel robotScore;
	JPanel humanInput;
	JLabel robotInput;
	JButton rock;
	JButton paper;
	JButton scissors;
	JPanel scorePanel;
	JPanel gamePanel;
	
	int rScore;
	int hScore;
	
	int[][] paths = new int[3][3];
	int last;
	
    public RockPaperScissors()
    {
    	humanScore = new JLabel("player: 0");
    	robotScore = new JLabel("robot: 0");
    	humanInput = new JPanel();
    	robotInput = new JLabel();
    	rock = new JButton("Rock");
    	paper = new JButton("Paper");
    	scissors = new JButton("Scissors");
    	scorePanel = new JPanel();
    	gamePanel = new JPanel();
    	rScore = 0;
    	hScore = 0;
    	
    	robotInput.setHorizontalAlignment(0);
    	
    	for(int i=0;i < paths.length;i++)
    		for(int j=0;j < paths[0].length;j++)
    			paths[i][j] = 1;
    	last = 0;
    	
    	rock.addActionListener(this);
    	paper.addActionListener(this);
    	scissors.addActionListener(this);
    	
    	humanInput.setLayout(new GridLayout(3,1));
    	humanInput.add(rock);
    	humanInput.add(paper);
    	humanInput.add(scissors);
    	
    	gamePanel.setLayout(new GridLayout(1,2));
    	gamePanel.add(humanInput);
    	gamePanel.add(robotInput);
    	
    	scorePanel.setLayout(new GridLayout(1,2));
    	scorePanel.add(humanScore);
    	scorePanel.add(robotScore);
    	
    	setLayout(new BorderLayout());
    	add(gamePanel,BorderLayout.CENTER);
    	add(scorePanel,BorderLayout.SOUTH);
    	
    	setSize(600,400);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(3);
    	setTitle("Rock Paper Scissors");
    	setVisible(true);
    	
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	int robotChoice;
    	int total = 0;
    	for(int i=0;i < paths.length;i++)
    		total += paths[last][i];
    	
    	double rand = Math.random() * (double)(total+1);
    	for(robotChoice=paths.length-1;robotChoice >= 0 && rand < total;robotChoice--)
    		total -= paths[last][robotChoice];
    	robotChoice += 2;
    	robotChoice %= 3;
    	
    	System.out.println(last + " " + paths[last][0] + " " + paths[last][1] + " " + paths[last][2] + " " + robotChoice);
    	
    	
    	
    	JButton button = (JButton)e.getSource();
    	int humanChoice;
    	if(button == rock)
    		humanChoice = 0;
    	else if(button == paper)
    		humanChoice = 1;
    	else
    		humanChoice = 2;
    	
    	System.out.println(humanChoice + "\n");
    	
    	paths[last][humanChoice]++;
    	last = humanChoice;
    	
    	if(robotChoice == 0)
    		robotInput.setText("Rock");
    	else if(robotChoice == 1)
    		robotInput.setText("Paper");
    	else
    		robotInput.setText("Scissors");
    	
    	if(humanChoice != robotChoice)
    	{
    		if((robotChoice + 1) % 3 == humanChoice) //human wins
    		{
    			hScore++;
    			humanScore.setText("player: " + hScore);
    		}
    		else
    		{
    			rScore++;
    			robotScore.setText("robot: " + rScore);
    		}
    	}
    	
    }
    
    public static void main(String[]args)
    {
    	new RockPaperScissors();
    }
    
}