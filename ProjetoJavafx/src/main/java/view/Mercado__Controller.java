package view;

import model.Mercado__;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Mercado__Controller {

    @FXML private TextField txtPreco0;
    @FXML private TextField txtPreco1;
    @FXML private TextField txtPreco2;
    @FXML private TextField txtPreco3;
    @FXML private TextField txtPreco4;
    @FXML private TextField txtPreco5;
    @FXML private TextField txtPreco6;
    @FXML private TextField txtPreco7;
    @FXML private TextField txtPreco8;
    @FXML private TextField txtPreco9;

    @FXML private Spinner<Integer> spnQtd0;
    @FXML private Spinner<Integer> spnQtd1;
    @FXML private Spinner<Integer> spnQtd2;
    @FXML private Spinner<Integer> spnQtd3;
    @FXML private Spinner<Integer> spnQtd4;
    @FXML private Spinner<Integer> spnQtd5;
    @FXML private Spinner<Integer> spnQtd6;
    @FXML private Spinner<Integer> spnQtd7;
    @FXML private Spinner<Integer> spnQtd8;
    @FXML private Spinner<Integer> spnQtd9;

    @FXML private TableView<ItemCaixa> tabelaCaixa;
    @FXML private TableColumn<ItemCaixa, String> colProduto;
    @FXML private TableColumn<ItemCaixa, Integer> colQuantidade;
    @FXML private TableColumn<ItemCaixa, String> colParcial;

    @FXML private Label lblSubtotal;
    @FXML private Label lblDesconto;
    @FXML private Label lblTotal;

    private final Mercado__ mercado = new Mercado__();

    private final NumberFormat moeda =
            NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    @FXML
    public void initialize() {

        Spinner<Integer>[] quantidades = new Spinner[]{
                spnQtd0, spnQtd1, spnQtd2, spnQtd3, spnQtd4,
                spnQtd5, spnQtd6, spnQtd7, spnQtd8, spnQtd9
        };

        for (Spinner<Integer> spinner : quantidades) {
            spinner.setValueFactory(
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0)
            );
            spinner.setEditable(true);
        }

        colProduto.setCellValueFactory(
                new PropertyValueFactory<>("produto")
        );

        colQuantidade.setCellValueFactory(
                new PropertyValueFactory<>("quantidade")
        );

        colParcial.setCellValueFactory(
                new PropertyValueFactory<>("parcial")
        );

        tabelaCaixa.setItems(FXCollections.observableArrayList());
    }

    @FXML
    private void calcularCompra() {

        TextField[] precos = {
                txtPreco0, txtPreco1, txtPreco2, txtPreco3, txtPreco4,
                txtPreco5, txtPreco6, txtPreco7, txtPreco8, txtPreco9
        };

        Spinner<Integer>[] quantidades = new Spinner[]{
                spnQtd0, spnQtd1, spnQtd2, spnQtd3, spnQtd4,
                spnQtd5, spnQtd6, spnQtd7, spnQtd8, spnQtd9
        };

        List<ItemCaixa> itens = new ArrayList<>();

        try {

            // Envia os preços e as quantidades para a classe Mercado__
            for (int i = 0; i < 10; i++) {

                String texto = precos[i].getText().trim();

                if (texto.isEmpty()) {
                    texto = "0";
                }

                texto = texto.replace("R$", "")
                        .replace(" ", "")
                        .replace(",", ".");

                double preco = Double.parseDouble(texto);
                int quantidade = quantidades[i].getValue();

                if (preco < 0 || quantidade < 0) {
                    lblTotal.setText("Os valores não podem ser negativos.");
                    return;
                }

                mercado.setValor_Prod(preco, i);
                mercado.setQuant_Prod(quantidade, i);
            }

            // Utiliza os métodos da classe Mercado__
            mercado.calculoTotal();
            mercado.calculoDesc();
            mercado.calculoPagar();

            // Monta a lista do caixa
            for (int i = 0; i < 10; i++) {

                int quantidade = mercado.getQuant_Prod(i);

                if (quantidade > 0) {

                    double parcial =
                            mercado.getValor_Prod(i) * quantidade;

                    itens.add(new ItemCaixa(
                            mercado.getProd(i),
                            quantidade,
                            moeda.format(parcial)
                    ));
                }
            }

            tabelaCaixa.setItems(
                    FXCollections.observableArrayList(itens)
            );

            // Mostra os resultados calculados pela classe Mercado__
            lblSubtotal.setText(
                    "Subtotal: " + moeda.format(mercado.getTotal())
            );

            lblDesconto.setText(
                    "Desconto: " + moeda.format(mercado.getDesc())
            );

            lblTotal.setText(
                    "Total a pagar: " + moeda.format(mercado.getPagar())
            );

        } catch (NumberFormatException e) {
            lblTotal.setText(
                    "Digite preços válidos. Exemplo: 12,50"
            );
        }
    }

    @FXML
    private void sair() {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("Menu.fxml")
            );

            Parent root = loader.load();

            Stage stage = (Stage) tabelaCaixa.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Menu");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            lblTotal.setText("Não foi possível voltar ao menu.");
        }
    }

    public static class ItemCaixa {

        private final String produto;
        private final int quantidade;
        private final String parcial;

        public ItemCaixa(String produto, int quantidade, String parcial) {
            this.produto = produto;
            this.quantidade = quantidade;
            this.parcial = parcial;
        }

        public String getProduto() {
            return produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public String getParcial() {
            return parcial;
        }
    }
}