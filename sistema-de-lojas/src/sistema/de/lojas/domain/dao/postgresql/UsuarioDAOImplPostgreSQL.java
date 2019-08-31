
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
import sistema.de.lojas.domain.dao.IUsuarioDAO;
import sistema.de.lojas.domain.entities.Usuario;

public class UsuarioDAOImplPostgreSQL implements IUsuarioDAO {

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
    public void inserir(Usuario ent) {

        Connection con = criaConexao();

        String sql = "insert into usuario (nome, endereco, rg)" + " VALUES ('" + ent.getNome() + "','"+ ent.getEndereco() + "','"+ ent.getRG() +  "')";

        try {
            con.createStatement().execute(sql);
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    @Override
    public void atualizar(Usuario ent) {

        Connection con = criaConexao();
        String sql = "update usuario set nome = ?, endereco = ?, rg = ? where id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setString(2, ent.getEndereco());
            ps.setString(3, ent.getRG());
            ps.setInt(4, ent.getID());
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

        String sql = "delete from usuario where id ="+id;

        try {
            con.createStatement().execute(sql);
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    @Override
    public List<Usuario> consultar() {
        try{
            List<Usuario> lista = new ArrayList<>();
            
            String sql = "select * from usuario";
            
            Connection con = criaConexao();
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Usuario c = new Usuario();
                c.setID(res.getInt("id"));
                c.setNome(res.getString("nome"));
                c.setEndereco(res.getString("endereco"));
                c.setRG(res.getString("rg"));
                lista.add(c);
            }
            
            return lista;
        } catch( Exception erro){
            erro.printStackTrace();
        }
        return null;
    }

}

    