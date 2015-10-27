package Options;

import java.io.Serializable;
import main.Option;

public class BarreDeToit implements Option, Serializable{
	
	private static final long serialVersionUID = 6661868418276762304L;

	public double GetPrix(){
		return 29.9;
	}
	
	public String toString(){
		return "Barre de toit (" + GetPrix() + "€)";
	}
	
}
