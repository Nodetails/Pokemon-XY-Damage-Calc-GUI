import javax.swing.JFrame;


public class GUI_Main {
	public static void main(String args[]) { 
		
		Poke_Damage_Calculator_GUI go = new Poke_Damage_Calculator_GUI ();
		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go.setVisible(true);
	}
}
