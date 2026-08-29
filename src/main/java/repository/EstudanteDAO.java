/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    // INSERIR

    public void incluir(Estudante estudante) {

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

            int linhasInseridas = stmt.executeUpdate();

            if (linhasInseridas > 0) {
                System.out.println(
                    "Estudante " + estudante.getNome() +
                    " inserido com sucesso!"
                );
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

            throw new RuntimeException(
                "Erro ao inserir estudante no banco de dados."
            );

        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    // ALTERAR

    public void alterar(Estudante estudante) {

        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "UPDATE ESTUDANTE SET " +
                "nome = ?, " +
                "curso = ?, " +
                "semestre = ?, " +
                "email = ?, " +
                "telefone = ?, " +
                "situacao = ? " +
                "WHERE matricula = ?"
            );

            stmt.setString(1, estudante.getNome());
            stmt.setString(2, estudante.getCurso());
            stmt.setInt(3, estudante.getSemestre());
            stmt.setString(4, estudante.getEmail());
            stmt.setString(5, estudante.getTelefone());
            stmt.setString(6, estudante.getSituacao());
            stmt.setString(7, estudante.getMatricula());

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {

                System.out.println(
                    "Estudante " + estudante.getNome() +
                    " alterado com sucesso!"
                );

            } else {

                System.out.println(
                    "Nenhum estudante encontrado com a matrícula: " +
                    estudante.getMatricula()
                );
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

            throw new RuntimeException(
                "Erro ao alterar estudante no banco de dados."
            );

        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    // EXCLUIR
    
    public void excluir(Estudante estudante) {

        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "DELETE FROM ESTUDANTE WHERE matricula = ?"
            );

            stmt.setString(1, estudante.getMatricula());

            int linhasExcluidas = stmt.executeUpdate();

            if (linhasExcluidas > 0) {

                System.out.println(
                    "Estudante " + estudante.getNome() +
                    " excluído com sucesso!"
                );

            } else {

                System.out.println(
                    "Nenhum estudante encontrado com a matrícula: " +
                    estudante.getMatricula()
                );
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

            throw new RuntimeException(
                "Erro ao excluir estudante do banco de dados."
            );

        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    // CONSULTAR TODOS

    public List<Estudante> consulta() {

        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Estudante> estudantes = new ArrayList<>();

        try {

            stmt = con.prepareStatement(
                "SELECT matricula, nome, curso, semestre, " +
                "email, telefone, situacao " +
                "FROM ESTUDANTE " +
                "ORDER BY nome"
            );

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

            throw new RuntimeException(
                "Erro ao consultar estudantes no banco de dados."
            );

        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }

        return estudantes;
    }

    // CONSULTAR POR MATRÍCULA

    public Estudante consultarPorMatricula(String matricula) {

        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement(
                "SELECT matricula, nome, curso, semestre, " +
                "email, telefone, situacao " +
                "FROM ESTUDANTE " +
                "WHERE matricula = ?"
            );

            stmt.setString(1, matricula);

            rs = stmt.executeQuery();

            if (rs.next()) {

                Estudante estudante = new Estudante();

                estudante.setMatricula(rs.getString("matricula"));
                estudante.setNome(rs.getString("nome"));
                estudante.setCurso(rs.getString("curso"));
                estudante.setSemestre(rs.getInt("semestre"));
                estudante.setEmail(rs.getString("email"));
                estudante.setTelefone(rs.getString("telefone"));
                estudante.setSituacao(rs.getString("situacao"));

                return estudante;
            }

            return null;

        } catch (SQLException ex) {

            ex.printStackTrace();

            throw new RuntimeException(
                "Erro ao consultar estudante por matrícula."
            );

        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
    }

    // CONSULTAR POR NOME

    public List<Estudante> consultarPorNome(String nome) {

        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Estudante> estudantes = new ArrayList<>();

        try {

            stmt = con.prepareStatement(
                "SELECT matricula, nome, curso, semestre, " +
                "email, telefone, situacao " +
                "FROM ESTUDANTE " +
                "WHERE LOWER(nome) LIKE LOWER(?) " +
                "ORDER BY nome"
            );

            stmt.setString(1, "%" + nome + "%");

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

            throw new RuntimeException(
                "Erro ao consultar estudante por nome."
            );

        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }

        return estudantes;
    }
}

