
// This was the initial code used before conversion to GUI.  It runs with the Scanner tool.

//import java.text.DecimalFormat;
//import java.awt.*;
//import java.util.*;
//import java.math.*;
//import java.io.*;
//import javax.swing.*;
//
//public class Scanner_Test_Calc_Program {
//	

//   
//	
//		DecimalFormat df =new DecimalFormat("#.##");
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("What's the weather?");
//		String WeatherName = scanner.nextLine();
//		
//		Weather Forecast = new Weather(WeatherName);
//		
//		int OffLevel = 50;
//		int DefLevel = 50;
//		double DamageMod = 1.0;	
//		
//		int Strike = 1;
//		
//		int OffIV[] = {0,0,0,0,0,0};
//		int OffEV[] = {0,0,0,0,0,0};
//		int DefIV[] = {0,0,0,0,0,0};
//		int DefEV[] = {0,0,0,0,0,0};
//		
//		ArrayList<Pokemon> Pokey = new ArrayList<Pokemon>();
//		ArrayList<Move> Action = new ArrayList<Move>();
//		
//		Pokey = Pokedex(Pokey);		
//		Action = AttackDex(Action, Forecast);
//		
//		System.out.print("Enter Attacker Here: ");
//		String PokeName = scanner.nextLine();
//			
//		Pokemon OffPoke;	
//		OffPoke = Pokemon.getPokemonObject(PokeName, Pokey);
//
//		System.out.print("Enter Defender Here: ");
//		PokeName = scanner.nextLine();
//		
//		Pokemon DefPoke;	
//		DefPoke = Pokemon.getPokemonObject(PokeName, Pokey);
//		
//		System.out.print("Enter Move Here: ");
//		String MoveName = scanner.nextLine();
//		
//		System.out.print("Enter Hold Item Here: ");
//		String HoldItem = scanner.nextLine();
//		
//		System.out.println("Enter Offensive Boost (-6 -- 0-- 6)");
//		int OffBoost = scanner.nextInt();
//		System.out.println("Enter Defensive Boost (-6 -- 0-- 6)");
//		int DefBoost = scanner.nextInt();
//		
//		Move Attack;
//		Attack = Move.getMoveObject(MoveName, Action, Forecast, OffPoke, DefPoke);
//		
//		if (Attack.getSpecialMod() == 'D' ||Attack.getSpecialMod() == 'M') {
//			
//			Strike = Attack.getStrikeType(Attack.getSpecialMod(), Strike, scanner);
//			
//		}
//		
//		DamageMod = TypeChart(DamageMod, Attack.getType(), DefPoke.getTypeA());
//		if (DefPoke.getTypeB() != null) {
//			DamageMod = TypeChart(DamageMod, Attack.getType(), DefPoke.getTypeB());
//		}
//		
//		Nature OffNatObj = new Nature("Serious");
//		Nature DefNatObj = new Nature("Serious");
//	
//		double OffStats[] = LevelUp(OffLevel, OffIV, OffPoke.getBaseStats(),  OffEV,  OffNatObj.getNatureMod());
//		double DefStats[] = LevelUp(DefLevel, DefIV, DefPoke.getBaseStats(),  DefEV,  DefNatObj.getNatureMod());	
//		
//		if (WeatherName.equals("Sand")) {
//			OffStats[4] = SandEndCorrection(OffPoke.getTypeA(),OffPoke.getTypeB(), OffStats[4]);
//			DefStats[4] = SandEndCorrection(DefPoke.getTypeA(),DefPoke.getTypeB(), DefStats[4]);
//		}
//	
//		double Damage[] = DamageCalc(Forecast, OffBoost, DefBoost, OffPoke.getTypeA(), OffPoke.getWeight(), DefPoke.getWeight(), Attack.getType(), OffLevel, OffStats[1], DefStats[2], OffStats[3], DefStats[4], Attack.getPower(), DamageMod, Attack.getCategory(), HoldItem, Attack.getName(), Strike, Attack.getSpecialMod());
//		
//		double LowPercent = 100* Damage[0] / DefStats[0];
//		double HighPercent = 100* Damage[1] / DefStats[0];
//		
//		System.out.println(OffPoke.getName() + "'s " + Attack.getName() + " does " + df.format(LowPercent) + "%  -- " + df.format(HighPercent) + "% to " + DefPoke.getName() + ".");
//	}
//	
//	
//	
//	// Type Chart Mechanics ///////////////////////////
//	
//	public static double TypeChart (double DamageMod, String MoveType, String DefType) {
//		
//		switch(MoveType) {
//		
//			case "Normal":
//				
//				if (DefType.equals("Rock") || DefType.equals("Steel")) {
//				}
//				if (DefType.equals("Ghost")) {
//					DamageMod*=0;
//				} 
//				break;
//				
//			case "Fight":
//				
//				if (DefType.equals("Flying") || DefType.equals("Poison") || DefType.equals("Bug") || DefType.equals("Psychic") || DefType.equals("Fairy")) {
//					DamageMod *= 0.5;
//				}
//
//				if (DefType.equals("Normal") || DefType.equals("Rock") || DefType.equals("Steel") || DefType.equals("Ice") || DefType.equals("Dark")) {
//					DamageMod *= 2.0;
//				}
//
//				if (DefType.equals("Ghost")) {
//					DamageMod*=0;
//				} 
//				break;
//				
//			case "Flying":
//				
//				if(DefType.equals("Rock") || DefType.equals("Steel") || DefType.equals("Electric")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Fight") || DefType.equals("Bug") || DefType.equals("Grass")) {
//					DamageMod*=2.0;
//				}
//				break;
//				
//			case "Poison":
//				
//				if(DefType.equals("Poison") || DefType.equals("Ground") || DefType.equals("Rock") || DefType.equals("Ghost")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Grass") || DefType.equals("Fairy")) {
//					DamageMod*=2.0;
//				}
//				if (DefType.equals("Steel")) {
//					DamageMod*=0;
//				} 
//				break;
//				
//			case "Ground":
//				
//				if(DefType.equals("Bug") || DefType.equals("Grass")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Poison") || DefType.equals("Rock") || DefType.equals("Steel") || DefType.equals("Fire") || DefType.equals("Electric")) {
//					DamageMod*=2.0;
//				}
//				if (DefType.equals("Flying")) {
//					DamageMod*=0;
//				} 
//				break;
//				
//			case "Rock":
//				
//				if(DefType.equals("Fight") || DefType.equals("Ground") || DefType.equals("Steel")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Flying") || DefType.equals("Bug") || DefType.equals("Fire") || DefType.equals("Ice")) {
//					DamageMod*=2.0;
//				}
//				break;
//				
//			case "Bug":
//				
//				if(DefType.equals("Fight") || DefType.equals("Flying") || DefType.equals("Poison") || DefType.equals("Ghost") || DefType.equals("Steel") || DefType.equals("Fire") || DefType.equals("Fairy")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Grass") || DefType.equals("Psychic") || DefType.equals("Dark")) {
//					DamageMod*=2.0;
//				}
//				break;
//				
//			case "Ghost":
//				
//				if(DefType.equals("Dark")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Ghost") || DefType.equals("Psychic")) {
//					DamageMod*=2.0;
//				}
//				if (DefType.equals("Normal")) {
//					DamageMod*=0;
//				} 
//				break;
//				
//			case "Steel":
//				
//				if(DefType.equals("Steel") || DefType.equals("Fire") || DefType.equals("Water") || DefType.equals("Electric")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Rock") || DefType.equals("Ice") || DefType.equals("Fairy")) {
//					DamageMod*=2.0;
//				}
//				break;
//				
//			case "Fire":
//				
//				if(DefType.equals("Rock") || DefType.equals("Fire") || DefType.equals("Water") || DefType.equals("Dragon")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Bug") || DefType.equals("Steel") || DefType.equals("Grass") || DefType.equals("Ice")) {
//					DamageMod*=2.0;
//				}
//				break;
//				
//			case "Water":
//				
//				if(DefType.equals("Water") || DefType.equals("Grass") || DefType.equals("Dragon")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Ground") || DefType.equals("Rock") || DefType.equals("Fire")) {
//					DamageMod*=2.0;
//				}
//				break;
//				
//			case "Grass":
//				
//				if(DefType.equals("Flying") || DefType.equals("Poison") || DefType.equals("Bug") || DefType.equals("Steel") || DefType.equals("Fire") || DefType.equals("Grass") || DefType.equals("Dragon")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Ground") || DefType.equals("Rock") || DefType.equals("Water")) {
//					DamageMod*=2.0;
//				}
//				break;
//				
//			case "Electric":
//				
//				if(DefType.equals("Grass") || DefType.equals("Electric") || DefType.equals("Dragon")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Flying") || DefType.equals("Water")) {
//					DamageMod*=2.0;
//				}
//				if (DefType.equals("Ground")) {
//					DamageMod*=0;
//				} 
//				break;
//				
//			case "Psychic":
//				
//				if(DefType.equals("Steel") || DefType.equals("Psychic")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Fight") || DefType.equals("Poison")) {
//					DamageMod*=2.0;
//				}
//				if (DefType.equals("Dark")) {
//					DamageMod*=0;
//				} 
//				break;
//				
//			case "Ice":
//							
//				if(DefType.equals("Steel") || DefType.equals("Fire") || DefType.equals("Water") || DefType.equals("Ice")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Flying") || DefType.equals("Ground") || DefType.equals("Grass") || DefType.equals("Dragon")) {
//					DamageMod*=2.0;
//				}
//				break;
//				
//			case "Dragon":
//				
//				if(DefType.equals("Steel")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Dragon")) {
//					DamageMod*=2.0;
//				}
//				if (DefType.equals("Fairy")) {
//					DamageMod*=0;
//				} 
//				break;
//				
//			case "Dark":
//				
//				if(DefType.equals("Fight") || DefType.equals("Dark") || DefType.equals("Fairy")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Ghost") || DefType.equals("Psychic")) {
//					DamageMod*=2.0;
//				}
//				break;
//				
//			case "Fairy":
//				
//				if(DefType.equals("Poison") || DefType.equals("Steel") || DefType.equals("Fire")) {
//					DamageMod*=0.5;
//				}
//				if(DefType.equals("Fight") || DefType.equals("Dragon") || DefType.equals("Dark")) {
//					DamageMod*=2.0;
//				}
//				break;
//				
//			default:
//				//do nothing
//				break;			
//		}
//	
//		return DamageMod;
//	}
//	
//	
//	// Level up Mechanics /////////////////
//	
//	public static double[] LevelUp (int Level, int[] IV, int Base[], int[] EV, double[] Nature) {
//		
//		double Stats[] = new double[6];
//		
//		Stats[0] = Math.floor((((IV[0] + (2 * Base[0]) + (EV[0] / 4.0) + 100) * Level) / 100.0 ) + 10); // HP
//		for (int i=1; i < Stats.length; i++) {
//			Stats[i] =  Math.floor(((((IV[i] + (2 * Base[i]) + (EV[i] / 4.0)) * Level) / 100.0) + 5) * Nature[i-1]);
//		}
//		
//		return Stats;
//	}
//	
//	
//	public static double[] DamageCalc(Weather Forecast, int OffBoost, int DefBoost,  String PokemonType, double OffWeight, double DefWeight, String AttType, int Level, double Att, double Def, double SpA, double SpD, int Power, double WeakResMod, char Category, String HoldItem, String MoveName, int Strike, char SpecialMod) {
//		
//		double STAB = 1;	
//		double AttPow=0;
//		double DefPow=0;
//		double Damage[] = new double[2];
//		
//		if (SpecialMod == 'W') {
//			Power = WeightCorrection (MoveName, OffWeight, DefWeight, Power);
//		}
//		
//		if (Forecast.getWeather().equals("Sun") || Forecast.getWeather().equals("Rain")) {
//			Power = Forecast.SunRainAttMod(AttType, Power);
//		}
//		
//		double ItemMod = ItemModifier (HoldItem,Category,WeakResMod);
//		
//		switch(Category) {
//			case 'P':
//				AttPow = Att;
//				DefPow = Def;
//				break;
//			case 'S':
//				AttPow = SpA;
//				DefPow = SpD;
//				break;
//			case 'p':
//				AttPow = Att;
//				DefPow = SpD;
//				break;	
//			case 's':
//				AttPow = SpA;
//				DefPow = Def;
//				break;	
//			default:
//				// do nothing
//				break;
//		}
//		
//		AttPow = StatBonus(OffBoost, AttPow);
//		DefPow = StatBonus(DefBoost, DefPow);
//			
//		
//		if (PokemonType.equals(AttType)) {
//			STAB = 1.5;
//		}
//		
//		double minMod = STAB * WeakResMod * ItemMod * 0.85;
//		double maxMod = STAB * WeakResMod * ItemMod * 1.00;
//				
//		Damage[0] = (Math.floor((((2 * Level + 10) / 250.0) * (AttPow / DefPow) * Power + 2) * minMod)) * Strike;
//		Damage[1] = (Math.floor((((2 * Level + 10) / 250.0) * (AttPow / DefPow) * Power + 2) * maxMod)) * Strike;	
//		
//		return Damage;
//		
//	}
//	
//	
//	
//	public static double ItemModifier (String HoldItem, char Category, double WeakResMod) {
//		
//		double ItemMod = 1;
//		
//		switch (HoldItem) {
//		
//		case "Life Orb":
//			ItemMod*= 1.3;
//			break;
//		case "Choice Band":
//			if (Category == 'P' || Category == 'p') {
//				ItemMod*=1.5;
//			}
//			break;
//		case "Choice Specs":
//			if (Category == 'S' || Category == 's') {
//				ItemMod*=1.5;
//			}
//			break;
//		case "Expert Belt":
//			if (WeakResMod >= 2.0) {
//				ItemMod*=1.2;
//			}
//				break;
//		default:
//			//Do nothing
//			break;
//		}
//		return ItemMod;		
//	}
//	
//	
//	public static double StatBonus(int StatAugment, double Stat) {
//		
//		double Boost;
//		
//		if (StatAugment >= 0) {
//			Boost = 1 + 0.5*StatAugment;
//		}
//		else {
//			Boost = 1.0 / (1 + 0.5*StatAugment);
//		}
//		
//		Stat = Stat*Boost;
//		
//		return Stat;
//		
//	}	
//	
//	
//	public static double SandEndCorrection(String TypeA, String TypeB, double SpD) {
//		
//		if (TypeB != null) {
//			if (TypeA.equals("Rock") || TypeB.equals("Rock")) {
//				SpD *= 1.5;
//			}
//		} else {
//			if (TypeA.equals("Rock")) {
//				SpD *= 1.5;
//			}
//		}
//		
//		return SpD;
//	}
//	
//	public static int WeightCorrection (String MoveName, double OffWeight, double DefWeight, int Power) {
//		
//		switch(MoveName) {
//		
//			case "Grass Knot": case "Low Kick":
//				if (DefWeight <= 22) {
//					Power = 20;
//				} else if (DefWeight <= 55) {
//					Power = 40;
//				} else if (DefWeight <= 110) {
//					Power = 60;
//				} else if (DefWeight <= 220) {
//					Power = 80;
//				} else if (DefWeight <= 440) {
//					Power = 100;
//				} else {
//					Power = 120;
//				}
//				break;
//			case "Heavy Slam": case "Heat Crash":
//				
//				if (DefWeight <= OffWeight * 0.2) {
//					Power = 120;
//				} else if (DefWeight <= OffWeight * 0.25) {
//					Power = 100;
//				} else if (DefWeight <= OffWeight * 0.33) {
//					Power = 80;
//				} else if (DefWeight <= OffWeight * 0.5) {
//					Power = 60;
//				} else {
//					Power = 40;
//				}
//				break;
//		}	
//		return Power;
//	}
//		
//	
//	public static ArrayList<Pokemon> Pokedex (ArrayList<Pokemon> Pokey) {

//		Pokey.add(new Pokemon("Blastoise", "Water", new int[] {79, 83, 100, 85, 105, 78}, 188.5));
//		Pokey.add(new Pokemon("Garchomp", "Dragon", "Ground",  new int[] {108, 130, 95, 80, 85, 102}, 209.4));
//		Pokey.add(new Pokemon("Glaceon", "Ice", new int[] {65,60,110,130,95,65}, 57.1));
//		Pokey.add(new Pokemon("Tyranitar", "Rock", "Dark", new int[] {100,134,110,95,100,61}, 445.3));
//		Pokey.add(new Pokemon("Carracosta", "Water", "Rock", new int[] {74,108,133,83,65,32}, 178.6));
//		return Pokey;
//	}
//	
//	public static ArrayList<Move> AttackDex(ArrayList<Move> Action, Weather Forecast) {
//		
//		Action.add(new Move("Attack Order","Bug", 90, 'P'));
//		Action.add(new Move("Crunch","Dark", 80, 'P'));
//		Action.add(new Move("Draco_Meteor", "Dragon", 130, 'S'));
//		Action.add(new Move("Fire Blast","Fire", 110, 'S'));
//		Action.add(new Move("Flamethrower","Fire", 90, 'S'));
//		Action.add(new Move("Ice Beam", "Ice", 90, 'S'));
//		Action.add(new Move("Ice Fang", "Ice", 65, 'P'));
//		Action.add(new Move("Psychic", "Psychic", 90, 'S'));
//		Action.add(new Move("Surf","Water", 90, 'S'));
//		
//		Action.add(new Move("Low Kick", "Fight", 20, 'P','W'));
//		Action.add(new Move("Grass Knot", "Grass", 20, 'S','W'));		
//		Action.add(new Move("Heavy Slam", "Steel", 40, 'P','W'));
//		Action.add(new Move("Heat Crash", "Fire", 40, 'P','W'));
//		
//		Action.add(new Move("Bonemerang","Ground", 50, 'P', 'D'));
//		Action.add(new Move("Icicle Spear","Ice", 25, 'P', 'M'));
//		
////		Action.add(new Move("Solar Beam","Grass", 120, 'S'));
////		Action.add(new Move("Weather Ball","Normal", 50, 'S'));
//		
//		if (Forecast.getWeather().equals("Sun")) {
//			Action.add(new Move("Weather Ball","F", 100, 'S'));
//			
//		} else if (Forecast.getWeather().equals("Rain")) {
//			Action.add(new Move("Solar Beam","Grass", 60, 'S'));
//			Action.add(new Move("Weather Ball","Water", 100, 'S'));
//			
//		} else if (Forecast.getWeather().equals("Sand")) {
//			Action.add(new Move("Solar Beam","Grass", 60, 'S'));
//			Action.add(new Move("Weather Ball","Rock", 100, 'S'));
//			
//		} else if (Forecast.getWeather().equals("Hail")) {
//			Action.add(new Move("Solar Beam","Grass", 60, 'S'));
//			Action.add(new Move("Weather Ball","Ice", 100, 'S'));
//			
//		} else {
//			Action.add(new Move("Solar Beam","Grass", 120, 'S'));
//			Action.add(new Move("Weather Ball","Normal", 50, 'S'));
//			
//		}
//		
//		return Action;
//	}
//}
