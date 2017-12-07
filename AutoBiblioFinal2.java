import java.util.Scanner;
public class AutoBiblioFinal2{
  
   final public static Scanner sc= new Scanner(System.in); //Declaro el Scanner de manera global, de esta forma no tengo que declararlo en cada funcion
   
   //FUNCIÓN MENÚ
   public static void menu(String[][]libreria){
     boolean seguir = false; 
     do {
       System.out.println("\nSeleccione la opción que desea ejecutar: ");
       System.out.println("1. Añadir o eliminar libro");
       System.out.println("2. Ver libreria ahora");
       System.out.println("3. Añadir características a un libro");
       System.out.println("4. Contar libros según género");
       System.out.println("5. ¿Estamos abiertos?");
       System.out.println("6. ¿Tengo algún descuento?");
       System.out.println("7. Filtrar libros");
       System.out.println("8. Ordenar libros según criterio");
       System.out.println("9. Consulta tus marcapáginas");
       System.out.println("10. Apagar programa"); 
       switch (sc.nextInt()){
         case 1:
           seguir=true;
           libreria = entraSale(libreria); 
           break;
         case 2:
           seguir=true;
           verLibreria(libreria); 
           break;             
         case 3:
           seguir=true;
           libreria=caracteristica(libreria);
           break;
         case 4:
           seguir=true;
           contadorGeneros(libreria);
           break; 
         case 5:
           seguir=true;
           horario(libreria);
           break;
         case 6:
           seguir=true;
           descuento(libreria);
           break;
         case 7:
           seguir=true;
           filtrar(libreria);
           break;
         case 8:
           seguir=true;
           ordenar(libreria);
           break;
         case 9:
           seguir=true;
           marcapag(libreria);
           break;
         case 10:
          seguir=false;
          System.exit(0);
          break; 
         default: 
           System.out.println("Opción incorrecta, pruebe otra vez\n");
           seguir=true;    
       }
     }while(seguir);
   }
   
   
   //FUNCIÓN VER LIBRERIA (en forma de tabla)
   public static void verLibreria(String[][]libreria){
     //Apaña los espacios en la tabla
     String[][]libreriaVer=new String[libreria.length][libreria[0].length];
     for (int i=0; i<libreria.length; i++) {
       for (int j=0; j<libreria[0].length; j++){
            libreriaVer[i][j] = libreria[i][j];
        }
     }
     for (int q=0; q<libreria[0].length; q++){
       int mayorLongitud=0;
       int mayorPos=0;
       for (int w=0; w<libreria.length; w++){
         if (libreria[w][q]!="" && libreria[w][q].length()>=libreria[mayorPos][q].length()){
           mayorPos=w;
           mayorLongitud=libreria[w][q].length();
         }
       }  
       for (int r=0; r<libreria.length; r++){
         while (libreriaVer[r][q].length()<mayorLongitud){
           libreriaVer[r][q]+=" ";
         }
       }
     }   
     String verTabla= "";
     for (int i=0; i<libreria.length; i++){
       verTabla= "";
       for (int j=0; j<libreria[i].length; j++){
         verTabla+= "  "+libreriaVer[i][j];         
       }
       if(libreria[i][0]!=""){
         System.out.println(verTabla);
       }
     }
   }
   
   
   //FUNCIÓN DESCUENTOS
   public static void descuento(String[][]libreria){
     System.out.println("¿Qué edad tienes?");
     String edad = "0";
     //Evitar edad negativa
     boolean repetir=true;
     while(repetir){
      edad =sc.next();
            if (edad.charAt(0)>48 && edad.charAt(0)<58){
             if (string2int(edad)>0){
                 repetir = false;
               } else {
                 System.out.println("Introduce la edad correctamente");
               }
            }else{
              System.err.println("Error. Añade el valor en numérico");
            }
     }
     //Descuentos
     if (string2int(edad)<18||string2int(edad)>65){
       System.out.println("Genial tienes un descuento del 10% en todos los libros :)");
     }else{
       System.out.println("Vaya, prueba con otra cosa: \n Pulse 1 Si es cliente premium de la librería\n Pulse 2 si tiene familia numerosa\n Pulse 3 si está en paro\n Pulse cualquier otro número si no cumple ninguno de los requisitos");
       int opcionDescuento=sc.nextInt();
       switch (opcionDescuento){
         case 1: case 2: case 3:
           System.out.println("Genial tienes un descuento del 10% en todos los libros :)");
           break;
         default:
           System.out.println("Vaya, no tienes ningún descuento");
           break;  
       }
     }
   }
   
   
   //Comprueba que la hora está entre 0-24 y los minutos entre 0-60
   public static boolean horaValida(int hora, int minutos){
     if (hora>=0 && hora<24 && minutos>=0 && minutos<60){
       return false;
     } else {
       System.err.println("Error");
       return true;
     }
   }
   
   
   //Compara hora/minutos con el horario (10-14:30 y 17:30-21 en este ejemplo)
   public static boolean horarioApertura(int hora, int minutos){
     if (hora<10 || hora>=21 || (hora>15 && hora<17)){
       return false;
     } else if (hora==14){
       if (minutos>30){
         return false;
       } else {
         return true;
       }
     } else if (hora==17){
       if (minutos<30){
         return false;
       } else {
         return true;
       }
     } else {
       return true;
     }
   }    
   
   
   //FUNCION PRINCIPAL HORARIO (llama a horaValida para ver si la hora es valida y a horarioApertura para ver si esta en el rango de horas correspondiente
   public static void horario(String[][]libreria){
     int hora, minutos;
 //Lee hora y minutos y llama a la función haste que tenga un valor valido  
     do {
       System.out.println("Introduce la hora");
       hora = sc.nextInt();
       System.out.println("Introduce los minutos");
       minutos = sc.nextInt();
     } while (horaValida(hora, minutos));
 //Abierta/cerrada
     if (horarioApertura(hora, minutos)){
       System.out.println("¡Qué bien! La librería está abierta\n");
     } else {
       System.out.println("Lo siento, la librería está cerrada...");
     }
   }
   
   //FUNCIÓN CONTAR GÉNEROS (Lee título y género de una cantidad de libros determinada por el usuario y cuenta cuántos hay de cada genero.)
   public static void contadorGeneros(String[][]libreria){
    int contadorPolicial=0,contadorThriller=0,contadorDrama=0,contadorAccion=0,contadorPoesia=0,contadorCienciaFiccion=0;
    String genero1="Policiaco",genero2="Thriller", genero3="Drama",
      genero4="Accion", genero5="Poesia", genero6="Ciencia ficcion";

    for(int i=1; i<libreria.length; i++){
        if(genero1.equalsIgnoreCase(libreria[i][2])){
          contadorPolicial++;
        }
        else if(genero2.equalsIgnoreCase(libreria[i][2])){
          contadorThriller++;
        }
        else if(genero3.equalsIgnoreCase(libreria[i][2])){
          contadorDrama++;
      }
        else if(genero4.equalsIgnoreCase(libreria[i][2])){
          contadorAccion++;
    }
        else if(genero5.equalsIgnoreCase(libreria[i][2])){
          contadorPoesia++;
        }
        else if(genero6.equalsIgnoreCase(libreria[i][2])){
          contadorCienciaFiccion++;
        }
    }
      System.out.println(genero1 + " aparece: " + contadorPolicial + " veces. ");
      System.out.println(genero2 + " aparece: " + contadorThriller + " veces. ");
      System.out.println(genero3 + " aparece: " + contadorDrama + " veces. ");
      System.out.println(genero4 + " aparece: " + contadorAccion + " veces. ");
      System.out.println(genero5 + " aparece: " + contadorPoesia + " veces. ");
      System.out.println(genero6 + " aparece: " + contadorCienciaFiccion + " veces. ");
   }
   
   
   //FUNCIÓN AÑADIR Y ELIMINAR LIBROS (Recoge una de las dos opciones y en el caso de añadir busca una posición vacía para guardar el título y en el caso de eliminar, busca el libro que se desee eliminar y lo borra de la librería)
   public static String[][] entraSale(String[][] libreria){
     boolean erroneo=false;
     
     do{
       System.out.print("Pulse 1.) si quiere añadir un nuevo libro.\nPulse 2.) para eliminar un ejemplar\n");
       char eleccion = sc.next().charAt(0);
       switch(eleccion){
         case '1':
           int i=1;
           while(i<libreria.length && libreria[i][0]!=""){ // Sugerencia, podría ponerse la segunda condición como !(libreria[i][0].equals(""))
             i++;
           }
           if (i==libreria.length){
             System.out.println("Lo sentimos, no hay espacio en la biblioteca.\n");
           }else{
             System.out.print("¿Cómo se llama el libro que quieres añadir?\n");
             sc.nextLine();
             libreria[i][0]=sc.nextLine();
             System.out.println("Ya hemos almacenado tu libro\n");
           }
           erroneo = false;
           break;
         case '2':
           System.out.print("¿Cómo se llama el libro que quieres eliminar?\n");
           int j=1;
           sc.nextLine();
           String nombre =sc.nextLine();
           while(j<libreria.length && !libreria[j][0].equalsIgnoreCase(nombre)){
             j++;
           }
           if (j==libreria.length){
             System.out.println("Lo sentimos, no hay ningún libro llamado " + nombre+ " en la biblioteca.\n");
           }else{
             for(int h = 0; h<libreria[0].length;h++) {
               libreria[j][h]="";  
             }   
             for (int p=j; p<libreria.length-1; p++){
               libreria=permutar(libreria, p, p+1);
             }                  
             System.out.println("Ya hemos eliminado el libro\n");
           }
           erroneo = false;
           break;
         default:
           System.err.println("Valor no válido, pruebe otra vez");
           erroneo= true;
       }
     }while(erroneo);
     return libreria;
   }
   
   //FUNCION PERMUTAR FILA I Y J
   public static String[][] permutar(String[][]libreria, int i, int j){
     String[]aux=new String[libreria[0].length];
     for (int k=0; k<libreria[0].length; k++){
       aux[k]=libreria[i][k];
       libreria[i][k]=libreria[j][k];
       libreria[j][k]=aux[k];
     }
     return libreria;
   }
       
   //FUNCIÓN MODIFICAR CARACTERÍSTICAS
   public static String[][] caracteristica(String[][] libreria){
   sc.nextLine();
      System.out.print("¿Cómo se llama el libro al que quiere añadirle una característica?");
     String nombre =sc.nextLine();
     int j=1;
     while(j<libreria.length && !libreria[j][0].equalsIgnoreCase(nombre)){
       j++;
     }
     if (j==libreria.length){
       System.out.println("Lo sentimos, no hay ningún libro llamado \"" + nombre+ "\" en la biblioteca.\n");
     }else{
       boolean erroneo=true;
       do{
         System.out.println("Pulse 1.) para cambiar el autor");
         System.out.println("Pulse 2.) para cambiar el género");
         System.out.println("Pulse 3.) para cambiar el año de publicación");
         System.out.println("Pulse 4.) para añadir una nueva valoración");
         System.out.println("Pulse 5.) para cambiar el número de páginas");
         System.out.println("Pulse 6.) para cambiar el marcador\n");
         int respuesta= sc.nextInt();
         sc.nextLine();
         switch (respuesta){
           case 1:
          System.out.print("Añade el nuevo autor");
            libreria[j][respuesta]=sc.nextLine();
            erroneo=false;
            break;
           case 2:
             System.out.print("Marque la tecla correspondiente al género a insertar:\n1. Policíaco\n2. Thriller\n3. Drama\n4. Acción\n5. Poesía\n6. Ciencia ficción");
             String tecla =sc.next();
             char tecla2 = tecla.charAt(0);
             switch(char2int(tecla2)) {
             case 1:
              libreria[j][2]="Policiaco";
              erroneo=false;
              System.out.println("Perfecto, ahora el género del libro es \"Policíaco\"\n");
              break;
             case 2:
              libreria[j][2]="Thriller";
              erroneo=false;
              System.out.println("Perfecto, ahora el género del libro es \"Thriller\"\n");
              break;
             case 3:
              libreria[j][2]="Drama";
              erroneo=false;
              System.out.println("Perfecto, ahora el género del libro es \"Drama\"\n");
              break;
             case 4:
              libreria[j][2]="Accion";
              erroneo=false;
              System.out.println("Perfecto, ahora el género del libro es \"Acción\"\n");
              break;
             case 5:
              libreria[j][2]="Poesia";
              erroneo=false;
              System.out.println("Perfecto, ahora el género del libro es \"Poesía\"\n");
              break;
             case 6:
              libreria[j][2]="Ciencia ficcion";
              erroneo=false;
              System.out.println("Perfecto, ahora el género del libro es \"Ciencia ficción\"\n");
              break;
             default:
              System.err.println("Valor no válido, pruebe otra vez");
             }
             break;
           case 3:
           case 5:
           case 6:
             boolean estado =true;
             do{
               System.out.print("Añade el nuevo valor");
               String valor =sc.next();
               if (valor.charAt(0)>48 && valor.charAt(0)<58){
                 libreria[j][respuesta]=valor;
                 estado= false;
               }else{
                 System.err.println("Error. Añade el valor en numérico");
               }
             }while(estado);
             erroneo =false;  
             break;
           case 4:
             libreria[j][respuesta]= valoracion(libreria[j][respuesta]);
             erroneo = false;
             break;
           default:
             System.err.println("Valor no válido, pruebe otra vez");
         }
         
       }while(erroneo);
       
     }
     return libreria;
   
   }
   
   //FUNCIÓN PARA SABER CUÁNTOS LIBROS HAY EN UNA LIBRERÍA
   public static void cuantosLibros(String[][] libreria){
     int s =0;
     for(int i=1; i<libreria.length; i++){
       if (libreria[i][0]!="")
         s++; 
     }
     System.out.println("Actualmente hay "+ s + " libros");
   }
   
   //FUNCIÓN AUXILIAR PARA PASAR UN STRING A UN INT
   public static int string2int(String texto){
     int num=0;
     int temp=0;
     texto =texto.trim();
     if(texto !=""){
       for (int i=0; i<texto.length();i++){
         temp=(int)(texto.charAt(texto.length()-1-i)) -48;
         num=(int)(temp*Math.pow(10, i))+num; //Math.pow(a, b) se usa para calcular potencias, donde a es la base y b el exponente
       }
     }
     return num;
   }
   
   //FUNCIÓN AUXILIAR PARA PASAR UN CHAR A UN INT
   public static int char2int(char caracter){
     int num = (int)(caracter) -48;
     return num;
   }
   
   //Hace la media y redondea hacia abajo a entero 
   public static String valoracion(String valAnt){
     double valNuevDouble=0.0;
     double valAntDouble= string2int(valAnt);
     boolean estado=true;
     do{
       System.out.print("¿Del cero al 10 cuánto te ha gustado el libro?");
       valNuevDouble= sc.nextDouble();
       if(valNuevDouble<=10&& valNuevDouble>=0)
         estado =false;
       else
         System.err.println("Error. Valor no válido");
     }while(estado);
     
     if (valAntDouble==0)
       return ""+ (int)valNuevDouble;
     else
       return ""+ (int)((valNuevDouble+valAntDouble)/2);
   }
   
   //FUNCIÓN MARCAPÁGINAS
   public static void marcapag(String[][] libreria){
     System.out.print("¿Cómo se llama el libro que quieres saber por donde vás?");
     String nombre =sc.nextLine();
     int j=1;
     while(j<libreria.length && !libreria[j][0].equalsIgnoreCase(nombre)){
       j++;
     }
     if (j==libreria.length){
       System.out.println("Lo sentimos, no hay ningún libro llamado " + nombre + " en la biblioteca.");
     }else{
       int pagInt= string2int(libreria[j][5]);
       int marcInt= string2int(libreria[j][6]);
       if(marcInt==0)
         System.out.println("Todavia no has comenzado a leer este libro");
       else if(marcInt<pagInt)
         System.out.println("Vas por la página " + marcInt + ", es decir, te quedan " + (pagInt-marcInt) + " págs. para acabar.");
       else 
         System.out.println("Enhorabuena, ya has leido este libro");
     }
   }
   
   //FUNCIÓN FILTRAR
   public static void filtrar(String[][] libreria){
     boolean estado = true;
     //tomo "ª" como null
     String autor="ª";
     String genero="ª";
     String anyo="ª";
     String val="ª";
     String pag="ª";    
     do{
       System.out.println("Pulse 1.) si quiere especificar el autor");
       System.out.println("Pulse 2.) si quiere especificar el género");
       System.out.println("Pulse 3.) si quiere especificar el el año de publicación");
       System.out.println("Pulse 4.) si quiere especificar la valoración");
       System.out.println("Pulse 5.) si quiere especificar el número de páginas");
       System.out.println("Pulse otro boton si no quiere añadir más limitaciones");
       switch(sc.next().charAt(0)){
         case '1':
           sc.nextLine();
           System.out.print("¿Cómo se llama el autor?");
           autor=sc.nextLine();
           break;
         case '2':
           sc.nextLine();
           System.out.print("Qué genero quieres?");
           genero=sc.nextLine();
           break;
         case '3':
           System.out.print("Cuándo se publicó?");
           anyo=sc.next();
           break;
         case '4':
           System.out.print("¿Qué nota tiene?");
           val= "" + (int)sc.nextDouble();
           break;
         case '5':
           System.out.print("¿Cuántas páginas tiene?");
           pag=sc.next();
           break;
         default:
           estado = false;
       }
     }while(estado);
     System.out.println("Los libros que cumplen dichas propiedades son: (en caso de no aparecer ninguno, se debe a que ninguno cumple dichas propiedades simultaneamente)");   
     for (int i=1; i<libreria.length; i++){
       if(((autor=="ª")||(libreria[i][1].equalsIgnoreCase(autor))) 
            && ((genero=="ª")||(libreria[i][2].equalsIgnoreCase(genero)))
            &&((anyo=="ª")||(libreria[i][3].equalsIgnoreCase(anyo)))
            &&((val=="ª")||(libreria[i][4].equalsIgnoreCase(val)))
            &&((pag=="ª")||(libreria[i][5].equalsIgnoreCase(pag)))){
         System.out.println(libreria[i][0]);
       }
     }
   }
   
   //FUNCIÓN ORDENAR SEGÚN CRITERIO
   public static void ordenar(String[][]libreria){
     System.out.println("Elige un criterio de ordenación: \n 1. Género \n 2. Valoración \n 3. Año");
     switch (sc.next().charAt(0)){
       case '1':
         //Compara filas buscando el mismo genero:
         for (int i=1; i<libreria.length; i++){
         int n=0;
         for (int j=i+1; j<libreria.length; j++){
           if (libreria[j][2]!="" && libreria[i][2].equals(libreria[j][2])){
             n+=1;
             libreria= permutar(libreria, i+n, j);
           }
         }
       }
         verLibreria(libreria); 
         break;
       case '2':
         //Compara filas a partir de i buscando la maxima valoracion:
         for (int i=1; i<libreria.length-1; i++){
         int max=i;
         for (int j=i+1; j<libreria.length; j++){
           if(libreria[j][4]!="" && string2int(libreria[j][4])>string2int(libreria[max][4])){
             max=j;
           }
         }        
         if(i!=max){
           //Permuta fila i y fila max:
           libreria= permutar(libreria, i, max);
         }
       }
         verLibreria(libreria);  
         break;
       case '3':
         //Funciona igual que la valoracion
         for (int i=1; i<libreria.length-1; i++){
         int max=i;
         for (int j=i+1; j<libreria.length; j++){
           if(libreria[j][3]!="" && string2int(libreria[j][3])>string2int(libreria[max][3])){
             max=j;
           }
         }
         if(i!=max){
           String[]aux=new String[libreria[0].length];
           libreria= permutar(libreria, i, max);
         }
       }
         verLibreria(libreria);        
         
     }
   }
   
   //MAIN    
   public static void main (String[]args){
      String[][] libreria={
      {"Título","Autor","Género","Año","Valoración","Páginas","Marcapáginas"},
      {"prueba1","paco","drama","111","3","123","50"},
      {"prueba2","pedro","drama","1234","3","123","2"},
      {"prueba3","paco","Poesia","111","8","123","2"},
      {"prueba4","paco","Accion","1234","821","1785","2"},
      {"","","","","","",""},
      {"","","","","","",""},
      {"","","","","","",""},
      {"","","","","","",""},        
      {"","","","","","",""},
      {"","","","","","",""},
      {"","","","","","",""},
      {"","","","","","",""},
      {"","","","","","",""},
      {"","","","","","",""}};
      menu(libreria);
   }
}
