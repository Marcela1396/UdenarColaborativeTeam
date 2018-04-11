/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina;

import java.net.URL;
import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author neo
 */
public class MainUiController implements Initializable {

    //---------------------------------------  Contenedores
    @FXML
    private Pane main_panel;
    @FXML
    private Pane panel_menu;
    @FXML
    private Pane main_agregar_monedas;
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
    private void btn_info_on_click(){
        this.main_panel.setVisible(false);
        this.panel_menu.setVisible(true);
    }
    
    @FXML
    private void return_on_click(){
        this.main_panel.setVisible(true);
        this.panel_menu.setVisible(false);
        //this.panel_unidades_compradas.setVisible(false);
    }
    
    
    private void activar_panel(){
        /*if(this.panel_info_fopre){
            
        }*/
    }
    
    
    //@FXML
    //private void handleButtonAction(ActionEvent event) {
     //   System.out.println("You clicked me!");
     //   label.setText("Hello World!");
    //}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
