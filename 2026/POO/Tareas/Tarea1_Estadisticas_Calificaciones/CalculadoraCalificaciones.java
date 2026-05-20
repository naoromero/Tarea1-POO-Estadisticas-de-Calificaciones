
package com.mycompany.tarea1_estadisticas_calificaciones;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author anaro
 */
public class CalculadoraCalificaciones {

    public static void main(String[] args) {
      //Scanner scanner = new Scanner(System.in);
      int[] calificaciones = leerCalificaciones();
      if (validarCalificaciones(calificaciones)){
          mostrarReporte(calificaciones);
      }
    }
    
    /**
     * Lee las 8 calificaciones permitidas a ingresar por el usuario,
     * no permite ni mas ni menos. Valida que cada valor sea un numero 
     * entre 0 y 100. Si el valor es invalido o no es un numero, se le 
     * solicita al usuario de ingresar de nuevo
     * @return arreglo con las 8 calificaciones
     */
   public static int[] leerCalificaciones(){
        Scanner scanner = new Scanner(System.in);
        int[] calificaciones = new int[8];
        System.out.println("Calculadora de Calificaciones");
        for (int i=0; i<8; i++){
            int nota=-1;
            do {
                try {
            System.out.print("Ingrese Calificacion #" + (i+1) +": ");
            nota = scanner.nextInt();
            if (nota < 0 || nota > 100){
              System.out.println("El dato ingresado " + nota + " es invalido,"
                      + "debe estar entre 0 y 100");   
            } }
                catch (InputMismatchException e){
                    System.out.println("Error : ingrese un numero valido. "
                            + "Su respuesta es invalida ya que debe ser un digito");  
                    scanner.nextLine();
                }}
            while (nota<0 || nota>100);
            calificaciones[i]=nota;
            
            
        }
       return calificaciones;
    }
   
   
   /**
    * Verifica que todas las calificaciones del arreglo esten en el rango permitido.
    * Este actua como una segunda capa de validacion
    * @param calificaciones arreglo de 8 calificaciones enteras
    * @return true si todas son validas y false si alguna esta fuera del rango
    */
   public static boolean validarCalificaciones(int[] calificaciones){
 
         for (int j=0; j<8; j++){
            if (calificaciones[j] < 0 || calificaciones[j]>100){
                return false;
            } 
         }
    return true;
    }
   
   /**
    * Calcula el promedio de las 8 calificaciones
    * suma las calificaciones y las divide entre 8
    * @param calificaciones arreglo de 8 calificaciones enteras
    * @return el promedio de las calificaciones con 2 decimales (double)
    */
    
   public  static double calcularPromedio(int[] calificaciones){
       double promedio;
       int sumaCalificaciones=0;
       
       for (int m=0; m<8; m++){
           sumaCalificaciones += calificaciones[m];
       }
        promedio = sumaCalificaciones/8.0;
        return promedio;
    }
    
   
   /**
    * Encuentra la calificacion mas alta del arreglo
    * recorre el arreglo comparando cada valor hasta encontrar 
    * el mas grande.
    * @param calificaciones arreglo de 8 calificaciones enteras
    * @return la calificaciones mas alta encontrada
    */
   public  static int encontrarMaximo (int[] calificaciones){
       int max=calificaciones[0];
       for (int l=0; l<8; l++){
        if(calificaciones[l] >= max){
            max = calificaciones[l];
        }
           
       }
        return max;
    }
    
   
   /**
    * Encuentra la calificacion mas baja deñ arreglo
    * recorre el arreglo comparando cada valor hasta encontrar
    * el mas pequeño
    * @param calificaciones
    * @return 
    */
    public static int encontrarMinimo (int[] calificaciones){
        int min=calificaciones[0];
       for (int s=0; s<8; s++){
        if(calificaciones[s] <= min){
            min = calificaciones[s];
        }
           
       }
        return min;
    }
    
    
    /**
     * Cuenta cuantas calificaciones son mayores a 70, 
     * o sea que aprobaron
     * @param calificaciones arreglo de 8 calificaciones
     * @return cantidad de calificaciones aprobadas
     */
    public static int contarAprobados (int[] calificaciones){
      int aprobados=0;
       for (int h=0; h<8; h++){
        if(calificaciones[h] >= 70){
           aprobados++;
        }
           
       }
        return aprobados;
    }
    
    
    /**
     * Calcula el porcentaje de calificaciones aprobados
     * Divide la cantidad de aprobados entre 8 y lo multiplica por 100
     * @param calificaciones arreglo de 8 calificaciones
     * @return porcentaje de aprobados como double
     */
    public static double porcentajeAprobados (int[] calificaciones){
        double porcentaje;
        porcentaje = ((double)contarAprobados(calificaciones)/8.0)*100.0;
        
        return porcentaje;
    }
    
    
    /**
     * Muestra en pantalla el reporte completo de calificaciones
     * Incluyendo estadisticas, analisis de resultados y porcentajes
     * @param calificaciones arreglo de 8 calificaciones
     */
   public  static void mostrarReporte (int[] calificaciones){
     System.out.println();
      System.out.println();
    System.out.println("=== REPORTE DE CALIFICACIONES ===");
    System.out.println();
    System.out.print("Calificaciones Ingresadas: ");
        for (int v=0; v<8; v++){
        System.out.print(calificaciones[v] + " ");
            }
    System.out.println();
    System.out.println("----- ESTADISTICAS -----");
     System.out.println();
    System.out.println("Promedio :" + calcularPromedio(calificaciones));
    System.out.println("Calificacion Maxima :" + encontrarMaximo(calificaciones));
    System.out.println("Calificacion Minima :" + encontrarMinimo(calificaciones));
     System.out.println();
      System.out.println();
    System.out.println("----- ANALISIS DE RESULTADOS -----");
     System.out.println();
    System.out.println("Cantidad de aprobados (>=70) :" + contarAprobados(calificaciones));
    System.out.println("Cantidad de reaprobados (<70) :" + (8-contarAprobados(calificaciones)));
    System.out.println("Porcentaje de aprobados (>=70) :" + porcentajeAprobados(calificaciones));
    
    }
    
}
