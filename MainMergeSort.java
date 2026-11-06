
import java.util.Arrays;

public class MainMergeSort {

    // Método que divide el arreglo en subarreglos más pequeños.

    // Arreglo original: [8, 3, 5, 1, 9, 2, 7, 4, 6]
            //Recibe el [arreglo, posición inicial del arreglo, posición final]
    // Primera llamada: mergeSort(arreglo, 0, 8)
    public static void mergeSort(int[] arreglo, int izquierda, int derecha) {

        // Se Verifica si el subarreglo tiene más de un elemento.

        // izquierda = 0
        // derecha = 8
        // ¿0 < 8? Sí.
        // Como el indice izquierdo es menor al derecho, entra al if.
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

            // Luego de esa sub-división de los nodos  [8, 3, 5, 1, 9], se vuelve a realizar otra
            // los elementos desde el índice 0 hasta el 2 forman la mitad izquierda.
            // y los elementos desde el índice 3 hasta el 4 forman la mitad derecha.

            // Mitad izquierda: [8, 3, 5]
            // Mitad derecha: [1, 9]

            // Después se sigue dividiendo hasta tener elementos individuales:
            // [8, 3, 5] -> [8, 3] y [5]
            // [8, 3] -> [8] y [3]
            // [1, 9] -> [1] y [9]

            // Después  se ordenan:
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
            // Mitad derecha:[2, 4, 6, 7]

            // Resultado:
            // [1, 2, 3, 4, 5, 6, 7, 8, 9]
            merge(arreglo, izquierda, medio, derecha);
        }
    }

    //******************************************************************
    //******************************************************************

    // Método que  combina dos subarreglos que ya están ordenados.
    // [1, 3, 5, 8, 9] + [2, 4, 6, 7]

    // izquierda = 0 (posición inicial del arreglo)
    // medio = 4 (última posición de la mitad izquierda)
    // derecha = 8 8 (última posición de la mitad derecha)
    public static void merge(int[] arreglo, int izquierda, int medio, int derecha) {

        // Se Calcula el tamaño del subarreglo izquierdo.
            // Se suma 1 porque se incluyen las posiciones 0, 1, 2, 3 y 4.
                // n1 = 4 - 0 + 1 = 5 (medio - izquierda + 1)
        int n1 = medio - izquierda + 1;


        // Se Calcula el tamaño del subarreglo derecho.
            // Corresponde a las posiciones 5, 6, 7 y 8.
                // n2 = 8 - 4 = 4
        int n2 = derecha - medio;

        // Se crea un arreglo temporal para la mitad izquierda.
            // n1 = 5
                // izquierdo = [0, 0, 0, 0, 0]
        int[] izquierdo = new int[n1];

        // Se crea un arreglo temporal para la mitad derecha.
            // n2 = 4
                // derecho = [0, 0, 0, 0]
        int[] derecho = new int[n2];

        //**************
        //Este for solamente copia los elementos del arreglo original al arreglo temporal izquierdo[]. No compara los valores entre sí ni los ordena.
        // Resultado: [1, 3, 5, 8, 9]
        // i = 0 -> izquierdo[0] = arreglo[0] = 1
        // i = 1 -> izquierdo[1] = arreglo[1] = 3
        // i = 2 -> izquierdo[2] = arreglo[2] = 5
        // i = 3 -> izquierdo[3] = arreglo[3] = 8
        // i = 4 -> izquierdo[4] = arreglo[4] = 9

        for (int i = 0; i < n1; i++) {
            izquierdo[i] = arreglo[izquierda + i];
        }

        //**************
        //Este for solamente copia los elementos del arreglo original al arreglo temporal derecho []. No compara los valores entre sí ni los ordena.
        // Se copia los elementos de la mitad derecha.
        // j = 0 -> derecho[0] = arreglo[5] = 2
        // j = 1 -> derecho[1] = arreglo[6] = 4
        // j = 2 -> derecho[2] = arreglo[7] = 6
        // j = 3 -> derecho[3] = arreglo[8] = 7

        // Resultado: [2, 4, 6, 7]
        for (int j = 0; j < n2; j++) {
            derecho[j] = arreglo[medio + 1 + j];
        }

        //**********************
        // Aunque el arreglo original se dividió en dos subarreglos,
            // al momento de unirlos SE DEBEN COMPARAR SUS ELEMENTOS
                // para colocarlos en orden, sin importar si pertenecen al subarreglo izquierdo o al derecho.

            // La variable i indica la posición del elemento que se va a comparar dentro del subarreglo izquierdo.
                // Cuando ese elemento se copia al arreglo original,
                    // i aumenta para continuar con el siguiente.
        int i = 0;

        // La variable j indica la posición del elemento que se va a COMPARAR dentro del subarreglo derecho.
            // Cuando ese elemento se copia al arreglo original,
                // j aumenta para continuar con el siguiente.
        int j = 0;
        //**********************

        // La variable k indica la posición del arreglo original
            // donde se va a guardar el número seleccionado después de comparar los elementos de ambos subarreglos.
        int k = izquierda;

        // 1 <= 2 -> copia 1
        // 3 <= 2 -> falso, copia 2
        // 3 <= 4 -> copia 3
        // 5 <= 4 -> falso, copia 4
        // 5 <= 6 -> copia 5
        // 8 <= 6 -> falso, copia 6
        // 8 <= 7 -> falso, copia 7

        //**********************
        // Se seguirá haciendo la comparación de valores mientras ambos sub-arreglos tengan valores
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
        // Quedan los valores 8 y 9.
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

    //******************************************************************
    //******************************************************************

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
