import java.util.ArrayList;
import java.util.List;

class NodoBinario {
    int valor;
    NodoBinario izquierdo;
    NodoBinario derecho;

    public NodoBinario(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class Arbol {
    private NodoBinario raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoBinario insertarRec(NodoBinario actual, int valor) {
        if (actual == null) {
            return new NodoBinario(valor);
        }
        if (valor < actual.valor) {
            actual.izquierdo = insertarRec(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = insertarRec(actual.derecho, valor);
        }
        return actual;
    }

    public void recorridoInorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(NodoBinario nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inordenRec(nodo.derecho);
        }
    }

    public int getAltura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(NodoBinario nodo) {
        if (nodo == null) {
            return -1;
        }
        return 1 + Math.max(calcularAltura(nodo.izquierdo), calcularAltura(nodo.derecho));
    }

    public int contarHojas() {
        return contarHojasRec(raiz);
    }

    private int contarHojasRec(NodoBinario nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.izquierdo == null && nodo.derecho == null) {
            return 1;
        }
        return contarHojasRec(nodo.izquierdo) + contarHojasRec(nodo.derecho);
    }

    public void mostrarJerarquia() {
        imprimirEstructura(raiz, "", true);
    }

    private void imprimirEstructura(NodoBinario nodo, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.valor);
            List<NodoBinario> hijos = new ArrayList<>();
            if (nodo.izquierdo != null) hijos.add(nodo.izquierdo);
            if (nodo.derecho != null) hijos.add(nodo.derecho);

            for (int i = 0; i < hijos.size(); i++) {
                imprimirEstructura(hijos.get(i), prefijo + (esUltimo ? "    " : "│   "), i == hijos.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        int[] datos = {50, 30, 70, 20, 40, 60, 80};

        for (int d : datos) {
            arbol.insertar(d);
        }

        System.out.println("Recorrido Inorden:");
        arbol.recorridoInorden();

        System.out.println("\nRepresentación Visual:");
        arbol.mostrarJerarquia();

        System.out.println("\nPropiedades:");
        System.out.println("Altura del árbol: " + arbol.getAltura());
        System.out.println("Cantidad de hojas: " + arbol.contarHojas());
    }
}