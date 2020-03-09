package controle;

import enums.StatusFilosofo;
import java.awt.Color;
import java.awt.Container;

public class JFilosofo extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFilosofo() {
        initComponents();
    }

    public void setNomeFilofoso(String nome) {
        lblNomeFilosofo.setText(nome);
    }

    public void setStatusFilosofo(StatusFilosofo statusFilosofo) {
        lblStatusFilosofo.setText(statusFilosofo.toString());

        Container parent = getParent();
        if (parent == null) {
            return;
        }
        switch (statusFilosofo) {
            case Comendo:
                parent.setBackground(Color.blue);
                setBackground(Color.blue);
                lblNomeFilosofo.setForeground(Color.white);
                lblStatusFilosofo.setForeground(Color.white);
                break;

            case Pensando:
                parent.setBackground(Color.white);
                setBackground(Color.white);
                lblNomeFilosofo.setForeground(Color.black);
                lblStatusFilosofo.setForeground(Color.black);
                break;

            case ComFome:
                parent.setBackground(Color.red);
                setBackground(Color.red);
                break;
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeFilosofo = new javax.swing.JLabel();
        lblStatusFilosofo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(null);
        setMinimumSize(null);

        lblNomeFilosofo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblNomeFilosofo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeFilosofo.setText("Nome do filósofo");

        lblStatusFilosofo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblStatusFilosofo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatusFilosofo.setText("Status do filósofo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeFilosofo, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(lblStatusFilosofo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeFilosofo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatusFilosofo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblNomeFilosofo;
    private javax.swing.JLabel lblStatusFilosofo;
    // End of variables declaration//GEN-END:variables

}
