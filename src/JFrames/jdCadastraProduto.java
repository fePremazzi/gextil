/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Service.Controller.ProdutoController;
import VOs.Enuns.EnunCor;
import VOs.Enuns.EnunTamanho;
import VOs.ProdutoVO;
import javax.swing.JOptionPane;

/**
 *
 * @author felli
 */
public class jdCadastraProduto extends javax.swing.JFrame {

    /**
     * Creates new form jdCadastraProduto
     */
    public jdCadastraProduto(java.awt.Frame parent, boolean modal) {
//        super(parent, modal);
        initComponents();
        ProdutoController prdCont = new ProdutoController();
        txtId.setText(String.valueOf(prdCont.getNextId()));
    }

    int mode = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVoltar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbTamanho = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbCor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnBuscaProduto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        btnVoltar1 = new javax.swing.JButton();
        txtValor = new javax.swing.JTextField();

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/undo.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de produto");
        setResizable(false);

        txtNome.setEnabled(false);

        jLabel1.setText("Id");

        txtId.setEnabled(false);

        jLabel2.setText("Nome");

        jLabel3.setText("Tamanho");

        cbTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "P", "M", "G" }));

        jLabel4.setText("Cor");

        cbCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amarelo", "Azul", "Beje", "Branco", "Cinza", "Marrom", "Preto", "Rosa", "Roxo", "Verde", "Vermeho", "Vinho" }));

        jLabel5.setText("Valor");

        btnBuscaProduto.setText("Buscar produto");
        btnBuscaProduto.setEnabled(false);
        btnBuscaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaProdutoActionPerformed(evt);
            }
        });

        jLabel6.setText("Descrição:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Fechar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        txtDescricao.setEnabled(false);
        jScrollPane1.setViewportView(txtDescricao);

        btnVoltar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/undo.png"))); // NOI18N
        btnVoltar1.setText("Voltar");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });

        txtValor.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnVoltar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAlterar)
                    .addComponent(btnConfirmar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnVoltar1)
                    .addComponent(btnCancelar)
                    .addComponent(btnBuscaProduto))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        ProdutoVO prd = new ProdutoVO(txtNome.getText().trim(), EnunTamanho.valueOf(cbTamanho.getSelectedItem().toString()),
                EnunCor.valueOf(cbCor.getSelectedItem().toString()),
                Double.parseDouble(txtValor.getText().trim()),
                txtDescricao.getText().trim(),
                Integer.parseInt(txtId.getText().trim()));

        ProdutoController prdCont = new ProdutoController();
        switch (mode) {
            case 0: //Insere
                if (verificaObjeto(prd)) {
                    prdCont.insere(prd);
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha os campos em branco antes de continuar.");
                }
                break;

            case 1: //Exclui
                prdCont.deletaPorId(Integer.parseInt(txtId.getText()));
                JOptionPane.showMessageDialog(null, "Deletado com sucesso.");
                break;

            case 2: //Alterar
                prdCont.update(prd);
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
                break;
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        mode = 0;

        enableInputs(false, true, true, true);
        enableCbs(true, true);
        enableBtn(false, true, false);

        btnBuscaProduto.setEnabled(false);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        mode = 1;

        enableInputs(false, false, false, false);
        enableCbs(false, false);
        enableBtn(false, false, true);

        btnBuscaProduto.setEnabled(true);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        mode = 2;

        enableInputs(false, true, true, true);
        enableCbs(true, true);
        enableBtn(true, false, false);

        btnBuscaProduto.setEnabled(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        ProdutoController prodCont = new ProdutoController();
        enableBtn(true, true, true);
        cleanInputs();
        enableCbs(false, false);
        enableInputs(false, false, false, false);

        txtId.setText(String.valueOf(prodCont.getNextId()));
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnBuscaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaProdutoActionPerformed
        ProdutoVO prd = new ProdutoVO();
        jdConsultaProduto frConsulta = new jdConsultaProduto(this, rootPaneCheckingEnabled, prd);
        frConsulta.setModal(true);
        frConsulta.setLocationRelativeTo(this);
        frConsulta.setVisible(true);

        if (prd.getId() != 0) {
            txtId.setText(String.valueOf(prd.getId()));
            txtNome.setText(prd.getNome());
            txtValor.setText(String.valueOf(prd.getValorUnit()));
            txtDescricao.setText(prd.getDescricao());

            switch (prd.getTamanho()) {
                case P:
                    cbTamanho.setSelectedIndex(0);
                    break;
                case M:
                    cbTamanho.setSelectedIndex(1);

                    break;
                case G:
                    cbTamanho.setSelectedIndex(2);

                    break;
                case GG:
                    cbTamanho.setSelectedIndex(3);

                    break;
                case GGG:
                    cbTamanho.setSelectedIndex(4);
                    break;
                default:
                    cbTamanho.setSelectedIndex(0);
                    break;
            }

            switch (prd.getCor()) {
                case Amarelo:
                    cbCor.setSelectedIndex(0);
                    break;
                case Azul:
                    cbCor.setSelectedIndex(1);
                    break;
                case Beje:
                    cbCor.setSelectedIndex(2);
                    break;
                case Branco:
                    cbCor.setSelectedIndex(3);
                    break;
                case Cinza:
                    cbCor.setSelectedIndex(4);
                    break;
                case Marrom:
                    cbCor.setSelectedIndex(5);
                    break;
                case Preto:
                    cbCor.setSelectedIndex(6);
                    break;
                case Rosa:
                    cbCor.setSelectedIndex(7);
                    break;
                case Roxo:
                    cbCor.setSelectedIndex(8);
                    break;
                case Verde:
                    cbCor.setSelectedIndex(9);
                    break;
                case Vermelho:
                    cbCor.setSelectedIndex(10);
                    break;
                case Vinho:
                    cbCor.setSelectedIndex(11);
                    break;
                default:
                    cbCor.setSelectedIndex(0);
                    break;
            }

        }
    }//GEN-LAST:event_btnBuscaProdutoActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
        ProdutoController prodCont = new ProdutoController();
        enableBtn(true, true, true);
        cleanInputs();
        enableCbs(false, false);
        enableInputs(false, false, false, false);
        btnBuscaProduto.setEnabled(false);

        txtId.setText(String.valueOf(prodCont.getNextId()));        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltar1ActionPerformed

    private void cleanInputs() {
        txtId.setText("");
        txtNome.setText("");
        txtDescricao.setText("");
        txtValor.setText("");
        cbTamanho.setSelectedIndex(0);
        cbCor.setSelectedIndex(0);

    }

    private void enableCbs(boolean cbCor, boolean cbTamanho) {
        this.cbCor.setEnabled(cbCor);
        this.cbTamanho.setEnabled(cbTamanho);
    }

    private void enableInputs(boolean txtId, boolean txtDescricao, boolean txtValor, boolean txtNome) {
        this.txtId.setEnabled(txtId);
        this.txtDescricao.setEnabled(txtDescricao);
        this.txtValor.setEnabled(txtValor);
        this.txtNome.setEnabled(txtNome);
    }

    private void enableBtn(boolean btnAlterar, boolean btnCadastrar, boolean btnExcluir) {
        this.btnAlterar.setEnabled(btnAlterar);
        this.btnCadastrar.setEnabled(btnCadastrar);
        this.btnExcluir.setEnabled(btnExcluir);
    }

    private boolean verificaObjeto(ProdutoVO prd) {
        if (prd.getNome().isEmpty() || prd.getNome() == null) {
            return false;
        } else if (prd.getCor() == null) {
            return false;
        } else if (prd.getId() < 0) {
            return false;
        } else if (prd.getDescricao().isEmpty() || prd.getDescricao() == null) {
            return false;
        } else if (prd.getTamanho() == null) {
            return false;
        } else if (prd.getValorUnit() <= 0) {
            return false;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdCadastraProduto dialog = new jdCadastraProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscaProduto;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JComboBox<String> cbCor;
    private javax.swing.JComboBox<String> cbTamanho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
