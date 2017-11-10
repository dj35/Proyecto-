import java.util.Scanner;
public class practica{
  
  final public static Scanner sc= new Scanner(System.in); //Declaro el Sccaner de manera global, de esta forma no tengo que declararlo en cada funcion
  
  public static void menu(){
    boolean estado = false;
    do{
      System.out.println("¿Qué le gustaría hacer?");
      System.out.println("Pulse 1 para ver si está abierta la tienda");
      System.out.println("Pulse 2 para añadir libros");
      System.out.println("Pulse 3 para ver los descuentos que dispones");
      System.out.println("Pulse 4 para apagar el programa");
      int opcion = sc.nextInt();
      switch (opcion){
        case 1:
          horario();
          estado = false;
          break;
        case 2:
          contadorGeneros();
          estado = false;
          break;
        case 3:
          System.out.println("Working in progress");
          estado =true;
        case 4:
            System.exit(0); //La funcion "System.exit(0)" termina el programa si el código esta correcto
            break;
        default:
          System.err.println("ERROR: Valor no válido");
          estado = true;
          break;
      }
    }while(estado);
  
  
  }
  
  public static boolean horaValida(int hora, int minutos){
    if(hora>=0 && hora <=24){
      if (minutos>=60 && minutos<=60)
        return true;
      else
        return false;
    }else 
      return false;
  }
  
  public static boolean horarioApertura(int hora, int minutos){
     if(hora>=10 && hora <=14){
      if ((hora==10 && minutos<0)|| (hora==14 &&minutos>30))
        return false;
      else
        return true;
     }else if(hora>=17 && hora<=21){
       if ((hora==17 && minutos<30)|| (hora==21 &&minutos>0))
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
      System.out.println("¿Quiere venir a las " + hora + ":" + minutos+ " ? {Y/N}");
      char respuesta= sc.next().charAt(0); //sólo si pones .charAt(x) puedes leer un caracter de un escaner, ya que lo que hace es coger el char en la posición "x" de un String
      switch (respuesta){
        case 'Y':
        case 'y':
          estado = false;
          break;
        default:
          estado = true;
      }
    }while(horaValida(hora,minutos)|| estado);
    if (horarioApertura(hora,minutos))
      System.out.println("Enhorabuena nuestra tienda está abierta a las " + hora + ":" + minutos);
    else
      System.out.println("Lo sentimos, nosotros abrimos de 10-14:30 y de 17:30-21");
  menu();
  }
  
  public static void contadorGeneros(){
    System.out.println("¿Cuántos libros le gustaría añadir?");
    int cantidad =sc.nextInt();
    sc.nextLine(); //Se debe limpiar el buffer de entrada si se van a leer datos de tipo carácter a continuación de la lectura de datos numéricos. La forma más sencilla de limpiar el buffer de entrada en Java es ejecutar la instrucción: sc.nextLine();
    String genero;
    int policial=0, thriller=0, romantica=0, aventura=0, terror=0, fantasia=0, cienciaFiccion=0, otros=0;
    for(int i=1; i<=cantidad; i++){
      System.out.println("¿Como se llama el libro?");
      sc.nextLine(); //Si utilizas algo que no sea un nextLine aquí va a dejar en el Buffer de entrada el caracter '\n', y por eso no va a ejecutar la lectura del siguiente Scanner de tipo nextLine
      System.out.println("¿A que género pertenece?");
      genero =sc.nextLine();
      switch (genero.toLowerCase()){ //Con ".toLowerCase()" pasas un String a minúsculas
        case "policial":
          policial++;
          break;
        case "thriller":
         thriller++;
          break;
        case "romantica":
          romantica++;
          break;
        case "aventura":
          aventura++;
          break;
        case "fantasia":
            fantasia++;
          break;
        case "terror":
          terror++;
          break;
        case "ciencia ficcion":
          cienciaFiccion++;
          break;
        default:
          otros++; 
      
      }
    }
      System.out.println("Policial: "+ policial);
      System.out.println("Thriller: "+ thriller);
      System.out.println("Romantica: "+ romantica);
      System.out.println("Aventura: "+ aventura);
      System.out.println("Fantasia: "+ fantasia);
      System.out.println("Terror: "+ terror);
      System.out.println("Ciencia Ficcion: "+ cienciaFiccion);
      System.out.println("Otros: "+ otros);
    menu();
}

  public static void main (String[]args){
    menu();
  } 



}
  
  
  
  
  
