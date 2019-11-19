/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Service.Controller.ClienteController;
import VOs.ClienteVO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author felli
 */
public class jdCadastraCliente extends javax.swing.JFrame {

    /**
     * Creates new form jdCadastraCliente
     */
    public jdCadastraCliente(java.awt.Frame parent, boolean modal) throws ParseException {
//        super(parent, modal);
        initComponents();
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(this.rbCNPJ);
        bgroup.add(this.rbCPF);
        final MaskFormatter CNPJMask;
        final MaskFormatter CPFMask;
        final JFormattedTextField fmtField = this.txtCpf;

        CNPJMask = new MaskFormatter("##.###.###/####-##");
        CPFMask = new MaskFormatter("###.###.###-##");

        fmtField.setValue(null);
        fmtField.setFormatterFactory(new DefaultFormatterFactory(CPFMask));

        rbCPF.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fmtField.setValue(null);
                    fmtField.setFormatterFactory(new DefaultFormatterFactory(CPFMask));
                }
            }
        });

        rbCNPJ.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fmtField.setValue(null);
                    fmtField.setFormatterFactory(new DefaultFormatterFactory(CNPJMask));
                }
            }
        });

        ClienteController clC = new ClienteController();
        txtId.setText(String.valueOf(clC.getNextId()));
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

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rbCPF = new javax.swing.JRadioButton();
        rbCNPJ = new javax.swing.JRadioButton();
        txtCpf = new javax.swing.JFormattedTextField();
        btnInserirFoto = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnBusca = new javax.swing.JButton();
        txtCaminho = new javax.swing.JTextField();
        jlFoto = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastra Cliente");
        setResizable(false);

        jLabel1.setText("Id");

        txtId.setEnabled(false);

        jLabel2.setText("Nome");

        txtNome.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Física/Jurídica"));

        rbCPF.setSelected(true);
        rbCPF.setText("CPF");

        rbCNPJ.setText("CNPJ");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(rbCPF)
                .addGap(18, 18, 18)
                .addComponent(rbCNPJ)
                .addGap(18, 18, 18)
                .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCPF)
                    .addComponent(rbCNPJ)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInserirFoto.setText("Inserir foto");
        btnInserirFoto.setEnabled(false);
        btnInserirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirFotoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Fechar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnBusca.setText("Busca cliente");
        btnBusca.setEnabled(false);
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        txtCaminho.setEnabled(false);
        txtCaminho.setMinimumSize(new java.awt.Dimension(108, 22));
        txtCaminho.setPreferredSize(new java.awt.Dimension(108, 22));

        jlFoto.setBorder(new javax.swing.border.MatteBorder(null));
        jlFoto.setMaximumSize(new java.awt.Dimension(108, 125));
        jlFoto.setMinimumSize(new java.awt.Dimension(108, 125));
        jlFoto.setPreferredSize(new java.awt.Dimension(108, 125));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInserirFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCaminho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnExcluir)
                                    .addComponent(btnConfirmar)
                                    .addComponent(btnCadastrar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnInserirFoto)
                            .addComponent(btnBusca)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        ClienteVO cl = new ClienteVO(txtNome.getText().trim(),
                txtCpf.getText().trim(),
                txtCaminho.getText().trim(),
                Integer.parseInt(txtId.getText().trim()));

        ClienteController clCont = new ClienteController();
        switch (mode) {
            case 0: //Insere
                if (verificaObjeto(cl)) {
                    clCont.insere(cl);
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha os campos em branco antes de continuar.");
                }
                break;
            case 1: //Exclui
                clCont.deletaPorId(Integer.parseInt(txtId.getText().trim()));
                JOptionPane.showMessageDialog(null, "Deletado com sucesso");
                break;
            case 2: //Alterar
                clCont.update(cl);
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        ClienteVO cl = new ClienteVO();
        
        jdConsultaCliente frConsulta = new jdConsultaCliente(this, rootPaneCheckingEnabled, cl);
        frConsulta.setModal(true);
        frConsulta.setLocationRelativeTo(this);
        frConsulta.setVisible(true);
        
        if (cl.getId() != 0) {
            txtId.setText(String.valueOf(cl.getId()));
            txtNome.setText(cl.getNome());
            txtCaminho.setText(cl.getFoto());
            if (cl.getCpfOuCnpj().length()>14){
                rbCNPJ.setSelected(true);
            }
            txtCpf.setText(cl.getCpfOuCnpj());

        }
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        mode = 0;
        txtNome.setEnabled(true);
        txtCpf.setEnabled(true);
        btnInserirFoto.setEnabled(true);
        btnBusca.setEnabled(false);

        enableBtn(false, true, false);

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        mode = 1;
        txtNome.setEnabled(false);
        txtCpf.setEnabled(false);
        btnInserirFoto.setEnabled(false);
        btnBusca.setEnabled(true);

        enableBtn(false, false, true);


    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        mode = 2;
        txtNome.setEnabled(true);
        txtCpf.setEnabled(true);
        btnInserirFoto.setEnabled(true);
        btnBusca.setEnabled(true);

        enableBtn(true, false, false);

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
            txtCaminho.setText(caminho);

        } else {
            jFileChooser.cancelSelection();
        }
    }//GEN-LAST:event_btnInserirFotoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        ClienteController clCont = new ClienteController();
        enableBtn(true, true, true);
        cleanInputs();
        enableInputs(false, false, false, false);
        this.btnInserirFoto.setEnabled(false);

        txtId.setText(String.valueOf(clCont.getNextId()));
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cleanInputs() {
        txtId.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        rbCPF.setSelected(true);
        rbCNPJ.setSelected(false);
    }

    private void enableInputs(boolean txtId, boolean txtNome, boolean txtSenha, boolean txtCpf) {
        this.txtId.setEnabled(txtId);
        this.txtNome.setEnabled(txtNome);
        this.txtCpf.setEnabled(txtCpf);

    }

    private void enableBtn(boolean btnAlterar, boolean btnCadastrar, boolean btnExcluir) {
        this.btnAlterar.setEnabled(btnAlterar);
        this.btnCadastrar.setEnabled(btnCadastrar);
        this.btnExcluir.setEnabled(btnExcluir);
    }

    private boolean verificaObjeto(ClienteVO cl) {
        if (cl.getNome().isEmpty() || cl.getNome() == null) {
            return false;
        } else if (cl.getCpfOuCnpj().isEmpty() || cl.getCpfOuCnpj() == null) {
            return false;
        } else if (cl.getFoto().isEmpty() || cl.getFoto() == null) {
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
            java.util.logging.Logger.getLogger(jdCadastraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdCadastraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdCadastraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdCadastraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    jdCadastraCliente dialog = new jdCadastraCliente(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(jdCadastraCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserirFoto;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JRadioButton rbCNPJ;
    private javax.swing.JRadioButton rbCPF;
    private javax.swing.JTextField txtCaminho;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
