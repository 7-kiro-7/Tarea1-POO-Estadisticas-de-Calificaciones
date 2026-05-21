## **DOCUMENTACION**

**Descripción General**

Desarrollar un programa en java que permita almacenar un conjunto de 8 notas y calcular diversas operaciones educativas. Este debe procesar dichas, validar y generar un informe detallado.

##### **Métodos utilizados**

##### **1. for(int i = 0; i<notas.length;i++)**

Ubicado en el main, dentro de este for se realiza todo lo que vendria siendo la validación de los datos a ingresar, para poder seguir avanzando en el programa, se tiene que 
cumplir una única condición totalmente OBLIGATORIA, esa condición es ingresar enteros en el rango de 0-100.
Si esa condición no se cumple, el usuario estara atrapado en un bucle que se repetira infinitamente, para evitarlo y/o salir de el simplemente se tiene que ingresar enteros entre 0 y 100 hasta tener los 8 
enteros necesarios. Para ahorrarnos una gran molestia, no se pueden ingresar menos o mas de 8 enteros. Al mismo tiempo esta validación (por OBVIAS razones) no permite el ingreso de cadenas de texto, si el 
usuario por alguna razón que desconocemos quisiera agregar texto, ingresaria al bucle antes planteado, y al igual que con los números fuera de rango, la única manera de salir de el es ingresar un entero en el 
rango correcto.

##### **2. public static String maxymin(int[] a, double b)**

Esta funcion manda a llamar a 'a' (int[] a), que vendría siendo el array donde estan guardadas las notas ingresadas, también manda a llamar a 'b', que es la
suma de todas las notas ingresadas. En esta función sin retorno, el programa encuentra la nota máxima y la minima entre las notas ingresadas. Dentro de la funcion 
esta declarada la  variable max (max = a[0]), y min (min = a[0]), una vez ingresadas todas las notas, la función examina todo el arreglo donde se encuentran las
notas, y medida lo recorre va buscando y seleccionando la nota máxima y la minima para mostrarla cuando sean requeridas. También en esta misma función
se encuentra la variable pr (pr = b/8), esta es utilizada para calcular el promedio de la suma de todas las notas ingresadas, la formula de esta es: 
la suma de las notas / 8. Ya que es una función con retorno, en este caso retornara un String que contiene todos los datos anteriormente descritos.

##### **3. public static String aprobados(int[] b)**

Como vimos en la funcion de arriba, esta función llamar al array donde estan las notas (int[] b). En esta función estan declaradas las funciones 'apr'(aprobados) y 'rpb' (reprobados), ambas variables 
inicializadas en 0 ya que se usaran como contadores. Cada vez que una nota sea mayor o igual a 70 la variable que representa a las notas aprobadas aumentara en 1, sin embargo si esta condición no se cumple, el
contador que aumentara sera el de la variable que representa a las notas reprobadas. Al igual que en la función anterior, esta función también cuenta con una tercera tarea, dentro de esta función esta 
declarada la funcion 'por'(porcentaje) está esta declarada como (apr/8.0 * 100), y su tarea es la de encontrar el porcentaje (%) de notas aprobadas. Ya que era una directriz de la tarea, su formato esta 
reducido a 1 solo decimal. Como en la función anterior es una función con retorno, retornara un String que contiene todos los datos anteriormente descritos


##### **4. public static String notas(int[] n)**

Esta vendria siendo la función más simple del programa, unicamente llama al array donde están las notas (int [] n), ya que unicamente lo que hace es cambiar el formato del array donde estan las notas para 
poder ser visualizado en la consola y ya. Mismo caso que los anteriores funciones, retornara un String con los datos utiles dentro de ella.

##### **5. public static void escribirTextoEnArchivo(String ruta, String contenido)**

En esta función se realiza una de las partes mas importantes de este programa, esta función nos sirve para guardar los datos importantes del programa en un acrhivo con extensión .txt. Aquí se manda a llamar la 
ruta y el contenido que se guardara en el archivo.


##### **- - DIAGRAMA DE FLUJO - -**

[ INICIO ]
                   │
                   ▼
  [ Declarar array notas[8], a = 0, Scanner ]
                   │
                   ▼
 ┌──────────>[ FOR i = 0 hasta 8 ]─────────────┐
 │                 │                           │
 │                 ▼                           │
 │       ┌──>[ WHILE entrada inválida ]        │
 │       │         │                           │
 │       │         ▼                           │
 │       │    / Leer número /                  │
 │       │         │                           │
 │       │         ▼                           │
 │       ├───< ¿Ingresó texto? (Catch) >── Sí ─┤
 │       │         │                           │
 │       │         No                          │
 │       │         ▼                           │
 │       ├───< ¿Número < 0 o > 100? >───── Sí ─┤
 │       │         │                           │
 │       │         No                          │
 │       │         ▼                           │
 │       │   [ a += número, r = true ]         │
 │       │         │                           │
 │       └─────────┘                           │
 │                 │                           │
 └─────────────────┘                           │ (Fin del ciclo For)
                                               ▼
                              [ Obtener String de notas() ]
                                               │
                                               ▼
                              [ Obtener String de maxymin() ]
                                               │
                                               ▼
                              [ Obtener String de aprobados() ]
                                               │
                                               ▼
                          [ reporteFinal = notas + maxmin + aprob ]
                                               │
                                               ▼
                            / Imprimir reporteFinal en consola /
                                               │
                                               ▼
                           [ Escribir reporteFinal en pruebas.txt ]
                           [     (Modo añadir / Append = true)    ]
                                               │
                                               ▼
                                            [ FIN ]



##### **- - Instrucciones de compilación y ejecución - -**

##### **Compilación**

Para compilar este programa es necesario ejecutar CalculadoraCalificaciones.java, lo que genera el CalculadoradeCalificaciones.class.

##### **Ejecución**

Ejecutar Calculadoracalificaciones.java


##### **- - EJEMPLOS DE SALIDA - -**


REPORTE DE CALIFICACIONES
 - - - - - - - - - - - - - -
- - - INFORME DE CALIFICACIONES - - -

 - - - Notas obtenidas - - - 

[98, 97, 9, 6, 95, 94, 93, 92]

 - - - Estadisticas importantes - - -

Nota máxima: 98
Nota minima: 6
Promedio: 73.00

- - - ANALISIS - - -

Aprobados: 6
Reprobados: 2
% de aprobados: 75.0                                            