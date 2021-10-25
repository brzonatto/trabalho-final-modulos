package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Habilidade;
import com.dbc.model.Pokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabilidadeRepository implements Repositorio<Integer, Habilidade> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_ID_HABILIDADE.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Habilidade adicionar(Habilidade habilidade) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            habilidade.setIdHabilidade(proximoId);

            String sql = "INSERT INTO HABILIDADE \n" +
                    "(ID_HABILIDADE, NOME_HABILIDADE, MULT_DE_PODER_HABILIDADE)\n" +
                    "VALUES(?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, habilidade.getIdHabilidade());
            stmt.setString(2, habilidade.getNome());
            stmt.setDouble(3, habilidade.getMultiplicacaoDePoder());

            int res = stmt.executeUpdate();
//            System.out.println("adicionarHabilidade.res=" + res);
            return habilidade;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM HABILIDADE H WHERE H.ID_HABILIDADE = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
//            System.out.println("removerHabilidadePorId.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id, Habilidade habilidade) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE HABILIDADE H SET ");
            sql.append(" H.NOME_HABILIDADE = ?,");
            sql.append(" H.MULT_DE_PODER_HABILIDADE = ?");
            sql.append(" WHERE H.ID_HABILIDADE = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, habilidade.getNome());
            stmt.setDouble(2, habilidade.getMultiplicacaoDePoder());
            stmt.setDouble(3, id);


            // Executa-se a consulta
            int res = stmt.executeUpdate();
//            System.out.println("editarHabilidade.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Habilidade> listar() throws BancoDeDadosException {
        List<Habilidade> habilidades = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM HABILIDADE";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Habilidade habilidade = new Habilidade();
                habilidade.setIdHabilidade(res.getInt("ID_HABILIDADE"));
                habilidade.setNome(res.getString("NOME_HABILIDADE"));
                habilidade.setMultiplicacaoDePoder(res.getDouble("MULT_DE_PODER_HABILIDADE"));
                habilidades.add(habilidade);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return habilidades;
    }

    public void adicionarHabilidadeAoPokemon(Integer idHab, Integer idPoke) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "INSERT INTO POKEMON_HABILIDADE \n" +
                    "(FK_HABILIDADE_ID_HABILIDADE, FK_POKEMON_ID_POKEMON)\n" +
                    "VALUES(?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idHab);
            stmt.setInt(2, idPoke);


            int res = stmt.executeUpdate();
//            System.out.println("adicionarHabAoPoke.res=" + res);
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean removerHabilidadeDoPokemon(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM POKEMON_HABILIDADE WHERE FK_HABILIDADE_ID_HABILIDADE = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
//            System.out.println("removerPOKEHABILIDADEPorId.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean removerPokemonDaHabilidade(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM POKEMON_HABILIDADE WHERE FK_POKEMON_ID_POKEMON = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
//            System.out.println("removerPOKEHABILIDADEPorId.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
