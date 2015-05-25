import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Pokemon {
	
	private String PokeName;
	private char Evolution;
	private String Name;
	private String TypeA;
	private String TypeB;
	private int bst[] = new int[6];
	private double Weight;
	private ImageIcon pic;

	
	
	public Pokemon(String Name, char Evolution, String TypeA, String TypeB, int[] bst, double Weight, ImageIcon pic) {
		
		this.Name = Name;
		this.Evolution = Evolution;
		this.bst = bst;
		this.TypeA = TypeA;
		this.TypeB = TypeB;
		this.Weight = Weight;
		this.pic = pic;

	}
	
	public Pokemon(String Name, char Evolution, String TypeA, int[] bst, double Weight, ImageIcon pic) {
		
		this.Name = Name;
		this.Evolution = Evolution;
		this.bst = bst;
		this.TypeA = TypeA;
		this.Weight = Weight;
		this.pic = pic;
	
	}
	
	public static Pokemon getPokemonObject(String PokeName, ArrayList<Pokemon> Pokey) {
				
		int i = -1;
		do {
			i++;
		} while (!PokeName.equals(Pokey.get(i).getName()));
		
		return Pokey.get(i);
	}
	
	
	
	public String getName () {
		return Name;
	}
	
	public char getEvol() {
		return Evolution;
	}
	
	public String getTypeA () {
		return TypeA;
	}
	
	public String getTypeB () {
		return TypeB;
	}
	
	public double getWeight () {
		return Weight;
	}
	
	public int[] getBaseStats () {
		return bst;
	}
	
	public String toString() {
		return Name;
	}
	
	public ImageIcon getPic() {
		return pic;
	}

}
