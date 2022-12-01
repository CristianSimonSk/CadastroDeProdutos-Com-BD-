
package Conexao;

import Dados.Produto;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDB {
    private Connection conexao = null;

    public ProdutoDB() throws SQLException {
        this.conexao = new ConectorDB().getConexao();
    }
    
    public ArrayList<Produto> consultar(String buscaProduto) throws SQLException{
        String sql = "select * from cadastro.produto where nomeProduto like?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1,buscaProduto);
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        
        while(rs.next()){
            Produto produto = new Produto();
            produto.setId(rs.getInt("Id"));
            produto.setNomeProduto(rs.getString("nomeProduto"));
            produto.setEspecificacao(rs.getString("especificacao"));
            produto.setPrecoVenda(rs.getFloat("precoVenda"));
            produto.setPrecoCusto(rs.getFloat("precoCusto"));
            produto.setHabilitado(rs.getInt("habilitado"));
            
            listaProdutos.add(produto);
        }
        rs.close();
        stmt.close();
        conexao.close();
        return listaProdutos;
    }
    
    public void newProduto(Produto produto) throws SQLException{
        String sql = "insert into produto(nomeProduto, especificacao, precoVenda, precoCusto, habilitado)" + "values(?,?,?,?,?)";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getEspecificacao());
            stmt.setFloat(3, produto.getPrecoVenda());
            stmt.setFloat(4, produto.getPrecoCusto());
            stmt.setInt(5, produto.getHabilitado());
            stmt.execute();        
        }
        conexao.close();
    }
    
    public void alteraProduto(Produto produto) throws SQLException{
        String sql = "update produto set nomeProduto=?, especificacao=?, precoVenda=?, precoCusto=?, habilitaVenda=?";        
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getEspecificacao());
            stmt.setFloat(3, produto.getPrecoVenda());
            stmt.setFloat(4, produto.getPrecoCusto());
            stmt.setInt(5, produto.getHabilitado());
            stmt.setInt(6, produto.getId());       
            stmt.execute();        
        }
        conexao.close();
    }
    
    public void deleteProduto(Produto produto) throws SQLException{
        String sql = "delete from produto where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);        
        stmt.setInt(1, produto.getId());       
        stmt.execute();        
        
        conexao.close();        
    }
    
    public void primProduto(Produto referencia) throws SQLException{
        String sql = "select * from produto";
        Statement stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        
        rs.first();
       
        referencia.setId(rs.getInt("Id"));
        referencia.setNomeProduto(rs.getString("nomeProduto"));
        referencia.setEspecificacao(rs.getString("especificacao"));
        referencia.setPrecoVenda(rs.getFloat("precoVenda"));
        referencia.setPrecoCusto(rs.getFloat("precoCusto"));
        referencia.setHabilitado(rs.getInt("habilitado"));
        rs.close();
        
        conexao.close();  
    }
    
    public void antProduto(Produto referencia){
        
    }
    
    public void proxProduto(Produto referencia){
        
    }
    
    public void ultProduto(Produto referencia){
        
    }
}
