package KSRZadanie2.View;


import KSRZadanie2.Model.Match;
import KSRZadanie2.Model.Summary.FirstTypeSummary;
import KSRZadanie2.Model.Summary.SecondTypeSummary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainWindowHelper {
    MainController controller;
    Match match;

    public MainWindowHelper(MainController mainController) {
        controller = mainController;
        match = new Match();
    }

    public void PrepareMemberFuncComboBox(JComboBox comboBox) {
        comboBox.addItem(controller.dataContext.rectangleMemberFunc.ToString());
        comboBox.addItem(controller.dataContext.triangleMemberFunc.ToString());
    }

    public void PrepareAttributesComboBox(JComboBox comboBox) {
        comboBox.addItem("HomeTeamShots");
        comboBox.addItem("AwayTeamShots");

    }

    public void AddToComboBox(JComboBox comboBox, String label) {
        comboBox.addItem(label);
    }

    public void PrepareSumarriesTable(JTable table) {
        DefaultTableModel rowModel = new DefaultTableModel(new String[]{"Tresc podsumowania", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11"}, 0);
        for(FirstTypeSummary summary : controller.dataContext.summaries1) {
            rowModel.addRow(
                    new Object[]{
                            summary.toString(),
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                    }
            );
        }
        for(SecondTypeSummary summary : controller.dataContext.summaries2) {
            rowModel.addRow(
                    new Object[]{
                            summary.toString(),
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0",
                    }
            );
        }
        table.setModel(rowModel);
    }

}
