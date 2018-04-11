package Monto;
package Producto;

/**
 * @nombre: Componente Máquina Expendedora
 * @objetivo: Construir una aplicación que permita simular
 * el uso, por parte de un cliente, de una máquina
 * expendedora de alimentos, la cual contiene 4
 * productos. La aplicación permite al usuario (o cliente
 * de la máquina) añadir monedas a la máquina para
 * tener un crédito de compra, comprar productos, recibir
 * el cambio cuando haya terminado una compra y
 * conocer la información sobre las compras que ha
 * realizado en la máquina.
 * @descripción: La máquina expendedora dispone de cuatro productos de los
 * cuales podrán ser comprados por un usuario de acuerdo al dinero que este
 * ingrese.
 * @colaborador: Daniel Tutistar
 * @zona: PAS-04
 * @fecha: 10 - Abril 2018
 * @versión. 1.0
*/

public class MaquinaExpendedora{

    private Monto credito = Monto();
    private  Producto producto1;
    private  Producto producto2;
    private  Producto producto3;
    private  Producto producto4;

    public MaquinaExpendedora(){

        producto1 = new Producto("A1", "Papa Natural Margarita", 1300);
        producto2 = new Producto("A2", "Jugo Hit", 2000);
        producto3 = new Producto("A3", "Chocolatina Jet", 450);
        producto4 = new Producto("A4", "Galleta Festival", 800);
        Producto[] listaProductos = new Pruducto [4];
        listaProductos[0] = producto1;
        listaProductos[1] = producto2;
        listaProductos[2] = producto3;
        listaProductos[3] = producto4;

    }

    public double darValorCredito(){

        return credito.darValorTotal();

    }

    public void darProducto(String pIdentificador){

        switch (pIdentificador){

        case producto1.darIdentificador():
            return producto1;
            break;
        case producto2.darIdentificador():
            return producto2;
            break;
        case producto3.darIdentificador():
            return producto3;
            break;
        case producto4.darIdentificador():
            return producto4;
            break;

        }

    }

    public boolean agregarMoneda(int pMoneda){

        return credito.agregarMoneda(pMoneda);
    }


    public boolean comprarProducto(String pIdentificador){

        if(pIdentificador == null || pIdentificador == ""){return false;}
        for(int i = 0; i<4; i++){

            if(listaProductos[i].darIdentificador() == pIdentificador
            && listaProductos[i].darCantidadUnidadesDisponibles() > 0){
                return listaProductos[i].comprar();
            }

        }
        return false;

    }

    public void terminarCompra(){

        return credito;

    }

    public int darCantidadTotalUnidadesCompradas(){

        int cantidadTotalUnidadesCompradas = 0;
        for(int i = 0; i < 4; i++){
            cantidadTotalUnidadesCompradas
            += listaProductos[i].darCantidadUnidadesCompradas();
        }
        return cantidadTotalUnidadesCompradas;

    }

    public double darValorTotalCompras(){

        double valorTotalCompras = 0;
        for (int i = 0; i < 4; i++){
          valorTotalCompras += listaProductos[i].darCantidadUnidadesCompradas()
          * listaProductos[i].darPrecio();
        }
        return valorTotalCompras;

    }

    public double darPorcentajeDisponibilidad(){

        double porcentajeDisponibilidad = 0;
        for(int i = 0; i < 4; i++){
            porcentajeDisponibilidad
            += listaProductos[i].darCantidadUnidadesDisponibles();
        }
        porcentajeDisponibilidad = (100 - (porcentajeDisponibilidad * 100 / 4));
        return porcentajeDisponibilidad;

    }

    public double darDonacionPorTipo(char pTipo){

        double donacionPorTipo = 0;
        for(int i = 0; i < 4; i++){

            if(listaProductos[i].darTipo() == pTipo
            && listaProductos[i].esFope()){
                donacionPorTipo += listaProductos[i].calcularDonacionFopre();

            }
        }
        return donacionPorTipo;

    }

    public int darCantidadUnidadesCompradasFopre(char pTipo){

        int unidadesCompradasFopre = 0;
        for(int i = 0; i < 4; i++){

            if(listaProductos[i].esFrope()){unidadesCompradasFopre
              += listaProductos[i].darCantidadUnidadesCompradas();}
              
        }
        return unidadesCompradasFopre;

    }

    public void darProductoMasComprado(){

        int aux = 0;
        for(int i = 1; i < 4; i++){
            if(listaProductos[aux] > listaProductos[i]){aux = i;}
        }
        return listaProductos[aux];

    }

    public double darDonacionTotal(){

        double donacionTotal = 0;
        for(int i = 0; i < 4; i++){

            if(listaProductos[i].esFopre()){
                donacionTotal += listaProductos[i].calcularDonacionFopre()
                * listaProductos[i].darCantidadUnidadesCompradas();

            }
        }
        return donacionTotal;

    }

}
