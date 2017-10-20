import java.util.Scanner;
public class proyeXto{
  
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
          break;
      }
    }
    System.out.println("Genero A: "+genero1+" libros"+'\n'+"Genero B: "+genero2+" libros"+'\n'+"Genero C: "+genero3+" libros"+'\n'+"Genero D: "+genero4+" libros"+'\n'+"Genero E: "+genero5+" libros");
  }
       
  
  public static void main (String[]args){
//A estas funciones las llamamos desde la funcion menu.
    horario();
    contadorGeneros();
 }
}