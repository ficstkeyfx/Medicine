package model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "medicine")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicineModel implements Serializable{
    //private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String idBill;
    private String idProduction;
    private String productionSource;
    private String NSX,HSD;

    public MedicineModel() {
    }

    public MedicineModel(int id, String name, String idBill, String idProduction, String productionSource, String NSX, String HSD) {
        this.id = id;
        this.name = name;
        this.idBill = idBill;
        this.idProduction = idProduction;
        this.productionSource = productionSource;
        this.NSX = NSX;
        this.HSD = HSD;
    }

    

    public String getHSD() {
        return HSD;
    }

    public String getNSX() {
        return NSX;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }
    
    

    public String getIdProduction() {
        return idProduction;
    }

    public void setIdProduction(String idProduction) {
        this.idProduction = idProduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductionSource() {
        return productionSource;
    }

    public void setProductionSource(String productionSource) {
        this.productionSource = productionSource;
    } 
}
