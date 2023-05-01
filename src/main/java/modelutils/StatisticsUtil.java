/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelutils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.StatisticsModel;
import model.StatisticsXML;
import utils.FileUtils;

/**
 *
 * @author PV
 */
public class StatisticsUtil {
    private static final String STAT_FILE_NAME = "statistic.xml";
    private List<StatisticsModel> listStatistics;
    LocalDate currentDate;
    
    public StatisticsUtil() {
        this.listStatistics = readListMedicines();
        if (listStatistics == null) {
            listStatistics = new ArrayList<StatisticsModel>();
        }
    }

    private List<StatisticsModel> readListMedicines() {
        List<StatisticsModel> list = new ArrayList<StatisticsModel>();
        StatisticsXML medicineXML = (StatisticsXML) FileUtils.readXMLFile(
                STAT_FILE_NAME, StatisticsXML.class);
        
        
        if (medicineXML != null) {
            list = medicineXML.getStatistics();
        }
        return list;
    }
    
    public void writeListMedicines(List<StatisticsModel> stats) {
        StatisticsXML statXML = new StatisticsXML();
        statXML.setStatistics(stats);
        FileUtils.writeXMLtoFile(STAT_FILE_NAME, statXML);
    }
    
    public void add(){
        currentDate = LocalDate.now();
        boolean check=false;
        for(StatisticsModel statisticsModel:listStatistics){
            if(statisticsModel.getMonth().equals(String.valueOf(currentDate.getMonth()))){
                check = true;
                statisticsModel.setValue(statisticsModel.getValue()+1);
                writeListMedicines(listStatistics);
                return;
            }
        }
        if(!check){
            StatisticsModel statisticsModel = new StatisticsModel(String.valueOf(currentDate.getMonth()),1);
            listStatistics.add(statisticsModel);
            writeListMedicines(listStatistics);
        }
    }
    
    public void delete(){
        currentDate = LocalDate.now();
        boolean check=false;
        for(StatisticsModel statisticsModel:listStatistics){
            if(statisticsModel.getMonth().equals(String.valueOf(currentDate.getMonth()))){
                check = true;
                statisticsModel.setValue(statisticsModel.getValue()-1);
                writeListMedicines(listStatistics);
                return;
            }
        }
        if(!check){
            StatisticsModel statisticsModel = new StatisticsModel(String.valueOf(currentDate.getMonth()),0);
            writeListMedicines(listStatistics);
        }
    }

    public List<StatisticsModel> getListStatistics() {
        return listStatistics;
    }

    public void setListStatistics(List<StatisticsModel> listStatistics) {
        this.listStatistics = listStatistics;
    }
    
    
    
    public static void main(String[] args) {
        StatisticsUtil s = new StatisticsUtil();
    }
}
