package modelutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MedicineModel;
import model.MedicineXML;
import utils.FileUtils;

/**
 * MedicineDao class
 * 
 * @author viettuts.vn
 */
public class MedicineUtil {
    private static final String MEDICINE_FILE_NAME = "medicine.xml";
    private List<MedicineModel> listMedicines;
    

    public MedicineUtil() {
        this.listMedicines = readListMedicines();
        if (listMedicines == null) {
            listMedicines = new ArrayList<MedicineModel>();
        }
    }
    
    public void writeListMedicines(List<MedicineModel> medicines) {
        MedicineXML medicineXML = new MedicineXML();
        medicineXML.setMedicines(medicines);
        FileUtils.writeXMLtoFile(MEDICINE_FILE_NAME, medicineXML);
    }

    public List<MedicineModel> readListMedicines() {
        List<MedicineModel> list = new ArrayList<MedicineModel>();
        MedicineXML medicineXML = (MedicineXML) FileUtils.readXMLFile(
                MEDICINE_FILE_NAME, MedicineXML.class);
        
        
        if (medicineXML != null) {
            list = medicineXML.getMedicines();
        }
        return list;
    }
    

    public void add(MedicineModel medicine) {
        listMedicines.add(medicine);
        writeListMedicines(listMedicines);
    }


    public void edit(MedicineModel medicine) {
        int size = listMedicines.size();
        for (int i = 0; i < size; i++) {
            if (listMedicines.get(i).getId() == medicine.getId()) {
                listMedicines.get(i).setName(medicine.getName());
                listMedicines.get(i).setNSX(medicine.getNSX());
                listMedicines.get(i).setHSD(medicine.getHSD());
                listMedicines.get(i).setIdBill(medicine.getIdBill());
                listMedicines.get(i).setIdProduction(medicine.getIdProduction());
                listMedicines.get(i).setProductionSource(medicine.getProductionSource());
                writeListMedicines(listMedicines);
                break;
            }
        }
    }


    public boolean delete(MedicineModel medicine) {
        boolean isFound = false;
        int size = listMedicines.size();
        for (int i = 0; i < size; i++) {
            if (listMedicines.get(i).getId() == medicine.getId()) {
                medicine = listMedicines.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listMedicines.remove(medicine);
            writeListMedicines(listMedicines);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách student theo name theo tứ tự tăng dần
     */
    public void sortMedicineByName() {
        Collections.sort(listMedicines, new Comparator<MedicineModel>() {
            @Override
            public int compare(MedicineModel medicine1, MedicineModel medicine2) {
                return String.valueOf(medicine1.getName()).compareTo(String.valueOf(medicine2.getName()));
            }
        });
    }

    public void sortStudentByID() {
        Collections.sort(listMedicines, new Comparator<MedicineModel>() {
            @Override
            public int compare(MedicineModel medicine1, MedicineModel medicine2) {
                return String.valueOf(medicine1.getId()).compareTo(String.valueOf(medicine2.getId()));
            }
        });
    }

    public List<MedicineModel> getListMedicines() {
        return listMedicines;
    }

    public void setListMedicines(List<MedicineModel> listMedicines) {
        this.listMedicines = listMedicines;
    }

    public void sortMedicineByNSX() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Collections.sort(listMedicines, new Comparator<MedicineModel>() {
            @Override
            public int compare(MedicineModel medicine1, MedicineModel medicine2) {
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 = dateFormat.parse(medicine1.getNSX());
                    date2 = dateFormat.parse(medicine2.getNSX());
                    System.out.println(date1.compareTo(date2));
                    return date1.compareTo(date2);
                } catch (ParseException ex) {
                    System.out.println("Error");
                }
                return medicine1.getNSX().compareTo(medicine2.getNSX());
            }
        });
    }

    public void sortMedicineByHSD() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Collections.sort(listMedicines, new Comparator<MedicineModel>() {
            @Override
            public int compare(MedicineModel medicine1, MedicineModel medicine2) {
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 = dateFormat.parse(medicine1.getHSD());
                    date2 = dateFormat.parse(medicine2.getHSD());
                    System.out.println(date1.compareTo(date2));
                    return date1.compareTo(date2);
                } catch (ParseException ex) {
                    System.out.println("Error");
                }
                return medicine1.getHSD().compareTo(medicine2.getHSD());
            }
        });
    }

    public void sortMedicineByIdBill() {
        Collections.sort(listMedicines, new Comparator<MedicineModel>() {
            @Override
            public int compare(MedicineModel medicine1, MedicineModel medicine2) {
                return medicine1.getIdBill().compareTo(medicine2.getIdBill());
            }
        });
    }

    public void sortMedicineByIdProduction() {
        Collections.sort(listMedicines, new Comparator<MedicineModel>() {
            @Override
            public int compare(MedicineModel medicine1, MedicineModel medicine2) {
                return medicine1.getIdProduction().compareTo(medicine2.getIdProduction());
            }
        });
    }

    public void sortMedicineByProductionSource() {
        Collections.sort(listMedicines, new Comparator<MedicineModel>() {
            @Override
            public int compare(MedicineModel medicine1, MedicineModel medicine2) {
                return medicine1.getProductionSource().compareTo(medicine2.getProductionSource());
            }
        });
    }
}