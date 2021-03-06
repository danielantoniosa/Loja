/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.SharedPEmpresa_Control;
import controle.SharedP_Control;
import controleService.ControleLogin;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.CaixaBEAN;
import modelo.local.SharedPreferencesBEAN;
import modelo.local.SharedPreferencesEmpresaBEAN;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sync.SyncDefault;
import util.Time;
import visao.util.FRMConfiguracao;
import sync.LojaAPI;
import util.Criptografia;

/**
 *
 * @author Daniel
 */
public final class Splash extends javax.swing.JFrame {

    private ControleLogin c = new ControleLogin();

    /**
     * Creates new form Splash
     */
    public Splash() {
        initComponents();
        setLocationRelativeTo(null);
        onBackgroud();

    }

    private void onBackgroud() {
        Runnable r = new Runnable() {
            public void run() {
                SharedPreferencesEmpresaBEAN e = SharedPEmpresa_Control.listarLogin();
                if (e.getEmpCodigo() == 0) {
                    FRMLoginEmpresa le = new FRMLoginEmpresa();
                    le.setVisible(true);
                    finalizar();

                } else {
                    atualizarEmpresa(e.getEmpEmail(), e.getEmpSenha());
                    listarCaixa();
                }
            }

        };
        new Thread(r).start();

    }

    private void atualizarEmpresa(String email, String senha) {
        LojaAPI api = SyncDefault.RETROFIT_LOJA.create(LojaAPI.class);
        final Call<SharedPreferencesEmpresaBEAN> call = api.fazLoginEmpresa(email, Criptografia.criptografar(senha));
        SharedPreferencesEmpresaBEAN u = null;
        call.enqueue(new Callback<SharedPreferencesEmpresaBEAN>() {
            @Override
            public void onResponse(Call<SharedPreferencesEmpresaBEAN> call, Response<SharedPreferencesEmpresaBEAN> response) {

                System.out.println(response);
                if (response.isSuccessful()) {
                    String auth = response.headers().get("auth");
                    if (auth.equals("1")) {
                        System.out.println("Login correto");
                        SharedPreferencesEmpresaBEAN u = response.body();
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                if (u != null) {
                                    u.setEmpSenha(senha);
                                    c.logEmpresa(u);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Login Invalido");
                                }

                            }
                        });

                    } else {
                        JOptionPane.showMessageDialog(null, "Login Incorreto");
                        System.out.println("Login incorreto");
                        // senha ou usuario incorreto

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Servidor não responde!!");

                    //servidor fora do ar
                }

            }

            @Override
            public void onFailure(Call<SharedPreferencesEmpresaBEAN> call, Throwable t) {
                //Servidor fora do ar
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                               JOptionPane.showMessageDialog(null, " erro");

                            }
                        });

                System.out.println(t.getMessage());

            }
        });
    }

    public void listarCaixa() {
        CaixaBEAN c = null;
        String data = Time.getData();
        SharedPreferencesEmpresaBEAN sh = SharedPEmpresa_Control.listar();
        LojaAPI api = SyncDefault.RETROFIT_LOJA.create(LojaAPI.class);
        final Call<CaixaBEAN> call = api.listarCaixa(sh.getEmpEmail(), sh.getEmpSenha());
        call.enqueue(new Callback<CaixaBEAN>() {
            @Override
            public void onResponse(Call<CaixaBEAN> call, Response<CaixaBEAN> response) {
                System.out.println(response.isSuccessful());
                if (response.isSuccessful()) {
                    String auth = response.headers().get("auth");
                    if (auth.equals("1")) {
                        System.out.println("Login correto");
                        CaixaBEAN c = response.body();
                        if (c.getCodigo() > 0) {
                            if (c.getData().equals(data)) {
                            } else {
                                JOptionPane.showMessageDialog(null, "Data de abertura de caixa diferente da atual, favor fechar o caixa atual antes de usá-lo!!");
                            }
                        }
                        FRMLogin l = new FRMLogin();
                        l.setVisible(true);
                        dispose();

                    } else {
                        FRMLoginEmpresa le = new FRMLoginEmpresa();
                        le.setVisible(true);
                        dispose();
                        System.out.println("Login incorreto");
                        // senha ou usuario incorreto

                    }
                } else {
                    FRMLoginEmpresa le = new FRMLoginEmpresa();
                    le.setVisible(true);
                    dispose();
                    System.out.println("Login incorreto- fora do ar");
                    //servidor fora do ar
                }
            }

            @Override
            public void onFailure(Call<CaixaBEAN> call, Throwable t) {
                System.out.println(t.getMessage());
                FRMLogin l = new FRMLogin();
                l.setVisible(true);
                finalizar();
            }
        });
    }

    private void configurar() {
        FRMConfiguracao conf = new FRMConfiguracao();
        conf.setVisible(true);
        dispose();
    }

    private void finalizar() {
        this.setVisible(false);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logotipo4.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
