
import controle.SharedPEmpresa_Control;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;

import javax.swing.SwingUtilities;
import modelo.local.ConnectionF;
import modelo.local.SharedPreferencesEmpresaBEAN;
import net.sf.jasperreports.engine.JasperPrint;
import okhttp3.ResponseBody;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import sync.SyncDefault;
import util.GeradorRelatorio;
import util.SalvaDownload;
import visao.util.Carregamento;
import sync.LojaAPI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel
 */
public class FRMRelatorio extends javax.swing.JFrame {

    private Connection conexao;

    /**
     * Creates new form FRMRelatorio
     */
    public FRMRelatorio() {
        initComponents();
        this.conexao = ConnectionF.getConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jButton1)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButton1)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LojaAPI api = SyncDefault.RETROFIT_LOJA.create(LojaAPI.class);
        SharedPreferencesEmpresaBEAN sh = SharedPEmpresa_Control.listar();
        Carregamento a = new Carregamento(this, true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                a.setVisible(true);

            }
        });

        final Call<ResponseBody> call = api.geraRelatorioProduto(sh.getEmpEmail(), sh.getEmpSenha(), "3.0");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response.isSuccessful());
                System.out.println(response);
                if (response.isSuccessful()) {
                    String auth = response.headers().get("auth");
                    if (auth.equals("1")) {
                        String nome = response.headers().get("nome");
                        if (!nome.equals("0")) {
                            File arquivo = SalvaDownload.writeResponseBodyToDisk(response.body(), nome);
                                PDDocument documento = null;
                                SwingUtilities.invokeLater(new Runnable() {
                                    public void run() {
                                        a.setVisible(false);
                                    }
                                });
                                try {
                                    documento = PDDocument.load(arquivo);
                                    PrintService servico = PrintServiceLookup.lookupDefaultPrintService();
                                    PrinterJob job = PrinterJob.getPrinterJob();
                                    job.setPageable(new PDFPageable(documento));
                                    try {
                                        job.setPrintService(servico);
                                    } catch (PrinterException ex) {

                                    }

                                    job.print();
                                    documento.close();
                                } catch (IOException ex) {

                                } catch (PrinterException ex) {

                                }
                                System.out.println("file download was a success? " + arquivo);
                        } else {
                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {
                                    a.setVisible(false);

                                }
                            });
                            JOptionPane.showMessageDialog(null, "Houve algum erro no gerar arquivo!");
                        }
                    } else {
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                a.setVisible(false);

                            }
                        });
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
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("Login incorreto- erro");
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        a.setVisible(false);

                    }
                });
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FRMRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

}
