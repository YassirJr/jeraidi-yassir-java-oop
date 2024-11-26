package com.javafx.javafx.controller;

import com.javafx.javafx.metier.IMetier;
import com.javafx.javafx.metier.MetierImpl;
import com.javafx.javafx.models.Departement;
import com.javafx.javafx.models.Professeur;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;


public class ProfesseurController implements Initializable {
    private final IMetier metier = new MetierImpl();

    @FXML private TextField searchField;
    @FXML private TableView<Professeur> professeurTable;
    @FXML private TableColumn<Professeur, Integer> idColumn;
    @FXML private TableColumn<Professeur, String> nomColumn;
    @FXML private TableColumn<Professeur, String> prenomColumn;
    @FXML private TableColumn<Professeur, String> cinColumn;
    @FXML private TableColumn<Professeur, String> emailColumn;
    @FXML private TableColumn<Professeur, String> departementColumn;
    @FXML private TableColumn<Professeur, Void> actionsColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupTable();
        loadProfesseurs();
    }

    private void setupTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        cinColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        departementColumn.setCellValueFactory(cellData -> {
            var departementOptional = metier.getAllDepartements().stream()
                    .filter(departement -> departement.getId() == cellData.getValue().getDepartementId())
                    .findFirst();
            return new SimpleStringProperty(departementOptional.map(Departement::getNom).orElse("Non trouvé"));
        });

        setupActionsColumn();
    }

    private void setupActionsColumn() {
        actionsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button editBtn = new Button("Modifier");
            private final Button deleteBtn = new Button("Supprimer");
            private final Button assignBtn = new Button("Assigner");

            {
                editBtn.setOnAction(event -> {
                    Professeur professeur = getTableView().getItems().get(getIndex());
                    if (professeur != null) {
                        handleEdit(professeur);
                    }
                });
                deleteBtn.setOnAction(event -> {
                    Professeur professeur = getTableView().getItems().get(getIndex());
                    if (professeur != null) {
                        handleDelete(professeur);
                    }
                });
                assignBtn.setOnAction(event -> {
                    Professeur professeur = getTableView().getItems().get(getIndex());
                    if (professeur != null) {
                        handleAssign(professeur);
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || getTableView().getItems().get(getIndex()) == null) {
                    setGraphic(null);
                } else {
                    HBox buttons = new HBox(5, editBtn, deleteBtn, assignBtn);
                    setGraphic(buttons);
                }
            }
        });
    }

    private void loadProfesseurs() {
        professeurTable.setItems(FXCollections.observableArrayList(metier.getAllProfesseurs()));
        professeurTable.refresh();
    }

    @FXML
    private void handleSearch() {
        String keyword = searchField.getText();
        if (keyword != null && !keyword.isEmpty()) {
            professeurTable.setItems(FXCollections.observableArrayList(metier.searchProfesseurs(keyword)));
        } else {
            loadProfesseurs();
        }
        professeurTable.refresh();
    }

    @FXML
    private void handleAdd() {
        Dialog<Professeur> dialog = new Dialog<>();
        dialog.setTitle("Ajouter un professeur");
        dialog.setHeaderText("Saisir les informations du professeur");

        ButtonType saveButtonType = new ButtonType("Sauvegarder", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nom = new TextField();
        TextField prenom = new TextField();
        TextField cin = new TextField();
        TextField adresse = new TextField();
        TextField telephone = new TextField();
        TextField email = new TextField();
        DatePicker dateRecrutement = new DatePicker();

        ComboBox<String> departmentComboBox = new ComboBox<>();
        departmentComboBox.setItems(FXCollections.observableArrayList(
                metier.getAllDepartements().stream()
                        .map(Departement::getNom)
                        .toList()
        ));

        departmentComboBox.setPromptText("Sélectionnez un département");

        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nom, 1, 0);
        grid.add(new Label("Prénom:"), 0, 1);
        grid.add(prenom, 1, 1);
        grid.add(new Label("CIN:"), 0, 2);
        grid.add(cin, 1, 2);
        grid.add(new Label("Adresse:"), 0, 3);
        grid.add(adresse, 1, 3);
        grid.add(new Label("Téléphone:"), 0, 4);
        grid.add(telephone, 1, 4);
        grid.add(new Label("Email:"), 0, 5);
        grid.add(email, 1, 5);
        grid.add(new Label("Date de recrutement:"), 0, 6);
        grid.add(dateRecrutement, 1, 6);
        grid.add(new Label("Département:"), 0, 7);
        grid.add(departmentComboBox, 1, 7);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                Professeur professeur = new Professeur();
                professeur.setNom(nom.getText());
                professeur.setPrenom(prenom.getText());
                professeur.setCin(cin.getText());
                professeur.setAdresse(adresse.getText());
                professeur.setTelephone(telephone.getText());
                professeur.setEmail(email.getText());
                professeur.setDateRecrutement(java.sql.Date.valueOf(dateRecrutement.getValue()));

                String selectedDepartmentName = departmentComboBox.getValue();
                if (selectedDepartmentName != null) {
                    Departement selectedDepartement = metier.getAllDepartements().stream()
                            .filter(departement -> departement.getNom().equals(selectedDepartmentName))
                            .findFirst()
                            .orElse(null);

                    if (selectedDepartement != null) {
                        professeur.setDepartementId(selectedDepartement.getId());
                    }
                }
                return professeur;
            }
            return null;
        });


        dialog.showAndWait().ifPresent(professeur -> {
            metier.addProfesseur(professeur);
            loadProfesseurs();
        });
    }

    @FXML
    private void handleEdit(Professeur professeur) {
        Dialog<Professeur> dialog = new Dialog<>();
        dialog.setTitle("Modifier un professeur");
        dialog.setHeaderText("Modifier les informations du professeur");

        ButtonType saveButtonType = new ButtonType("Sauvegarder", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nom = new TextField(professeur.getNom());
        TextField prenom = new TextField(professeur.getPrenom());
        TextField cin = new TextField(professeur.getCin());
        TextField adresse = new TextField(professeur.getAdresse());
        TextField telephone = new TextField(professeur.getTelephone());
        TextField email = new TextField(professeur.getEmail());

        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nom, 1, 0);
        grid.add(new Label("Prénom:"), 0, 1);
        grid.add(prenom, 1, 1);
        grid.add(new Label("CIN:"), 0, 2);
        grid.add(cin, 1, 2);
        grid.add(new Label("Adresse:"), 0, 3);
        grid.add(adresse, 1, 3);
        grid.add(new Label("Téléphone:"), 0, 4);
        grid.add(telephone, 1, 4);
        grid.add(new Label("Email:"), 0, 5);
        grid.add(email, 1, 5);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                professeur.setNom(nom.getText());
                professeur.setPrenom(prenom.getText());
                professeur.setCin(cin.getText());
                professeur.setAdresse(adresse.getText());
                professeur.setTelephone(telephone.getText());
                professeur.setEmail(email.getText());
                return professeur;
            }
            return null;
        });

        dialog.showAndWait().ifPresent(updatedProfesseur -> {
            metier.updateProfesseur(updatedProfesseur);
            loadProfesseurs();
        });
    }

    @FXML
    private void handleDelete(Professeur professeur) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Supprimer le professeur");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer ce professeur ?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                metier.deleteProfesseur(professeur.getId());
                loadProfesseurs();
            }
        });
    }

    @FXML
    private void handleAssign(Professeur professeur) {
        Dialog<Integer> dialog = new Dialog<>();
        dialog.setTitle("Assigner un département");
        dialog.setHeaderText("Assigner un département à " + professeur.getNom() + " " + professeur.getPrenom());

        ButtonType assignButtonType = new ButtonType("Assigner", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(assignButtonType, ButtonType.CANCEL);

        ComboBox<String> departmentComboBox = new ComboBox<>();
        departmentComboBox.setItems(FXCollections.observableArrayList(
                metier.getAllDepartements().stream()
                        .map(Departement::getNom)
                        .toList()
        ));
        departmentComboBox.setPromptText("Sélectionnez un département");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(new Label("Département:"), 0, 0);
        grid.add(departmentComboBox, 1, 0);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == assignButtonType) {
                int selectedIndex = departmentComboBox.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                    return metier.getAllDepartements().get(selectedIndex).getId();
                }
            }
            return null;
        });

        dialog.showAndWait().ifPresent(departmentId -> {
            professeur.setDepartementId(departmentId);
            metier.updateProfesseur(professeur);

            professeurTable.getItems().forEach(p -> {
                if (p.getId() == professeur.getId()) {
                    p.setDepartementId(departmentId);
                }
            });

            professeurTable.refresh();

            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Succès");
            success.setHeaderText(null);
            success.setContentText("Le professeur a été assigné au département avec succès !");
            success.show();
        });
    }
}