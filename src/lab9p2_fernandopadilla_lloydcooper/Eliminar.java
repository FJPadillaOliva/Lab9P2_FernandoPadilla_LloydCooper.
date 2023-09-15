package lab9p2_fernandopadilla_lloydcooper;

import java.sql.SQLException;

public class Eliminar {
   private int Id;

    public Eliminar(int Id) {
        this.Id = Id;
        delete();
    }
   
   private void delete(){
       Dba db = new Dba("./TenRecord.accdb");
        db.conectar();
        try {
            db.query.execute("delete from TenRecord where Id = " + Id);
            db.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
    } 
}
