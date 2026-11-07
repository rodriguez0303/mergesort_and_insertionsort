import java.util.Arrays;

/**
 * Demostración del algoritmo Insertion Sort (ordenamiento por inserción).
 *
 * Versión clásica, sin optimizaciones: compara con los elementos de la
 * izquierda y desplaza los que sean mayores para insertar la clave.
 *
 * Complejidad temporal:
 *   - Mejor caso: O(n), cuando el arreglo ya está ordenado.
 *   - Caso promedio: O(n^2).
 *   - Peor caso: O(n^2), cuando está ordenado al revés.
 * Memoria adicional: O(1), porque ordena el arreglo original.
 */
public class InsertionSort {

    /**
     * Ordena de menor a mayor el arreglo recibido.
     * No crea otro arreglo y no utiliza Arrays.sort().
     *
     * @param arreglo arreglo de números enteros que se desea ordenar
     */
    public static void insertionSort(int[] arreglo) {
        // Comenzamos en 1: un único elemento (posición 0) ya está ordenado.
        for (int i = 1; i < arreglo.length; i++) {

            // La "clave" es el valor que queremos insertar en la parte ordenada.
            int clave = arreglo[i];

            // j señala el elemento inmediatamente a la izquierda de la clave.
            int j = i - 1;

            // Mientras no lleguemos al inicio y haya un valor mayor que
            // la clave, desplazamos ese valor una posición hacia la derecha.
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j--; // Continuamos comparando con el elemento anterior.
            }

            // Insertamos la clave en el espacio que quedó libre.
            // Si ningún valor era mayor, la clave permanece en su posición.
            arreglo[j + 1] = clave;
        }
    }

    /** Punto de entrada: permite ejecutar y comprobar el algoritmo. */
    public static void main(String[] args) {
        // Usamos los mismos ocho números del ejemplo de la presentación.
        int[] numeros = {14, 7, 3, 12, 9, 11, 6, 2};

        // Mostramos el orden original antes de hacer cualquier cambio.
        System.out.println("Antes:   " + Arrays.toString(numeros));

        // El método modifica directamente el arreglo "numeros".
        insertionSort(numeros);

        // Comprobamos que todos los números quedaron en orden ascendente.
        System.out.println("Despues: " + Arrays.toString(numeros));
    }
}
