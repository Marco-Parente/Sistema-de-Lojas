
package sistema.de.lojas.domain.dao.list;

import java.util.ArrayList;
import java.util.List;
import sistema.de.lojas.domain.dao.IProdutoDAO;
import sistema.de.lojas.domain.entities.Produto;

public class ProdutoDAOImpl implements IProdutoDAO {
    private static List<Produto> produtos = new ArrayList<>();
    private static int lastId = 1;

    @Override
    public void inserir(Produto ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(produtos.contains(ent)){
            throw new RuntimeException("Valor repetido.");
        }
        ent.setID(lastId);
        lastId++;
        produtos.add(ent);
    }

    @Override
    public void atualizar(Produto ent) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto get = produtos.get(i);
            if(ent.getID() == get.getID()){
                if(!produtos.contains(ent)){
                    produtos.set(i, ent);
                }
            }
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto get = produtos.get(i);
            if(get.getID() == id){
                produtos.remove(i);
            }
            
        }
    }

    @Override
    public List<Produto> consultar() {
        return produtos;
    }
}
   
    