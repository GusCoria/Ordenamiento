import java.util.List;
import java.util.LinkedList; 
import java.io.*;
/**
    *Esta clase ordena archivos por medio de apellidos y utiliza el metodo de ordenamiento externo polifase
    *@author: Pablo Giovanni Constantino Cruz
    *@author: Gustavo Coria Martinez
    *@author: Dulce María López Galicia
    *@version: 10.24.2021 

*/
class Polifase{
	/**
     * Metodo para ordenar datos por apellido de forma externa por Polifase
     * @param a Es la lista de esclavos que se deben ordenar
     */
	public static void Poli(List<Esclavo> a)throws IOException{
		int i,h=0,c=0;
		int j;
		int count =a.size(); 
		List<List<Esclavo>> F0 = new LinkedList<>();//
		List<List<Esclavo>> F1 = new LinkedList<>();//
		List<List<Esclavo>> F2 = new LinkedList<>();//
		List<List<Esclavo>> F3 = new LinkedList<>();//
		List<Esclavo>  F00 =  a;
		System.out.println("<--------------------------------------------------------------F0---------------------------------------------------------->");
		for(i=0;i<F00.size();i++)
            System.out.println(F00.get(i).getNom()+", "+F00.get(i).getApe()+", "+F00.get(i).getNum()+" || ");
		while(count!=0 ){//
			F1.add(new LinkedList<Esclavo>());//añaden un bloque F1
			F2.add(new LinkedList<Esclavo>());//añaden un bloque F2
			for(i=0; i<2;i++){//se repite 2 veces
				if(count!=0){
					F1.get(h).add(F00.get(0));
					F00.remove(0);
					--count;
				}
				else {
					break;
				}
			}
			for(i=0; i<2;i++){//se repite 2 veces
				if(count!=0){//verificacion de que no es cero
					F2.get(h).add(F00.get(0));//añade el objeto a la lsita de listas
					F00.remove(0);//elimina el primer objeto
					--count;
				}
				else {
					break;
				}
			}
			++h;
		}
		selectionSort(F1);
		selectionSort(F2);
		System.out.println("<--------------------------------------------------------------F1---------------------------------------------------------->");
		imp(F1);
		System.out.println("<--------------------------------------------------------------F2---------------------------------------------------------->");
		imp(F2);
		while(F1.size()!=0){
			int b = F1.size();
			c=0;
			if(F1.size()==1){//
				F0.add(new LinkedList<Esclavo>());//añade un espacio de bloque
				F0.get(0).addAll(F1.get(0));//se añade todos los objetos del bloque F1 en laposicion 0, añadiendose al bloque F0 
				F0.get(0).addAll(F2.get(0));//se añade todos los objetos del bloque F2 en laposicion 0
				F1.remove(0);//Estan vacias las listas
				F2.remove(0);//
				selectionSort(F0);//El ultimo ordenamiento
				System.out.println("<--------------------------------------------------------------F0---------------------------------------------------------->");
				imp(F0);
				break;//Se sale del ciclo while de la linea 60
			}
			while(b!=0){//Se repite hasta que la lista F1 este completamente vacia
				F0.add(new LinkedList<Esclavo>());//se hace espacio de bloque
				F3.add(new LinkedList<Esclavo>());//se hace espacio de bloque
				for(i=0;i<1;i++){//union de bloques en F0
					F0.get(i+c).addAll(F1.get(i));
					F0.get(i+c).addAll(F2.get(i));
					F1.remove(0);
					F2.remove(0);
					--b;
				}
				if(b==0){
					selectionSort(F0);
					selectionSort(F3);
					System.out.println("<--------------------------------------------------------------F0---------------------------------------------------------->");
					imp(F0);
					System.out.println("<--------------------------------------------------------------F3---------------------------------------------------------->");
					imp(F3);
					break;//se sale del ciclo en dado caso de que F1 este ya completamente vacia 
				}
				for(i=0;i<1;i++){//union de bloques en F3
					F3.get(i+c).addAll(F1.get(i));
					F3.get(i+c).addAll(F2.get(i));
					F1.remove(0);
					F2.remove(0);
					--b;
				}
				++c;//
				selectionSort(F0);
				selectionSort(F3);
				System.out.println("<--------------------------------------------------------------F0---------------------------------------------------------->");
				imp(F0);
				System.out.println("<--------------------------------------------------------------F3---------------------------------------------------------->");
				imp(F3);
			}
			if(F0.size()==1){//en dado caso de que F0 solo tenga un bloque se une con el bloque de F3 y se guarda en F1
				F1.add(new LinkedList<Esclavo>());
				F1.get(0).addAll(F0.get(0));
				F1.get(0).addAll(F3.get(0));
				F0.remove(0);
				F3.remove(0);
				selectionSort(F1);
				System.out.println("<--------------------------------------------------------------F1---------------------------------------------------------->");
				imp(F1);
				break;
			}
			int aa = F0.size();
			int cc=0;
			while(aa!=0 ){
				F1.add(new LinkedList<Esclavo>());
				F2.add(new LinkedList<Esclavo>());
				for(i=0;i<1;i++){
					F1.get(i+cc).addAll(F0.get(i));
					F1.get(i+cc).addAll(F3.get(i));
					F0.remove(0);
					F3.remove(0);
					--aa;
				}
				if(aa==0){
					selectionSort(F1);
					selectionSort(F2);
					System.out.println("<--------------------------------------------------------------F1---------------------------------------------------------->");
					imp(F1);
					System.out.println("<--------------------------------------------------------------F2---------------------------------------------------------->");
					imp(F2);
					break;
				}
				for(i=0;i<1;i++){
					F2.get(i+cc).addAll(F0.get(i));
					F2.get(i+cc).addAll(F3.get(i));
					F0.remove(0);
					F3.remove(0);
					--aa;
				}
				++cc;
				selectionSort(F1);
				selectionSort(F2);
				System.out.println("<--------------------------------------------------------------F1---------------------------------------------------------->");
				imp(F1);
				System.out.println("<--------------------------------------------------------------F2-------------------------------------------------------->");
				imp(F2);
			}
		}
		if(F1.isEmpty()==false){
			selectionSort(F1);
			System.out.println("<------------------------------------------------------DATOS ENVIADOS AL ARCHIVO------------------------------------------>");
			Imp(F1);
		}
		if(F0.isEmpty()==false){
			selectionSort(F0);
			System.out.println("<------------------------------------------------------DATOS ENVIADOS AL ARCHIVO------------------------------------------>");
			Imp(F0);
		}
	}//Cierre del metodo
	/**
     * Metodo para ordenar datos por apellido 
     * @param array Es la lista de lista de esclavos que se deben ordenar por medio de SelectionSort
     */
	public static void selectionSort(List<List<Esclavo>> array){
		for(int h=0;h<array.size();h++)
		    for (int j=0;j<array.get(h).size()-1;j++){
		      	int min = j;
		      	for (int k=j+1;k<array.get(h).size();k++){
		        	if (array.get(h).get(k).getApe().compareTo(array.get(h).get(min).getApe())<0) 
		        		min = k;  
		      	}
		      	Esclavo temp = array.get(h).get(j);
		      	array.get(h).set(j,array.get(h).get(min));
		      	array.get(h).set(min,temp);
		    }
  	}//Cierre del metodo
  	/**
     * Metodo para imprimir en un archivo los datos de los esclavos de cada lista de listas
     * @param a Es la lista de listas de esclavos 
     */
  	public static void Imp(List<List<Esclavo>> a) throws IOException {//crea los archivos
		String a1="Polifase.txt";
		PrintWriter imp;
		imp = new PrintWriter (new FileWriter(a1, true ));
		
  		for(int j=0; j<a.size();j++){
			System.out.print("\n[");
	  		for(int i=0;i<a.get(j).size();i++){
				System.out.print(a.get(j).get(i).getNom()+", "+a.get(j).get(i).getApe()+", "+a.get(j).get(i).getNum()+" || ");
				imp.println(a.get(j).get(i).getNom()+", "+a.get(j).get(i).getApe()+", "+a.get(j).get(i).getNum()+" || ");
	  		}
	  		System.out.print("]\n");
	  	}
		imp.close();
  	}//Cierre del metodo
  	/**
     * Metodo para imprimir en un archivo los datos de los esclavos de cada lista de listas
     * @param a Es la lista de listas de esclavos 
     */
  	public static void imp(List<List<Esclavo>> a){//imprime los datos en cmd
  		for(int j=0; j<a.size();j++){
			//System.out.println("<------------------------------------------------------------------------------------------------------------------------>");
	  		for(int i=0;i<a.get(j).size();i++){
				System.out.print(a.get(j).get(i).getNom()+", "+a.get(j).get(i).getApe()+", "+a.get(j).get(i).getNum()+" || ");
	  		}
	  	System.out.print("\n");
	  	}

  	}//Cierre del metodo
}