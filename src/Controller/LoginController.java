package Controller;

import FastFood.Index;
import Infra.ConnectionFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Eduardo
 */
public class LoginController implements Initializable {

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Label mensagem;

    private Connection con;

    public void botaoEntrarOnAction() throws Exception {
        String usuario = campoUsuario.getText();
        int senha = Integer.parseInt(campoSenha.getText());

        boolean valido = validaLogin(usuario, senha);

        if (valido) {
            Index.irParaHome();
        }

        mensagem.setVisible(!valido);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public boolean validaLogin(String usuario, int senha) throws Exception {
        try {
            String sql = "SELECT COUNT(cod_colaborador) "
                         + "FROM Colaboradores "
                        + "WHERE Usuario = ? "
                          + "AND Senha = ?";

            con = ConnectionFactory.conectaBanco();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.toUpperCase());
            ps.setInt(2, senha);

            return ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
