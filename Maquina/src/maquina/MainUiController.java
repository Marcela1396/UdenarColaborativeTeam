
package maquina;

import clases.MaquinaExpendedora;
import clases.Monto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 * @nombre: Proceso de compra y venta de un producto de la Máquina Expendedora.
 * @objetivo: Construir la Interfaz grafica
 * @descripción: Permite simular el uso de una maquina expendedora de alimentos,
 * facilitando su compra de acuerdo a un monto establecido y al dinero ingresado
 * por el usuario.
 * @colaborador: Luis España
 * @zona: PAS-01
 * @fecha: 11 - Abril 2018
 * @versión. 1.1
*/

public class MainUiController implements Initializable {

    //--------------------------------------- Otras variables 
    private String pIdentificador;
    private MaquinaExpendedora m;
    //---------------------------------------  Contenedores
    @FXML
    private Pane main_panel;
    @FXML
    private Pane panel_menu;
    @FXML
    private Pane panel_comprar_producto;
    @FXML
    private Pane panel_agregar_monedas;
    @FXML
    private Pane panel_terminar_compra;
    @FXML
    private Pane panel_unidades_compradas;
    @FXML
    private Pane panel_producto_mas_comprado;
    @FXML
    private Pane panel_valor_total;
    @FXML
    private Pane panel_porcentaje_disp;
    @FXML
    private Pane panel_info_fopre;
    
    // ----------------------------------------  Botones
    @FXML
    private Pane btn_comprar_prod;
    @FXML
    private Pane btn_terminar_compra;
    @FXML
    private Pane btn_agregar_moneda;
    @FXML
    private Pane btn_unidades_compradas;
    @FXML
    private Pane btn_producto_mas_comprado;
    @FXML
    private Pane btn_valor_total;
    @FXML
    private Pane btn_porcentaje_disp;
    @FXML
    private Pane btn_info_fopre;
    @FXML
    private Pane btn_A;
    @FXML
    private Pane btn_B;
    @FXML
    private Pane btn_1;
    @FXML
    private Pane btn_2;
    @FXML
    private Pane btn_info;
    //------------------------------------ labels
    @FXML
    private Label lbl_info_comprar;
    @FXML
    private Label lbl_unidades_compradas;
    @FXML
    private Label lbl_info_prod_mas_comprado;
    @FXML
    private Label lbl_info_valor_total;
    @FXML
    private Label lbl_info_porcentaje_disp;
    @FXML
    private Label lbl_info_fopre;
    
    
    @FXML
    private Label lbl_papas_disp;
    @FXML
    private Label lbl_papa_precio;
    @FXML
    private Label lbl__papas_tipo;
    @FXML
    private Label lbl__papas_fopre;
    
    @FXML
    private Label lbl_jugo_disp;
    @FXML
    private Label lbl_jugo_precio;
    @FXML
    private Label lbl_jugo_tipo;
    @FXML
    private Label lbl_jugo_fopre;
   
    @FXML
    private Label lbl_jet_disp;
    @FXML
    private Label lbl_jet_precio;
    @FXML
    private Label lbl_jet_tipo;
    @FXML
    private Label lbl_jet_fopre;
    
    @FXML
    private Label lbl_galleta_disp;
    @FXML
    private Label lbl_galleta_precio;
    @FXML
    private Label lbl_galleta_tipo;
    @FXML
    private Label lbl_galleta_fopre;
    
    @FXML
    private Label lbl_saldo;
    //------------------------------------------ botones monedas
    @FXML
    private Pane btn_50;
    @FXML
    private Pane btn_100;
    @FXML
    private Pane btn_200;
    @FXML
    private Pane btn_500;
    @FXML
    private Pane btn_1000;
    
    //-------------------------------------------- Multiline Text
    @FXML
    private TextArea txt_info_term_compra;
    //---------------------------------------------------------- On click events
    @FXML
    private void btn_info_on_click(){
        this.desactivar_paneles();
        this.panel_menu.setVisible(true);
    }
    
    @FXML
    private void return_on_click(){
       this.desactivar_paneles();
       this.main_panel.setVisible(true);
    }
    
    @FXML
    private void btn_comprar_producto_on_click(){
       this.desactivar_paneles();
       this.panel_comprar_producto.setVisible(true);
       this.comprarProducto(pIdentificador);
       this.actualizar();
    }
    
    @FXML
    private void btn_terminar_compra_on_click(){
       this.desactivar_paneles();
       this.panel_terminar_compra.setVisible(true);
       this.terminarCompra();       
       this.actualizar();
    }
    
    @FXML
    private void btn_agregar_moneda_on_click(){
       this.desactivar_paneles();
       this.agregarMoneda();
    }
    
    @FXML
    private void btn_unidades_compradas_on_click(){
       this.desactivar_paneles();
       this.mostrarDialogoUnidadesCompradas();
    }
    
    @FXML
    private void btn_prod_mas_comp_on_click(){
       this.desactivar_paneles();
       this.panel_producto_mas_comprado.setVisible(true);
       this.darProductoMasComprado();
       
    }
    
    @FXML
    private void btn_valor_total_on_click(){
       this.desactivar_paneles();
       this.panel_valor_total.setVisible(true);
       this.darValorTotalCompras();
    }
    
    @FXML
    private void btn_porcentaje_disp_on_click(){
       this.desactivar_paneles();
       this.panel_porcentaje_disp.setVisible(true);
       this.darPorcentajeDeDisponibilidad();
    }
    
    @FXML
    private void btn_info_fopre_on_click(){
       this.desactivar_paneles();
       this.panel_info_fopre.setVisible(true);
       this.lbl_info_fopre.setText("Total:\t\t\t$ "+this.m.darDonacionTotal() + " COP\n\n"+
                                   "Comida:\t\t\t$ "+this.m.darDonacionPorTipo('C')+"\n\n"+
                                   "Bebida:\t\t\t$ "+this.m.darDonacionPorTipo('B'));
    }
    
    @FXML
    private void btn_a_on_click(){
        this.pIdentificador="A";
    }
    @FXML
    private void btn_b_on_click(){
        this.pIdentificador="B";
    }
    @FXML
    private void btn_1_on_click(){
        if(this.pIdentificador.compareTo("A")==0 || this.pIdentificador.compareTo("B")==0){
            this.pIdentificador += "1";
        }
    }
    @FXML
    private void btn_2_on_click(){
        if(this.pIdentificador.compareTo("A")==0 || this.pIdentificador.compareTo("B")==0){
            this.pIdentificador += "2";
        }
    }
    
    
    @FXML
    private void btn_50_on_click(){
        this.m.agregarMoneda(50);
        this.actualizar();
        this.return_on_click();
    }
    @FXML
    private void btn_100_on_click(){
        this.m.agregarMoneda(100);
        this.actualizar();
        this.return_on_click();
    }
    @FXML
    private void btn_200_on_click(){
        this.m.agregarMoneda(200);
        this.actualizar();
        this.return_on_click();
    }
    @FXML
    private void btn_500_on_click(){
        this.m.agregarMoneda(500);
        this.actualizar();
        this.return_on_click();
    }
    @FXML
    private void btn_1000_on_click(){
        this.m.agregarMoneda(1000);
        this.actualizar();
        this.return_on_click();
    }
    //--------------------------------------------------------------------------
    private void desactivar_paneles(){
        this.main_panel.setVisible(false);
        this.panel_menu.setVisible(false);
        this.panel_agregar_monedas.setVisible(false);
        this.panel_terminar_compra.setVisible(false);
        this.panel_comprar_producto.setVisible(false);
        this.panel_unidades_compradas.setVisible(false);
        this.panel_producto_mas_comprado.setVisible(false);
        this.panel_valor_total.setVisible(false);
        this.panel_porcentaje_disp.setVisible(false);
        this.panel_info_fopre.setVisible(false);
    }
    
    private void agregarMoneda(){
        this.panel_agregar_monedas.setVisible(true);
    }
    
    private void comprarProducto(String pIdentificador){
        if(this.pIdentificador.compareTo("A1")==0 || this.pIdentificador.compareTo("A2")==0 ||
          this.pIdentificador.compareTo("B1")==0 || this.pIdentificador.compareTo("B2")==0){
           if(m.comprarProducto(pIdentificador)){
               this.lbl_info_comprar.setText("La compra del producto fue exitosa");
               this.m.terminarCompra().cambiarValor(this.m.terminarCompra().darValorTotal()-this.m.darProducto(pIdentificador).darPrecio());
               this.lbl_saldo.setText(this.m.terminarCompra().darValorTotal()+"$");
           }
           else{
               this.lbl_info_comprar.setText("Error al comprar");
           }           
       }
       else{
           this.lbl_info_comprar.setText("No hay identificador seleccionado");
       }
        this.pIdentificador = "";
    }
    
    private void terminarCompra(){
        this.txt_info_term_compra.setText("Se terminó la compra. \n"
                                        +"El cambio es de: $" + (int)this.m.terminarCompra().darValorTotal()+" COP.\n\n"
       +"$1000\tx "+  this.m.terminarCompra().darCantidadMonedas1000() + " = $"+(int)this.m.terminarCompra().darCantidadMonedas1000()*1000+"\n"
       +"$500\t\tx "+ this.m.terminarCompra().darCantidadMonedas500() + " = $"+(int)this.m.terminarCompra().darCantidadMonedas500()*500+"\n"
       +"$200\t\tx "+ this.m.terminarCompra().darCantidadMonedas200() + " = $"+(int)this.m.terminarCompra().darCantidadMonedas200()*200+"\n"
       +"$100\t\tx "+ this.m.terminarCompra().darCantidadMonedas100() + " = $"+(int)this.m.terminarCompra().darCantidadMonedas100()*100+"\n"
       +"$50 \t\tx "+ this.m.terminarCompra().darCantidadMonedas50() + " = $"+(int)this.m.terminarCompra().darCantidadMonedas50()*50+"\n");
       this.txt_info_term_compra.setEditable(false); 
       
       this.m.terminarCompra().reiniciar();
    }
    
    private void darValorTotalCompras(){
        this.lbl_info_valor_total.setText("El valor total de las compras de la\n"
       +" maquina es $"+(int)this.m.darValorTotalCompras()+" COP");
    }
    
    private void darPorcentajeDeDisponibilidad(){
        this.lbl_info_porcentaje_disp.setText("El porcentaje de disponibilidad de\n"+
       "la maquina es del: "+m.darPorcentajeDisponibilidad()+"%");
    }
    
    private void mostrarDialogoUnidadesCompradas(){
       this.panel_unidades_compradas.setVisible(true);
       this.lbl_unidades_compradas.setText("Total\t\t\t\t\t"+m.darCantidadTotalUnidadesCompradas()+"\n"
       +"Papas Margarita\t\t\t"+m.darProducto("A1").darCantidadUnidadesCompradas()+"\n"
       +"Jugo Hit\t\t\t\t\t"   +m.darProducto("A2").darCantidadUnidadesCompradas()+"\n"
       +"Chocolatina Jet\t\t\t"+m.darProducto("B1").darCantidadUnidadesCompradas()+"\n"
       +"Galletas Festival\t\t\t"+m.darProducto("B2").darCantidadUnidadesCompradas()+"\n"
       );
    }
    
    private void darProductoMasComprado(){
        this.lbl_info_prod_mas_comprado.setText("El producto mas comprado es:\n"+
               this.m.darProductoMasComprado().darIdentificador() + " - " +
               this.m.darProductoMasComprado().darNombre()+"\n"+
               "Se han comprado "+ this.m.darProductoMasComprado().darCantidadUnidadesCompradas()+
               " unidades.");
    }
   
    private void actualizar(){
        this.pIdentificador="";
        this.lbl_saldo.setText("$" + (int)m.darValorCredito());
        this.lbl_papas_disp.setText(m.darProducto("A1").darCantidadUnidadesDisponibles()+"");
        this.lbl_papa_precio.setText((int)m.darProducto("A1").darPrecio()+"");
        if(m.darProducto("A1").darTipo() == 'C'){
            this.lbl__papas_tipo.setText("Comida");
        }
        else if(m.darProducto("A1").darTipo() == 'B'){
            this.lbl__papas_tipo.setText("Bebida");
        }
        
        if(m.darProducto("A1").esFopre()){
            this.lbl__papas_fopre.setText("Si");
        }
        else{
             this.lbl__papas_fopre.setText("No");
        }
        
        this.lbl_jugo_disp.setText(m.darProducto("A2").darCantidadUnidadesDisponibles()+"");
        this.lbl_jugo_precio.setText((int)m.darProducto("A2").darPrecio()+"");
        if(m.darProducto("A2").darTipo() == 'C'){
            this.lbl_jugo_tipo.setText("Comida");
        }
        else if(m.darProducto("A2").darTipo() == 'B'){
            this.lbl_jugo_tipo.setText("Bebida");
        }
        
        if(m.darProducto("A2").esFopre()){
            this.lbl_jugo_fopre.setText("Si");
        }
        else{
             this.lbl_jugo_fopre.setText("No");
        }
       
        this.lbl_jet_disp.setText(m.darProducto("B1").darCantidadUnidadesDisponibles()+"");
        this.lbl_jet_precio.setText((int)m.darProducto("B1").darPrecio()+"");
        if(m.darProducto("B1").darTipo() == 'C'){
            this.lbl_jet_tipo.setText("Comida");
        }
        else if(m.darProducto("B1").darTipo() == 'B'){
            this.lbl_jet_tipo.setText("Bebida");
        }
        
        if(m.darProducto("B1").esFopre()){
            this.lbl_jet_fopre.setText("Si");
        }
        else{
             this.lbl_jet_fopre.setText("No");
        }
        
        this.lbl_galleta_disp.setText(m.darProducto("B2").darCantidadUnidadesDisponibles()+"");
        this.lbl_galleta_precio.setText((int)m.darProducto("B2").darPrecio()+"");
        if(m.darProducto("B2").darTipo() == 'C'){
            this.lbl_galleta_tipo.setText("Comida");
        }
        else if(m.darProducto("B2").darTipo() == 'B'){
            this.lbl_galleta_tipo.setText("Bebida");
        }
        
        if(m.darProducto("B2").esFopre()){
            this.lbl_galleta_fopre.setText("Si");
        }
        else{
             this.lbl_galleta_fopre.setText("No");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.return_on_click();
        this.pIdentificador="";
        this.m = new MaquinaExpendedora();
        this.lbl_saldo.setText("$0");
        this.actualizar();
   }    
}
