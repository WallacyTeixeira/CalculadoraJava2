import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraCustoViagem extends JPanel {
    public CalculadoraCustoViagem() {

        // Criação de um JFrame (janela principal) e configuração de propriedades
        JFrame frame = new JFrame("Calculadora de Viagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a ação ao fechar a janela
        frame.setLayout(new BorderLayout()); // Define o layout do JFrame como BorderLayout
        JPanel painelC = new JPanel(new BorderLayout()); // Criação de um painel principal com layout BorderLayout

        // Criação dos painéis para os botões numéricos
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();
        
        // Adiciona os painéis ao JFrame em posições específicas
        frame.add(painel1, BorderLayout.WEST); // Adiciona o painel1 à esquerda do JFrame
        frame.add(painel2, BorderLayout.SOUTH); // Adiciona o painel2 na parte inferior do JFrame
        frame.add(painel3, BorderLayout.EAST); // Adiciona o painel3 à direita do JFrame
        
        // Configuração dos layouts dos painéis de botões numéricos
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS)); // Define layout vertical para o painel1
        painel2.setLayout(new BoxLayout(painel2, BoxLayout.X_AXIS)); // Define layout horizontal para o painel2
        painel3.setLayout(new BoxLayout(painel3, BoxLayout.Y_AXIS)); // Define layout vertical para o painel3
        
        // Adiciona botões numéricos aos painéis de botões numéricos
        for (int i = 0; i < 10; i++) {
            painel1.add(new JButton("" + (i + 1))); // Adiciona botões de 1 a 10 ao painel1
            painel2.add(new JButton("" + (i + 5))); // Adiciona botões de 6 a 15 ao painel2
            painel3.add(new JButton("" + (i + 10))); // Adiciona botões de 11 a 20 ao painel3
        }

        // Criação dos painéis de entrada para dados
        JPanel inputPanelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Criação de um painel com layout à direita
        JLabel distanciaLabel = new JLabel("Distância (km):"); // Criação de um rótulo para a distância
        JTextField distanciaTextField = new JTextField(10); // Criação de um campo de texto para a distância
        distanciaTextField.setFont(new Font("Arial", 0, 20)); // Define a fonte do campo de texto

        inputPanelRight.add(distanciaLabel); // Adiciona o rótulo ao painel
        inputPanelRight.add(distanciaTextField); // Adiciona o campo de texto ao painel

        JPanel inputPanelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Criação de um painel com layout à esquerda
        JLabel precoLabel = new JLabel("Preço por litro:"); // Criação de um rótulo para o preço por litro
        JTextField precoTextField = new JTextField(10); // Criação de um campo de texto para o preço por litro
        precoTextField.setFont(new Font("Arial", 0, 20)); // Define a fonte do campo de texto

        inputPanelLeft.add(precoLabel); // Adiciona o rótulo ao painel
        inputPanelLeft.add(precoTextField); // Adiciona o campo de texto ao painel

        JPanel inputPanelCenter = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Criação de um painel com layout centralizado
        JLabel consumoLabel = new JLabel("Consumo por litro:"); // Criação de um rótulo para o consumo por litro
        JTextField consumoTextField = new JTextField(10); // Criação de um campo de texto para o consumo por litro
        consumoTextField.setFont(new Font("Arial", 0, 20)); // Define a fonte do campo de texto

        inputPanelCenter.add(consumoLabel); // Adiciona o rótulo ao painel
        inputPanelCenter.add(consumoTextField); // Adiciona o campo de texto ao painel

        // Criação do painel para botões e resultado na parte inferior
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Criação de um painel com layout centralizado
        JButton calcularButton = new JButton("Calcular"); // Criação de um botão com o texto "Calcular"
        JLabel resultadoLabel = new JLabel("Custo total:"); // Criação de um rótulo para o resultado
        resultadoLabel.setFont(new Font("Arial", 0, 35)); // Define a fonte do rótulo

        buttonPanel.add(calcularButton); // Adiciona o botão "Calcular" ao painel
        buttonPanel.add(resultadoLabel); // Adiciona o rótulo "Custo total" ao painel

        // Criação do rótulo para mostrar o resultado do cálculo
        JLabel resultadoValor = new JLabel(""); // Criação de um rótulo vazio
        resultadoValor.setFont(new Font("Arial", 0, 48)); // Define a fonte do rótulo

        buttonPanel.add(resultadoValor); // Adiciona o rótulo de resultado ao painel

        // Adiciona um ActionListener ao botão "Calcular"
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double distancia = Double.parseDouble(distanciaTextField.getText()); // Obtém a distância
                    double precoLitro = Double.parseDouble(precoTextField.getText()); // Obtém o preço por litro
                    double consumo = Double.parseDouble(consumoTextField.getText()); // Obtém o consumo por litro
                    
                    // Realiza o cálculo do custo total
                    double custoTotal = distancia * (precoLitro / consumo);
                    
                    // Define o texto do rótulo de resultado com o valor calculado
                    resultadoValor.setText(String.format("%.2f", custoTotal) + " Reais");
                } catch (NumberFormatException ex) {
                    resultadoValor.setText("Entrada inválida"); // Exibe uma mensagem de erro se houver entrada inválida
                }
            }
        });

        // Adiciona os painéis e elementos ao painel principal (painelC)
        painelC.add(inputPanelRight, BorderLayout.EAST);
        painelC.add(inputPanelLeft, BorderLayout.WEST);
        painelC.add(inputPanelCenter, BorderLayout.CENTER);
        painelC.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal (painelC) ao JFrame
        frame

.add(painelC);

        frame.setDefaultCloseOperation(1); // Define a operação de fechamento (1 = JFrame.EXIT_ON_CLOSE)
        frame.pack(); // Ajusta o tamanho da janela automaticamente com base no conteúdo
        frame.setVisible(true); // Torna a janela visível
    }
}