/*
1. Posibilidad de agregar y eliminar nuevos ejemplares.

    public static void otroLibro (int a, String nombre, String[][] libreria){Esta función va a recibir el número de la posición en el array(int), el nuevo valor de la posición (String) que será el título del libro, y el nombre del array que hemos definido (librería)}
    public static void eliminarLibro (int a, String nombre, String[][] libreria){es igual que la otra pero asignará el valor nulo (null / "")}

2. Vincular a un libro unas características: Género, autor, extensión, valoración...

    public static void otroAutor (int a, String nombre, String[][] libreria){Igual pero con el valor de la segunda coordenada definida dentro de la función}

    public static void otroGenero (int a, String nombre, String[][] libreria){Igual pero con el valor de la segunda coordenada definida dentro de la función}    

    public static void otroExtension (int a, String nombre, String[][] libreria){Igual pero con el valor de la segunda coordenada definida dentro de la función}

3. Saber cuántos libros tienes en total en la biblioteca.


    public static int contarLibros (String[][] libreria){Esta función contará mediante un bucle de incremento cuántas posiciones de la primera coordenada (los libros) es distinta de null}

4. Poder añadir una valoración a través de puntuación.

    public static void otraValoracion (int a, String nombre, String[][] libreria){Igual pero con el valor de la segunda coordenada definida dentro de la función}

5. Añadir un marcapáginas virtual, es decir, que te muestre si te has leído un libro y en
caso de que no lo hayas terminado decir por donde vas.

    public static int marcador (int a, int m, String[][] libreria){la función te dice si lo has empezado(compara si es cero en cuyo caso te dirá que no lo has empezado, si es igual a la extensión, te dirá que los has terminado, y si no te dirá por cuál vas) y posteriormente te dará la opción de cambiarlo}


6. Para ayudar a un lector a buscar libros según sus preferencias se podría hacer una
función que te muestre los libros que sólo tienen unas características determinadas.
Ya sea: “quiero que el libro sea de fantasía y que tenga menos de 500 páginas”.

    public static void filtro (int a, String nombre, String[][] libreria){Coge la característica a filtrar(género,autor...), el valor de esa carasterística (fantasía, policiaca o J.K.Rowling, G.R.Martin), y compruebe con operadores lógicos si el valor coincide con el guardado en cada libro y en caso positivo imprime todos los que cumplan la condición por pantalla}

7. Mostrar por pantalla la biblioteca ordenada según diferentes criterios:

? Estándar: almacenar por autor y dentro del autor por orden lexicográfico, es
decir, primero diferencias grupos de libros por su autor y después dentro de
cada grupo se tendría que ordenar alfabéticamente.

? Valoraciones: por orden de mayor a menor media de valoración

? Género literario

    public static void main (int a, String[][] libreria){Coge la categoría correspondiente a int y la ordena por orden lexicográfico y de esa manera quedan todas las categorías ordenadas}

 
 
 
 
 */