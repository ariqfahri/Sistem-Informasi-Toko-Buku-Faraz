/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.view.chart;

import faraz.database.JualBeliDatabase;
import faraz.entity.JualBeli;
import faraz.error.JualBeliException;
import faraz.service.JualBeliDao;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author FAM
 */
public class ChartJualBeli {

    public ChartJualBeli() {
    }
    
    public static void main(String arg[]) throws SQLException, JualBeliException {
        
        Format formatter = new SimpleDateFormat("dd MMM");
        
        List<JualBeli> jualbeli = new ArrayList<JualBeli>();
        JualBeliDao dao = JualBeliDatabase.getJualBeliDao();
        
        jualbeli = dao.chartJualBeli();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < jualbeli.size(); i++) {
            String tanggal = formatter.format(jualbeli.get(i).getTanggal_jualbeli());
            dataset.setValue(jualbeli.get(i).getTotal(), "Total", tanggal);
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Grafik Total Penjualan", "Tanggal Penjualan", "Rupiah",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.LIGHT_GRAY);
        chart.getTitle().setPaint(Color.BLACK);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartFrame frame = new ChartFrame("Grafik Penjualan", chart);
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
    }
}
