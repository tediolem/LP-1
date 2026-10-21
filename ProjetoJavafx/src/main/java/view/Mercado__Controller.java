package view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Mercado__Controller {

    @FXML
    private TextField txtPreco0;
    @FXML
    private TextField txtPreco1;
    @FXML
    private TextField txtPreco2;
    @FXML
    private TextField txtPreco3;
    @FXML
    private TextField txtPreco4;
    @FXML
    private TextField txtPreco5;
    @FXML
    private TextField txtPreco6;
    @FXML
    private TextField txtPreco7;
    @FXML
    private TextField txtPreco8;
    @FXML
    private TextField txtPreco9;

    @FXML
    private Spinner<Integer> spnQtd0;
    @FXML
    private Spinner<Integer> spnQtd1;
    @FXML
    private Spinner<Integer> spnQtd2;
    @FXML
    private Spinner<Integer> spnQtd3;
    @FXML
    private Spinner<Integer> spnQtd4;
    @FXML
    private Spinner<Integer> spnQtd5;
    @FXML
    private Spinner<Integer> spnQtd6;
    @FXML
    private Spinner<Integer> spnQtd7;
    @FXML
    private Spinner<Integer> spnQtd8;
    @FXML
    private Spinner<Integer> spnQtd9;

    @FXML
    private TableView<ItemCaixa> tabelaCaixa;

    @FXML
    private TableColumn<ItemCaixa, String> colProduto;

    @FXML
    private TableColumn<ItemCaixa, Integer> colQuantidade;

    @FXML
    private TableColumn<ItemCaixa, String> colParcial;

    @FXML
    private Label lblSubtotal;

    @FXML
    private Label lblDesconto;

    @FXML
    private Label lblTotal;

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
        }
    }

    private final String[] produtos = {
            "Arroz",
            "Feijão",
            "Óleo de soja",
            "Açúcar",
            "Café",
            "Macarrão",
            "Farinha",
            "Fubá",
            "Molho de tomate",
            "Sal refinado"
    };

    private final NumberFormat moeda =
            NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    @FXML
    public void initialize() {
        configurarSpinner(spnQtd0);
        configurarSpinner(spnQtd1);
        configurarSpinner(spnQtd2);
        configurarSpinner(spnQtd3);
        configurarSpinner(spnQtd4);
        configurarSpinner(spnQtd5);
        configurarSpinner(spnQtd6);
        configurarSpinner(spnQtd7);
        configurarSpinner(spnQtd8);
        configurarSpinner(spnQtd9);

        colProduto.setCellValueFactory(
                new PropertyValueFactory<>("produto"));

        colQuantidade.setCellValueFactory(
                new PropertyValueFactory<>("quantidade"));

        colParcial.setCellValueFactory(
                new PropertyValueFactory<>("parcial"));

        tabelaCaixa.setItems(FXCollections.observableArrayList());
    }

    private void configurarSpinner(Spinner<Integer> spinner) {
        spinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        spinner.setEditable(true);
    }

    @FXML
    private void calcularCompra() {
        TextField[] camposPreco = {
                txtPreco0, txtPreco1, txtPreco2, txtPreco3, txtPreco4,
                txtPreco5, txtPreco6, txtPreco7, txtPreco8, txtPreco9
        };

        Spinner<Integer>[] camposQuantidade = new Spinner[]{
                spnQtd0, spnQtd1, spnQtd2, spnQtd3, spnQtd4,
                spnQtd5, spnQtd6, spnQtd7, spnQtd8, spnQtd9
        };

        List<ItemCaixa> itens = new ArrayList<>();
        double subtotal = 0;

        try {
            for (int i = 0; i < produtos.length; i++) {
                String textoPreco = camposPreco[i].getText().trim();

                if (textoPreco.isEmpty()) {
                    textoPreco = "0";
                }

                textoPreco = textoPreco.replace("R$", "")
                        .replace(" ", "")
                        .replace(",", ".");

                double preco = Double.parseDouble(textoPreco);

                if (preco < 0) {
                    lblTotal.setText("O preço não pode ser negativo.");
                    return;
                }

                int quantidade = camposQuantidade[i].getValue();

                double parcial = preco * quantidade;
                subtotal += parcial;

                if (quantidade > 0) {
                    itens.add(new ItemCaixa(
                            produtos[i],
                            quantidade,
                            moeda.format(parcial)
                    ));
                }
            }

            double desconto = subtotal > 100 ? subtotal * 0.10 : 0;
            double total = subtotal - desconto;

            tabelaCaixa.setItems(FXCollections.observableArrayList(itens));

            lblSubtotal.setText("Subtotal: " + moeda.format(subtotal));
            lblDesconto.setText("Desconto: " + moeda.format(desconto));
            lblTotal.setText("Total a pagar: " + moeda.format(total));

        } catch (NumberFormatException e) {
            lblTotal.setText("Digite preços válidos. Exemplo: 12,50");
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