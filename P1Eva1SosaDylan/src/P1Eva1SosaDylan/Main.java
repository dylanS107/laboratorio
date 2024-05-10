package P1Eva1SosaDylan;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String[] nombres;
    static double cantidad;
    static double precio;
    static double total;
    static double iva;
    static double totalConIva;

    static String Name;
    static int Age;
    static String Sex;
    static double[] Ratings;
    static double promedioCalificaciones;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc;

        do {
            // Menú de opciones
            System.out.println("Menu");
            System.out.println("1. Factura de un producto.");
            System.out.println("2. Ordenamiento de nombres.");
            System.out.println("3. Ingresar datos de estudiantes.");
            System.out.println("4. guardar informacion arcivo txt.");
            System.out.println("5. Salir.");
            System.out.println("Ingrese una opcion.");
            opc = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            switch (opc) {
                case 1:
                    Factura(scanner);
                    break;
                case 2:
                    OrdenNombres(scanner);
                    break;
                case 3:
                    DatosEstudiantes(scanner);
                    break;
                case 4:
                    System.out.println("GENERAL UN ARCHIVO TXT");
                    guardarInformacionEnArchivo();
                    break;
                case 5:
                    System.out.println("muchas gracias");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        } while (opc != 4);
    }

 // Método para ingresar los datos de un estudiante
public static void DatosEstudiantes(Scanner scanner) {
    // Solicitar el nombre del estudiante
    System.out.print("Ingrese el nombre del estudiante: ");
    Name = scanner.nextLine();

    // Solicitar la edad del estudiante
    do {
        System.out.print("Ingrese la edad del estudiante (3-100): ");
        Age = scanner.nextInt();
        if (Age < 3 || Age > 100) {
            System.out.println("Ingrese una edad válida.");
        }
    } while (Age < 3 || Age > 100);

    // Solicitar el género del estudiante
    System.out.print("Ingrese el género del estudiante (M-F): ");
    Sex = scanner.next().toUpperCase();
    // Validar el género
    while (!Sex.equals("M") && !Sex.equals("F")) {
        System.out.println("Intente de nuevo. M para masculino y F para femenino.");
        System.out.print("Ingrese el género del estudiante (M-F): ");
        Sex = scanner.next().toUpperCase();
    }
    scanner.nextLine(); // Limpia el buffer de entrada después de usar next()

    // Solicitar la cantidad de asignaturas del estudiante
    int numSubjects;
    do {
        System.out.print("Ingrese la cantidad de asignaturas (1-10): ");
        numSubjects = scanner.nextInt();
        if (numSubjects <= 0 || numSubjects > 10) {
            System.out.println("Ingrese un número válido de asignaturas.");
        }
    } while (numSubjects <= 0 || numSubjects > 10);

    // Inicializar el arreglo de calificaciones
    Ratings = new double[numSubjects];
    // Solicitar las calificaciones de las asignaturas
    for (int i = 0; i < numSubjects; i++) {
        do {
            System.out.print("Ingrese la calificación de la asignatura " + (i + 1) + ": ");
            Ratings[i] = scanner.nextDouble();
            if (Ratings[i] < 0 || Ratings[i] > 20) {
                System.out.println("Ingrese una calificación válida (entre 0 y 20).");
            }
        } while (Ratings[i] < 0 || Ratings[i] > 20);
    }

    // Calcular el promedio de calificaciones
    double suma = 0;
    for (double calificacion : Ratings) {
        suma += calificacion;
    }
    promedioCalificaciones = suma / numSubjects;

    // Mostrar los datos del estudiante
    System.out.println("\nDatos del estudiante:");
    System.out.println("Nombre: " + Name);
    System.out.println("Edad: " + Age);
    System.out.println("Género: " + Sex);
    System.out.println("Calificaciones:");
    for (int i = 0; i < numSubjects; i++) {
        System.out.println("Asignatura " + (i + 1) + ": " + Ratings[i]);
    }
    System.out.println("Promedio de calificaciones: " + promedioCalificaciones);
}


 public static void Factura(Scanner scanner) {
    // Solicitar la cantidad del producto
    System.out.println("Factura de un producto");
    do {
        System.out.print("Ingrese la cantidad (1-100): ");
        cantidad = scanner.nextInt();
        if (cantidad < 1 || cantidad > 100) {
            System.out.println("Intente de nuevo.");
        }
    } while (cantidad < 1 || cantidad > 100);

    // Solicitar el precio del producto
    do {
        System.out.print("Ingrese el precio (0-10): ");
        precio = scanner.nextDouble();
        if (precio <= 0 || precio > 10) {
            System.out.println("Intente de nuevo.");
        }
    } while (precio <= 0 || precio > 10);

    // Calcular el total, IVA y total con IVA
    total = cantidad * precio;
    iva = total * 0.15;
    totalConIva = total + iva;

    // Mostrar el total sin IVA, el IVA y el total con IVA
    System.out.println("Total sin IVA: " + total);
    System.out.println("IVA (15%): " + iva);
    System.out.println("Total con IVA: " + totalConIva);
}
 
 

  // Método para guardar la información en un archivo de texto
public static void guardarInformacionEnArchivo() {
    try (FileWriter writer = new FileWriter("informacion.txt")) {
        // Guardar información sobre la factura de un producto
        writer.write("Factura de un producto\n");
        writer.write("Cantidad: " + cantidad + "\n");
        writer.write("Precio: " + precio + "\n");
        writer.write("Total sin IVA: " + total + "\n");
        writer.write("IVA (15%): " + iva + "\n");
        writer.write("Total con IVA: " + totalConIva + "\n");
        writer.write("\n");

        // Guardar información sobre los nombres ordenados
        writer.write("Nombres ordenados:\n");
        if (nombres != null) {
            for (String nombre : nombres) {
                writer.write(nombre + "\n");
            }
        } else {
            writer.write("No hay nombres ordenados disponibles.\n");
        }
        writer.write("\n");

        // Guardar información sobre los datos del estudiante
        writer.write("Datos del estudiante:\n");
        writer.write("Nombre: " + Name + "\n");
        writer.write("Edad: " + Age + "\n");
        writer.write("Género: " + Sex + "\n");
        writer.write("Calificaciones:\n");
        for (int i = 0; i < Ratings.length; i++) {
            writer.write("Asignatura " + (i + 1) + ": " + Ratings[i] + "\n");
        }
        writer.write("Promedio de calificaciones: " + promedioCalificaciones + "\n");
        writer.write("\n");

        System.out.println("La información se ha guardado correctamente en 'informacion.txt'.");
    } catch (IOException e) {
        System.out.println("Error al guardar la información: " + e.getMessage());
    }
}

public static void OrdenNombres(Scanner scanner) {
        int n = 0;
        // Opción 2: Ordenamiento de nombres
        System.out.println("Ordenamiento de nombres");
        // Solicitar la cantidad de nombres
        do {
            System.out.println("Ingrese la cantidad de nombres: ");
            n = scanner.nextInt();
            if (n <= 0 || n > 25) {
                System.out.println("Intente de nuevo.");
            }
        } while (n <= 0 || n > 25);
        // Consumir la nueva línea pendiente en el buffer
        scanner.nextLine();
        // Inicializar el arreglo de nombres
        nombres = new String[n];
        // Solicitar los nombres
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el nombre " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }
        // Ordenar los nombres alfabéticamente
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nombres[j].compareTo(nombres[j + 1]) > 0) {
                    String aux = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = aux;
                }
  }
        }
        // Mostrar los nombres ordenados
        System.out.println("Los nombres ordenados son:");
        for (int i = 0; i < n; i++) {
            System.out.println(nombres[i]);
}
}
}