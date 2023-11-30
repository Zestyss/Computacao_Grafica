package Transformacoes_2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class TransformacoesGeometricas extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int UNIDADE = 50;

    private Path2D.Double originalPolygon;

    public TransformacoesGeometricas() {
        setTitle("Transformações Geométricas");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        originalPolygon = createPolygon();

        setVisible(true);
    }

    private Path2D.Double createPolygon() {
        Path2D.Double polygon = new Path2D.Double();

        // Adicione aqui os pontos para formar o polígono
        polygon.moveTo(100, 100);
        polygon.lineTo(150, 100);
        polygon.lineTo(200, 150);
        // ...

        return polygon;
    }

    private void drawPolygon(Graphics2D g2d, Path2D.Double polygon, Color color) {
        g2d.setColor(color);
        g2d.fill(polygon);  // Alteração aqui
    }

    private void drawAxes(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        g2d.drawLine(0, HEIGHT / 2, WIDTH, HEIGHT / 2);

        g2d.setColor(Color.BLUE);
        for (int i = -WIDTH / 2; i <= WIDTH / 2; i += UNIDADE) {
            g2d.drawString(String.valueOf(i / UNIDADE), i + WIDTH / 2 - 5, HEIGHT / 2 - 10);
        }
    }

    private void applyTransformationsAndDraw(Graphics2D g2d, AffineTransform transform, Color color) {
        Path2D.Double transformedPolygon = new Path2D.Double(originalPolygon);
        transformedPolygon.transform(transform);

        drawPolygon(g2d, transformedPolygon, color);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Configurações iniciais
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, WIDTH, HEIGHT);

        drawAxes(g2d);

        // Transformações para a letra a) (R, T e E)
        AffineTransform transformA = new AffineTransform();
        transformA.rotate(Math.toRadians(60), WIDTH / 2, HEIGHT / 2);
        transformA.translate(1 * UNIDADE, 2 * UNIDADE);
        transformA.scale(2, 2);

        applyTransformationsAndDraw(g2d, transformA, Color.RED);

        // Transformações para a letra b) (E, R e T)
        AffineTransform transformB = new AffineTransform();
        transformB.scale(2, 2);
        transformB.rotate(Math.toRadians(60), WIDTH / 2, HEIGHT / 2);
        transformB.translate(1 * UNIDADE, 2 * UNIDADE);

        applyTransformationsAndDraw(g2d, transformB, Color.BLUE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TransformacoesGeometricas::new);
    }
}
