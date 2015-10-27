package Options;

import java.io.Serializable;
import main.Option;

public class VitreElectrique implements Option, Serializable {
	
	private static final long serialVersionUID = 3705409493572219913L;

	public double GetPrix(){
		return 212.35;
	}
	
	public String toString(){
		return "Vitre electrique (" + GetPrix() + "€)";
	}
}
