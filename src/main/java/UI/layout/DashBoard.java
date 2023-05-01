package UI.layout;

import net.miginfocom.swing.MigLayout;

import UI.layout.swing.ButtonCus;
import view.DashBoardView;

import javax.swing.*;
import javax.swing.text.Element;
import javax.swing.text.TableView;

import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class DashBoard extends JPanel {
    public JPanel feaPane, topPane, workPane;
    private ButtonCus filterBtn, searchBtn, addBtn, editBtn, removeBtn;
    // table
    private JTable tableContent;
    private Object data = new Object [][] {};
    private String [] columnNames = new String [] {
            "ID", "Name", "Duration", "Bill", "Production","Source"};
    private JScrollPane jScrollPaneTableContent;
    
    
    public DashBoard(){
        init();
    }

    void init(){
        setLayout(new BorderLayout());

        //TOP:
        topPane = new JPanel();
        
        
        
        topPane.setPreferredSize(new Dimension(1000,70));
        topPane.setBackground(new Color(65, 105, 225));
//        BackgroundPane background = new BackgroundPane();
//        background.setBackground(ImageIO.read(new File("/path/to/your/image/on/your/disk")));
        topPane.setLayout(new MigLayout("fill", "30[][]push", "push[]push"));
        topPane.add(new JLabel(new ImageIcon("src/main/java/UI/icon/app_syp.png")));
        JLabel label1 = new JLabel("MEDICINE MANAGE");
        label1.setFont(new Font("Calibri", 3, 24));
        label1.setForeground(Color.WHITE);
        topPane.add(label1);

        add(topPane, BorderLayout.NORTH);


        //Dashboard
        feaPane = new JPanel();
        feaPane.setLayout(new MigLayout("fillx, inset 0 0 0 0, w 200:200:200, h 550:550:550",
                "[]","0[center]0"));
        Color colorFea = new Color(65, 105, 225);
        feaPane.setBackground(colorFea);


        filterBtn = createButton("Home", new ImageIcon("src/main/java/UI/icon/user.png"), colorFea);
        feaPane.add(filterBtn, "wrap, w 200:200:200, h 50:50:50");

        searchBtn = createButton("Search Medicine", new ImageIcon("src/main/java/UI/icon/search.png"), colorFea);
        feaPane.add(searchBtn, "grow, wrap, h 50:50:50");

        addBtn = createButton("Add Medicine", new ImageIcon("src/main/java/UI/icon/user.png"), colorFea);
        feaPane.add(addBtn, "grow, wrap, h 50:50:50");

        editBtn = createButton("Edit Medicine", new ImageIcon("src/main/java/UI/icon/user.png"), colorFea);
        feaPane.add(editBtn, "grow, wrap, h 50:50:50");

        removeBtn = createButton("Delete Medicine", new ImageIcon("src/main/java/UI/icon/user.png"), colorFea);
        feaPane.add(removeBtn, "grow, wrap, h 50:50:50");


        add(feaPane, BorderLayout.EAST);

        
        // Content
        workPane = new JPanel(new MigLayout("fill", "fill", "fill"));
        
        
        // table
        tableContent = new JTable();
        tableContent.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        tableContent.getTableHeader().setForeground(new Color(255,255,255));
        tableContent.setRowHeight(25);
        tableContent.getTableHeader().setOpaque(false);
        tableContent.getTableHeader().setBackground(new Color(32,136,203));
        jScrollPaneTableContent = new JScrollPane();
        tableContent.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneTableContent.setViewportView(tableContent);
        //
        workPane.add(jScrollPaneTableContent, "grow, wrap, w 800:800:800, h 500:500:500");
        workPane.setBackground(Color.WHITE);
        add(workPane, BorderLayout.CENTER);
        setPreferredSize(new Dimension(1000, 600));
//        jScrollPaneTableContent.setVisible(false);
        //jScrollPaneTableContent.setPreferredSize(new Dimension (480, 300));
        
        
        
        
        
        
    }

    public ButtonCus createButton(String text, ImageIcon a, Color color){
        ButtonCus temp = new ButtonCus();
        temp.setText(text);
        temp.setIcon(a);
        temp.setOvalH(0);
//        temp.setHorizontalAlignment(SwingConstants.CENTER);
//        temp.setMargin(new Insets(0, 20, 0, 0));
        temp.setBackground(color);
        temp.setEffectColor(temp.getBackground());
        temp.setOverColor(new Color(115, 11, 131));
        temp.setBorder(null);
        temp.setFont(new Font("Calibri", 1, 16));
        temp.setForeground(Color.WHITE);
        return temp;
    }

    public ButtonCus getFilterBtn() {
        return filterBtn;
    }

    public ButtonCus getSearchBtn() {
        return searchBtn;
    }

    public ButtonCus getAddBtn() {
        return addBtn;
    }

    public ButtonCus getEditBtn() {
        return editBtn;
    }

    public ButtonCus getRemoveBtn() {
        return removeBtn;
    }
    
}
