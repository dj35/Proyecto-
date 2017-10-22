import java.util.Scanner;
public class proyeXto{
  
//Vamos a definir la función de menú
public static int menu(){
  System.out.println("Seleccione la opción que desea ejecutar: ");
  System.out.println("1. Añadir libro");
  System.out.println("2. Pedir recomendaciones");
  System.out.println("3. Valorar libro");
  System.out.println("4. Contar libros según criterio");
  System.out.println("5. ¿Estamos abiertos?");
  System.out.println("6. ¿Tengo algún descuento?");
//System.out.println("s/n. Ordenar libros según criterio");  ESTA SE COMENTA PORQUE LO MISMO NO SE IMPLEMENTA

  Scanner sc = new Scanner(System.in);
  return sc.nextInt();
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

//Funcion principal horario (llama a horaValida para ver si la hora es valida y a horarioApertura para ver si esta en el rango de horas correspondiente
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
  
//Lee título y género de una cantidad de libros determinada por el usuario y cuenta cuántos hay de cada genero.
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
    
//Descuentos
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
        
  
  public static void main (String[]args){
    boolean seguir = false;
    do{
      switch (menu()){
      case 1:
        seguir=false;
        break;
        
      case 2:
        seguir=false;
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
        
      default: 
        System.out.println("Opción incorrecta, pruebe otra vez");
        seguir=true;    
      }
    }while(seguir);
  }
}