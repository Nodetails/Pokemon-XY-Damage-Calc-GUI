import java.math.*;

public class Weather {

	private String WeatherName;
	private String Type;
	
	
	public Weather(String WeatherName) {
		this.WeatherName = WeatherName;	
	}
	
	public String getWeather() {
		return WeatherName;
	}
	
	public int SunRainAttMod(String MoveType, int MovePower) {
		
		switch(WeatherName) {
			case "Sun":
				if (MoveType.equals("Fire")) {
					MovePower *= 1.5;
				}
				if (MoveType.equals("Water")) {
					MovePower /= 2;
				}
				break;
			case "Rain":
				if (MoveType.equals("Water")) {
					MovePower *= 1.5;
				}
				if (MoveType.equals("Fire")) {
					MovePower /= 2;
				}
				break;
		}
		return MovePower;
	}
	
	public double SandRockCorrection (double SpD) {
		
		SpD *= 1.5;
		
		return SpD;
		
	}
	
	public int SolarBeamCorrection (int MovePower) {
		
		if (WeatherName.equals("Rain") || WeatherName.equals("Sand") || WeatherName.equals("Hail")) {
			MovePower *= 0.5;
		}
		
		return MovePower;
	}
	
	public int WeatherBallPowerCorrection (int MovePower) {
		
		if (WeatherName.equals("Rain") || WeatherName.equals("Sand") || WeatherName.equals("Hail") || WeatherName.equals("Sun")) {
			MovePower *= 2;
		}
		
		return MovePower;
	}
	
	public String WeatherBallTypeCorrection () {
		
		switch (WeatherName){
			case "Sun":
				Type = "Fire";
				break;
			case "Rain":
				Type = "Water";
				break;
			case "Hail":
				Type = "Ice";
				break;
			case "Sand":
				Type = "Rock";
				break;
			default:
				//do nothing
				break;
		}	
		return Type;
	}
	
}
