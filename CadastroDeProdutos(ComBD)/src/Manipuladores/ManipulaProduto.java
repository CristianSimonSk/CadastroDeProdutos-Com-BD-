
package Manipuladores;

import Conexao.ProdutoDB;
import Dados.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ManipulaProduto {
    
    
    public ArrayList<Produto> solicitaGetProduto(String produtoPesquisado) throws SQLException{
        ProdutoDB produtosDb = new ProdutoDB();
        ArrayList<Produto> listaProdutos = produtosDb.consultar(produtoPesquisado);
        return listaProdutos;
    }
    
    public void solicitaNewProduto(String nome, String especificacao, String precoC, String habilitado) throws SQLException{
        Produto produto = new Produto();
        produto.setNomeProduto(nome);
        produto.setEspecificacao(especificacao);
        produto.setPrecoVenda((float) (Float.parseFloat(precoC) * 1.3));
        produto.setPrecoCusto(Float.parseFloat(precoC));
        produto.setHabilitado(Integer.parseInt(habilitado));
        
        ProdutoDB produtoDB = new ProdutoDB();
        produtoDB.newProduto(produto);
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
    }
    
    public void solicitaAlterarProduto(String Id, String nome, String especificacao, String precoC, String habilitado) throws SQLException{
        Produto produto = new Produto();
        produto.setId(Integer.parseInt(Id));
        produto.setNomeProduto(nome);
        produto.setEspecificacao(especificacao);
        produto.setPrecoVenda((float) (Float.parseFloat(precoC) * 1.3));
        produto.setPrecoCusto(Float.parseFloat(precoC));
        produto.setHabilitado(Integer.parseInt(habilitado));
        
        ProdutoDB produtoDB = new ProdutoDB();
        produtoDB.alteraProduto(produto);
        JOptionPane.showMessageDialog(null, "Produto alterado com sucesso.");
    }
    
    public void solicitaDeleteProduto(String Id) throws SQLException{
        Produto produto = new Produto();
        produto.setId(Integer.parseInt(Id));
        ProdutoDB produtoDb = new ProdutoDB(); 
        produtoDb.deleteProduto(produto);
        JOptionPane.showMessageDialog(null, "Produto removido com sucesso.");       
    }
    
    public void solicitaPrimProduto(Produto referencia) throws SQLException{
        
        ProdutoDB produtoDb = new ProdutoDB(); 
        produtoDb.primProduto(referencia);
        JOptionPane.showMessageDialog(null, "Produto localizado com sucesso.");
        
              
    }
    
    public void solicitaAntProduto(String Id) throws SQLException{
              
    }
    
    public void solicitaProxProduto(String Id) throws SQLException{
              
    }
    
    public void solicitaUltProduto(String Id) throws SQLException{
              
    }
    
    
    
    
}
