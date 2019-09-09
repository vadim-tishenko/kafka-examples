package ru.cwl.kafkaexamples.importcsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvDataImporter {


    public  <T> List<T> loadTsv(String fileName, Class<T> aClass) throws FileNotFoundException {
        HeaderColumnNameToPropertyMappingStrategy<T> mappingStrategy = new HeaderColumnNameToPropertyMappingStrategy<T>(aClass);

        CsvToBean<T> tsvToBean = new CsvToBeanBuilder<T>(new FileReader(fileName))
                .withSeparator('\t')
                .withMappingStrategy(mappingStrategy)
                .withType(aClass).build();

        return tsvToBean.parse();
    }
}
