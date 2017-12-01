import java.util.Scanner;
public class AutoBiblio2{
  
  final public static Scanner sc= new Scanner(System.in); //Declaro el Scanner de manera global, de esta forma no tengo que declararlo en cada funcion
  
  public static void descuento(){
    System.out.println("¿Qué edad tienes?");
    int edad=0;
    //Evitar edad negativa
    boolean repetir=true;
    while(repetir){
      edad=sc.nextInt();
      if (edad>0){
        repetir = false;
      } else {
        System.err.println("Introduce la edad correctamente");
      }
    }
    //Descuentos
    if (edad<18||edad>65){
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
    //menu();
  } 
  
  public static boolean horaValida(int hora, int minutos){
    if(hora>=0 && hora <=24){
      if (minutos>=0 && minutos<=60)
        return true;
      else{
        System.err.println("ERROR");
        return false;
      }
    }else{ 
      System.err.println("ERROR");
      return false;
    }
  }
  
  public static boolean horarioApertura(int hora, int minutos){
    if(hora>=10 && hora <=14){
      if ((hora==10 && minutos<0)|| (hora==14 && minutos>30))
        return false;
      else
        return true;
    }else if(hora>=17 && hora<=21){
      if ((hora==17 && minutos<30)|| (hora==21 && minutos>0))
        return false;
      else
        return true;
    }else 
      return false;
  }
  
  public static void horario(){
    boolean estado= false;
    int hora,minutos;
    do{
      System.out.println("Introduzca la hora a la que le gustaría ir a nuestra tienda");
      hora =sc.nextInt();
      minutos =sc.nextInt();
      System.out.println("¿Quiere venir a las " + hora + ":" + minutos + " ? {Y/N}");
      char respuesta= sc.next().charAt(0); 
      switch (respuesta){
        case 'Y':
        case 'y':
          estado = false;
          break;
        default:
          estado = true;
      }
    }while(!horaValida(hora,minutos)|| estado);
    if (horarioApertura(hora,minutos))
      System.out.println("Enhorabuena nuestra tienda está abierta a las " + hora + ":" + minutos);
    else
      System.out.println("Lo sentimos, nosotros abrimos de 10-14:30 y de 17:30-21");
    // menu();
  }
  
  //FUNCIÓN CONTAR GÉNEROS (Lee título y género de una cantidad de libros determinada por el usuario y cuenta cuántos hay de cada genero.)
  public static void contadorGeneros(String[][] libreria){
    int contador=0;
    for(int i=1; i<libreria.length; i++){
      String genero= libreria[i][2];
      for (int j=1; j<libreria.length;j++){
        if(libreria[j][2]==libreria[i][2] && (i!=j)){
          contador++;
        }
      }
      System.out.print(libreria[i][2] + "aparece: " + contador + " veces. ");
      contador=0;
    }
    // menu();
  }
  
  public static String[][] entraSale(String[][] libreria){
    boolean erroneo=false;
    int pregunta;
    do{
      System.out.print("Pulse 1.) si quiere añadir un nuevo libro. Pulse 2.) para eliminar un ejemplar");
      switch(sc.nextInt()){
        case 1:
          int i=1;
          while(i<libreria.length && libreria[i][0]!=""){
            i++;
          }
          if (i==libreria.length){
            System.out.println("Lo sentimos, no hay espacio en la biblioteca.");
          }else{
            System.out.print("¿Cómo se llama el libro que quieres añadir?");
            sc.nextLine();
            libreria[i][0]=sc.nextLine();
            System.out.println("Ya hemos almacenado tú libro");
          }
          erroneo = false;
          break;
        case 2:
          System.out.print("¿Cómo se llama el libro que quieres eliminar?");
          int j=1;
          sc.nextLine();
          String nombre =sc.nextLine();
          while(j<libreria.length && !libreria[j][0].equalsIgnoreCase(nombre)){
            j++;
          }
          if (j==libreria.length){
            System.out.println("Lo sentimos, no hay ningún libro llamado " + nombre+ " en la biblioteca.");
          }else{
            libreria[j][0]="";
            System.out.println("Ya hemos eliminado el libro");
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
  
  public static String[][] caracteristica(String[][] libreria){
    System.out.print("¿Cómo se llama el libro al que quiere añadirle una característica?");
    String nombre =sc.nextLine();
    int j=1;
    while(j<libreria.length && !libreria[j][0].equalsIgnoreCase(nombre)){
      j++;
    }
    if (j==libreria.length){
      System.out.println("Lo sentimos, no hay ningún libro llamado " + nombre+ " en la biblioteca.");
    }else{
      boolean erroneo=true;
      do{
        System.out.println("Pulse 1.) para cambiar el autor");
        System.out.println("Pulse 2.) para cambiar el género");
        System.out.println("Pulse 3.) para cambiar el año de publicación");
        System.out.println("Pulse 4.) para añadir una nueva valoración");
        System.out.println("Pulse 5.) para cambiar el número de páginas");
        System.out.println("Pulse 6.) para cambiar el marcador");
        int respuesta= sc.nextInt();
        sc.nextLine();
        switch (respuesta){
          case 1:
          case 2:
            System.out.print("Añade el nuevo valor");
            libreria[j][respuesta]=sc.nextLine();
            erroneo=false;
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
  
  public static void cuantosLibros(String[][] libreria){
    int s =0;
    for(int i=1; i<libreria.length; i++){
      if (libreria[i][0]!="")
        s++; 
    }
    System.out.println("Actualmente hay "+ s + " libros");
  }
  
  
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
  //Hace la media y redondea hacia abajo a entero 
  public static String valoracion(String valAnt){
    String valNuev;
    double valNuevDouble=0.0;
    double valAntDouble= string2int(valAnt);
    boolean estado=true;
    do{
      System.out.print("¿Del cero al 10 como te ha gustado el libro?");
      valNuevDouble= sc.nextDouble();
      if(valNuevDouble<=10&& valNuevDouble>=0)
        estado =false;
      else
        System.err.println("Error. Valor no válido");
    }while(estado);
    
    if (valAntDouble==0)
      return valNuev=""+ (int)valNuevDouble;
    else
      return valNuev=""+ (int)((valNuevDouble+valAntDouble)/2);
  }
  
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
      int marcInt =string2int(libreria[j][6]);
      if(marcInt==0)
        System.out.println("Todavia no has comenzado a leer este libro");
      else if(marcInt<pagInt)
        System.out.println("Vas por la página " + marcInt + ", es decir, te quedan " + (pagInt-marcInt) + " págs. para acabar.");
      else 
        System.out.println("Enhorabuena, ya has leido este libro");
    }
  }
  
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
      System.out.println( autor+ ""+genero+ ""+anyo+  ""+val+ ""+pag + ((autor=="ª")||(libreria[i][1].equalsIgnoreCase(autor)))+((genero=="ª")||(libreria[i][2].equalsIgnoreCase(genero)))+((anyo=="ª")||(libreria[i][3].equalsIgnoreCase(anyo)))+((val=="ª")||(libreria[i][4].equalsIgnoreCase(val)))+((pag=="ª")||(libreria[i][5].equalsIgnoreCase(pag))) );
      if(((autor=="ª")||(libreria[i][1].equalsIgnoreCase(autor))) 
           && ((genero=="ª")||(libreria[i][2].equalsIgnoreCase(genero)))
           &&((anyo=="ª")||(libreria[i][3].equalsIgnoreCase(anyo)))
           &&((val=="ª")||(libreria[i][4].equalsIgnoreCase(val)))
           &&((pag=="ª")||(libreria[i][5].equalsIgnoreCase(pag)))){
        System.out.println(libreria[i][0]);
      }
    }
  }
  
  
  public static void main (String[]args){
    //Inicializa un array (X filas->X-1 libros, 7 columnas->título+6 atributos)
    /*System.out.println("¿Cuántos libros necesitas para la libreria?");
    String[][] libreria=new String[sc.nextInt()+1][7]; 
    sc.nextLine();
    libreria[0][0]="TÍTULO";
    libreria[0][1]="AUTOR";
    libreria[0][2]="GÉNERO";
    libreria[0][3]="AÑO";
    libreria[0][4]="VALORACIÓN";
    libreria[0][5]="PÁGINAS";
    libreria[0][6]="MARCADOR";
    
    //Si no inicializo la matriz, ésta se llena de [null], lo cual me impide usar funciones de Strings (NullPointerException error)
    
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
    */String[][] libreria={
     {"T","A","G","A","V","P"},
     {"prueba1","paco","drama","111","3","123","50"},
     {"prueba2","pedro","drama","1234","3","123"},
     {"prueba3","paco","sex","111","8","123"},
     {"prueba4","paco","sex","1234","821","1785"}};
   
   
    marcapag(libreria);
    filtrar(libreria);
    //menu(libreria);
  } 
  
}