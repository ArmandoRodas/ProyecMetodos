
import javax.swing.table.DefaultTableModel;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;

public class RaicesMultiples extends javax.swing.JFrame {

    funcionderi fderivada = new funcionderi();
    DJep djep = new DJep();
    JEP j = new JEP();
    DefaultTableModel model = new DefaultTableModel();

    public RaicesMultiples() {
        initComponents();
    }

    private double respuesta;
    private String rderi;
    private String rdoblederi;

    int iterador = 1;
    double xr;
    double vxi;
    double funcionxi;
    double funcionderivada;
    double doblederivada;
    double errortole;

    //METODO QUE EVALUA LA FUNCION INGRESADA Y ENCUENTRA SU DERIVADA
    public void FDerivada() {
        Node nodofuncion;
        Node nododerivada;
        Node difNode;
        djep = new DJep();

        try {
            djep.addStandardFunctions();
            djep.addStandardConstants();
            //se adjuntan los numeros complejos
            djep.addComplex();
            //se permite el acceso de las variables no definidas
            djep.setAllowUndeclared(true);
            //se permite el acceso a las variables definidas
            djep.setAllowAssignment(true);
            //se declara las funciones que incorporan los signos matematicos para la evaluacion
            djep.setImplicitMul(true);
            //se declara los estandares de diferenciacion para derivadas mas avanzadas
            djep.addStandardDiffRules();

            //evalaucion y envio de la funcion ya derivada
            nodofuncion = djep.parse(fderivada.getFuncion());
            difNode = djep.differentiate(nodofuncion, "x");
            nododerivada = djep.simplify(difNode);

            fderivada.setFuncionderivada(djep.toString(nododerivada));

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    //METODO QUE DETERMINA LA FUNCION YA DERIVADA Y ENCUENTRA SU SEGUNDA DERIVADA
    public void FSegundaDerivada() {
        Node nodofuncion;
        Node nododerivada;
        Node difNode;
        djep = new DJep();

        try {
            djep.addStandardFunctions();
            djep.addStandardConstants();
            djep.addComplex();
            djep.setAllowUndeclared(true);
            djep.setAllowAssignment(true);
            djep.setImplicitMul(true);
            djep.addStandardDiffRules();

        nodofuncion = djep.parse(fderivada.getFuncionDderivada());
            difNode = djep.differentiate(nodofuncion, "x");
            nododerivada = djep.simplify(difNode);

            fderivada.setFuncionDderivada(djep.toString(nododerivada));

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    //METODO QUE EVALUA LA FUNCION ENVIADA Y EL PARAMETRO A ENCONTRAR
    public double f(double x) {
        j.addStandardFunctions();
        j.addStandardConstants();
        j.addVariable("x", x);
        j.parseExpression(fderivada.getFuncion());
        respuesta = j.getValue();

        return respuesta;
    }

    //METODO QUE EVALUA LA FUNCION DERIVADA Y EL PARAMETRO A ENCONTRAR
    public double fderivada(double x) {
        j.addStandardFunctions();
        j.addStandardConstants();
        j.addVariable("x", x);
        j.parseExpression(fderivada.getFuncionderivada());
        respuesta = j.getValue();

        return respuesta;
    }

    //METODO QUE EVALUA LA FUNCION CON SU SEGUNDA DERIVADA Y EL PARAMETRO A ENCONTRAR
    public double fSegundaderivada(double x) {
        j.addStandardFunctions();
        j.addStandardConstants();
        j.addVariable("x", x);
        j.parseExpression(fderivada.getFuncionDderivada());
        respuesta = j.getValue();

        return respuesta;
    }

    //METODO DONDE SE EVALUA LA LOGICA DEL METODO DE RAICES MULTIPLES O NEWTON MEJORADO
    public void evaluar() {
        
        vxi = fderivada.getXi();
        funcionxi = f(vxi);
        System.out.println(funcionxi);
        
        /*do {

            vxi = fderivada.getXi();

            funXi = f(Xi);
            funDeriXi = fderivada(Xi);
            funSegunDeriXi = fSegundaderivada(Xi);

            XiR = Xi - ((funXi * funDeriXi) / ((Math.pow(funDeriXi, 2)) - (funXi * funSegunDeriXi)));

            if (iterador == 1) {

            } else {
                ETolerancia = (Math.abs(Xi - XiR));
            }

            modelo = (DefaultTableModel) TablaRaicesMultiples.getModel();
            Object[] ob = new Object[7];
            ob[0] = iterador;
            ob[1] = String.format("%.4f", Xi);
            ob[2] = String.format("%.4f", funXi);
            ob[3] = String.format("%.4f", funDeriXi);
            ob[4] = String.format("%.4f", funSegunDeriXi);
            ob[5] = String.format("%.4f", XiR);
            ob[6] = String.format("%.4f", ETolerancia);
            modelo.addRow(ob);
            TablaRaicesMultiples.setModel(modelo);

            mrm.setXi(XiR);
            iterador++;

        } while (Math.abs(Xi - XiR) >= mrm.getETolerancia());*/
    }
    
    public void envio(){
        double xi = Double.parseDouble(VXI.getText());
        String f = funcion.getText();
        fderivada.setXi(xi);
        fderivada.setFuncion(f);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anterior = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        funcion = new javax.swing.JTextField();
        evaluar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        VXI = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtSderi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        anterior.setText("X");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        jLabel1.setText("  METODO NEWTON MEJORADO");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Ingresar Funcion :");

        evaluar.setText("Evaluar");
        evaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluarActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor de xi :");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "iterador", "xi", "f(xi)", "f´(xi)", "f´´(xi)", "xi+1", "Tolerancia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(funcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(VXI, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSderi, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(evaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(evaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(funcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VXI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSderi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        // TODO add your handling code here:
        Inicio i = new Inicio();
        i.setVisible(true);
        hide();
    }//GEN-LAST:event_anteriorActionPerformed

    private void evaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluarActionPerformed
        // TODO add your handling code here:
        evaluar();
        envio();
        
    }//GEN-LAST:event_evaluarActionPerformed

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
            java.util.logging.Logger.getLogger(RaicesMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RaicesMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RaicesMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RaicesMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RaicesMultiples().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField VXI;
    private javax.swing.JButton anterior;
    private javax.swing.JButton evaluar;
    private javax.swing.JTextField funcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtSderi;
    // End of variables declaration//GEN-END:variables
}
