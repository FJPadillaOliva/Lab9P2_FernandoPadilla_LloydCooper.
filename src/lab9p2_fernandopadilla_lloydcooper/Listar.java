package lab9p2_fernandopadilla_lloydcooper;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextArea;

public class Listar {
    private JTextArea textArea;
    
    private void listOrders(JTextArea textArea){       
        Dba db = new Dba("./TenRecord.accdb");
        db.conectar();
        try {
            db.query.execute("select Order ID,Order Date,Ship Date,Ship Mode,Customer ID from TenRecord");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                textArea.append(rs.getString(1) + "\n" + rs.getString(2) + "\n" + rs.getString(3) + "\n" + rs.getString(4) + "\n" + rs.getString(5) + "\n\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
    }
    
    private void listDetails(JTextArea textArea){       
        Dba db = new Dba("./TenRecord.accdb");
        db.conectar();
        try {
            db.query.execute("select Order ID,Product ID,Sales,Quantity,Discount,Profit from TenRecord");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                textArea.append(rs.getString(1) + "\n" + rs.getString(2) + "\n" + rs.getString(3) + "\n" + rs.getString(4) + "\n" + rs.getString(5) + rs.getString(6) + "\n\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
    }
    
    private void listCustomers(JTextArea textArea){       
        Dba db = new Dba("./TenRecord.accdb");
        db.conectar();
        try {
            db.query.execute("select Customer ID,Customer Name,Segment,Country,City,State,Postal Code,Region from TenRecord");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                textArea.append(rs.getString(1) + "\n" + rs.getString(2) + "\n" + rs.getString(3) + "\n" + rs.getString(4) 
                                + "\n" + rs.getString(5) + rs.getString(6) + rs.getString(7) + rs.getString(8) + "\n\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
    }
    
    private void listProducts(JTextArea textArea){       
        Dba db = new Dba("./TenRecord.accdb");
        db.conectar();
        try {
            db.query.execute("select Product ID,Category,Sub-Category,Product Name from TenRecord");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                textArea.append(rs.getString(1) + "\n" + rs.getString(2) + "\n" + rs.getString(3) + "\n" + rs.getString(4) + "\n\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
    }
}
