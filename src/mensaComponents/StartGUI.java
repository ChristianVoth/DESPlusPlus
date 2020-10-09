package mensaComponents;

import Multithreading.Multithreading;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

public class StartGUI extends JFrame {

    private JTextField simulationsTextField2;
    private JTextField foodDistributionTextField2;
    private JTextField checkoutsTextField2;
    private JTextField threadsTextField2;
    private JTextField filenameTextField2;
    private JTextField threadsTextField1;
    private JTextField simulationsTextField1;
    private JTextField foodDistributionTextField1;
    private JTextField checkoutsTextField1;
    private JTextField filenameTextField1;
    private JButton showBoxPlotButton;
    private JButton startSimulationButton1;
    private JButton startSimulationButton2;
    private JPanel mainPanel;



    public StartGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        startSimulationButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int numOfThreads = (Integer.parseInt(threadsTextField1.getText()));
                int numOfSimulations = (Integer.parseInt(simulationsTextField1.getText()));
                int numOfFoodDistributions = (Integer.parseInt(foodDistributionTextField1.getText()));
                int numOfCheckouts = (Integer.parseInt(checkoutsTextField1.getText()));
                String filename = filenameTextField1.getText();

                Multithreading startMultithreading = new Multithreading(numOfThreads, numOfSimulations, numOfFoodDistributions, numOfCheckouts, filename);

                try {
                    startMultithreading.startMultithreading();
                } catch (TransformerException transformerException) {
                    transformerException.printStackTrace();
                } catch (ParserConfigurationException parserConfigurationException) {
                    parserConfigurationException.printStackTrace();
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });


        startSimulationButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int numOfThreads = (Integer.parseInt(threadsTextField2.getText()));
                int numOfSimulations = (Integer.parseInt(simulationsTextField2.getText()));
                int numOfFoodDistributions = (Integer.parseInt(foodDistributionTextField2.getText()));
                int numOfCheckouts = (Integer.parseInt(checkoutsTextField2.getText()));
                String filename = filenameTextField2.getText();

                Multithreading startMultithreading = new Multithreading(numOfThreads, numOfSimulations, numOfFoodDistributions, numOfCheckouts, filename);

                try {
                    startMultithreading.startMultithreading();
                } catch (TransformerException transformerException) {
                    transformerException.printStackTrace();
                } catch (ParserConfigurationException parserConfigurationException) {
                    parserConfigurationException.printStackTrace();
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        showBoxPlotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new StartGUI("Discrete Event Simulation");
        frame.setVisible(true);
    }
}
