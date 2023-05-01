/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PV
 */

@XmlRootElement(name = "statistic")
@XmlAccessorType(XmlAccessType.FIELD)

public class StatisticsModel {
    String month;
    int value;

    public StatisticsModel() {
    }

    public StatisticsModel(String month, int value) {
        this.month = month;
        this.value = value;
    }

    public String getMonth() {
        return month;
    }

    public int getValue() {
        return value;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
