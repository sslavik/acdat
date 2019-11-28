/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eft_ad_ej1;

/**
 *Haz un programa que permita navegar de forma interactiva por los contenidos de la tabla CLIENTES creada con un programa de ejemplo anterior.
 * Primero el programa debe realizar una consulta para obtener los contenidos de la tabla, y debe mostrar el mensaje “fila 1” y el contenido de la fila,
 * indicando para cada columna el nombre de la columna y su valor. Después se deben ejecutar los comandos que se vayan introduciendo por teclado. 
 * Si el comando es ‘.’ debe terminar, por supuesto liberando todos los recursos. Si es ‘k’ debe ir a la siguiente fila, 
 * indicando el número de la fila y mostrando sus contenidos, como al principio para la primera fila. El comando para ir a la fila anterior será ‘d’. 
 * Si se introduce un número, se debe mostrar la fila en la posición indicada por el número. 
 * El programa debe mostrar mensajes apropiados en caso de que el comando que se ha introducido no se pueda realizar 
 * (por ejemplo, estando en la última fila se pide ir a la siguiente, o se introduce el número de una fila que no existe).
 * La clase Integer tiene métodos que permiten determinar si un String representa un número entero.

[Pista: Se puede leer una cadena de caracteres desde el teclado de la siguiente forma:

BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); String comando=br.readLine();]


 * @author Vyacheslav Shylyayev
 */
public class EFT_AD_EJ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
