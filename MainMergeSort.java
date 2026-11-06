
import java.util.Arrays;

public class MainMergeSort {

    // Este método divide el arreglo en subarreglos más pequeños.

    // Arreglo original: [8, 3, 5, 1, 9, 2, 7, 4, 6]
            //Recibe el arreglo, posición inicial del arreglo, posición final
    // Primera llamada: mergeSort(arreglo, 0, 8)
    public static void mergeSort(int[] arreglo, int izquierda, int derecha) {

        // EXPLICACIÓN:
        // Verifica si el subarreglo tiene más de un elemento.

        // PRUEBA MANUAL:
        // izquierda = 0
        // derecha = 8
        // ¿0 < 8? Sí.
        // Como el indice izquierdo es menor al derecho , entra al if.
        if (izquierda < derecha) {

            // Se calcula el índice central del subarreglo.
            // medio = 0 + (8 - 0) / 2
            // medio = 4

            // Se toman los elementos desde el índice 0 hasta el índice 4
                // para formar la mitad izquierda.
                // Los elementos restantes forman la mitad derecha.

            // Índices:   0  1  2  3  4 | 5  6  7  8
            // Valores:  [8, 3, 5, 1, 9 | 2, 7, 4, 6]

            // Mitad izquierda: [8, 3, 5, 1, 9]
            // Mitad derecha:   [2, 7, 4, 6]
            int medio = izquierda + (derecha - izquierda) / 2;

            // Se divide y ordena recursivamente la mitad izquierda.

            // Primera llamada: mergeSort(arreglo, 0, 4)

            // [8, 3, 5, 1, 9]

            // Se divide en:
            // [8, 3, 5] y [1, 9]

            // Después:
            // [8, 3, 5] -> [8, 3] y [5]
            // [8, 3] -> [8] y [3]
            // [1, 9] -> [1] y [9]

            // Después de las combinaciones se ordenan:
            // [1, 3, 5, 8, 9]
            mergeSort(arreglo, izquierda, medio);

            //*********************************
            //*********************************

            // Se Divide y ordena recursivamente la mitad derecha.


            // Primera llamada: mergeSort(arreglo, 5, 8)

            // [2, 7, 4, 6]
            // Se divide en:
            // [2, 7] y [4, 6]

            // Después:
            // [2, 7] -> [2] y [7]
            // [4, 6] -> [4] y [6]

            // Después se ordenan los valores:
            // [2, 4, 6, 7]
            mergeSort(arreglo, medio + 1, derecha);

            //*********************************
            //*********************************

            // Combinación de las dos mitades previamente ordenadas.

            // Mitad izquierda: [1, 3, 5, 8, 9]
            // Mitad derecha:   [2, 4, 6, 7]

            // Resultado:
            // [1, 2, 3, 4, 5, 6, 7, 8, 9]
            merge(arreglo, izquierda, medio, derecha);
        }
    }

    // Se combina dos subarreglos que ya están ordenados.
    // [1, 3, 5, 8, 9] + [2, 4, 6, 7]

    // izquierda = 0
    // medio = 4
    // derecha = 8
    public static void merge(int[] arreglo, int izquierda, int medio, int derecha) {

        // Se Calcula el tamaño del subarreglo izquierdo.

        // n1 = 4 - 0 + 1
        // n1 = 5
        int n1 = medio - izquierda + 1;

        // EXPLICACIÓN:
        // Calcula el tamaño del subarreglo derecho.

        // n2 = 8 - 4
        // n2 = 4
        int n2 = derecha - medio;

        // Se crea un arreglo temporal para la mitad izquierda.

        // n1 = 5
        // izquierdo = [0, 0, 0, 0, 0]
        int[] izquierdo = new int[n1];

        // Se crea un arreglo temporal para la mitad derecha.

        // n2 = 4
        // derecho = [0, 0, 0, 0]
        int[] derecho = new int[n2];

        // Se Copia los elementos de la mitad izquierda.
        // i = 0 -> izquierdo[0] = arreglo[0] = 1
        // i = 1 -> izquierdo[1] = arreglo[1] = 3
        // i = 2 -> izquierdo[2] = arreglo[2] = 5
        // i = 3 -> izquierdo[3] = arreglo[3] = 8
        // i = 4 -> izquierdo[4] = arreglo[4] = 9
        //
        // Resultado: [1, 3, 5, 8, 9]
        for (int i = 0; i < n1; i++) {
            izquierdo[i] = arreglo[izquierda + i];
        }

        // Se copia los elementos de la mitad derecha.
        // j = 0 -> derecho[0] = arreglo[5] = 2
        // j = 1 -> derecho[1] = arreglo[6] = 4
        // j = 2 -> derecho[2] = arreglo[7] = 6
        // j = 3 -> derecho[3] = arreglo[8] = 7

        // Resultado: [2, 4, 6, 7]
        for (int j = 0; j < n2; j++) {
            derecho[j] = arreglo[medio + 1 + j];
        }

        // i recorre el subarreglo izquierdo
        // i = 0, apunta al valor 1.
        int i = 0;

        // j recorre el subarreglo derecho.
        //
        // PRUEBA MANUAL:
        // j = 0, apunta al valor 2.
        int j = 0;


        // k indica la posición del arreglo original donde se copiará el siguiente elemento.
        // k = izquierda = 0.
        int k = izquierda;

        // Se Compara elementos mientras ambos subarreglos tengan valores disponibles.

        // Comparaciones de la combinación final:
        //
        // 1 <= 2 -> copia 1
        // 3 <= 2 -> falso, copia 2
        // 3 <= 4 -> copia 3
        // 5 <= 4 -> falso, copia 4
        // 5 <= 6 -> copia 5
        // 8 <= 6 -> falso, copia 6
        // 8 <= 7 -> falso, copia 7
        //
        // En este momento j = 4.

        // El subarreglo derecho se terminó.
        while (i < n1 && j < n2) {

            // Se compara los valores actuales.
            // izquierdo[0] = 1
            // derecho[0] = 2
            // ¿1 <= 2? Sí.
            if (izquierdo[i] <= derecho[j]) {

                // Copia el elemento izquierdo.
                // arreglo[0] = 1
                arreglo[k] = izquierdo[i];

                // Se Avanza al siguiente elemento izquierdo.
                i++;

            } else {


            // Se copia el elemento del arreglo derecho porque es menor que el elemento del arreglo izquierdo.

            // izquierdo[1] = 3
            // derecho[0] = 2

            // Como 3 <= 2 es falso, entra al else.
            // Se copia el número 2 en la posición 1 del arreglo original.
                arreglo[k] = derecho[j];

                // Se avanza al siguiente elemento derecho
                j++;
            }

            // Se avanza a la siguiente posición del arreglo original.
            k++;
        }

        // Se Copia los elementos restantes del subarreglo izquierdo.
        //
        // PRUEBA MANUAL:
        // Quedan los valores 8 y 9.
        //
        // arreglo[7] = 8
        // arreglo[8] = 9
        while (i < n1) {
            arreglo[k] = izquierdo[i];
            i++;
            k++;
        }


        // Se copia los elementos restantes del subarreglo derecho

        // En la combinación final:
        // j = 4 y n2 = 4.
        // ¿4 < 4? No.

        // Por eso este while no se ejecuta en esta combinación.
        while (j < n2) {
            arreglo[k] = derecho[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        // Se Crea el arreglo con los nueve valores.
        // Índices: 0  1  2  3  4  5  6  7  8
        // Valores: 8  3  5  1  9  2  7  4  6
        int[] arreglo = {8, 3, 5, 1, 9, 2, 7, 4, 6};

        // Muestra el arreglo original.
        System.out.println("Arreglo original: " + Arrays.toString(arreglo));


        // Se ejecuta Merge Sort desde el primer índice hasta el último índice del arreglo.

        // arreglo.length = 9
        // arreglo.length - 1 = 8

        // mergeSort(arreglo, 0, 8)
        mergeSort(arreglo, 0, arreglo.length - 1);

        // Se muestra el arreglo después del ordenamiento.

        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
    }
}
