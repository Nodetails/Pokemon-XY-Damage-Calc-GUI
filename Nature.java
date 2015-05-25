import java.util.Arrays;
import java.util.*;

public class Nature {
	
	private double[] NatureMod = {1,1,1,1,1};
	private String NatureName;
	
	
	public Nature(String NatureName) {
		this.NatureName = NatureName;	
		
		switch(NatureName) {
		
		case "Bashful":
			break;
		case "Hardy":
			break;
		case "Serious":
			break;
		case "Docile":
			break;
		case "Quirky":
			break;
			
			case "Lonely":
				NatureMod[0] = 1.1;
				NatureMod[1] = 0.9;		
				break;
			
			case "Adamant":
				NatureMod[0] = 1.1;
				NatureMod[2] = 0.9;
				break;
				
			case "Naughty":
				NatureMod[0] = 1.1;
				NatureMod[3] = 0.9;
				break;
				
			case "Brave":
				NatureMod[0] = 1.1;
				NatureMod[4] = 0.9;
				break;
				
			case "Bold":
				NatureMod[1] = 1.1;
				NatureMod[0] = 0.9;
				break;
				
			case "Impish":
				NatureMod[1] = 1.1;
				NatureMod[2] = 0.9;
				break;
				
			case "Lax":
				NatureMod[1] = 1.1;
				NatureMod[3] = 0.9;
				break;
				
			case "Relaxed":
				NatureMod[1] = 1.1;
				NatureMod[4] = 0.9;
				break;
				
			case "Modest":
				NatureMod[2] = 1.1;
				NatureMod[0] = 0.9;
				break;
				
			case "Mild":
				NatureMod[2] = 1.1;
				NatureMod[1] = 0.9;
				break;
				
			case "Rash":
				NatureMod[2] = 1.1;
				NatureMod[3] = 0.9;
				break;
				
			case "Quiet":
				NatureMod[2] = 1.1;
				NatureMod[4] = 0.9;
				break;
				
			case "Calm":
				NatureMod[3] = 1.1;
				NatureMod[0] = 0.9;
				break;
				
			case "Gentle":
				NatureMod[3] = 1.1;
				NatureMod[1] = 0.9;
				break;
				
			case "Careful":
				NatureMod[3] = 1.1;
				NatureMod[2] = 0.9;
				break;
	
			case "Sassy":
				NatureMod[3] = 1.1;
				NatureMod[4] = 0.9;
				break;
				
			case "Timid":
				NatureMod[4] = 1.1;
				NatureMod[0] = 0.9;
				break;
				
			case "Hasty":
				NatureMod[4] = 1.1;
				NatureMod[1] = 0.9;
				break;
				
			case "Jolly":
				NatureMod[4] = 1.1;
				NatureMod[2] = 0.9;
				break;
	
			case "Naive":
				NatureMod[4] = 1.1;
				NatureMod[3] = 0.9;
				break;
			
			default:
				//do nothing
			
		}
				
	}
		
	
	public String getNatureName() {
		return NatureName;
	}
	
	public double[] getNatureMod() {
		return NatureMod;
	}

}


