public class Pila{
    private int tope;
    private char[] elementos;

    public Pila() {
        this.tope = -1; 
        this.elementos = new char[5]; // Tamaño de la pila
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == elementos.length - 1;
    }

    public void empujar(char elemento) {
        if (!estaLlena()) {
            elementos[++tope] = elemento;
        } else {
            System.out.println("La pila está llena. No se puede agregar el elemento.");
        }
    }

    public char sacar() {
        if (!estaVacia()) {
            return elementos[tope--];
        } else {
            System.out.println("La pila está vacía.");
            return 0; 
        }
    }

}
