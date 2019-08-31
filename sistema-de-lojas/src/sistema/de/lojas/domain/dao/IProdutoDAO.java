
package sistema.de.lojas.domain.dao;

import java.util.List;
import sistema.de.lojas.domain.entities.Produto;

public interface IProdutoDAO {

    public void inserir(Produto produto);

    public void atualizar(Produto produto);

    public void remover(int id);

    public List<Produto> consultar();

}


    