/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.MedicineModel;
import modelutils.MedicineUtil;
import modelutils.StatisticsUtil;
import view.DashView;
import view.LoginView;


/**
 *
 * @author PV
 */
public class DashBoardController {
    private DashView view;
    private MedicineUtil medicines;
    private StatisticsUtil stats;

    public DashBoardController(DashView view) {
        this.view = view;
        medicines = new MedicineUtil();  
        stats = new StatisticsUtil();
        medicines.readListMedicines();
        
        view.addGeneralListener(new GeneralActionListener());
        view.addGeneralListener(new GeneralMouseListener());
        view.addListMedicineSelectionListener(new ListMedicineSelectionListener());
        view.addAddMedicineListener(new AddButtonListenerFirst());
        view.addEdiMedicineListener(new EditButtonListenerFirst());
        view.addsearchButtonListener(new SearchListener());
        view.addDeleteMedicineListener(new DeleteButtonListener());
        view.addSortButtonListener(new SortButtonListener());
        view.addStatListener(new StatMouseListener());
        view.addStatListener(new StatActionListener());
        view.addLogout(new LogoutListener());
    }
    
    public void showMedicineList() {
        List<MedicineModel> medicinesList = medicines.getListMedicines();
        view.setVisible(true);
        view.showListmMedicines(medicinesList);
    }
    
    public void showMedicineList(MedicineUtil medicineUtil) {
        List<MedicineModel> medicinesList = medicineUtil.getListMedicines();
        view.setVisible(true);
        view.showListmMedicines(medicinesList);
    }
    
    public void showMedicineList(List<MedicineModel> medicineList) {
        List<MedicineModel> medicinesList = medicineList;
        view.setVisible(true);
        view.showListmMedicines(medicinesList);
    }

    private class LogoutListener implements MouseListener {

        public LogoutListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            view.setVisible(false);
            LoginView loginView = new LoginView();
            LoginController controller = new LoginController(loginView);
            // hiển thị màn hình login
            controller.showLoginView();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class StatMouseListener implements MouseListener {

        public StatMouseListener() {
            view.showLineChart(stats.getListStatistics());
            view.showPieChart(stats.getListStatistics());
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class StatActionListener implements ActionListener {

        public StatActionListener() {
            view.showLineChart(stats.getListStatistics());
            view.showPieChart(stats.getListStatistics());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }

    private class SortButtonListener implements ActionListener {

        public SortButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String typeSort = view.getTypeSort();
            if(typeSort==null) typeSort="";
            switch (typeSort) {
                case "ID": {
                    medicines.sortStudentByID();
                    break;
                }
                case "Tên" :                     {
                    medicines.sortMedicineByName();
                    break;
                }
                case "NSX" :                     {
                    medicines.sortMedicineByNSX();
                    break;
                }
                case "HSD" :                     {
                    medicines.sortMedicineByHSD();
                    break;
                } 
                case "Số lô" :                    {
                    medicines.sortMedicineByIdBill();
                    break;
                } 
                case "Số hàng" :                    {
                    
                    medicines.sortMedicineByIdProduction();
                    break;
                } 
                
                case "Nguồn nhập":{
                    medicines.sortMedicineByProductionSource();
                    break;
                }
                
                default : 
                {
                    view.showMessage("Hãy chọn tiêu chí sắp xếp");
                    return;
                }
            }
            view.showListmMedicines(medicines.getListMedicines());
        }
    }

    private class DeleteButtonListener implements ActionListener {

        public DeleteButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MedicineModel student = view.getMedicineInfo();
            if (student != null) {
                medicines.delete(student);
                                
                stats.delete();
                
                view.clearMedicinetInfo();
                view.showListmMedicines(medicines.getListMedicines());
                view.showLineChart(stats.getListStatistics());
                view.showPieChart(stats.getListStatistics());
                view.showMessage("Xóa thành công!");
            }
        }
    }

    private class AddButtonListener implements ActionListener {

        public AddButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MedicineModel medicine = view.getMedicineInfo();
            if(medicine!=null){
                
                stats.add();
                Map<Integer,Integer> m = new HashMap<>();
                List<MedicineModel> ls = medicines.getListMedicines();
                for(MedicineModel medicineModel:ls){
                    m.put(medicineModel.getId(), 1);
                }
                int id = medicine.getId();
                while(m.get(id)!=null&&m.get(id)==1){
                    id++;
                }
                medicine.setId(id);
                medicines.add(medicine);
                view.showMedicine(medicine);
                view.showListmMedicines(medicines.getListMedicines());
                view.showLineChart(stats.getListStatistics());
                view.showPieChart(stats.getListStatistics());
                view.showMessage("Thêm thành công!");
            }
        }
    }

    private class AddButtonListenerFirst implements ActionListener {

        public AddButtonListenerFirst() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearMedicinetInfo();
            view.addAddButtonListener(new AddButtonListener());
            view.removeAddMedicineListener(this);
        }
    }

    private class EditButtonListener implements ActionListener {

        public EditButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MedicineModel medicine = view.getMedicineInfo();
            if(medicine!=null){
                medicines.edit(medicine);
                view.showMedicine(medicine);
                view.showListmMedicines(medicines.getListMedicines());
                view.showMessage("Cập nhật thành công!");
            }
        }
    }

    private class EditButtonListenerFirst implements ActionListener {

        public EditButtonListenerFirst() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.addEdiMedicineListener(new EditButtonListener());
            view.removeEditMedicineListener(this);
        }
    }

    private class ListMedicineSelectionListener implements ListSelectionListener {

        public ListMedicineSelectionListener() {
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            view.fillMedicinetFromSelectedRow();
        }
    }

    private class SearchListener implements ActionListener {

        public SearchListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            List<MedicineModel> searchMedicine = new ArrayList<>();
            String typeSearch = view.getTypeSearch();
            String searchField = view.getSearchField().toLowerCase();
            if(typeSearch==null){
                typeSearch = "";
            }
            switch (typeSearch) {
                case "ID" :                 {
                    for(MedicineModel medicineModel: medicines.getListMedicines()){
                       if(String.valueOf(medicineModel.getId()).toLowerCase().contains(searchField)) {
                           //System.out.println(medicineModel.getId());
                           searchMedicine.add(medicineModel);
                       }
                    }
                    break;
                }
                case "Tên" :                     {
                    for(MedicineModel medicineModel: medicines.getListMedicines()){
                       if(String.valueOf(medicineModel.getName()).toLowerCase().contains(searchField)) searchMedicine.add(medicineModel);
                    }
                    break;
                }
                case "NSX" :                     {
                    for(MedicineModel medicineModel: medicines.getListMedicines()){
                       if(String.valueOf(medicineModel.getNSX()).toLowerCase().contains(searchField)) searchMedicine.add(medicineModel);
                    }
                    break;
                }
                case "HSD" :                     {
                    for(MedicineModel medicineModel: medicines.getListMedicines()){
                       if(String.valueOf(medicineModel.getHSD()).toLowerCase().contains(searchField)) searchMedicine.add(medicineModel);
                    }
                    break;
                } 
                case "Số lô" :                     {
                    for(MedicineModel medicineModel: medicines.getListMedicines()){
                       if(String.valueOf(medicineModel.getIdBill()).toLowerCase().contains(searchField)) searchMedicine.add(medicineModel);
                    }
                    break;
                } 
                case "Số hàng" :                     {
                    for(MedicineModel medicineModel: medicines.getListMedicines()){
                       if(String.valueOf(medicineModel.getIdProduction()).toLowerCase().contains(searchField)) searchMedicine.add(medicineModel);
                    }
                    break;
                } 
                case "Nguồn nhập" : 
                {
                    for(MedicineModel medicineModel: medicines.getListMedicines()){
                       if(String.valueOf(medicineModel.getProductionSource()).toLowerCase().contains(searchField)) searchMedicine.add(medicineModel);
                    }
                    break;
                }
                default: {
                    view.showMessage("Hãy chọn tiêu chí tìm kiếm");
                    return;
                }
            }
            showMedicineList(searchMedicine);
        }
    }

    private class GeneralActionListener implements ActionListener {

        public GeneralActionListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.removeAllMedicineListener();
            view.addAddMedicineListener(new AddButtonListenerFirst());
            view.addEdiMedicineListener(new EditButtonListenerFirst());
            showMedicineList();
        }
    }

    private class GeneralMouseListener implements MouseListener {

        public GeneralMouseListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            view.removeAllMedicineListener();
            view.addAddMedicineListener(new AddButtonListenerFirst());
            view.addEdiMedicineListener(new EditButtonListenerFirst());
            showMedicineList();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    
}
