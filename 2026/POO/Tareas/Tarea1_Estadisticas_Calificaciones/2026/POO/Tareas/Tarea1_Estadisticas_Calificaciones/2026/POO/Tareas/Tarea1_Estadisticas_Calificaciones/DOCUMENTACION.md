# **EXPLICACION DE CALCULADORA DE CALIFICACIONES**
## Naomy Leticia Vasquez Romero - 20231003292 - POO

Holaaa soy Naomy y voy a explicar mi codigo y como lo hice a continuación 

Primeramente pues habia que revisar el readme en github, y asi.. ver que teniamos que hacer y como lo debiamos de hacer. Al hacer esto me di cuenta que habian cosas que no podia utilizar, y cosas que debia utilizar ya que eso era lo que estabamos praticando. Ya con esta intro, podemos irnos al codigo, ya con netbeans abierto tenemos que crear nuestro programita.
Al hacer esto vamos a obtener un main generico
Ya con el main generico, regresamos a github y vemos los metodos que tenemos que crear y que deben de ir en el programa, creamos estos y les ponemos su return respectivo, para que no nos marquen error.

Ahora si comenzamos a hacer lo que que realmente ocupamos.

## *Primer Paso: Leer Calificaciones*
Agregar / importar los utils 
```java
    Scanner scanner = new Scanner(System.in); // creamos nuestro scanner para poder recibir valores
        int[] calificaciones = new int[8]; // creamos nuestro arreglo en donde guardaremos notas
        System.out.println("Calculadora de Calificaciones"); // nuestro titulo de la calculadora
```
----------------------------------------------------------------------------------------------------        
en esta siguiente parte del codigo lo modifique varias veces, al inicio estaba mas sencillo pero a medida lo fui probando me di cuenta de que le hacia falta validar dentro del leer para que el user pueda ingresar otra vez el valor donde se equivoco y lo pueda corregir con su respectivo mensaje de Error

```java
for (int i=0; i<8; i++){
    int nota=-1;
    do {
        try {
            System.out.print("Ingrese Calificacion #" + (i+1) +": ");
            nota = scanner.nextInt();
            if (nota < 0 || nota > 100){
                System.out.println("El dato ingresado " + nota + " es invalido,"
                        + "debe estar entre 0 y 100");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Error : ingrese un numero valido. "
                    + "Su respuesta es invalida ya que debe ser un digito");
            scanner.nextLine();
        }}
    while (nota<0 || nota>100);
    calificaciones[i]=nota;
}
return calificaciones;
```
## *Segundo Paso: Validar Calificaciones*
```java
public static boolean validarCalificaciones(int[] calificaciones){
    for (int j=0; j<8; j++){
        if (calificaciones[j] < 0 || calificaciones[j]>100){
            return false;
        }
    }
    return true;
}
```
Aqui como ya validamos dentro del Leer, validamos otra vez por si acaso, aunque realmente no es necesario, pero actua como segunda capa de validacion despues del Leer.

## *Tercer Paso: Calcular Promedio*
```java
public static double calcularPromedio(int[] calificaciones){
    double promedio;
    int sumaCalificaciones=0;

    for (int m=0; m<8; m++){
        sumaCalificaciones += calificaciones[m];
    }
    promedio = sumaCalificaciones/8.0;
    return promedio;
}
```
Aqui en esta parte realmente solo calculamos el promedio, no lleva mucho ciencia..

`promedio = suma de todas las calificaciones / 8.0`

Primeramente algo de lo que me di cuenta es que para que retorne un promedio con puntos decimales es necesario poner .0 en nuestro caso. Ya que venimos con nuestro suma en int, y queremos que retorne un double, pero lo dividimos en int, no nos retornara con un double sino un int, por eso le ponemos el .0

## *Cuarto Paso: Encontrar Maximo*

```java
public static int encontrarMaximo(int[] calificaciones){
    int max=calificaciones[0];
    for (int l=0; l<8; l++){
        if(calificaciones[l] >= max){
            max = calificaciones[l];
        }
    }
    return max;
}
```
Aqui lo que hice fue que vamos a recorrer el arreglo y lo iremos comparando uno a uno a modo de que cuando lo comparemos miremos cual es mayor y ese lo actualizamos y lo guardamos en la variable max.

## *Quinto Paso: Encontrar Minimo*

```java
public static int encontrarMinimo(int[] calificaciones){
    int min=calificaciones[0];
    for (int s=0; s<8; s++){
        if(calificaciones[s] <= min){
            min = calificaciones[s];
        }
    }
    return min;
}
```
Aqui lo que hice fue lo mismo que el max solo lo iremos comparando uno a uno a modo de que cuando lo comparemos miremos cual es menor y ese lo actualizamos y lo guardamos en la variable min.

## *Sexto Paso: Contar Aprobados*

```java
public static int contarAprobados(int[] calificaciones){
    int aprobados=0;
    for (int h=0; h<8; h++){
        if(calificaciones[h] >= 70){
            aprobados++;
        }
    }
    return aprobados;
}
```
Aqui lo unico que haremos es verificar cuales son las calificaciones mayores a 70, es decir que aprobaron, e ir sumando cuantos aprobados tenemos.

## *Septimo Paso: Porcentaje de Aprobados*

```java
public static double porcentajeAprobados(int[] calificaciones){
    double porcentaje;
    porcentaje = ((double)contarAprobados(calificaciones)/8.0)*100.0;
    return porcentaje;
}
```
Yo hice este metodo extra para poder calcular el porcentaje de aprobados, y lo unico que debemos hacer es hacer lo mismo que el promedio pero para los aprobados y multiplicarlo por 100.
Dato importantisimo es que debemos castear este porcentaje para que nos retorne un double, ya que lo estamos calculando con numeros enteros pero queremos una respuesta con decimales, por eso ponemos (double)


`porcentaje =(numero de aprobados / 8) * 100`

## *Octavo Paso: Mostrar Reporte*

```java
public static void mostrarReporte(int[] calificaciones){
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
    System.out.println("Cantidad de reprobados (<70) :" + (8-contarAprobados(calificaciones)));
    System.out.println("Porcentaje de aprobados (>=70) :" + porcentajeAprobados(calificaciones));
}
```
Para este paso final ocupamos llamar a los metodos que ya hicimos y lo pondremos para que el usuario pueda ver el reporte, este incluye:
- Calificaciones ingresadas para que puedan corroborar sus datos ingresados
- Promedio; promedio total de todas las calificaciones entre 8
-Calificacion Maxima encontrarda
-Calificacion Minima encontrada
-Cantidad de Aprobados, exponemos la cantidad de notas que son mayores a 70, o sea aprobados
-Cantidad de Reprobados, exponemos la cantidas de notas que son menores a 70, o sea reprobados, y solo le restamos de nuestro total de calificaciones a la cantidad de aprobados

`reprobados = 8 - aprobados`

- Porcentaje de Aprobados, aqui vemos cuantos del 100% aprobaron la clase, o sea su .nota es mayor a 70.
