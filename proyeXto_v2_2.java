//VERSION FUNCIONAL CON ARRAYS
import java.util.Scanner;
public class proyeXto_v2_2{
  
//FUNCIÓN MENÚ
  public static void menu(String[][]libreria, Scanner sc){
    System.out.println("Seleccione la opción que desea ejecutar: ");
    System.out.println("1. Añadir libro");
    System.out.println("2. Ver libreria ahora");
    System.out.println("3. Valorar libro");
    System.out.println("4. Contar libros según criterio");
    System.out.println("5. ¿Estamos abiertos?");
    System.out.println("6. ¿Tengo algún descuento?");
    System.out.println("7. Pedir recomendaciones");
    System.out.println("8. Ordenar libros según criterio"); 
    
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
          recomienda(libreria,sc);
          break;
        case 8:
          seguir=false;
          ordenar(libreria,sc);
          break;
          
        default: 
          System.out.println("Opción incorrecta, pruebe otra vez");
          seguir=true;    
      }
    }while(seguir);
  }
  
//Convienrte un string(que sea un numero positivo) en un int
  public static int str2int(String cadena){
    int numero=0;
    for (int i=0; i<cadena.length(); i++){
      numero+=(cadena.charAt(cadena.length()-1-i)-'1'+1)*Math.pow(10,i);
    }
    return numero;
  }

      
//Comprueba que la hora está entre 0-24 y los minutos entre 0-60
  public static boolean horaValida(int hora, int minutos){
    if (hora>=0 && hora<24 && minutos>=0 && minutos<60){
      return false;
    } else {
      System.err.println("Error");
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
//Lee hora y minutos y llama a la función haste que tenga un valor valido  
    do {
      System.out.println("Introduce la hora");
      hora = sc.nextInt();
      System.out.println("Introduce los minutos");
      minutos = sc.nextInt();
    } while (horaValida(hora, minutos));
//Abierta/cerrada
    if (horarioApertura(hora, minutos)){
      System.out.println("¡Qué bien! La librería está abierta");
    } else {
      System.out.println("Lo siento, la librería está cerrada...");
    }
    menu(libreria, sc);
  }
  
  
//FUNCIÓN CONTAR GÉNEROS (Lee título y género de una cantidad de libros determinada por el usuario y cuenta cuántos hay de cada genero.)
//ESTA NECESITA UN REWORK CON ARRAYS
  public static void contadorGeneros(String[][]libreria, Scanner sc){
    int cantidad;
    int genero1=0, genero2=0, genero3=0, genero4=0, genero5=0;
    System.out.println("¿Cuántos libros vas a introducir?");
    cantidad= sc.nextInt();
    for (int i=0; i<cantidad; i++){
      System.out.println("Introduce el titulo del libro: ");
      String libro=sc.next();
      System.out.println("Introduce el numero correspondiente al género del libro:"+'\n'+"1. Genero A"+'\n'+"2. Genero B"+'\n'+"3. Genero C"+'\n'+"4. Genero D"+'\n'+"5. Genero E");
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
  
  
//FUNCIÓN DESCUENTOS
  public static void descuento(String[][]libreria, Scanner sc){
    System.out.println("¿Qué edad tienes?");
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
    menu(libreria, sc);
  }
  
  
//FUNCIÓN VER LIBRERIA (en forma de tabla)
  public static void verLibreria(String[][]libreria, Scanner sc){
    String verTabla= "";
    for (int i=0; i<libreria.length; i++){
      verTabla= "";
      for (int j=0; j<libreria[i].length; j++){
        verTabla+= "  "+libreria[i][j];         
      }
      System.out.println(verTabla);
    }
    menu(libreria, sc);
  }
  
  
//FUNCIÓN AÑADIR LIBRO (con sus atributos)
  public static void anadirLibro(String[][]libreria,Scanner sc){
    boolean yaEsta=true;
    for (int j=1; j<libreria.length; j++){
      if (yaEsta){
        if (libreria[j][0]==null){
          System.out.println("Introduce el título:");
          libreria[j][0]=sc.next();
          System.out.println("Introduce el autor:");
          libreria[j][1]=sc.next(); 
          //Obligar a que meta un genero correcto
          boolean repetir=true; 
          do{
            System.out.println("Introduce el género:");
            System.out.println(" 1. Policial \n 2. Thriller \n 3. Romantico \n 4. Aventura \n 5. Fantasia \n 6. Terror \n 7. Ciencia Ficcion");
            libreria[j][2]=sc.next();                   
            if ((libreria[j][2].toLowerCase().equals("policial"))||(libreria[j][2].toLowerCase().equals("thriller"))||(libreria[j][2].toLowerCase().equals("romantico"))||(libreria[j][2].toLowerCase().equals("aventura"))||(libreria[j][2].toLowerCase().equals("fantasia"))||(libreria[j][2].toLowerCase().equals("terror"))||(libreria[j][2].toLowerCase().equals("ciencia ficcion"))){
             repetir=false;
            }
          } while (repetir);
          //Obligar a que meta año correcto
          boolean seguir=true;
          do{
            System.out.println("Introduce el año:");
            libreria[j][3]=sc.next();
            for (int i=0; i<2019; i++){
              if (str2int(libreria[j][3])==i){
                seguir=false;
              }
            }
          } while (seguir);
          yaEsta=false;
        } 
      }
    }
    verLibreria(libreria, sc);
  }
  

//FUNCION VALORAR LIBRO
  public static void valorarLibro(String[][]libreria, Scanner sc){
    System.out.println("¿Qué libro quieres valorar?");
    //Muestra los libros
    for(int l=1; l<libreria.length; l++){
      if ((libreria[l][0]!=null)){
        System.out.println(l+". "+libreria[l][0]);       
      }
    }
    //Modifica la valoración solo si existe el libro
    int numLibro=sc.nextInt();
    if (libreria[numLibro][0]==null){
      System.out.println("No trolles, no hay nada ahí!");
    } else {
      System.out.println("Introduce/modifica la valoración:");
      libreria[numLibro][4]=sc.next();
    }
    menu(libreria, sc);
  }
  
    
//FUNCION PEDIR RECOMENDACIONES
  //La idea es que el usuario indique un género que le guste y la función le devuelva el ejemplar de ese género con mejor valoración
  public static void recomienda (String[][]libreria, Scanner sc){
    System.out.println("¿Cuál es tu género favorito?");
    // Mostrar las distintas opciones
    System.out.println(" 1. Policial \n 2. Thriller \n 3. Romántico \n 4. Aventura \n 5. Fantasía \n 6. Terror \n 7. Ciencia Ficción");
    String gen =sc.next().toLowerCase();
    int maximaValoracion = 0;
    String libroRecomendado = "";
    for(int g=1; g<libreria.length; g++){
      if(libreria[g][2].equals(gen)){
        if(str2int(libreria[g][4])>=maximaValoracion){
          maximaValoracion = str2int(libreria[g][4]);
          libroRecomendado = libreria[g][0];
        }
      }
    }
    if(libroRecomendado!=""){
      System.out.println("Quizás te guste " + libroRecomendado + ". Seguro que lo disfrutas :)");
    }
    else{System.out.println("Lo siento, no tenemos recomendaciones para ese género :/");
    }
    menu(libreria, sc);
  }
  
  
//FUNCIÓN ORDENAR LIBROS SEGÚN CRITERIO (ordena la libreria original, es criminal hacerlo en otro array)
  public static void ordenar(String[][]libreria, Scanner sc){
    System.out.println("Elige un criterio de ordenación: \n 1. Género \n 2. Valoración \n 3. Año");
    switch (sc.next().charAt(0)){
      case '1':
        //Compara filas buscando el mismo genero:
        for (int i=1; i<libreria.length; i++){
        int n=0;
        for (int j=i+1; j<libreria.length; j++){
          if (libreria[j][2]!=null && libreria[i][2].equals(libreria[j][2])){
            n+=1;
            //Permuta fila i+n y fila j:
            String[]aux=new String[libreria[0].length];
            for (int k=0; k<libreria[0].length; k++){
              aux[k]=libreria[i+n][k];
              libreria[i+n][k]=libreria[j][k];
              libreria[j][k]=aux[k];
            }
          }
        }
      }
        verLibreria(libreria, sc); 
        break;
      case '2':
        //Compara filas a partir de i buscando la maxima valoracion:
        for (int i=1; i<libreria.length-1; i++){
        int max=i;
        for (int j=i+1; j<libreria.length; j++){
          if(libreria[j][4]!=null && str2int(libreria[j][4])>str2int(libreria[max][4])){
            max=j;
          }
        }        
        if(i!=max){
          //Permuta fila i y fila max:
          String[]aux=new String[libreria[0].length];
          for (int k=0; k<libreria[0].length; k++){
            aux[k]=libreria[i][k];
            libreria[i][k]=libreria[max][k];
            libreria[max][k]=aux[k];
          }
        }
      }
        verLibreria(libreria, sc);  
        break;
      case '3':
        //Funciona igual que la valoracion
        for (int i=1; i<libreria.length-1; i++){
        int max=i;
        for (int j=i+1; j<libreria.length; j++){
          if(libreria[j][3]!=null && str2int(libreria[j][3])>str2int(libreria[max][3])){
            max=j;
          }
        }
        if(i!=max){
          String[]aux=new String[libreria[0].length];
          for (int k=0; k<libreria[0].length; k++){
            aux[k]=libreria[i][k];
            libreria[i][k]=libreria[max][k];
            libreria[max][k]=aux[k];
          }
        }
      }
        verLibreria(libreria, sc);        
      default:
        menu(libreria, sc);
    }
  }
  
 
//MAIN    
  public static void main (String[]args){
    //Ya solo hace falta este scanner para todas las funciones
    Scanner sc = new Scanner(System.in);
    //Inicializa un array (7 filas->6 libros, 5 columnas->título+4 atributos)
    String[][]libreria=new String[8][5]; 
    libreria[0][0]="TÍTULO";
    libreria[0][1]="AUTOR";
    libreria[0][2]="GÉNERO";
    libreria[0][3]="AÑO";
    libreria[0][4]="VALORACIÓN";
    //He metido esto para probar funciones sin tener que introducir libros
    libreria[1][0]="Tit1";
    libreria[1][1]="Aut1";
    libreria[1][2]="Gen1";
    libreria[1][3]="1985";
    libreria[1][4]="10";
    libreria[2][0]="Tit2";
    libreria[2][1]="Aut2";
    libreria[2][2]="Gen2";
    libreria[2][3]="1995";
    libreria[2][4]="5";
    libreria[3][0]="Tit3";
    libreria[3][1]="Aut3";
    libreria[3][2]="Gen1";
    libreria[3][3]="2000";
    libreria[3][4]="7";
    libreria[4][0]="Tit4";
    libreria[4][1]="Aut4";
    libreria[4][2]="Gen1";
    libreria[4][3]="1999";
    libreria[4][4]="8"; 
    menu(libreria, sc);
  }
}