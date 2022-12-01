
package Interface;

import Manipuladores.ManipulaProduto;
import Dados.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class RelatoriosPage extends javax.swing.JDialog {

    ManipulaProduto conexao;
    
    public RelatoriosPage(java.awt.Frame parent, boolean modal, ManipulaProduto conexao) {
        super(parent, modal);
        initComponents();
        this.conexao = conexao;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        relTabela = new javax.swing.JTable();
        voltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        relPesquisa = new javax.swing.JButton();
        nomeProduto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        relTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(relTabela);

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite o nome do produto que deseja visualizar:"));

        relPesquisa.setText("Pesquisar");
        relPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relPesquisaActionPerformed(evt);
            }
        });

        nomeProduto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nomeProdutoCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(relPesquisa)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(relPesquisa)
                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    .addComponent(voltar)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        buscaTabela();
    }//GEN-LAST:event_formWindowActivated

    private void relPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relPesquisaActionPerformed
        buscaTabela();
    }//GEN-LAST:event_relPesquisaActionPerformed

    private void buscaTabela() {
        ArrayList<Produto> produto = null;
        try {
            produto = conexao.solicitaGetProduto("%"+relPesquisa.getText()+"%");
        } catch (SQLException ex) {
            Logger.getLogger(RelatoriosPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] titulos = {"ID", "Nome Produto","Especificação Técnica","Preço de Venda","Preço de Custo","Habilitado p/ Venda"};
        
        String[][] informacoes = new String[produto.size()][6];
        
        for(int i = 0; i < produto.size(); i++){
            informacoes[i][0] = String.valueOf(produto.get(i).getId());
            informacoes[i][1] = produto.get(i).getNomeProduto();
            informacoes[i][2] = produto.get(i).getEspecificacao();
            informacoes[i][3] = String.valueOf(produto.get(i).getPrecoVenda());
            informacoes[i][4] = String.valueOf(produto.get(i).getPrecoCusto());
            if(produto.get(i).getHabilitado() == 0){
                informacoes[i][5] = "Sim";
            }else{
                informacoes[i][5] = "Não";
            }
        }
        
        DefaultTableModel tabela = new DefaultTableModel(informacoes, titulos);
        this.relTabela.setModel(tabela);
    }

    private void nomeProdutoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nomeProdutoCaretUpdate
        buscaTabela();
    }//GEN-LAST:event_nomeProdutoCaretUpdate

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JButton relPesquisa;
    private javax.swing.JTable relTabela;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
