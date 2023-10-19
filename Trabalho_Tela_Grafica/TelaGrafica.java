import javax.swing.*;
import java.awt.*;

public class TelaGrafica extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int largura = 800;
        int altura = 600;
        int escala = 100;

        // Configurar a cor de fundo para branca
        this.setBackground(Color.WHITE);

        // Desenhar os eixos (linhas pretas) cortando a tela no meio
        g.setColor(Color.BLACK);
        g.drawLine(0, altura / 2, largura, altura / 2); // Eixo horizontal
        g.drawLine(largura / 2, 0, largura / 2, altura); // Eixo vertical

        // Configurar a fonte para a legenda em azul
        g.setColor(Color.BLUE);
        Font fonte = new Font("Arial", Font.PLAIN, 12);
        g.setFont(fonte);

        // Desenhar as marcações de unidades inteiras no eixo horizontal
        for (int i = -largura / (2 * escala); i <= largura / (2 * escala); i++) {
            int x = largura / 2 + i * escala;
            g.drawLine(x, altura / 2 - 5, x, altura / 2 + 5);
            g.drawString(Integer.toString(i), x - 8, altura / 2 + 20);
        }

        // Desenhar as marcações de unidades inteiras no eixo vertical
        for (int i = -altura / (2 * escala); i <= altura / (2 * escala); i++) {
            int y = altura / 2 - i * escala;
            g.drawLine(largura / 2 - 5, y, largura / 2 + 5, y);
            g.drawString(Integer.toString(i), largura / 2 + 10, y + 5);
        }

        // Desenhar o segmento de reta em vermelho entre os pontos (1,1) e (2,2)
        g.setColor(Color.RED);
        int x1 = largura / 2 + escala;
        int y1 = altura / 2 - escala;
        int x2 = largura / 2 + 2 * escala;
        int y2 = altura / 2 - 2 * escala;
        g.drawLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tela Gráfica");
        TelaGrafica tela = new TelaGrafica();
        frame.add(tela);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
