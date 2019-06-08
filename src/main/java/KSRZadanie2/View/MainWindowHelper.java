package KSRZadanie2.View;

import javax.swing.*;

public class MainWindowHelper {
    MainController controller;

    public MainWindowHelper(MainController mainController) {
        controller = mainController;
    }

    public void PrepareMemberFuncComboBox(JComboBox comboBox) {
        comboBox.addItem(controller.dataContext.rectangleMemberFunc.ToString());
        comboBox.addItem(controller.dataContext.triangleMemberFunc.ToString());
    }
}
