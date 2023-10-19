import java.util.Scanner;

public class Pila {
    private int tope;
    private Character[] elementos;

    public String ultimaExpresion = "";
    public String ultimaConversion = "";

    Main nuevo = new Main();

    public Pila() {
        this.tope = -1;
        this.elementos = new Character[10];
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == elementos.length - 1;
    }

    public void empujar(Character elemento) {
        if (!estaLlena()) {
            elementos[++tope] = elemento;
        } else {
            System.out.println("La pila está llena. No se puede agregar el elemento.");
        }
    }

        public void introducirExpresion(Scanner scanner) {
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

    public String convertirInfijaAPosfija(String infija) {
        String posfija = "";
        for (int i = 0; i < infija.length(); ++i) {
            char caracter = infija.charAt(i);

            if (Character.isLetterOrDigit(caracter)) {
                posfija += caracter;
            } else if (caracter == '(') {
                empujar(caracter);
            } else if (caracter == ')') {
                while (!estaVacia() && mirar() != '(') {
                    posfija += sacar();
                }
                if (!estaVacia() && mirar() != '(') {
                    return "Expresión infija inválida"; 
                } else {
                    sacar();
                }
            } else { 
                while (!estaVacia() && precedencia(caracter) <= precedencia(mirar())) {
                    posfija += sacar();
                }
                empujar(caracter);
            }
        }

        while (!estaVacia()) {
            posfija += sacar();
        }

        return posfija;
    }

    public static int precedencia(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public Character sacar() {
        if (!estaVacia()) {
            return elementos[tope--];
        } else {
            return null;
        }
    }

    public Character mirar() {
        if (!estaVacia()) {
            return elementos[tope];
        } else {
            return null;
        }
    }

    public void mostrar() {
        System.out.println("Última expresión Infija: " + ultimaExpresion);
        System.out.println("Su conversión a Posfija: " + ultimaConversion);
    }

    
}
