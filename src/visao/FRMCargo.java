/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import com.google.gson.Gson;
import controle.SharedP_Control;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.CargoBEAN;
import modelo.local.SharedPreferencesBEAN;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sync.SyncDefault;
import visao.util.Carregamento;
import sync.LojaAPI;

/**
 *
 * @author Daniel
 */
public class FRMCargo extends javax.swing.JFrame {

    private TableRowSorter<TableModel> tr;
    private DefaultTableModel dTable;

    private ArrayList<CargoBEAN> dados;

    /**
     * Creates new form FRMCargo
     */
    public FRMCargo() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        atualizaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnLocalizar1 = new javax.swing.JButton();
        btnLocalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaAtribuicao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaRequisitos = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaCargo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboPermicao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(140, 18, 30));
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(0, 153, 102));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 153, 102));

        btnAdicionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdicionar.setText("ADICIONAR");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarjButton6ActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarjButton7ActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirjButton8ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(" CARGOS");

        btnLocalizar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLocalizar1.setText("VOLTAR");
        btnLocalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizar1ActionPerformed(evt);
            }
        });

        btnLocalizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLocalizar.setText("LIMPAR CAMPOS");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLocalizar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLocalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnLocalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("*Nome:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("*Atribuições:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("*Requisitos:");

        jtaAtribuicao.setColumns(20);
        jtaAtribuicao.setRows(5);
        jScrollPane1.setViewportView(jtaAtribuicao);

        jtaRequisitos.setColumns(20);
        jtaRequisitos.setRows(5);
        jScrollPane2.setViewportView(jtaRequisitos);

        tabelaCargo.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCargoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaCargo);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("*Permição:");

        comboPermicao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboPermicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADM", "GERENTE", "GARCOM", "CAIXA" }));
        comboPermicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPermicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2))))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboPermicao, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(jLabel79)
                    .addContainerGap(1290, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboPermicao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(92, 92, 92)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addComponent(jLabel79)
                    .addContainerGap(511, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirjButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirjButton8ActionPerformed
        if (!jtfNome.getText().equals("")) {
            exluir(jtfNome.getText());

            jtfNome.setEditable(true);

        } else {
            JOptionPane.showMessageDialog(null, "Campo Nome VAZIO!!");
        }
    }//GEN-LAST:event_btnExcluirjButton8ActionPerformed

    private void btnEditarjButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarjButton7ActionPerformed
        String r = verificaCampos();
        if (r.equals("")) {
            CargoBEAN c = new CargoBEAN();
            c.setNome(jtfNome.getText());
            c.setAtribuicao(jtaAtribuicao.getText());
            c.setRequisito(jtaRequisitos.getText());
            c.setPermicao(comboPermicao.getSelectedItem() + "");
            editar(c);

            jtfNome.setEditable(true);

        } else {
            JOptionPane.showMessageDialog(null, r);
        }
    }//GEN-LAST:event_btnEditarjButton7ActionPerformed

    private void btnAdicionarjButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarjButton6ActionPerformed
        String r = verificaCampos();
        if (r.equals("")) {
            CargoBEAN c = new CargoBEAN();
            c.setNome(jtfNome.getText());
            c.setAtribuicao(jtaAtribuicao.getText());
            c.setRequisito(jtaRequisitos.getText());
            c.setPermicao(comboPermicao.getSelectedItem() + "");
            cadastrar(c);
            limpaCampos();

        } else {
            JOptionPane.showMessageDialog(null, r);
        }
    }//GEN-LAST:event_btnAdicionarjButton6ActionPerformed

    private void btnLocalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnLocalizar1ActionPerformed

    private void tabelaCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCargoMouseClicked
        int linha = tabelaCargo.getSelectedRow();
        prencheCampos(linha);
        jtfNome.setEditable(false);

    }//GEN-LAST:event_tabelaCargoMouseClicked

    private void comboPermicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPermicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPermicaoActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        limpaCampos();
        atualizaTabela();
    }//GEN-LAST:event_btnLocalizarActionPerformed

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
            java.util.logging.Logger.getLogger(FRMCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMCargo().setVisible(true);
            }
        });
    }

    private DefaultTableModel criaTabela() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false
            };
        ;

        };
        //retorna o DefaultTableModel
    return dTable;
    }

    private void preencheTabela(ArrayList<CargoBEAN> dados) {
        dTable = criaTabela();
        //seta o nome das colunas da tabela

        dTable.addColumn("Código");
        dTable.addColumn("Nome");
        dTable.addColumn("Atribuições");
        dTable.addColumn("Requisitos");
        dTable.addColumn("Permição");
        //pega os dados do ArrayList

        //cada célula do arrayList vira uma linha(row) na tabela
        for (CargoBEAN dado : dados) {
            dTable.addRow(new Object[]{dado.getCodigo(), dado.getNome(),
                dado.getAtribuicao(), dado.getRequisito(), dado.getPermicao()});
        }
        //set o modelo da tabela
        tabelaCargo.setModel(dTable);
        tr = new TableRowSorter<TableModel>(dTable);
        tabelaCargo.setRowSorter(tr);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnLocalizar1;
    private javax.swing.JComboBox<String> comboPermicao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaAtribuicao;
    private javax.swing.JTextArea jtaRequisitos;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTable tabelaCargo;
    // End of variables declaration//GEN-END:variables

    private String verificaCampos() {
        String retorno = "";
        if (jtfNome.getText().equals("")) {
            retorno = "Campo Nome";
        }
        if (jtaAtribuicao.getText().equals("")) {
            retorno += ", Abtribuição";
        }
        if (jtaRequisitos.getText().equals("")) {
            retorno += ", Requisitos";
        }

        if (!retorno.equals("")) {
            retorno += " se encontra(ão) 'vazio(s)', preencha-o(s) por gentileza!!";
        }
        return retorno;
    }

    private void atualizaTabela() {
        listarALL();

    }

    private void prencheCampos(int linha) {
        jtaAtribuicao.setText(tabelaCargo.getValueAt(linha, 2) + "");
        jtaRequisitos.setText(tabelaCargo.getValueAt(linha, 3) + "");
        jtfNome.setText(tabelaCargo.getValueAt(linha, 1) + "");
        comboPermicao.setSelectedItem(tabelaCargo.getValueAt(linha, 4) + "");

    }

    private void limpaCampos() {
        jtaAtribuicao.setText("");
        jtaRequisitos.setText("");
        jtfNome.setText("");
        comboPermicao.setSelectedIndex(0);
    }

    public void cadastrar(CargoBEAN car) {
        Carregamento a = new Carregamento(this, true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                a.setVisible(true);
            }
        });
        SharedPreferencesBEAN sh = SharedP_Control.listar();
        LojaAPI api = SyncDefault.RETROFIT_RESTAURANTE.create(LojaAPI.class);
        final Call<Void> call = api.insereCargo(new Gson().toJson(car), sh.getFunEmail(), sh.getFunSenha());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200) {
                    String auth = response.headers().get("auth");
                    if (auth.equals("1")) {
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                a.setVisible(false);
                                String sucesso = response.headers().get("sucesso");
                                JOptionPane.showMessageDialog(null, sucesso);
                                atualizaTabela();
                            }
                        });

                    }
                } else {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            a.setVisible(false);
                            String sucesso = response.headers().get("sucesso");
                            JOptionPane.showMessageDialog(null, sucesso);
                            atualizaTabela();
                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                //Servidor fora do ar
                System.out.println("Login incorreto");

            }
        });
    }

    public void editar(CargoBEAN car) {
        String cargo = new Gson().toJson(car);
        System.out.println(cargo);
        Carregamento a = new Carregamento(this, true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                a.setVisible(true);
            }
        });
        SharedPreferencesBEAN sh = SharedP_Control.listar();
        LojaAPI api = SyncDefault.RETROFIT_RESTAURANTE.create(LojaAPI.class);
        final Call<Void> call = api.atualizaCargo(cargo, sh.getFunEmail(), sh.getFunSenha());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200) {
                    String auth = response.headers().get("auth");
                    if (auth.equals("1")) {
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                a.setVisible(false);
                                String sucesso = response.headers().get("sucesso");
                                JOptionPane.showMessageDialog(null, sucesso);
                                atualizaTabela();
                            }
                        });

                    }
                } else {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            a.setVisible(false);
                            String sucesso = response.headers().get("sucesso");
                            JOptionPane.showMessageDialog(null, sucesso);
                        }
                    });

                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                //Servidor fora do ar
                System.out.println("erro");

            }
        });
    }

    public void exluir(String car) {
        Carregamento a = new Carregamento(this, true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                a.setVisible(true);
            }
        });
        SharedPreferencesBEAN sh = SharedP_Control.listar();
        LojaAPI api = SyncDefault.RETROFIT_RESTAURANTE.create(LojaAPI.class);
        final Call<Void> call = api.excluiCargo(car, sh.getFunEmail(), sh.getFunSenha());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200) {
                    String auth = response.headers().get("auth");
                    if (auth.equals("1")) {
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                a.setVisible(false);
                                String sucesso = response.headers().get("sucesso");
                                JOptionPane.showMessageDialog(null, sucesso);
                                atualizaTabela();
                            }
                        });

                    }
                } else {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            a.setVisible(false);
                            String sucesso = response.headers().get("sucesso");
                            JOptionPane.showMessageDialog(null, sucesso);

                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                //Servidor fora do ar

                System.out.println("Login incorreto");

            }
        });
    }

    private void listarALL() {
        Carregamento a = new Carregamento(this, true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                a.setVisible(true);
            }
        });
        SharedPreferencesBEAN sh = SharedP_Control.listar();
        LojaAPI api = SyncDefault.RETROFIT_RESTAURANTE.create(LojaAPI.class);
        System.out.println(sh.getFunEmail() + "/" + sh.getFunSenha());
        final Call<ArrayList<CargoBEAN>> call = api.listarCargos(sh.getFunEmail(), sh.getFunSenha());
        call.enqueue(new Callback<ArrayList<CargoBEAN>>() {
            @Override
            public void onResponse(Call<ArrayList<CargoBEAN>> call, Response<ArrayList<CargoBEAN>> response) {
                System.out.println(response.code());
                if (response.code() == 200) {
                    String auth = response.headers().get("auth");
                    if (auth.equals("1")) {
                        System.out.println("Login correto");
                        ArrayList<CargoBEAN> u = response.body();
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                a.setVisible(false);
                                preencheTabela(u);
                            }
                        });

                    } else {

                        System.out.println("Login incorreto");
                        // senha ou usuario incorreto

                    }
                } else {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            a.setVisible(false);

                        }
                    });

                    System.out.println("Login incorreto- fora do ar");
                    //servidor fora do ar
                }

            }

            @Override
            public void onFailure(Call<ArrayList<CargoBEAN>> call, Throwable t) {
                //Servidor fora do ar
                JOptionPane.showMessageDialog(null, "Login Incorreto erro");
                System.out.println("Login incorreto");

            }
        });

    }
}
