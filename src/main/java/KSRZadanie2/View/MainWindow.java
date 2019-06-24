package KSRZadanie2.View;

import KSRZadanie2.Model.LinguisticVariables.Qualifier;
import KSRZadanie2.Model.LinguisticVariables.Quantifier;
import KSRZadanie2.Model.LinguisticVariables.Summarizer;
import KSRZadanie2.View.Helpers.MainWindowHelper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    MainController controller;
    MainWindowHelper helper;

    //region JFrameElements
    private JPanel MainPanel;
    private JPanel LeftPanel;
    private JPanel SummarizerPanel;
    private JPanel QuantifierAndQualifierPanel;
    private JPanel ToolPanel;
    private JPanel RightPanel;
    private JPanel SummaryParametersPanel;
    private JPanel SummaryResultPanel;
    private JComboBox summarizerAtributes;
    private JTextField summarizerMemberFuncLabel;
    private JComboBox summarizerMemberFuncs;
    private JPanel SummarizerValuesPanel;
    private JPanel SummarizerMemberFuncPanel;
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
    private JTextField summaryTitle;
    private JComboBox summaryQuantifiers;
    private JComboBox summarySummarizer1;
    private JComboBox summarySummarizer2;
    private JComboBox summaryOperations;
    private JTable summaries;
    private JPanel QuantifierMemberFuncPanel;
    private JPanel QualifierMemberFuncPanel;
    private JComboBox qualifierMemberFuncs;
    private JTextField qualifierMemberFuncLabel;
    private JTextField qualifierMemberFuncParamA;
    private JTextField qualifierMemberFuncParamB;
    private JTextField qualifierMemberFuncParamC;
    private JTextField qualifierMemberFuncParamD;
    private JButton qualifierAddButton;
    private JComboBox summaryQualifiers;
    private JComboBox quantifierAtributes;
    private JComboBox qualifierAttributes;
    private JLabel Atrybut;
    private JTable summarizationValuesTable;
    private JButton summarySaveParamsButton;
    private JButton summaryLoadParamsButton;
    private JCheckBox quantifierIsBezwzglCheckBox;
    private JPanel MemberFuncParamsPanel;
    //endregion

    public MainWindow() {
        super("Okno główne");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1300, 900);
        setLocation(50, 50);
        setVisible(true);

        controller = new MainController();
        helper = new MainWindowHelper(controller);

        CreateMainPanelStructure();
        add(MainPanel);
        summarizerAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.CreateSummarizer((String) summarizerAtributes.getSelectedItem(), summarizerMemberFuncLabel.getText(), (String) summarizerMemberFuncs.getSelectedItem(), Double.parseDouble(summarizerMemberFuncParamA.getText()), Double.parseDouble(summarizerMemberFuncParamB.getText()), Double.parseDouble(summarizerMemberFuncParamC.getText()), Double.parseDouble(summarizerMemberFuncParamD.getText()));
                helper.AddToComboBox(summarySummarizer1, (String) summarizerAtributes.getSelectedItem() + " - " + summarizerMemberFuncLabel.getText());
                helper.AddToComboBox(summarySummarizer2, (String) summarizerAtributes.getSelectedItem() + " - " + summarizerMemberFuncLabel.getText());
            }
        });
        quantifierAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quantifierIsBezwzglCheckBox.isSelected()) {
                    controller.CreateQuantifier(" ", true, quantifierMemberFuncLabel.getText(), (String) quantifierMemberFuncs.getSelectedItem(), Double.parseDouble(quantifierMemberFuncParamA.getText()), Double.parseDouble(quantifierMemberFuncParamB.getText()), Double.parseDouble(quantifierMemberFuncParamC.getText()), Double.parseDouble(quantifierMemberFuncParamD.getText()));
                } else {
                    controller.CreateQuantifier(" ", false, quantifierMemberFuncLabel.getText(), (String) quantifierMemberFuncs.getSelectedItem(), Double.parseDouble(quantifierMemberFuncParamA.getText()), Double.parseDouble(quantifierMemberFuncParamB.getText()), Double.parseDouble(quantifierMemberFuncParamC.getText()), Double.parseDouble(quantifierMemberFuncParamD.getText()));
                }
                helper.AddToComboBox(summaryQuantifiers, quantifierMemberFuncLabel.getText());
            }
        });
        qualifierAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.CreateQualifier((String) qualifierAttributes.getSelectedItem(), qualifierMemberFuncLabel.getText(), (String) qualifierMemberFuncs.getSelectedItem(), Double.parseDouble(qualifierMemberFuncParamA.getText()), Double.parseDouble(qualifierMemberFuncParamB.getText()), Double.parseDouble(qualifierMemberFuncParamC.getText()), Double.parseDouble(qualifierMemberFuncParamD.getText()));
                helper.AddToComboBox(summaryQualifiers, (String) qualifierAttributes.getSelectedItem() + " - " + qualifierMemberFuncLabel.getText());
            }
        });
        summaryAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.CreateSummary(summaryTitle.getText(), (String) summaryQuantifiers.getSelectedItem(), (String) summarySummarizer1.getSelectedItem(), (String) summarySummarizer2.getSelectedItem(), (String) summaryOperations.getSelectedItem(), (String) summaryQualifiers.getSelectedItem());
                helper.PrepareSumarriesTable(summaries);
            }
        });
        summaryClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.dataContext.summaries1 = new ArrayList<>();
                controller.dataContext.summaries2 = new ArrayList<>();
                helper.PrepareSumarriesTable(summaries);
            }
        });
        summarySaveParamsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helper.SerializeDataContext();
            }
        });
        summaryLoadParamsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.dataContext = helper.DeserializeDataContext();
                for(Quantifier q : controller.dataContext.quantifiers) {
                    helper.AddToComboBox(summaryQuantifiers, q.label);
                }
                for(Summarizer s : controller.dataContext.summarizers) {
                    helper.AddToComboBox(summarySummarizer1, s.attribute + " - " + s.label);
                    helper.AddToComboBox(summarySummarizer2, s.attribute + " - " + s.label);
                }
                for(Qualifier q : controller.dataContext.qualifiers) {
                    helper.AddToComboBox(summaryQualifiers, q.attribute + " - " + q.label);
                }
            }
        });
    }

    public void CreateMainPanelStructure() {
        MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(1, 2));

        CreateLeftPanelStructure();
        MainPanel.add(LeftPanel);

        CreateRightPanelStructure();
        MainPanel.add(RightPanel);
    }

    public void CreateLeftPanelStructure() {
        TitledBorder title;
        LeftPanel = new JPanel();
        LeftPanel.setLayout(new GridLayout(3, 1));

        CreateSummarizationPanelStructure();
        LeftPanel.add(SummarizerPanel);

        CreateQuantifierAndQualifierPanelStructure();
        LeftPanel.add(QuantifierAndQualifierPanel);

        CreatToolPanelStructure();
        LeftPanel.add(ToolPanel);
    }

    public void CreateRightPanelStructure() {
        TitledBorder title;
        RightPanel.setLayout(new GridLayout(2, 1));

        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Parametry podsumowania");
        SummaryParametersPanel.setBorder(title);
        summaryQuantifiers.addItem("NONE");

        summarySummarizer1.addItem("NONE");

        summarySummarizer2.addItem("NONE");

        summaryOperations.addItem("NONE");
        summaryOperations.addItem("AND");
        summaryOperations.addItem("OR");
        RightPanel.add(SummaryParametersPanel);

        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Wyniki podsumowania");
        SummaryResultPanel.setBorder(title);
        helper.PrepareSumarriesTable(summaries);
        RightPanel.add(SummaryResultPanel);
    }

    public void CreateSummarizationPanelStructure() {
        TitledBorder title;
        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Sumaryzator");
        SummarizerPanel = new JPanel();
        SummarizerPanel.setBorder(title);
        SummarizerPanel.setLayout(new GridLayout(1, 2));

        helper.PrepareSumarizerValuesTable(summarizationValuesTable);

        helper.PrepareAttributesComboBox(summarizerAtributes);
        SummarizerPanel.add(SummarizerMemberFuncPanel);

        SummarizerPanel.add(SummarizerValuesPanel);
        helper.PrepareMemberFuncComboBox(summarizerMemberFuncs);
    }

    public void CreateQuantifierAndQualifierPanelStructure() {
        TitledBorder title;

        QuantifierAndQualifierPanel.setLayout(new GridLayout(1, 2));

        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Kwantyfikator");
        QuantifierMemberFuncPanel.setBorder(title);
        helper.PrepareAttributesComboBox(quantifierAtributes);
        helper.PrepareMemberFuncComboBox(quantifierMemberFuncs);
        QuantifierAndQualifierPanel.add(QuantifierMemberFuncPanel);

        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Kwalifikator");
        helper.PrepareMemberFuncComboBox(qualifierMemberFuncs);
        helper.PrepareAttributesComboBox(qualifierAttributes);
        helper.AddToComboBox(summaryQualifiers, "NONE");
        QualifierMemberFuncPanel.setBorder(title);

        QuantifierAndQualifierPanel.add(QualifierMemberFuncPanel);
    }

    public void CreatToolPanelStructure() {
        TitledBorder title;
        title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Akcje");
        ToolPanel.setBorder(title);
        ToolPanel.setLayout(new GridLayout(1, 3));
        ToolPanel.add(summarizerToolPanel);
        ToolPanel.add(quantifierToolPanel);
        ToolPanel.add(summaryToolPanel);
    }
}
