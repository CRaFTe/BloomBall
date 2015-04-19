import javax.swing.JFrame;
//import javax.swing.UIManager;


public class BaseGame {
	   public static void main(String[] args){
		   
		      JFrame frame = new JFrame("BloomBall");
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		      frame.getContentPane().add(new MainPanel());
		      
		      frame.pack();
		      frame.setVisible(true);
	   }
}
