package bsu.rfect.java.lab4;

import java.awt.*;
import java.awt.geom.*;
import java.text.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.JPanel;

public class GraphicsDisplay {
    class GraphPoint {
        double xd, yd;
        int x, y, n;
    }

    class Zone {
        double MAXY, MINY, MAXX, MINX;
        boolean use;
    }

    private Zone zone = new Zone();

    private double[][] graphicsData;
    private int[][] graphicsDataI;

    private boolean showAxis = true,
                    showMarkers = true,
                    transform = false,
                    showGrid = true,
                    PPP = false,
                    zoom = false,
                    selMode = false,
                    dragMode = false;

    private double minX,
                   maxX,
                   minY,
                   maxY,
                   scale,
                   scaleX,
                   scaleY;

    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();

    private BasicStroke graphicsStroke,
                        gridStroke,
                        hatchStroke,
                        axisStroke,
                        selStroke,
                        markerStroke;

    private Font axisFont,
                 captionFont;

    private int mausePX = 0,
                mausePY = 0;

    private GraphPoint SMP;
    double xmax;
    private Rectangle2D.Double rect;
    private Stack<Zone> stack = new Stack<Zone>();

    void sop(String s) {
        System.out.println(s);
    }

    public GraphicsDisplay(){
        setBackground(Color.WHITE);

        graphicsStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, new float[]{8, 2, 2, 2, 4, 2, 2, 2, 8, 2}, 0.0f);
        gridStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, null, 0.0f);
        hatchStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, null, 0.0f);
        axisStroke = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
        markerStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
        selStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{8, 8}, 0.0f);
        axisFont = new Font("Serif", Font.BOLD, 20);
        captionFont = new Font("Serif", Font.BOLD, 10);

        MouseMotionHandler mouseMotionHandler = new MouseMotionHandler();
        addMouseMotionListener(mouseMotionHandler);
        addMouseListener(mouseMotionHandler);

        rect = new Rectangle2D.Double();
        zone.use = false;
    }
}
