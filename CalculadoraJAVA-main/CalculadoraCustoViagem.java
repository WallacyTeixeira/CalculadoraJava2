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
        painel1.setBackground(Color.gray);

        // Adiciona os painéis ao JFrame em posições específicas
        frame.add(painel1, BorderLayout.SOUTH); // Adiciona o painel1 à esquerda do JFrame
        
        // Configuração dos layouts dos painéis de botões numéricos
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.X_AXIS)); // Define layout vertical para o painel1
        
        // Adiciona botões numéricos aos painéis de botões numéricos
        for (int i = 0; i < 18; i++) {
            painel1.add(new JButton("" + (i + 1))); // Adiciona botões de 1 a 10 ao painel1
        }

        // Criação dos painéis de entrada para dados
        JPanel inputPanelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Criação de um painel com layout à direita
        JLabel distanciaLabel = new JLabel("Distância (km):"); // Criação de um rótulo para a distância
        JTextField distanciaTextField = new JTextField(5); // Criação de um campo de texto para a distância
        distanciaTextField.setFont(new Font("Arial", 0, 25)); // Define a fonte do campo de texto
        inputPanelRight.setBackground(Color.gray);

        inputPanelRight.add(distanciaLabel); // Adiciona o rótulo ao painel
        inputPanelRight.add(distanciaTextField); // Adiciona o campo de texto ao painel

        JPanel inputPanelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Criação de um painel com layout à esquerda
        JLabel precoLabel = new JLabel("Preço por litro (R$):"); // Criação de um rótulo para o preço por litro
        JTextField precoTextField = new JTextField(5); // Criação de um campo de texto para o preço por litro
        precoTextField.setFont(new Font("Arial", 0, 25)); // Define a fonte do campo de texto
        inputPanelLeft.setBackground(Color.gray);

        inputPanelLeft.add(precoLabel); // Adiciona o rótulo ao painel
        inputPanelLeft.add(precoTextField); // Adiciona o campo de texto ao painel

        JPanel inputPanelCenter = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Criação de um painel com layout centralizado
        JLabel consumoLabel = new JLabel("Consumo por litro(L/Km):"); // Criação de um rótulo para o consumo por litro
        JTextField consumoTextField = new JTextField(5); // Criação de um campo de texto para o consumo por litro
        consumoTextField.setFont(new Font("Arial", 0, 25)); // Define a fonte do campo de texto
        inputPanelCenter.setBackground(Color.gray);

        inputPanelCenter.add(consumoLabel); // Adiciona o rótulo ao painel
        inputPanelCenter.add(consumoTextField); // Adiciona o campo de texto ao painel

        // Criação do painel para botões e resultado na parte inferior
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Criação de um painel com layout centralizado
        JButton calcularButton = new JButton("Calcular"); // Criação de um botão com o texto "Calcular"
        JLabel resultadoLabel = new JLabel("Custo total:"); // Criação de um rótulo para o resultado
        resultadoLabel.setFont(new Font("Arial", 0, 25)); // Define a fonte do rótulo

        buttonPanel.add(calcularButton); // Adiciona o botão "Calcular" ao painel
        buttonPanel.add(resultadoLabel); // Adiciona o rótulo "Custo total" ao painel

        // Criação do rótulo para mostrar o resultado do cálculo
        JLabel resultadoValor = new JLabel(""); // Criação de um rótulo vazio
        resultadoValor.setFont(new Font("Arial", 0, 30)); // Define a fonte do rótulo
        buttonPanel.setBackground(Color.green);

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