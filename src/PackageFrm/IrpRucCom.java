/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageFrm;

import Conexion.Conexion;
import Conexion.ConexionDes;
import Conexion.ConexionOri;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADRIAN
 */
public class IrpRucCom extends javax.swing.JInternalFrame {

    /**
     * Creates new form IrpRucCom
     */
    public IrpRucCom() {
        initComponents();
    }
    String Proceso = "";
    int selectcount = 0;
    int setRowCount = 0;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setClosable(true);

        jButton1.setText("(Paso 1) Actualizar Facturas RucCom (IRP)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Proceso"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("(Paso 2) Actualizar Tilde (No Enviar)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Migrar Ganancia Capital");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Migrar Pagos y Cuotas (Sistema Expert)");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Actualizar No Enviar (No IRP)");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void CargarGrid(){
        JTable table = null;
        JScrollPane ScrollPane;
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        if(setRowCount==0){
           modelo.setRowCount(0);
        }
        try {
             Vector v = new Vector();
             v.add(Proceso);
             modelo.addRow(v);
             jTable1.setModel(modelo);
             ScrollPane = new JScrollPane(table);
             jTable1.add(ScrollPane,BorderLayout.CENTER); 
             setRowCount++;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error"+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Proceso = "Actualizacion de ComIrp Realizada Con Exito";   
        try {
                Connection con = ConexionDes.GetConnection();
                PreparedStatement psql=con.prepareStatement("DELETE FROM "+Conexion.conexiondesvar+".dbo.COMIRP\n" +
                "Insert Into "+Conexion.conexiondesvar+".dbo.COMIRP (ComIrpId, ComIrpRucComId, ComIrpImpGas, ComIrpImpInv, ComIrpRub, ComIrpIn, ComIrpRucComTot, ComIrpTip, ComIrpEmp, ComIrpCod, ComIrpEst, ComIrpEstMig, ComIrpImpInv2, ComIrpIncV3B, ComIrpRubV3B, ComIrpIncV3, ComIrpRubV3, ComIrpIncV2, ComIrpRubV2, ComIrpMar, ComIrpCanCuoPag, ComIrpImp515, ComIrpRub515)\n" +
                "select GenRanDId as ComIrpId, GenRanId as ComIrpRucComId, Case GenranDetInv When 1 Then GenRanDetGasto Else 0 End as ComIrpImpGas,\n" +
                "Case GenranDetInv When 0 Then GenRanDetGasto Else 0 End as ComIrpImpInv,\n" +
                "Case\n" +
                " When GenRanDiTemG3 <> 0 or GenRanDiTemG2 <> 0 Then \n" +
                "     Case \n" +
                "        When GenranDitemI = 0 Then\n" +
                "           1\n" +
                "         Else \n" +
                "           3\n" +
                "     End\n" +
                " Else\n" +
                "     Case \n" +
                "        When GenranDitemI = 0 Then\n" +
                "           1\n" +
                "         Else \n" +
                "           2\n" +
                "     End     \n" +
                "End as ComIrpRub,\n" +
                "Case \n" +
                " When GenRanDiTemG3 <> 0 Then GenRanDiTemG3\n" +
                " When GenRanDiTemG2 <> 0 Then GenRanDiTemG2\n" +
                "  Else\n" +
                "   GenRanDiTemG\n" +
                " End as ComIrpIn,\n" +
                " 0 as ComIrpRucComTot,\n" +
                " 0 as ComIrpTip,\n" +
                " GenRanEmp as ComIrpEmp,\n" +
                " 0 as ComIrpCod,\n" +
                " 0 as ComIrpEst,\n" +
                " 0 as ComIrpestMig,\n" +
                " Case \n" +
                "  When GenranDitemI = 2 Then GenRanDetGasto\n" +
                " Else\n" +
                "  0\n" +
                "End as ComIrpImpInv2,\n" +
                "Case \n" +
                " When GenRanDiTemG3 <> 0 Then GenRanDiTemG3\n" +
                " When GenRanDiTemG2 <> 0 Then 0\n" +
                "  Else\n" +
                "   0\n" +
                "End as ComIrpIncV3B,\n" +
                "Case \n" +
                " When GenRanDiTemG3 <> 0 Then\n" +
                "  Case GenranDitemI When 0 Then 1 Else 3 End \n" +
                " Else \n" +
                "  0\n" +
                "End as ComIrpRubV3B,\n" +
                "Case \n" +
                " When GenRanDiTemG3 <> 0 Then 0\n" +
                " When GenRanDiTemG2 <> 0 Then GenRanDiTemG2\n" +
                "  Else\n" +
                "   0\n" +
                "End as ComIrpIncV3,\n" +
                "Case \n" +
                " When GenRanDiTemG2 <> 0 Then\n" +
                "  Case GenranDitemI When 0 Then 1 Else 3 End\n" +
                " Else \n" +
                "  0\n" +
                "End as ComIrpRubV3,\n" +
                "Case \n" +
                " When GenRanDiTemG3 <> 0 Then 0\n" +
                " When GenRanDiTemG2 <> 0 Then 0\n" +
                " Else \n" +
                "  GenRanDiTemG\n" +
                "End as ComIrpIncV2,\n" +
                "Case \n" +
                " When GenRanDiTemG <> 0 Then\n" +
                "  Case GenranDitemI When 0 Then 1 Else 2 End \n" +
                " Else\n" +
                " 0\n" +
                "End as ComIrpRubV2,\n" +
                "0 as ComIrpMar,\n" +
                "0 as ComIrpCanCuoPag, \n" +
                "GenRanF515Imp as ComIrpImp515, \n" +
                "GenRanF515Rub as ComIrpRub515 from "+Conexion.conexionorivar+".dbo.GENRANDET");
                psql.execute();
                psql.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error en COMIRP "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                Proceso = "Problemas en el Proceso. ComIrp Migracion no Realizada";
            }        
        CargarGrid();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Proceso = "Actualizar Tilde No Enviar Realizada Con Exito";
        selectcount = 0;
            try {
                Connection con = ConexionDes.GetConnection();
                PreparedStatement psql=con.prepareStatement("Update RC\n" +
                "Set RC.RucComNoEnv = GR.GenRanEst\n" +
                "From "+Conexion.conexiondesvar+".dbo.RUCCOM as RC\n" +
                "Inner Join "+Conexion.conexionorivar+".dbo.GENRAN as GR on GR.GenRanId = RC.RucComId And GR.GenRanEmp = RC.RucComEmp");
                psql.execute();
                psql.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error en RUCCOM "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                Proceso = "Problemas en el Proceso. Tilde No Enviar Actualizacion no Realizada";
            }
        CargarGrid();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Proceso = "Migracion de GASCOS Realizada Con Exito";
        selectcount = 0;
            try {
                Connection con = ConexionDes.GetConnection();
                PreparedStatement psql=con.prepareStatement("DELETE FROM "+Conexion.conexiondesvar+".dbo.GASCOS SET IDENTITY_INSERT "+Conexion.conexiondesvar+".dbo.GASCOS ON\n" +
                "INSERT INTO "+Conexion.conexiondesvar+".dbo.GASCOS (GasCosId, GasCosEmp, GasCosVen, GasCosItem, GasCosCom)\n" +
                "select GasCosId, GasCosEmp, GasCosVen, GasCosItem, GasCosCom from "+Conexion.conexionorivar+".dbo.GASCOS\n" +
                "SET IDENTITY_INSERT "+Conexion.conexiondesvar+".dbo.GASCOS  OFF");
                psql.execute();
                psql.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error en GASCOS "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                Proceso = "Problemas en el Proceso. Actualizacion Ganancia de Capital no Realizada";
            }
        CargarGrid();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Proceso = "Migrar Pagos y Cuotas Sistema Expert Realizado Con Exito";
        selectcount = 0;
            try {
                Connection con = ConexionDes.GetConnection();
                PreparedStatement psql=con.prepareStatement("DELETE FROM "+Conexion.conexiondesvar+".[dbo].[CANCUO]\n" +
                "INSERT INTO "+Conexion.conexiondesvar+".[dbo].[CANCUO]\n" +
                "([CanCuoId],[CanCuoEmp],[PrvId],[PrvEmp],[SucId],[SucEmp]\n" +
                ",[CanCuoMon],[CanCuoNroRec],[CanCuoNroChq],[CanCuoNroChqME],[CanCuoRucComId],[CanCuoCen]\n" +
                ",[CanCuoNroFac],[CanCuoFecPag],[CanCuoFecVen],[CanCuoUsr],[BanId],[BanEmp]\n" +
                ",[CanCuoBen],[CanCuoCam],[CanCuoImp],[CanCuoTotFac],[CanCuoAnt],[CanCuoNotCre]\n" +
                ",[CanCuoNet],[CanCuoRetIva],[CanCuoRetRen],[CanCuoRetLey],[CanCuoCon],[CanCuoNroCtr]\n" +
                ",[CanCuoNroFacRet],[CanCuoImpEfe],[CanCuoImpCuo],[CanCuoEntrega],[CanCuoRetIvaMe],[CanCuoRetIva5Me]\n" +
                ",[CanCuoRetRenMe],[CanCuoRetLeyMe],[CanCuoNoRecibo],[CanCuoNroOpId],[CanCuoNroChq3ME],[CanCuoNroChq3]\n" +
                ",[CanCuoNroTimRet],[CANCUORETRENCON],[CANCUORETIVACON],[CanCuoRetIva05Me],[CanCuoRetIva05],[CanCuoEstMig]\n" +
                ",[CanCuoRetTC],[CanCuoGasBanMe],[CanCuoGasBan],[CanCuoNroTranf],[CanCuoBanId],[CanCuoTransfMe]\n" +
                ",[CanCuoTransf])\n" +
                "SELECT\n" +
                "cast(SubString(convert(varchar,convert(decimal(10,0),ReciboComNro)),1,7) +''+ SubString(convert(varchar,convert(decimal(10,0),RucComId)),1,1) as INT), ReciboComEmp, PrvId, PrvEmp, SucId, SucEmp\n" +
                ", Case When ReciboComMon = '' Then 'LOCAL' Else ReciboComMon End as ReciboComMon, SubString(convert(varchar,convert(decimal(10,0),ReciboComNro)),1,7), 0, 0, RucComId, RucComCen\n" +
                ", 0, ReciboComFec, 0, ReciboComUsr, '', ''\n" +
                ", '', ReciboComCam, ReciboComImpMe, ReciboComImp, 0, 0\n" +
                ", ReciboComImp, 0, 0, 0, ReciboComObs, 0\n" +
                ", '', ReciboComImp, ReciboComImp, '', 0, 0\n" +
                ", 0, 0, SubString(convert(varchar,convert(decimal(10,0),ReciboComNro)),1,7), 0, 0, 0\n" +
                ", 0, '','', 0, 0, 0\n" +
                ", 0, 0, 0, 0,'', 0\n" +
                ",0\n" +
                "FROM "+Conexion.conexionorivar+".[dbo].[RECIBOCOM] as REC\n" +
                "INNER JOIN "+Conexion.conexionorivar+".[dbo].[RUCCOM] as RUC ON RUC.RucComId = REC.ReciboComRucComId And RUC.RucComEmp = REC.ReciboComEmp\n" +
                
                "DELETE FROM "+Conexion.conexiondesvar+".[dbo].[GENAUX]\n" +
                "INSERT INTO "+Conexion.conexiondesvar+".[dbo].[GENAUX]\n" +
                "([GenAuxSuc],[GenAuxCen],[GenAuxCta],[GenAuxFec],[GenAuxDeb],[GenAuxHab]\n" +
                ",[GenAuxCam],[GenAuxImp],[GenAuxiliar],[GenAuxDet],[GenAuxFecVen],[GenAuxPrv]\n" +
                ",[GenAuxEstRet],[GenAuxCuotaId],[GenAuxNegId],[GenAuxCmpRet],[GenAuxNroIden],[GenAuxNroLin])\n" +
                "SELECT \n" +
                "RucComTipCmp, '1/1', ReciboComEmp, RucComFec, RucComTot, ReciboComImp, ReciboComCam, RucComTot-ReciboComImp, cast(SubString(convert(varchar,convert(decimal(10,0),ReciboComNro)),1,7) +''+ SubString(convert(varchar,convert(decimal(10,0),RucComId)),1,1) as INT)\n" +
                ", RucComNoFac, RucComFec, PrvId, 0, 0, 0, 0, 0,0\n" +
                "FROM "+Conexion.conexionorivar+".[dbo].[RECIBOCOM] as REC\n" +
                "INNER JOIN "+Conexion.conexionorivar+".[dbo].[RUCCOM] as RUC ON RUC.RucComId = REC.ReciboComRucComId And RUC.RucComEmp = REC.ReciboComEmp\n" +
                
                "DELETE FROM "+Conexion.conexiondesvar+".[dbo].[CANCUOPAG]\n" +
                "INSERT INTO "+Conexion.conexiondesvar+".[dbo].[CANCUOPAG]\n" +
                "([SucId],[SucEmp],[PrvId],[ComCuoPagUltNro],[ComCuoPagRucId],[ComCuoPagUsr]\n" +
                ",[ComCuoPagEmp],[ComCuoPagAntId],[ComCuoPagNroAnt],[ComCuoPagNroCan],[CenId],[CenEmp]\n" +
                ",[PrvEmp],[ComCuoPagNroOP],[ComCuoPagIdRecha],[ComCuoPagDesId],[ComCuoPagRenId],[ComCuoPagNcImpMe]\n" +
                ",[ComCuoPagNcImp],[ComCuoPagNcRucId],[ComCuoEstMig])\n" +
                "SELECT \n" +
                "SucId, SucEmp, PrvId, 1, RucComId, RucComUsr\n" +
                ", RucComEmp, 0, 0, 0, RucComCen, RucComEmp\n" +
                ", PrvEmp, 0, 0, 0, 0, 0\n" +
                ", 0, 0, 0 \n" +
                "FROM "+Conexion.conexionorivar+".[dbo].[RUCCOM]\n" +
                "WHERE RucComFmaPgo = 2\n" +
                
                "DELETE FROM "+Conexion.conexiondesvar+".[dbo].[CANCUOPAGLEVEL1]\n" +
                "INSERT INTO "+Conexion.conexiondesvar+".[dbo].[CANCUOPAGLEVEL1]\n" +
                "([ComCuoPagId],[ComCuoPagNroLin],[ComCuoPagCon],[ComCuoPagRetLey],[ComCuoPagRetRen],[ComCuoPagRetIva]\n" +
                ",[ComCuoPagSalCuo],[ComCuoPagSal],[ComCuoPagImp],[ComCuoPagTipFac],[ComCuoPag2],[ComCuoPag1]         \n" +
                ",[ComCuoPagMon],[ComCuoPagCmp],[ComCuoPagVen],[ComCuoPagFacFec],[ComCuoPagMar],[ComCuoPagCam]        \n" +
                ",[ComCuoPagImpMe],[ComCuoPagNroCanc],[ComCuoPagAju],[ComCuoPagEstRet],[ComCuoPagRetML],[ComCuoPagRetME]\n" +
                ",[ComCuoPagIva],[ComCuoPagIva05],[ComCuoPagNroOPDet],[ComCuoPagEstOP],[ComCuoPagMarOP],[ComCuoPagIvaME]\n" +
                ",[ComCuoPagIva05ME],[ComCuoPagSalImpMe],[ComCuoPagAutorizar],[ComCuoPagOri],[CanCuoEntrega],[ComCuoPagGra05Me]\n" +
                ",[ComCuoPagGra10Me],[ComCuoPagCobFac],[ComCuoPagRetRencon],[ComCuoPagRetIvacon],[ComCuoPagNroTim],[ComCuoPagGra05]\n" +
                ",[ComCuoPagGra10],[ComCuoPagExe],[ComCuoPagExeMe],[ComCuoPagIrpGDC])\n" +
                "SELECT \n" +
                "CCP.ComCuoPagId, 1, '', 0, 0, 0\n" +
                ", RucComTot, RucComTot, RucComTot, RucComTipCmp, 1, 1 \n" +
                ", RucComMon, substring(RucComNoFac,1,15), RucComFec, RucComFec, 0, RucComCam\n" +
                ", RucComImp, 0, 0, 0, 0, 0\n" +
                ", 0, 0, 0, 0, 0, 0\n" +
                ", 0, 0, 0, '', '', 0\n" +
                ", 0, 0, '', '', 0, 0\n" +
                ", 0, 0, 0, 0\n" +
                "FROM "+Conexion.conexionorivar+".[dbo].[RUCCOM] as RC\n" +
                "INNER JOIN "+Conexion.conexiondesvar+".[dbo].[CANCUOPAG] As CCP On CCP.ComCuoPagRucId = RC.RucComId And CCP.ComCuoPagEmp = RC.RucComEmp\n" +
                
                "Update GA\n" +
                "Set GA.GenAuxCuotaId = CP.ComCuoPagId\n" +
                "From GENAUX As GA\n" +
                "Inner Join CANCUOPAGLEVEL1 As CPDet On GA.GenAuxDet = CPDet.ComCuoPagCmp And GA.GenAuxSuc = CPDet.ComCuoPagTipFac\n" +
                "Inner join CANCUOPAG As CP On CPDet.ComCuoPagId = CP.ComCuoPagId And CP.SucEmp = GA.GenAuxCta\n" +
                
                "Update CCPL1\n" +
                "Set CCPL1.ComCuoPagSal = CCPL1.ComCuoPagSal - GAC.GenAuxHab, CCPL1.ComCuoPagMar = 1\n" +
                "From CANCUOPAGLEVEL1 as CCPL1\n" +
                "INNER JOIN GENAUX as GAC On GAC.GenAuxDet = CCPL1.ComCuoPagCmp\n" +
                "INNER JOIN CANCUOPAG as CCP On CCP.ComCuoPagId = CCPL1.ComCuoPagId And GAC.GenAuxCta = CCP.ComCuoPagEmp");
                psql.execute();
                psql.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error en GASCOS "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                Proceso = "Problemas en el Proceso. Migrar Pagos y Cuotas Sistema Expert no Realizada";
            }
        CargarGrid();        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Proceso = "Actualizar No Enviar (No IRP) Realizado Con Exito";
        selectcount = 0;
            try {
                Connection con = ConexionDes.GetConnection();
                PreparedStatement psql=con.prepareStatement("UPDATE RC \n" +
                "set RC.RucComNoEnv = RCO.RucComEst \n" +
                "FROM "+Conexion.conexiondesvar+".dbo.RUCCOM as RC \n" +
                "INNER JOIN "+Conexion.conexionorivar+".DBO.RUCCOM AS RCO ON RC.RucComId = RCO.RucComId AND RC.RucComEmp = RCO.RucComEmp");
                psql.execute();
                psql.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error en GASCOS "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                Proceso = "Problemas en el Proceso. \"Actualizar No Enviar (No IRP) no Realizada";
            }
        CargarGrid();        
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
