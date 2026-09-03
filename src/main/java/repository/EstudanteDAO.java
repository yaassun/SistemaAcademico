package repository;

import model.Estudante;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {

    // CADASTRAR
    public void inserir(Estudante estudante) {

        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "INSERT INTO ESTUDANTE " +
                "(matricula, nome, curso, semestre, email, telefone, situacao) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            stmt.setString(1, estudante.getMatricula());
            stmt.setString(2, estudante.getNome());
            stmt.setString(3, estudante.getCurso());
            stmt.setInt(4, estudante.getSemestre());
            stmt.setString(5, estudante.getEmail());
            stmt.setString(6, estudante.getTelefone());
            stmt.setString(7, estudante.getSituacao());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    // CONSULTAR POR MATRÍCULA OU NOME
    public List<Estudante> consultar(String busca) {

        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Estudante> estudantes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(
                "SELECT * FROM ESTUDANTE " +
                "WHERE matricula = ? OR LOWER(nome) LIKE LOWER(?) " +
                "ORDER BY nome"
            );

            stmt.setString(1, busca);
            stmt.setString(2, "%" + busca + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Estudante estudante = new Estudante();

                estudante.setMatricula(rs.getString("matricula"));
                estudante.setNome(rs.getString("nome"));
                estudante.setCurso(rs.getString("curso"));
                estudante.setSemestre(rs.getInt("semestre"));
                estudante.setEmail(rs.getString("email"));
                estudante.setTelefone(rs.getString("telefone"));
                estudante.setSituacao(rs.getString("situacao"));

                estudantes.add(estudante);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }

        return estudantes;
    }

    // ALTERAR
    public void alterar(Estudante estudante) {

        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "UPDATE ESTUDANTE SET " +
                "nome = ?, curso = ?, semestre = ?, email = ?, " +
                "telefone = ?, situacao = ? " +
                "WHERE matricula = ?"
            );

            stmt.setString(1, estudante.getNome());
            stmt.setString(2, estudante.getCurso());
            stmt.setInt(3, estudante.getSemestre());
            stmt.setString(4, estudante.getEmail());
            stmt.setString(5, estudante.getTelefone());
            stmt.setString(6, estudante.getSituacao());
            stmt.setString(7, estudante.getMatricula());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    // EXCLUIR
    public void excluir(String matricula) {

        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "DELETE FROM ESTUDANTE WHERE matricula = ?"
            );

            stmt.setString(1, matricula);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
