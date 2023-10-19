import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pila pila = new Pila();
        String opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Introducir expresión");
            System.out.println("2. Mostrar");
            System.out.println("3. Créditos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    pila.introducirExpresion(scanner);
                    break;
                case "2":
                    pila.mostrar();
                    break;
                case "3":
                    creditos();
                    break;
                case "4":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!opcion.equals("4"));

        scanner.close();
    }


    public static void creditos() {
        System.out.println("Nombre de la materia: estructura de datos");
        System.out.println("ANTHONY FUENTES CARRERA 22170187");
        System.out.println("ABRAHAM ALONSO REYNOSO 22170060");
        System.out.println("CARLOS GABRIEL ROMERO 22170145");
    }
}
