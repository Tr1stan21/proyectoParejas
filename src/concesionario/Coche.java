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

    private static Coche[] coches = new Coche[20];
    static int numCoches = 0;

    // Constructor
    public Coche(String matricula, String marca, String modelo, String color, double precio, int anio) {
        this.id = numCoches + 1;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.anio = anio;
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

    // Métodos
    public static String agregarCoche(Coche coche) {
        if (numCoches >= coches.length) {
            return "\nNo se pueden agregar más coches";
        }

        coches[numCoches] = coche;
        numCoches++;
        return "\nCoche agregado con ID " + coche.getId();
    }

    public static void mostrarCoches() {
        if (numCoches == 0) {
            System.out.println("\nNo hay coches en el concesionario.");
        }

        for (int i = 0; i < numCoches; i++) {
            Coche coche = coches[i];
            System.out.println(
                    "ID: " + coche.getId() + ", Matrícula: " + coche.getMatricula() + ", Marca: " + coche.getMarca() +
                            ", Modelo: " + coche.getModelo() + ", Color: " + coche.getColor() + ", Precio: "
                            + coche.getPrecio() + ", Año: " + coche.getAnio());
        }
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
}
