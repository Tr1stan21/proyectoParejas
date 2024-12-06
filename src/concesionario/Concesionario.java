package concesionario;

import java.util.Scanner;

public class Concesionario {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;

        do {
            System.out.println("\n-- Concesionario de Coches --");
            System.out.println("1. Agregar coche");
            System.out.println("2. Mostrar lista de coches");
            System.out.println("3. Buscar coche por ID");
            System.out.println("4. Eliminar coche");
            System.out.println("5. Editar información de coche");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
	            case 1:
	                System.out.print("Matrícula: ");
	                String matricula = scanner.nextLine();
	                System.out.print("Marca: ");
	                String marca = scanner.nextLine();
	                System.out.print("Modelo: ");
	                String modelo = scanner.nextLine();
	                System.out.print("Color: ");
	                String color = scanner.nextLine();
	                System.out.print("Precio: ");
	                double precio = Double.parseDouble(scanner.nextLine());
	                System.out.print("Año: ");
	                int anio = Integer.parseInt(scanner.nextLine());
	
	                Coche nuevoCoche = new Coche(matricula, marca, modelo, color, precio, anio);
	                System.out.println(Coche.agregarCoche(nuevoCoche));
	                break;
	                
	            case 2:
	            	Coche.mostrarCoches();
	            	break;
	            
                default:
                	System.out.println("Por favor, seleccione una opción válida.");
                    break;
            }
            
            } while (opcion != 6);
        

        scanner.close();
	}

}
