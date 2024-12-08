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

    // Métodos
    public static String agregarCoche(Coche coche) {
        if (numCoches >= coches.length) {
            return "\nNo se pueden agregar más coches";
        }

        coches[numCoches] = coche;
        numCoches++;
        contadorId++;
        return "\nCoche agregado con ID " + coche.getId();
    }

    public static void mostrarCoches() {
        if (numCoches == 0) {
            System.out.println("\nNo hay coches en el concesionario.");
            return;
        }

        for (int i = 0; i < numCoches; i++) {
            Coche coche = coches[i];
            System.out.println(
                    "ID: " + coche.getId() + ", Matrícula: " + coche.getMatricula() + ", Marca: " + coche.getMarca() +
                            ", Modelo: " + coche.getModelo() + ", Color: " + coche.getColor() + ", Precio: "
                            + coche.getPrecio() + ", Año: " + coche.getAnio() + ", Vendido: " + coche.getVendido());
        }
    }

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

    public static boolean existeCoche(int id) {
        for (int i = 0; i < numCoches; i++) {
            if (coches[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

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

    public static void venderCoche(int id, boolean vender) {
        for (int i = 0; i < numCoches; i++) {
            if (coches[i].getId() == id) {
                coches[i].setVendido(vender);
            }
        }
    }
}
