package KSRZadanie2.View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainWindow extends JFrame {
    MainController controller;

    //region JFrameElements
    private JPanel MainPanel;
    private JPanel LeftPanel;
    private JPanel SummarizerPanel;
    private JPanel QuantifierPanel;
    private JPanel ToolPanel;
    private JPanel RightPanel;
    private JPanel SummaryParametersPanel;
    private JPanel SummaryResultPanel;
    private JComboBox summarizerAtributes;
    private JTextField summarizerMemberFuncLabel;
    private JComboBox summarizerMemberFuncs;
    private JPanel SummarizerMemberFuncPanel;
    private JPanel SummarizerAtributesPanel;
    private JTextField summarizerMemberFuncParamA;
    private JTextField summarizerMemberFuncParamB;
    private JTextField summarizerMemberFuncParamC;
    private JTextField summarizerMemberFuncParamD;
    private JTextField quantifierMemberFuncLabel;
    private JTextField quantifierMemberFuncParamA;
    private JTextField quantifierMemberFuncParamB;
    private JTextField quantifierMemberFuncParamC;
    private JTextField quantifierMemberFuncParamD;
    private JComboBox quantifierMemberFuncs;
    private JPanel MemberFuncParamsPanel;
    //endregion

    public MainWindow() {
        super("Okno główne");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocation(50, 50);
        setVisible(true);

        CreateMainPanelStructure();
        add(MainPanel);

        controller = new MainController();
    }

    public void CreateMainPanelStructure() {
        MainPanel.setLayout(new GridLayout(1, 2));

        CreateLeftPanelStructure();
        MainPanel.add(LeftPanel);

        CreateRightPanelStructure();
        MainPanel.add(RightPanel);
    }

    public void CreateLeftPanelStructure() {
        TitledBorder title;
        LeftPanel.setLayout(new GridLayout(3, 1));


        CreateSummarizationPanelStructure();
        LeftPanel.add(SummarizerPanel);

        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Kwantyfikator");
        QuantifierPanel.setBorder(title);
        LeftPanel.add(QuantifierPanel);

        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Akcje");
        ToolPanel.setBorder(title);
        LeftPanel.add(ToolPanel);
    }

    public void CreateRightPanelStructure() {
        TitledBorder title;
        RightPanel.setLayout(new GridLayout(2, 1));

        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Parametry podsumowania");
        SummaryParametersPanel.setBorder(title);
        RightPanel.add(SummaryParametersPanel);

        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Wyniki podsumowania");
        SummaryResultPanel.setBorder(title);
        RightPanel.add(SummaryResultPanel);
    }

    public void CreateSummarizationPanelStructure() {
        TitledBorder title;
        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Sumaryzator");
        SummarizerPanel.setBorder(title);
        SummarizerPanel.setLayout(new GridLayout(1, 2));

        SummarizerPanel.add(SummarizerAtributesPanel);
        summarizerAtributes.addItem("XD");

        SummarizerPanel.add(SummarizerMemberFuncPanel);
        summarizerMemberFuncs.addItem("XD2");
    }
}
