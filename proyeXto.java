//
//VERSION CON PROBLEMAS PARA LLAMAR A LAS FUNCIONES CON ARRAYS; CORREGIDO EN V2
//
import java.util.Scanner;
public class proyeXto{
  
//FUNCIÓN MENÚ
  public static void menu(){
    System.out.println("Seleccione la opción que desea ejecutar: ");
    System.out.println("1. Añadir libro");
    System.out.println("2. Ver libreria ahora");
    System.out.println("3. Valorar libro");
    System.out.println("4. Contar libros según criterio");
    System.out.println("5. ¿Estamos abiertos?");
    System.out.println("6. ¿Tengo algún descuento?");
    System.out.println("7. Pedir recomendaciones");
//System.out.println("s/n. Ordenar libros según criterio");  ESTA SE COMENTA PORQUE LO MISMO NO SE IMPLEMENTA
    Scanner sc=new Scanner (System.in);
//Hay que meter el switch en menu en vez de main porque sino despues de hacer una de las opciones no vuelve al switch.   
    boolean seguir = false; 
    do{
      switch (sc.nextInt()){
        case 1:
          seguir=false;
          //anadirLibro(libreria, sc) no funciona si se le llama desde aqui...arreglado en v.2
          //en esta version solo se le llama desde main
          break;
        case 2:
          seguir=false;
          //verLibreria(libreria) no funciona si se le llama desde aqui...arreglado en v.2
          //en esta version solo se le llama desde main
          break;             
        case 3:
          seguir=false;
          break;
        case 4:
          seguir=false;
          contadorGeneros();
          break; 
        case 5:
          seguir=false;
          horario();
          break;
        case 6:
          seguir=false;
          descuento();
          break;
        case 7:
          seguir=false;
          break;
          
        default: 
          System.out.println("Opción incorrecta, pruebe otra vez");
          seguir=true;    
      }
    }while(seguir);
  }
  
  
//Comprueba que la hora está entre 0-24 y los minutos entre 0-60
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
  public static void horario(){
    int hora, minutos;
    Scanner dj=new Scanner(System.in);
//Lee hora y minutos y llama a la función haste que tenga un valor valido  
    do {
      System.out.println("Introduce la hora");
      hora = dj.nextInt();
      System.out.println("Introduce los minutos");
      minutos = dj.nextInt();
    } while (horaValida(hora, minutos));
//Abierta/cerrada
    if (horarioApertura(hora, minutos)){
      System.out.println("¡Qué bien! La librería está abierta");
    } else {
      System.out.println("Lo siento, la librería está cerrada...FeelsBadMan");
    }
    menu();
  }
  
  
//FUNCIÓN CONTAR GÉNEROS (Lee título y género de una cantidad de libros determinada por el usuario y cuenta cuántos hay de cada genero.)
  public static void contadorGeneros(){
    int cantidad;
    int genero1=0, genero2=0, genero3=0, genero4=0, genero5=0;
    Scanner dj=new Scanner(System.in);
    System.out.println("¿Cuántos libros vas a introducir?");
    cantidad= dj.nextInt();
    for (int i=0; i<cantidad; i++){
      System.out.println("Introduce el titulo del libro: ");
      String libro=dj.next();
      System.out.println("Introduce el numero correspondiente al género del libro:"+'\n'+"1. Genero A"+'\n'+"2. Genero B"+'\n'+"3. Genero C"+'\n'+"4. Genero D"+'\n'+"5. Genero E");
      int genero=dj.nextInt();
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
    menu();
  }
  
  
//FUNCIÓN DESCUENTOS
  public static void descuento(){
    Scanner dj=new Scanner(System.in);
    System.out.println("¿Qué edad tienes?");
    int edad=dj.nextInt();
    if (edad<18||edad>65){
      System.out.println("Genial tienes un descuento del 10% en todos los libros :)");
    }else{
      System.out.println("Vaya,prueba con otra cosa \n Pulse 1 Si es cliente premium de la librería\n Pulse 2 si tiene familia numerosa\n Pulse 3 si está en paro\n Pulse cualquier otro número si no cumle ninguno de los requisitos");
      int opcionDescuento=dj.nextInt();
      switch (opcionDescuento){
        case 1: case 2: case 3:
          System.out.println("Genial tienes un descuento del 10% en todos los libros :)");
          break;
        default:
          System.out.println("Vaya, no tienes ningún descuento");
          break;  
      }
    }
    menu();
  }
  
  
//FUNCIÓN VER LIBRERIA (tabla)
  public static void verLibreria(String[][]libreria){
    String verTabla= "";
    for (int i=0; i<7; i++){
      verTabla= "";
      for (int j=0; j<5; j++){
        verTabla+= "  "+libreria[i][j];         
      }
      System.out.println(verTabla);
    }
    //menu();
  }
  
//FUNCIÓN AÑADIR LIBRO
  public static void anadirLibro(String[][]libreria,Scanner sc){
    for (int j=1; j<7; j++){
      if (libreria[j][0]==""){
        System.out.println("Introduce el título:");
        libreria[j][0]=sc.next();
        System.out.println("Introduce el autor:");
        libreria[j][1]=sc.next(); 
        System.out.println("Introduce el género:");
        libreria[j][2]=sc.next(); 
        System.out.println("Introduce el año:");
        libreria[j][3]=sc.next(); 
        System.out.println("Introduce valoración:");
        libreria[j][4]=sc.next();
        break;
      } 
    }
    verLibreria(libreria);
  }
  
  
//MAIN    
  public static void main (String[]args){
    Scanner sc = new Scanner(System.in);
    //Inicializa un array (7 filas->6 libros, 5 columnas->título+4 atributos)
    String[][]libreria=new String[7][5]; 
    libreria[0][0]="TÍTULO";
    libreria[0][1]="AUTOR";
    libreria[0][2]="GÉNERO";
    libreria[0][3]="AÑO";
    libreria[0][4]="VALORACIÓN";
    for (int c=1; c<7; c++){
      for (int d=0; d<5; d++){
        libreria[c][d]="";
      }
    }
    //Para probar anadirLibro y verLibreria:
    anadirLibro(libreria, sc);
    anadirLibro(libreria, sc);
    menu();
    
  }
}
   
