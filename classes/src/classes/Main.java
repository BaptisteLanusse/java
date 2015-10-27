package classes;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Vehicule.nombreVehicules);
		Vehicule v1 = new Vehicule();
		System.out.println(Vehicule.nombreVehicules);
		System.out.println(v1.nombreVehicules);
		Vehicule v2 = new Vehicule();
		System.out.println(Vehicule.nombreVehicules);
		System.out.println(v1.nombreVehicules);
		System.out.println(v2.nombreVehicules);
	}

}
