package sistema.de.lojas.domain;

import java.util.Scanner;
import sistema.de.lojas.domain.dao.IUsuarioDAO;
import sistema.de.lojas.domain.dao.postgresql.UsuarioDAOImplPostgreSQL;
import sistema.de.lojas.domain.entities.Usuario;

public class SistemaDeLojas {

    public static void main(String[] args) {

        IUsuarioDAO banco = new UsuarioDAOImplPostgreSQL();

        Scanner t = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("Menu");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Remover");
            System.out.println("4 - Consultar");
            System.out.println("5 - Sair");
            System.out.println("Digite a opção desejada: ");
            opcao = t.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrando...");
                    Usuario nova = new Usuario();
                    System.out.println("Digite o nome do usuario: ");
                    nova.setNome(t.next());
                    System.out.println("Digite o endereco do usuario: ");
                    nova.setEndereco(t.next());
                    System.out.println("Digite o rg do usuario: ");
                    nova.setRG(t.next());
                    try {
                        banco.inserir(nova);
                        System.out.println("Inserido com Sucesso!");
                    } catch (Exception erro) {
                        System.out.println(erro.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Atualizando...");
                    System.out.println("Digite o ID: ");
                    Usuario c = new Usuario();
                    c.setID(t.nextInt());
                    System.out.println("Digite o nome atualizado");
                    c.setNome(t.next());
                    System.out.println("Digite o endereco atualizado");
                    c.setEndereco(t.next());
                    System.out.println("Digite o rg atualizado");
                    c.setRG(t.next());
                    banco.atualizar(c);
                    System.out.println("Atualizado com Sucesso!");
                    break;
                case 3:
                    System.out.println("Removendo...");
                    System.out.println("Digite o ID: ");
                    banco.remover(t.nextInt());
                    System.out.println("Removido com Sucesso!");
                    break;
                case 4:
                    for (Usuario ent : banco.consultar()) {
                        System.out.println(ent.getID() + " - " + ent.getNome());
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 5);
    }

}
