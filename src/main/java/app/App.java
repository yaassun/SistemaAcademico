package app;

import model.Estudante;
import repository.EstudanteDAO;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EstudanteDAO estudanteDAO = new EstudanteDAO();

        // CADASTRAR
        Estudante estudante = new Estudante();

        estudante.setMatricula("2026001");
        estudante.setNome("Maria Oliveira");
        estudante.setSemestre(6);
        estudante.setCurso("Sistemas de Informação");
        estudante.setEmail("maria@email.com");
        estudante.setTelefone("75999999999");
        estudante.setSituacao("Ativo");

        estudanteDAO.incluir(estudante);

        // CONSULTAR
        List<Estudante> estudantes = estudanteDAO.consulta();

        for (Estudante estudante1 : estudantes) {

            System.out.println(
                estudante1.getMatricula() + " - " +
                estudante1.getNome() + " - " +
                estudante1.getCurso()
            );
        }
        
        //ALTERAR
        //estudanteDAO.alterar(estudante);
        //EXCLUIR
        //estudanteDAO.excluir(estudante);
        
    }
}