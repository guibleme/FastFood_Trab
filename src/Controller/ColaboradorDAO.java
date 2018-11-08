package Controller;

import Infra.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Model.Colaborador;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Eduardo
 */
public class ColaboradorDAO {

    private ColaboradorDAO() {
    }
    private Connection con;

    public void Add(Colaborador colaborador) throws Exception {
        try {
            String sql = "INSERT INTO Colaboradores (cod_Colaborador, nome, funcao) "
                                          + "VALUES (?,?,?)" ;

            con = ConnectionFactory.conectaBanco();
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, colaborador.getCod_Colaborador());
            ps.setString(2, colaborador.getNome());
            ps.setString(3, colaborador.getFuncao());
            
            ps.execute();
            
        } catch (Exception e) {
            throw e;
        }
    };
    
    public List<Colaborador> findAll() throws Exception {

        String sql = "SELECT *"
                     + "FROM Colaboradores";

        con = ConnectionFactory.conectaBanco();

        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        List<Colaborador> colaboradores = new ArrayList<>();

        while (rs.next()) {

            Colaborador colaborador = new Colaborador();

            colaborador.setCod_Colaborador(rs.getInt("cod_Colaborador"));
            colaborador.setFuncao(rs.getString("funcao"));
            colaborador.setNome(rs.getString("descricao"));

            colaboradores.add(colaborador);
        }

        return colaboradores;
    };
    
    public void Delete(int cod_Colaborador) throws Exception {
        try {
            String sql = "DELETE Colaboradores WHERE cod_Colaborador = ?)";

            con = ConnectionFactory.conectaBanco();
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, cod_Colaborador);
            
            ps.execute();
            
        } catch (Exception e) {
            throw e;
        }
    };
}
