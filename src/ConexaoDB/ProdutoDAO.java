package ConexaoDB;

import Entidade.Produto;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Clock;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Deyvid
 */
public class ProdutoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Produto> lista = new ArrayList<>();

    public void cadastrar(Produto p) {
        String sql = "INSERT INTO mercadinho (nome, Marca ) values (?,?) ";
        conn = new ConexaoDAO().conectaBD();
        try {
            System.out.println(p.getNome() + p.getMarca());
            pstm = conn.prepareStatement(sql);
            System.out.println("Passou");
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getMarca());
            System.out.println("Passou 2");
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO" + e);
        }
    }

    public ArrayList<Produto> PesquisarProduto() {
        String sql = "Select * from mercadinho";
        conn = new ConexaoDAO().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("codigo"));
                p.setMarca(rs.getString("marca"));
                p.setNome(rs.getString("nome"));
                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "PesquisarDAO " + e);

        }
        return lista;

    }
}
