import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class MainPanel extends JPanel 
{
	private JPanel StartScreen, SettingScreen, GameScreen, StatsScreen;
	private JLabel SettingLabel0, SettingLabel1, StatsLabel0, StockPicture, Points, StockName, AttemptLabel, BaseBall0, BaseBall1, BaseBall2;
	private JTextField StockTicSym0, StockTicSym1, StockTicSym2, StockTicSym3, StockTicSym4;
	//private Vector<JTextField> StockTicSym;
	private Vector<String> Stocks = new Vector<String>();
	private Vector<Double> priceChange = new Vector<Double>();
	private JButton Start0Button, Start1Button, BackButton0, BackButton1, StatsButton, ThrowButton0, ThrowButton1, ThrowButton2, ThrowButton3, ThrowButton4, ThrowButton5;
	private JComboBox<String> Time;
	private JTable StatsTable;
	
	static String TimeSelcted, Stock0, Stock1, Stock2, Stock3, Stock4, CurrentStock;
	static int UserChoice, AIChoice, AttemptNumber = 2, PointTracker, StockCount, OverallAttemptNumber;
	int stockCounter = 0;
	
	public MainPanel()
	{
		StartScreen = new JPanel();
		SettingScreen = new JPanel();
		StatsScreen = new JPanel();
		GameScreen = new JPanel(); 
		
		Object rowData[][] = { { "Stock: ", "Date/Time: ", "Percentage: " },
                { " AAPL", "4/17/15 at 9:30am TO 4/18/15 at 4:00pm", "-1.13%" },
                { " MSFT", "4/17/15 at 9:30am TO 4/18/15 at 4:00pm", "-1.29%" },
                { " BAC", "4/17/15 at 9:30am TO 4/18/15 at 4:00pm", "-1.46%" },
                { " GE", "4/17/15 at 9:30am TO 4/18/15 at 4:00pm", "-0.11%" },
                { " MAT", "4/17/15 at 9:30am TO 4/18/15 at 4:00pm", "+5.84%" },
                { " CSCO", "4/17/15 at 9:30am TO 4/18/15 at 4:00pm", "-2.40%" },
                { " F", "4/17/15 at 9:30am TO 4/18/15 at 4:00pm", "-1.13%" },
                { " MYL", "4/17/15 at 9:30am TO 4/18/15 at 4:00pm", "+4.46%" },
                { " T", "4/17/15 at 9:30am TO 4/18/15 at 4:00pm", "-0.73%" },
                { " PFE", "4/17/15 at 9:30am TO 4/18/15 at 4:00pm", "-0.43%" }};
Object columnNames[] = { "Stock1", "Stock2", "Stock3" };
StatsTable = new JTable(rowData, columnNames);
StatsTable.setBorder(BorderFactory.createLineBorder(Color.black));

		
		String[] timeStrings = { "One Month",  "One Hour", "One Day" };
		
		Time = new JComboBox<String>(timeStrings);
		Time.setSelectedIndex(2);
		
		ImageIcon image = new ImageIcon("soaring-stocks1.jpg");
		BaseBall0 = new JLabel();
		BaseBall1 = new JLabel();
		BaseBall2 = new JLabel();
		AttemptLabel = new JLabel("Attempts Remaining: 2");
		StockName = new JLabel("");
		Points = new JLabel("Points: 0");
		Points.setAlignmentX(RIGHT_ALIGNMENT);
		Points.setAlignmentY(RIGHT_ALIGNMENT);
		StockPicture = new JLabel();
		StockPicture.setIcon(image);
		StockPicture.setAlignmentY(CENTER_ALIGNMENT);
		StockPicture.setAlignmentX(CENTER_ALIGNMENT);
		SettingLabel0 = new JLabel("Enter the stocks you will be using: ");
		SettingLabel1 = new JLabel("Enter the time frame you will be using: ");
		StatsLabel0 = new JLabel("The stats of your current stocks: ");
		StatsLabel0.setAlignmentY(CENTER_ALIGNMENT);
		StatsLabel0.setAlignmentX(CENTER_ALIGNMENT);
		
		StockTicSym0 = new JTextField(4);
		StockTicSym1 = new JTextField(4);
		StockTicSym2 = new JTextField(4);
		StockTicSym3 = new JTextField(4);
		StockTicSym4 = new JTextField(4);
		
		
		
		ThrowButton0 = new JButton("Walk (< -2.5%)");
		ThrowButton1 = new JButton("Change Up(-2.49% Thru -1.25%)");
		ThrowButton2 = new JButton("Curveball(-1.25 Thru 0%)");
		ThrowButton3 = new JButton("Screwball(0 Thru +1.25%)");
		ThrowButton4 = new JButton("Fastball(+1.26 Thru +2.5%)");
		ThrowButton5 = new JButton("Fireball(+2.51% and over)");
		BackButton0 = new JButton("Back");
		StatsButton = new JButton("Stats");
		StatsButton.setAlignmentY(CENTER_ALIGNMENT);
		StatsButton.setPreferredSize(new Dimension(80,90));
		BackButton1 = new JButton("Back");
		BackButton1.setAlignmentY(CENTER_ALIGNMENT);
		BackButton1.setAlignmentX(CENTER_ALIGNMENT);
		Start0Button = new JButton("Start!");
		Start0Button.setAlignmentY(CENTER_ALIGNMENT);
		Start0Button.setPreferredSize(new Dimension(80,90));
		Start1Button = new JButton("Click Here To Begin!");
		
		ThrowButton0.addActionListener(new Throw0PushListener());
		ThrowButton1.addActionListener(new Throw1PushListener());
		ThrowButton2.addActionListener(new Throw2PushListener());
		ThrowButton3.addActionListener(new Throw3PushListener());
		ThrowButton4.addActionListener(new Throw4PushListener());
		ThrowButton5.addActionListener(new Throw5PushListener());
		StatsButton.addActionListener(new StatsPushListener());
		Start0Button.addActionListener(new SettingsPushListener());
		BackButton0.addActionListener(new BackPushListener());
		BackButton1.addActionListener(new BackPushListener());
		Time.addActionListener(new TimeSelectionListener());
		Start1Button.addActionListener(new StartGameListener());
		
		SettingScreen.setLayout(new GridLayout(10, 10, 10, 10));
		SettingScreen.add(SettingLabel0);
		SettingScreen.add(Box.createRigidArea(new Dimension(0, 90)));
		SettingScreen.add(StockTicSym0);
		SettingScreen.add(StockTicSym1);
		SettingScreen.add(StockTicSym2);
		SettingScreen.add(StockTicSym3);
		SettingScreen.add(StockTicSym4);
		SettingScreen.add(Box.createRigidArea(new Dimension(0, 90)));
		SettingScreen.add(Box.createRigidArea(new Dimension(0, 90)));
		SettingScreen.add(Box.createRigidArea(new Dimension(0, 90)));
		SettingScreen.add(SettingLabel1);
		SettingScreen.add(Box.createRigidArea(new Dimension(0, 90)));
		SettingScreen.add(Time);
		SettingScreen.add(Box.createRigidArea(new Dimension(0, 90)));
		SettingScreen.add(Box.createRigidArea(new Dimension(0, 90)));
		SettingScreen.add(Box.createRigidArea(new Dimension(0, 90)));
		SettingScreen.add(Start1Button);
		SettingScreen.add(BackButton0);
		
		BoxLayout layout1 = new BoxLayout(StartScreen, BoxLayout.Y_AXIS);
		StartScreen.setLayout(layout1);
		StartScreen.add(Box.createRigidArea(new Dimension(0, 60)));
		StartScreen.add(Start0Button);
		StartScreen.add(Box.createRigidArea(new Dimension(0, 20)));
		StartScreen.add(StockPicture);
		StartScreen.add(Box.createRigidArea(new Dimension(0, 20)));
		StartScreen.add(StatsButton);
		StartScreen.add(Box.createRigidArea(new Dimension(0, 60)));
		
		BoxLayout layout2 = new BoxLayout(StatsScreen, BoxLayout.Y_AXIS);
		StatsScreen.setLayout(layout2);
		StatsScreen.add(Box.createRigidArea(new Dimension(0, 30)));
		StatsScreen.add(StatsLabel0);
		StatsScreen.add(Box.createRigidArea(new Dimension(0, 60)));
		StatsScreen.add(StatsTable);
		StatsScreen.add(Box.createRigidArea(new Dimension(0, 50)));
		StatsScreen.add(BackButton1);
		
		GameScreen.setLayout(new GridLayout(6, 2, 10, 10));
		GameScreen.add(Points);
		GameScreen.add(StockName);
		GameScreen.add(AttemptLabel);
		GameScreen.add(BaseBall0);
		GameScreen.add(BaseBall1);
		GameScreen.add(BaseBall2);
		GameScreen.add(Box.createRigidArea(new Dimension(0, 50)));
		GameScreen.add(Box.createRigidArea(new Dimension(0, 50)));
		GameScreen.add(Box.createRigidArea(new Dimension(0, 50)));
		GameScreen.add(Box.createRigidArea(new Dimension(0, 50)));
		GameScreen.add(Box.createRigidArea(new Dimension(0, 50)));
		GameScreen.add(Box.createRigidArea(new Dimension(0, 50)));
		GameScreen.add(ThrowButton0);
		GameScreen.add(ThrowButton1);
		GameScreen.add(ThrowButton2);
		GameScreen.add(ThrowButton3);
		GameScreen.add(ThrowButton4);
		GameScreen.add(ThrowButton5);
		
		StatsScreen.setBackground(Color.decode("#79D2B3"));
		StatsScreen.setPreferredSize(new Dimension(700, 500));
		StartScreen.setBackground(Color.decode("#79D2B3"));
		StartScreen.setPreferredSize(new Dimension(700, 500));
		SettingScreen.setBackground(Color.decode("#79D2B3"));
		SettingScreen.setPreferredSize(new Dimension (700,500));
		GameScreen.setBackground(Color.decode("#79D2B3"));
		GameScreen.setPreferredSize(new Dimension (700,500));
		
		add(StartScreen);
	}
	
	private class SettingsPushListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			removeAll();
			revalidate();
			repaint();
			
			add(SettingScreen);
		}
	}
	
	private class BackPushListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			removeAll();
			revalidate();
			repaint();
			
			add(StartScreen);
		}
	}
	
	private class TimeSelectionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			JComboBox<String> cb = (JComboBox<String>)event.getSource();
	        TimeSelcted = (String) cb.getSelectedItem();
		}
	}
	
	private class StatsPushListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			removeAll();
			revalidate();
			repaint();
			
			add(StatsScreen);
		}
	}
	
	private class StartGameListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			removeAll();
			revalidate();
			repaint();
			
			refreshStockNames();
			StockName.setText("Stock:  " + Stocks.get(stockCounter));
			add(GameScreen);
		}
	}
	
	private class Throw0PushListener implements ActionListener{
		
        public void actionPerformed(ActionEvent event) {
        	UserChoice = 0;
        	BaseBall0.setIcon(null);
            BaseBall1.setIcon(null);
            BaseBall2.setIcon(null);
        	if(refreshPoints() != -1)
        	AttemptNumber = AttemptNumber - 1;
        	AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        	if(AttemptNumber < 1){
        		stockCounter++;
        		AttemptNumber = 2;
        		AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        		OverallAttemptNumber = OverallAttemptNumber + 1;
        		if(StockCount <= OverallAttemptNumber){
        			OverallAttemptNumber = 0;
        			
        			removeAll();
        			revalidate();
        			repaint();
        			
        			if(stockCounter < Stocks.size()) {
        				StockName.setText("Stock:  " + Stocks.get(stockCounter));
            			add(GameScreen);
        			}
        			else {
        				add(StatsScreen);
        			}
        			
        		}
        	}else{
        		ImageIcon image = new ImageIcon("BaseBall.jpg");
        		BaseBall0.setIcon(image);
        		BaseBall1.setIcon(image);
        		BaseBall2.setIcon(image);
        	}
          }
	}
	
	private class Throw1PushListener implements ActionListener{
		
        public void actionPerformed(ActionEvent event) {
        	UserChoice = 1;
        	BaseBall0.setIcon(null);
            BaseBall1.setIcon(null);
            BaseBall2.setIcon(null);
        	if(refreshPoints() != -1)
        	AttemptNumber = AttemptNumber - 1;
        	AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        	if(AttemptNumber < 1){
        		stockCounter++;
        		AttemptNumber = 2;
        		AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        		OverallAttemptNumber = OverallAttemptNumber + 1;
        		if(StockCount <= OverallAttemptNumber){
        			OverallAttemptNumber = 0;
        			
        			removeAll();
        			revalidate();
        			repaint();
        			
        			if(stockCounter < Stocks.size()) {
        				StockName.setText("Stock:  " + Stocks.get(stockCounter));
            			add(GameScreen);
        			}
        			else {
        				add(StatsScreen);
        			}
        		}
        	}else{
        		ImageIcon image = new ImageIcon("BaseBall.jpg");
        		BaseBall0.setIcon(image);
        		BaseBall1.setIcon(image);
        		BaseBall2.setIcon(image);

        	}
          }
	}
	
	private class Throw2PushListener implements ActionListener{
		
        public void actionPerformed(ActionEvent event) {
        	UserChoice = 2;
        	BaseBall0.setIcon(null);
            BaseBall1.setIcon(null);
            BaseBall2.setIcon(null);
        	if(refreshPoints() != -1)
        	AttemptNumber = AttemptNumber - 1;
        	AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        	if(AttemptNumber < 1){
        		stockCounter++;
        		AttemptNumber = 2;
        		AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        		OverallAttemptNumber = OverallAttemptNumber + 1;
        		if(StockCount <= OverallAttemptNumber){
        			OverallAttemptNumber = 0;
        			
        			removeAll();
        			revalidate();
        			repaint();
        			
        			if(stockCounter < Stocks.size()) {
        				StockName.setText("Stock:  " + Stocks.get(stockCounter));
            			add(GameScreen);
        			}
        			else {
        				add(StatsScreen);
        			}
        		}
        	}else{
        		ImageIcon image = new ImageIcon("BaseBall.jpg");
        		BaseBall0.setIcon(image);
        		BaseBall1.setIcon(image);
        		BaseBall2.setIcon(image);

        	}
          }
	}
	
	private class Throw3PushListener implements ActionListener{
		
        public void actionPerformed(ActionEvent event) {
        	UserChoice = 3;
        	BaseBall0.setIcon(null);
            BaseBall1.setIcon(null);
            BaseBall2.setIcon(null);
        	if(refreshPoints() != -1)
        	AttemptNumber = AttemptNumber - 1;
        	AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        	if(AttemptNumber < 1){
        		stockCounter++;
        		AttemptNumber = 2;
        		AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        		OverallAttemptNumber = OverallAttemptNumber + 1;
        		if(StockCount <= OverallAttemptNumber){
        			OverallAttemptNumber = 0;
        			
        			removeAll();
        			revalidate();
        			repaint();
        			
        			if(stockCounter < Stocks.size()) {
        				StockName.setText("Stock:  " + Stocks.get(stockCounter));
            			add(GameScreen);
        			}
        			else {
        				add(StatsScreen);
        			}
        		}
        	}else{
        		ImageIcon image = new ImageIcon("BaseBall.jpg");
        		BaseBall0.setIcon(image);
        		BaseBall1.setIcon(image);
        		BaseBall2.setIcon(image);

        	}
          }
	}
	
	private class Throw4PushListener implements ActionListener{
		
        public void actionPerformed(ActionEvent event) {
        	UserChoice = 4;
        	BaseBall0.setIcon(null);
            BaseBall1.setIcon(null);
            BaseBall2.setIcon(null);
        	if(refreshPoints() != -1)
        	AttemptNumber = AttemptNumber - 1;
        	AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        	if(AttemptNumber < 1){
        		stockCounter++;
        		AttemptNumber = 2;
        		AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        		OverallAttemptNumber = OverallAttemptNumber + 1;
        		if(StockCount <= OverallAttemptNumber){
        			OverallAttemptNumber = 0;
        			
        			removeAll();
        			revalidate();
        			repaint();
        			
        			if(stockCounter < Stocks.size()) {
        				StockName.setText("Stock:  " + Stocks.get(stockCounter));
            			add(GameScreen);
        			}
        			else {
        				add(StatsScreen);
        			}
        		}
        	}else{
        		ImageIcon image = new ImageIcon("BaseBall.jpg");
        		BaseBall0.setIcon(image);
        		BaseBall1.setIcon(image);
        		BaseBall2.setIcon(image);

        	}
          }
	}
	
	private class Throw5PushListener implements ActionListener{
		
        public void actionPerformed(ActionEvent event) {
        	UserChoice = 5;
        	BaseBall0.setIcon(null);
            BaseBall1.setIcon(null);
            BaseBall2.setIcon(null);
        	if(refreshPoints() != -1)
        	AttemptNumber = AttemptNumber - 1;
        	AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        	if(AttemptNumber < 1){
        		stockCounter++;
        		AttemptNumber = 2;
        		AttemptLabel.setText("Attempts Remaining: " + AttemptNumber);
        		OverallAttemptNumber = OverallAttemptNumber + 1;
        		if(StockCount <= OverallAttemptNumber){
        			OverallAttemptNumber = 0;
        			
        			removeAll();
        			revalidate();
        			repaint();
        			
        			if(stockCounter < Stocks.size()) {
        				StockName.setText("Stock:  " + Stocks.get(stockCounter));
            			add(GameScreen);
        			}
        			else {
        				add(StatsScreen);
        			}
        		}
        	}else{
        		ImageIcon image = new ImageIcon("BaseBall.jpg");
        		BaseBall0.setIcon(image);
        		BaseBall1.setIcon(image);
        		BaseBall2.setIcon(image);
        	}
          }
	}
	
	public void refreshStockNames(){
		Stock0 = StockTicSym0.getText().toUpperCase();
		Stock1 = StockTicSym1.getText().toUpperCase();
		Stock2 = StockTicSym2.getText().toUpperCase();
		Stock3 = StockTicSym3.getText().toUpperCase();
		Stock4 = StockTicSym4.getText().toUpperCase();
		if(Stock0 != "") {
			Stocks.add(Stock0);
			ReferenceData st0 = new ReferenceData(Stock0);
			priceChange.add(st0.getPercentChange("a", "b"));
		}
		if(Stock1.length() != 0) {
			Stocks.add(Stock1);
			ReferenceData st1 = new ReferenceData(Stock1);
			priceChange.add(st1.getPercentChange("a", "b"));
		}
		if(Stock2.length() != 0) {
			Stocks.add(Stock2);
			ReferenceData st2 = new ReferenceData(Stock2);
			priceChange.add(st2.getPercentChange("a", "b"));
		}
		if(Stock3.length() !=0) {
			Stocks.add(Stock3);
			ReferenceData st3 = new ReferenceData(Stock3);
			priceChange.add(st3.getPercentChange("a", "b"));
		}
		if(Stock4.length() !=0) {
			System.out.println("Stock 4 != 0");
			Stocks.add(Stock4);
			ReferenceData st4 = new ReferenceData(Stock4);
			priceChange.add(st4.getPercentChange("a", "b"));
		}

		
	}
	
	public int refreshPoints(){
		String PointsText;
		if(priceChange.get(stockCounter) <= -2.5) {
			AIChoice = 0;
		}
		else if(priceChange.get(stockCounter) > -2.5 && priceChange.get(stockCounter) <= -1.25) {
			AIChoice = 1;
		}
		else if(priceChange.get(stockCounter) > -1.25 && priceChange.get(stockCounter) <= 0) {
			AIChoice = 2;
		}
		else if(priceChange.get(stockCounter) > -0 && priceChange.get(stockCounter) <= 1.25) {
			AIChoice = 3;
		}
		else if(priceChange.get(stockCounter) > 1.25 && priceChange.get(stockCounter) <= 2.5) {
			AIChoice = 4;
		}
		else if(priceChange.get(stockCounter) > 2.5) {
			AIChoice = 5;
		}
			
		if(UserChoice == AIChoice){
			PointTracker = PointTracker + AttemptNumber;
			stockCounter++;
    		AttemptNumber = 2;
    		OverallAttemptNumber = OverallAttemptNumber + 1;
    		if(StockCount <= OverallAttemptNumber){
    			OverallAttemptNumber = 0;
    			
    			removeAll();
    			revalidate();
    			repaint();
    			if(stockCounter < Stocks.size()) {
    				StockName.setText("Stock:  " + Stocks.get(stockCounter));
        			add(GameScreen);
    			}
    			else {
    				add(StatsScreen);
    			}
    		}
    		PointsText = Integer.toString(PointTracker);
    		Points.setText("Points: " + PointsText);
    		return -1;
		}
		
		PointsText = Integer.toString(PointTracker);
		Points.setText("Points: " + PointsText);
		return AttemptNumber;

		
	}
	
	

}
