package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class statistics_layout extends javax.swing.JPanel {

    public statistics_layout() {
        initComponents();
        createDailyStudentCountChart();
        initializeDualPieChartsForStudentsByDepartmentAndMajor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        studentCountByDayChartPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        studentDistributionChartPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Từ:");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MM/dd/yyyy"))));
        jFormattedTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Đến:");

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MM/dd/yyyy"))));
        jFormattedTextField2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(331, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout studentCountByDayChartPanelLayout = new javax.swing.GroupLayout(studentCountByDayChartPanel);
        studentCountByDayChartPanel.setLayout(studentCountByDayChartPanelLayout);
        studentCountByDayChartPanelLayout.setHorizontalGroup(
            studentCountByDayChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        studentCountByDayChartPanelLayout.setVerticalGroup(
            studentCountByDayChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jComboBox1, 0, 118, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout studentDistributionChartPanelLayout = new javax.swing.GroupLayout(studentDistributionChartPanel);
        studentDistributionChartPanel.setLayout(studentDistributionChartPanelLayout);
        studentDistributionChartPanelLayout.setHorizontalGroup(
            studentDistributionChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        studentDistributionChartPanelLayout.setVerticalGroup(
            studentDistributionChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(studentDistributionChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentDistributionChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentCountByDayChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentCountByDayChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ghi nhận", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Vi phạm", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Mượn trả", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel studentCountByDayChartPanel;
    private javax.swing.JPanel studentDistributionChartPanel;
    // End of variables declaration//GEN-END:variables

    // phương thức khởi tạo biểu đồ cột số lượng sinh viên vào theo ngày
    public void createDailyStudentCountChart() {
        // Tạo dữ liệu mẫu (viết hàm đẩy dữ liệu vào đây sau đó truyền nó vào phương thức này để vẽ biểu đồ)
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Số lượng sinh viên", "Ngày 1");
        dataset.addValue(20, "Số lượng sinh viên", "Ngày 2");
        dataset.addValue(15, "Số lượng sinh viên", "Ngày 3");
        dataset.addValue(25, "Số lượng sinh viên", "Ngày 4");
        // Tạo biểu đồ cột từ dữ liệu
        JFreeChart barChart = ChartFactory.createBarChart(
                "",
                "Số lượng sinh viên vào thư viện theo ngày",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                false, // Không hiển thị chú thích biểu đồ
                true,
                false
        );
        CategoryPlot plot = barChart.getCategoryPlot();
        // Thiết lập trục số nguyên cho trục y
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // Tùy chỉnh màu sắc của cột dữ liệu
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 221, 22)); // Đặt màu cho cột dữ liệu (series) thứ nhất
        // Thiết lập màu nền cho biểu đồ
        plot.setBackgroundPaint(Color.WHITE); // Màu nền trắng
        // Tạo một ChartPanel để chứa biểu đồ
        ChartPanel chartPanel = new ChartPanel(barChart);
        // Tạo một JPanel để chứa biểu đồ
        this.studentCountByDayChartPanel.setLayout(new BorderLayout());
        // Thêm ChartPanel vào JPanel
        this.studentCountByDayChartPanel.add(chartPanel, BorderLayout.CENTER);
    }

    // phương thức khởi tạo biểu đồ tròn thể hiện số lượng sinh viên theo khoa và theo ngành
    public void initializeDualPieChartsForStudentsByDepartmentAndMajor() {
        // Dữ liệu mẫu cho biểu đồ tròn 1 (viết hàm đẩy dữ liệu vào đây sau đó truyền nó vào phương thức này để vẽ biểu đồ)
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        dataset1.setValue("A", 30);
        dataset1.setValue("B", 40);
        dataset1.setValue("C", 20);

        // Dữ liệu mẫu cho biểu đồ tròn 2 (viết hàm đẩy dữ liệu vào đây sau đó truyền nó vào phương thức này để vẽ biểu đồ)
        DefaultPieDataset dataset2 = new DefaultPieDataset();
        dataset2.setValue("X", 25);
        dataset2.setValue("Y", 35);
        dataset2.setValue("Z", 40);

        // Tạo biểu đồ tròn 1
        JFreeChart pieChart1 = ChartFactory.createPieChart(
                "", // Tiêu đề
                dataset1, // Dữ liệu
                false, // tắt chú thích bên dưới biểu đồ
                true,
                false
        );
        // Thiết lập màu nền cho biểu đồ tròn 1
        Plot plot1 = pieChart1.getPlot();
        plot1.setBackgroundPaint(Color.WHITE);
        plot1.setOutlineVisible(false);

        // Tạo biểu đồ tròn 2
        JFreeChart pieChart2 = ChartFactory.createPieChart(
                "", // Tiêu đề
                dataset2, // Dữ liệu
                false, // tắt chú thích bên dưới biểu đồ
                true,
                false
        );
        // Thiết lập màu nền cho biểu đồ tròn 2
        Plot plot2 = pieChart2.getPlot();
        plot2.setBackgroundPaint(Color.WHITE);
        plot2.setOutlineVisible(false);

        // Tạo JPanel chứa biểu đồ tròn 1
        JPanel pieChartPanel1 = new JPanel(new BorderLayout());
        ChartPanel chartPanel1 = new ChartPanel(pieChart1);
        pieChartPanel1.add(chartPanel1, BorderLayout.CENTER);
        pieChartPanel1.setPreferredSize(new Dimension(175, 175)); // Đặt kích thước ưu tiên

        // Tạo JPanel chứa biểu đồ tròn 2
        JPanel pieChartPanel2 = new JPanel(new BorderLayout());
        ChartPanel chartPanel2 = new ChartPanel(pieChart2);
        pieChartPanel2.add(chartPanel2, BorderLayout.CENTER);
        pieChartPanel2.setPreferredSize(new Dimension(175, 175)); // Đặt kích thước ưu tiên

        //JPanel chứa cả hai biểu đồ tròn
        this.studentDistributionChartPanel.setLayout(new GridLayout(1, 2));
        this.studentDistributionChartPanel.add(pieChartPanel1);
        this.studentDistributionChartPanel.add(pieChartPanel2);
    }
}
