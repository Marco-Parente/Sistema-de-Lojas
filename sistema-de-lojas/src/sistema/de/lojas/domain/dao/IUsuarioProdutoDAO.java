
package sistema.de.lojas.domain.dao;

import java.util.List;
import sistema.de.lojas.domain.entities.UsuarioProduto;

public interface IUsuarioProdutoDAO {

    public void inserir(UsuarioProduto usuarioproduto);

    public void atualizar(UsuarioProduto usuarioproduto);

    public void remover(int id);

    public List<UsuarioProduto> consultar();

}


    