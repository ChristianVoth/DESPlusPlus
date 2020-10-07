package mensaComponents;



import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;



/**
 *
 */
public class StartMultithreading {



    public static void main(String [] args) throws InterruptedException, ExecutionException, Exception {

       String filename= "data122334";

       String simulationID = "1";
        int numSimulations = 5;

        Mensa currentModel;

        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(processors);
        List<Future<ArrayList<Report>>> listOfFutures = new ArrayList<>();

        System.out.println("Hauptthread gestartet");

        // create for every processor in your computer a thread
       for (int i = 0; i < 2; i++) {
            Callable<ArrayList<Report>> callableCustomThread = new CustomThread("Thread " + (i + 1));
            Future<ArrayList<Report>> futureCounterResult = pool.submit(callableCustomThread);
            listOfFutures.add(futureCounterResult);
        }
       for (Future<ArrayList<Report>> future : listOfFutures) {
           System.out.println(future.get());
       }
        pool.shutdown();

       double FD_meanLength = 0;
       double FD_meanWaitingTime = 0;

       double CO_meanLength = 0;
       double CO_meanWaitingTime = 0;

       double FD_medianLength = 0;
       double FD_medianWaitingTime = 0;

       double CO_medianLength = 0;
       double CO_medianWaitingTime = 0;

       double FD_25Length = 0;
       double FD_25WaitingTime = 0;

       double CO_25Length = 0;
       double CO_25WaitingTime = 0;

       double FD_75Length = 0;
       double FD_75WaitingTime = 0;

       double CO_75Length = 0;
       double CO_75WaitingTime = 0;

       int counter = 0;


        for (Future<ArrayList<Report>> future : listOfFutures) {
            for(int i = 0; i < future.get().size(); i++){


                FD_meanLength += future.get().get(i).meanReport.studentFDQueue_meanLength;
                FD_meanWaitingTime += future.get().get(i).meanReport.studentFDQueue_meanWaitingTime;

                CO_meanLength += future.get().get(i).meanReport.studentCOQueue_meanLength;
                CO_meanWaitingTime += future.get().get(i).meanReport.studentCOQueue_meanWaitingTime;

                FD_medianLength += future.get().get(i).medianReport.studentFDQueue_medianQueueLength;
                FD_medianWaitingTime += future.get().get(i).medianReport.studentFDQueue_medianWaitingTime;

                CO_medianLength += future.get().get(i).medianReport.studentCOQueue_medianQueueLength;
                CO_medianWaitingTime += future.get().get(i).medianReport.studentCOQueue_medianWaitingTime;

                FD_25Length += future.get().get(i).percentile25Report.studentFDQueue_25QueueLength;
                FD_25WaitingTime += future.get().get(i).percentile25Report.studentFDQueue_25WaitingTime;

                CO_25Length += future.get().get(i).percentile25Report.studentCOQueue_25QueueLength;
                CO_25WaitingTime += future.get().get(i).percentile25Report.studentCOQueue_25WaitingTime;

                FD_75Length += future.get().get(i).percentile75Report.studentFDQueue_75QueueLength;
                FD_75WaitingTime += future.get().get(i).percentile75Report.studentFDQueue_75WaitingTime;

                CO_75Length += future.get().get(i).percentile75Report.studentCOQueue_75QueueLength;
                CO_75WaitingTime += future.get().get(i).percentile75Report.studentCOQueue_75WaitingTime;



                counter++;
            }
        }

        FD_meanLength = FD_meanLength / counter;
        FD_meanWaitingTime = FD_meanWaitingTime / counter;

        CO_meanLength = CO_meanLength / counter;
        CO_meanWaitingTime = CO_meanWaitingTime / counter;

        FD_medianLength = FD_medianLength / counter;
        FD_medianWaitingTime = FD_medianWaitingTime / counter;

        CO_medianLength = CO_medianLength / counter;
        CO_medianWaitingTime = CO_medianWaitingTime / counter;

        FD_25Length = FD_25Length / counter;
        FD_25WaitingTime = FD_25WaitingTime / counter;

        CO_25Length = CO_25Length / counter;
        CO_25WaitingTime = CO_25WaitingTime / counter;

        FD_75Length = FD_75Length / counter;
        FD_75WaitingTime = FD_75WaitingTime / counter;

        CO_75Length = CO_75Length / counter;
        CO_75WaitingTime = CO_75WaitingTime / counter;

        System.out.println("\n" + "Mean FDQueue Length " + FD_meanLength);
        System.out.println("Median FDQueue Length " + FD_medianLength);
        System.out.println("First Quantile FDQueue Length " + FD_25Length);
        System.out.println("Third Quantile FDQueue Length " + FD_75Length + "\n");

        System.out.println("Mean FDQueue Waiting Time " + FD_meanWaitingTime);
        System.out.println("Median FDQueue Waiting Time " + FD_medianWaitingTime);
        System.out.println("First Quantile FDQueue Waiting Time " + FD_25WaitingTime);
        System.out.println("Third Quantile FDQueue Waiting Time " + FD_75WaitingTime + "\n");

        System.out.println("Mean COQueue Length " + CO_meanLength);
        System.out.println("Median COQueue Length " + CO_medianLength);
        System.out.println("First Quantile COQueue " + CO_25Length);
        System.out.println("Third Quantile COQueue " + CO_75Length + "\n");

        System.out.println("Mean COQueue Waiting Time " + CO_meanWaitingTime);
        System.out.println("Median COQueue Waiting Time " + CO_medianWaitingTime);
        System.out.println("First Quantile Waiting Time " + CO_25WaitingTime);
        System.out.println("Third Quantile Waiting Time " + CO_75WaitingTime + "\n");

        System.out.println(counter);



        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();

        Element element = document.createElement("SimulationRun");
        document.appendChild(element);

        Attr attr = document.createAttribute("Id");

        attr.setValue(simulationID);
        element.setAttributeNode(attr);

        Element meanFDQueue = document.createElement("MeanFoodDistributionQueue");
        meanFDQueue.appendChild(document.createTextNode(String.valueOf(FD_meanLength)));
        element.appendChild(meanFDQueue);

        Element medianFDLength = document.createElement("FoodDistributionMedianLength");
        medianFDLength.appendChild(document.createTextNode(String.valueOf(FD_medianLength)));
        element.appendChild(medianFDLength);

        Element firstQunatileFDQueueLength = document.createElement("FirstQuantileFoodDistribtionQueueLength");
        firstQunatileFDQueueLength.appendChild(document.createTextNode(String.valueOf(FD_25Length)));
        element.appendChild(firstQunatileFDQueueLength);

        Element thirdQuantileFDQueueLength = document.createElement("ThirdQuantileFDQueueLength");
        thirdQuantileFDQueueLength.appendChild(document.createTextNode(String.valueOf(FD_75Length)));
        element.appendChild(thirdQuantileFDQueueLength);

        Element meanFDQueueWaitingTime = document.createElement("MeanFDQueueWaitingTime");
        meanFDQueueWaitingTime.appendChild(document.createTextNode(String.valueOf(FD_meanWaitingTime)));
        element.appendChild(meanFDQueueWaitingTime);

        Element medianFDQueueWaitingTime = document.createElement("MedianFDQueueWaitingTime");
        medianFDQueueWaitingTime.appendChild(document.createTextNode(String.valueOf(FD_medianWaitingTime)));
        element.appendChild(medianFDQueueWaitingTime);

        Element firstQuantileFDQueueWaitingTime = document.createElement("FirstQuantileFDQueueWaitingTime");
        firstQuantileFDQueueWaitingTime.appendChild(document.createTextNode(String.valueOf(FD_25WaitingTime)));
        element.appendChild(firstQuantileFDQueueWaitingTime);

        Element thirdQuantileFDQueueWaitingTime = document.createElement("ThirdQuantileFDQueueWaitingTime");
        thirdQuantileFDQueueWaitingTime.appendChild(document.createTextNode(String.valueOf(FD_75WaitingTime)));
        element.appendChild(thirdQuantileFDQueueWaitingTime);

        Element meanCDQueueLength = document.createElement("MeanCOQueueLength");
        meanCDQueueLength.appendChild(document.createTextNode(String.valueOf(CO_meanLength)));
        element.appendChild(meanCDQueueLength);

        Element medianCOQueueLength = document.createElement("MedianCOQueueLength");
        medianCOQueueLength.appendChild(document.createTextNode(String.valueOf(CO_medianLength)));
        element.appendChild(medianCOQueueLength);

        Element firstQuantileCOQueue = document.createElement("FirstQuantileCOQueue");
        firstQuantileCOQueue.appendChild(document.createTextNode(String.valueOf(CO_25Length)));
        element.appendChild(firstQuantileCOQueue);

        Element thirdQunatileCOQueue = document.createElement("ThirdQuantileCOQueue");
        thirdQunatileCOQueue.appendChild(document.createTextNode(String.valueOf(CO_75Length)));
        element.appendChild(thirdQunatileCOQueue);

        Element meanCOQueueWaitingTime = document.createElement("MeanCOQueueWaitingTime");
        meanCOQueueWaitingTime.appendChild(document.createTextNode(String.valueOf(CO_meanWaitingTime)));
        element.appendChild(meanCOQueueWaitingTime);

        Element medianCOQueueWaitingTime = document.createElement("MedianCOQueueWaitingTime");
        medianCOQueueWaitingTime.appendChild(document.createTextNode(String.valueOf(CO_medianWaitingTime)));
        element.appendChild(medianCOQueueWaitingTime);

        Element firstQuantileWaitingTime = document.createElement("FirstQuantileWaitingTime");
        firstQuantileWaitingTime.appendChild(document.createTextNode(String.valueOf(CO_25WaitingTime)));
        element.appendChild(firstQuantileWaitingTime);

        Element thirdQuantileWaitingTime = document.createElement("ThirdQuantileWaitingTime");
        thirdQuantileWaitingTime.appendChild(document.createTextNode(String.valueOf(CO_75WaitingTime)));
        element.appendChild(thirdQuantileWaitingTime);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);


        StreamResult streamResult = new StreamResult(new File("C:\\XML\\" + filename +".fxml"));

        transformer.transform(source, streamResult);



    }

}
