package forma;

import classes.TalheresSingleton;
import controle.JFilosofo;
import classes.Filosofo;
import enums.StatusFilosofo;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MesaDosFilosofos extends javax.swing.JFrame {


	private static final long serialVersionUID = 1L;
	private static final int QUANTIDADE_FILOSOFOS = 7;

    public MesaDosFilosofos() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        TalheresSingleton.getInstance(QUANTIDADE_FILOSOFOS);
        initFilosofosComponentes();
    }

    private void initFilosofosComponentes() {
        int quantidadeDeFilosofosCadaLadoDaMesa = (int) Math.round(QUANTIDADE_FILOSOFOS / 4d);
        int linhas = quantidadeDeFilosofosCadaLadoDaMesa + 2;
        int colunas = (quantidadeDeFilosofosCadaLadoDaMesa * 4) < QUANTIDADE_FILOSOFOS ? linhas + 1 : linhas;
        panelMesa.setLayout(new GridLayout(linhas, colunas));

        JPanel[][] jPanelsFilosofos = new JPanel[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                JPanel jPanel = new JPanel(new GridBagLayout());
                jPanel.setBackground(Color.white);
                jPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
                jPanelsFilosofos[i][j] = jPanel;
                panelMesa.add(jPanel);
            }
        }

        int numeroFilosofo = 0;
        int linha = 1;
        int coluna = colunas - 1;
        while (linha < linhas) {
            if (numeroFilosofo >= QUANTIDADE_FILOSOFOS) {
                break;
            }

            JPanel jPanel = jPanelsFilosofos[linha][coluna];

            JFilosofo jFilosofo = new JFilosofo();
            jFilosofo.setNomeFilofoso(String.format("Filosofo %s", ++numeroFilosofo));
            jPanel.add(jFilosofo);

            initFilosofoThread(jFilosofo, numeroFilosofo);

            // Preenchendo o lado direito da mesa
            if (coluna == colunas - 1) {
                if (linha < linhas - 2) {
                    linha++;
                } else {
                    coluna--;
                    linha++;
                }
            } // Preenchendo a parte de baixo da mesa.
            else if (linha == linhas - 1) {
                if (coluna == 1) {
                    linha--;
                    coluna--;
                } else {
                    coluna--;
                }
            } // Preenchendo o lado esquerdo da mesa.
            else if (coluna == 0) {
                if (linha == 1) {
                    linha--;
                    coluna++;
                } else {
                    linha--;
                }
            } // Preenchendo a parte de cima da mesa.
            else if (linha == 0) {
                coluna++;
            }
        }
    }

    private void initFilosofoThread(JFilosofo jFilosofo, int id) {
        Filosofo filosofo = new Filosofo(id, QUANTIDADE_FILOSOFOS, jFilosofo);
        filosofo.setStatusFilosofo(StatusFilosofo.Pensando);
        new Thread(filosofo).start();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMesa = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jantar do Filosofos");

        panelMesa.setBackground(new java.awt.Color(255, 255, 255));
        panelMesa.setMaximumSize(null);
        panelMesa.setMinimumSize(null);

        javax.swing.GroupLayout panelMesaLayout = new javax.swing.GroupLayout(panelMesa);
        panelMesa.setLayout(panelMesaLayout);
        panelMesaLayout.setHorizontalGroup(
            panelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );
        panelMesaLayout.setVerticalGroup(
            panelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MesaDosFilosofos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MesaDosFilosofos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MesaDosFilosofos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MesaDosFilosofos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MesaDosFilosofos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelMesa;
    // End of variables declaration//GEN-END:variables
}
