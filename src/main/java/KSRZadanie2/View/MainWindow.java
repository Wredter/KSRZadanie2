package KSRZadanie2.View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.tools.Tool;
import java.awt.*;

public class MainWindow extends JFrame {
    MainController controller;
    MainWindowHelper helper;

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
    private JPanel summarizerToolPanel;
    private JButton summarizerAddButton;
    private JPanel quantifierToolPanel;
    private JButton quantifierAddButton;
    private JPanel summaryToolPanel;
    private JButton summaryAddButton;
    private JButton summaryClearButton;
    private JButton summarySaveButton;
    private JPanel MemberFuncParamsPanel;
    //endregion

    public MainWindow() {
        super("Okno główne");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocation(50, 50);
        setVisible(true);

        controller = new MainController();
        helper = new MainWindowHelper(controller);

        CreateMainPanelStructure();
        add(MainPanel);
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

        CreateQuantifierPanelStructure();
        LeftPanel.add(QuantifierPanel);

        CreatToolPanelStructure();
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

        SummarizerPanel.add(SummarizerMemberFuncPanel);
        helper.PrepareMemberFuncComboBox(summarizerMemberFuncs);
    }

    public void CreateQuantifierPanelStructure() {
        TitledBorder title;
        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Kwantyfikator");
        QuantifierPanel.setBorder(title);

        helper.PrepareMemberFuncComboBox(quantifierMemberFuncs);
    }

    public void CreatToolPanelStructure() {
        TitledBorder title;
        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Akcje");
        ToolPanel.setBorder(title);
        ToolPanel.setLayout(new GridLayout(1, 3, 3, 3));
        ToolPanel.add(summarizerToolPanel);
        ToolPanel.add(quantifierToolPanel);
        ToolPanel.add(summaryToolPanel);
    }
}
