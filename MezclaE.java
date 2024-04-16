import java.util.List;
import java.util.LinkedList; 
import java.io.*;
/**
    *Esta clase ordena archivos por medio de apellidos utilizando el metodo de ordenamiento externo Mezcla Equilibrada 
    *@author: Gustavo Coria Martinez
    *@version: 10.24.2021 

*/
public class MezclaE{
	/**
     * Metodo para ordenar datos por apellido de forma externa por Mezcla equilibrada
     * @param a Es la lista de esclavos que se deben ordenar
     */
	public static void Mezcla(List<Esclavo> a)throws IOException{
		List<List<Esclavo>> F0 = new LinkedList<>();//lista principal
		List<List<Esclavo>> F1 = new LinkedList<>();//
		List<List<Esclavo>> F2 = new LinkedList<>();
		List<Esclavo>  F00 =  a;
		int h=0,c=0,i;
		int count =a.size(); 
		String v="§";
		System.out.println(F00);
		while(F00.size()!=0){
			F1.add(new LinkedList<Esclavo>());//añadimos bloques
			F2.add(new LinkedList<Esclavo>());//
				while(F00.size()!=0){
					if(count>1){
		                c = F00.get(0).getApe().compareTo(F00.get(1).getApe());//comparacion de datos
		                if(count==2)//
                    		v = F00.get(0).getApe();
						if(c<0 || c==0){
							F1.get(h).add(F00.get(0));
							F00.remove(0);
							--count;
						}
						else{
							F1.get(h).add(F00.get(0));
							F00.remove(0);
							--count;
							break;
						}
					}
					else{
						break;
					}
				}
				if(v.compareTo(F00.get(0).getApe())==0 || v.compareTo(F00.get(0).getApe())<0){
					F1.get(h).add(F00.get(0));
					F00.remove(0);
					--count;
				}
				while(F00.size()!=0){
					if(count>1){
		                c = F00.get(0).getApe().compareTo(F00.get(1).getApe());
		                if(count==2)
                    		v = F00.get(0).getApe();
						if(c<0 || c==0){
							F2.get(h).add(F00.get(0));
							F00.remove(0);
							--count;
						}
						else{
							F2.get(h).add(F00.get(0));
							F00.remove(0);
							--count;
							break;
						}
					}
					else{
						break;
					}
				}
				if(F00.size()!=0){
					if(v.compareTo(F00.get(0).getApe())==0 || v.compareTo(F00.get(0).getApe())<0){
						F2.get(h).add(F00.get(0));
						F00.remove(0);
						--count;
					}
					else{
						if(v.compareTo(F00.get(0).getApe())>0 && F1.get(h).isEmpty()==false && count==1){
						F2.get(h).add(F00.get(0));
						F00.remove(0);
						--count;
						}
					}
				}
            ++h;
		}
		System.out.println("<--------------------------------------------------------------F1---------------------------------------------------------->");
		imp(F1);
		System.out.println("<--------------------------------------------------------------F2-------------------------------------------------------->");
		imp(F2);	
		while(F1.size()!=0){
			int b = F1.size();
			c=0;
			if(F1.size()==1){
				F0.add(new LinkedList<Esclavo>());
				F0.get(0).addAll(F1.get(0));
				F0.get(0).addAll(F2.get(0));
				F1.remove(0);
				F2.remove(0);
				selectionSort(F0);
				System.out.println("<--------------------------------------------------------------F0---------------------------------------------------------->");
				imp(F0);
				break;
			}
			while(b!=0){
				F0.add(new LinkedList<Esclavo>());
				for(i=0;i<1;i++){
					F0.get(i+c).addAll(F1.get(i));
					F0.get(i+c).addAll(F2.get(i));
					F1.remove(0);
					F2.remove(0);
					--b;
				}
				if(b==0){
					selectionSort(F0);
					System.out.println("<--------------------------------------------------------------F0---------------------------------------------------------->");
					imp(F0);
                    break;
                }
				++c;
			}
			int aa = F0.size();
			int cc=0;
			while(aa!=0 ){
				F1.add(new LinkedList<Esclavo>());
				F2.add(new LinkedList<Esclavo>());
				for(i=0;i<1;i++){
					F1.get(i+cc).addAll(F0.get(i));
					F0.remove(0);
					--aa;
				}
				if(aa==0){
					break;
                }
				for(i=0;i<1;i++){
					F2.get(i+cc).addAll(F0.get(i));
					F0.remove(0);
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
		System.out.println("<------------------------------------------------------DATOS ENVIADOS AL ARCHIVO------------------------------------------>");
        Imp(F0);
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
     * Metodo para imprimir en un archivo  los datos de los esclavos de cada lista de listas
     * @param a Es la lista de listas de esclavos 
     */
  	public static void Imp(List<List<Esclavo>> a) throws IOException {
		String a1="MezclaE.txt";
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
     * Metodo para imprimir en la pantall los datos de los esclavos de cada lista de listas
     * @param a Es la lista de listas de esclavos 
     */
  	public static void imp(List<List<Esclavo>> a){
  		for(int j=0; j<a.size();j++){
	  		for(int i=0;i<a.get(j).size();i++){
				System.out.print(a.get(j).get(i).getNom()+", "+a.get(j).get(i).getApe()+", "+a.get(j).get(i).getNum()+" || ");
	  		}
	  	System.out.print("\n");
	  	}
  	}//Cierre del metodo
}
