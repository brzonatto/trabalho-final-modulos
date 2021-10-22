package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dbc.model.Pokemon;

public class PokemonRepository implements Repositorio<Integer, Pokemon> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_ID_POKEMON.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Pokemon adicionar(Pokemon pokemon) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            pokemon.setIdPokemon(proximoId);

            String sql = "INSERT INTO POKEMON\n" +
                    "(ID_POKEMON, NUMERO_POKEMON, NOME_POKEMON, LEVEL_POKEMON, PESO_POKEMON, ALTURA_POKEMON, CATEGORIA_POKEMON, REGIAO_DOMINANTE_POKE_LENDARIO, HP_STATUS, ATAQUE_STATUS, DEFESA_STATUS, ATAQUE_ESPECIAL_STATUS, DEFESA_ESPECIAL_STATUS, VELOCIDADE_STATUS)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, pokemon.getIdPokemon());
            stmt.setInt(2, pokemon.getNumero());
            stmt.setString(3, pokemon.getNome());
            stmt.setInt(4, pokemon.getLevel());
            stmt.setDouble(5, pokemon.getPeso());
            stmt.setDouble(6, pokemon.getAltura());
            stmt.setString(7, pokemon.getCategoria());
            stmt.setString(8, ((PokemonLendario) pokemon).getRegiaoDominante());//TODO VER CAST
            stmt.setInt(9, pokemon.getStatus().getHp());//HP_STATUS
            stmt.setInt(10, pokemon.getStatus().getAtaque());//ATAQUE_STATUS,
            stmt.setInt(11, pokemon.getStatus().getDefesa());//DEFESA_STATUS,
            stmt.setInt(12, pokemon.getStatus().getEspecialAtaque());//ATAQUE_ESPECIAL_STATUS,
            stmt.setInt(13, pokemon.getStatus().getEspecialDefesa());//DEFESA_ESPECIAL_STATUS,
            stmt.setInt(14, pokemon.getStatus().getVelocidade());//VELOCIDADE_STATUS


            int res = stmt.executeUpdate();
            System.out.println("adicionarPokemon.res=" + res);
            return pokemon;
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

            String sql = "DELETE FROM POKEMON WHERE ID_POKEMON = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerPokemonPorId.res=" + res);

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
    public boolean editar(Integer id, Pokemon pokemon) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE POKEMON SET ");
            sql.append(" numero = ?,");
            sql.append(" nome = ?,");
            sql.append(" level = ? ");
            sql.append(" peso = ? ");
            sql.append(" altura = ? ");
            sql.append(" categoria = ? ");
            sql.append(" HP = ? ");
            sql.append(" ataque = ? ");
            sql.append(" defesa = ? ");
            sql.append(" especialAtaque = ? ");
            sql.append(" especialDefesa = ? ");
            sql.append(" velocidade = ? ");
            sql.append(" WHERE ID_POKEMON  = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, pokemon.getNumero());
            stmt.setString(2, pokemon.getNome());
            stmt.setInt(3, pokemon.getLevel());
            stmt.setDouble(4, pokemon.getPeso());
            stmt.setDouble(5, pokemon.getAltura());
            stmt.setString(6, pokemon.getCategoria());
            stmt.setString(7, pokemon.getRegiaoDominante());
            stmt.setInt(8, pokemon.getStatus().getHp());//HP_STATUS
            stmt.setInt(9, pokemon.getStatus().getAtaque());//ATAQUE_STATUS,
            stmt.setInt(10, pokemon.getStatus().getDefesa());//DEFESA_STATUS,
            stmt.setInt(11, pokemon.getStatus().getEspecialAtaque());//ATAQUE_ESPECIAL_STATUS,
            stmt.setInt(12, pokemon.getStatus().getEspecialDefesa());//DEFESA_ESPECIAL_STATUS,
            stmt.setInt(13, pokemon.getStatus().getVelocidade());//VELOCIDADE_STATUS
            stmt.setInt(4, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarPessoa.res=" + res);

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
    public List<Pokemon> listar() throws BancoDeDadosException {
        List<Pokemon> pokemons = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM POKEMON";


            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setIdPokemon(res.getInt("id_pokemon"));
                pokemon.setNome(res.getString("nome_pokemon"));
                pokemon.setLevel(res.getInt("level_pokemon"));
                pokemon.setPeso(res.getDouble("peso_pokemon"));
                pokemon.setAltura(res.getDouble("altura_pokemon"));
                pokemon.setCategoria(res.getString("categoria_pokemon"));
                pokemon.setRegiaoDominante(res.getString("regiao_dominante_pokemon_lendario"));
                pokemon.getStatus().setHp(res.getInt("hp_status"));
                pokemon.getStatus().setAtaque(res.getInt("ataque_status"));
                pokemon.getStatus().setDefesa(res.getInt("defesa_status"));
                pokemon.getStatus().setEspecialAtaque(res.getInt("ataque_especial_status"));
                pokemon.getStatus().setEspecialDefesa(res.getInt("defesa_especial_status"));
                pokemon.getStatus().setVelocidade(res.getInt("velocidade_status"));

                pokemons.add(pokemon);
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
        return pokemons;
    }

}
