import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws GastoException {

		Scanner sc = new Scanner(System.in);

		Usuario nuevoUsuario = creaUsuario(sc);

		Cuenta nuevaCuenta = new Cuenta(nuevoUsuario);

		int opcion = visuMenu(sc);
		String descripcion = "";
		double importe;

		do {

			switch (opcion) {
			case 1:
				System.out.println("Introduce la descripción");
				descripcion = sc.nextLine();
				System.out.println("Introduce el importe");
				importe = sc.nextDouble();
				sc.nextLine();
				if (nuevaCuenta.getSaldo() < importe) {
					System.out.println("Debe realizar un ingreso previamente");
				} else {
					double saldo = nuevaCuenta.addGastos(descripcion, importe);
					System.out.println("Saldo restante: " + saldo + "€");
				}
				break;
			case 2:
				System.out.println("Introduce la descripción");
				descripcion = sc.nextLine();
				System.out.println("Introduce el importe");
				importe = sc.nextDouble();
				sc.nextLine();
				double saldo = nuevaCuenta.addIngresos(descripcion, importe);
				System.out.println("Saldo restante: " + saldo + "€");
				break;
			case 3:
				for (Gasto gasto : nuevaCuenta.getGastos()) {
					System.out.println(gasto.toString());
				}
				break;
			case 4:
				for (Ingreso ingreso : nuevaCuenta.getIngresos()) {
					System.out.println(ingreso.toString());
				}
				break;
			case 5:
				System.out.println(nuevaCuenta.toString());
				break;

			}
			opcion = visuMenu(sc);
		} while (opcion != 0);
		
		System.out.println("Fin del programa.\nGracias por utilizar la aplicación.");

	}

	private static Usuario creaUsuario(Scanner sc) {
		Usuario nuevoUsuario = new Usuario();
		String nuevoNombre = "";
		int nuevoEdad;
		String nuevoDNI;

		System.out.println("Introduce el nombre del usuario");
		nuevoNombre = sc.nextLine();
		nuevoUsuario.setNombre(nuevoNombre);

		System.out.println("Introduce la edad del usuario");
		nuevoEdad = sc.nextInt();
		sc.nextLine();
		nuevoUsuario.setEdad(nuevoEdad);

		do {
			System.out.println("Introduce el DNI del usuario");
			nuevoDNI = sc.nextLine();

			if (nuevoUsuario.setDNI(nuevoDNI)) {
				nuevoUsuario.setDNI(nuevoDNI);
			} else {
				System.out.println("DNI introducido incorrecto");
			}
		} while (nuevoUsuario.setDNI(nuevoDNI) == false);
		return nuevoUsuario;

	}

	private static int visuMenu(Scanner sc) {
		Integer opcion = null;

		do {
			if (opcion != null && (opcion < 0 || opcion > 5))
				System.out.println("Debe introducir un valor entre 0 y 5");
			System.out.println("Realiza una nueva acción \n1 Introduce un nuevo gasto\n2 Introduce un nuevo ingreso\n3 "
					+ "Mostrar gastos\n4 Mostrar ingresos\n5 Mostrar saldo\n0 Salir");

			opcion = sc.nextInt();
			sc.nextLine();

		} while (opcion == null || opcion < 0 || opcion > 5);
		return opcion;
	}

}
