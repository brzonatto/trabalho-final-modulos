package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Habilidade;
import com.dbc.model.Pokemon;
import com.dbc.model.Tipo;
import com.dbc.model.TipoPokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoPokemonRepository implements Repositorio<Integer, TipoPokemon> {


    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_ID_POKEMON_TIPO.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public TipoPokemon adicionar(TipoPokemon tipoPokemon) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            tipoPokemon.setIdTipoPokemon(proximoId);

            String sql = "INSERT INTO POKEMON_TIPO\n" +
                    "(NOME_TIPO, FK_POKEMON_ID_POKEMON, ID_POKEMON_TIPO)\n" +
                    "VALUES(?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, tipoPokemon.getTipo().getNome());
            stmt.setInt(2, tipoPokemon.getPokemon().getIdPokemon());
            stmt.setInt(3, tipoPokemon.getIdTipoPokemon());

            int res = stmt.executeUpdate();
            System.out.println("adicionarTipo.res=" + res);
            return tipoPokemon;
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

            String sql = "DELETE FROM POKEMON_TIPO WHERE FK_POKEMON_ID_POKEMON = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerTipoPorId.res=" + res);

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
    public boolean editar(Integer id, TipoPokemon tipoPokemon) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE POKEMON_TIPO SET ");
            sql.append(" NOME_TIPO = ?,");
            sql.append(" WHERE FK_POKEMON_ID_POKEMON = ? AND NOME_TIPO = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, tipoPokemon.getTipo().getNome());
            stmt.setInt(2, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarTipo.res=" + res);

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

    public boolean editar(Integer id, TipoPokemon tipoPokemon, String nome) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE POKEMON_TIPO SET ");
            sql.append(" NOME_TIPO = ?,");
            sql.append(" WHERE FK_POKEMON_ID_POKEMON = ? AND NOME_TIPO = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, tipoPokemon.getTipo().getNome());
            stmt.setInt(2, id);
            stmt.setString(3, nome);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarTipo.res=" + res);

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
    public List<TipoPokemon> listar() throws BancoDeDadosException {
        List<TipoPokemon> tipoPokemons = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT P.NOME_POKEMON, PT.NOME_TIPO " +
                    "FROM POKEMON P " +
                    "INNER JOIN POKEMON_TIPO PT ON (PT.FK_POKEMON_ID_POKEMON = P.ID_POKEMON)";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                TipoPokemon tipoPokemon = getTipoPokemonFromResultSet(res);
                tipoPokemons.add(tipoPokemon);
            }
            return tipoPokemons;
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

    public List<TipoPokemon> listarTiposDoPokemon(Integer id) throws BancoDeDadosException {
        List<TipoPokemon> tipoPokemons = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT PT.NOME_TIPO " +
                    " FROM POKEMON P " +
                    " INNER JOIN POKEMON_TIPO PT ON (PT.FK_POKEMON_ID_POKEMON = P.ID_POKEMON)" +
                    " WHERE P.ID_POKEMON = ? ";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                TipoPokemon tipoPokemon = new TipoPokemon();
                tipoPokemon.setIdTipoPokemon(res.getInt("ID_POKEMON_TIPO"));
                tipoPokemon.setTipo(Tipo.ofTipo(res.getString("NOME_TIPO")));


                tipoPokemons.add(tipoPokemon);
            }
            return tipoPokemons;
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

    public boolean removerTipoDoPokemon(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM POKEMON_TIPO WHERE FK_POKEMON_ID_POKEMON = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerPOKETIPOPorId.res=" + res);

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

    private TipoPokemon getTipoPokemonFromResultSet(ResultSet res) throws SQLException {
        TipoPokemon tipoPokemon = new TipoPokemon();
        tipoPokemon.setTipo(Tipo.ofTipo(res.getString("NOME_TIPO")));
        Pokemon pokemon = new Pokemon();
        pokemon.setIdPokemon(res.getInt("FK_POKEMON_ID_POKEMON"));
        tipoPokemon.setIdTipoPokemon(res.getInt("ID_POKEMON_TIPO"));

        return tipoPokemon;
    }

    public List<String> filtrarPokemonPorTipo(String tipoPesquisado) throws BancoDeDadosException{
        List<String> pokemonFiltrados = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT P.NOME_POKEMON FROM POKEMON P\n" +
                    "INNER JOIN POKEMON_TIPO PT ON (P.ID_POKEMON = PT.FK_POKEMON_ID_POKEMON)\n" +
                    "WHERE PT.NOME_TIPO = ?";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tipoPesquisado);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Pokemon pokemon = new Pokemon();
                String nome;
                pokemon.setNome(res.getString("NOME_POKEMON"));
                nome = pokemon.getNome();
                pokemonFiltrados.add(nome);
            }
            return pokemonFiltrados;
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

