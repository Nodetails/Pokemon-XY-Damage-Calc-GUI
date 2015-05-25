import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Graphics2D; 
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;



public class Poke_Damage_Calculator_GUI extends JFrame {

	private JPanel contentPane;  
	
	// Base Stats Off
	
	private JLabel Off_HP_Base;
	private JLabel Off_Att_Base;
	private JLabel Off_Def_Base;
	private JLabel Off_SpA_Base;
	private JLabel Off_SpD_Base;
	private JLabel Off_Spe_Base;
	
	//Base Stats Def
	
	private JLabel Def_HP_Base;
	private JLabel Def_Att_Base;
	private JLabel Def_Def_Base;
	private JLabel Def_SpA_Base;
	private JLabel Def_SpD_Base;
	private JLabel Def_Spe_Base;
	
	// Stats: Off
	
	private JLabel Off_HP;
	private JLabel Off_Att;
	private JLabel Off_Def;
	private JLabel Off_SpA;
	private JLabel Off_SpD;
	private JLabel Off_Spe;
		
	// Stats: Def
	
	private JLabel Def_HP;
	private JLabel Def_Att;
	private JLabel Def_Def;
	private JLabel Def_SpA;
	private JLabel Def_SpD;
	private JLabel Def_Spe;
	
	// Types: Off
	
	private JLabel Off_Type_A;
	private JLabel Off_Type_B;
	
	// Types: Def
	
	private JLabel Def_TypeA;
	private JLabel Def_TypeB;
	
	// EV's: Off
	
	private JSpinner Off_HP_EVs;
	private JSpinner Off_Att_EVs;
	private JSpinner Off_Def_EVs;
	private JSpinner Off_SpA_EVs;
	private JSpinner Off_SpD_EVs;
	private JSpinner Off_Spe_EVs;
	
	// EV's: Off
	
	private JSpinner Def_HP_EVs;
	private JSpinner Def_Att_EVs;
	private JSpinner Def_Def_EVs;
	private JSpinner Def_SpA_EVs;
	private JSpinner Def_SpD_EVs;
	private JSpinner Def_Spe_EVs;
	
	// IV's: Off
	
	private JSpinner Off_HP_IVs;
	private JSpinner Off_Att_IVs;
	private JSpinner Off_Def_IVs;
	private JSpinner Off_SpA_IVs;
	private JSpinner Off_SpD_IVs;
	private JSpinner Off_Spe_IVs;
	
	// IV's: Def
	
	private JSpinner Def_HP_IVs;
	private JSpinner Def_Att_IVs;
	private JSpinner Def_Def_IVs;
	private JSpinner Def_SpA_IVs;
	private JSpinner Def_SpD_IVs;
	private JSpinner Def_Spe_IVs;

	// Levels
	
	private JSpinner Off_Level;
	private JSpinner Def_Level;
	
	//Offensive Pokemon Boosts
	
	private JSpinner Off_Att_Boost;
	private JSpinner Off_Def_Boost;
	private JSpinner Off_SpA_Boost;
	private JSpinner Off_SpD_Boost;
	private JSpinner Off_Spe_Boost;
	
	//Defensive Pokemon Boosts
	
	private JSpinner Def_Att_Boost;
	private JSpinner Def_Def_Boost;
	private JSpinner Def_SpA_Boost;
	private JSpinner Def_SpD_Boost;
	private JSpinner Def_Spe_Boost;
	
	//Damage calc lister
	
	private JLabel Off_Damage_Calc;
	private JLabel Def_Damage_Calc;
	
	//Move Combo Box
	
	private JComboBox Off_Pokemon;
	private JComboBox Def_Pokemon;
	
	// Weather

	private JComboBox WeatherBox;

	// Hold Item
	
	private JComboBox Off_Item;
	private JComboBox Def_Item;
	
	// Weight
	
	private JLabel Off_Weight;
	private JLabel Def_Weight;
	
	// Move: Off 
	
	private JComboBox Off_Move;
	private JLabel Off_Move_Type;
	private JLabel Off_Move_Power;
	private JLabel Off_Move_Category;
	private JLabel Off_Move_Contact;
	private JLabel Off_SpecialMod;
	
	// Move: Def 
	
	private JComboBox Def_Move;
	private JLabel Def_Move_Type;
	private JLabel Def_Move_Power;
	private JLabel Def_Move_Category;
	private JLabel Def_Move_Contact;
	private JLabel Def_SpecialMod;
	
	// Hit count
	
	private JSpinner Off_Hit_Count;
	private JSpinner Def_Hit_Count;

	// Hits 
	
	private JLabel Off_Hits_label;
	private JLabel Def_Hits_label;
	
	// Nature
	
	private JComboBox Off_Nature;
	private JComboBox Def_Nature;
	
	//Evolution check
	
	private JLabel Off_Evol;
	private JLabel Def_Evol;
	
	// KO
	
	private JLabel Off_KO;
	private JLabel Def_KO;
	
	// Ability
	
	private JComboBox Off_Ability;
	private JComboBox Def_Ability;
	private JLabel Off_Poke_Pic;
	private JLabel Def_Poke_Pic;
	
	// pics
	
	private JLabel Off_Poke_pic;
	private JLabel Def_Poke_pic;
	private JLabel Green_Arrow;
	private JLabel Red_Arrow;

//////////////////////////////////////////////////
	
	public Poke_Damage_Calculator_GUI() {
		
		//Boring labels
		
		OffActionHandlerClass OAhandler = new OffActionHandlerClass();
		OffChangeHandlerClass OChandler = new OffChangeHandlerClass();
		
		DefActionHandlerClass DAhandler = new DefActionHandlerClass();
		DefChangeHandlerClass DChandler = new DefChangeHandlerClass();
		
		String[] Natures = {"Bashful","Serious","Hardy","Quirky","Docile","Lonely","Adamant","Naughty","Brave","Bold","Impish","Lax","Relaxed","Modest","Mild","Rash","Quiet","Calm","Gentle","Careful","Sassy","Timid","Hasty","Jolly","Naive"};
		String[] HoldItems = {"-none-","Choice Band", "Choice Specs", "Life Orb", "Expert Belt", "Eviolite"};
		String[] WeatherName = {"-none-","Sun","Rain","Sand","Hail"};
		String[] AbilityNames = {"-none-","Adaptability", "Aerialate", "Blaze(a)", "Dark Aura", "Fairy Aura", "Filter", "Flash Fire(a)", "Fur Coat", "Guts(a)", "Heatproof", "Heavy Metal", "Huge Power", "Hustle", "Iron Fist", "Marvel Scale", "Mega Launcher", "Normalize", "Overgrow(a)", "Paternal Bond", "Pixelate", "Protean", "Pure Power", "Reckless", "Refrigerate", "Rivalry(SameG)", "Rivalry(DifG)", "Sand Force", "Sheer Force", "Slow Start", "Solar Power", "Solid Rock", "Strong Jaw", "Swarm(a)", "Technician", "Thick Fat", "Tinted Lens", "Torrent(a)", "Tough Claws", "Toxic Boost"};
		
		ArrayList<Pokemon> Pokey = new ArrayList<Pokemon>();
		Pokey = Pokedex(Pokey);	
		
		ArrayList<Move> Action = new ArrayList<Move>();
		Action = AttackDex(Action);
		
		
			
		setTitle("Pokemon Damage Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		
		JLabel Off_SpAttack_label = new JLabel("Sp. Attack");
		Off_SpAttack_label.setBounds(48, 146, 68, 14);
		contentPane.add(Off_SpAttack_label);
		
		JLabel Off_Speed_label = new JLabel("Speed");
		Off_Speed_label.setBounds(48, 196, 46, 14);
		contentPane.add(Off_Speed_label);
		
		Off_Damage_Calc = new JLabel("");
		Off_Damage_Calc.setBounds(211, 221, 260, 14);
		Off_Damage_Calc.setVisible(true);
		contentPane.add(Off_Damage_Calc);
		
		JLabel Off_Attack_label = new JLabel("Attack");
		Off_Attack_label.setBounds(48, 96, 46, 14);
		contentPane.add(Off_Attack_label);
		
		Off_KO = new JLabel("");
		Off_KO.setBounds(211, 242, 184, 14);
		contentPane.add(Off_KO);
		Off_KO.setVisible(true);
		
		JLabel Off_Defense_label = new JLabel("Defense");
		Off_Defense_label.setBounds(48, 121, 56, 14);
		contentPane.add(Off_Defense_label);
		
		JLabel Off_SpDefense_label = new JLabel("Sp. Defense");
		Off_SpDefense_label.setBounds(48, 171, 78, 14);
		contentPane.add(Off_SpDefense_label);
		
		JLabel Off_HP_label = new JLabel("HP");
		Off_HP_label.setBounds(48, 71, 46, 14);
		contentPane.add(Off_HP_label);
		
		JLabel Off_Base_label = new JLabel("Base");
		Off_Base_label.setBounds(125, 46, 46, 14);
		contentPane.add(Off_Base_label);
		
		JLabel Off_EVs_label = new JLabel("EV's");
		Off_EVs_label.setBounds(192, 46, 29, 14);
		contentPane.add(Off_EVs_label);
		
		JLabel Off_IVs_label = new JLabel("IV's");
		Off_IVs_label.setBounds(241, 46, 29, 14);
		contentPane.add(Off_IVs_label);
		
		JLabel Off_Nature_label = new JLabel("Nature");
		Off_Nature_label.setBounds(381, 96, 56, 14);
		contentPane.add(Off_Nature_label);
		
		JLabel Off_Item_label = new JLabel("Item");
		Off_Item_label.setBounds(381, 121, 56, 14);
		contentPane.add(Off_Item_label);
		
		JLabel Off_Ability_label = new JLabel("Ability");
		Off_Ability_label.setBounds(381, 146, 56, 14);
		contentPane.add(Off_Ability_label);
		
		JLabel Off_Move_label = new JLabel("Move");
		Off_Move_label.setBounds(381, 171, 56, 14);
		contentPane.add(Off_Move_label);
		
		
		Off_HP_Base = new JLabel("--");
		Off_HP_Base.setBounds(125, 71, 46, 14);
		contentPane.add(Off_HP_Base);
		
		Off_Att_Base = new JLabel("--");
		Off_Att_Base.setBounds(125, 96, 46, 14);
		contentPane.add(Off_Att_Base);
		
		Off_Def_Base = new JLabel("--");
		Off_Def_Base.setBounds(125, 121, 46, 14);
		contentPane.add(Off_Def_Base);
		
		Off_SpA_Base = new JLabel("--");
		Off_SpA_Base.setBounds(125, 146, 46, 14);
		contentPane.add(Off_SpA_Base);
		
		Off_SpD_Base = new JLabel("--");
		Off_SpD_Base.setBounds(125, 171, 46, 14);
		contentPane.add(Off_SpD_Base);
		
		Off_Spe_Base = new JLabel("--");
		Off_Spe_Base.setBounds(125, 196, 46, 14);
		contentPane.add(Off_Spe_Base);
		
		Off_HP = new JLabel("--");
		Off_HP.setBounds(280, 71, 46, 14);
		contentPane.add(Off_HP);
	
		
		Off_Att = new JLabel("--");
		Off_Att.setBounds(280, 96, 46, 14);
		contentPane.add(Off_Att);
		
		Off_Def = new JLabel("--");
		Off_Def.setBounds(280, 121, 46, 14);
		contentPane.add(Off_Def);
		
		Off_SpA = new JLabel("--");
		Off_SpA.setBounds(280, 146, 46, 14);
		contentPane.add(Off_SpA);
		
		Off_SpD = new JLabel("--");
		Off_SpD.setBounds(280, 171, 46, 14);
		contentPane.add(Off_SpD);
		
		Off_Spe = new JLabel("--");
		Off_Spe.setBounds(280, 196, 46, 14);
		contentPane.add(Off_Spe);
		
		Def_KO = new JLabel("");
		Def_KO.setBounds(211, 335, 208, 14);
		contentPane.add(Def_KO);
		Def_KO.setVisible(true);
		
		Def_Damage_Calc = new JLabel("");
		Def_Damage_Calc.setBounds(211, 314, 134, 14);
		Def_Damage_Calc.setVisible(true);
		contentPane.add(Def_Damage_Calc);
		
		
		JLabel Off_Boosts_label = new JLabel("Boosts");
		Off_Boosts_label.setBounds(325, 46, 46, 14);
		contentPane.add(Off_Boosts_label);
		
		JLabel Off_Stats_label = new JLabel("Stats");
		Off_Stats_label.setBounds(280, 46, 46, 14);
		contentPane.add(Off_Stats_label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(437, 217, 46, 14);
		contentPane.add(label_1);
		
		
		JLabel Def_HP_label = new JLabel("HP");
		Def_HP_label.setBounds(48, 417, 46, 14);
		contentPane.add(Def_HP_label);
		
		JLabel Def_Att_label = new JLabel("Attack");
		Def_Att_label.setBounds(48, 442, 46, 14);
		contentPane.add(Def_Att_label);
		
		JLabel Def_Def_label = new JLabel("Defense");
		Def_Def_label.setBounds(48, 467, 68, 14);
		contentPane.add(Def_Def_label);
		
		JLabel Def_SpA_label = new JLabel("Sp. Attack");
		Def_SpA_label.setBounds(48, 492, 68, 14);
		contentPane.add(Def_SpA_label);
		
		JLabel Def_SpD_label = new JLabel("Sp. Defense");
		Def_SpD_label.setBounds(48, 517, 78, 14);
		contentPane.add(Def_SpD_label);
		
		JLabel Def_Spe_label = new JLabel("Speed");
		Def_Spe_label.setBounds(48, 542, 46, 14);
		contentPane.add(Def_Spe_label);
		
		JLabel Def_Base_label = new JLabel("Base");
		Def_Base_label.setBounds(125, 393, 46, 14);
		contentPane.add(Def_Base_label);
		
		JLabel Def_Nature_label = new JLabel("Nature");
		Def_Nature_label.setBounds(381, 442, 56, 14);
		contentPane.add(Def_Nature_label);
		
		JLabel Def_Item_label = new JLabel("Item");
		Def_Item_label.setBounds(381, 467, 56, 14);
		contentPane.add(Def_Item_label);
		
		JLabel Def_Ability_label = new JLabel("Ability");
		Def_Ability_label.setBounds(381, 492, 56, 14);
		contentPane.add(Def_Ability_label);
		
		JLabel Def_Move_label = new JLabel("Move");
		Def_Move_label.setBounds(381, 517, 56, 14);
		contentPane.add(Def_Move_label);
		

		
		JSeparator separator = new JSeparator();
		separator.setBounds(48, 380, 89, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(48, 33, 536, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(48, 380, 536, 2);
		contentPane.add(separator_2);
		
		JLabel Attacker_Title = new JLabel("Attacking Pokemon");
		Attacker_Title.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Attacker_Title.setBounds(48, 16, 123, 14);
		contentPane.add(Attacker_Title);
		
		JLabel lblDefender = new JLabel("Defending Pokemon");
		lblDefender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDefender.setBounds(48, 362, 123, 14);
		contentPane.add(lblDefender);
		

		
		JLabel Weather_label = new JLabel("Weather");
		Weather_label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Weather_label.setBounds(415, 16, 56, 14);
		contentPane.add(Weather_label);
		
		JLabel Off_Level_label = new JLabel("Level");
		Off_Level_label.setBounds(381, 71, 42, 14);
		contentPane.add(Off_Level_label);
		
		JLabel Def_Level_label = new JLabel("Level");
		Def_Level_label.setBounds(381, 417, 56, 14);
		contentPane.add(Def_Level_label);
		
		JLabel Def_Type_label = new JLabel("Type");
		Def_Type_label.setBounds(381, 393, 29, 14);
		contentPane.add(Def_Type_label);
		
		JLabel Off_Type_label = new JLabel("Type");
		Off_Type_label.setBounds(381, 46, 29, 14);
		contentPane.add(Off_Type_label);
		
		Def_TypeA = new JLabel("--");
		Def_TypeA.setBounds(437, 393, 46, 14);
		contentPane.add(Def_TypeA);
		
		Def_TypeB = new JLabel("--");
		Def_TypeB.setBounds(523, 393, 46, 14);
		contentPane.add(Def_TypeB);
		
		Off_Type_A = new JLabel("--");
		Off_Type_A.setBounds(437, 46, 46, 14);
		contentPane.add(Off_Type_A);
		
		Off_Type_B = new JLabel("--");
		Off_Type_B.setBounds(523, 46, 46, 14);
		contentPane.add(Off_Type_B);
		
		Off_Weight = new JLabel("--");
		Off_Weight.setBounds(506, 71, 39, 14);
		contentPane.add(Off_Weight);
		Off_Weight.setVisible(false);
		
		Def_Weight = new JLabel("--");
		Def_Weight.setBounds(503, 417, 46, 14);
		contentPane.add(Def_Weight);
		Def_Weight.setVisible(false);
		
		Off_Move_Type = new JLabel("--");
		Off_Move_Type.setBounds(437, 196, 46, 14);
		contentPane.add(Off_Move_Type);
		
		Off_Move_Power = new JLabel("--");
		Off_Move_Power.setBounds(484, 196, 29, 14);
		contentPane.add(Off_Move_Power);
		
		Off_Move_Category = new JLabel("-");
		Off_Move_Category.setBounds(559, 171, 14, 14);
		contentPane.add(Off_Move_Category);
		
		Def_Move_Type = new JLabel("--");
		Def_Move_Type.setBounds(437, 542, 46, 14);
		contentPane.add(Def_Move_Type);
		
		Def_Move_Power = new JLabel("--");
		Def_Move_Power.setBounds(484, 542, 29, 14);
		contentPane.add(Def_Move_Power);
		
		Def_Move_Category = new JLabel("-");
		Def_Move_Category.setBounds(559, 517, 14, 14);
		contentPane.add(Def_Move_Category);
		
		Off_Hits_label = new JLabel("Hits");
		Off_Hits_label.setVisible(false);
		Off_Hits_label.setBounds(508, 196, 23, 14);
		contentPane.add(Off_Hits_label);
		
		Def_Hits_label = new JLabel("Hits");
		Def_Hits_label.setVisible(false);
		Def_Hits_label.setBounds(508, 542, 23, 14);
		contentPane.add(Def_Hits_label);
		
		Off_SpecialMod = new JLabel("X");
		Off_SpecialMod.setVisible(false);
		Off_SpecialMod.setBounds(381, 196, 14, 14);
		contentPane.add(Off_SpecialMod);
		
		Def_SpecialMod = new JLabel("X");
		Def_SpecialMod.setVisible(false);
		Def_SpecialMod.setBounds(381, 542, 14, 14);
		contentPane.add(Def_SpecialMod);
		
		Def_HP_Base = new JLabel("--");
		Def_HP_Base.setBounds(125, 417, 46, 14);
		contentPane.add(Def_HP_Base);
		
		Def_Att_Base = new JLabel("--");
		Def_Att_Base.setBounds(125, 442, 46, 14);
		contentPane.add(Def_Att_Base);
		
		Def_Def_Base = new JLabel("--");
		Def_Def_Base.setBounds(125, 467, 46, 14);
		contentPane.add(Def_Def_Base);
		
		Def_SpA_Base = new JLabel("--");
		Def_SpA_Base.setBounds(125, 492, 46, 14);
		contentPane.add(Def_SpA_Base);
		
		Def_SpD_Base = new JLabel("--");
		Def_SpD_Base.setBounds(125, 517, 46, 14);
		contentPane.add(Def_SpD_Base);
		
		Def_Spe_Base = new JLabel("--");
		Def_Spe_Base.setBounds(125, 542, 46, 14);
		contentPane.add(Def_Spe_Base);
		
		JLabel Def_EVs_label = new JLabel("EV's");
		Def_EVs_label.setBounds(192, 393, 29, 14);
		contentPane.add(Def_EVs_label);
		
		JLabel Def_IVs_label = new JLabel("IV's");
		Def_IVs_label.setBounds(241, 393, 29, 14);
		contentPane.add(Def_IVs_label);
		
		JLabel Def_Stats_label = new JLabel("Stats");
		Def_Stats_label.setBounds(280, 393, 46, 14);
		contentPane.add(Def_Stats_label);
		
		JLabel Def_Boosts_label = new JLabel("Boosts");
		Def_Boosts_label.setBounds(325, 393, 46, 14);
		contentPane.add(Def_Boosts_label);
		
		Def_HP = new JLabel("--");
		Def_HP.setBounds(280, 417, 46, 14);
		contentPane.add(Def_HP);
		
		Def_Att = new JLabel("--");
		Def_Att.setBounds(280, 442, 46, 14);
		contentPane.add(Def_Att);
		
		Def_Def = new JLabel("--");
		Def_Def.setBounds(280, 467, 46, 14);
		contentPane.add(Def_Def);
		
		Def_SpA = new JLabel("--");
		Def_SpA.setBounds(280, 492, 46, 14);
		contentPane.add(Def_SpA);
		
		Def_SpD = new JLabel("--");
		Def_SpD.setBounds(280, 517, 46, 14);
		contentPane.add(Def_SpD);
		
		Def_Spe = new JLabel("--");
		Def_Spe.setBounds(280, 542, 46, 14);
		contentPane.add(Def_Spe);
		
		
		Off_Hit_Count = new JSpinner();
		Off_Hit_Count.setEnabled(true);
		Off_Hit_Count.setVisible(false);
		Off_Hit_Count.setModel(new SpinnerNumberModel(1, 1, 1, 1));
		Off_Hit_Count.setBounds(540, 193, 29, 20);
		contentPane.add(Off_Hit_Count);
		
		Def_Hit_Count = new JSpinner();
		Def_Hit_Count.setVisible(false);
		Def_Hit_Count.setModel(new SpinnerNumberModel(1, 1, 1, 1));
		Def_Hit_Count.setBounds(540, 539, 29, 20);
		contentPane.add(Def_Hit_Count);
		
		Off_Att_Boost = new JSpinner();
		Off_Att_Boost.setModel(new SpinnerNumberModel(0, -6, 6, 1));
		Off_Att_Boost.setBounds(325, 93, 39, 20);
		contentPane.add(Off_Att_Boost);
		
		Off_Def_Boost = new JSpinner();
		Off_Def_Boost.setModel(new SpinnerNumberModel(0, -6, 6, 1));
		Off_Def_Boost.setBounds(325, 118, 39, 20);
		contentPane.add(Off_Def_Boost);
		
		Off_SpA_Boost = new JSpinner();
		Off_SpA_Boost.setModel(new SpinnerNumberModel(0, -6, 6, 1));
		Off_SpA_Boost.setBounds(325, 143, 39, 20);
		contentPane.add(Off_SpA_Boost);
		
		Off_SpD_Boost = new JSpinner();
		Off_SpD_Boost.setModel(new SpinnerNumberModel(0, -6, 6, 1));
		Off_SpD_Boost.setBounds(325, 168, 39, 20);
		contentPane.add(Off_SpD_Boost);
		
		Off_Spe_Boost = new JSpinner();
		Off_Spe_Boost.setModel(new SpinnerNumberModel(0, -6, 6, 1));
		Off_Spe_Boost.setBounds(325, 193, 39, 20);
		contentPane.add(Off_Spe_Boost);
		
		
		Def_Att_Boost = new JSpinner();
		Def_Att_Boost.setModel(new SpinnerNumberModel(0, -6, 6, 1));
		Def_Att_Boost.setBounds(325, 439, 39, 20);
		contentPane.add(Def_Att_Boost);
		
		Def_Def_Boost = new JSpinner();
		Def_Def_Boost.setModel(new SpinnerNumberModel(0, -6, 6, 1));
		Def_Def_Boost.setBounds(325, 464, 39, 20);
		contentPane.add(Def_Def_Boost);
		
		Def_SpA_Boost = new JSpinner();
		Def_SpA_Boost.setModel(new SpinnerNumberModel(0, -6, 6, 1));
		Def_SpA_Boost.setBounds(325, 489, 39, 20);
		contentPane.add(Def_SpA_Boost);
		
		Def_SpD_Boost = new JSpinner();
		Def_SpD_Boost.setModel(new SpinnerNumberModel(0, -6, 6, 1));
		Def_SpD_Boost.setBounds(325, 514, 39, 20);
		contentPane.add(Def_SpD_Boost);
		
		Def_Spe_Boost = new JSpinner();
		Def_Spe_Boost.setModel(new SpinnerNumberModel(0, -6, 6, 1));
		Def_Spe_Boost.setBounds(325, 539, 39, 20);
		contentPane.add(Def_Spe_Boost);
			
		Off_HP_EVs = new JSpinner();		
		Off_HP_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Off_HP_EVs.setToolTipText("");
		Off_HP_EVs.setForeground(Color.BLACK);
		Off_HP_EVs.setBounds(174, 68, 47, 20);
		contentPane.add(Off_HP_EVs);
		Off_HP_EVs.addChangeListener(OChandler);

		Off_Att_EVs = new JSpinner();
		Off_Att_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Off_Att_EVs.setToolTipText("");
		Off_Att_EVs.setForeground(Color.BLACK);
		Off_Att_EVs.setBounds(174, 93, 46, 20);
		contentPane.add(Off_Att_EVs);
		Off_Att_EVs.addChangeListener(OChandler);
		
		Off_Def_EVs = new JSpinner();
		Off_Def_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Off_Def_EVs.setToolTipText("");
		Off_Def_EVs.setForeground(Color.BLACK);
		Off_Def_EVs.setBounds(174, 118, 46, 20);
		contentPane.add(Off_Def_EVs);
		Off_Def_EVs.addChangeListener(OChandler);
			
		Off_SpA_EVs = new JSpinner();
		Off_SpA_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Off_SpA_EVs.setToolTipText("");
		Off_SpA_EVs.setForeground(Color.BLACK);
		Off_SpA_EVs.setBounds(174, 143, 46, 20);
		contentPane.add(Off_SpA_EVs);
		Off_SpA_EVs.addChangeListener(OChandler);
			
		Off_SpD_EVs = new JSpinner();
		Off_SpD_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Off_SpD_EVs.setToolTipText("");
		Off_SpD_EVs.setForeground(Color.BLACK);
		Off_SpD_EVs.setBounds(174, 168, 46, 20);
		contentPane.add(Off_SpD_EVs);
		Off_SpD_EVs.addChangeListener(OChandler);
		
		Off_Spe_EVs = new JSpinner();
		Off_Spe_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Off_Spe_EVs.setToolTipText("");
		Off_Spe_EVs.setForeground(Color.BLACK);
		Off_Spe_EVs.setBounds(174, 193, 46, 20);
		contentPane.add(Off_Spe_EVs);
		Off_Spe_EVs.addChangeListener(OChandler);

		Off_HP_IVs = new JSpinner();
		Off_HP_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Off_HP_IVs.setToolTipText("");
		Off_HP_IVs.setForeground(Color.BLACK);
		Off_HP_IVs.setBounds(231, 68, 39, 20);
		contentPane.add(Off_HP_IVs);
		Off_HP_IVs.addChangeListener(OChandler);
		
		Off_Att_IVs = new JSpinner();
		Off_Att_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Off_Att_IVs.setToolTipText("");
		Off_Att_IVs.setForeground(Color.BLACK);
		Off_Att_IVs.setBounds(231, 93, 39, 20);
		contentPane.add(Off_Att_IVs);
		Off_Att_IVs.addChangeListener(OChandler);
		
		Off_Def_IVs = new JSpinner();
		Off_Def_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Off_Def_IVs.setToolTipText("");
		Off_Def_IVs.setForeground(Color.BLACK);
		Off_Def_IVs.setBounds(231, 118, 39, 20);
		contentPane.add(Off_Def_IVs);
		Off_Def_IVs.addChangeListener(OChandler);
		
		Off_SpA_IVs = new JSpinner();
		Off_SpA_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Off_SpA_IVs.setToolTipText("");
		Off_SpA_IVs.setForeground(Color.BLACK);
		Off_SpA_IVs.setBounds(231, 143, 39, 20);
		contentPane.add(Off_SpA_IVs);
		Off_SpA_IVs.addChangeListener(OChandler);
		
		Off_SpD_IVs = new JSpinner();
		Off_SpD_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Off_SpD_IVs.setToolTipText("");
		Off_SpD_IVs.setForeground(Color.BLACK);
		Off_SpD_IVs.setBounds(231, 168, 39, 20);
		contentPane.add(Off_SpD_IVs);
		Off_SpD_IVs.addChangeListener(OChandler);
		
		Off_Spe_IVs = new JSpinner();
		Off_Spe_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Off_Spe_IVs.setToolTipText("");
		Off_Spe_IVs.setForeground(Color.BLACK);
		Off_Spe_IVs.setBounds(230, 193, 39, 20);
		contentPane.add(Off_Spe_IVs);
		Off_Spe_IVs.addChangeListener(OChandler);
		
		Def_HP_IVs = new JSpinner();
		Def_HP_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Def_HP_IVs.setToolTipText("");
		Def_HP_IVs.setForeground(Color.BLACK);
		Def_HP_IVs.setBounds(231, 414, 39, 20);
		contentPane.add(Def_HP_IVs);
		Def_HP_IVs.addChangeListener(DChandler);
		
		Def_Att_IVs = new JSpinner();
		Def_Att_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Def_Att_IVs.setToolTipText("");
		Def_Att_IVs.setForeground(Color.BLACK);
		Def_Att_IVs.setBounds(231, 439, 39, 20);
		contentPane.add(Def_Att_IVs);
		Def_Att_IVs.addChangeListener(DChandler);
		
		Def_Def_IVs = new JSpinner();
		Def_Def_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Def_Def_IVs.setToolTipText("");
		Def_Def_IVs.setForeground(Color.BLACK);
		Def_Def_IVs.setBounds(231, 464, 39, 20);
		contentPane.add(Def_Def_IVs);
		Def_Def_IVs.addChangeListener(DChandler);
		
		Def_HP_EVs = new JSpinner();
		Def_HP_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Def_HP_EVs.setToolTipText("");
		Def_HP_EVs.setForeground(Color.BLACK);
		Def_HP_EVs.setBounds(174, 414, 47, 20);
		contentPane.add(Def_HP_EVs);
		Def_HP_EVs.addChangeListener(DChandler);
		
		Def_Att_EVs = new JSpinner();
		Def_Att_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Def_Att_EVs.setToolTipText("");
		Def_Att_EVs.setForeground(Color.BLACK);
		Def_Att_EVs.setBounds(174, 439, 47, 20);
		contentPane.add(Def_Att_EVs);
		Def_Att_EVs.addChangeListener(DChandler);
		
		Def_Def_EVs = new JSpinner();
		Def_Def_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Def_Def_EVs.setToolTipText("");
		Def_Def_EVs.setForeground(Color.BLACK);
		Def_Def_EVs.setBounds(174, 464, 47, 20);
		contentPane.add(Def_Def_EVs);
		Def_Def_EVs.addChangeListener(DChandler);
		
		Def_SpA_EVs = new JSpinner();
		Def_SpA_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Def_SpA_EVs.setToolTipText("");
		Def_SpA_EVs.setForeground(Color.BLACK);
		Def_SpA_EVs.setBounds(174, 489, 47, 20);
		contentPane.add(Def_SpA_EVs);
		Def_SpA_EVs.addChangeListener(DChandler);
		
		Def_SpD_EVs = new JSpinner();
		Def_SpD_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Def_SpD_EVs.setToolTipText("");
		Def_SpD_EVs.setForeground(Color.BLACK);
		Def_SpD_EVs.setBounds(174, 514, 47, 20);
		contentPane.add(Def_SpD_EVs);
		Def_SpD_EVs.addChangeListener(DChandler);
	
		Def_SpA_IVs = new JSpinner();
		Def_SpA_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Def_SpA_IVs.setToolTipText("");
		Def_SpA_IVs.setForeground(Color.BLACK);
		Def_SpA_IVs.setBounds(231, 489, 39, 20);
		contentPane.add(Def_SpA_IVs);
		Def_SpA_IVs.addChangeListener(DChandler);
		
		Def_SpD_IVs = new JSpinner();
		Def_SpD_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Def_SpD_IVs.setToolTipText("");
		Def_SpD_IVs.setForeground(Color.BLACK);
		Def_SpD_IVs.setBounds(231, 514, 39, 20);
		contentPane.add(Def_SpD_IVs);
		Def_SpD_IVs.addChangeListener(DChandler);
		
		Def_Spe_EVs = new JSpinner();
		Def_Spe_EVs.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		Def_Spe_EVs.setToolTipText("");
		Def_Spe_EVs.setForeground(Color.BLACK);
		Def_Spe_EVs.setBounds(174, 539, 46, 20);
		contentPane.add(Def_Spe_EVs);
		Def_Spe_EVs.addChangeListener(DChandler);
		
		Def_Spe_IVs = new JSpinner();
		Def_Spe_IVs.setModel(new SpinnerNumberModel(31, 0, 31, 1));
		Def_Spe_IVs.setToolTipText("");
		Def_Spe_IVs.setForeground(Color.BLACK);
		Def_Spe_IVs.setBounds(231, 539, 39, 20);
		contentPane.add(Def_Spe_IVs);
		Def_Spe_IVs.addChangeListener(DChandler);
		
		Off_Level = new JSpinner();
		Off_Level.setModel(new SpinnerNumberModel(50, 1, 100, 1));
		Off_Level.setBounds(437, 68, 43, 20);
		contentPane.add(Off_Level);
		Off_Level.addChangeListener(OChandler);
		
		Def_Level = new JSpinner();
		Def_Level.setModel(new SpinnerNumberModel(50, 1, 100, 1));
		Def_Level.setBounds(437, 414, 43, 20);
		contentPane.add(Def_Level);
		Def_Level.addChangeListener(DChandler);
		
		
		Off_Poke_Pic = new JLabel();
		Off_Poke_Pic.setBounds(36, 221, 137, 128);
		contentPane.add(Off_Poke_Pic);
		
		Def_Poke_Pic = new JLabel();
		Def_Poke_Pic.setBounds(335, 217, 138, 132);
		contentPane.add(Def_Poke_Pic);
		
		Green_Arrow = new JLabel(new ImageIcon(getClass().getResource("calc_arrow.png")));
		Green_Arrow.setBounds(174, 267, 159, 20);
		contentPane.add(Green_Arrow);
		Green_Arrow.setVisible(false);
		
		Red_Arrow = new JLabel(new ImageIcon(getClass().getResource("ret_arrow.png")));
		Red_Arrow.setBounds(174, 287, 152, 24);
		contentPane.add(Red_Arrow);
		Red_Arrow.setVisible(false);
		
		JButton Calculate_Button = new JButton("Calculate");
		Calculate_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Event) {
						
				AllTheCalculations(Off_Pokemon, Def_Pokemon, Off_Damage_Calc, Off_Move, Off_Hit_Count, Off_Weight, Def_Weight, Off_Ability, Def_Ability, Off_Type_A, Off_Type_B, Off_Evol, Def_Evol, Off_Move_Contact, Off_HP_Base,  Off_Att_Base, Off_Def_Base, Off_SpA_Base, Off_SpD_Base, Off_Spe_Base, Off_Move_Type, Off_Move_Power, Off_Move_Category, Off_SpecialMod, Def_TypeA, Def_TypeB , Off_Att, Off_SpA, Def_Def, Def_SpD, Off_Att_Boost, Off_SpA_Boost, Def_Def_Boost, Def_SpD_Boost , Off_Level, Off_Item, Def_Item , Off_Damage_Calc, Def_HP, Off_KO);
				if (Off_KO.toString().contains("HK")) {
					Green_Arrow.setVisible(true);
				}
			}
		});
		Calculate_Button.setBounds(480, 228, 89, 41);
		contentPane.add(Calculate_Button);
		
		JButton Retaliate_Button = new JButton("Retaliate");
		
		
		Retaliate_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Event) {
				
				AllTheCalculations(Def_Pokemon, Off_Pokemon, Def_Damage_Calc, Def_Move, Def_Hit_Count, Def_Weight, Off_Weight, Def_Ability, Off_Ability, Def_TypeA, Def_TypeB, Def_Evol, Off_Evol, Def_Move_Contact, Def_HP,  Def_Att, Def_Def, Def_SpA, Def_SpD, Def_Spe, Def_Move_Type, Def_Move_Power, Def_Move_Category, Def_SpecialMod, Off_Type_A, Off_Type_B , Def_Att, Def_SpA, Off_Def, Off_SpD, Def_Att_Boost, Def_SpA_Boost, Off_Def_Boost, Off_SpD_Boost , Def_Level, Def_Item, Off_Item , Def_Damage_Calc, Off_HP, Def_KO);
				if (Def_KO.toString().contains("HK")) {
					Red_Arrow.setVisible(true);
				}
			}
		});
		
		
		Retaliate_Button.setBounds(480, 307, 89, 44);
		contentPane.add(Retaliate_Button);
		
			
//////////////////////		
		

		Off_Pokemon = new JComboBox();
		
		for (int i = 0; i < Pokey.size(); i++) {
			Off_Pokemon.addItem(Pokey.get(i));
		}
		
		Off_Pokemon.setSelectedIndex(0);
		
		Off_Pokemon.addActionListener(		
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						
						if (Off_Pokemon.getSelectedItem().toString() == "--select Pokemon--" ) {
							OffDefaultSettings ();
						} else {
						
							Pokemon superPoke = (Pokemon)Off_Pokemon.getSelectedItem();					
							int bst[] = superPoke.getBaseStats();
							String BaseStats[]=Arrays.toString(bst).split("[\\[\\]]")[1].split(", ");			
							Off_HP_Base.setText(BaseStats[0]);
							Off_Att_Base.setText(BaseStats[1]);
							Off_Def_Base.setText(BaseStats[2]);
							Off_SpA_Base.setText(BaseStats[3]);
							Off_SpD_Base.setText(BaseStats[4]);
							Off_Spe_Base.setText(BaseStats[5]);	
							Off_Type_A.setText(superPoke.getTypeA());
							Off_Type_B.setText(superPoke.getTypeB());
							
							Off_Weight.setText(Double.toString(superPoke.getWeight()));
							Off_Evol.setText(String.valueOf(superPoke.getEvol()));
							OffListener();	
												        
					        Flip obj=new Flip();
					        
							try {
								BufferedImage bi = ImageIO.read(new File("C:\\Users\\Nodetails\\workspace\\Pokemon_Damage_Calculator\\Image_Location\\" + Off_Pokemon.getSelectedItem().toString() + ".png"));
						        BufferedImage dest = obj.flipVertical(bi);
						        ImageIcon icon = new ImageIcon(dest);
						        
						        Off_Poke_Pic.setIcon(icon);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
					}
					
				});
		Off_Pokemon.setBounds(174, 12, 184, 20);
		contentPane.add(Off_Pokemon);
		
		
		Def_Pokemon = new JComboBox();

		
		for (int i = 0; i < Pokey.size(); i++) {
			Def_Pokemon.addItem(Pokey.get(i));
		}
		
		Def_Pokemon.setSelectedIndex(0);
		Def_Pokemon.addActionListener(		
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						
						if (Def_Pokemon.getSelectedItem().toString() == "--select Pokemon--" ) {
							DefDefaultSettings ();
						} else {
							
							Pokemon superPoke = (Pokemon)Def_Pokemon.getSelectedItem();	
											
							int bst[] = superPoke.getBaseStats();
							String BaseStats[]=Arrays.toString(bst).split("[\\[\\]]")[1].split(", ");			
							Def_HP_Base.setText(BaseStats[0]);
							Def_Att_Base.setText(BaseStats[1]);
							Def_Def_Base.setText(BaseStats[2]);
							Def_SpA_Base.setText(BaseStats[3]);
							Def_SpD_Base.setText(BaseStats[4]);
							Def_Spe_Base.setText(BaseStats[5]);	
							Def_TypeA.setText(superPoke.getTypeA());
							Def_TypeB.setText(superPoke.getTypeB());
							
							Def_Weight.setText(Double.toString(superPoke.getWeight()));
							Def_Evol.setText(String.valueOf(superPoke.getEvol()));
							DefListener();
							
							Def_Poke_Pic.setIcon(superPoke.getPic());
						}
					}
					
				});
		Def_Pokemon.setBounds(174, 359, 177, 20);
		contentPane.add(Def_Pokemon);
		
		WeatherBox = new JComboBox();
		WeatherBox.setModel(new DefaultComboBoxModel(new String[] {"-none-","Sun","Rain","Hail","Sand"}));
		WeatherBox.setBounds(486, 12, 98, 20);
		contentPane.add(WeatherBox);
		
		Off_Nature = new JComboBox();
		Off_Nature.setModel(new DefaultComboBoxModel(Natures));
		Off_Nature.setBounds(437, 93, 132, 20);
		contentPane.add(Off_Nature);
		Off_Nature.addActionListener(OAhandler);
		
		Off_Item = new JComboBox();
		Off_Item.setModel(new DefaultComboBoxModel(new String[] {"-none/other-", "Choice Band", "Choice Specs", "Life Orb", "Expert Belt", "Eviolite"}));
		Off_Item.setBounds(437, 118, 132, 20);
		contentPane.add(Off_Item);
		
		Off_Ability = new JComboBox();
		Off_Ability.setModel(new DefaultComboBoxModel(new String[] {"-other-", "Adaptability", "Aerialate", "Blaze(a)", "Dark Aura", "Fairy Aura", "Filter", "Flash Fire(a)", "Fur Coat", "Guts(a)", "Heatproof", "Heavy Metal", "Huge Power", "Hustle", "Iron Fist", "Marvel Scale", "Mega Launcher", "Normalize", "Overgrow(a)", "Paternal Bond", "Pixelate", "Protean", "Pure Power", "Reckless", "Refrigerate", "Rivalry(SameG)", "Rivalry(DifG)", "Sand Force", "Sheer Force", "Slow Start", "Solar Power", "Solid Rock", "Strong Jaw", "Swarm(a)", "Technician", "Thick Fat", "Tinted Lens", "Torrent(a)", "Tough Claws", "Toxic Boost"}));
		Off_Ability.setBounds(437, 143, 132, 20);
		contentPane.add(Off_Ability);
		
		Off_Move = new JComboBox();
		
		for (int i = 0; i < Action.size(); i++) {
			Off_Move.addItem(Action.get(i));
		}
		
		Off_Move.setSelectedIndex(0);
		
		Off_Move.addActionListener(		
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						
						Move Attack = (Move)Off_Move.getSelectedItem();
						Off_Move_Type.setText(String.valueOf(Attack.getType()));
						Off_Move_Category.setText(String.valueOf(Attack.getCategory()));
						Off_Move_Contact.setText(String.valueOf(Attack.getContact()));
						
						
						if (Off_Move.getSelectedItem().toString() == "--select Move--") {
							Off_Move_Power.setText("--");
						} else {
							Off_Move_Power.setText(String.valueOf(Attack.getPower()));
						}
						
						
						if (Attack.getSpecialMod() == 'D' || Attack.getSpecialMod() == 'M') {	
							Off_SpecialMod.setText(String.valueOf(Attack.getSpecialMod()));
						    Off_Hits_label.setVisible(true);
						    Off_SpecialMod.setVisible(true);
						    Off_Hit_Count.setVisible(true);

						    if (Attack.getSpecialMod() == 'D') {	
						    	Off_Hit_Count.setModel(new SpinnerNumberModel(2, 2, 2, 1));
						    } else {
						    	Off_Hit_Count.setModel(new SpinnerNumberModel(2, 2, 5, 1));
						    }
						    
						} else if (Attack.getSpecialMod() == 'W' || Attack.getSpecialMod() == 'P' || Attack.getSpecialMod() == 'A' || Attack.getSpecialMod() == 'B' || Attack.getSpecialMod() == 'R' ) {
							Off_SpecialMod.setText(String.valueOf(Attack.getSpecialMod()));	
						} else {
							Off_SpecialMod.setVisible(false);
						    Off_Hits_label.setVisible(false);
						    Off_Hit_Count.setVisible(false);	
						    Off_Hit_Count.setModel(new SpinnerNumberModel(1, 1, 1, 1));
						}
					}
				});
		Off_Move.setBounds(437, 168, 112, 20);
		contentPane.add(Off_Move);
		
		
		Def_Nature = new JComboBox();
		Def_Nature.setModel(new DefaultComboBoxModel(Natures));
		Def_Nature.setBounds(437, 439, 132, 20);
		contentPane.add(Def_Nature);
		Def_Nature.addActionListener(DAhandler);
		
		Def_Item = new JComboBox();
		Def_Item.setModel(new DefaultComboBoxModel(new String[] {"-none/other-", "Choice Band", "Choice Specs", "Life Orb", "Expert Belt", "Eviolite"}));
		Def_Item.setBounds(437, 464, 132, 20);
		contentPane.add(Def_Item);
		
		Def_Ability = new JComboBox();
		Def_Ability.setModel(new DefaultComboBoxModel(new String[] {"-other-", "Adaptability", "Aerialate", "Blaze(a)", "Dark Aura", "Fairy Aura", "Filter", "Flash Fire(a)", "Fur Coat", "Guts(a)", "Heatproof", "Heavy Metal", "Huge Power", "Hustle", "Iron Fist", "Marvel Scale", "Mega Launcher", "Normalize", "Overgrow(a)", "Paternal Bond", "Pixelate", "Protean", "Pure Power", "Reckless", "Refrigerate", "Rivalry(SameG)", "Rivalry(DifG)", "Sand Force", "Sheer Force", "Slow Start", "Solar Power", "Solid Rock", "Strong Jaw", "Swarm(a)", "Technician", "Thick Fat", "Tinted Lens", "Torrent(a)", "Tough Claws", "Toxic Boost"}));
		Def_Ability.setBounds(437, 489, 132, 20);
		contentPane.add(Def_Ability);
		
		Def_Move = new JComboBox();
		
		for (int i = 0; i < Action.size(); i++) {
			Def_Move.addItem(Action.get(i));
		}
		
		Def_Move.setSelectedIndex(0);
		
		Def_Move.addActionListener(	
		new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				Move Attack = (Move)Def_Move.getSelectedItem();			
				Def_Move_Type.setText(String.valueOf(Attack.getType()));
				Def_Move_Category.setText(String.valueOf(Attack.getCategory()));
				Def_Move_Contact.setText(String.valueOf(Attack.getContact()));
				
				if (Def_Move.getSelectedItem().toString() == "--select Move--") {
					Def_Move_Power.setText("--");
				} else {
					Def_Move_Power.setText(String.valueOf(Attack.getPower()));
				}
				
				
				if (Attack.getSpecialMod() == 'D' || Attack.getSpecialMod() == 'M' ) {	
					Def_SpecialMod.setVisible(true);
					Def_SpecialMod.setText(String.valueOf(Attack.getSpecialMod()));
				    Def_Hits_label.setVisible(true);
				    Def_Hit_Count.setVisible(true);
				    
				    if (Attack.getSpecialMod() == 'D') {
				    
				    	Def_Hit_Count.setModel(new SpinnerNumberModel(2, 2, 2, 1));
				    } else {
				    	Def_Hit_Count.setModel(new SpinnerNumberModel(2, 2, 5, 1));
				    }
				} else if (Attack.getSpecialMod() == 'W' || Attack.getSpecialMod() == 'P' || Attack.getSpecialMod() == 'A' || Attack.getSpecialMod() == 'B' || Attack.getSpecialMod() == 'R'  ) {
					Def_SpecialMod.setText(String.valueOf(Attack.getSpecialMod()));		
				}
				else {
					Def_SpecialMod.setVisible(false);
					Def_Hits_label.setVisible(false);
				    Def_Hit_Count.setVisible(false);	
				    Def_Hit_Count.setModel(new SpinnerNumberModel(1, 1, 1, 1));
				}
			}
		});
		
		Def_Move.setBounds(437, 514, 112, 20);
		contentPane.add(Def_Move);
		
		Off_Evol = new JLabel("New label");
		Off_Evol.setBounds(325, 71, 46, 14);
		Off_Evol.setVisible(false);
		contentPane.add(Off_Evol);
		
		Def_Evol = new JLabel("New label");
		Def_Evol.setBounds(325, 417, 46, 14);
		Def_Evol.setVisible(false);
		contentPane.add(Def_Evol);
		
		Off_Move_Contact = new JLabel("X");
		Off_Move_Contact.setBounds(405, 196, 14, 14);
		Off_Move_Contact.setVisible(false);
		contentPane.add(Off_Move_Contact);
		
		Def_Move_Contact = new JLabel("X");
		Def_Move_Contact.setBounds(404, 542, 6, 14);
		Def_Move_Contact.setVisible(false);
		contentPane.add(Def_Move_Contact);
		

		

	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
	
	public  ArrayList<Pokemon> Pokedex (ArrayList<Pokemon> Pokey) {

		Pokey.add(new Pokemon("--select Pokemon--",'-', "--", "--", new int[] {0,0,0,0,0,0}, 0, null));
		Pokey.add(new Pokemon("Abomasnow",'F', "Grass", "Ice", new int[] {90,92,75,92,85,60}, 298.7, new ImageIcon(getClass().getResource("Abomasnow.png"))));
		Pokey.add(new Pokemon("Accelgor",'F', "Bug", new int[] {80,70,40,100,60,145}, 55.8, new ImageIcon(getClass().getResource("Accelgor.png"))));
		Pokey.add(new Pokemon("Aegislash(S)",'F', "Steel", "Ghost", new int[] {60,50,150,50,150,60}, 116.8, new ImageIcon(getClass().getResource("Aegislash(S).png"))));
		Pokey.add(new Pokemon("Aegislash(B)",'F', "Steel", "Ghost", new int[] {60,150,50,150,50,60}, 116.8, new ImageIcon(getClass().getResource("Aegislash(B).png"))));
		Pokey.add(new Pokemon("Aerodactyl",'F', "Rock", "Flying", new int[] {80,105,65,60,75,130}, 130.1, new ImageIcon(getClass().getResource("Aerodactyl.png"))));
		Pokey.add(new Pokemon("Aggron",'F', "Steel", "Rock", new int[] {70,110,180,60,60,50}, 793.7, new ImageIcon(getClass().getResource("Aggron.png"))));
		Pokey.add(new Pokemon("Alakazam",'F', "Psychic",new int[] {55,50,45,135,95,120}, 105.8, new ImageIcon(getClass().getResource("Alakazam.png"))));
		Pokey.add(new Pokemon("Arceus",'F', "Normal", new int[] {120,120,120,120,120,120}, 705.5, new ImageIcon(getClass().getResource("Arceus.png"))));
		Pokey.add(new Pokemon("Archeops",'F', "Rock", "Flying", new int[] {75,140,65,112,65,110}, 70.5, new ImageIcon(getClass().getResource("Archeops.png"))));
		Pokey.add(new Pokemon("Azumarill",'F', "Water", "Fairy", new int[]{100,50,80,60,80,50}, 62.8, new ImageIcon(getClass().getResource("Azumarill.png"))));
		Pokey.add(new Pokemon("Bisharp",'F', "Dark", "Steel", new int[]{65,125,100,60,70,70}, 154.3, new ImageIcon(getClass().getResource("Bisharp.png"))));
		Pokey.add(new Pokemon("Blastoise",'F', "Water", new int[] {79, 83, 100, 85, 105, 78}, 188.5, new ImageIcon(getClass().getResource("Blastoise.png"))));
		Pokey.add(new Pokemon("Blissey",'F', "Normal", new int[] {255,10,10,75,135,55}, 103.2, new ImageIcon(getClass().getResource("Blissey.png"))));
		Pokey.add(new Pokemon("Breloom",'F', "Grass", "Fight", new int[] {60,130,80,60,60,70}, 86.4, new ImageIcon(getClass().getResource("Breloom.png"))));
		Pokey.add(new Pokemon("Carracosta",'F', "Water", "Rock", new int[] {74,108,133,83,65,32}, 178.6,  new ImageIcon(getClass().getResource("Carracosta.png")) ));
		Pokey.add(new Pokemon("Charizard",'F', "Fire", "Flying", new int[] {78,84,78,109,85,100}, 199.5, new ImageIcon(getClass().getResource("Charizard.png"))));
		Pokey.add(new Pokemon("Clefable",'F', "Fairy", new int[] {95,70,73,95,90,60}, 88.2, new ImageIcon(getClass().getResource("Clefable.png"))));
		Pokey.add(new Pokemon("Conkeldurr",'F', "Fight", new int[] {105,140,95,55,65,45}, 191.8, new ImageIcon(getClass().getResource("Conkeldurr.png"))));
		Pokey.add(new Pokemon("Diglett",'N', "Ground", new int[] {10,55,25,35,45,95}, 1.8, new ImageIcon(getClass().getResource("Diglett.png"))));
		Pokey.add(new Pokemon("Deoxys-S",'F', "Psychic", new int[] {50,95,90,95,90,180}, 134.0, new ImageIcon(getClass().getResource("Deoxys-S.png"))));
		Pokey.add(new Pokemon("Ditto",'F', "Normal", new int[] {48,48,48,48,48,48}, 8.8, new ImageIcon(getClass().getResource("Ditto.png"))));
		Pokey.add(new Pokemon("Dragonite",'F', "Dragon", "Flying", new int[]{91,134,95,100,100,80}, 463.0, new ImageIcon(getClass().getResource("Dragonite.png"))));
		Pokey.add(new Pokemon("Espeon",'F', "Psychic", new int[]{65,65,60,130,95,110}, 58.4, new ImageIcon(getClass().getResource("Espeon.png"))));
		Pokey.add(new Pokemon("Excadrill",'F', "Ground", "Steel", new int[] {110,135,60,50,65,88}, 89.1, new ImageIcon(getClass().getResource("Excadrill.png"))));
		Pokey.add(new Pokemon("Ferrothorn",'F', "Grass", "Steel", new int[] {74,94,131,54,116,20}, 242.5, new ImageIcon(getClass().getResource("Ferrothorn.png"))));
		Pokey.add(new Pokemon("Galvantula",'F', "Bug", "Electric", new int[] {70,77,60,97,60,108}, 31.5, new ImageIcon(getClass().getResource("Galvantula.png"))));
		Pokey.add(new Pokemon("Garchomp",'F', "Dragon", "Ground",  new int[] {108, 130, 95, 80, 85, 102}, 209.4, new ImageIcon(getClass().getResource("Garchomp.png"))));
		Pokey.add(new Pokemon("Genesect",'F', "Bug", "Steel", new int[] {71,120,95,120,95,99}, 181.9, new ImageIcon(getClass().getResource("Genesect.png"))));
		Pokey.add(new Pokemon("Gengar",'F', "Ghost", "Poison",  new int[] {60,65,60,130,75,110}, 89.3, new ImageIcon(getClass().getResource("Gengar.png"))));
		Pokey.add(new Pokemon("Glaceon",'F', "Ice", new int[] {65,60,110,130,95,65}, 57.1, new ImageIcon(getClass().getResource("Glaceon.png"))));
		Pokey.add(new Pokemon("Gliscor",'F', "Ground", "Flying", new int[] {75,95,125,45,75,95}, 93.7, new ImageIcon(getClass().getResource("Gliscor.png"))));
		Pokey.add(new Pokemon("Goodra",'F', "Dragon", new int[] {90,100,70,110,150,80}, 331.8, new ImageIcon(getClass().getResource("Goodra.png"))));
		Pokey.add(new Pokemon("Greninja",'F', "Water", "Dark", new int[] {72,95,67,103,71,122}, 88.2, new ImageIcon(getClass().getResource("Greninja.png"))));
		Pokey.add(new Pokemon("Gyarados",'F', "Water", "Flying", new int[]{95,155,109,70,130,81}, 518.1, new ImageIcon(getClass().getResource("Gyarados.png"))));
		Pokey.add(new Pokemon("Heatran",'F', "Fire", "Steel", new int[]{91,90,106,130,106,77}, 948.0, new ImageIcon(getClass().getResource("Heatran.png"))));
		Pokey.add(new Pokemon("Kangaskhan",'F', "Normal", new int[] {105,95,80,40,80,90}, 176.4, new ImageIcon(getClass().getResource("Kangaskhan.png"))));
		Pokey.add(new Pokemon("Klefki",'F', "Steel", "Fairy", new int[] {57,80,91,80,87,75}, 6.6, new ImageIcon(getClass().getResource("Klefki.png"))));
		Pokey.add(new Pokemon("Kyurem-B",'F', "Dragon", "Ice", new int[] {125,170,100,120,90,95}, 716.5, new ImageIcon(getClass().getResource("Kyurem-B.png"))));
		Pokey.add(new Pokemon("Landorus",'F', "Ground", "Flying", new int[] {89,125,90,115,80,101}, 149.9, new ImageIcon(getClass().getResource("Landorus.png"))));
		Pokey.add(new Pokemon("Landorus-T",'F', "Ground", "Flying", new int[] {89,145,90,105,80,91}, 149.9, new ImageIcon(getClass().getResource("Landorus-T.png"))));
		Pokey.add(new Pokemon("Latios",'F', "Dragon", "Psychic", new int[] {80,90,80,130,110,110}, 132.3, new ImageIcon(getClass().getResource("Latios.png"))));
		Pokey.add(new Pokemon("Lucario",'F', "Steel", "Fight",  new int[] {70,110,70,115,70,90}, 119.0, new ImageIcon(getClass().getResource("Lucario.png"))));
		Pokey.add(new Pokemon("Mamoswine",'F', "Ice", "Ground",  new int[] {110,130,80,70,60,80}, 641.5, new ImageIcon(getClass().getResource("Mamoswine.png"))));
		Pokey.add(new Pokemon("Mandibuzz",'F', "Dark", "Flying", new int[] {110,65,105,55,95,80}, 87.1, new ImageIcon(getClass().getResource("Mandibuzz.png"))));
		Pokey.add(new Pokemon("Mawile",'F', "Steel", "Fairy", new int[]{50,85,85,55,55,50}, 25.4, new ImageIcon(getClass().getResource("Mawile.png"))));
		Pokey.add(new Pokemon("Pinsir",'F', "Bug", new int[]{65,125,100,55,70,85}, 121.3, new ImageIcon(getClass().getResource("Pinsir.png"))));
		Pokey.add(new Pokemon("Rotom-W",'F', "Electric","Water", new int[] {50,65,107,105,107,86}, 0.7, new ImageIcon(getClass().getResource("Rotom-W.png"))));
		Pokey.add(new Pokemon("Scizor",'F', "Bug", "Steel", new int[] {70,150,140,65,100,75}, 260.1, new ImageIcon(getClass().getResource("Scizor.png"))));
		Pokey.add(new Pokemon("Scyther",'N', "Bug", "Flying", new int[] {70, 110, 80, 55, 80, 105}, 123.5, new ImageIcon(getClass().getResource("Scyther.png"))));
		Pokey.add(new Pokemon("Skarmory",'F', "Steel", "Flying", new int[] {65,80,140,40,70,70}, 111.3, new ImageIcon(getClass().getResource("Skarmory.png"))));
		Pokey.add(new Pokemon("Smeargle",'F', "Normal", new int[] {55,20,35,20,45,75}, 127.9, new ImageIcon(getClass().getResource("Smeargle.png"))));
		Pokey.add(new Pokemon("Talonflame",'F', "Fire", "Flying", new int[] {78,81,71,74,69,126}, 54.0, new ImageIcon(getClass().getResource("Talonflame.png"))));
		Pokey.add(new Pokemon("Thundurus",'F', "Electric", "Flying", new int[] {79,105,70,145,80,101}, 134.5, new ImageIcon(getClass().getResource("Thundurus.png"))));
		Pokey.add(new Pokemon("Togekiss",'F', "Fairy", "Flying", new int[] {85,50,95,120,115,80}, 83.8, new ImageIcon(getClass().getResource("Togekiss.png"))));	
		Pokey.add(new Pokemon("Trevenant",'F', "Ghost", "Grass", new int[] {85,110,76,65,82,56}, 156.5, new ImageIcon(getClass().getResource("Trevenant.png"))));
		Pokey.add(new Pokemon("Tyranitar",'F', "Rock", "Dark", new int[] {100,134,110,95,100,61}, 445.3, new ImageIcon(getClass().getResource("Tyranitar.png"))));
		Pokey.add(new Pokemon("Venusaur",'F', "Grass", "Poison", new int[]{80,82,83,100,100,80}, 220.5, new ImageIcon(getClass().getResource("Venusaur.png"))));
		Pokey.add(new Pokemon("Volcarona",'F', "Bug", "Fire", new int[]{85,60,65,135,105,100}, 101.4, new ImageIcon(getClass().getResource("Volcarona.png"))));
		Pokey.add(new Pokemon("Mega Abomasnow",'F', "Grass", "Ice", new int[]{90,132,105,132,105,30}, 407.8, new ImageIcon(getClass().getResource("Mega Abomasnow.png"))));
		Pokey.add(new Pokemon("Mega Alakazam",'F', "Psychic", new int[]{55,50,65,175,95,150}, 105.8, new ImageIcon(getClass().getResource("Mega Alakazam.png"))));
		Pokey.add(new Pokemon("Mega Blastoise",'F', "Water", new int[]{79,103,120,135,115,78}, 222.9, new ImageIcon(getClass().getResource("Mega Blastoise.png"))));
		Pokey.add(new Pokemon("Mega Charizard X",'F', "Fire", "Dragon", new int[]{78,130,111,130,85,100}, 243.6, new ImageIcon(getClass().getResource("Mega Charizard X.png"))));
		Pokey.add(new Pokemon("Mega Charizard Y",'F', "Fire", "Flying", new int[]{78,104,78,159,115,100}, 221.6, new ImageIcon(getClass().getResource("Mega Charizard Y.png"))));
		Pokey.add(new Pokemon("Mega Garchomp",'F', "Dragon", "Ground", new int[]{108,170,115,120,95,92}, 209.4, new ImageIcon(getClass().getResource("Mega Garchomp.png"))));	
		Pokey.add(new Pokemon("Mega Gengar",'F', "Ghost", "Poison", new int[]{60,65,80,170,95,130}, 89.3, new ImageIcon(getClass().getResource("Mega Gengar.png"))));
		Pokey.add(new Pokemon("Mega Gyarados",'F', "Water", "Dark", new int[]{95,155,109,70,130,81}, 672.4, new ImageIcon(getClass().getResource("Mega Gyarados.png"))));
		Pokey.add(new Pokemon("Mega Kangaskhan",'F', "Normal", new int[]{105,125,100,60,100,100}, 220.5, new ImageIcon(getClass().getResource("Mega Kangaskhan.png"))));
		Pokey.add(new Pokemon("Mega Latios",'F', "Dragon", "Psychic", new int[] {80,130,100,160,120,110}, 154.3, new ImageIcon(getClass().getResource("Mega Latios.png"))));
		Pokey.add(new Pokemon("Mega Lucario",'F', "Fight", "Steel", new int[]{70,145,88,140,70,112}, 126.8, new ImageIcon(getClass().getResource("Mega Lucario.png"))));
		Pokey.add(new Pokemon("Mega Mawile",'F', "Steel", "Fairy", new int[]{50,105,125,55,95,50}, 51.8, new ImageIcon(getClass().getResource("Mega Mawile.png"))));
		Pokey.add(new Pokemon("Mega Pinsir",'F', "Bug", "Flying", new int[]{65,155,120,65,90,105}, 130.1, new ImageIcon(getClass().getResource("Mega Pinsir.png"))));
		Pokey.add(new Pokemon("Mega Scizor",'F', "Bug", "Steel", new int[]{70,150,140,65,100,75}, 275.6, new ImageIcon(getClass().getResource("Mega Scizor.png"))));
		Pokey.add(new Pokemon("Mega Tyranitar",'F', "Rock", "Dark", new int[]{100,164,150,95,120,71}, 562.2, new ImageIcon(getClass().getResource("Mega Tyranitar.png"))));
		Pokey.add(new Pokemon("Mega Venusaur",'F', "Grass", "Poison", new int[]{80,100,123,122,120,80}, 342.8, new ImageIcon(getClass().getResource("Mega Venusaur.png"))));
		
		return Pokey;
	}

	
	public static ArrayList<Move> AttackDex(ArrayList<Move> Action) {
	
		Action.add(new Move("--select Move--","--", 0, '-','-'));
		
		Action.add(new Move("Abomacare","WTF?", 9000, 'P','D'));
		Action.add(new Move("Aqua Jet","Water", 40, 'P','C'));
		Action.add(new Move("Attack Order","Bug", 90, 'P','D'));
		Action.add(new Move("Aura Sphere","Fight", 80, 'S','D','A'));
		Action.add(new Move("Blizzard","Ice", 110, 'S','D'));
		Action.add(new Move("Body Slam","Normal", 85, 'P','C'));
		Action.add(new Move("Bonemerang","Ground", 50, 'P','D', 'D'));
		Action.add(new Move("Brave Bird","Flying", 120, 'P','C','R'));
		Action.add(new Move("Bug Buzz","Bug", 90, 'S','D'));
		Action.add(new Move("Bullet Punch","Steel", 40, 'P','C','P'));
		Action.add(new Move("Close Combat","Fight", 120, 'P','C'));
		Action.add(new Move("Crunch","Dark", 80, 'P','C','B'));
		Action.add(new Move("Dark Pulse","Dark", 80, 'S','D','A'));
		Action.add(new Move("Dazzling Gleam","Fairy", 80, 'S','D'));
		Action.add(new Move("Dig","Ground", 80, 'P','C'));
		Action.add(new Move("Double Edge","Normal", 120, 'P','C','R'));
		Action.add(new Move("Draco Meteor", "Dragon", 130, 'S','D'));
		Action.add(new Move("Dragon Claw","Dragon", 80, 'P','C'));
		Action.add(new Move("Dragon Pulse","Dragon", 100, 'S','D','A'));
		Action.add(new Move("Dragon Rush","Dragon", 90, 'P','C'));
		Action.add(new Move("Drill Run","Ground", 80, 'S','C'));
		Action.add(new Move("Earthquake","Ground", 100, 'P','D'));
		Action.add(new Move("Earth Power","Ground", 90, 'P','D'));
		Action.add(new Move("Extremespeed","Normal", 80, 'P','C'));
		Action.add(new Move("Fiery Dance" ,"Fire", 80, 'S','D'));
		Action.add(new Move("Fire Blast","Fire", 110, 'S','D'));
		Action.add(new Move("Fire Punch" ,"Fire", 75, 'P','C','P'));
		Action.add(new Move("Flamethrower","Fire", 90, 'S','D'));
		Action.add(new Move("Flare Blitz","Fire", 120, 'P','C','R'));
		Action.add(new Move("Flash Cannon","Steel", 80, 'S','D'));
		Action.add(new Move("Focus Blast","Fight", 120, 'S','D'));
		Action.add(new Move("Foul Play","Dark", 95, 'P','C'));
		Action.add(new Move("Grass Knot", "Grass", 20, 'S','C','W'));	
		Action.add(new Move("Gunk Shot","Poison", 120, 'P','D'));
		Action.add(new Move("Heat Crash", "Fire", 40, 'P','C','W'));
		Action.add(new Move("Heat Wave" ,"Fire", 95, 'S','D'));
		Action.add(new Move("Heavy Slam", "Steel", 40, 'P','C','W'));
		Action.add(new Move("Hurricane","Flying", 110, 'S','D'));
		Action.add(new Move("Hydro Pump","Water", 110, 'S','D'));
		Action.add(new Move("Ice Beam", "Ice", 90, 'S','D'));
		Action.add(new Move("Ice Fang", "Ice", 65, 'P','C'));
		Action.add(new Move("Ice Punch","Ice", 75, 'P','C','P'));
		Action.add(new Move("Ice Shard","Ice", 40, 'P','D'));
		Action.add(new Move("Icicle Spear","Ice", 25, 'P','D', 'M'));	
		Action.add(new Move("Leaf Storm","Grass", 130, 'S','D'));
		Action.add(new Move("Low Kick", "Fight", 20, 'P','C','W'));
		Action.add(new Move("Magma Storm","Fire", 100, 'S','D'));
		Action.add(new Move("Megahorn","Bug", 120, 'P','C'));
		Action.add(new Move("Meteor Mash","Steel", 90, 'P','C'));
		Action.add(new Move("Moonblast","Fairy", 95, 'S','D'));
		Action.add(new Move("Outrage","Dragon", 90, 'P','C'));
		Action.add(new Move("Overheat","Fire", 130, 'S','D'));
		Action.add(new Move("Play Rough","Fairy", 90, 'P','C'));
		Action.add(new Move("Poison Jab","Poison", 110, 'P','C','P'));
		Action.add(new Move("Power Whip","Grass", 120, 'P','C'));
		Action.add(new Move("Psychic", "Psychic", 90, 'S','D'));
		Action.add(new Move("Psycho Boost","Psychic", 140, 'S','D'));
		Action.add(new Move("Psyshock","Psychic", 80, 's','D'));
		Action.add(new Move("Psystrike","Psychic", 100, 's','D'));
		
		Action.add(new Move("Sacred Sword","Fight", 90, 'P','C'));
		
		Action.add(new Move("Scald","Water", 80, 'S','D'));
		Action.add(new Move("Seed Bomb","Grass", 80, 'P','D'));
		Action.add(new Move("Shadow Ball","Ghost", 80, 'S','D'));
		Action.add(new Move("Sludge Bomb","Poison", 90, 'S','D'));
		Action.add(new Move("Sludge Wave","Poison", 95, 'S','D'));
		Action.add(new Move("Solar Beam","Grass", 120, 'S','D'));
		Action.add(new Move("Stone Edge" ,"Rock", 100, 'P','D'));
		Action.add(new Move("Sucker Punch","Dark", 80, 'P','C'));
		Action.add(new Move("Superpower","Fight", 120, 'P','C'));
		Action.add(new Move("Surf","Water", 90, 'S','D'));	
		Action.add(new Move("Thunder","Electric", 110, 'S','D'));
		Action.add(new Move("Thunder Punch","Electric", 75, 'P','C','P'));
		Action.add(new Move("Thunderbolt","Electric", 90, 'S','D'));
		Action.add(new Move("U-turn","Bug", 70, 'P','C'));
		Action.add(new Move("Vacuum Wave","Fight", 40, 'S','D'));
		Action.add(new Move("Volt Tackle","Electric", 120, 'P','C','R'));
		Action.add(new Move("Weather Ball","Normal", 50, 'S','D'));
		Action.add(new Move("Wood Hammer","Grass", 120, 'P','C','R'));

		return Action;
	
	}
	
	public static double[] LevelUp (int Level, int[] IV, int Base[], int[] EV, double[] Nature) {
	
		double Stats[] = new double[6];
		
		Stats[0] = Math.floor((((IV[0] + (2 * Base[0]) + (EV[0] / 4.0) + 100) * Level) / 100.0 ) + 10); // HP
		for (int i=1; i < Stats.length; i++) {
			Stats[i] =  Math.floor(((((IV[i] + (2 * Base[i]) + (EV[i] / 4.0)) * Level) / 100.0) + 5) * Nature[i-1]);
		}
		
		return Stats;
	}
	
	
	public static double[] DamageCalc(Weather Forecast, int OffBoost, int DefBoost,  String PokemonTypeA, String PokemonTypeB, double OffWeight, double DefWeight, String AttType, int Level, double Att, double Def, double SpA, double SpD, int Power, double WeakResMod, char Category, String HoldItem, String MoveName, int Strike, char SpecialMod, String OffAbility, String DefAbility) {
	
		double STAB = 1;	
		double AttPow=0;
		double DefPow=0;
		double Damage[] = new double[16];
		double Mod;

		
		if (SpecialMod == 'W') {
			Power = WeightCorrection (MoveName, OffWeight, DefWeight, Power);
		}
		
		if (Forecast.getWeather().equals("Sun") || Forecast.getWeather().equals("Rain")) {
			Power = Forecast.SunRainAttMod(AttType, Power);
		}
		
		if (MoveName.equals("Sacred Sword")) {
			DefBoost = 0;
		}
		
		double ItemMod = ItemModifier (HoldItem,Category,WeakResMod);
		
		switch(Category) {
			case 'P':
				AttPow = Att;
				DefPow = Def;
				break;
			case 'S':
				AttPow = SpA;
				DefPow = SpD;
				break;
			case 'p':
				AttPow = Att;
				DefPow = SpD;
				break;	
			case 's':
				AttPow = SpA;
				DefPow = Def;
				break;	
			default:
				// do nothing
				break;
		}
		
		AttPow = StatBonus(OffBoost, AttPow);
		DefPow = StatBonus(DefBoost, DefPow);
			
		if (OffAbility.equals("Protean")) {
			STAB = 1.5;
		} else {
			if (PokemonTypeB == null) {
				
				if (PokemonTypeA.equals(AttType)) {
					if (OffAbility.equals("Adaptability")) {
						STAB = 2;
					} else {
						STAB = 1.5;
					}
				}
				
			} else {
				
				if (PokemonTypeA.equals(AttType) || PokemonTypeB.equals(AttType)) {				
					if (OffAbility.equals("Adaptability")) {
						STAB = 2;
					} else {
						STAB = 1.5;
					}
				}	
			}
		}
		
		double Rand = 0.85;
		
		for (int i=0;i < Damage.length; i++) {
			Mod = STAB * WeakResMod * ItemMod * Rand;
			Damage[i] = (Math.floor((((2 * Level + 10) / 250.0) * (AttPow / DefPow) * Power + 2) * Mod)) * Strike;
			
			Damage[i] = DamageAdjustAbilities(DefAbility, OffAbility, WeakResMod, Damage[i],  AttType, Category);
			
			
			Rand += 0.01;
		}
		return Damage;
		
	}
	
	public static double ItemModifier (String HoldItem, char Category, double WeakResMod) {
		
		double ItemMod = 1;
		
		switch (HoldItem) {
		
		case "Life Orb":
			ItemMod*= 1.3;
			break;
		case "Choice Band":
			if (Category == 'P' || Category == 'p') {
				ItemMod*=1.5;
			}
			break;
		case "Choice Specs":
			if (Category == 'S' || Category == 's') {
				ItemMod*=1.5;
			}
			break;
		case "Expert Belt":
			if (WeakResMod >= 2.0) {
				ItemMod*=1.2;
			}
				break;
		default:
			//Do nothing
			break;
		}
		return ItemMod;		
	}


	public static double StatBonus(int StatAugment, double Stat) {
		
		double Boost;
		
		if (StatAugment >= 0) {
			Boost = 1 + 0.5*StatAugment;
		}
		else {
			Boost = 1.0 / (1 + 0.5*Math.abs(StatAugment));
		}
		
		Stat = Stat*Boost;
		
		return Stat;
		
	}	

	public static int WeightCorrection (String MoveName, double OffWeight, double DefWeight, int Power) {

		switch(MoveName) {
		
			case "Grass Knot": case "Low Kick":
				if (DefWeight <= 22) {
					Power = 20;
				} else if (DefWeight <= 55) {
					Power = 40;
				} else if (DefWeight <= 110) {
					Power = 60;
				} else if (DefWeight <= 220) {
					Power = 80;
				} else if (DefWeight <= 440) {
					Power = 100;
				} else {
					Power = 120;
				}
				break;
			case "Heavy Slam": case "Heat Crash":
				
				if (DefWeight <= OffWeight * 0.2) {
					Power = 120;
				} else if (DefWeight <= OffWeight * 0.25) {
					Power = 100;
				} else if (DefWeight <= OffWeight * 0.33) {
					Power = 80;
				} else if (DefWeight <= OffWeight * 0.5) {
					Power = 60;
				} else {
					Power = 40;
				}
				break;
		}	
		return Power;
	}
	
	
	public static double TypeChart (double DamageMod, String MoveType, String DefType) {
	
		switch(MoveType) {
		
			case "Normal":
				
				if (DefType.equals("Rock") || DefType.equals("Steel")) {
				}
				if (DefType.equals("Ghost")) {
					DamageMod*=0;
				} 
				break;
				
			case "Fight":
				
				if (DefType.equals("Flying") || DefType.equals("Poison") || DefType.equals("Bug") || DefType.equals("Psychic") || DefType.equals("Fairy")) {
					DamageMod *= 0.5;
				}
	
				if (DefType.equals("Normal") || DefType.equals("Rock") || DefType.equals("Steel") || DefType.equals("Ice") || DefType.equals("Dark")) {
					DamageMod *= 2.0;
				}
	
				if (DefType.equals("Ghost")) {
					DamageMod*=0;
				} 
				break;
				
			case "Flying":
				
				if(DefType.equals("Rock") || DefType.equals("Steel") || DefType.equals("Electric")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Fight") || DefType.equals("Bug") || DefType.equals("Grass")) {
					DamageMod*=2.0;
				}
				break;
				
			case "Poison":
				
				if(DefType.equals("Poison") || DefType.equals("Ground") || DefType.equals("Rock") || DefType.equals("Ghost")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Grass") || DefType.equals("Fairy")) {
					DamageMod*=2.0;
				}
				if (DefType.equals("Steel")) {
					DamageMod*=0;
				} 
				break;
				
			case "Ground":
				
				if(DefType.equals("Bug") || DefType.equals("Grass")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Poison") || DefType.equals("Rock") || DefType.equals("Steel") || DefType.equals("Fire") || DefType.equals("Electric")) {
					DamageMod*=2.0;
				}
				if (DefType.equals("Flying")) {
					DamageMod*=0;
				} 
				break;
				
			case "Rock":
				
				if(DefType.equals("Fight") || DefType.equals("Ground") || DefType.equals("Steel")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Flying") || DefType.equals("Bug") || DefType.equals("Fire") || DefType.equals("Ice")) {
					DamageMod*=2.0;
				}
				break;
				
			case "Bug":
				
				if(DefType.equals("Fight") || DefType.equals("Flying") || DefType.equals("Poison") || DefType.equals("Ghost") || DefType.equals("Steel") || DefType.equals("Fire") || DefType.equals("Fairy")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Grass") || DefType.equals("Psychic") || DefType.equals("Dark")) {
					DamageMod*=2.0;
				}
				break;
				
			case "Ghost":
				
				if(DefType.equals("Dark")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Ghost") || DefType.equals("Psychic")) {
					DamageMod*=2.0;
				}
				if (DefType.equals("Normal")) {
					DamageMod*=0;
				} 
				break;
				
			case "Steel":
				
				if(DefType.equals("Steel") || DefType.equals("Fire") || DefType.equals("Water") || DefType.equals("Electric")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Rock") || DefType.equals("Ice") || DefType.equals("Fairy")) {
					DamageMod*=2.0;
				}
				break;
				
			case "Fire":
				
				if(DefType.equals("Rock") || DefType.equals("Fire") || DefType.equals("Water") || DefType.equals("Dragon")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Bug") || DefType.equals("Steel") || DefType.equals("Grass") || DefType.equals("Ice")) {
					DamageMod*=2.0;
				}
				break;
				
			case "Water":
				
				if(DefType.equals("Water") || DefType.equals("Grass") || DefType.equals("Dragon")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Ground") || DefType.equals("Rock") || DefType.equals("Fire")) {
					DamageMod*=2.0;
				}
				break;
				
			case "Grass":
				
				if(DefType.equals("Flying") || DefType.equals("Poison") || DefType.equals("Bug") || DefType.equals("Steel") || DefType.equals("Fire") || DefType.equals("Grass") || DefType.equals("Dragon")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Ground") || DefType.equals("Rock") || DefType.equals("Water")) {
					DamageMod*=2.0;
				}
				break;
				
			case "Electric":
				
				if(DefType.equals("Grass") || DefType.equals("Electric") || DefType.equals("Dragon")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Flying") || DefType.equals("Water")) {
					DamageMod*=2.0;
				}
				if (DefType.equals("Ground")) {
					DamageMod*=0;
				} 
				break;
				
			case "Psychic":
				
				if(DefType.equals("Steel") || DefType.equals("Psychic")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Fight") || DefType.equals("Poison")) {
					DamageMod*=2.0;
				}
				if (DefType.equals("Dark")) {
					DamageMod*=0;
				} 
				break;
				
			case "Ice":
							
				if(DefType.equals("Steel") || DefType.equals("Fire") || DefType.equals("Water") || DefType.equals("Ice")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Flying") || DefType.equals("Ground") || DefType.equals("Grass") || DefType.equals("Dragon")) {
					DamageMod*=2.0;
				}
				break;
				
			case "Dragon":
				
				if(DefType.equals("Steel")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Dragon")) {
					DamageMod*=2.0;
				}
				if (DefType.equals("Fairy")) {
					DamageMod*=0;
				} 
				break;
				
			case "Dark":
				
				if(DefType.equals("Fight") || DefType.equals("Dark") || DefType.equals("Fairy")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Ghost") || DefType.equals("Psychic")) {
					DamageMod*=2.0;
				}
				break;
				
			case "Fairy":
				
				if(DefType.equals("Poison") || DefType.equals("Steel") || DefType.equals("Fire")) {
					DamageMod*=0.5;
				}
				if(DefType.equals("Fight") || DefType.equals("Dragon") || DefType.equals("Dark")) {
					DamageMod*=2.0;
				}
				break;
				
			default:
				//do nothing
				break;			
		}

		return DamageMod;
	}
	
	private class OffActionHandlerClass implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			OffListener();
		}
	}
	
	private class OffChangeHandlerClass implements ChangeListener { 
		public void stateChanged(ChangeEvent arg0) {
			OffListener();
		}
	}
	
	private class DefActionHandlerClass implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			DefListener();
		}
	}
	
	private class DefChangeHandlerClass implements ChangeListener { 
		public void stateChanged(ChangeEvent arg0) {
			DefListener();
		}
	}
	
	
	public void OffListener () {
		
		int[] OffEVs = {Integer.parseInt(Off_HP_EVs.getValue().toString()), Integer.parseInt(Off_Att_EVs.getValue().toString()), Integer.parseInt(Off_Def_EVs.getValue().toString())  , Integer.parseInt(Off_SpA_EVs.getValue().toString())  , Integer.parseInt(Off_SpD_EVs.getValue().toString())  , Integer.parseInt(Off_Spe_EVs.getValue().toString()) };
		int[] OffIVs = {Integer.parseInt(Off_HP_IVs.getValue().toString()), Integer.parseInt(Off_Att_IVs.getValue().toString()), Integer.parseInt(Off_Def_IVs.getValue().toString())  , Integer.parseInt(Off_SpA_IVs.getValue().toString())  , Integer.parseInt(Off_SpD_IVs.getValue().toString())  , Integer.parseInt(Off_Spe_IVs.getValue().toString()) };
		
		int OffLevel = Integer.parseInt(Off_Level.getValue().toString());			
		
		int[] Offbst = {Integer.parseInt(Off_HP_Base.getText()), Integer.parseInt(Off_Att_Base.getText()), Integer.parseInt(Off_Def_Base.getText()), Integer.parseInt(Off_SpA_Base.getText()), Integer.parseInt(Off_SpD_Base.getText()), Integer.parseInt(Off_Spe_Base.getText()) };
		
		String OffNatureName = Off_Nature.getSelectedItem().toString();
    	Nature OffNature = new Nature(OffNatureName);
		
		double[] OffStats = LevelUp (OffLevel, OffIVs, Offbst, OffEVs, OffNature.getNatureMod());
		
		Off_HP.setText(String.valueOf((int)OffStats[0]));
		Off_Att.setText(String.valueOf((int)OffStats[1]));
		Off_Def.setText(String.valueOf((int)OffStats[2]));	
		Off_SpA.setText(String.valueOf((int)OffStats[3]));
		Off_SpD.setText(String.valueOf((int)OffStats[4]));
		Off_Spe.setText(String.valueOf((int)OffStats[5]));
		
	}
	
	
	public void DefListener() {
		
		int[] DefEVs = {Integer.parseInt(Def_HP_EVs.getValue().toString()), Integer.parseInt(Def_Att_EVs.getValue().toString()), Integer.parseInt(Def_Def_EVs.getValue().toString())  , Integer.parseInt(Def_SpA_EVs.getValue().toString())  , Integer.parseInt(Def_SpD_EVs.getValue().toString())  , Integer.parseInt(Def_Spe_EVs.getValue().toString()) };
		int[] DefIVs = {Integer.parseInt(Def_HP_IVs.getValue().toString()), Integer.parseInt(Def_Att_IVs.getValue().toString()), Integer.parseInt(Def_Def_IVs.getValue().toString())  , Integer.parseInt(Def_SpA_IVs.getValue().toString())  , Integer.parseInt(Def_SpD_IVs.getValue().toString())  , Integer.parseInt(Def_Spe_IVs.getValue().toString()) };
		
		int DefLevel = Integer.parseInt(Def_Level.getValue().toString());			
		
		int[] Defbst = {Integer.parseInt(Def_HP_Base.getText()), Integer.parseInt(Def_Att_Base.getText()), Integer.parseInt(Def_Def_Base.getText()), Integer.parseInt(Def_SpA_Base.getText()), Integer.parseInt(Def_SpD_Base.getText()), Integer.parseInt(Def_Spe_Base.getText()) };
		
		String DefNatureName = Def_Nature.getSelectedItem().toString();
    	Nature DefNature = new Nature(DefNatureName);
		
		double[] DefStats = LevelUp (DefLevel, DefIVs, Defbst, DefEVs, DefNature.getNatureMod());
		
		Def_HP.setText(String.valueOf((int)DefStats[0]));
		Def_Att.setText(String.valueOf((int)DefStats[1]));
		Def_Def.setText(String.valueOf((int)DefStats[2]));	
		Def_SpA.setText(String.valueOf((int)DefStats[3]));
		Def_SpD.setText(String.valueOf((int)DefStats[4]));
		Def_Spe.setText(String.valueOf((int)DefStats[5]));
	}
	
	public void OffDefaultSettings () {
		
		Off_HP_Base.setText("--");
		Off_Att_Base.setText("--");
		Off_Def_Base.setText("--");
		Off_SpA_Base.setText("--");
		Off_SpD_Base.setText("--");
		Off_Spe_Base.setText("--");
		
		Off_HP.setText("--");
		Off_Att.setText("--");
		Off_Def.setText("--");
		Off_SpA.setText("--");
		Off_SpD.setText("--");
		Off_Spe.setText("--");
		
		Off_Weight.setText("--");
		
	}
	
	public void DefDefaultSettings () {
		
		Def_HP_Base.setText("--");
		Def_Att_Base.setText("--");
		Def_Def_Base.setText("--");
		Def_SpA_Base.setText("--");
		Def_SpD_Base.setText("--");
		Def_Spe_Base.setText("--");
		
		Def_HP.setText("--");
		Def_Att.setText("--");
		Def_Def.setText("--");
		Def_SpA.setText("--");
		Def_SpD.setText("--");
		Def_Spe.setText("--");
		
		Def_Weight.setText("--");
		
	}
	
	
	public static double SandEndCorrection(String TypeA, String TypeB, double SpD) {
	
		if (TypeB != null) {
			if (TypeA.equals("Rock") || TypeB.equals("Rock")) {
				SpD *= 1.5;
			}
		} else {
			if (TypeA.equals("Rock")) {
				SpD *= 1.5;
			}
		}
		
		return SpD;
	}
	
	public double KO_Percentage(double[] Damage, double Def_HP) {
		
		int counter = 0;
		double KO_Percent;
		
		if (Damage[15] >= Def_HP) {
			for (int i=0; i < Damage.length; i++) {
				if (Damage[i] >= Def_HP) {
					counter += 1;
				}
			}	
			KO_Percent = (counter / 16.0) * 100;
		} else {
			for (int i=0; i < Damage.length; i++) {
				for (int j=0; j < Damage.length; j++) {
					if (Damage[j] + Damage[i] >= Def_HP) {
						counter += 1;
					}
				}
			}
			KO_Percent = (counter / (16.0*16.0)) * 100;
			
		}	
		return KO_Percent;
	}
	
	
	
	public int PowerAdjustAbilities(String AbilityName, String MoveType, char SpecialMod, char Contact, int Power) {
		
		switch(AbilityName) {
		
		case "Blaze(a)":
			if (MoveType.equals("Fire")) {
				Power *= 1.5;
			}
			break;
		case "Flash Fire(a)":
			if (MoveType.equals("Fire")) {
				Power *= 1.5;
			}
			break;
		case "Iron Fist":
			if (SpecialMod == 'P') {
				Power *= 1.2;
			}
			break;
		case "Mega Launcher":
			if (SpecialMod == 'A') {
				Power *=1.5;
			}
			break;
		case "Overgrow(a)":
			if (MoveType.equals("Grass")) {
				Power *= 1.5;
			}
			break;
		case "Reckless":
			if (SpecialMod == 'R') {
				Power *= 1.2;
			}
			break;
		case "Rivalry(SameG)":
			Power *= 1.25;
			break;
			
		case "Rivalry(DifG)":
			Power*=0.75;
			break;
			
		case "Sand Force":
			
			if ((WeatherBox.getSelectedItem().toString() == "Sand") && (MoveType.equals("Rock") || MoveType.equals("Steel") || MoveType.equals("Ground"))) {
				Power *= 1.3;
			}
			break;
		case "Sheer Force":
			Power *= 1.3;
			break;
		case "Strong Jaw":
			if (SpecialMod == 'B') {
				Power*= 1.5;
			}
			break;
		case "Swarm(a)":
			if (MoveType.equals("Bug")) {
				Power *= 1.5;
			}
			break;
		case "Technician":
			if (Power <= 60) {
				Power*=1.5;
			}
			break;
		case "Torrent(a)":
			if (MoveType.equals("Water")) {
				Power *= 1.5;
			}
			break;
			
		case "Tough Claws":
			if (Contact == 'C') {
				Power*= 1.33;
			}
			break;
			
		default:
			//do nothing
			break;
		}
		
		return Power;
	}
	
	
	
	
	public String MoveTypeChangeAbility(String AbilityName, String MoveType) {

		if (AbilityName.equals("Normalize")) {
			MoveType ="Normal";
		}

		return MoveType;
	}
	
	public double AttStatAdjustAbilities(String AbilityName, double Att) {
		
		switch(AbilityName) {
		
		case "Guts(a)": case "Hustle": case "Toxic Boost":
			Att*=1.5;
			break;
		case "Huge Power": case "Pure Power":
			Att*=2;
			break;
		case "Slow Start":
			Att*=0.5;
			break;
		default:
			//Do nothing
			break;
		}
		
		return Att;
	}
	
	public static double DamageAdjustAbilities(String DefAbilityName, String OffAbilityName, double WeakResMod, double Damage, String MoveType, char Category) {
		
		switch(DefAbilityName) {
		
			case "Filter": case "Solid Rock":
				if (WeakResMod >= 2) {
					Damage*=0.75;
				}
				break;
			case "Fur Coat":
				if (Category == 'P' || Category == 'p') {
					Damage*=0.5;
				}
				break;
			case "Heatproof":
				if(MoveType.equals("Fire")) {
					Damage*=0.5;
				}
				break;
			case "Thick Fat":
				if(MoveType.equals("Fire") || MoveType.equals("Ice")) {
					Damage*=0.5;
				}
				break;
			default:
				//do nothing
				break;
		}
	
		if (OffAbilityName.equals("Tinted Lens")) {
			if (WeakResMod < 1) {
				Damage*= 2;
			}
		}
		
		if (OffAbilityName.equals("Paternal Bond")) {
			Damage = Damage + Damage * 0.5;
			
		}
		
		Damage = Math.floor(Damage);
		
		return Damage;
	}
	
	
	private double HeavyMetal (String AbilityName, double Weight) {
		if (AbilityName.equals("Heavy Metal")) {
			Weight *= 2;
		}
		return Weight;
	}
	
	private double MarvelScale (String AbilityName, double Def) {
		if (AbilityName.equals("Marvel Scale")) {
			Def *= 1.5;
		}
		return Def;
	}
	
	private double SolarPower (String AbilityName, double SpA) {
		
		if (AbilityName.equals("Solar Power") || (WeatherBox.getSelectedItem().toString() == "Sun")) {
			SpA*= 1.5;
		}
		return SpA;
	}
	
	private double DarkAura (String OffAbilityName, String DefAbilityName, String MoveType, double Damage) {
		
		if ((OffAbilityName.equals("Dark Aura") || DefAbilityName.equals("Dark Aura")) && MoveType.equals("Dark")) {
			Damage *= 1.33;
			Damage = Math.floor(Damage);
		}
		
		return Damage;
		
	}
	
	private double FairyAura (String OffAbilityName, String DefAbilityName, String MoveType, double Damage) {
		
		if ((OffAbilityName.equals("Fairy Aura") || DefAbilityName.equals("Fairy Aura")) && MoveType.equals("Fairy")) {
			Damage *= 1.33;
			Damage = Math.floor(Damage);
		}
		
		return Damage;
		
	}
	
	
	
	
	public void AllTheCalculations(JComboBox OffPokemon, JComboBox DefPokemon, JLabel OffDamageCalc, JComboBox OffMove, JSpinner OffHitCount, JLabel OWeight, JLabel DWeight, JComboBox OffAbility, JComboBox DefAbility, JLabel OffTypeA, JLabel OffTypeB, JLabel OEvol, JLabel DEvol, JLabel OffMoveContact, JLabel HPbst, JLabel Attbst, JLabel Defbst, JLabel SpAbst, JLabel SpDbst, JLabel Spebst, JLabel OffMoveType, JLabel OffMovePower, JLabel OffMoveCat, JLabel OffMoveSM, JLabel DefTypeA, JLabel DefTypeB , JLabel OffAtt, JLabel OffSpA, JLabel DefDef, JLabel DefSpD, JSpinner OffAttBoost, JSpinner OffSpABoost, JSpinner DefDefBoost, JSpinner DefSpDBoost , JSpinner OffLevel, JComboBox OffItem, JComboBox DefItem , JLabel OffDamCalc, JLabel DefHP, JLabel OffKO) {

		DecimalFormat df =new DecimalFormat("#.##");
		
		if(OffPokemon.getSelectedItem().toString() == "--select Pokemon--"  || DefPokemon.getSelectedItem().toString() == "--select Pokemon--" ) {
			OffDamageCalc.setText("Select a Pokemon.");
			OffDamageCalc.setVisible(true);
		} else if (OffMove.getSelectedItem().toString() == "--select Move--") {
			OffDamageCalc.setText("Select a Move.");
			OffDamageCalc.setVisible(true);
			
			// Easter Eggs
		} else if (Off_Pokemon.getSelectedItem().toString() == "Mega Abomasnow"  &&  Off_Move.getSelectedItem().toString() == "Abomacare" &&  Def_Pokemon.getSelectedItem().toString() == "Mega Abomasnow"  &&  Def_Move.getSelectedItem().toString() == "Abomacare") {
			System.exit(0);	
			
		} else if (Def_Pokemon.getSelectedItem().toString() == "Abomasnow"  &&  OffMove.getSelectedItem().toString() == "Abomacare") {
			JOptionPane.showMessageDialog(null, "Politicians facing attacks cannot enact Abomacare.", "alert", JOptionPane.ERROR_MESSAGE);
			
		} else if (OffPokemon.getSelectedItem().toString() == "Abomasnow"  &&  OffMove.getSelectedItem().toString() == "Abomacare") {
			OffDamageCalc.setText("You healed " + Def_Pokemon.getSelectedItem().toString() + " with Abomacare");
			Def_Damage_Calc.setText("Thanks Aboma.");
			Def_Damage_Calc.setVisible(true);
			OffDamageCalc.setVisible(true);
			
		} else if (OffPokemon.getSelectedItem().toString() == "Mega Abomasnow"  &&  OffMove.getSelectedItem().toString() == "Abomacare") {
			JOptionPane.showMessageDialog(null, "This program almost crashed because it couldn't handle all the Abomacare. I hope you're happy you Socialist.", "alert", JOptionPane.ERROR_MESSAGE);
			
		} else if (OffMove.getSelectedItem().toString() == "Abomacare") {
			JOptionPane.showMessageDialog(null, "Only licensed politicians can use Abomacare.", "alert", JOptionPane.ERROR_MESSAGE);
			
		} else if (OffPokemon.getSelectedItem().toString() == "Diglett" && OffMove.getSelectedItem().toString() == "Dig"){
			OffDamageCalc.setText("Diglett Dig, Diglett Dig");
			OffKO.setText("TRIO TRIO TRIO");
			OffKO.setVisible(true);
			OffDamageCalc.setVisible(true);
			

		} else {
			
			
			int OffBoost;
			int DefBoost;
			double DamageMod = 1;	
			double Defense;
			
			int Strike = (int) OffHitCount.getValue();
			
			double OffWeight = Double.parseDouble(OWeight.getText());
			OffWeight = HeavyMetal (OffAbility.getSelectedItem().toString(), OffWeight);
			double DefWeight = Double.parseDouble(DWeight.getText());
			DefWeight = HeavyMetal (DefAbility.getSelectedItem().toString(), DefWeight);
			
			String OffPokeName = OffPokemon.getSelectedItem().toString();
			String DefPokeName = DefPokemon.getSelectedItem().toString();
			String OffPokeTypeA = OffTypeA.getText();
			String OffPokeTypeB = OffTypeB.getText();

			char OffEvol = OEvol.getText().charAt(0);
			char DefEvol = DEvol.getText().charAt(0);
			char Contact = OffMoveContact.getText().charAt(0);
			
			int[] Off_bst = {Integer.parseInt(HPbst.getText()), Integer.parseInt(Attbst.getText()), Integer.parseInt(Defbst.getText()), Integer.parseInt(SpAbst.getText()), Integer.parseInt(SpDbst.getText()), Integer.parseInt(Spebst.getText()) };
			Pokemon OffPoke = new Pokemon (OffPokeName, OffEvol, OffPokeTypeA, OffPokeTypeB, Off_bst, OffWeight, null);
		
			String MoveName = OffMove.getSelectedItem().toString();
			String MoveType = OffMoveType.getText();
			int Power = Integer.parseInt(OffMovePower.getText());
			char Category = OffMoveCat.getText().charAt(0);
			char SpecialMod = OffMoveSM.getText().charAt(0);
			
			String DefPokeTypeA = DefTypeA.getText();
			String DefPokeTypeB = DefTypeB.getText();
			
			Weather Forecast = new Weather(WeatherBox.getSelectedItem().toString());
			
			
			
			if (MoveName.equals("Solar Beam") && (Forecast.getWeather().equals("Rain")  || Forecast.getWeather().equals("Sand") || Forecast.getWeather().equals("Hail"))) {
				Power = 60;
			}
			
			if (MoveName.equals("Weather Ball") && (Forecast.getWeather().equals("Rain")  || Forecast.getWeather().equals("Sand") || Forecast.getWeather().equals("Hail") || Forecast.getWeather().equals("Sun"))) {
				Power = 100;
				
				if (Forecast.getWeather().equals("Rain")) {
					MoveType = "Water";
				} else if (Forecast.getWeather().equals("Sand")) {
					MoveType = "Rock";
				} else if (Forecast.getWeather().equals("Hail")) {
					MoveType = "Ice";
				} else {
					MoveType = "Fire";
				}

			}
			
			double Att = Double.parseDouble(OffAtt.getText());
			double SpA = Double.parseDouble(OffSpA.getText());
			
			double Def = Double.parseDouble(DefDef.getText());
			double SpD = Double.parseDouble(DefSpD.getText());
	
			if (Category == 'P' || Category == 'p') {
				OffBoost = Integer.parseInt(OffAttBoost.getValue().toString());
			} else {
				OffBoost = Integer.parseInt(OffSpABoost.getValue().toString());
			}
			
			if (Category == 'P' || Category == 's') {
				DefBoost = Integer.parseInt(DefDefBoost.getValue().toString());
				Defense = Def;
			} else {
				DefBoost = Integer.parseInt(DefSpDBoost.getValue().toString());
				Defense = SpD;
			}

			
			int Level = Integer.parseInt(OffLevel.getValue().toString());  
			
			String OffHoldItem = OffItem.getSelectedItem().toString();
			String DefHoldItem = DefItem.getSelectedItem().toString();
			
			if (DefEvol == 'N' && DefHoldItem.equals("Eviolite")) {
				Def*=1.5;
				SpD*=1.5;
			}
			
			Def = MarvelScale (DefAbility.getSelectedItem().toString(), Def);
			SpA = SolarPower (OffAbility.getSelectedItem().toString(), SpA);
						
			
			if (OffAbility.getSelectedItem().toString().equals("Normalize")) {
				MoveType = "Normal";
			}
			
			if (OffAbility.getSelectedItem().toString().equals("Pixelate") && MoveType.equals("Normal")) {
				MoveType = "Fairy";
				Power*=1.3;
			}
			if (OffAbility.getSelectedItem().toString().equals("Refrigerate") && MoveType.equals("Normal")) {
				MoveType = "Ice";
				Power*=1.3;
			}
			if (OffAbility.getSelectedItem().toString().equals("Aerialate") && MoveType.equals("Normal")) {
				MoveType = "Flying";
				Power*=1.3;
			}
			
			if ((DefAbility.getSelectedItem().toString().equals("Dark Aura")  || OffAbility.getSelectedItem().toString().equals("Dark Aura")) && MoveType.equals("Dark")) {
				Power*=1.33;
			}
			
			if ((DefAbility.getSelectedItem().toString().equals("Fairy Aura")  || OffAbility.getSelectedItem().toString().equals("Fairy Aura")) && MoveType.equals("Fairy")) {
				Power*=1.33;
			}
			

			DamageMod = TypeChart(DamageMod, MoveType, DefPokeTypeA);
			if (DefPokeTypeB != null) {
				DamageMod = TypeChart(DamageMod, MoveType, DefPokeTypeB);
			}
			
			
			if (Forecast.getWeather().equals("Sand")) {
				SpD = SandEndCorrection(DefPokeTypeA,DefPokeTypeB, SpD);
			}

			
			Power = PowerAdjustAbilities(OffAbility.getSelectedItem().toString(), MoveType, SpecialMod, Contact, Power);
			Att = AttStatAdjustAbilities(OffAbility.getSelectedItem().toString(),Att);
			
		
			double Damage[] = DamageCalc(Forecast, OffBoost,DefBoost, OffPokeTypeA, OffPokeTypeB, OffWeight, DefWeight, MoveType, Level,  Att, Def, SpA, SpD, Power, DamageMod, Category, OffHoldItem, MoveName, Strike, SpecialMod, OffAbility.getSelectedItem().toString(), DefAbility.getSelectedItem().toString());
			
			double LowPercent = 100* Damage[0] / Double.parseDouble(DefHP.getText());
			double HighPercent = 100* Damage[15] / Double.parseDouble(DefHP.getText());
			
			OffDamCalc.setText(df.format(LowPercent) + "%  -- " + df.format(HighPercent) + "%");
			
			double KO_Rate = KO_Percentage(Damage, Double.parseDouble(DefHP.getText())); 
			
			char KO;
			
			OffKO.setVisible(true);
			if (Damage[15] >= Double.parseDouble(DefHP.getText())) {
				KO = 'O';
				OffKO.setText(df.format(KO_Rate) + "% chance of " + KO + "HKO." );
			} else if ((Damage[15]*2 >= Double.parseDouble(DefHP.getText()))) {
				KO = '2';
				OffKO.setText(df.format(KO_Rate) + "% chance of " + KO + "HKO." );
			} else {
				OffKO.setText("Will not 2HKO." );
			}
		}
	}
}
	
