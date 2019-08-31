
package sistema.de.lojas.domain.dao;

import java.util.List;
import sistema.de.lojas.domain.entities.Loja;

public interface ILojaDAO {

    public void inserir(Loja loja);

    public void atualizar(Loja loja);

    public void remover(int id);

    public List<Loja> consultar();

}


    