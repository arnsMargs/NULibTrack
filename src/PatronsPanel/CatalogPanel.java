package PatronsPanel;

import javax.swing.*;
import java.awt.*;
import Services.dB;

import LibTrackModel.modelBook;

public class CatalogPanel{
    private JPanel createCatalogPanel() {

    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(BorderFactory.createTitledBorder("Catalog"));

    String[] cols = {"Title","Author","Status"};
    Object[][] data = new Object[dB.books.size()][3];

    int i = 0;
    for(modelBook b : dB.books){
        data[i][0] = b.getTitle();
        data[i][1] = "Author"; // placeholder
        data[i][2] = b.isAvailable() ? "Available" : "Borrowed";
        i++;
    }

    JTable table = new JTable(data, cols);

    p.add(new JScrollPane(table));
    return p;
}

}

