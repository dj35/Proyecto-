import java.util.Scanner;
public class correccion{

  // Vamos a definir la funci�n de men�
  
  public static int menu(){
    
    System.out.println("Seleccione la opci�n que desea ejecutar: ");
    System.out.println("1. A�adir libro");
    System.out.println("2. Pedir recomendaciones");
    System.out.println("3. Valorar libro");
    System.out.println("4. Contar libros seg�n criterio");
    System.out.println("5. �Estamos abiertos?");
    System.out.println("6. �Tengo alg�n descuento?");
    //System.out.println("s/n. Ordenar libros seg�n criterio");  ESTA SE COMENTA PORQUE LO MISMO NO SE IMPLEMENTA

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
        System.out.println("Opci�n incorrecta, pruebe otra vez");
        seguir=true;
        
    }
    }while(seguir);
}
}