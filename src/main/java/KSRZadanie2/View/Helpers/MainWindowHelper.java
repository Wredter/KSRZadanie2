package KSRZadanie2.View.Helpers;

import KSRZadanie2.Model.Match;
import KSRZadanie2.Model.Quality;
import KSRZadanie2.View.MainController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;

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
        comboBox.addItem(match.ToStringFullTimeHomeGoals());
        comboBox.addItem(match.ToStringFullTimeAwayGoals());

        comboBox.addItem(match.ToStringHalfTimeHomeTeamGoals());
        comboBox.addItem(match.ToStringHalfTimeAwayTeamGoals());

        comboBox.addItem(match.ToStringHomeTeamShoots());
        comboBox.addItem(match.ToStringAwayTeamShots());

        comboBox.addItem(match.ToStringHomeTeamShotsOnTarget());
        comboBox.addItem(match.ToStringAwayTeamShotsOnTarget());

        comboBox.addItem(match.ToStringHomeTeamFoulsCommitted());
        comboBox.addItem(match.ToStringAwayTeamFoulsCommitted());
    }

    public void AddToComboBox(JComboBox comboBox, String label) {
        comboBox.addItem(label);
    }

    public void PrepareSumarriesTable(JTable table) {
        DefaultTableModel rowModel = new DefaultTableModel(new String[]{"Tresc podsumowania", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T"}, 0);
        for(Quality summary : controller.dataContext.summaries1) {
            if (summary != null) {
                rowModel.addRow(
                        new Object[]{
                                summary.summaryType1.toString(),
                                String.valueOf(summary.qualities.get(0)),
                                String.valueOf(summary.qualities.get(1)),
                                String.valueOf(summary.qualities.get(2)),
                                String.valueOf(summary.qualities.get(3)),
                                String.valueOf(summary.qualities.get(4)),
                                String.valueOf(summary.qualities.get(5)),
                                String.valueOf(summary.qualities.get(6)),
                                String.valueOf(summary.qualities.get(7)),
                                String.valueOf(summary.qualities.get(8)),
                                String.valueOf(summary.qualities.get(9)),
                                String.valueOf(summary.qualities.get(10)),
                                String.valueOf(summary.qualities.get(11)),
                        }
                );
            }
        }
        for(Quality summary : controller.dataContext.summaries2) {
            if (summary != null) {
                rowModel.addRow(
                        new Object[]{
                                summary.summaryType1.toString(),
                                String.valueOf(summary.qualities.get(0)),
                                String.valueOf(summary.qualities.get(1)),
                                String.valueOf(summary.qualities.get(2)),
                                String.valueOf(summary.qualities.get(3)),
                                String.valueOf(summary.qualities.get(4)),
                                String.valueOf(summary.qualities.get(5)),
                                String.valueOf(summary.qualities.get(6)),
                                String.valueOf(summary.qualities.get(7)),
                                String.valueOf(summary.qualities.get(8)),
                                String.valueOf(summary.qualities.get(9)),
                                String.valueOf(summary.qualities.get(10)),
                                String.valueOf(summary.qualities.get(11)),
                        }
                );
            }
        }
        table.setModel(rowModel);
    }

    public void PrepareSumarizerValuesTable(JTable table) {
        DefaultTableModel rowModel = new DefaultTableModel(new String[]{"Atrybut", "Min", "Max"}, 0);

        AddAttrMinMaxToRowModel(rowModel, match.ToStringFullTimeHomeGoals());
        AddAttrMinMaxToRowModel(rowModel, match.ToStringFullTimeAwayGoals());

        AddAttrMinMaxToRowModel(rowModel, match.ToStringHalfTimeHomeTeamGoals());
        AddAttrMinMaxToRowModel(rowModel, match.ToStringHalfTimeAwayTeamGoals());

        AddAttrMinMaxToRowModel(rowModel, match.ToStringHomeTeamShoots());
        AddAttrMinMaxToRowModel(rowModel, match.ToStringAwayTeamShots());

        AddAttrMinMaxToRowModel(rowModel, match.ToStringHomeTeamShotsOnTarget());
        AddAttrMinMaxToRowModel(rowModel, match.ToStringAwayTeamShotsOnTarget());

        AddAttrMinMaxToRowModel(rowModel, match.ToStringHomeTeamFoulsCommitted());
        AddAttrMinMaxToRowModel(rowModel, match.ToStringAwayTeamFoulsCommitted());

        table.setModel(rowModel);
    }

    private void AddAttrMinMaxToRowModel(DefaultTableModel rowModel, String attr) {
        rowModel.addRow(
                new Object[] {
                        attr,
                        GetMin(attr),
                        GetMax(attr),
                }
        );
    }

    private Double GetMax(String sttr) {
        ArrayList<Double> list = controller.PrepareAttributeValuesList(sttr);

        return  Collections.max(list);
    }

    private Double GetMin(String sttr) {
        ArrayList<Double> list = controller.PrepareAttributeValuesList(sttr);

        return  Collections.min(list);
    }

}
