//VERSION FUNCIONAL CON ARRAYS
import java.util.Scanner;
public class proyeXto_v2{
  
//FUNCI�N MEN�
  public static void menu(String[][]libreria, Scanner sc){
    System.out.println("Seleccione la opci�n que desea ejecutar: ");
    System.out.println("1. A�adir libro");
    System.out.println("2. Ver libreria ahora");
    System.out.println("3. Valorar libro");
    System.out.println("4. Contar libros seg�n criterio");
    System.out.println("5. �Estamos abiertos?");
    System.out.println("6. �Tengo alg�n descuento?");
    System.out.println("7. Pedir recomendaciones");
//System.out.println("s/n. Ordenar libros seg�n criterio");  ESTA SE COMENTA PORQUE LO MISMO NO SE IMPLEMENTA
    
//Hay que meter el switch en menu en vez de main porque sino despues de hacer una de las opciones no vuelve al switch.   
    boolean seguir = false; 
    do{
      switch (sc.nextInt()){
        case 1:
          seguir=false;
          anadirLibro(libreria, sc); 
          break;
        case 2:
          seguir=false;
          verLibreria(libreria, sc); 
          break;             
        case 3:
          seguir=false;
          valorarLibro(libreria, sc);
          break;
        case 4:
          seguir=false;
          contadorGeneros(libreria, sc);
          break; 
        case 5:
          seguir=false;
          horario(libreria, sc);
          break;
        case 6:
          seguir=false;
          descuento(libreria, sc);
          break;
        case 7:
          seguir=false;
          //falta esta
          break;
          
        default: 
          System.out.println("Opci�n incorrecta, pruebe otra vez");
          seguir=true;    
      }
    }while(seguir);
  }
  
  
//Comprueba que la hora est� entre 0-24 y los minutos entre 0-60
  public static boolean horaValida(int hora, int minutos){
    if (hora>=0 && hora<24 && minutos>=0 && minutos<60){
      return false;
    } else {
      System.out.println("Error");
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
  public static void horario(String[][]libreria, Scanner sc){
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
      System.out.println("�Qu� bien! La librer�a est� abierta");
    } else {
      System.out.println("Lo siento, la librer�a est� cerrada...FeelsBadMan");
    }
    menu(libreria, sc);
  }
  
  
//FUNCI�N CONTAR G�NEROS (Lee t�tulo y g�nero de una cantidad de libros determinada por el usuario y cuenta cu�ntos hay de cada genero.)
  public static void contadorGeneros(String[][]libreria, Scanner sc){
    int cantidad;
    int genero1=0, genero2=0, genero3=0, genero4=0, genero5=0;
    System.out.println("�Cu�ntos libros vas a introducir?");
    cantidad= sc.nextInt();
    for (int i=0; i<cantidad; i++){
      System.out.println("Introduce el titulo del libro: ");
      String libro=sc.next();
      System.out.println("Introduce el numero correspondiente al g�nero del libro:"+'\n'+"1. Genero A"+'\n'+"2. Genero B"+'\n'+"3. Genero C"+'\n'+"4. Genero D"+'\n'+"5. Genero E");
      int genero=sc.nextInt();
      switch (genero){
        case 1:
          genero1 += 1;
          break;
        case 2:
          genero2 += 1;
          break;
        case 3:
          genero3 += 1;
          break;
        case 4:
          genero4 += 1;
          break;
        case 5:
          genero5 += 1;
          break;
        default:
          System.out.println("Error");
          break;
      }
    }
    System.out.println("Genero A: "+genero1+" libros"+'\n'+"Genero B: "+genero2+" libros"+'\n'+"Genero C: "+genero3+" libros"+'\n'+"Genero D: "+genero4+" libros"+'\n'+"Genero E: "+genero5+" libros");
    menu(libreria, sc);
  }
  
  
//FUNCI�N DESCUENTOS
  public static void descuento(String[][]libreria, Scanner sc){
    System.out.println("�Qu� edad tienes?");
    int edad=0;
    //Evitar edad negativa
    boolean repetir=true;
    while(repetir){
      edad=sc.nextInt();
      if (edad>0){
        repetir = false;
      } else {
        System.out.println("Introduce la edad correctamente");
      }
    }
    //Descuentos
    if (edad<18||edad>65){
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
    menu(libreria, sc);
  }
  
  
//FUNCI�N VER LIBRERIA (en forma de tabla)
  public static void verLibreria(String[][]libreria, Scanner sc){
    String verTabla= "";
    for (int i=0; i<7; i++){
      verTabla= "";
      for (int j=0; j<5; j++){
        verTabla+= "  "+libreria[i][j];         
      }
      System.out.println(verTabla);
    }
    menu(libreria, sc);
  }
  
  
//FUNCI�N A�ADIR LIBRO (con sus atributos)
  public static void anadirLibro(String[][]libreria,Scanner sc){
    for (int j=1; j<7; j++){
      if (libreria[j][0]==""){
        System.out.println("Introduce el t�tulo:");
        libreria[j][0]=sc.next();
        System.out.println("Introduce el autor:");
        libreria[j][1]=sc.next(); 
        System.out.println("Introduce el g�nero:");
        libreria[j][2]=sc.next(); 
        System.out.println("Introduce el a�o:");
        libreria[j][3]=sc.next(); 
        break;
      } 
    }
    verLibreria(libreria, sc);
  }
  

//FUNCION VALORAR LIBRO
  public static void valorarLibro(String[][]libreria, Scanner sc){
    System.out.println("�Qu� libro quieres valorar?");
    //Muestra los libros
    for(int l=1; l<7; l++){
      if (libreria[l][0]!=""){
        System.out.println(l+". "+libreria[l][0]);
      }
    }
    //Modifica la valoraci�n solo si existe el libro
    int numLibro=sc.nextInt();
    if (libreria[numLibro][0]==""){
      System.out.println("No trolles, no hay nada ah�!");
    } else {
      System.out.println("Introduce/modifica la valoraci�n:");
      libreria[numLibro][4]=sc.next();
    }
    menu(libreria, sc);
  }
     
    
//FUNCION PEDIR RECOMENDACIONES?
  
  
//MAIN    
  public static void main (String[]args){
    Scanner sc = new Scanner(System.in);
    //Inicializa un array (7 filas->6 libros, 5 columnas->t�tulo+4 atributos)
    String[][]libreria=new String[7][5]; 
    libreria[0][0]="T�TULO";
    libreria[0][1]="AUTOR";
    libreria[0][2]="G�NERO";
    libreria[0][3]="A�O";
    libreria[0][4]="VALORACI�N";
    for (int c=1; c<7; c++){
      for (int d=0; d<5; d++){
        libreria[c][d]="";
      }
    }
    menu(libreria, sc);
  }
}
   