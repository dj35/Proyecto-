	import java.util.Scanner;
	public class AutoBiblio3 {
	 
	   
	   final public static Scanner sc= new Scanner(System.in); //Declaro el Scanner de manera global, de esta forma no tengo que declararlo en cada funcion
	   
	   
	   
	   //FUNCI�N MEN�
	   public static void menu(String[][]libreria){
	   boolean seguir = false; 
	    do {
	  System.out.println("Seleccione la opci�n que desea ejecutar: ");
	     System.out.println("1. A�adir o eliminar libro");
	     System.out.println("2. Ver libreria ahora");
	     System.out.println("3. A�adir caracter�sticas a un libro");
	     System.out.println("4. Contar libros seg�n criterio");
	     System.out.println("5. �Estamos abiertos?");
	     System.out.println("6. �Tengo alg�n descuento?");
	     System.out.println("7. Pedir recomendaciones");
	     System.out.println("8. Ordenar libros seg�n criterio"); 
	     System.out.println("9. Apagar programa"); 
	     
	 //Hay que meter el switch en menu en vez de main porque sino despues de hacer una de las opciones no vuelve al switch.   
	     
	   
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
	        seguir=false;
	        System.exit(0);
	        break; 
	         default: 
	           System.out.println("Opci�n incorrecta, pruebe otra vez\n");
	           seguir=true;    
	       }
	     }while(seguir);
	   }
	   
	   
	   //FUNCI�N VER LIBRERIA (en forma de tabla)
	   public static void verLibreria(String[][]libreria){
	     //Apa�a los espacios en la tabla
	     for (int q=0; q<libreria[0].length; q++){
	       int mayorLongitud=0;
	       int mayorPos=0;
	       for (int w=1; w<libreria.length; w++){
	         if (libreria[w][q]!="" && libreria[w][q].length()>=libreria[mayorPos][q].length()){
	           mayorPos=w;
	           mayorLongitud=libreria[w][q].length();
	         }
	       }  
	       for (int r=0; r<libreria.length; r++){
	         while (libreria[r][q]!="" && libreria[r][q].length()<mayorLongitud){
	           libreria[r][q]+=" ";
	         }
	       }
	     }   
	     String verTabla= "";
	     for (int i=0; i<libreria.length; i++){
	       verTabla= "";
	       for (int j=0; j<libreria[i].length; j++){
	         verTabla+= "  "+libreria[i][j];         
	       }
	       System.out.println(verTabla);
	     }
	     menu(libreria);
	   }
	   
	   
	   //FUNCI�N DESCUENTOS
	   public static void descuento(String[][]libreria){
	     System.out.println("�Qu� edad tienes?");
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
	              System.err.println("Error. A�ade el valor en num�rico");
	            }
	     }
	     //Descuentos
	     if (string2int(edad)<18||string2int(edad)>65){
	       System.out.println("Genial tienes un descuento del 10% en todos los libros :)");
	     }else{
	       System.out.println("Vaya, prueba con otra cosa: \n Pulse 1 Si es cliente premium de la librer�a\n Pulse 2 si tiene familia numerosa\n Pulse 3 si est� en paro\n Pulse cualquier otro n�mero si no cumple ninguno de los requisitos");
	       int opcionDescuento=sc.nextInt();
	       switch (opcionDescuento){
	         case 1: case 2: case 3:
	           System.out.println("Genial tienes un descuento del 10% en todos los libros :)");
	           break;
	         default:
	           System.out.println("Vaya, no tienes ning�n descuento");
	           break;  
	       }
	     }
	     menu(libreria);
	   }
	   
	   
	   //Comprueba que la hora est� entre 0-24 y los minutos entre 0-60
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
	 //Lee hora y minutos y llama a la funci�n haste que tenga un valor valido  
	     do {
	       System.out.println("Introduce la hora");
	       hora = sc.nextInt();
	       System.out.println("Introduce los minutos");
	       minutos = sc.nextInt();
	     } while (horaValida(hora, minutos));
	 //Abierta/cerrada
	     if (horarioApertura(hora, minutos)){
	       System.out.println("�Qu� bien! La librer�a est� abierta\n");
	     } else {
	       System.out.println("Lo siento, la librer�a est� cerrada...");
	     }
	     menu(libreria);
	   }
	   
	   //FUNCI�N CONTAR G�NEROS (Lee t�tulo y g�nero de una cantidad de libros determinada por el usuario y cuenta cu�ntos hay de cada genero.)
	   public static void contadorGeneros(String[][]libreria){
	    int contadorPolicial=0,contadorThriller=0,contadorDrama=0,contadorAccion=0,
	      contadorPoesia=0,contadorCienciaFiccion=0;
	    String genero1="Policiaco",genero2="Thriller", genero3="Drama",
	      genero4="Accion", genero5="Poesia", genero6="Ciencia ficcion";

	    for(int i=1; i<libreria.length; i++){
	        if(genero1.equals(libreria[i][2])){
	          contadorPolicial++;
	        }
	        else if(genero2.equals(libreria[i][2])){
	          contadorThriller++;
	        }
	        else if(genero3.equals(libreria[i][2])){
	          contadorDrama++;
	      }
	        else if(genero4.equals(libreria[i][2])){
	          contadorAccion++;
	    }
	        else if(genero5.equals(libreria[i][2])){
	          contadorPoesia++;
	        }
	        else if(genero6.equals(libreria[i][2])){
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
	    // menu();
	   
	   
	   //FUNCI�N A�ADIR Y ELIMINAR LIBROS (Recoge una de las dos opciones y en el caso de a�adir busca una posici�n vac�a para guardar el t�tulo y en el caso de eliminar, busca el libro que se desee eliminar y lo borra de la librer�a)
	   public static String[][] entraSale(String[][] libreria){
	     boolean erroneo=false;
	     
	     do{
	       System.out.print("Pulse 1.) si quiere a�adir un nuevo libro.\nPulse 2.) para eliminar un ejemplar\n");
	       char eleccion = sc.next().charAt(0);
	       switch(eleccion){
	         case '1':
	           int i=1;
	           while(i<libreria.length && libreria[i][0]!=""){ // Sugerencia, podr�a ponerse la segunda condici�n como !(libreria[i][0].equals(""))
	             i++;
	           }
	           if (i==libreria.length){
	             System.out.println("Lo sentimos, no hay espacio en la biblioteca.\n");
	           }else{
	             System.out.print("�C�mo se llama el libro que quieres a�adir?\n");
	             sc.nextLine();
	             libreria[i][0]=sc.nextLine();
	             System.out.println("Ya hemos almacenado t� libro\n");
	           }
	           erroneo = false;
	           break;
	         case '2':
	           System.out.print("�C�mo se llama el libro que quieres eliminar?\n");
	           int j=1;
	           sc.nextLine();
	           String nombre =sc.nextLine();
	           while(j<=libreria.length && !libreria[j][0].equalsIgnoreCase(nombre)){
	             j++;
	           }
	           if (j==libreria.length){
	             System.out.println("Lo sentimos, no hay ning�n libro llamado " + nombre+ " en la biblioteca.\n");
	           }else{
	            for(int h = 0; h<libreria[0].length;h++) {
	             libreria[j][h]="";  
	            }
	             System.out.println("Ya hemos eliminado el libro\n");
	           }
	           erroneo = false;
	           break;
	         default:
	           System.err.println("Valor no v�lido, pruebe otra vez");
	           erroneo= true;
	       }
	     }while(erroneo);
	     return libreria;
	   }
	   
	   //FUNCI�N MODIFICAR CARACTER�STICAS
	   public static String[][] caracteristica(String[][] libreria){
	   sc.nextLine();
	      System.out.print("�C�mo se llama el libro al que quiere a�adirle una caracter�stica?");
	     String nombre =sc.nextLine();
	     int j=1;
	     while(j<libreria.length && !libreria[j][0].equalsIgnoreCase(nombre)){
	       j++;
	     }
	     if (j==libreria.length){
	       System.out.println("Lo sentimos, no hay ning�n libro llamado \"" + nombre+ "\" en la biblioteca.\n");
	     }
	     else{
	       boolean erroneo=true;
	       do{
	         System.out.println("Pulse 1.) para cambiar el autor");
	         System.out.println("Pulse 2.) para cambiar el g�nero");
	         System.out.println("Pulse 3.) para cambiar el a�o de publicaci�n");
	         System.out.println("Pulse 4.) para a�adir una nueva valoraci�n");
	         System.out.println("Pulse 5.) para cambiar el n�mero de p�ginas");
	         System.out.println("Pulse 6.) para cambiar el marcador\n");
	         int respuesta= sc.nextInt();
	         sc.nextLine();
	         switch (respuesta){
	           case 1:
	          System.out.print("A�ade el nuevo autor");
	            libreria[j][respuesta]=sc.nextLine();
	            erroneo=false;
	            break;
	           case 2:
	             System.out.print("Marque la tecla correspondiente al g�nero a insertar:\n1. Polic�aco\n2. Thriller\n3. Drama\n4. Acci�n\n5. Poes�a\n6. Ciencia ficci�n");
	             String tecla =sc.next();
	             char tecla2 = tecla.charAt(0);
	             switch(char2int(tecla2)) {
	             case 1:
	              libreria[j][2]="Policiaco";
	              erroneo=false;
	              System.out.println("Perfecto, ahora el g�nero del libro es \"Polic�aco\"\n");
	              break;
	             case 2:
	              libreria[j][2]="Thriller";
	              erroneo=false;
	              System.out.println("Perfecto, ahora el g�nero del libro es \"Thriller\"\n");
	              break;
	             case 3:
	              libreria[j][2]="Drama";
	              erroneo=false;
	              System.out.println("Perfecto, ahora el g�nero del libro es \"Drama\"\n");
	              break;
	             case 4:
	              libreria[j][2]="Accion";
	              erroneo=false;
	              System.out.println("Perfecto, ahora el g�nero del libro es \"Acci�n\"\n");
	              break;
	             case 5:
	              libreria[j][2]="Poesia";
	              erroneo=false;
	              System.out.println("Perfecto, ahora el g�nero del libro es \"Poes�a\"\n");
	              break;
	             case 6:
	              libreria[j][2]="Ciencia ficcion";
	              erroneo=false;
	              System.out.println("Perfecto, ahora el g�nero del libro es \"Ciencia ficci�n\"\n");
	              break;
	             default:
	              System.err.println("Valor no v�lido, pruebe otra vez");
	             }
	             break;
	           case 3:
	        	   boolean estado =true;
		             do{
		               System.out.print("A�ade el nuevo valor");
		               String valor =sc.next();
		               if (valor.charAt(0)>48 && valor.charAt(0)<58 && string2int(valor)>0 && string2int(valor)<2018){
		                 libreria[j][respuesta]=valor;
		                 estado= false;
		               }else{
		                 System.err.println("Error. A�ade el valor en num�rico");
		               }
		             }while(estado);
		             erroneo =false;  
		             break;
	           case 5:
	           case 6:
	             estado =true;
	             do{
	               System.out.print("A�ade el nuevo valor");
	               String valor =sc.next();
	               if (valor.charAt(0)>48 && valor.charAt(0)<58){
	                 libreria[j][respuesta]=valor;
	                 estado= false;
	               }else{
	                 System.err.println("Error. A�ade el valor en num�rico");
	               }
	             }while(estado);
	             erroneo =false;  
	             break;
	           case 4:
	             libreria[j][respuesta]= valoracion(libreria[j][respuesta]);
	             erroneo = false;
	             break;
	           default:
	             System.err.println("Valor no v�lido, pruebe otra vez");
	         }
	         
	       }while(erroneo);
	       
	     }
	     j = 0;
	     return libreria;
	   
	   }
	   
	   //FUNCI�N PARA SABER CU�NTOS LIBROS HAY EN UNA LIBRER�A
	   public static void cuantosLibros(String[][] libreria){
	     int s =0;
	     for(int i=1; i<libreria.length; i++){
	       if (libreria[i][0]!="")
	         s++; 
	     }
	     System.out.println("Actualmente hay "+ s + " libros");
	   }
	   
	   //FUNCI�N AUXILIAR PARA PASAR UN STRING A UN INT
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
	 //FUNCI�N AUXILIAR PARA PASAR UN CHAR A UN INT
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
	       System.out.print("�Del cero al 10 cu�nto te ha gustado el libro?");
	       valNuevDouble= sc.nextDouble();
	       if(valNuevDouble<=10&& valNuevDouble>=0)
	         estado =false;
	       else
	         System.err.println("Error. Valor no v�lido");
	     }while(estado);
	     
	     if (valAntDouble==0)
	       return ""+ (int)valNuevDouble;
	     else
	       return ""+ (int)((valNuevDouble+valAntDouble)/2);
	   }
	   
	   //FUNCI�N MARCAP�GINAS
	   public static void marcapag(String[][] libreria){
	     System.out.print("�C�mo se llama el libro que quieres saber por donde v�s?");
	     String nombre =sc.nextLine();
	     int j=1;
	     while(j<libreria.length && !libreria[j][0].equalsIgnoreCase(nombre)){
	       j++;
	     }
	     if (j==libreria.length){
	       System.out.println("Lo sentimos, no hay ning�n libro llamado " + nombre + " en la biblioteca.");
	     }else{
	       int pagInt= string2int(libreria[j][5]);
	       int marcInt =string2int(libreria[j][6]);
	       if(marcInt==0)
	         System.out.println("Todavia no has comenzado a leer este libro");
	       else if(marcInt<pagInt)
	         System.out.println("Vas por la p�gina " + marcInt + ", es decir, te quedan " + (pagInt-marcInt) + " p�gs. para acabar.");
	       else 
	         System.out.println("Enhorabuena, ya has leido este libro");
	     }
	   }
	   
	   //FUNCI�N FILTRAR
	   public static void filtrar(String[][] libreria){
	     boolean estado = true;
	     //tomo "�" como null
	     String autor="�";
	     String genero="�";
	     String anyo="�";
	     String val="�";
	     String pag="�";    
	     do{
	       System.out.println("Pulse 1.) si quiere especificar el autor");
	       System.out.println("Pulse 2.) si quiere especificar el g�nero");
	       System.out.println("Pulse 3.) si quiere especificar el el a�o de publicaci�n");
	       System.out.println("Pulse 4.) si quiere especificar la valoraci�n");
	       System.out.println("Pulse 5.) si quiere especificar el n�mero de p�ginas");
	       System.out.println("Pulse otro boton si no quiere a�adir m�s limitaciones");
	       switch(sc.next().charAt(0)){
	         case '1':
	           sc.nextLine();
	           System.out.print("�C�mo se llama el autor?");
	           autor=sc.nextLine();
	           break;
	         case '2':
	           sc.nextLine();
	           System.out.print("Qu� genero quieres?");
	           genero=sc.nextLine();
	           break;
	         case '3':
	           System.out.print("Cu�ndo se public�?");
	           anyo=sc.next();
	           break;
	         case '4':
	           System.out.print("�Qu� nota tiene?");
	           val= "" + (int)sc.nextDouble();
	           break;
	         case '5':
	           System.out.print("�Cu�ntas p�ginas tiene?");
	           pag=sc.next();
	           break;
	         default:
	           estado = false;
	       }
	     }while(estado);
	     System.out.println("Los libros que cumplen dichas propiedades son: (en caso de no aparecer ninguno, se debe a que ninguno cumple dichas propiedades simultaneamente)");
	     
	     for (int i=1; i<libreria.length; i++){
	       if(((autor=="�")||(libreria[i][1].equalsIgnoreCase(autor))) 
	            && ((genero=="�")||(libreria[i][2].equalsIgnoreCase(genero)))
	            &&((anyo=="�")||(libreria[i][3].equalsIgnoreCase(anyo)))
	            &&((val=="�")||(libreria[i][4].equalsIgnoreCase(val)))
	            &&((pag=="�")||(libreria[i][5].equalsIgnoreCase(pag)))){
	         System.out.println(libreria[i][0]);
	       }
	     }menu(libreria);
	   }
	   
	   //FUNCI�N ORDENAR SEG�N CRITERIO
	   public static void ordenar(String[][]libreria){
	     System.out.println("Elige un criterio de ordenaci�n: \n 1. G�nero \n 2. Valoraci�n \n 3. A�o");
	     switch (sc.next().charAt(0)){
	       case '1':
	         //Compara filas buscando el mismo genero:
	         for (int i=1; i<libreria.length; i++){
	         int n=0;
	         for (int j=i+1; j<libreria.length; j++){
	           if (libreria[j][2]!="" && libreria[i][2].equals(libreria[j][2])){
	             n+=1;
	             //Permuta fila i+n y fila j:
	             String[]aux=new String[libreria[0].length];
	             for (int k=0; k<libreria[0].length; k++){
	               aux[k]=libreria[i+n][k];
	               libreria[i+n][k]=libreria[j][k];
	               libreria[j][k]=aux[k];
	             }
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
	           String[]aux=new String[libreria[0].length];
	           for (int k=0; k<libreria[0].length; k++){
	             aux[k]=libreria[i][k];
	             libreria[i][k]=libreria[max][k];
	             libreria[max][k]=aux[k];
	           }
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
	           for (int k=0; k<libreria[0].length; k++){
	             aux[k]=libreria[i][k];
	             libreria[i][k]=libreria[max][k];
	             libreria[max][k]=aux[k];
	           }
	         }
	       }
	         verLibreria(libreria);        
	       default:
	         menu(libreria);
	     }
	   }
	   
	  /* public static void main (String[]args){
	     //Inicializa un array (X filas->X-1 libros, 7 columnas->t�tulo+6 atributos)
	    /* System.out.println("�Cu�ntos libros necesitas para la libreria?");
	     String[][] libreria=new String[sc.nextInt()+1][7]; 
	     sc.nextLine();
	     libreria[0][0]="T�TULO";
	     libreria[0][1]="AUTOR";
	     libreria[0][2]="G�NERO";
	     libreria[0][3]="A�O";
	     libreria[0][4]="VALORACI�N";
	     libreria[0][5]="P�GINAS";
	     libreria[0][6]="MARCADOR";
	     
	     //Si no inicializo la matriz, �sta se llena de [null], lo cual me impide usar funciones de Strings (NullPointerException error)
	     
	     for(int i=1; i<libreria.length; i++){
	       for(int j=0; j<libreria[i].length;j++){
	         libreria[i][j]="";
	       }
	     }
	     
	     for(int i=0; i<libreria.length; i++){
	       for(int j=0; j<libreria[i].length;j++){
	         System.out.print(libreria[i][j] + " ");
	       }
	       System.out.println("");
	     }
	     String[][] libreria={
	      {"T","A","G","A","V","P"},
	      {"prueba1","paco","drama","111","3","123","50"},
	      {"prueba2","pedro","drama","1234","3","123"},
	      {"prueba3","paco","sex","111","8","123"},
	      {"prueba4","paco","sex","1234","821","1785"}};
	    
	    
	     marcapag(libreria);
	     filtrar(libreria);
	     //menu(libreria);
	   } */
	   //MAIN    
	   public static void main (String[]args){
	     //Ya solo hace falta este scanner para todas las funciones
	     
	     //Inicializa un array (7 filas->6 libros, 5 columnas->t�tulo+4 atributos)
	     String[][]libreria=new String[10][5]; 
	     libreria[0][0]="T�TULO";
	     libreria[0][1]="AUTOR";
	     libreria[0][2]="G�NERO";
	     libreria[0][3]="A�O";
	     libreria[0][4]="VALORACI�N";
	     for(int i=1; i<libreria.length; i++){
	        for(int j=0; j<libreria[i].length;j++){
	          libreria[i][j]="";
	        }
	      }
	     //He metido esto para probar funciones sin tener que introducir libros
	     libreria[1][0]="Tit1111111";
	     libreria[1][1]="Aut1";
	     libreria[1][2]="Policiaco";
	     libreria[1][3]="1985";
	     libreria[1][4]="10";
	     libreria[2][0]="Tit2";
	     libreria[2][1]="Aut222222";
	     libreria[2][2]="Thriller";
	     libreria[2][3]="1995";
	     libreria[2][4]="5";
	     libreria[3][0]="Tit3";
	     libreria[3][1]="Aut3";
	     libreria[3][2]="Policiaco";
	     libreria[3][3]="2000";
	     libreria[3][4]="7";
	     libreria[4][0]="Tit4";
	     libreria[4][1]="Aut4";
	     libreria[4][2]="policial";
	     libreria[4][3]="1999";
	     libreria[4][4]="8"; 
	     menu(libreria);
	   }
	 }

