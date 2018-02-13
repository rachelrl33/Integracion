package presentacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConexionAccess{
   private String NombreBD = "Coches.accdb";
   private String ConexionBD = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + this.NombreBD;
   private String SentenciaSQL;
   private Connection CanalBD;
   private Statement Instruccion;
   private ResultSet Resultado;

   public ConexionAccess(){
       try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           this.CanalBD = DriverManager.getConnection(this.ConexionBD);
           this.Instruccion = this.CanalBD.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
       }
       catch(SQLException SQLE)
       {
           JOptionPane.showMessageDialog(null,"ERROR EN LA CONEXION CON BD\nERROR : " + SQLE.getMessage());
       }
       catch(ClassNotFoundException CNFE)
       {
           JOptionPane.showMessageDialog(null,"ERROR DRIVER BD JAVA\nERROR : " + CNFE.getMessage());
       }
   }

   public void InsertInsertar(String SentenciaSQL){
       this.SentenciaSQL = SentenciaSQL;

       try
       {
           this.Instruccion.executeUpdate(this.SentenciaSQL);
           JOptionPane.showMessageDialog(null,"EL COCHE SE AGREGO CON EXITO A LA BD");
       }
       catch (SQLException SQLE)
       {
           JOptionPane.showMessageDialog(null,"ERROR AL INSERTAR EL COCHE A LA BD \n ERROR : " + SQLE.getMessage());
       }
   }

   public void UpdateModificar(String SentenciaSQL){
       this.SentenciaSQL = SentenciaSQL;

       try
       {
           this.Instruccion.executeUpdate(this.SentenciaSQL);
           JOptionPane.showMessageDialog(null,"EL COCHE SE MODIFICO CON EXITO A LA BD");
       }
       catch (SQLException SQLE)
       {
           JOptionPane.showMessageDialog(null,"ERROR AL MODIFICAR EL COCHE DE LA BD \n ERROR : " + SQLE.getMessage());
       }
   }

   public void DeleteEliminar(String SentenciaSQL){
       this.SentenciaSQL = SentenciaSQL;

       try
       {
           this.Instruccion.executeUpdate(this.SentenciaSQL);
           JOptionPane.showMessageDialog(null,"EL COCHE SE ELIMINO CON EXITO A LA BD");
       }
       catch (SQLException SQLE)
       {
           JOptionPane.showMessageDialog(null,"ERROR AL ELIMINAR EL COCHE DE LA BD \n ERROR : " + SQLE.getMessage());
       }
   }

   public DefaultTableModel SelectConsultar(String SentenciaSQL){

       this.SentenciaSQL = SentenciaSQL;

       String[] COCHES = {"Id", "Nombre", "Año", "Precio", "Color", "Cantidad"};
       String[] REGISTRO = new String[6];

       DefaultTableModel TABLA = new DefaultTableModel(null, COCHES);

       try
       {
           this.Resultado = Instruccion.executeQuery(this.SentenciaSQL);

           while(Resultado.next())
           {
               REGISTRO[0] = Resultado.getString("Id");
               REGISTRO[1] = Resultado.getString("Nombre");
               REGISTRO[2] = Resultado.getString("Año");
               REGISTRO[3] = Resultado.getString("Precio");
               REGISTRO[4] = Resultado.getString("Color");
               REGISTRO[5] = Resultado.getString("Cantidad");

               TABLA.addRow(REGISTRO);
           }
       }
       catch (SQLException SQLE)
       {
           JOptionPane.showMessageDialog(null,"ERROR AL CARGAR LOS DATOS DE LA BD \n ERROR : " + SQLE.getMessage());
       }

       return TABLA;
   }
}