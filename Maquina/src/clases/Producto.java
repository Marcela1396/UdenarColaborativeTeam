
package clases;

/**
 * @Nombre Componenete Producto
 * @Objetivo Desarrollar un componenete que represente un producto de la maquina
 * expendedora
 * @Descripción Representa un producto de la maquina expendedora
 * @Colaborador Camilo Valencia
 * @Zona PAS-04
 * @Fecha 11 - Abril - 2018
 * @Versión 1.0
 */
public class Producto {
    public int CAPACIDAD = 10;
    public double PORCENTAJE_FOPRE = 0.06;    
    
    private int cantidadUnidadesDisponibles;
    private int cantidadUnidadesCompradas;
    private double precio;
    private char tipo;
    private String identificador;
    private String nombre;           
    private boolean fopre;
    
    public Producto(String pIdentificador, String pNombre, double pPrecio, boolean pFopre, char pTipo){
        identificador = pIdentificador;
        nombre = pNombre;        
        fopre = pFopre;
        cantidadUnidadesCompradas = 0;
        cantidadUnidadesDisponibles = CAPACIDAD;
        if(pPrecio >= 50) precio = pPrecio;                
        if(pTipo == 'C' || pTipo == 'B') tipo = pTipo;        
    }
    
    public String darIdentificador(){
        return this.identificador;
    }
    
    public String darNombre(){
        return this.nombre;
    }
    
    public double darPrecio(){
        return this.precio;
    }
    
    public char darTipo(){
        return this.tipo;
    }
    
    public int darCantidadUnidadesDisponibles(){
        return this.cantidadUnidadesDisponibles;
    }
    
    public int darCantidadUnidadesCompradas(){
        return this.cantidadUnidadesCompradas;
    }
    
    public boolean esFopre(){
        return this.fopre;
    }
    
    public boolean comprar(){
        if(cantidadUnidadesDisponibles > 0){
            cantidadUnidadesDisponibles -= 1;
            cantidadUnidadesCompradas += 1;
            return true;
        }
        else{
            return false;
        }
    }
    
    public double calcularDonacionFopre(){
        return precio * PORCENTAJE_FOPRE;
    }
    
    /*
    public static void main(String[] args) {
        Producto p1 = new Producto("A1", "Papa Natural Margarita", 1300, true, 'C');
        Producto p2 = new Producto("A2", "Jugo Hit", 2000, true, 'B');
        Producto p3 = new Producto("B1", "Chocolatina Jet", 450, false, 'C');
        Producto p4 = new Producto("B2", "Galletas Festival", 800, false, 'C');
        System.out.println("Producto: " + p2.darIdentificador());
        System.out.println("Nombre: " + p2.darNombre());
        System.out.println("Precio: " + p2.darPrecio());
        System.out.println("Tipo: " + p2.darTipo());
        System.out.println("Donación: " + p2.calcularDonacionFopre());
        System.out.println("Comprar: " + p2.comprar());
        System.out.println("Unidades compradas: " + p2.darCantidadUnidadesCompradas());
        System.out.println("Unidades disponibles: " + p2.darCantidadUnidadesDisponibles());                        
    }
    */
}



