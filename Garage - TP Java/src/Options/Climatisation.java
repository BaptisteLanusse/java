package Options;

import java.io.Serializable;
import main.Option;

public class Climatisation implements Option, Serializable{
	
	private static final long serialVersionUID = 1009644532698297045L;

	public double GetPrix(){
		return 347.3;
	}
	
	public String toString(){
		return "Climatisation (" + GetPrix() + "€)";
	}
}
