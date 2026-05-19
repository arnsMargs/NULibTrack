package PatronsPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import LibTrackModel.modelBook;
import Services.dB;
import java.awt.*;

public class CatalogPanel extends JPanel {

    JTable table;
    DefaultTableModel model;

    public CatalogPanel(){

        setLayout(new BorderLayout());

        // 🔍 SEARCH FIELD
        JTextField search = new JTextField();
        search.setBorder(BorderFactory.createTitledBorder("Search Books"));

        // 🧾 TABLE
        String[] columns = {"ID", "Title", "Status"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        loadTable("");

        search.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyReleased(java.awt.event.KeyEvent e){
                loadTable(search.getText());
            }
        });

        add(search, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    // ✅ LOAD TABLE
    void loadTable(String keyword){

        model.setRowCount(0);

        for(modelBook b : dB.books){

            if(b.getTitle().toLowerCase().contains(keyword.toLowerCase())){

                model.addRow(new Object[]{
                    b.getId(),
                    b.getTitle(),
                    b.isAvailable() ? "Available" : "Unavailable"
                });
            }
        }
    }
}
