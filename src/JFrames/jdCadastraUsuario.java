/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Service.Controller.UsuarioController;
import VOs.UsuarioVO;
import gextil.config;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author felli
 */
public class jdCadastraUsuario extends javax.swing.JFrame {

    /**
     * Creates new form jdCadastraUsuario
     */
    public jdCadastraUsuario(java.awt.Frame parent, boolean modal) {
//        super(parent, modal);
        initComponents();
        UsuarioController usrCont = new UsuarioController();
        txtId.setText(String.valueOf(usrCont.getNextId()));
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

        jlFoto = new javax.swing.JLabel();
        btnInserirFoto = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnBuscarUsuario = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbRole = new javax.swing.JComboBox<>();
        jLabelCaminho = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastra usuario");
        setResizable(false);

        jlFoto.setBorder(new javax.swing.border.MatteBorder(null));

        btnInserirFoto.setText("Inserir foto");
        btnInserirFoto.setEnabled(false);
        btnInserirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirFotoActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        txtId.setEnabled(false);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        btnCancelar.setText("Fechar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtNome.setEnabled(false);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnBuscarUsuario.setText("Buscar usuario");
        btnBuscarUsuario.setEnabled(false);
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        jLabel4.setText("Usuario");

        txtUsuario.setEnabled(false);

        jLabel5.setText("Senha");

        txtSenha.setEnabled(false);

        jLabel6.setText("Cargo");

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cargo 1", "Cargo 2", "Cargo 3", "Cargo 4" }));
        cbCargo.setEnabled(false);

        jLabel7.setText("Permissao");

        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "normal" }));
        cbRole.setEnabled(false);

        jLabelCaminho.setEnabled(false);

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/undo.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInserirFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(56, 56, 56))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(66, 66, 66)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnConfirmar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(jLabelCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnInserirFoto)
                    .addComponent(btnBuscarUsuario)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

        UsuarioVO usr = new UsuarioVO(txtNome.getText().trim(), txtUsuario.getText().trim(),
                txtSenha.getText().trim(), cbCargo.getSelectedIndex(), cbRole.getSelectedIndex(), Integer.parseInt(txtId.getText().trim()));

        UsuarioController usrC = new UsuarioController();
        switch (mode) {
            case 0: //Insere
                if (verificaObjeto(usr)) {
                    usrC.insere(usr);
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha os campos em branco antes de continuar.");
                }
                break;

            case 1: //Exclui
                usrC.deletaPorId(Integer.parseInt(txtId.getText()));
                JOptionPane.showMessageDialog(null, "Deletado com sucesso.");
                break;

            case 2: //Alterar
                usrC.update(usr);
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
                break;
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        UsuarioVO usr = new UsuarioVO();
        jdConsultaUsuario frConsulta = new jdConsultaUsuario(this, rootPaneCheckingEnabled, usr);
        frConsulta.setModal(true);
        frConsulta.setLocationRelativeTo(this);
        frConsulta.setVisible(true);

        if (usr.getId() != 0) {
            txtId.setText(String.valueOf(usr.getId()));
            txtNome.setText(usr.getNome());
            txtUsuario.setText(usr.getUsername());
            txtSenha.setText("");
            cbCargo.setSelectedIndex(usr.getCargo());
            cbRole.setSelectedIndex(usr.getId_role());

        }
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        mode = 0;
        txtNome.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtSenha.setEnabled(true);
        cbCargo.setEnabled(true);
        btnInserirFoto.setEnabled(true);
        cbRole.setEnabled(true);

        enableBtn(false, true, false);

        btnBuscarUsuario.setEnabled(false);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        mode = 1;
        txtNome.setEnabled(false);
        txtUsuario.setEnabled(false);
        txtSenha.setEnabled(false);
        cbCargo.setEnabled(false);
        btnInserirFoto.setEnabled(false);
        cbRole.setEnabled(false);

        enableBtn(false, false, true);

        btnBuscarUsuario.setEnabled(true);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        mode = 2;
        txtNome.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtSenha.setEnabled(true);
        cbCargo.setEnabled(true);
        btnInserirFoto.setEnabled(true);
        cbRole.setEnabled(true);

        enableBtn(true, false, false);

        btnBuscarUsuario.setEnabled(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnInserirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirFotoActionPerformed

        ImageIcon conteudo = null;
        String caminho = null;
        JFileChooser jFileChooser = new JFileChooser();

        int ok = jFileChooser.showOpenDialog(null);
        if (ok == JFileChooser.APPROVE_OPTION) {

            caminho = jFileChooser.getCurrentDirectory().getPath() + "\\" + jFileChooser.getSelectedFile().getName(); // caminho do arquivo

            conteudo = new ImageIcon(caminho);

            jlFoto.setIcon(conteudo);
            jLabelCaminho.setText(caminho);

        } else {
            jFileChooser.cancelSelection();
        }


    }//GEN-LAST:event_btnInserirFotoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        UsuarioController usrCont = new UsuarioController();
        enableBtn(true, true, true);
        cleanInputs();
        enableCbs(false, false);
        enableInputs(false, false, false, false);
        this.btnInserirFoto.setEnabled(false);

        txtId.setText(String.valueOf(usrCont.getNextId()));
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cleanInputs() {
        txtId.setText("");
        txtNome.setText("");
        txtSenha.setText("");
        txtUsuario.setText("");
        cbCargo.setSelectedIndex(0);
        cbRole.setSelectedIndex(0);

    }

    private void enableInputs(boolean txtId, boolean txtNome, boolean txtSenha, boolean txtUsuario) {
        this.txtId.setEnabled(txtId);
        this.txtNome.setEnabled(txtNome);
        this.txtSenha.setEnabled(txtSenha);
        this.txtUsuario.setEnabled(txtUsuario);
    }

    private void enableCbs(boolean cbCargo, boolean cbRole) {
        this.cbCargo.setEnabled(cbCargo);
        this.cbRole.setEnabled(cbRole);
    }

    private void enableBtn(boolean btnAlterar, boolean btnCadastrar, boolean btnExcluir) {
        this.btnAlterar.setEnabled(btnAlterar);
        this.btnCadastrar.setEnabled(btnCadastrar);
        this.btnExcluir.setEnabled(btnExcluir);
    }

    private boolean verificaObjeto(UsuarioVO usr) {
        if (usr.getNome().isEmpty() || usr.getNome() == null) {
            return false;
        } else if (usr.getCargo() < 0) {
            return false;
        } else if (usr.getId_role() < 0) {
            return false;
        } else if (usr.getSenha().isEmpty() || usr.getSenha() == null) {
            return false;
        } else if (usr.getUsername().isEmpty() || usr.getUsername() == null) {
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
            java.util.logging.Logger.getLogger(jdCadastraUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdCadastraUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdCadastraUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdCadastraUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdCadastraUsuario dialog = new jdCadastraUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserirFoto;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jLabelCaminho;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
