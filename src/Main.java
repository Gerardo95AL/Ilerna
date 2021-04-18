//Importar la libreria Scanner de java util.
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Definición de variables a utilizar a posteriori
        Scanner sc = new Scanner(System.in);
        //Creación del usuario con el metodo creaUsuario.
        Usuario nuevoUsuario = creaUsuario(sc);
        //Inicialización de la cuenta.
        Cuenta nuevaCuenta = new Cuenta(nuevoUsuario);
        //Iniciamos la variable opcion con el valor que se obtenga del metodo visuMenu. Se muestra por pantalla el menú para el usuario
        int opcion = visuMenu(sc);
        String descripcion = "";
        double importe;


        //Con la estructura switch se ejecuta una opción u otra dependiendo de la opción elejida por el usuario.
        do {

            switch (opcion) {
                //Si elige la opción 1, se registra un gasto pidiendo al usuario la descripción y el importe.
                case 1:
                    System.out.println("Introduce la descripción");
                    descripcion = sc.nextLine();
                    System.out.println("Introduce el importe");
                    importe = sc.nextDouble();
                    sc.nextLine();
                    try {
                        //Se registra el gasto
                        double saldo = nuevaCuenta.addGastos(descripcion, importe);
                        System.out.println("Saldo restante: " + saldo + "€");
                        //Si el valor del gasto es mayo que el saldo, salta la excepción GastoException mostrando por pantalla el error.
                    } catch (GastoException e) {
                        System.out.println(e);

                    }
            break;
            case 2:
                //Si elige la opción 2, se registra un ingreso sumando al saldo el importe.
                System.out.println("Introduce la descripción");
                descripcion = sc.nextLine();
                System.out.println("Introduce el importe");
                importe = sc.nextDouble();
                sc.nextLine();
                double saldo = nuevaCuenta.addIngresos(descripcion, importe);
                System.out.println("Saldo restante: " + saldo + "€");
                break;
            case 3:
                //Si se elige la opción 3. Con un for each se recorre el Array Gasto y con el toString se muestra el contenido del array.
                for (Gasto gasto : nuevaCuenta.getGastos()) {
                    System.out.println(gasto.toString());
                }
                break;
            case 4:
                //Si se elige la opción 4. Con un for each se recorre el Array Ingreso y con el toString se muestra el contenido del array.
                for (Ingreso ingreso : nuevaCuenta.getIngresos()) {
                    System.out.println(ingreso.toString());
                }
                break;
            case 5:
                //Si elige la opción 5. Con el metodo toString de la clase Cuenta se muestra el contenido de la cuenta.
                System.out.println(nuevaCuenta.toString());
                break;

        }
        //Se vuelve a mostrar el menú para que el usuario elija otra opción.
        opcion = visuMenu(sc);
            //En caso de elegir la opción 0, sale del programa mostrando el mensaje "Fin del programa. Gracias por utilizar la aplicación"
    } while(opcion !=0);

		System.out.println("Fin del programa.\nGracias por utilizar la aplicación.");

}
    //Metodo craUsuario pasandole el objeto sc de la clase Scanner para poder utilizarlo. Metodo para la creación del usuario y la asignación de valores a nombre, edad y DNI.
    private static Usuario creaUsuario(Scanner sc) {

        //Se creal el usuario nuevoUsuario.
        Usuario nuevoUsuario = new Usuario();
        //Definicion de las variables para el metodo creaUsuario
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
        //Mediante el bucle do while, se pide el DNI al usuario y se verifica que sea correcto. En caso de que el metodo setDNI devuelva un true, se settea el DNI, si devuelve un false, vuelve a solicitar el DNI al usuario.
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
    //Metodo visuMenu pansadole el objeto sc de la clase Scanner. Se setea la variable opción a null para que entre en el do while y siempre que opcion sea menor que 0 o mayor que 5, vuelve a mostrar el menú al usuario.
    private static int visuMenu(Scanner sc) {
        Integer opcion = null;

        do {
            if (opcion != null && (opcion < 0 || opcion > 5))
                System.out.println("Debe introducir un valor entre 0 y 5");
            System.out.println("Realiza una nueva acción \n1 Introduce un nuevo gasto\n2 Introduce un nuevo ingreso\n3 "
                    + "Mostrar gastos\n4 Mostrar ingresos\n5 Mostrar saldo\n0 Salir");

            opcion = sc.nextInt();
            sc.nextLine();
        //Cuando opcion sea null o tenga un valor mayor que 0 y menor que 5, deuvleva la variable opcion que se va a evaluar en el switch.
        } while (opcion == null || opcion < 0 || opcion > 5);
        return opcion;
    }

}