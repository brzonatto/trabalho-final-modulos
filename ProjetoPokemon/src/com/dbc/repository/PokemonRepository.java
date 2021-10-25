package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dbc.model.*;

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
            stmt.setString(8, pokemon.getRegiaoDominante());
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
            sql.append("UPDATE POKEMON SET \n");

            if (pokemon.getNumero() != null) {
                sql.append(" NUMERO_POKEMON = ?,");
            }
            if (pokemon.getNome() != null) {
                sql.append(" NOME_POKEMON = ?,");
            }
            if (pokemon.getLevel() != null) {
                sql.append(" LEVEL_POKEMON = ?,");
            }
            if (pokemon.getPeso() != null) {
                sql.append(" PESO_POKEMON = ?,");
            }
            if (pokemon.getAltura() != null) {
                sql.append(" ALTURA_POKEMON = ?,");
            }
            if (pokemon.getCategoria() != null) {
                sql.append(" CATEGORIA_POKEMON = ?,");
            }
            if (pokemon.getRegiaoDominante() != null) {
                sql.append(" REGIAO_DOMINANTE_POKE_LENDARIO = ?,");
            }
            Status status = pokemon.getStatus();
            if (status != null) {
                if (status.getHp() != null) {
                    sql.append(" HP_STATUS = ?,");
                }
                if (status.getAtaque() != null) {
                    sql.append(" ATAQUE_STATUS = ?,");
                }
                if (status.getDefesa() != null) {
                    sql.append(" DEFESA_STATUS = ?,");
                }
                if (status.getEspecialAtaque() != null) {
                    sql.append(" ATAQUE_ESPECIAL_STATUS = ?,");
                }
                if (status.getEspecialDefesa() != null) {
                    sql.append(" DEFESA_ESPECIAL_STATUS = ?,");
                }
                if (status.getVelocidade() != null) {
                    sql.append(" VELOCIDADE_STATUS = ?,");
                }
            }
            if (pokemon.getEvolucao() != null) {
                sql.append(" FK_ID_EVOLUCAO = ?,");
            }


            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE ID_POKEMON = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;
            if (pokemon.getNumero() != null) {
                stmt.setInt(index++, pokemon.getNumero());
            }
            if (pokemon.getNome() != null) {
                stmt.setString(index++, pokemon.getNome());
            }
            if (pokemon.getLevel() != null) {
                stmt.setInt(index++, pokemon.getLevel());
            }
            if (pokemon.getPeso() != null) {
                stmt.setDouble(index++, pokemon.getPeso());
            }
            if (pokemon.getAltura() != null) {
                stmt.setDouble(index++, pokemon.getAltura());
            }
            if (pokemon.getCategoria() != null) {
                stmt.setString(index++, pokemon.getCategoria());
            }
            if (pokemon.getRegiaoDominante() != null) {
                stmt.setString(index++, pokemon.getRegiaoDominante());
            }
            if (status != null) {
                if (status.getHp() != null) {
                    stmt.setInt(index++, status.getHp());
                }
                if (status.getAtaque() != null) {
                    stmt.setInt(index++, status.getAtaque());
                }
                if (status.getDefesa() != null) {
                    stmt.setInt(index++, status.getDefesa());
                }
                if (status.getEspecialAtaque() != null) {
                    stmt.setInt(index++, status.getEspecialAtaque());
                }
                if (status.getEspecialDefesa() != null) {
                    stmt.setInt(index++, status.getEspecialDefesa());
                }
                if (status.getVelocidade() != null) {
                    stmt.setInt(index++, status.getVelocidade());
                }
            }
            if (pokemon.getEvolucao() != null) {
                stmt.setInt(index++, pokemon.getEvolucao().getIdEvolucao());
            }

            stmt.setInt(index++, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarPokemon.res=" + res);

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
                Pokemon pokemon = getPokemonFromResultSet(res);
                pokemons.add(pokemon);
            }
            return pokemons;
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

    public List<Pokemon> listarPorTipo(String nomeTipo) throws BancoDeDadosException {
        List<Pokemon> pokemons = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT P.NOME_POKEMON FROM POKEMON P " +
                    "INNER JOIN POKEMON_TIPO PT ON (P.ID_POKEMON = PT.FK_POKEMON_ID_POKEMON) " +
                    "WHERE PT.NOME_TIPO = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nomeTipo);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Pokemon pokemon = getPokemonFromResultSet(res);
                pokemons.add(pokemon);
            }
            return pokemons;
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

    public Pokemon pegarPokemonPorID(Integer id) throws BancoDeDadosException {
        List<Pokemon> pokemons = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM POKEMON P " +
                    "WHERE P.ID_POKEMON = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Pokemon pokemon = getPokemonFromResultSet(res);
                pokemons.add(pokemon);
            }
            return pokemons.get(0);
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

    private Pokemon getPokemonFromResultSet(ResultSet res) throws SQLException {
        Pokemon pokemon = new Pokemon();
        pokemon.setIdPokemon(res.getInt("id_pokemon"));
        pokemon.setNumero(res.getInt("numero_pokemon"));
        pokemon.setNome(res.getString("nome_pokemon"));
        pokemon.setLevel(res.getInt("level_pokemon"));
        pokemon.setPeso(res.getDouble("peso_pokemon"));
        pokemon.setAltura(res.getDouble("altura_pokemon"));
        pokemon.setCategoria(res.getString("categoria_pokemon"));
        pokemon.setRegiaoDominante(res.getString("regiao_dominante_poke_lendario"));
        Status status = new Status();
        status.setHp(res.getInt("hp_status"));
        status.setAtaque(res.getInt("ataque_status"));
        status.setDefesa(res.getInt("defesa_status"));
        status.setEspecialAtaque(res.getInt("ataque_especial_status"));
        status.setEspecialDefesa(res.getInt("defesa_especial_status"));
        status.setVelocidade(res.getInt("velocidade_status"));
        pokemon.setStatus(status);

        ArrayList<TipoPokemon> tiposPokemon = new ArrayList<>();

        return pokemon;
    }

    public List<Pokemon> pegarPokemonPorIdEvolucao(Integer id) throws BancoDeDadosException {
        List<Pokemon> pokemons = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT * FROM POKEMON P " +
                    "WHERE P.FK_ID_EVOLUCAO = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Pokemon pokemon = getPokemonFromResultSet(res);
                pokemons.add(pokemon);
            }
            return pokemons;
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

    public boolean removerEvolucaoPokemon(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE POKEMON P SET");
            sql.append(" P.FK_ID_EVOLUCAO = NULL");
            sql.append(" WHERE P.FK_ID_EVOLUCAO = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarEVOPOKE.res=" + res);

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
