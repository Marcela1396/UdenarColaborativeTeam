package MaquinaExpendedora;

/**
 * @nombre: Componente Monto.
 * @objetivo: Construir una aplicación que permita simular
 * el uso, por parte de un cliente, de una máquina
 * expendedora de alimentos, la cual contiene 4
 * productos. La aplicación permite al usuario (o cliente
 * de la máquina) añadir monedas a la máquina para
 * tener un crédito de compra, comprar productos, recibir
 * el cambio cuando haya terminado una compra y
 * conocer la información sobre las compras que ha
 * realizado en la máquina.
 * @descripción: Representa un monto.
 * @colaborador: Juan Pablo
 * @zona: PAS-04
 * @fecha: 8 - Abril 2018
 * @versión. 1.0
*/

public class Monto
{

    public final int MONEDA_50 = 50;
    public final int MONEDA_100 = 100;
    public final int MONEDA_200 = 200;
    public final int MONEDA_500 = 500;
    public final int MONEDA_1000 = 1000;
    public final int VALOR_MAXIMO = 10000;

    private int cantidadMonedas50;
    private int cantidadMonedas100;
    private int cantidadMonedas200;
    private int cantidadMonedas500;
    private int cantidadMonedas1000;
	    
    public Monto()
    {
   	ceros();
    }
    
    public int darCantidadMonedas50()
    {
        return cantidadMonedas50;
    }

    public int darCantidadMonedas100()
    {
        return cantidadMonedas100;
    }

    public int darCantidadMonedas200()
    {
        return cantidadMonedas200;
    }

    public int darCantidadMonedas500()
    {
        return cantidadMonedas500;
    }

    public int darCantidadMonedas1000()
    {
        return cantidadMonedas1000;
    }
    
    public double darValorTotal()
    {
        return  cantidadMonedas50*50+
                cantidadMonedas100*100+
                cantidadMonedas200*200+
                cantidadMonedas500*500+
                cantidadMonedas1000*1000;
    }
    
    public void reiniciar()
    {
        this.ceros();
    }
    
    public void cambiarValor(double pValor)
    {
        // PENDIENTE
    }
    
    public boolean agregarMoneda(int pMoneda)
    {
        if(darValorTotal() >= VALOR_MAXIMO) {return false;}
        else if(pMoneda == MONEDA_50) {cantidadMonedas50++;return true;}
        else if(pMoneda == MONEDA_100) {cantidadMonedas100++;return true;}
        else if(pMoneda == MONEDA_200) {cantidadMonedas200++;return true;}
        else if(pMoneda == MONEDA_500) {cantidadMonedas500++;return true;}
        else if(pMoneda == MONEDA_1000) {cantidadMonedas1000++;return true;}
        return false; // Si no se ingresa ninguna moneda conocida
    }
    
    private void ceros()
    {
        cantidadMonedas50 = 0;
	cantidadMonedas100 = 0;
	cantidadMonedas200 = 0;
	cantidadMonedas500 = 0;
	cantidadMonedas1000 = 0;
    }
      
}
