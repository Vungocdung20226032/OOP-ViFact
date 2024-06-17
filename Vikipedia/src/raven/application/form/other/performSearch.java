/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import raven.application.*;
import java.util.ArrayList;
import raven.data.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import jdk.internal.org.jline.terminal.TerminalBuilder;
import raven.application.form.other.*;
/**
 *
 * @author Quynh
 */
public class performSearch {
    private ArrayList<String> name;
    private String text;
    
    public performSearch(String t) {
        this.name = new ArrayList<String>();
        for (VWE virus : Application.enveList) {
            this.name.add(virus.getName());
        }
        
        for (VNE virus : Application.nonenveList) {
            this.name.add(virus.getName());
        }
        this.text = t;
        System.out.println(this.text);
    }
    
    public void search() {
    JFrame innerFrame = new JFrame();
    innerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    innerFrame.setSize(400, 300);

    String[] columns = {"Name"};

    ArrayList<String[]> dataList = new ArrayList<>();

    for (String n : name) {
        if (n.toLowerCase().contains(text.toLowerCase())) {
            dataList.add(new String[]{n}); // Add new String array with matching name
        }
    }

    // Convert dataList to a 2D array
    String[][] data = dataList.toArray(new String[0][]);

    DefaultTableModel model = new DefaultTableModel(data, columns) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // This will make the table non-editable
            return false;
        }
    };

    JTable result = new JTable(model);
    result.setFont(new Font("Serif", Font.BOLD, 18)); // Set font for rows
    result.setRowHeight(25); // Adjust row height to accommodate the larger font size

    // Set font for the table header
    JTableHeader header = result.getTableHeader();
    header.setFont(new Font("Serif", Font.BOLD, 18));

    // Add mouse listener to detect clicks on rows
    result.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow();
                // Assuming you want to display the selected name in the new frame
                String selectedName = (String)model.getValueAt(row, 0);
                // Call a method to open a new frame with the selected name
                int flag = 1;
                VWE last = null;
                VNE lastt = null;
                for(VWE virus : Application.enveList) {
                    if (virus.getName().equals(selectedName)) {
                        last = virus;
                        flag = 0;
                        break;
                    }
                }
                
                if (flag == 1) {
                    for(VNE virus : Application.nonenveList) {
                    if (virus.getName().equals(selectedName)) {
                        lastt = virus;
                        break;
                    }
                }
                }
                if (lastt == null) {
                    Enve enve = new Enve(last);
                    enve.setVisible(true);
                }
                else {
                    Nonenve nonenve = new Nonenve(lastt);
                    nonenve.setVisible(true);
                }
            }
        }
    });

    JScrollPane sp = new JScrollPane(result);
    innerFrame.add(sp);
    innerFrame.setVisible(true);
}
}
