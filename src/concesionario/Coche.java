package concesionario;

public class Coche {
	
	//Atributos
    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double precio;
    private int anio;
    
    private static Coche[] coches = new Coche[20];
    static int numCoches = 0;

    //Constructor
    public Coche (String matricula, String marca, String modelo, String color, double precio, int anio) {
        this.id = numCoches + 1;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.anio = anio;
    }

    //Getters y setters
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

    public String getModelo() {
        return modelo;
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
    
    //Métodos
    public static String agregarCoche(Coche coche) {
        if (numCoches >= coches.length) {
            return "No se pueden agregar más coches";
        }
        
        coches[numCoches] = coche;
        numCoches++;
        return "Coche agregado con ID "+ coche.getId();
    }
    
    public static void mostrarCoches() {
        if (numCoches == 0) {
            System.out.println("No hay coches en el concesionario.");
        }

        for (int i = 0; i < numCoches; i++) {
            Coche coche = coches[i];
            System.out.println("ID: " + coche.getId() + ", Matrícula: " + coche.getMatricula() + ", Marca: " + coche.getMarca() + 
            		", Modelo: " + coche.getModelo() + ", Color: " + coche.getColor() + ", Precio: " + coche.getPrecio() + ", Año: " + coche.getAnio());
        }
    }
    
}