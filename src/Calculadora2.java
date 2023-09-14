import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora2 extends JPanel {
    public static void main(String[] args) {

            JFrame frame = new JFrame("Calculadora de Viagem");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            JPanel painelC = new JPanel(new BorderLayout());

            //teclado
            JPanel painel1 = new JPanel();
            JPanel painel2 = new JPanel();
            JPanel painel3 = new JPanel();
            frame.add(painel1, BorderLayout. WEST);
            frame.add(painel2, BorderLayout. SOUTH);
            frame.add(painel3, BorderLayout.EAST);
            painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
            painel2.setLayout(new BoxLayout(painel2, BoxLayout.X_AXIS));
            painel3.setLayout(new BoxLayout(painel3, BoxLayout.Y_AXIS));
            for (int i = 0; i < 20; i++) {
                painel1.add(new JButton(""+(i+1)));
                painel2.add(new JButton(""+(i+101)));
                painel3.add(new JButton(""+(i+1001)));
            }

            // Painel de entrada direita
            JPanel inputPanelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JLabel distanciaLabel = new JLabel("Distância (km):");
            JTextField distanciaTextField = new JTextField(10);
            distanciaTextField.setFont(new Font("Arial", 0, 48));

            inputPanelRight.add(distanciaLabel);
            inputPanelRight.add(distanciaTextField);

            // Painel de entrada esquerda
            JPanel inputPanelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel precoLabel = new JLabel("Preço por litro:");            
            JTextField precoTextField = new JTextField(10);
            precoTextField.setFont(new Font("Arial", 0, 48));

            inputPanelLeft.add(precoLabel);
            inputPanelLeft.add(precoTextField);

            // Painel de entrada centra
            JPanel inputPanelCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel consumoLabel = new JLabel("Consumo por litro:");            
            JTextField consumoTextField = new JTextField(10);
            consumoTextField.setFont(new Font("Arial", 0, 48));

            inputPanelLeft.add(consumoLabel);
            inputPanelLeft.add(consumoTextField);


            // Painel de botões e resultado no rodapé
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton calcularButton = new JButton("Calcular");
            JLabel resultadoLabel = new JLabel("Custo total:");
            resultadoLabel.setFont(new Font("Arial", 0, 35));

            buttonPanel.add(calcularButton);
            buttonPanel.add(resultadoLabel);

            // Painel de resultado
            JLabel resultadoValor = new JLabel("");
            resultadoValor.setFont(new Font("Arial", 0, 48));
            buttonPanel.add(resultadoValor);

            calcularButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        double distancia = Double.parseDouble(distanciaTextField.getText());
                        double precoLitro = Double.parseDouble(precoTextField.getText());
                        double consumo = Double.parseDouble(consumoTextField.getText());
                        //calculo
                        double custoTotal = distancia * (precoLitro / consumo);
                        resultadoValor.setText(String.format("%.2f", custoTotal) + " Reais");
                    } catch (NumberFormatException ex) {
                        resultadoValor.setText("Entrada inválida");
                    }
                }
            });

            painelC.add(inputPanelRight, BorderLayout.EAST);
            painelC.add(inputPanelLeft, BorderLayout.WEST);
            painelC.add(inputPanelCenter, BorderLayout.CENTER);
            painelC.add(buttonPanel, BorderLayout.SOUTH);

            frame.add(painelC);
            frame.setDefaultCloseOperation(1);

            frame.pack();
            frame.setVisible(true);
        };
    }
    


