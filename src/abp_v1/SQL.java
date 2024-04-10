package abp_v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SQL {

    Connection con;

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/p_gra_3c", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void reg(String user, String contra, String grado, NewUser n) throws SQLException {
        conectar();
        try {
            PreparedStatement reg;
            reg = con.prepareStatement("INSERT INTO Usuario(Usuario,Contraseña,Grado) VALUES(?,?,?)");
            reg.setString(1, user);
            reg.setString(2, contra);
            reg.setString(3, grado);
            reg.executeUpdate();
            Ventana men = new Ventana();
            men.setVisible(true);
            JOptionPane.showMessageDialog(null, "Exito en la Alta de:\n¡Bienvenido " + user + "!");
            n.dispose();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "Usuario Ya Registrado");
            }
        }
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveElip(String user, String fecha, String hora, int centroX, int centroY, int finX, int finY) {
        conectar();
        try {
            PreparedStatement save = con.prepareStatement("INSERT INTO Elipse(Usuario,Fecha,Hora,PuntoIX,PuntoIY,PuntoFX,PuntoFY) values(?,?,?,?,?,?,?)");
            save.setString(1, user);
            save.setString(2, fecha);
            save.setString(3, hora);
            save.setInt(4, centroX);
            save.setInt(5, centroY);
            save.setInt(6, finX);
            save.setInt(7, finY);
            save.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveCir(String user, String fecha, String hora, int centrox, int centroy, int tanX, int tanY) {
        conectar();
        try {
            PreparedStatement save = con.prepareStatement("insert into Circunferencia(IDC,Usuario,Fecha,Hora,CentroX,CentroY,PuntoTanX,PuntoTanY) values (default,?,?,?,?,?,?,?)");
            save.setString(1, user);
            save.setString(2, fecha);
            save.setString(3, hora);
            save.setInt(4, centrox);
            save.setInt(5, centroy);
            save.setInt(6, tanX);
            save.setInt(7, tanY);
            save.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void savePara(String user, String fech, String hor, int vertx, int verty, int focox, int focoy) {
        conectar();
        try {
            PreparedStatement save = con.prepareStatement("insert into Parabola(IDP,Usuario,Fecha,Hora,VerticeX,VerticeY,FocoX,FocoY) values (default,?,?,?,?,?,?,?)");
            save.setString(1, user);
            save.setString(2, fech);
            save.setString(3, hor);
            save.setInt(4, vertx);
            save.setInt(5, verty);
            save.setInt(6, focox);
            save.setInt(7, focoy);
            save.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveHiper(String user, String fech, String hor, int vertx, int verty, int foco1x, int foco1y) {
        conectar();
        try {
            PreparedStatement save = con.prepareStatement("insert into Hiperbola(IDH,Usuario,Fecha,Hora,VerticeX,VerticeY,Foco1X,Foco1Y) values (default,?,?,?,?,?,?,?)");
            save.setString(1, user);
            save.setString(2, fech);
            save.setString(3, hor);
            save.setInt(4, vertx);
            save.setInt(5, verty);
            save.setInt(6, foco1x);
            save.setInt(7, foco1y);
            save.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel showReg(String user, String tipo) {
        conectar();
        DefaultTableModel df = new DefaultTableModel();
        if ("Circunferencia".equals(tipo)) {
            df.addColumn("ID");
            df.addColumn("Usuario");
            df.addColumn("Fecha");
            df.addColumn("Hora");
            df.addColumn("Centro X");
            df.addColumn("Centro Y");
            df.addColumn("Punto Tan X");
            df.addColumn("Punto Tan Y");
            try {
                PreparedStatement show = con.prepareStatement("Select * from Circunferencia where Usuario=?");
                show.setString(1, user);
                ResultSet rs = show.executeQuery();
                while (rs.next()) {
                    String[] col = new String[10];
                    col[0] = Integer.toString(rs.getInt(1));
                    col[1] = rs.getString(2);
                    col[2] = rs.getString(3);
                    col[3] = rs.getString(4);
                    col[4] = Integer.toString(rs.getInt(5));
                    col[5] = Integer.toString(rs.getInt(6));
                    col[6] = Integer.toString(rs.getInt(7));
                    col[7] = Integer.toString(rs.getInt(8));
                    col[8] = rs.getString(9);
                    col[9] = rs.getString(10);
                    df.addRow(col);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if ("Elipse".equals(tipo)) {
                df.addColumn("ID");
                df.addColumn("Usuario");
                df.addColumn("Fecha");
                df.addColumn("Hora");
                df.addColumn("Centro X");
                df.addColumn("Centro Y");
                df.addColumn("Final X");
                df.addColumn("Final Y");
                try {
                    PreparedStatement show = con.prepareStatement("Select * from Elipse where Usuario=?");
                    show.setString(1, user);
                    ResultSet rs = show.executeQuery();
                    while (rs.next()) {
                        String[] col = new String[8];
                        col[0] = Integer.toString(rs.getInt(1));
                        col[1] = rs.getString(2);
                        col[2] = rs.getString(3);
                        col[3] = rs.getString(4);
                        col[4] = Integer.toString(rs.getInt(5));
                        col[5] = Integer.toString(rs.getInt(6));
                        col[6] = Integer.toString(rs.getInt(7));
                        col[7] = Integer.toString(rs.getInt(8));
                        df.addRow(col);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if ("Parabola".equals(tipo)) {
                    df.addColumn("ID");
                    df.addColumn("Usuario");
                    df.addColumn("Fecha");
                    df.addColumn("Hora");
                    df.addColumn("Vertice X");
                    df.addColumn("Vertice Y");
                    df.addColumn("Foco X");
                    df.addColumn("Foco Y");
                    try {
                    PreparedStatement show = con.prepareStatement("Select * from Parabola where Usuario=?");
                    show.setString(1, user);
                    ResultSet rs = show.executeQuery();
                    while (rs.next()) {
                        String[] col = new String[8];
                        col[0] = Integer.toString(rs.getInt(1));
                        col[1] = rs.getString(2);
                        col[2] = rs.getString(3);
                        col[3] = rs.getString(4);
                        col[4] = Integer.toString(rs.getInt(5));
                        col[5] = Integer.toString(rs.getInt(6));
                        col[6] = Integer.toString(rs.getInt(7));
                        col[7] = Integer.toString(rs.getInt(8));
                        df.addRow(col);
                    }
                    } catch (SQLException ex) {
                    Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
                }
                } else{
                    df.addColumn("ID");
                    df.addColumn("Usuario");
                    df.addColumn("Fecha");
                    df.addColumn("Hora");
                    df.addColumn("Vertice X");
                    df.addColumn("Vertice Y");
                    df.addColumn("Foco 1 X");
                    df.addColumn("Foco 1 Y");
                    try {
                    PreparedStatement show = con.prepareStatement("Select * from Hiperbola where Usuario=?");
                    show.setString(1, user);
                    ResultSet rs = show.executeQuery();
                    while (rs.next()) {
                        String[] col = new String[8];
                        col[0] = Integer.toString(rs.getInt(1));
                        col[1] = rs.getString(2);
                        col[2] = rs.getString(3);
                        col[3] = rs.getString(4);
                        col[4] = Integer.toString(rs.getInt(5));
                        col[5] = Integer.toString(rs.getInt(6));
                        col[6] = Integer.toString(rs.getInt(7));
                        col[7] = Integer.toString(rs.getInt(8));
                        df.addRow(col);
                    }
                    } catch (SQLException ex) {
                    Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        }
        return df;
    }

    public void login(String user, String contra, Popup p) throws SQLException {
        conectar();
        try {
            PreparedStatement check = con.prepareStatement("Select Usuario,Contraseña From Usuario WHERE Usuario=?");
            check.setString(1, user);
            ResultSet resultado = check.executeQuery();
            if (resultado.next()) {
                if (resultado.getString("Usuario").equals(user) && resultado.getString("Contraseña").equals(contra)) {
                    Ventana men = new Ventana();
                    men.getUserV(user);
                    men.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Bienvenido de Nuevo " + user);
                    p.dispose();
                } else {
                    if (resultado.getString("Usuario").equals(user)) {
                        JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Verifique la escritura del usuario");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El Usuario no esta registrado");
            }
        } catch (SQLException ex) {
            System.out.println("Error3: " + ex.toString());
        }
    }
}
