import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
/**
    *Esta clase ordena archivos por medio de numero de cuenta
    *@author: Pablo Giovanni Constantino Cruz
    *@author: Gustavo Coria Martinez
    *@author: Dulce María López Galicia
    *@version: 10.24.2021 

*/
public class Radix{
    /**
     * Metodo para ordenar datos por numero de cuenta de forma externa por radix
     * @param lista1 Es la lista de esclavos que se deben ordenar
     */
    public static void Radixd(List<Esclavo> lista1)throws IOException {
        List<Esclavo> lis0 = new LinkedList<>();
        List<Esclavo> lis1 = new LinkedList<>();
        List<Esclavo> lis2 = new LinkedList<>();
        List<Esclavo> lis3 = new LinkedList<>();
        List<Esclavo> lis4 = new LinkedList<>();
        List<Esclavo> lis5 = new LinkedList<>();
        List<Esclavo> lis6 = new LinkedList<>();
        List<Esclavo> lis7 = new LinkedList<>();
        List<Esclavo> lis8 = new LinkedList<>();
        List<Esclavo> lis9 = new LinkedList<>();//318164838
        List<Esclavo> listads = lista1 ;
        String[] aux = new String[1];
        int i,j,h=8,z,b,k=0,gg=1;
        while((h+1)>0){
                System.out.println("iteracion: "+gg);
                ++gg; 
                while(listads.size()!=0){
                    aux[0] = String.valueOf(listads.get(0).getNum());
                    b=Integer.valueOf(aux[0].charAt(h));
                    switch(b){
                        case 48://0
                            lis0.add(listads.get(0));
                            listads.remove(0);
                        break;
                        case 49://1
                            lis1.add(listads.get(0));
                            listads.remove(0);
                        break;
                        case 50:
                            lis2.add(listads.get(0));
                            listads.remove(0);
                        break;
                        case 51:
                            lis3.add(listads.get(0));
                            listads.remove(0);
                        break;
                        case 52:
                            lis4.add(listads.get(0));
                            listads.remove(0);
                        break;
                        case 53:
                            lis5.add(listads.get(0));
                            listads.remove(0);
                        break;
                        case 54:
                            lis6.add(listads.get(0));
                            listads.remove(0);
                        break;
                        case 55:
                            lis7.add(listads.get(0));
                            listads.remove(0);
                        break;
                        case 56://8
                            lis8.add(listads.get(0));
                            listads.remove(0);
                        break;
                        case 57://9
                            lis9.add(listads.get(0));
                            listads.remove(0);
                        break;
                    }
                }
                System.out.print("F0= [");
                    for(i=0;i<lis0.size();i++){
                        System.out.print(lis0.get(i).getNum()+", ");
                    }
                System.out.println();
                System.out.print("F1= [");
                    for(i=0;i<lis1.size();i++)
                        System.out.print(lis1.get(i).getNum()+", ");
                    System.out.println();
                System.out.print("F2= [");
                    for(i=0;i<lis2.size();i++)
                        System.out.print(lis2.get(i).getNum()+", ");
                    System.out.println();
                System.out.print("F3= [");
                    for(i=0;i<lis3.size();i++)
                        System.out.print(lis3.get(i).getNum()+", ");
                    System.out.println();
                System.out.print("F4= [");
                    for(i=0;i<lis4.size();i++)
                        System.out.print(lis4.get(i).getNum()+", ");
                    System.out.println();
                System.out.print("F5= [");
                    for(i=0;i<lis5.size();i++)
                        System.out.print(lis5.get(i).getNum()+", ");
                    System.out.println();
                System.out.print("F6= [");
                    for(i=0;i<lis6.size();i++)
                        System.out.print(lis6.get(i).getNum()+", ");
                    System.out.println();
                System.out.print("F7= [");
                    for(i=0;i<lis7.size();i++)
                        System.out.print(lis7.get(i).getNum()+", ");
                    System.out.println();
                System.out.print("F8= [");
                    for(i=0;i<lis8.size();i++)
                        System.out.print(lis8.get(i).getNum()+", ");
                    System.out.println();
                System.out.print("F9= [");
                    for(i=0;i<lis9.size();i++)
                        System.out.print(lis9.get(i).getNum()+", ");
                    System.out.println();
                if(lis0.isEmpty()==false){
                    for (z = 0; z<lis0.size(); z++){
                        listads.add(lis0.get(z));
                    }
                    lis0.clear();
                }
                if(lis1.isEmpty()==false){
                    for (z = 0; z<lis1.size(); z++){
                        listads.add(lis1.get(z));
                    }
                    lis1.clear();
                }
                if(lis2.isEmpty()==false){
                    for (z = 0; z<lis2.size(); z++){
                        listads.add(lis2.get(z));
                    }
                    lis2.clear();
                }
                if(lis3.isEmpty()==false){
                    for (z = 0; z<lis3.size(); z++){ 
                        listads.add(lis3.get(z));
                    }
                    lis3.clear();
                }
                if(lis4.isEmpty()==false){
                    for (z = 0; z<lis4.size(); z++){
                        listads.add(lis4.get(z));
                    }
                    lis4.clear();
                }
                if(lis5.isEmpty()==false){
                    for (z = 0; z<lis5.size(); z++){
                        listads.add(lis5.get(z));
                    }
                    lis5.clear();
                }
                if(lis6.isEmpty()==false){
                    for (z = 0; z<lis6.size(); z++){ 
                        listads.add(lis6.get(z));
                    }
                    lis6.clear();
                }
                if(lis7.isEmpty()==false){
                    for (z = 0; z<lis7.size(); z++){
                        listads.add(lis7.get(z));
                    }
                    lis7.clear();
                }
                if(lis8.isEmpty()==false){
                    for (z = 0; z<lis8.size(); z++){
                        listads.add(lis8.get(z));
                    }
                    lis8.clear();
                }
                if(lis9.isEmpty()==false){
                    for (z = 0; z<lis9.size(); z++){
                        listads.add(lis9.get(z));
                    }
                    lis9.clear();
                }
                --h;
        }
        System.out.println("<------------------------------------------------------DATOS ENVIADOS AL ARCHIVO------------------------------------------>");
        Imp(listads);
    }//Cierre del metodo

    /**
     * Metodo para imprimir en un archivo los datos de los esclavos de cada lista de listas
     * @param a Es la lista de listas de esclavos 
     */
    public static void Imp(List<Esclavo> a) throws IOException {
        String a1="Radix.txt";
        PrintWriter imp;
        imp = new PrintWriter (new FileWriter(a1, true ));
            System.out.print("\n[");
            for(int i=0;i<a.size();i++){
                System.out.print(a.get(i).getNom()+", "+a.get(i).getApe()+", "+a.get(i).getNum()+" || ");
                imp.println(a.get(i).getNom()+", "+a.get(i).getApe()+", "+a.get(i).getNum()+" || ");
            }
            System.out.print("]\n");
        imp.close();
    }//Cierre del metodo
}