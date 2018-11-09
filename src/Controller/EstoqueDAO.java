package Controller;

import Infra.ConnectionFactory;
import Model.Estoque;
import com.sun.jmx.mbeanserver.Util;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class EstoqueDAO {
    private Connection con;
   
    public  EstoqueDAO(){
    }
    
    public void Add(Estoque estoque) throws Exception {
        try {
            String sql = "INSERT INTO Estoque (cod_Item_Estoque, nome, funcao) "
                                    + "VALUES (?,?,?)" ;

            con = ConnectionFactory.conectaBanco();
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, estoque.getCod_Item_Estoque());
            ps.setString(2, estoque.getDescricao());
            ps.setDouble(3, estoque.getQuantidade());
            ps.setString(4, estoque.getTipo_Quantidade());
            
            ps.execute();
            
        } catch (Exception e) {
            throw e;
        }
    };
    
    public List<Estoque> listaEstoque() throws Exception {

        String sql = "SELECT *" +
                       "FROM Estoque";

        con = ConnectionFactory.conectaBanco();

        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        List<Estoque> listaEstoque = new ArrayList<>();

        while (rs.next()) {

            Estoque estoque = new Estoque();

            estoque.setCod_Item_Estoque(rs.getInt("Cod_Item_Estoque"));
            estoque.setDescricao(rs.getString("Descricao"));
            estoque.setQuantidade(rs.getInt("Quantidade"));
            estoque.setTipo_Quantidade(rs.getString("Tipo_Quantidade"));

            listaEstoque.add(estoque);
        }

        return listaEstoque;
    };
    
    public void Delete(int cod_Colaborador) throws Exception {
        try {
            String sql = "DELETE Estoquees WHERE cod_Colaborador = ?)";

            con = ConnectionFactory.conectaBanco();
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, cod_Colaborador);
            
            ps.execute();
            
        } catch (Exception e) {
            throw e;
        }
    };
}
