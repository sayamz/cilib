/*
 * Copyright (C) 2003 - 2008
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package net.sourceforge.cilib.simulator;

import java.text.NumberFormat;

/**
 *
 * @author  Edwin Peer
 */
class ProgressFrame extends javax.swing.JFrame implements ProgressListener {
    
    private static final long serialVersionUID = 4007873302370282732L;
    
	/** Creates new form ProgressFrame. */
    public ProgressFrame(int simulations) {
        initComponents();
        jProgressBar1.setMinimum(0);
        jProgressBar1.setMaximum(100);
        jProgressBar1.setStringPainted(true);
        jProgressBar2.setMinimum(0);
        jProgressBar2.setMaximum(simulations);
        jProgressBar2.setStringPainted(true);
        nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(1);
        nf.setMaximumFractionDigits(1);
        this.simulations = simulations;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();

        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        setTitle("Simulation Progress");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Current Simulation:");
        getContentPane().add(jLabel1);

        getContentPane().add(jProgressBar1);

        jLabel2.setText("All Simulations:");
        getContentPane().add(jLabel2);

        getContentPane().add(jProgressBar2);

        setBounds(0, 0, 165, 130);
    }//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing
    
    
    public void handleProgressEvent(ProgressEvent event) {
        double percentage = 100 * event.getPercentage();
        jProgressBar1.setValue((int) percentage);
        jProgressBar1.setString(nf.format(percentage) + "%");
    }    

    public void setSimulation(int simulation) {
        jProgressBar2.setValue(simulation);
        jProgressBar2.setString(String.valueOf(simulation) + "/" + String.valueOf(simulations));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
    
    private NumberFormat nf;
    private int simulations;
}
