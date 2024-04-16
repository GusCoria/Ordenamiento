import java.io.*;//
import java.util.List;//
import java.util.LinkedList;//listas de listas 
import java.util.Scanner;//datos que escribe el usuario desde el teclado
import java.nio.file.Path;
import java.nio.file.Files;
/**
    *Clase principal con las opciones de los algortimos de ordenamiento de polifase, mezcla equilibrada y radix
    *@author: Gustavo Coria Martinez
    *@version: 10.24.2021 

*/

public class Main{
    public static void main(String[] args)throws IOException{//leer escaner del dielreader
    Scanner stdIn = new Scanner(System.in);
    Scanner st = new Scanner(System.in);
    List<Esclavo>  alu =  new LinkedList<Esclavo>();//Lista que contiene todos los datos del archivo
    List<Esclavo>  alu1 =  new LinkedList<Esclavo>();//Lista de Polifase
    List<Esclavo>  alu2 =  new LinkedList<Esclavo>();//Lista de Mezcla E
    List<Esclavo>  alu3 =  new LinkedList<Esclavo>();//Lista de radix
    int opc=0;//Variable que guarda lo que escribe el usuario de las opciones ordenamiento
    //int ;
    Scanner fileIn;
    String line,leer,nom,ape,aa,numC;
    try {
        System.out.print("Introduzca el nombre del archivo: ");
        fileIn = new Scanner(new FileReader(stdIn.nextLine()));//leer el archivo
        while (fileIn.hasNextLine()) {//ciclo que guarda los datos
            line = fileIn.nextLine();
            String[]  sep = line.split(",");//hacemos la separacion por medio de una coma para 
                nom = sep[0];//nombre en la casilla 0
                ape = sep[1];//apellido en la casilla 1
                numC = sep[2];//numero en casilla 2
                Esclavo  E1 = new Esclavo(nom,ape,numC);//Se agrega a un constructor para volverse un objeto
                alu.add(E1);//se agrega a la lista alu con todos los datos
            System.out.println(line);//se imprime la linea en el cmd 
         }
        fileIn.close();//se cirra el escaner
    }
    catch (FileNotFoundException e){
         System.out.println("Error: " + e.getMessage());
    }
    for(int i=0;i<alu.size();i++){//ciclo el cual copia todos los datos que tiene la primer lista 
            alu1.add(alu.get(i));//Polifase
            alu2.add(alu.get(i));//Mezcla E
            alu3.add(alu.get(i));//Radix
    }
    System.out.print("\t |Ordenamiento| \n");
    do{
    System.out.print("1)Polifase\n");
    System.out.print("2)Mezcla Equilibrada\n");
    System.out.print("3)Radix\n");
    System.out.print("4)Salir\n");
    opc = st.nextInt();
        switch (opc){
          case 1://Polifase
              Polifase.Poli(alu1);
          break;
          case 2://Mezcla Equilibrada
            MezclaE.Mezcla(alu2);
          break;
          case 3:// Método por distribución (Radix)
                Radix.Radixd(alu3);
            break;
          }
        }while(opc!=4);
    } 
} 
