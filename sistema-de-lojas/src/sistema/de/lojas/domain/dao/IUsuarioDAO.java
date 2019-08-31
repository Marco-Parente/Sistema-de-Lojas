
package sistema.de.lojas.domain.dao;

import java.util.List;
import sistema.de.lojas.domain.entities.Usuario;

public interface IUsuarioDAO {

    public void inserir(Usuario usuario);

    public void atualizar(Usuario usuario);

    public void remover(int id);

    public List<Usuario> consultar();

}


    