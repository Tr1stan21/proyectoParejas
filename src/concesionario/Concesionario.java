package concesionario;

import java.util.Scanner;

public class Concesionario {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		try {
			do {
				System.out.println("\n-- Concesionario de Coches --");
				System.out.println("1. Agregar coche");
				System.out.println("2. Mostrar lista de coches");
				System.out.println("3. Buscar coche según características");
				System.out.println("4. Eliminar coche");
				System.out.println("5. Editar información de coche");
				System.out.println("6. Vender coche");
				System.out.println("7. Espacios restantes");
           			System.out.println("8. Espacios ocupados");
				System.out.println("9. Salir");
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
						boolean vendido = false;

						// Creamos coche con los atributos anteriormente solicitados
						Coche nuevoCoche = new Coche(matricula, marca, modelo, color, precio, anio, vendido);
						System.out.println(Coche.agregarCoche(nuevoCoche));
						break;

					case 2:
						Coche.mostrarCoches();
						break;
					case 3:
				                do {
				                    System.out.println("\n-- Buscar coches por característica --");
				                    System.out.println("1. ID");
				                    System.out.println("2. Matrícula");
				                    System.out.println("3. Marca");
				                    System.out.println("4. Modelo");
				                    System.out.println("5. Color");
				                    System.out.println("6. Precio");
				                    System.out.println("7. Año");
						    System.out.println("8. Estado de venta (Vendidos o No vendidos)");
				                    System.out.println("9. Salir");
				                    System.out.print("Ingrese una opción: ");
				                    opcion = Integer.parseInt(scanner.nextLine());
			
				                    switch (opcion) {
					                    case 1:  
				                            System.out.print("Ingrese matrícula para buscar: ");
				                            int idBuscado = Integer.parseInt(scanner.nextLine());
				                            Coche.buscarPorId(idBuscado);
				                            break;
				                    	case 2:  
				                            System.out.print("Ingrese matrícula para buscar: ");
				                            String matriculaBuscada = scanner.nextLine();
				                            Coche.buscarPorMatricula(matriculaBuscada);
				                            break;
				                        case 3:  
				                            System.out.print("Ingrese marca para buscar: ");
				                            String marcaBuscada = scanner.nextLine();
				                            Coche.buscarPorMarca(marcaBuscada);
				                            break;
				                        case 4:  
				                            System.out.print("Ingrese modelo para buscar: ");
				                            String modeloBuscado = scanner.nextLine();
				                            Coche.buscarPorModelo(modeloBuscado);
				                            break;
				                        case 5:  
				                            System.out.print("Ingrese color para buscar: ");
				                            String colorBuscado = scanner.nextLine();
				                            Coche.buscarPorColor(colorBuscado);
				                            break;
				                        case 6:  
				                            System.out.print("Ingrese precio para buscar (mayor que): ");
				                            double precioBuscado = Double.parseDouble(scanner.nextLine());
				                            Coche.buscarPorPrecio(precioBuscado);
				                            break;
				                        case 7:  
				                            System.out.print("Ingrese año para buscar: ");
				                            int anioBuscado = Integer.parseInt(scanner.nextLine());
				                            Coche.buscarPorAnio(anioBuscado);
				                            break;
							case 8:
					                    System.out.println("¿Desea buscar coches vendidos o no vendidos?");
					                    System.out.println("1. Vendidos");
					                    System.out.println("2. No vendidos");
					                    System.out.print("Ingrese una opción: ");
					                    int estadoVenta = Integer.parseInt(scanner.nextLine());
					
					                if (estadoVenta == 1) {
					                    Coche.buscarPorEstadoVenta(true);  // Buscar coches vendidos
					                } else if (estadoVenta == 2) {
					                    Coche.buscarPorEstadoVenta(false);  // Buscar coches no vendidos
					                } else {
					                    System.out.println("Opción inválida.");
					                }
					                break;    
				                        case 9:
				                            System.out.println("Saliendo del menú de búsqueda.");
				                            break;
				                        default:
				                            System.out.println("Opción inválida. Intente nuevamente.");
				                    }
						} while (opcion != 9); // Sale cuando la opción es 8 (Salir)
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
						System.out.print("\nIntroduzca el ID del coche a eliminar o 0 para salir: ");
						int idVender = Integer.parseInt(scanner.nextLine());
						if (Coche.existeCoche(idVender)) {
							boolean vender = true;
							Coche.venderCoche(idVender, vender);
							System.out.println("\nEl coche con ID " + idVender + " ha sido vendido.");
						} else if (idVender == 0) {
							System.out.println("\nOperación cancelada");
						} else {
							System.out.println("\nID del coche no encontrado");
						}
						break;
                
					case 7:
						System.out.println("Espacios libres en el concesionario: " + Coche.obtenerEspaciosLibres());
                    				break;
					case 8:
						System.out.println("Espacios ocupados en el concesionario: " + Coche.obtenerEspaciosOcupados());
                   				break;

					default:
						System.out.println("\nPor favor, seleccione una opción válida.");
						break;
				}

			} while (opcion != 9);
		} catch (NumberFormatException e) {
			System.out.println("\nError: Ingrese un dato válido.");
		}

		scanner.close();
	}

}
