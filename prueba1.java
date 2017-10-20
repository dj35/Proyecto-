import java.util.Arrays;

public class prueba1{
  public static void otroAutor (int a, String nombre, String[] libreria){
  libreria [a] = nombre;
  }
  
  public static void main (String [] args){
  String[] libreria = new String [10];
  otroAutor(4,"Pedro",libreria);
  
  System.out.println(Arrays.toString(libreria));
  
  }
}
