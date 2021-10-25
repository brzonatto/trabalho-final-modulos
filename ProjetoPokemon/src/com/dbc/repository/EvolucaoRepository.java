package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Evolucao;
import com.dbc.model.Habilidade;
import com.dbc.model.Pokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvolucaoRepository implements Repositorio<Integer, Evolucao>{
    PokemonRepository pokemonRepository = new PokemonRepository();
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_ID_EVOLUCAO.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Evolucao adicionar(Evolucao evolucao) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            evolucao.setIdEvolucao(proximoId);

            String sql = "INSERT INTO EVOLUCAO " +
                    "(ID_EVOLUCAO, ID_POKE_ESTAGIO_1_EVOLUCAO, ID_POKE_ESTAGIO_2_EVOLUCAO, ID_POKE_ESTAGIO_3_EVOLUCAO) " +
                    "VALUES(?, ?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, evolucao.getIdEvolucao());
            stmt.setInt(2, evolucao.getEstagioUm().getIdPokemon());
            stmt.setInt(3, evolucao.getEstagioDois().getIdPokemon());
            stmt.setInt(4, evolucao.getEstagioTres().getIdPokemon());

            int res = stmt.executeUpdate();
//            System.out.println("adicionarEvolucao.res=" + res);
            return evolucao;
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

            String sql = "DELETE FROM EVOLUCAO WHERE ID_EVOLUCAO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
//            System.out.println("removerEvolucaoPorId.res=" + res);

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
    public boolean editar(Integer id, Evolucao evolucao) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Evolucao> listar() throws BancoDeDadosException {
        List<Evolucao> evolucoes = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM EVOLUCAO";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Evolucao evolucao = new Evolucao();
                evolucao.setIdEvolucao(res.getInt("ID_EVOLUCAO"));
                List<Pokemon> pokemons = pokemonRepository.pegarPokemonPorIdEvolucao(evolucao.getIdEvolucao());
                evolucao.setEstagioUm(pokemons.get(0));
                evolucao.setEstagioDois(pokemons.get(1));
                evolucao.setEstagioTres(pokemons.get(2));

                evolucoes.add(evolucao);
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
        return evolucoes;
    }


}
