package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import raven.data.*;
import raven.application.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.*;

public class FormEnve extends javax.swing.JPanel {

    private javax.swing.JLabel jLabel1;
    private JTable virusTable;
    private JScrollPane scrollPane; // Declaration of scrollPane

    public FormEnve() {
        initComponents();
        initTable(); // Initialize and set up the table
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Envelop Viruses");

        scrollPane = new JScrollPane(); // Initialization of scrollPane
        // Setup GroupLayout and include the JScrollPane
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE) // Adjust width as needed
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE) // Adjust height as needed
                .addGap(0, 34, Short.MAX_VALUE))
        );
    }

    private void initTable() {
    String[] columnNames = {"Name", "Scientific Name", "Discovered Date"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    for (VWE virus : Application.enveList) {
        model.addRow(new Object[]{virus.getName(), virus.getSciName(), virus.getDate()});
    }
    virusTable = new JTable(model) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // No cell can be edited
            return false;
        }
    };

    // Custom cell renderer to align text to the center
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    // Apply the renderer to each column
    for (int columnIndex = 0; columnIndex < virusTable.getColumnCount(); columnIndex++) {
        virusTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
    }

    virusTable.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) { // Single-click detection
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow(); // Get the clicked row
                int column = target.getSelectedColumn(); // Get the clicked column if needed
                String value = (String) target.getValueAt(row, column);
                int flag = 1;
                VWE last = null;
                VNE lastt = null;
                for(VWE virus : Application.enveList) {
                    if (virus.getName().equals(value) || virus.getDate().equals(value) || virus.getSciName().equals(value)) {
                        last = virus;
                        flag = 0;
                        break;
                    }
                }
                
                if (flag == 1) {
                    for(VNE virus : Application.nonenveList) {
                    if (virus.getName().equals(value) || virus.getDate().equals(value) || virus.getSciName().equals(value)) {
                        lastt = virus;
                        break;
                    }
                }
                }
                // Logic to switch to another frame
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

    virusTable.setRowHeight(50);
    virusTable.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16));
    JTableHeader header = virusTable.getTableHeader();
    header.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16)); // Adjust the font size and style as needed
    scrollPane.setViewportView(virusTable); // Add the JTable to the JScrollPane
}
}