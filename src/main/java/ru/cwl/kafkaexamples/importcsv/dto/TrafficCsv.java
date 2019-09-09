package ru.cwl.kafkaexamples.importcsv.dto;

import lombok.Data;

@Data
public class TrafficCsv {
    long idTraffic;
    long gmteventtime;
    byte isLocked;
    long idTr;
    byte isValidLocation;
    String lat;
    String lon;
    float alt;
    int speed;
    int heading;
    String eventvalue;
    String idEvent;
    String iostate;
    String mileage;
    long gmtsystime;
    String idDeviceEvent;
    long gmtlocationtime;
    String odometr;

    String unitRecnum;

}
