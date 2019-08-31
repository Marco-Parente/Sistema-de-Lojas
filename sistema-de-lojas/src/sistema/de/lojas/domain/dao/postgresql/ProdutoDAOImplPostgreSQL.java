
package sistema.de.lojas.domain.dao.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.de.lojas.domain.dao.IProdutoDAO;
import sistema.de.lojas.domain.entities.Produto;

public class ProdutoDAOImplPostgreSQL implements IProdutoDAO {

    private Connection criaConexao() {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SistemaDeLojas", "postgres", "123");
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return conexao;
    }

    @Override
    public void inserir(Produto ent) {

        Connection con = criaConexao();

        String sql = "insert into produto (nome)" + " VALUES ('" + ent.getNome() + "')";

        try {
            con.createStatement().execute(sql);
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    @Override
    public void atualizar(Produto ent) {

        Connection con = criaConexao();
        String sql = "update produto set nome = ? where id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getID());
            ps.execute();
            ps.close();
            con.close();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        Connection con = criaConexao();

        String sql = "delete from produto where id ="+id;

        try {
            con.createStatement().execute(sql);
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    @Override
    public List<Produto> consultar() {
        try{
            List<Produto> lista = new ArrayList<>();
            
            String sql = "select * from produto";
            
            Connection con = criaConexao();
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Produto c = new Produto();
                c.setID(res.getInt("id"));
                c.setNome(res.getString("nome"));
                lista.add(c);
            }
            
            return lista;
        } catch( Exception erro){
            erro.printStackTrace();
        }
        return null;
    }

}

    