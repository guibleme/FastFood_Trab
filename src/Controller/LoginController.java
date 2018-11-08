package Controller;

import FastFood.Index;
import Infra.ConnectionFactory;
import Model.Colaborador;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
        String senha = campoSenha.getText();
        
        boolean valido =  validaLogin(usuario, senha);
        
        if (valido) {
            Index.irParaPrincipal();
        }
        
        mensagem.setVisible(!valido);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public boolean validaLogin(String usuario, String senha) throws Exception {
        
        String sql = "SELECT COUNT(CodColaborador)" +
                       "FROM Colaboradores" +
                      "WHERE Usuario LIKE ?" + 
                        "AND Senha = ?";

        con = ConnectionFactory.conectaBanco();
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, usuario.toUpperCase());
        ps.setString(2, senha.toUpperCase());
        
        return ps.execute();
    };
}
