/*
1. Posibilidad de agregar y eliminar nuevos ejemplares.

    public static void otroLibro (int a, String nombre, String[][] libreria){Esta funci�n va a recibir el n�mero de la posici�n en el array(int), el nuevo valor de la posici�n (String) que ser� el t�tulo del libro, y el nombre del array que hemos definido (librer�a)}
    public static void eliminarLibro (int a, String nombre, String[][] libreria){es igual que la otra pero asignar� el valor nulo (null / "")}

2. Vincular a un libro unas caracter�sticas: G�nero, autor, extensi�n, valoraci�n...

    public static void otroAutor (int a, String nombre, String[][] libreria){Igual pero con el valor de la segunda coordenada definida dentro de la funci�n}

    public static void otroGenero (int a, String nombre, String[][] libreria){Igual pero con el valor de la segunda coordenada definida dentro de la funci�n}    

    public static void otroExtension (int a, String nombre, String[][] libreria){Igual pero con el valor de la segunda coordenada definida dentro de la funci�n}

3. Saber cu�ntos libros tienes en total en la biblioteca.


    public static int contarLibros (String[][] libreria){Esta funci�n contar� mediante un bucle de incremento cu�ntas posiciones de la primera coordenada (los libros) es distinta de null}

4. Poder a�adir una valoraci�n a trav�s de puntuaci�n.

    public static void otraValoracion (int a, String nombre, String[][] libreria){Igual pero con el valor de la segunda coordenada definida dentro de la funci�n}

5. A�adir un marcap�ginas virtual, es decir, que te muestre si te has le�do un libro y en
caso de que no lo hayas terminado decir por donde vas.

    public static int marcador (int a, int m, String[][] libreria){la funci�n te dice si lo has empezado(compara si es cero en cuyo caso te dir� que no lo has empezado, si es igual a la extensi�n, te dir� que los has terminado, y si no te dir� por cu�l vas) y posteriormente te dar� la opci�n de cambiarlo}


6. Para ayudar a un lector a buscar libros seg�n sus preferencias se podr�a hacer una
funci�n que te muestre los libros que s�lo tienen unas caracter�sticas determinadas.
Ya sea: �quiero que el libro sea de fantas�a y que tenga menos de 500 p�ginas�.

    public static void filtro (int a, String nombre, String[][] libreria){Coge la caracter�stica a filtrar(g�nero,autor...), el valor de esa caraster�stica (fantas�a, policiaca o J.K.Rowling, G.R.Martin), y compruebe con operadores l�gicos si el valor coincide con el guardado en cada libro y en caso positivo imprime todos los que cumplan la condici�n por pantalla}

7. Mostrar por pantalla la biblioteca ordenada seg�n diferentes criterios:

? Est�ndar: almacenar por autor y dentro del autor por orden lexicogr�fico, es
decir, primero diferencias grupos de libros por su autor y despu�s dentro de
cada grupo se tendr�a que ordenar alfab�ticamente.

? Valoraciones: por orden de mayor a menor media de valoraci�n

? G�nero literario

    public static void main (int a, String[][] libreria){Coge la categor�a correspondiente a int y la ordena por orden lexicogr�fico y de esa manera quedan todas las categor�as ordenadas}

 
 
 
 
 */