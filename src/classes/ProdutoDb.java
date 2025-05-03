/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Etec-User
 */
public class ProdutoDb {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statment;

    public ProdutoDb() {
        this.connection = new DataBase().getConnection();
    }

    public ResultSet selectAll(String termo) {
        ResultSet produtos = null;
        String sql = "SELECT * from produto";

        if (!termo.isEmpty()) {
            try {
                sql = "SELECT * from produto WHERE codigo = ? OR nome LIKE ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, termo);
                preparedStatement.setString(2, "%" + termo + "%");

                produtos = preparedStatement.executeQuery();
            } catch (SQLException ex) {
                System.out.println("Erro na pesquisa: " + ex.getMessage());
            }
        } else {
            try {
                statment = connection.createStatement();
                produtos = statment.executeQuery(sql);
            } catch (SQLException ex) {
                System.out.println("Erro na pesquisa: " + ex.getMessage());
            }
        }
        return produtos;
    }
    

    public Integer insert(String nome, double preco, Integer estoque) {
        Integer insertResult = 0;
        String sql = "INSERT INTO produto (nome, preco, estoque) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setInt(3, estoque);

            insertResult = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na inserção: " + ex.getMessage());
        }

        return insertResult;
    }
    
    public Integer delete(String codigo){
        int deleteResult = 0;
        String sql = "DELETE FROM produto WHERE codigo = ?";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, codigo);

            deleteResult = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao remover produto. ERRO: " + ex.getMessage());
        }

        return deleteResult;
    }
    
    public ResultSet selectById(String codigo) {
        ResultSet produto = null;
        String sql = "SELECT * FROM produto WHERE codigo = ? LIMIT 1";

        if (!codigo.isEmpty()) {
            try {
                sql = "SELECT * from produto WHERE codigo = ? OR nome LIKE ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, codigo);

                produto = preparedStatement.executeQuery();
                
            } catch (SQLException ex) {
                System.out.println("Erro na pesquisa: " + ex.getMessage());
            }
        } else {
            try {
                statment = connection.createStatement();
                produto = statment.executeQuery(sql);
            } catch (SQLException ex) {
                System.out.println("Erro na pesquisa: " + ex.getMessage());
            }
        }
        return produto;
    }
    
     public Integer update(String nome, double preco, Integer estoque) {
        Integer insertResult = 0;
        String sql = "INSERT INTO produto (nome, preco, estoque) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setInt(3, estoque);

            insertResult = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro na inserção: " + ex.getMessage());
        }

        return insertResult;
    }

}
