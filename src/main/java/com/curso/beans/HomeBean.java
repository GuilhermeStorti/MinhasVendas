package com.curso.beans;

import com.curso.entidades.Graficos;
import com.curso.utils.JpaUtil;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilherme on 22/11/16.
 */
@ViewScoped
@ManagedBean(name = "homeBean")
public class HomeBean {

    private LineChartModel areaModel;
    private Graficos graficoCategoria;
    private List<Graficos> listCategoria;

    @PostConstruct
    public void init() {
        listCategoria = new ArrayList<>();
        buscarGraficoCategoria();
        createAreaModel();
    }

    private void buscarGraficoCategoria(){
        EntityManager manager = JpaUtil.getManager();
        String queryString = "SELECT c.descricao, count(v.idCategoria) from Veiculo v, Categoria c WHERE v.idCategoria = c.idCategoria GROUP BY v.idCategoria";
        Query query = manager.createNativeQuery(queryString);
        try {
            List<Object[]> result = query.getResultList();
            for(Object[] row : result){
                graficoCategoria = new Graficos();
                graficoCategoria.setDescricao(row[0].toString());
                graficoCategoria.setQuantidade(Integer.parseInt(row[1].toString()));
                listCategoria.add(graficoCategoria);
            }
        }catch (Exception ex){
            System.out.println("teste");
        }finally {
            JpaUtil.closeManager(manager);
        }
    }

    public LineChartModel getAreaModel() {
        return areaModel;
    }

    private void createAreaModel() {
        areaModel = new LineChartModel();

        LineChartSeries categoria = new LineChartSeries();
        categoria.setFill(true);
        categoria.setLabel("Categoria");

        for(Graficos grafico : listCategoria){
            categoria.set(grafico.getDescricao(), grafico.getQuantidade());
        }

        areaModel.addSeries(categoria);

        areaModel.setTitle("Quantidade de veiculos");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);

        Axis xAxis = new CategoryAxis("Categoria");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Quantidade");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

}
