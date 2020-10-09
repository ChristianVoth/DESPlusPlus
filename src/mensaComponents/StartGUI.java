package mensaComponents;

import Multithreading.Multithreading;
import Multithreading.FinalReport;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class StartGUI extends JFrame {


    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTabbedPane TabPanel;
    private JPanel Tab1;
    private JPanel Tab2;
    private JTextField textThreads1;
    private JTextField textSimulation1;
    private JTextField textFD1;
    private JTextField textCO1;
    private JTextField textThreads2;
    private JTextField textSimulation2;
    private JTextField textFD2;
    private JTextField textCO2;
    private JTextField textDBThreads1;
    private JTextField textDBSimulation1;
    private JTextField textDBThreads2;
    private JTextField textDBSimulation2;
    private JLabel labelSimulation2;
    private JLabel labelDBSimulation1;
    private JLabel labelDBSimulation2;
    private JButton btnDBSimulation1;
    private JButton btnDBSimulation2;
    private JButton btnSimulation1;
    private JButton btnSimulation2;
    private JButton btnBarChart;
    private JButton btnDBBarChart;
    private JComboBox comboBoxDBSimulation1;
    private JComboBox comboBoxDBSimulation2;
    private JComboBox comboBoxSimulation1;
    private JLabel labelSimulation1;
    private JComboBox comboBoxSimulation2;
    private FinalReport finalReportSimulation1;
    private FinalReport finalReportSimulation2;
    private FinalReport finalReportSimulationDB1;
    private FinalReport finalReportSimulationDB2;
    private int numOfStaff;



    public StartGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();



        btnSimulation1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numOfThreads = (Integer.parseInt(textThreads1.getText()));
                int numOfSimulations = (Integer.parseInt(textSimulation1.getText()));
                int numOfFoodDistributions = (Integer.parseInt(textFD1.getText()));
                int numOfCheckout = (Integer.parseInt(textCO1.getText()));
                String selectedValue = comboBoxSimulation1.getSelectedItem().toString();
                numOfStaff = (Integer.parseInt(selectedValue));


                 Multithreading startMultithreading = new Multithreading(numOfThreads, numOfSimulations, numOfFoodDistributions, numOfCheckout, numOfStaff,2);

                try {
                    startMultithreading.startMultithreading();
                    finalReportSimulation1 = startMultithreading.getFinalReport();
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            }
        });
        btnSimulation2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numOfThreads = (Integer.parseInt(textThreads2.getText()));
                int numOfSimulations = (Integer.parseInt(textSimulation2.getText()));
                int numOfFoodDistributions = (Integer.parseInt(textFD2.getText()));
                int numOfCheckout = (Integer.parseInt(textCO2.getText()));

                String selectedValue = comboBoxSimulation2.getSelectedItem().toString();
                numOfStaff = (Integer.parseInt(selectedValue));

                Multithreading startMultithreading = new Multithreading(numOfThreads, numOfSimulations, numOfFoodDistributions, numOfCheckout,numOfStaff,  2);

                try {
                    startMultithreading.startMultithreading();
                    finalReportSimulation2 = startMultithreading.getFinalReport();
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        btnDBSimulation1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numOfThreads = (Integer.parseInt(textDBThreads1.getText()));
                int numOfSimulations = (Integer.parseInt(textDBSimulation1.getText()));

                String selectedValue = comboBoxDBSimulation1.getSelectedItem().toString();
                numOfStaff = (Integer.parseInt(selectedValue));


                Multithreading startMultithreading = new Multithreading(numOfThreads,  numOfSimulations,numOfStaff, 1);

                try {
                    startMultithreading.startMultithreading();
                    finalReportSimulationDB1 = startMultithreading.getFinalReport();
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        btnDBSimulation2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numOfThreads = (Integer.parseInt(textDBThreads2.getText()));
                int numOfSimulations = (Integer.parseInt(textDBSimulation2.getText()));

                String selectedValue = comboBoxDBSimulation2.getSelectedItem().toString();
                numOfStaff = (Integer.parseInt(selectedValue));

                Multithreading startMultithreading = new Multithreading(numOfThreads,  numOfSimulations, numOfStaff,1);

                try {
                    startMultithreading.startMultithreading();
                    finalReportSimulationDB2 = startMultithreading.getFinalReport();
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        btnBarChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                DefaultCategoryDataset dcd = new DefaultCategoryDataset();

                String series1 = "Simulation 1";
                String series2 = "Simulation 2";

                String category1 = "Max Queue Length Food Distribution";
                String category2 = "Mean Queue Length Food Distribution";
                String category3= "Median Queue Length Food Distribution";
                String category4 = "Max Queue Length Checkout";
                String category5 = "Mean Queue Length Checkout";
                String category6 = "Median Queue Length Checkout";

                dcd.addValue(finalReportSimulation1.maxQueueLength1, series1, category1);
                dcd.addValue(finalReportSimulation1.meanQueueLength1, series1, category2);
                dcd.addValue(finalReportSimulation1.medianQueueLength1, series1, category3);
                dcd.addValue(finalReportSimulation2.maxQueueLength1, series2, category1);
                dcd.addValue(finalReportSimulation2.meanQueueLength1, series2, category2);
                dcd.addValue(finalReportSimulation2.medianQueueLength1, series2, category3);
                dcd.addValue(finalReportSimulation1.maxQueueLength2, series1, category4);
                dcd.addValue(finalReportSimulation1.meanQueueLength2, series1, category5);
                dcd.addValue(finalReportSimulation1.medianQueueLength2, series1, category6);
                dcd.addValue(finalReportSimulation2.maxQueueLength2, series2, category4);
                dcd.addValue(finalReportSimulation2.meanQueueLength2, series2, category5);
                dcd.addValue(finalReportSimulation2.medianQueueLength2, series2, category6);


                DefaultCategoryDataset dcd1 = new DefaultCategoryDataset();

                String timeSeries1 = "Simulation 1";
                String timeSeries2 = "Simulation 2";

                String timeCategory1 = "Max Waiting Time Food Distribution";
                String timeCategory2 = "Mean Waiting Time Food Distribution";
                String timeCategory3 = "Median Waiting Time Food Distribution";
                String timeCategory4 = "Max Waiting Time Checkout";
                String timeCategory5 = "Mean Waiting Time Checkout";
                String timeCategory6 = "Median Waiting Time Checkout";

                dcd1.addValue(finalReportSimulation1.maxWaitingTime1, timeSeries1, timeCategory1);
                dcd1.addValue(finalReportSimulation1.meanWaitingTime1, timeSeries1, timeCategory2);
                dcd1.addValue(finalReportSimulation1.medianWaitingTime1, timeSeries1, timeCategory3);
                dcd1.addValue(finalReportSimulation2.maxWaitingTime1, timeSeries2, timeCategory1);
                dcd1.addValue(finalReportSimulation2.meanWaitingTime1, timeSeries2, timeCategory2);
                dcd1.addValue(finalReportSimulation2.medianWaitingTime1, timeSeries2, timeCategory3);
                dcd1.addValue(finalReportSimulation1.maxWaitingTime2, series1, timeCategory4);
                dcd1.addValue(finalReportSimulation1.meanWaitingTime2, series1, timeCategory5);
                dcd1.addValue(finalReportSimulation1.medianWaitingTime2, series1, timeCategory6);
                dcd1.addValue(finalReportSimulation2.maxWaitingTime2, series2, timeCategory4);
                dcd1.addValue(finalReportSimulation2.meanWaitingTime2, series2, timeCategory5);
                dcd1.addValue(finalReportSimulation2.medianWaitingTime2, series2, timeCategory6);

                JFreeChart jchart1 = ChartFactory.createBarChart("Queue Length", "Statistically Significant Values", "Values", dcd, PlotOrientation.VERTICAL, true, true, false);
                JFreeChart jchart2 = ChartFactory.createBarChart("Waiting Time", "Statistically Significant Values", "Values", dcd1, PlotOrientation.VERTICAL, true, true, false);

                CategoryPlot plot = jchart1.getCategoryPlot();
                plot.setRangeGridlinePaint(Color.black);

                CategoryPlot plot1 = jchart2.getCategoryPlot();
                plot.setRangeGridlinePaint(Color.black);

                JFrame jframe = new JFrame("Statistics");
                jframe.setLayout(new GridLayout());
                jframe.setPreferredSize(new Dimension(1600,900));
                jframe.getContentPane().add(new ChartPanel(jchart1), BorderLayout.NORTH);
                jframe.getContentPane().add(new ChartPanel(jchart2), BorderLayout.CENTER);
                jframe.pack();
                jframe.setVisible(true);


            }
        });
        btnDBBarChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dcd = new DefaultCategoryDataset();

                String series1 = "Simulation 1";
                String series2 = "Simulation 2";

                String category1 = "Max Queue Length Food Distribution";
                String category2 = "Mean Queue Length Food Distribution";
                String category3= "Median Queue Length Food Distribution";
                String category4 = "Max Queue Length Checkout";
                String category5 = "Mean Queue Length Checkout";
                String category6 = "Median Queue Length Checkout";

                dcd.addValue(finalReportSimulationDB1.maxQueueLength1, series1, category1);
                dcd.addValue(finalReportSimulationDB1.meanQueueLength1, series1, category2);
                dcd.addValue(finalReportSimulationDB1.medianQueueLength1, series1, category3);
                dcd.addValue(finalReportSimulationDB2.maxQueueLength1, series2, category1);
                dcd.addValue(finalReportSimulationDB2.meanQueueLength1, series2, category2);
                dcd.addValue(finalReportSimulationDB2.medianQueueLength1, series2, category3);
                dcd.addValue(finalReportSimulationDB1.maxQueueLength2, series1, category4);
                dcd.addValue(finalReportSimulationDB1.meanQueueLength2, series1, category5);
                dcd.addValue(finalReportSimulationDB1.medianQueueLength2, series1, category6);
                dcd.addValue(finalReportSimulationDB2.maxQueueLength2, series2, category4);
                dcd.addValue(finalReportSimulationDB2.meanQueueLength2, series2, category5);
                dcd.addValue(finalReportSimulationDB2.medianQueueLength2, series2, category6);

                DefaultCategoryDataset dcd1 = new DefaultCategoryDataset();

                String timeSeries1 = "Simulation 1";
                String timeSeries2 = "Simulation 2";

                String timeCategory1 = "Max Waiting Time";
                String timeCategory2 = "Mean Waiting Time";
                String timeCategory3 = "Median Waiting Time";
                String timeCategory4 = "Max Waiting Time Checkout";
                String timeCategory5 = "Mean Waiting Time Checkout";
                String timeCategory6 = "Median Waiting Time Checkout";

                dcd1.addValue(finalReportSimulationDB1.maxWaitingTime1, timeSeries1, timeCategory1);
                dcd1.addValue(finalReportSimulationDB1.meanWaitingTime1, timeSeries1, timeCategory2);
                dcd1.addValue(finalReportSimulationDB1.medianWaitingTime1, timeSeries1, timeCategory3);
                dcd1.addValue(finalReportSimulationDB2.maxWaitingTime1, timeSeries2, timeCategory1);
                dcd1.addValue(finalReportSimulationDB2.meanWaitingTime1, timeSeries2, timeCategory2);
                dcd1.addValue(finalReportSimulationDB2.medianWaitingTime1, timeSeries2, timeCategory3);
                dcd1.addValue(finalReportSimulationDB1.maxQueueLength2, series1, timeCategory4);
                dcd1.addValue(finalReportSimulationDB1.meanQueueLength2, series1, timeCategory5);
                dcd1.addValue(finalReportSimulationDB1.medianQueueLength2, series1, timeCategory6);
                dcd1.addValue(finalReportSimulationDB2.maxQueueLength2, series2, timeCategory4);
                dcd1.addValue(finalReportSimulationDB2.meanQueueLength2, series2, timeCategory5);
                dcd1.addValue(finalReportSimulationDB2.medianQueueLength2, series2, timeCategory6);

                JFreeChart jchart1 = ChartFactory.createBarChart("Queue Length", "Statistically Significant Values", "Values", dcd, PlotOrientation.VERTICAL, true, true, false);
                JFreeChart jchart2 = ChartFactory.createBarChart("Waiting Time", "Statistically Significant Values", "Values", dcd1, PlotOrientation.VERTICAL, true, true, false);

                CategoryPlot plot = jchart1.getCategoryPlot();
                plot.setRangeGridlinePaint(Color.black);

                CategoryPlot plot1 = jchart2.getCategoryPlot();
                plot.setRangeGridlinePaint(Color.black);

                JFrame jframe = new JFrame("Statistics");
                jframe.setLayout(new GridLayout());
                jframe.setPreferredSize(new Dimension(1600,900));
                jframe.getContentPane().add(new ChartPanel(jchart1), BorderLayout.NORTH);
                jframe.getContentPane().add(new ChartPanel(jchart2), BorderLayout.CENTER);
                jframe.pack();
                jframe.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new StartGUI("Discrete Event Simulation");
        frame.setVisible(true);
    }
}
