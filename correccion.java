//
//TODO ESTO YA ESTA METIDO EN PROYEXTO.java
//
import java.util.Scanner;
public class correccion{

  // Vamos a definir la función de menú
  
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
  public static int filtrarHora (){
    Scanner sc = new Scanner(System.in);
    int h,m;
    h= sc.nextInt();
    m= sc.nextInt();
    
    if(h>=0 && h<24){
    return h;
    }
    else{
    System.out.println("Lo has hecho mal");
     filtrarHora();
    }
    public static int filtrarHora (){
      
      Scanner sc = new Scanner(System.in);
    int h,m;
    h= sc.nextInt();
  if(m>=0 && m<59){
    return m;
    }
    else{
    System.out.println("Lo has hecho mal");
     filtrarHora();
    }
  }
  
  
  public static void main(String [] args){
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
        break;
      case 5:
        
        seguir=false;
        break;
        
      case 6:
        seguir=false;
        break;
        
      default: 
        System.out.println("Opción incorrecta, pruebe otra vez");
        seguir=true;
        
    }
    }while(seguir);
}
}
