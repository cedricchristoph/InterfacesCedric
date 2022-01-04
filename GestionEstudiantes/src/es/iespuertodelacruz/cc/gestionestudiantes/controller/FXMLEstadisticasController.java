/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.controller;

import es.iespuertodelacruz.cc.gestionestudiantes.model.dao.RecetaDAO;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author cedric
 */
public class FXMLEstadisticasController implements Initializable {

    @FXML
    private BorderPane tipoRecetaContainer;
    @FXML
    private BorderPane compararCaloriasContainer;

    private List<Receta> recetas;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reloadCharts();
    }    

    private void reloadCharts() {
        if (!loadRecetas()) return;
        loadBarChart();
        loadPieChart();
    }
    
    private boolean loadRecetas() {
        RecetaDAO dao = new RecetaDAO();
        recetas = dao.selectAll();
        return recetas != null;
    }
    
    private void loadBarChart() {
        
        // Calcular datos
        
        HashMap<String, Integer> map = new HashMap<>();
        recetas.forEach(r -> {
            String tipo = r.getTipo().getTipo();
            if (map.containsKey(tipo))
                map.put(tipo, map.get(tipo) + 1);
            else
                map.put(tipo, 1);
        });
        
        
        // Llenar y mostrar grafico de barras
        
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> chart = new BarChart<String, Number>(xAxis, yAxis);
        chart.setBarGap(20);
        for(Node n:chart.lookupAll(".default-color0.chart-bar")) {
            n.getStyleClass().add("chart-bar");
        }
        //chart.setTitle("Diversidad de tipos de recetas");
        xAxis.setLabel("Tipo de receta");
        yAxis.setLabel("Recetas");
        
        XYChart.Series serie = new XYChart.Series();
        serie.setName("Existentes ahora");
        map.forEach((k, v) -> 
                serie.getData().add(new XYChart.Data(k, v))
        );
        
        chart.getData().add(serie);
        tipoRecetaContainer.setCenter(chart);

    }
    
    private void loadPieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        recetas.forEach(r -> 
                pieChartData.add(new PieChart.Data(r.getTitulo(), r.getCalorias()))
        );
        final PieChart chart = new PieChart(pieChartData);
        chart.setLegendSide(Side.RIGHT);
        compararCaloriasContainer.setCenter(chart);
        
    }
}
