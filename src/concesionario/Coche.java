package concesionario;

public class Coche {

    // Atributos
    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double precio;
    private int anio;
    private boolean vendido;

    private static Coche[] coches = new Coche[100];
    private static int numCoches = 0;
    private static int contadorId = 1;

    // Añadimos 5 coches al comenzar el programa
    static {
        coches[0] = new Coche("ABC123", "Toyota", "Corolla", "Rojo", 20000.0, 2021, false);
        contadorId++;
        coches[1] = new Coche("XYZ456", "Honda", "Civic", "Azul", 18000.0, 2020, false);
        contadorId++;
        coches[2] = new Coche("DEF789", "Ford", "Focus", "Negro", 22000.0, 2022, false);
        contadorId++;
        coches[3] = new Coche("GHI012", "Chevrolet", "Malibu", "Blanco", 25000.0, 2021, false);
        contadorId++;
        coches[4] = new Coche("JKL345", "Nissan", "Altima", "Gris", 23000.0, 2022, true);
        contadorId++;

        numCoches = 5;
    }

    // Constructor
    public Coche(String matricula, String marca, String modelo, String color, double precio, int anio,
            boolean vendido) {
        this.id = contadorId;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.anio = anio;
        this.vendido = vendido;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean getVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    // MÉTODOS

    // Método para agregar coches
    public static String agregarCoche(Coche coche) {
        if (numCoches >= coches.length) {
            return "\nNo se pueden agregar más coches";
        }

        coches[numCoches] = coche;
        numCoches++;
        contadorId++;
        return "\nCoche agregado con ID " + coche.getId();
    }

    // Método para mostrar los coches existentes en el array
    public static void mostrarCoches() {
        if (numCoches == 0) {
            System.out.println("\nNo hay coches en el concesionario.");
            return;
        }

        for (int i = 0; i < numCoches; i++) {
            Coche coche = coches[i];

            if (coche.getVendido() == true) {
                System.out.println(
                        "ID: " + coche.getId() + ", Matrícula: " + coche.getMatricula() + ", Marca: " + coche.getMarca()
                                + ", Modelo: " + coche.getModelo() + ", Color: " + coche.getColor() + ", Precio: "
                                + coche.getPrecio() + ", Año: " + coche.getAnio() + ", Vendido: Sí");
            } else if (coche.getVendido() == false) {
                System.out.println(
                        "ID: " + coche.getId() + ", Matrícula: " + coche.getMatricula() + ", Marca: " + coche.getMarca()
                                + ", Modelo: " + coche.getModelo() + ", Color: " + coche.getColor() + ", Precio: "
                                + coche.getPrecio() + ", Año: " + coche.getAnio() + ", Vendido: No");
            }
        }
    }

    // Método para eliminar coches
    public static String eliminarCoche(int idAEliminar) {
        boolean encontrado = false;

        // Buscamos el coche con el ID dado
        for (int i = 0; i < numCoches; i++) {
            if (coches[i].getId() == idAEliminar) {
                // Desplazamos los coches que están después del coche eliminado
                for (int j = i; j < numCoches - 1; j++) {
                    coches[j] = coches[j + 1]; // Mueve cada coche hacia la izquierda
                }
                coches[numCoches - 1] = null; // Limpiar la última posición
                numCoches--; // Reducir el contador de coches

                encontrado = true;
                return "Coche con ID " + idAEliminar + " eliminado exitosamente.";
            }
        }

        // Si no encontramos el coche con el ID dado
        if (!encontrado) {
            return "No se encontró un coche con ID " + idAEliminar;
        }
        return "";
    }

    // Método para comprobar si existe algún coche con el ID proporcionado
    public static boolean existeCoche(int id) {
        for (int i = 0; i < numCoches; i++) {
            if (coches[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Método para editar coches
    public static void editarCoche(int id, String matricula, String marca, String modelo, String color, double precio,
            int anio) {
        for (int i = 0; i < numCoches; i++) {
            if (coches[i].getId() == id) {
                coches[i].setMatricula(matricula);
                coches[i].setMarca(marca);
                coches[i].setModelo(modelo);
                coches[i].setColor(color);
                coches[i].setPrecio(precio);
                coches[i].setAnio(anio);
            }
        }
    }

    // Método para vender coches
    public static void venderCoche(int id, boolean vender) {
        for (int i = 0; i < numCoches; i++) {
            if (coches[i].getId() == id) {
                coches[i].setVendido(vender);
            }
        }
    }
}
