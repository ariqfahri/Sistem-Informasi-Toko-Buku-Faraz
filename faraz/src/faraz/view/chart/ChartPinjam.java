/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.view.chart;

import faraz.database.PinjamDatabase;
import faraz.entity.Pinjam;
import faraz.error.PinjamException;
import faraz.service.PinjamDao;
import java.awt.Color;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author FAM
 */
public class ChartPinjam {

    public ChartPinjam() {
    }
    
    public static void main(String arg[]) throws SQLException, PinjamException {
        
        Format formatter = new SimpleDateFormat("dd MMM");
        
        List<Pinjam> pinjam = new ArrayList<Pinjam>();
        PinjamDao dao = PinjamDatabase.getPinjamDao();
        
        pinjam = dao.chartPinjam();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < pinjam.size(); i++) {
            String tanggal = formatter.format(pinjam.get(i).getTanggal_pinjam());
            dataset.setValue(pinjam.get(i).getHarga_pinjam(), "Total", tanggal);
            dataset.setValue(pinjam.get(i).getDenda(), "Denda", tanggal);
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Grafik Total dan Denda Peminjaman", "Tanggal Peminjaman", "Rupiah",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.LIGHT_GRAY);
        chart.getTitle().setPaint(Color.BLACK);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartFrame frame = new ChartFrame("Grafik Peminjaman", chart);
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
    }
}
