import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Move {
	
	private String Name;
	private String Type;
	private int Power;
	private char Category;
	private char Contact;
	private char SpecialMod;
	
	public Move (String Name, String Type, int Power, char Category, char Contact) {
		this.Name= Name;
		this.Type = Type;
		this.Power = Power;
		this.Category = Category;
		this.Contact = Contact;
	}
	
	public Move (String Name, String Type, int Power, char Category,char Contact, char SpecialMod) {
		this.Name= Name;
		this.Type = Type;
		this.Power = Power;
		this.Category = Category;
		this.Contact = Contact;
		this.SpecialMod = SpecialMod;
	}
	
	public static Move getMoveObject(String MoveName, ArrayList<Move> Action) {
		
		int i = -1;
		do {
			i++;
		} while (!MoveName.equals(Action.get(i).getName()));
		
		return Action.get(i);
	}
	
	public String getName() {
		return Name;
	}
	

	public String getType() {
		return Type;
	}
	
	public int getPower() {
		return Power;
	}
	
	
	public char getCategory() {
		return Category;
	}
	public char getSpecialMod() {
		return SpecialMod;
	}
	public char getContact() {
		return Contact;
	}
	
	public int getStrikeType(char StrikeType, int Strike, Scanner scanner) {
		
		if (StrikeType == 'D') {
			Strike = 2;
		}
		if (StrikeType == 'M') {
			System.out.println("Number of strikes?");
			Strike = scanner.nextInt();
		}
		return Strike;
	}
	
	
	public String toString() {
		return Name;
	}
	
	
}
