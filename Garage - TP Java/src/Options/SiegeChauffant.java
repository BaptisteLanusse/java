package Options;

import java.io.Serializable;
import main.Option;

public class SiegeChauffant implements Option, Serializable {
	
	private static final long serialVersionUID = 7397747736164767633L;

	public double GetPrix(){
		return 562.9;
	}
	
	public String toString(){
		return "Siège chauffant (" + GetPrix() + "€)";
	}
}
