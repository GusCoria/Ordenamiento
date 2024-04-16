/**
    *Esta clase esta hecha para tener objetos de tipo esclavo que contengan: nombre, apellidos y numero de cuenta
    *@author: Pablo Giovanni Constantino Cruz
    *@author: Gustavo Coria Martinez
    *@author: Dulce María López Galicia
    *@version: 10.24.2021 

*/
public class Esclavo{
	//Variables globales
	private String nombre,ape,numero;
	/**
     * Constructor para la creacion de Esclavo
     * @param nombre El parámetro nombre almacena el nombre
     * @param ape El parametro ape almacena el apellido
     * @param numero El parametro numero almacena el numero de cuenta 
     */
	public Esclavo( String nombre , String ape,String numero){  
	    this.nombre = nombre;    
	    this.numero = numero;
        this.ape = ape; 
	}//cierre del constructor
	/**
     * Constructor vacio para utilizar los metodos de la clase
     */
	public Esclavo(){  
	}//cierre del constructor 
	/**
     * Metodo para obtener el nombre
     * @return El nombre del esclavo
     */
	public String getNom(){
	return (nombre);
	}//Cierre del metodo
	/**
     * Metodo para obtener el numero de cuenta
     * @return El numero de cuenta del esclavo
     */
	public String getNum(){
	return (numero);
	}//Cierre del metodo
	/**
     * Metodo para obtener el apellido
     * @return El apellido del esclavo
     */
	public String getApe(){
	return (ape);
	}//Cierre del metodo
}