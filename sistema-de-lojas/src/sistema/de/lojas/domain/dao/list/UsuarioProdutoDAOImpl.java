
package sistema.de.lojas.domain.dao.list;

import java.util.ArrayList;
import java.util.List;
import sistema.de.lojas.domain.dao.IUsuarioProdutoDAO;
import sistema.de.lojas.domain.entities.UsuarioProduto;

public class UsuarioProdutoDAOImpl implements IUsuarioProdutoDAO {
    private static List<UsuarioProduto> usuarioProdutos = new ArrayList<>();
    private static int lastId = 1;

    @Override
    public void inserir(UsuarioProduto ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(usuarioProdutos.contains(ent)){
            throw new RuntimeException("Valor repetido.");
        }
        ent.setID(lastId);
        lastId++;
        usuarioProdutos.add(ent);
    }

    @Override
    public void atualizar(UsuarioProduto ent) {
        for (int i = 0; i < usuarioProdutos.size(); i++) {
            UsuarioProduto get = usuarioProdutos.get(i);
            if(ent.getID() == get.getID()){
                if(!usuarioProdutos.contains(ent)){
                    usuarioProdutos.set(i, ent);
                }
            }
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < usuarioProdutos.size(); i++) {
            UsuarioProduto get = usuarioProdutos.get(i);
            if(get.getID() == id){
                usuarioProdutos.remove(i);
            }
            
        }
    }

    @Override
    public List<UsuarioProduto> consultar() {
        return usuarioProdutos;
    }
}
   
    