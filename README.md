# Act-10-
# Implementación de Estrcutura No Lineal: Árbol Binario de Búsqueda (ABB)

## Clasificación y Justificación
Los árboles se clasifican según su grado y estructura en:
- **Árboles Generales:** Cada nodo puede tener un número indeterminado de hijos.
- **Árboles Binarios:** Cada nodo tiene como máximo dos hijos (izquierdo y derecho).
- **Árbol Búsqueda Binario (ABB):** Mantienen una propiedad de orden estricto donde los valores menores al nodo actual se ubican a la izquierda y los mayores a la derecha.
- **Árboles Auto-balanceados (AVL / Rojo-Negro):** Variantes de ABB que reestructuran sus alturas automáticamente para garantizar búsquedas en tiempo O(log n).

Se eligió implementar un **Árbol Binario de Búsqueda (ABB)** porque proporciona un balance óptimo entre complejidad sintáctica y eficiencia en operaciones fundamentales como la inserción y la búsqueda organizada de datos.

## Métodos Implementados
- `insertar(int valor)`: Mantiene la propiedad de ordenamiento del ABB.
- `recorridoInorden()`: Muestra los elementos en orden ascendente.
- `getAltura()`: Retorna la altura máxima calculada desde la raíz.
- `contarHojas()`: Cuenta los nodos que carecen de descendientes.
- `mostrarJerarquia()`: Dibuja la estructura jerárquica en consola usando caracteres ASCII.

## Ejecución
```bash
javac Arbol.java
java Arbol