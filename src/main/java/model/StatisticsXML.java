/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PV
 */

@XmlRootElement(name = "statistics")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatisticsXML {
    private List<StatisticsModel> statistics;

    public List<StatisticsModel> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<StatisticsModel> statistics) {
        this.statistics = statistics;
    }
}
