package abp_v1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ventana extends javax.swing.JFrame {

    int cont = 0;
    Image icon;
    panel p;
    JButton Bcircu;
    SQL sql = new SQL();
    JButton Belipse;
    JButton Bhiper;
    JButton Bpara;
    JTextField jtf_xf;
    JLabel tan;
    JTextField jtf_yf;
    int radio;
    int cuerda;
    JLabel Emay;
    JLabel EMen;
    String User;
    int xa, ya;
    JLabel foco1;
    JLabel foco2;
    JTextField circux;
    JTextField circuy;
    JTextField radiotf;
    JLabel centro;
    JLabel cords;
    int focox, focoy;
    int m;
    panel P = new panel();
    double r;
    double vector[] = new double[5];
    int cox, coy;
    Point pointStart = null;
    Point pointEnd = null;

    public Ventana(String user) {
        this.User = user;
        initComponents();
    }

    public void getUserV(String u) {
        User = u;
        System.out.println(u);
    }

    public Ventana() {
        P = jp_Graficador;
        initComponents();
        circux = jtf_XCentroCircu;
        circuy = jtf_YCentroCircu;
        radiotf = jtf_Radio;
        Emay = jl_Emay;
        EMen = jl_EMen;
        foco1 = jl_Foco1;
        foco2 = jl_Foco2;
        centro = jl_CentroEli;
        cords = jl_CordM;
        Bpara = jb_Para;
        tan = jl_PuntoTan;
        Image ico = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.png"));
        setIconImage(ico);
        setLocationRelativeTo(null);
        rad.setVisible(false);
        jtf_Radio.setVisible(false);
        fo.setVisible(false);
        jtf_FocoXPara.setVisible(false);
        jtf_XCentroElip.setVisible(false);
        jtf_Ancho.setVisible(false);
        jtf_Alto.setVisible(false);
        jtf_XCentroCircu.setVisible(false);
        jtf_YCentroCircu.setVisible(false);
        jtf_YCentroElip.setVisible(false);

        jtf_FocoYPara.setVisible(false);
        anc.setVisible(false);
        al.setVisible(false);
        cen.setVisible(false);
        y.setVisible(false);
        x.setVisible(false);
        foc2.setVisible(false);
        cen2.setVisible(false);
        verticex.setVisible(false);
        verticey.setVisible(false);
        txtverticex.setVisible(false);
        txtverticey.setVisible(false);
        p = jp_Graficador;
        p.getV(this);
        Bcircu = jb_Circu;
        Belipse = jb_Elip;
        Bhiper = jb_Hiper;

    }

    public void getRa(String n, int rad) {
        radio = rad;
        jl_Radio.setText(n);
    }

    public void getCu(String n, int cuer) {
        cuerda = cuer;
        jl_Cuerda.setText(n);
    }

    public void getTan(String n) {
        jl_PuntoTan.setText(n);
    }

    public void deshabilitar() {
        if (cont == 1) {
            icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.png"));
            setIconImage(icon);
            jb_Circu.setEnabled(false);
            cir.setEnabled(false);
            jb_Elip.setEnabled(true);
            el.setEnabled(true);
            jb_Para.setEnabled(true);
            par.setEnabled(true);
            jb_Hiper.setEnabled(true);
            hi.setEnabled(true);
            jb_Calcu.setEnabled(true);
            rad.setVisible(true);
            jtf_Radio.setVisible(true);
            x.setVisible(true);
            y.setVisible(true);
            jtf_XCentroCircu.setVisible(true);
            jtf_YCentroCircu.setVisible(true);
            fo.setVisible(false);
            jtf_FocoXPara.setVisible(false);
            foc2.setVisible(false);
            jtf_FocoYPara.setVisible(false);

            anc.setVisible(false);
            al.setVisible(false);
            cen.setVisible(false);
            cen2.setVisible(false);
            verticex.setVisible(false);
            verticey.setVisible(false);
            txtverticex.setVisible(false);
            txtverticey.setVisible(false);
            jtf_XCentroElip.setVisible(false);
            jtf_Ancho.setVisible(false);
            jtf_Alto.setVisible(false);
            jtf_YCentroElip.setVisible(false);
        } else {
            if (cont == 2) {
                icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.png"));
                setIconImage(icon);
                jb_Para.setEnabled(false);
                par.setEnabled(false);
                jb_Elip.setEnabled(true);
                el.setEnabled(true);
                jb_Circu.setEnabled(true);
                cir.setEnabled(true);
                jb_Hiper.setEnabled(true);
                hi.setEnabled(true);
                jb_Calcu.setEnabled(true);
                fo.setVisible(true);
                jtf_FocoXPara.setVisible(true);
                foc2.setVisible(true);
                jtf_FocoYPara.setVisible(true);

                rad.setVisible(false);
                jtf_Radio.setVisible(false);
                x.setVisible(false);
                y.setVisible(false);
                verticex.setVisible(true);
                verticey.setVisible(true);
                txtverticex.setVisible(true);
                txtverticey.setVisible(true);
                jtf_XCentroCircu.setVisible(false);
                jtf_YCentroCircu.setVisible(false);
                anc.setVisible(false);
                al.setVisible(false);
                cen.setVisible(false);
                cen2.setVisible(false);
                jtf_XCentroElip.setVisible(false);
                jtf_Ancho.setVisible(false);
                jtf_Alto.setVisible(false);
                jtf_YCentroElip.setVisible(false);
            } else {
                if (cont == 3) {
                    icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.png"));
                    setIconImage(icon);
                    jb_Hiper.setEnabled(false);
                    hi.setEnabled(false);
                    jb_Elip.setEnabled(true);
                    el.setEnabled(true);
                    jb_Circu.setEnabled(true);
                    cir.setEnabled(true);
                    jb_Para.setEnabled(true);
                    par.setEnabled(true);
                    jb_Calcu.setEnabled(true);

                    verticex.setVisible(true);
                    verticey.setVisible(true);
                    txtverticex.setVisible(true);
                    txtverticey.setVisible(true);
                    anc.setVisible(false);
                    al.setVisible(false);
                    cen.setVisible(false);
                    cen2.setVisible(false);
                    jtf_XCentroElip.setVisible(false);
                    jtf_Ancho.setVisible(false);
                    jtf_Alto.setVisible(false);
                    jtf_YCentroElip.setVisible(false);
                    fo.setVisible(true);
                    jtf_FocoXPara.setVisible(true);
                    foc2.setVisible(true);
                    jtf_FocoYPara.setVisible(true);
                    rad.setVisible(false);
                    jtf_Radio.setVisible(false);
                    x.setVisible(false);
                    y.setVisible(false);
                    jtf_XCentroCircu.setVisible(false);
                    jtf_YCentroCircu.setVisible(false);
                } else {
                    if (cont == 4) {
                        icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.png"));
                        setIconImage(icon);
                        jb_Elip.setEnabled(false);
                        el.setEnabled(false);
                        jb_Hiper.setEnabled(true);
                        hi.setEnabled(true);
                        jb_Circu.setEnabled(true);
                        cir.setEnabled(true);
                        jb_Para.setEnabled(true);
                        par.setEnabled(true);
                        jb_Calcu.setEnabled(true);
                        jtf_Radio.requestFocus();
                        verticex.setVisible(false);
                        verticey.setVisible(false);
                        txtverticex.setVisible(false);
                        txtverticey.setVisible(false);
                        anc.setVisible(true);
                        al.setVisible(true);
                        cen.setVisible(true);
                        cen2.setVisible(true);
                        jtf_XCentroElip.setVisible(true);
                        jtf_Ancho.setVisible(true);
                        jtf_Alto.setVisible(true);
                        jtf_YCentroElip.setVisible(true);
                        fo.setVisible(false);
                        jtf_FocoXPara.setVisible(false);
                        foc2.setVisible(false);
                        jtf_FocoYPara.setVisible(false);
                        rad.setVisible(false);
                        jtf_Radio.setVisible(false);
                        x.setVisible(false);
                        y.setVisible(false);
                        jtf_XCentroCircu.setVisible(false);
                        jtf_YCentroCircu.setVisible(false);

                    }
                }
            }
        }
    }

    public void save() {
        // Capturar la imagen del panel de resultados
        BufferedImage resultsImage = new BufferedImage(jp_Resultados.getWidth(), jp_Resultados.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D resultsGraphics = resultsImage.createGraphics();
        jp_Resultados.paint(resultsGraphics);

        // Capturar la imagen del panel gráfico
        BufferedImage graphImage = new BufferedImage(jp_Graficador.getWidth(), jp_Graficador.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphGraphics = graphImage.createGraphics();
        jp_Graficador.paint(graphGraphics);

        // Combinar ambas imágenes en una sola
        int combinedWidth = Math.max(resultsImage.getWidth(), graphImage.getWidth());
        int combinedHeight = resultsImage.getHeight() + graphImage.getHeight();
        BufferedImage combinedImage = new BufferedImage(combinedWidth, combinedHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D combinedGraphics = combinedImage.createGraphics();
        combinedGraphics.drawImage(resultsImage, 0, 0, null);
        combinedGraphics.drawImage(graphImage, 0, resultsImage.getHeight(), null);

        // Guardar la imagen combinada
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int val = fc.showSaveDialog(null);
        if (val == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            String extension = "png"; // Default extension

            // Obtener la extensión del archivo seleccionado
            String[] fileExtensions = ((FileNameExtensionFilter) fc.getFileFilter()).getExtensions();
            if (fileExtensions.length > 0) {
                extension = fileExtensions[0];
            }

            try {
                ImageIO.write(combinedImage, extension, selectedFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



    public void calcu() {
        if (!jb_Elip.isEnabled()) {
            jp_Graficador.puntoCentroE.setLocation(Integer.parseInt(jtf_XCentroElip.getText()) * 10 + jp_Graficador.getWidth() / 2, Integer.parseInt(jtf_YCentroElip.getText()) * 10 + jp_Graficador.getHeight() / 2);
            jp_Graficador.puntoFinalE.setLocation((Integer.parseInt(jtf_XCentroElip.getText()) * 10 + jp_Graficador.getWidth() / 2) + Integer.parseInt(jtf_Ancho.getText()) * 10, (Integer.parseInt(jtf_YCentroElip.getText()) * 10 + jp_Graficador.getHeight() / 2) + Integer.parseInt(jtf_Alto.getText()) * 10);
            repaint();
        }
        if (!jb_Para.isEnabled()) {
            jp_Graficador.paranto.setLocation((Integer.parseInt(txtverticex.getText()) * 10) + jp_Graficador.getWidth() / 2, -(Integer.parseInt(txtverticey.getText()) * 10) + jp_Graficador.getHeight() / 2);
            jp_Graficador.parafin.setLocation((Integer.parseInt(jtf_FocoXPara.getText()) * 10) + jp_Graficador.getWidth() / 2, -(Integer.parseInt(jtf_FocoYPara.getText()) * 10) + jp_Graficador.getHeight() / 2);
            repaint();
        }
        if (!jb_Hiper.isEnabled()) {
            jp_Graficador.hiper.setLocation((Integer.parseInt(txtverticex.getText()) * 10) + jp_Graficador.getWidth() / 2, -(Integer.parseInt(txtverticey.getText()) * 10) + jp_Graficador.getHeight() / 2);
            jp_Graficador.hiperfin.setLocation((Integer.parseInt(jtf_FocoXPara.getText()) * 10) + jp_Graficador.getWidth() / 2, -(Integer.parseInt(jtf_FocoYPara.getText()) * 10) + jp_Graficador.getHeight() / 2);
            repaint();
        }
        if (!jb_Circu.isEnabled()) {
            jp_Graficador.puntoCentroC.setLocation((Integer.parseInt(jtf_XCentroCircu.getText()) * 10) + jp_Graficador.getWidth() / 2, (Integer.parseInt(jtf_YCentroCircu.getText()) * 10) + jp_Graficador.getHeight() / 2);
            jp_Graficador.puntoTanCM.setLocation((Integer.parseInt(jtf_XCentroCircu.getText()) * 10) + jp_Graficador.getWidth() / 2, ((Integer.parseInt(jtf_YCentroCircu.getText()) * 10) + jp_Graficador.getHeight() / 2) + Integer.parseInt(jtf_Radio.getText()) * 10);
            repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_Datos = new javax.swing.JPanel();
        rad = new javax.swing.JLabel();
        fo = new javax.swing.JLabel();
        jtf_Radio = new javax.swing.JTextField();
        jtf_FocoXPara = new javax.swing.JTextField();
        cen = new javax.swing.JLabel();
        anc = new javax.swing.JLabel();
        al = new javax.swing.JLabel();
        x = new javax.swing.JLabel();
        y = new javax.swing.JLabel();
        jtf_XCentroElip = new javax.swing.JTextField();
        jtf_Ancho = new javax.swing.JTextField();
        jtf_Alto = new javax.swing.JTextField();
        jtf_XCentroCircu = new javax.swing.JTextField();
        jtf_YCentroCircu = new javax.swing.JTextField();
        cen2 = new javax.swing.JLabel();
        jtf_YCentroElip = new javax.swing.JTextField();
        foc2 = new javax.swing.JLabel();
        jtf_FocoYPara = new javax.swing.JTextField();
        verticex = new javax.swing.JLabel();
        verticey = new javax.swing.JLabel();
        txtverticey = new javax.swing.JTextField();
        txtverticex = new javax.swing.JTextField();
        jp_Resultados = new javax.swing.JPanel();
        jl_Radio = new javax.swing.JLabel();
        jl_Cuerda = new javax.swing.JLabel();
        jl_PuntoTan = new javax.swing.JLabel();
        jl_Emay = new javax.swing.JLabel();
        jl_EMen = new javax.swing.JLabel();
        jl_Foco1 = new javax.swing.JLabel();
        jl_Foco2 = new javax.swing.JLabel();
        jl_CentroEli = new javax.swing.JLabel();
        jl_CordM = new javax.swing.JLabel();
        jb_Circu = new javax.swing.JButton();
        jb_Para = new javax.swing.JButton();
        jb_Hiper = new javax.swing.JButton();
        jb_Elip = new javax.swing.JButton();
        jb_Calcu = new javax.swing.JButton();
        jp_Graficador = new abp_v1.panel();
        jmi_Nuevo = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jm_Abrir = new javax.swing.JMenu();
        jmi_AbrirCir = new javax.swing.JMenuItem();
        jmi_AbrirPara = new javax.swing.JMenuItem();
        jmi_AbrirHiper = new javax.swing.JMenuItem();
        jmi_AbrirEli = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cir = new javax.swing.JMenuItem();
        par = new javax.swing.JMenuItem();
        hi = new javax.swing.JMenuItem();
        el = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graficador");
        setBackground(new java.awt.Color(254, 250, 224));
        setResizable(false);

        jp_Datos.setBackground(new java.awt.Color(254, 250, 224));
        jp_Datos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12))); // NOI18N

        rad.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        rad.setText("Radio");

        fo.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        fo.setText("Foco X");

        jtf_Radio.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jtf_Radio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jtf_FocoXPara.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jtf_FocoXPara.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        cen.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        cen.setText("X del Centro");

        anc.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        anc.setText("Ancho");

        al.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        al.setText("Alto");

        x.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        x.setText("X del Centro");

        y.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        y.setText("Y del Centro");

        jtf_XCentroElip.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jtf_XCentroElip.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jtf_XCentroElip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_XCentroElipActionPerformed(evt);
            }
        });

        jtf_Ancho.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jtf_Ancho.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jtf_Ancho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_AnchoActionPerformed(evt);
            }
        });

        jtf_Alto.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jtf_Alto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jtf_XCentroCircu.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jtf_XCentroCircu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jtf_YCentroCircu.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jtf_YCentroCircu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        cen2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        cen2.setText("Y del Centro");

        jtf_YCentroElip.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jtf_YCentroElip.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        foc2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        foc2.setText("Foco Y");

        jtf_FocoYPara.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jtf_FocoYPara.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        verticex.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        verticex.setText("Vértice X");

        verticey.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        verticey.setText("Vértice Y");

        txtverticey.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtverticey.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        txtverticex.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtverticex.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        javax.swing.GroupLayout jp_DatosLayout = new javax.swing.GroupLayout(jp_Datos);
        jp_Datos.setLayout(jp_DatosLayout);
        jp_DatosLayout.setHorizontalGroup(
            jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_DatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jp_DatosLayout.createSequentialGroup()
                        .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad)
                            .addComponent(fo)
                            .addComponent(al))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_Alto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_DatosLayout.createSequentialGroup()
                        .addComponent(anc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_Ancho, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_DatosLayout.createSequentialGroup()
                        .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cen2)
                                    .addComponent(cen)
                                    .addComponent(x))
                                .addComponent(y))
                            .addComponent(foc2)
                            .addComponent(verticex)
                            .addComponent(verticey))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtverticex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_FocoYPara, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_YCentroCircu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_XCentroCircu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_YCentroElip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_XCentroElip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_FocoXPara, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_Radio, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtverticey, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jp_DatosLayout.setVerticalGroup(
            jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_DatosLayout.createSequentialGroup()
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad)
                    .addComponent(jtf_Radio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_FocoXPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_XCentroElip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_YCentroElip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cen2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_XCentroCircu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_YCentroCircu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(y))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_FocoYPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foc2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtverticex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verticex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtverticey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verticey, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_Ancho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_Alto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_Resultados.setBackground(new java.awt.Color(254, 250, 224));
        jp_Resultados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0), "Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12))); // NOI18N
        jp_Resultados.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jl_Radio.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jl_Radio.setText("Radio:");

        jl_Cuerda.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jl_Cuerda.setText("Cuerda:");

        jl_PuntoTan.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jl_PuntoTan.setText("Punto Tangente: x[] y[]");

        jl_Emay.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jl_Emay.setText("Eje Mayor:");

        jl_EMen.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jl_EMen.setText("Eje Menor:");

        jl_Foco1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jl_Foco1.setText("Punto Foco 1: x[] y[]");

        jl_Foco2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jl_Foco2.setText("Punto Foco 2: x[] y[]");

        jl_CentroEli.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jl_CentroEli.setText("Punto Centro: x[] y[]");

        jl_CordM.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jl_CordM.setText("Mouse en: x[] y[]");

        javax.swing.GroupLayout jp_ResultadosLayout = new javax.swing.GroupLayout(jp_Resultados);
        jp_Resultados.setLayout(jp_ResultadosLayout);
        jp_ResultadosLayout.setHorizontalGroup(
            jp_ResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_ResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Cuerda)
                    .addComponent(jl_CordM)
                    .addComponent(jl_Radio)
                    .addComponent(jl_Foco1)
                    .addComponent(jl_Foco2)
                    .addComponent(jl_PuntoTan)
                    .addComponent(jl_CentroEli)
                    .addComponent(jl_EMen)
                    .addComponent(jl_Emay))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_ResultadosLayout.setVerticalGroup(
            jp_ResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ResultadosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jl_CordM)
                .addGap(16, 16, 16)
                .addComponent(jl_Radio)
                .addGap(18, 18, 18)
                .addComponent(jl_Cuerda)
                .addGap(18, 18, 18)
                .addComponent(jl_Foco1)
                .addGap(18, 18, 18)
                .addComponent(jl_Foco2)
                .addGap(18, 18, 18)
                .addComponent(jl_PuntoTan)
                .addGap(18, 18, 18)
                .addComponent(jl_CentroEli)
                .addGap(18, 18, 18)
                .addComponent(jl_EMen)
                .addGap(18, 18, 18)
                .addComponent(jl_Emay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jb_Circu.setBackground(new java.awt.Color(142, 202, 230));
        jb_Circu.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jb_Circu.setText("Circunferencia");
        jb_Circu.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(142, 202, 230), new java.awt.Color(142, 202, 230)));
        jb_Circu.setFocusable(false);
        jb_Circu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_CircuMouseClicked(evt);
            }
        });
        jb_Circu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_CircuActionPerformed(evt);
            }
        });

        jb_Para.setBackground(new java.awt.Color(233, 196, 106));
        jb_Para.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jb_Para.setText("Parábola");
        jb_Para.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(233, 196, 106), new java.awt.Color(233, 196, 106)));
        jb_Para.setFocusable(false);
        jb_Para.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ParaActionPerformed(evt);
            }
        });

        jb_Hiper.setBackground(new java.awt.Color(242, 132, 130));
        jb_Hiper.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jb_Hiper.setText("Hipérbola");
        jb_Hiper.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(242, 132, 130), new java.awt.Color(242, 132, 130)));
        jb_Hiper.setFocusable(false);
        jb_Hiper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_HiperActionPerformed(evt);
            }
        });

        jb_Elip.setBackground(new java.awt.Color(216, 226, 220));
        jb_Elip.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jb_Elip.setText("Elipse");
        jb_Elip.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(216, 226, 220), 2, true));
        jb_Elip.setFocusable(false);
        jb_Elip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ElipActionPerformed(evt);
            }
        });

        jb_Calcu.setBackground(new java.awt.Color(248, 150, 30));
        jb_Calcu.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jb_Calcu.setText("Calcular");
        jb_Calcu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(248, 150, 30), 3, true));
        jb_Calcu.setFocusable(false);
        jb_Calcu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jb_CalcuMousePressed(evt);
            }
        });
        jb_Calcu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_CalcuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_GraficadorLayout = new javax.swing.GroupLayout(jp_Graficador);
        jp_Graficador.setLayout(jp_GraficadorLayout);
        jp_GraficadorLayout.setHorizontalGroup(
            jp_GraficadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );
        jp_GraficadorLayout.setVerticalGroup(
            jp_GraficadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jmi_Nuevo.setBackground(new java.awt.Color(255, 237, 216));
        jmi_Nuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 237, 216), 1, true));
        jmi_Nuevo.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(255, 237, 216));
        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        jm_Abrir.setText("Abrir");

        jmi_AbrirCir.setBackground(new java.awt.Color(255, 237, 216));
        jmi_AbrirCir.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jmi_AbrirCir.setText("Circunferencia");
        jmi_AbrirCir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        jmi_AbrirCir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_AbrirCirActionPerformed(evt);
            }
        });
        jm_Abrir.add(jmi_AbrirCir);

        jmi_AbrirPara.setBackground(new java.awt.Color(255, 237, 216));
        jmi_AbrirPara.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jmi_AbrirPara.setText("Parabola");
        jmi_AbrirPara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        jmi_AbrirPara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_AbrirParaActionPerformed(evt);
            }
        });
        jm_Abrir.add(jmi_AbrirPara);

        jmi_AbrirHiper.setBackground(new java.awt.Color(255, 237, 216));
        jmi_AbrirHiper.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jmi_AbrirHiper.setText("Hiperbola");
        jmi_AbrirHiper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        jmi_AbrirHiper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_AbrirHiperActionPerformed(evt);
            }
        });
        jm_Abrir.add(jmi_AbrirHiper);

        jmi_AbrirEli.setBackground(new java.awt.Color(255, 237, 216));
        jmi_AbrirEli.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jmi_AbrirEli.setText("Elipse");
        jmi_AbrirEli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        jmi_AbrirEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_AbrirEliActionPerformed(evt);
            }
        });
        jm_Abrir.add(jmi_AbrirEli);

        jMenu1.add(jm_Abrir);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setBackground(new java.awt.Color(255, 237, 216));
        jMenuItem8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenuItem8.setText("Guardar Datos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setBackground(new java.awt.Color(255, 237, 216));
        jMenuItem1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenuItem1.setText("Guardar Grafico");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem9.setBackground(new java.awt.Color(255, 237, 216));
        jMenuItem9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenuItem9.setText("Cerrar sesión");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jmi_Nuevo.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(255, 237, 216));
        jMenu2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        jMenu2.setText("Cónicas");
        jMenu2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        cir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        cir.setBackground(new java.awt.Color(255, 237, 216));
        cir.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cir.setText("Circunferencia");
        cir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        cir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cirActionPerformed(evt);
            }
        });
        jMenu2.add(cir);

        par.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        par.setBackground(new java.awt.Color(255, 237, 216));
        par.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        par.setText("Parábola");
        par.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        par.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parActionPerformed(evt);
            }
        });
        jMenu2.add(par);

        hi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        hi.setBackground(new java.awt.Color(255, 237, 216));
        hi.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        hi.setText("Hiperbola");
        hi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        hi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiActionPerformed(evt);
            }
        });
        jMenu2.add(hi);

        el.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        el.setBackground(new java.awt.Color(255, 237, 216));
        el.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        el.setText("Elipse");
        el.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        el.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elActionPerformed(evt);
            }
        });
        jMenu2.add(el);

        jmi_Nuevo.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(255, 237, 216));
        jMenu3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        jMenu3.setText("Ayuda");
        jMenu3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenuItem2.setText("Manual");
        jMenuItem2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenuItem3.setText("Ayuda");
        jMenuItem3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 237, 216)));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);
        jMenuItem3.getAccessibleContext().setAccessibleName("Ayuda");

        jmi_Nuevo.add(jMenu3);

        setJMenuBar(jmi_Nuevo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_Datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_Resultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jp_Graficador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jb_Circu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_Para, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_Hiper, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_Elip, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_Calcu)
                .addGap(0, 336, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_Circu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_Para, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_Hiper, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_Elip, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_Calcu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jp_Datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_Resultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jp_Graficador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_ParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ParaActionPerformed
        repaint();
        cont = 2;
        deshabilitar();
    }//GEN-LAST:event_jb_ParaActionPerformed
    boolean bot;
    private void jb_HiperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_HiperActionPerformed
        repaint();
        bot = true;
        cont = 3;
        deshabilitar();

    }//GEN-LAST:event_jb_HiperActionPerformed

    private void jb_ElipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ElipActionPerformed
        repaint();
        cont = 4;
        deshabilitar();
    }//GEN-LAST:event_jb_ElipActionPerformed

    private void jb_CalcuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_CalcuActionPerformed
        calcu();
    }//GEN-LAST:event_jb_CalcuActionPerformed

    private void cirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cirActionPerformed
        repaint();
        cont = 1;
        deshabilitar();
    }//GEN-LAST:event_cirActionPerformed

    private void parActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parActionPerformed
        repaint();
        cont = 2;
        deshabilitar();
    }//GEN-LAST:event_parActionPerformed

    private void hiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hiActionPerformed
        repaint();
        cont = 3;
        deshabilitar();
    }//GEN-LAST:event_hiActionPerformed

    private void elActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elActionPerformed
        repaint();
        cont = 4;
        deshabilitar();
    }//GEN-LAST:event_elActionPerformed

    private void jb_CircuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_CircuActionPerformed
        repaint();
        cont = 1;
        deshabilitar();
    }//GEN-LAST:event_jb_CircuActionPerformed

    private void jb_CircuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_CircuMouseClicked

    }//GEN-LAST:event_jb_CircuMouseClicked

    private void jb_CalcuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_CalcuMousePressed
        repaint();
    }//GEN-LAST:event_jb_CalcuMousePressed

    private void jtf_XCentroElipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_XCentroElipActionPerformed

    }//GEN-LAST:event_jtf_XCentroElipActionPerformed


    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        String fech;
        String hor;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        hor = dtf.format(now);
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        fech = dtf.format(now);

        if (!jb_Circu.isEnabled()) {
            // Guardar datos en la tabla de Circunferencia
            sql.saveCir(User, fech, hor, (p.puntoCentroC.x - p.getWidth() / 2) / 10, (p.puntoCentroC.y - p.getHeight() / 2) / 10, (p.puntoTanCM.x - p.getWidth() / 2) / 10, (p.puntoTanCM.y - p.getHeight() / 2) / 10);
        } else if (!jb_Elip.isEnabled()) {
            // Guardar datos en la tabla de Elipse
            sql.saveElip(User, fech, hor, (p.puntoCentroE.x - p.getWidth() / 2) / 10, (p.puntoCentroE.y - p.getHeight() / 2) / 10, (p.puntoFinalE.x - p.getWidth() / 2) / 10, (p.puntoFinalE.y - p.getHeight() / 2) / 10);
        } else if (!jb_Para.isEnabled()) {
            // Guardar datos en la tabla de Parábola
            sql.savePara(User, fech, hor, (p.paranto.x - p.getWidth() / 2) / 10, (p.paranto.y - p.getHeight() / 2) / 10, (p.parafin.x - p.getWidth() / 2) / 10, (p.parafin.y - p.getHeight() / 2) / 10);
        } else if (!jb_Hiper.isEnabled()) {
            // Guardar datos en la tabla de Hipérbola
            sql.savePara(User, fech, hor, (p.paranto.x - p.getWidth() / 2) / 10, (p.paranto.y - p.getHeight()/ 2) / 10, (p.parafin.x - p.getWidth() / 2) / 10, (p.parafin.y - p.getHeight()/ 2) / 10);
        } else {
            // Si todos los botones están habilitados, no se puede guardar datos
            System.out.println("No hay figura seleccionada para guardar datos.");
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed


    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Popup p = new Popup();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        save();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmi_AbrirCirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_AbrirCirActionPerformed
        Abrir a = new Abrir(this);
        a.setDf("Circunferencia");
        a.setVisible(true);
    }//GEN-LAST:event_jmi_AbrirCirActionPerformed

    private void jmi_AbrirEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_AbrirEliActionPerformed
        Abrir a = new Abrir(this);
        a.setDf("Elipse");
        a.setVisible(true);
    }//GEN-LAST:event_jmi_AbrirEliActionPerformed

    private void jmi_AbrirParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_AbrirParaActionPerformed
        Abrir a = new Abrir(this);
        a.setDf("Parabola");
        a.setVisible(true);
    }//GEN-LAST:event_jmi_AbrirParaActionPerformed

    private void jmi_AbrirHiperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_AbrirHiperActionPerformed
        Abrir a = new Abrir(this);
        a.setDf("Hiperbola");
        a.setVisible(true);
    }//GEN-LAST:event_jmi_AbrirHiperActionPerformed

    private void jtf_AnchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_AnchoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_AnchoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Manual man = new Manual();
        man.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Ayuda ay = new Ayuda();
        ay.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel al;
    private javax.swing.JLabel anc;
    private javax.swing.JLabel cen;
    private javax.swing.JLabel cen2;
    private javax.swing.JMenuItem cir;
    private javax.swing.JMenuItem el;
    private javax.swing.JLabel fo;
    private javax.swing.JLabel foc2;
    private javax.swing.JMenuItem hi;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton jb_Calcu;
    private javax.swing.JButton jb_Circu;
    private javax.swing.JButton jb_Elip;
    private javax.swing.JButton jb_Hiper;
    private javax.swing.JButton jb_Para;
    private javax.swing.JLabel jl_CentroEli;
    private javax.swing.JLabel jl_CordM;
    private javax.swing.JLabel jl_Cuerda;
    private javax.swing.JLabel jl_EMen;
    private javax.swing.JLabel jl_Emay;
    private javax.swing.JLabel jl_Foco1;
    private javax.swing.JLabel jl_Foco2;
    private javax.swing.JLabel jl_PuntoTan;
    private javax.swing.JLabel jl_Radio;
    private javax.swing.JMenu jm_Abrir;
    private javax.swing.JMenuItem jmi_AbrirCir;
    private javax.swing.JMenuItem jmi_AbrirEli;
    private javax.swing.JMenuItem jmi_AbrirHiper;
    private javax.swing.JMenuItem jmi_AbrirPara;
    private javax.swing.JMenuBar jmi_Nuevo;
    private javax.swing.JPanel jp_Datos;
    private abp_v1.panel jp_Graficador;
    private javax.swing.JPanel jp_Resultados;
    private javax.swing.JTextField jtf_Alto;
    private javax.swing.JTextField jtf_Ancho;
    private javax.swing.JTextField jtf_FocoXPara;
    private javax.swing.JTextField jtf_FocoYPara;
    private javax.swing.JTextField jtf_Radio;
    private javax.swing.JTextField jtf_XCentroCircu;
    private javax.swing.JTextField jtf_XCentroElip;
    private javax.swing.JTextField jtf_YCentroCircu;
    private javax.swing.JTextField jtf_YCentroElip;
    private javax.swing.JMenuItem par;
    private javax.swing.JLabel rad;
    private javax.swing.JTextField txtverticex;
    private javax.swing.JTextField txtverticey;
    private javax.swing.JLabel verticex;
    private javax.swing.JLabel verticey;
    private javax.swing.JLabel x;
    private javax.swing.JLabel y;
    // End of variables declaration//GEN-END:variables

}
