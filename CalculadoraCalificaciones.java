import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class CalculadoraCalificaciones {
    public static void main(String[] args) { // Inicio del main.
        Scanner t = new Scanner(System.in); // Se inicia el escaner.
        String pruebasTxt = "pruebas.txt"; 
        int[] notas = new int[8]; //Se declara el arreglo.
        double a = 0; 

        for(int i = 0; i<notas.length; i++){  // Aqui validaremos los datos de entrada.
            boolean r = false;
            while (!r) {
                try {
                    System.out.println("Nota "+ (i+1)+":");
                    notas[i] = t.nextInt();
                    if (notas[i] < 0 || notas[i] > 100) {
                        System.out.println("fuera de rango (0-100)");
                    } else {
                        r = true;
                    }
                } catch (InputMismatchException z) { // Si se llega a ingresar texto, se hara una excepción al error y se permitira ingresar un entero otra vez.
                    System.out.println("No se permite texto, por favor, ingrese un entero entre 0 y 100");
                    t.nextLine();
                }
            }
            a += notas[i]; // Suma del total de los números que ya fueron validados.
        }

        //  Asignamos el texto que esta en nuestras funciones a las variables.
        String textoNotas = notas(notas);     
        String textoMaxMin = maxymin(notas, a); 
        String textoAprobados = aprobados(notas); 

        // 2. Unimos todo.
        String reporteFinal = textoNotas + textoMaxMin + textoAprobados;

        // 3. Esto es lo que vera el usuario en la consola.
        System.out.println(reporteFinal);

        // 4. primero especificamos donde se va a guardar y despues el contenido que se guardara.
        escribirTextoEnArchivo(pruebasTxt, reporteFinal);

        t.close();
    } // Fin del main


    public static String maxymin(int[] a, double b){
        int max = a[0], min = a[0];
        double pr;
        for (int i = 0; i < a.length; i++){
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        pr = b/8;

        // Aca se nos muestra la nota maxima, minima y el promedio de todas las notas.
        String resultado = " - - - Estadisticas importantes - - -\n\n";
        resultado += "Nota máxima: " + max + "\n";
        resultado += "Nota minima: " + min + "\n";
        resultado += "Promedio: " + String.format("%.2f", pr) + "\n";
        
        return resultado;  // retornamos lo que ocupamos.
    }

    public static String aprobados(int[] b){ // Esta función nos contara el total de aprobados, reprobados y el porcentaje de los aprobados.
        int apr = 0, rpb = 0;
        for(int i = 0; i < b.length; i++){
            if(b[i] >= 70){
                apr++;
            } else {
                rpb++;
            }
        }
        double por = apr/8.0 * 100;
        
        // Armamos el texto
        String resultado = "\n- - - ANALISIS - - -\n\n";
        resultado += "Aprobados: " + apr + "\n";
        resultado += "Reprobados: " + rpb + "\n";
        resultado += "% de aprobados: " + String.format("%.1f", por) + "\n";
        
        return resultado; // retornamos lo que ocupamos.
    }


    public static String notas(int[] n){ 
        // Armamos el texto
        String resultado = "- - - INFORME DE CALIFICACIONES - - -\n\n";
        resultado += " - - - Notas obtenidas - - - \n\n";
        resultado += Arrays.toString(n) + "\n\n";
        
        return resultado; // retornamos lo que ocupamos.
    }


    // Función que nos guardara el texto en el archivo.txt.
    public static void escribirTextoEnArchivo(String ruta, String contenido) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta, true))) {
            
           escritor.write("\n - - - - - - - - - - - - - -\n");
           escritor.write("REPORTE DE CALIFICACIONES");
           escritor.write("\n - - - - - - - - - - - - - -\n");


            // Escribimos todo el reporte.
            escritor.write(contenido); 

            escritor.newLine();
            
            System.out.println("\nEl reporte se guardo en: " + ruta);
            
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

}