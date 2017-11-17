import Contexts.*;
import Decorators.FragmentDecorator;
import Decorators.MoveDecorator;
import Decorators.ShellDecorator;
import Drawable.*;
import Drawable.Point;
import Visual.*;
import Composite.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Vasily Danilin on 03.11.2017.
 */
public class PlotForm {
    private JButton button1;
    private JRadioButton standartPaintRadioButton;
    private JRadioButton dottedPaintRadioButton;
    private JPanel jPanelGeneral;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JButton svgButton1;
    private JButton svgButton2;
    private Line line = new Line(new Point(20, 350), new Point(400, 30));
    private Bezier bezier = new Bezier(new Point(10, 10), new Point(200, 300), new Point(300, 150), new Point(380, 380));
    private VisualCurve visualLine = new VisualCurve(line);
    private VisualCurve visualBezier = new VisualCurve(bezier);
    private Canvas canvas1 = new Canvas(visualLine);
    private Canvas canvas2 = new Canvas(visualBezier);


    private PlotForm() {
        $$$setupUI$$$();
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (standartPaintRadioButton.isSelected()) {
                    canvas1.isDotted = false;
                    canvas2.isDotted = false;

                } else if (dottedPaintRadioButton.isSelected()) {
                    canvas1.isDotted = true;
                    canvas2.isDotted = true;
                }
                svgButton1.setEnabled(true);
                svgButton2.setEnabled(true);
                jPanelGeneral.repaint();
            }
        });
        svgButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                saveSVG("./svg1.svg", PlotForm.this.line);
            }
        });
        svgButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                saveSVG("./svg2.svg", PlotForm.this.bezier);
            }

        });
    }

    private void saveSVG(String pathname, ACurve curve) {
        SVGContext svgContext = new SVGContext();
        svgContext.createSVGContent(curve);
        File file = new File(pathname);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(svgContext.getXML());
            fileWriter.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("problem with file");
        }
        System.out.println(svgContext.getXML());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PlotForm");
        final PlotForm plotForm = new PlotForm();
        frame.setContentPane(plotForm.jPanelGeneral);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void createUIComponents() {
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();

        jPanel1.add(canvas1);
        jPanel2.add(canvas2);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        jPanelGeneral = new JPanel();
        jPanelGeneral.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        button1 = new JButton();
        button1.setText("Paint plots");
        jPanelGeneral.add(button1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        standartPaintRadioButton = new JRadioButton();
        standartPaintRadioButton.setSelected(true);
        standartPaintRadioButton.setText("Standart Paint");
        jPanelGeneral.add(standartPaintRadioButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dottedPaintRadioButton = new JRadioButton();
        dottedPaintRadioButton.setText("Dotted Paint");
        jPanelGeneral.add(dottedPaintRadioButton, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jPanelGeneral.add(jPanel2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(500, 500), new Dimension(500, 500), null, 0, false));
        jPanelGeneral.add(jPanel1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(500, 500), new Dimension(500, 500), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Line Curve");
        jPanelGeneral.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Bezier Curve");
        jPanelGeneral.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        svgButton1 = new JButton();
        svgButton1.setEnabled(false);
        svgButton1.setText("Save as SVG file");
        jPanelGeneral.add(svgButton1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        svgButton2 = new JButton();
        svgButton2.setEnabled(false);
        svgButton2.setText("Save as SVG file");
        jPanelGeneral.add(svgButton2, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(standartPaintRadioButton);
        buttonGroup.add(dottedPaintRadioButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return jPanelGeneral;
    }
}

class Canvas extends JPanel {
    private VisualCurve visualCurve;
    boolean isDotted = true;
    private boolean isFirst = true;

    Canvas(VisualCurve visualCurve) {
        super();
        setPreferredSize(new Dimension(500, 500));
        this.visualCurve = visualCurve;
    }

    public void paintComponent(Graphics g) {
        //System.out.println("repaint...");
        IGContext context = isDotted ? new Graphics2DDottedContext(g) : new Graphics2DContext(g);
        super.paintComponents(g);
        if (!isFirst) {
            new ShellDecorator(visualCurve, 8).draw(context);
            //FragmentDecorator decorator = new FragmentDecorator(visualCurve, 1, 0);
            //new VisualCurve(decorator).draw(context);
//            new VisualCurve(new MoveDecorator(new FragmentDecorator(visualCurve,0,0.2), visualCurve.getPoint(1))).draw(context);
//            Line a = new Line(new Point(50,10), new Point(100,20));
//            Line b = new Line(new Point(100,20), new Point(100,100));
//            Line c = new Line(new Point(100,100), new Point(200,100));
//            new VisualCurve(new Chain(a,new Chain(b,c))).drawWithoutAnyPoints(context);

        }
        isFirst = false;
    }

}