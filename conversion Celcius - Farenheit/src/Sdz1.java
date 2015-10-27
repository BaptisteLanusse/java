import java.util.Scanner;


public class Sdz1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("CONVERTISSEUR DEGRÉS CELSIUS ET DEGRÉS FAHRENHEIT");
		System.out.println("-------------------------------------------------");
		
		String veutContinuer = "O";
		while (veutContinuer.equals("O") || veutContinuer.equals("o")) {
			
			System.out.println("Choisissez le mode de conversion :");
			System.out.println("1 - Convertisseur Celsius - Fahrenheit");
			System.out.println("2 - Convertisseur Fahrenheit - Celsius");
			String typeConversion = sc.nextLine();
			
			while(!typeConversion.equals("1") && !typeConversion.equals("2")){
				System.out.println("Veuillez rechoisir le mode de conversion");
				typeConversion = sc.nextLine();
			}
			
			System.out.println("Veuillez entrer la température à convertir");
			
			double temperatureBase = 0.0d;
			while(true) {
				try {temperatureBase = Double.parseDouble(sc.nextLine());
					
					break;
				} catch(NumberFormatException nfe) {
					System.out.println("Veuillez entrer une température à convertir correcte");
				}
			}
			
			double temperatureFin = 0.0d;
			
			if (typeConversion.equals("1")) {
				temperatureFin = CtoF(temperatureBase);
				System.out.println(arrondi(temperatureBase, 1) + " °C correspond à : " + arrondi(temperatureFin, 1) + " °F.");
			} else {
				temperatureFin = FtoC(temperatureBase);
				System.out.println(arrondi(temperatureBase, 1) + " °F correspond à : " + arrondi(temperatureFin, 1) + " °C.");
			}
			
			System.out.println("Souhaitez-vous convertir une autre température ?(O/N)");
			veutContinuer = sc.nextLine();
			
			while (!veutContinuer.equals("O") && !veutContinuer.equals("o") && !veutContinuer.equals("N") && !veutContinuer.equals("n"))
			{
				System.out.println("Veuillez saisir une valeur correcte (O/N)");
				veutContinuer = sc.nextLine();
			}
			
		}
		
		System.out.println("Au revoir!");
		
	}
	
	public static double CtoF(double base) {
		return ((9.0d / 5.0d) * base) + 32.0d;
	}
	
	public static double FtoC(double base) {
		return (base - 32.0d) * (5.0d / 9.0d);
	}
	
	public static double arrondi(double A, int B) {
		return (double) ((int) (A * Math.pow(10, B) + .5)) / Math.pow(10,B);
	}

}
