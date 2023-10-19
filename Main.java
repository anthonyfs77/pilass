import java.util.Scanner;

public class Main {
    private static Pila pila = new Pila();
    private static String ultimaExpresion = "";
    private static String ultimaConversion = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    introducirExpresion(scanner);
                    break;
                case "2":
                    mostrar();
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

    public static void introducirExpresion(Scanner scanner) {
        System.out.print("Introduzca la expresión en notación infija: ");
        String expresion = scanner.nextLine();

        if (expresion.length() <= 50) {
            ultimaExpresion = expresion;

            ultimaConversion = convertirInfijaAPosfija(expresion);
            System.out.println("Resultado de la conversión: " + ultimaConversion);
        } else {
            System.out.println("La expresión no puede superar los 50 caracteres.");
        }
    }

    public static String convertirInfijaAPosfija(String infija) {
        return "Expresión posfija aquí";
    }

    public static void mostrar() {
        System.out.println("Última expresión Infija: " + ultimaExpresion);
        System.out.println("Su conversión a Posfija: " + ultimaConversion);
    }

    public static void creditos() {
        System.out.println("Nombre de la materia: estructura de datos");
        System.out.println("ANTHONY FUENTES CARRERA 2217017");
        System.out.println("ABRAHAM ALONSO REYNOSO ");
        System.out.println("CARLOS GABRIEL ROMERO");
    }
}
