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
					System.out.print("\nMatrícula: ");
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

				case 4:
					System.out.print("Ingrese el ID del coche a eliminar: ");
					int idAEliminar = Integer.parseInt(scanner.nextLine());
					System.out.println(Coche.eliminarCoche(idAEliminar));
					break;

				case 5:
					System.out.print("\nIngrese el ID del coche a editar: ");
					int idEditar = Integer.parseInt(scanner.nextLine());

					// Verificar existencia antes de solicitar datos
					if (Coche.existeCoche(idEditar)) {
						System.out.print("Nueva Matrícula: ");
						String nuevaMatricula = scanner.nextLine();
						System.out.print("Nueva Marca: ");
						String nuevaMarca = scanner.nextLine();
						System.out.print("Nuevo Modelo: ");
						String nuevoModelo = scanner.nextLine();
						System.out.print("Nuevo Color: ");
						String nuevoColor = scanner.nextLine();
						System.out.print("Nuevo Precio: ");
						double nuevoPrecio = Double.parseDouble(scanner.nextLine());
						System.out.print("Nuevo Año: ");
						int nuevoAnio = Integer.parseInt(scanner.nextLine());

						Coche.editarCoche(idEditar, nuevaMatricula, nuevaMarca, nuevoModelo,
								nuevoColor, nuevoPrecio, nuevoAnio);

						System.out.println("\nCoche editado correctamente.");
					} else {
						System.out.println("\nID del coche no encontrado");
					}
					break;

				case 6:
					break;

				default:
					System.out.println("\nPor favor, seleccione una opción válida.");
					break;
			}

		} while (opcion != 6);

		scanner.close();
	}

}
