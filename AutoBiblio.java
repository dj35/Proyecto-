import java.util.Scanner;
public class AutoBiblio{
  
 final public static Scanner sc= new Scanner(System.in); //Declaro el Scanner de manera global, de esta forma no tengo que declararlo en cada funcion
  
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
          descuento();
          estado=true;
          break;
        case 4:
          System.exit(0); 
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
  menu();
  }
  
  public static void contadorGeneros(){
    System.out.println("¿Cuántos libros le gustaría añadir?");
    int cantidad =sc.nextInt();
    sc.nextLine(); 
    String genero;
    int policial=0, thriller=0, romantica=0, aventura=0, terror=0, fantasia=0, cienciaFiccion=0, otros=0;
    for(int i=1; i<=cantidad; i++){
      System.out.println("¿Como se llama el libro?");
      sc.nextLine(); 
      System.out.println("¿A qué género pertenece?");
      genero =sc.nextLine();
      switch (genero.toLowerCase()){
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
      System.out.println("Romántica: "+ romantica);
      System.out.println("Aventura: "+ aventura);
      System.out.println("Fantasía: "+ fantasia);
      System.out.println("Terror: "+ terror);
      System.out.println("Ciencia Ficción: "+ cienciaFiccion);
      System.out.println("Otros: "+ otros);
    menu();
}

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
    menu();
  }

  public static void main (String[]args){
    menu();
  } 

}

