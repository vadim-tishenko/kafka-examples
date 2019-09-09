package ru.cwl.kafkaexamples.importcsv;

import ru.cwl.kafkaexamples.importcsv.dto.TfcSensor;
import ru.cwl.kafkaexamples.importcsv.dto.TrafficCsv;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CsvDataImporter imp = new CsvDataImporter();

        final String srcPath = "C:\\dev\\tmp\\refr\\";
        List<TrafficCsv> result = imp.loadTsv(srcPath + "TRAFFIC.tsv", TrafficCsv.class);

        final String fileName = srcPath + "TFC_SENSOR_21007.tsv";

        List<TfcSensor> result2 = imp.loadTsv(fileName, TfcSensor.class);

        String[] inFiles = {
                "TFC_SENSOR_3.tsv",
                "TFC_SENSOR_21007.tsv",
                "TFC_SENSOR_111007.tsv",
                "TFC_SENSOR_112007.tsv",
                "TFC_SENSOR_113007.tsv",
                "TFC_SENSOR_115007.tsv",
                "TFC_SENSOR_905007.tsv",
                "TFC_SENSOR_906007.tsv",
                "TFC_SENSOR_945007.tsv"
        };
        List<TfcSensor> resultAll = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            for (String inFile : inFiles) {
                List<TfcSensor> result3 = imp.loadTsv(srcPath+inFile, TfcSensor.class);
                resultAll.addAll(result3);
            }
        }

        System.out.println(resultAll.size());

    }

//    private static <T> List<T> loadTsv(String fileName, Class<T> aClass) throws FileNotFoundException {
//        HeaderColumnNameToPropertyMappingStrategy<T> mappingStrategy = new HeaderColumnNameToPropertyMappingStrategy<T>(aClass);
//
//        CsvToBean<T> tsvToBean = new CsvToBeanBuilder<T>(new FileReader(fileName))
//                .withSeparator('\t')
//                .withMappingStrategy(mappingStrategy)
//                .withType(aClass).build();
//
//        return tsvToBean.parse();
//    }
}
