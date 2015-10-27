package Options;

import java.io.Serializable;
import main.Option;

public class GPS implements Option, Serializable {
	
	private static final long serialVersionUID = -7625220820311364473L;

	public double GetPrix(){
		return 113.5;
	}
	
	public String toString(){
		return "GPS (" + GetPrix() + "€)";
	}
}
