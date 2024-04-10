package abp_v1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class panel extends javax.swing.JPanel {

    ////////////////////////////////////
    //Variables Generales///////////////
    Ventana v;                        //
    String cords = "x[] y[]";         //
    ////////////////////////////////////
    //Variables Circunferencia//////////
    Point puntoCentroC = new Point(); //
    Point puntoTanCM = new Point();   //
    Point puntoCuerdaIn;              //
    Point puntoCuerdaFi;              //
    ////////////////////////////////////
    //Variables Elipse//////////////////
    Point puntoCentroE = new Point(); //
    Point puntoFinalE = new Point();  //
    int al;                           //
    int an;                           //
    ////////////////////////////////////   
    //Variables Parabola////////////////
    Point paranto = new Point();      //
    Point parafin = new Point();      //
    ////////////////////////////////////
    //Variables Hipérbola///////////////
    Point hiper = new Point();        //
    Point hiperfin = new Point();     //
    ////////////////////////////////////

    public panel() {
        initComponents();
        paranto.setLocation(99999, 99999);
        parafin.setLocation(99998, 99998);
        puntoCentroC.setLocation(99999, 99999);
        puntoTanCM.setLocation(99998, 99998);
        puntoCentroE.setLocation(99999, 99999);
        puntoFinalE.setLocation(99998, 99998);
        hiper.setLocation(99999, 99999);
        hiperfin.setLocation(99998, 99998);
    }

    public void getV(Ventana ve) {
        v = ve;
    }

    @Override
    public void paint(Graphics g) {

        ///////////////////////////////////////////////////////////////
        //Reinicio del Panel///////////////////////////////////////////
        g.setColor(Color.white);                                     //
        g.fillRect(0, 0, this.getWidth(), this.getHeight());         //
        g.setColor(Color.black);                                     //
        g.translate(this.getWidth() / 2, this.getHeight() / 2);      //
        g.drawLine(this.getWidth() / -2, 0, this.getWidth() / 2, 0); //
        g.drawLine(0, this.getWidth() / -2, 0, this.getWidth() / 2); //
        for (int i = 0; i < this.getWidth() / 2; i = i + 10) {       //
            g.drawLine(i, 5, i, -5);                                 //
            g.drawLine(-i, 5, -i, -5);                               //
        }                                                            //
        for (int i = 0; i < this.getHeight() / 2; i = i + 10) {      //
            g.drawLine(5, i, -5, i);                                 //
            g.drawLine(5, -i, -5, -i);                               //
        }                                                            //
        g.translate(this.getWidth() / -2, this.getHeight() / -2);    //
        ///////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////////////////////////////////
        //Graficacion de la circunferencia////////////////////////////////////////////////////////////
        if (!v.Bcircu.isEnabled() && puntoCentroC != null) {                                        //
            g.setColor(Color.RED);                                                                  //
            double d1 = Math.pow(puntoTanCM.x - puntoCentroC.x, 2);                                 //
            double d2 = Math.pow(puntoTanCM.y - puntoCentroC.y, 2);                                 //
            int d = (int) Math.sqrt(d1 + d2);                                                       //
            g.drawOval(puntoCentroC.x - d, puntoCentroC.y - d, d * 2, d * 2);                       //
            g.fillOval(puntoCentroC.x, puntoCentroC.y, 3, 3);                                       //            
            //////////////////////////////////////////////////////////////////////////////////////////////            
            //Calculo y definicion del punto medio////////////////////////////////////////////////////////
            if (puntoCentroC.x != 99999 && puntoCentroC.y != 99999) {
                v.centro.setText("Punto Centro: x[" + (puntoCentroC.x - this.getWidth() / 2) / 10 //
                        + "] y[" + (puntoCentroC.y - this.getHeight() / 2) / -10 + "]");
            }
            //////Dibujo de la Cuerda/////////////////////////////////////////////////////////////////////
            g.setColor(Color.blue);                                                                 //
            g.drawLine(puntoCentroC.x + d, puntoCentroC.y, puntoTanCM.x, puntoTanCM.y);             //
            //////////////////////////////////////////////////////////////////////////////////////////////
            //////Dibujo de el Radio//////////////////////////////////////////////////////////////////////
            g.setColor(Color.green);                                                                //
            g.drawLine(puntoCentroC.x, puntoCentroC.y, puntoTanCM.x, puntoTanCM.y);                 //
            //////////////////////////////////////////////////////////////////////////////////////////////
            //////Calculo y dibujo de la tangente/////////////////////////////////////////////////////////
            g.setColor(Color.magenta);                                                              //
            int dx = (puntoTanCM.x - puntoCentroC.x);                                               //
            int dy = (puntoTanCM.y - puntoCentroC.y);                                               //
            g.drawLine(puntoTanCM.x - dy, puntoTanCM.y + dx, puntoTanCM.x + dy, puntoTanCM.y - dx); //
            //////////////////////////////////////////////////////////////////////////////////////////////
            //////Envio de datos a los Labels de la Ventana///////////////////////////////////////////////
            //////Calculo del radio a escala//////////////////////////////////////////////////////////////
            int n = d / 10;                                                                         //
            v.getRa("Radio:" + n, n);                                                               //
            //////////////////////////////////////////////////////////////////////////////////////////////        
            //////Calculo de la medida de la cuerda a escala//////////////////////////////////////////////
            double c1 = Math.pow(puntoTanCM.x - (puntoCentroC.x + d), 2);                           //
            double c2 = Math.pow(puntoTanCM.y - puntoCentroC.y, 2);                                 //
            int c = (int) Math.sqrt(c1 + c2);                                                       //
            n = c / 10;                                                                             //
            v.getCu("Cuerda:" + n, n);                                                              //
            //////////////////////////////////////////////////////////////////////////////////////////////
            //////Calculo del punto tangente a escala/////////////////////////////////////////////////////
            if (puntoTanCM.x != 99998 && puntoTanCM.y != 99998) {
                v.getTan("Punto Tangente: x[" + (puntoTanCM.x - this.getWidth() / 2) / 10 + "]" //
                        + " y[" + (puntoTanCM.y - this.getHeight() / 2) / -10 + "]");                   //
            }
        }//
        //////////////////////////////////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////////////////////////////////
        ////Graficación de la parabola////////////////////////////////////////////////////////////////
        if (!v.Bpara.isEnabled() && paranto != null) {
            g.setColor(Color.red);
            //Distancia entre dos puntos con la misma x;
            double g1 = Math.pow(paranto.x - paranto.x, 2);
            double g2 = Math.pow(parafin.y - paranto.y, 2);
            int da = (int) Math.sqrt(g1 + g2);
            //Distancia entre dos puntos con la misma y; 
            double d1 = Math.pow(parafin.x - paranto.x, 2);
            double d2 = Math.pow(paranto.y - paranto.y, 2);
            int dl = (int) Math.sqrt(d1 + d2);

            if (dl > da) {
                if (paranto.x < parafin.x) {
                    int v1 = dl * 2;
                    int v2 = dl * 4;
                    int poy = paranto.y + v2 / -2;
                    //Calculo de la parabola
                    g.drawLine(paranto.x, paranto.y, parafin.x, paranto.y);
                    g.drawArc(paranto.x, poy, v1, v2, 90, 180);
                    g.drawLine(parafin.x, poy, 9999, poy - 800);
                    g.drawLine(parafin.x, poy + v2, 9999, poy + v2 + 800);
                    //Calculo de la directriz
                    g.setColor(Color.blue);
                    g.drawLine(paranto.x - dl, 9999, paranto.x - dl, -9999);
                    //Calculo del lado recto
                    g.setColor(Color.orange);
                    g.drawLine(parafin.x, poy + v2, parafin.x, poy);
                    if (paranto.x != 99999 && paranto.y != 99999 && parafin.x != 99998 && parafin.y != 99998) {
                        v.foco1.setText("Punto Vértice: x[" + (paranto.x - this.getWidth() / 2) / 10 + "] y[" + (paranto.y - this.getHeight() / 2) / -10 + "]");
                        v.foco2.setText("Punto Foco: x[" + (parafin.x - this.getWidth() / 2) / 10 + "] y[" + (paranto.y - this.getHeight() / 2) / -10 + "]");
                    }

                } else {
                    int v1 = dl * 2;
                    int v2 = dl * 4;
                    int poy = paranto.y + v2 / -2;
                    //Calculo de la parabola
                    g.drawLine(paranto.x, paranto.y, parafin.x, paranto.y);
                    g.drawArc(paranto.x - v1, poy, v1, v2, 270, 180);
                    g.drawLine(parafin.x, poy, -9999, poy - 800);
                    g.drawLine(parafin.x, poy + v2, -9999, poy + v2 + 800);
                    //Calculo de la directriz
                    g.setColor(Color.blue);
                    g.drawLine(paranto.x + dl, 9999, paranto.x + dl, -9999);
                    //Calculo del lado recto
                    g.setColor(Color.orange);
                    g.drawLine(parafin.x, poy + v2, parafin.x, poy);
                    if (paranto.x != 99999 && paranto.y != 99999 && parafin.x != 99998 && parafin.y != 99998) {
                        v.foco1.setText("Punto Vértice: x[" + (paranto.x - this.getWidth() / 2) / 10 + "] y[" + (paranto.y - this.getHeight() / 2) / -10 + "]");
                        v.foco2.setText("Punto Foco: x[" + (parafin.x - this.getWidth() / 2) / 10 + "] y[" + (paranto.y - this.getHeight() / 2) / -10 + "]");
                    }
                }

            } else {
                if (paranto.y > parafin.y) {
                    int v1 = da * 4;
                    int v2 = da * 2;
                    int pox = paranto.x + v1 / -2;
                    int poy = paranto.y + v2 * -1;
                    //Calculo de la parabola 
                    g.drawLine(paranto.x, paranto.y, paranto.x, parafin.y);
                    g.drawArc(pox, poy, v1, v2, 180, 180);
                    g.drawLine(pox + v1, parafin.y, pox + 800, -9999);
                    g.drawLine(pox, parafin.y, pox + v1 - 800, -9999);
                    //Calculo de la directriz
                    g.setColor(Color.blue);
                    g.drawLine(9999, paranto.y + da, -9999, paranto.y + da);
                    //Calculo del lado recto
                    g.setColor(Color.orange);
                    g.drawLine(pox + v1, parafin.y, pox, parafin.y);
                    if (paranto.x != 99999 && paranto.y != 99999 && parafin.x != 99998 && parafin.y != 99998) {
                        v.foco1.setText("Punto Vértice: x[" + (paranto.x - this.getWidth() / 2) / 10 + "] y[" + (paranto.y - this.getHeight() / 2) / -10 + "]");
                        v.foco2.setText("Punto Foco: x[" + (paranto.x - this.getWidth() / 2) / 10 + "] y[" + (parafin.y - this.getHeight() / 2) / -10 + "]");
                    }

                } else {
                    int v1 = da * 4;
                    int v2 = da * 2;
                    int pox = paranto.x + v1 / -2;
                    int poy = paranto.y + v2;
                    //Calculo de la parabola
                    g.drawLine(paranto.x, paranto.y, paranto.x, parafin.y);
                    g.drawArc(pox, poy - v2, v1, v2, 0, 180);
                    g.drawLine(pox + v1, parafin.y, pox + 800, 9999);
                    g.drawLine(pox, parafin.y, pox + v1 - 800, 9999);
                    //Calculo de la directriz
                    g.setColor(Color.blue);
                    g.drawLine(9999, paranto.y - da, -9999, paranto.y - da);
                    //Calculo del lado recto
                    g.setColor(Color.orange);
                    g.drawLine(pox + v1, parafin.y, pox, parafin.y);
                    if (paranto.x != 99999 && paranto.y != 99999 && parafin.x != 99998 && parafin.y != 99998) {
                        v.foco1.setText("Punto Vértice: x[" + (paranto.x - this.getWidth() / 2) / 10 + "] y[" + (paranto.y - this.getHeight() / 2) / -10 + "]");
                        v.foco2.setText("Punto Foco: x[" + (paranto.x - this.getWidth() / 2) / 10 + "] y[" + (parafin.y - this.getHeight() / 2) / -10 + "]");
                    }
                }
            }

        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////7
        //Graficación de la hiperbola///////////////////////////////////////////////////////////////////////////
        if (!v.Bhiper.isEnabled() && hiper != null) {
            g.setColor(Color.RED);
            double k1 = Math.pow(hiper.x - 0, 2);
            double k2 = Math.pow(hiper.y - hiper.y, 2);
            int kl = (int) Math.sqrt(k1 + k2);
            double y1 = Math.pow(hiper.x - hiper.x, 2);
            double y2 = Math.pow(hiper.y - 0, 2);
            int yl = (int) Math.sqrt(y1 + y2);

            double g1 = Math.pow(hiper.x - hiper.x, 2);
            double g2 = Math.pow(hiperfin.y - hiper.y, 2);
            int da = (int) Math.sqrt(g1 + g2);
            double d1 = Math.pow(hiperfin.x - hiper.x, 2);
            double d2 = Math.pow(hiper.y - hiper.y, 2);
            int dl = (int) Math.sqrt(d1 + d2);

            if (dl > da) {
                if (hiper.x < hiperfin.x) {
                    if (hiper.x > this.getWidth() / 2) {
                        int v1 = dl * 2;
                        int v2 = dl * 4;
                        int pox = hiper.x;
                        int poy = hiper.y + v2 / -2;
                        g.drawLine(hiper.x, hiper.y, hiperfin.x, hiper.y);
                        g.drawArc(pox, poy, v1, v2, 90, 180);
                        g.drawLine(this.getWidth() - kl, hiper.y, this.getWidth() - hiperfin.x, hiper.y);
                        g.drawArc(this.getWidth() - kl - v1, poy, v1, v2, 270, 180);
                        g.drawLine(hiperfin.x, poy, 9999, poy - 800);
                        g.drawLine(hiperfin.x, poy + v2, 9999, poy + v2 + 800);
                        g.drawLine(this.getWidth() - hiperfin.x, poy, -9999, poy - 800);
                        g.drawLine(this.getWidth() - hiperfin.x, poy + v2, -9999, poy + v2 + 800);
                        g.setColor(Color.orange);
                        g.drawLine(hiperfin.x, poy + v2, hiperfin.x, poy);
                        g.drawLine(this.getWidth() - hiperfin.x, poy + v2, this.getWidth() - hiperfin.x, poy);
                        g.setColor(Color.magenta);
                        g.drawLine(hiperfin.x, hiper.y, this.getWidth() - hiperfin.x, hiper.y);
                        g.fillOval(this.getWidth() / 2 - 3, hiper.y - 3, 6, 6);
                        if (hiper.x != 99999 && hiper.y != 99999 && hiperfin.x != 99998 && hiperfin.y != 99998) {
                            v.foco1.setText("Punto Vértice: x[" + (hiper.x - this.getWidth() / 2) / 10 + "] y[" + (hiper.y - this.getHeight() / 2) / -10 + "]");
                            v.foco2.setText("Punto Foco: x[" + (hiperfin.x - this.getWidth() / 2) / 10 + "] y[" + (hiper.y - this.getHeight() / 2) / -10 + "]");
                            v.tan.setText("Vértice Opuesto: x[" + (hiper.x - this.getWidth() / 2) /-10 + "] y[" + (hiper.y - this.getHeight() / 2) / -10+ "]");
                            v.centro.setText("Foco Opuesto: x[" + (hiperfin.x - this.getWidth() / 2)/-10 +"] y[" + (hiper.y - this.getHeight()/2)/-10 +"]");
                            
                        }

                    }
                } else {
                    if (hiper.x < this.getWidth() / 2) {
                        int v1 = dl * 2;
                        int v2 = dl * 4;
                        int pox = hiper.x;
                        int poy = hiper.y + v2 / -2;
                        g.drawLine(hiper.x, hiper.y, hiperfin.x, hiper.y);
                        g.drawArc(pox - v1, poy, v1, v2, 270, 180);
                        g.drawLine(this.getWidth() - kl, hiper.y, this.getWidth() - hiperfin.x, hiper.y);
                        g.drawArc(this.getWidth() - kl, poy, v1, v2, 90, 180);
                        g.drawLine(hiperfin.x, poy, -9999, poy - 800);
                        g.drawLine(hiperfin.x, poy + v2, -9999, poy + v2 + 800);
                        g.drawLine(this.getWidth() - hiperfin.x, poy, 9999, poy - 800);
                        g.drawLine(this.getWidth() - hiperfin.x, poy + v2, 9999, poy + v2 + 800);
                        g.setColor(Color.orange);
                        g.drawLine(hiperfin.x, poy + v2, hiperfin.x, poy);
                        g.drawLine(this.getWidth() - hiperfin.x, poy + v2, this.getWidth() - hiperfin.x, poy);
                        g.setColor(Color.magenta);
                        g.drawLine(hiperfin.x, hiper.y, this.getWidth() - hiperfin.x, hiper.y);
                        g.fillOval(this.getWidth() / 2 - 3, hiper.y - 3, 6, 6);
                        if (hiper.x != 99999 && hiper.y != 99999 && hiperfin.x != 99998 && hiperfin.y != 99998) {
                            v.foco1.setText("Punto Vértice: x[" + (hiper.x - this.getWidth() / 2) / 10 + "] y[" + (hiper.y - this.getHeight() / 2) / -10 + "]");
                            v.foco2.setText("Punto Foco: x[" + (hiperfin.x - this.getWidth() / 2) / 10 + "] y[" + (hiper.y - this.getHeight() / 2) / -10 + "]");
                            v.tan.setText("Vértice Opuesto: x[" + (hiper.x - this.getWidth() / 2) /-10 + "] y[" + (hiper.y - this.getHeight() / 2) / -10+ "]");
                            v.centro.setText("Foco Opuesto: x[" + (hiperfin.x - this.getWidth() / 2)/-10 +"] y[" + (hiper.y - this.getHeight()/2)/-10 +"]");
                        }
                    }
                }
            } else {
                if (hiper.y > hiperfin.y) {
                    if (hiper.y < this.getHeight() / 2) {
                        int v1 = da * 4;
                        int v2 = da * 2;
                        int pox = hiper.x + v1 / -2;
                        int poy = hiper.y + v2 * -1;
                        g.drawLine(hiper.x, hiper.y, hiper.x, hiperfin.y);
                        g.drawArc(pox, poy, v1, v2, 180, 180);
                        g.drawLine(hiper.x, this.getHeight() - yl, hiper.x, this.getHeight() - hiperfin.y);
                        g.drawArc(pox, this.getHeight() - yl, v1, v2, 0, 180);
                        g.drawLine(pox + v1, hiperfin.y, pox + 800, -9999);
                        g.drawLine(pox, hiperfin.y, pox + v1 - 800, -9999);
                        g.drawLine(pox + v1, this.getHeight() - hiperfin.y, pox + 800, 9999);
                        g.drawLine(pox, this.getHeight() - hiperfin.y, pox + v1 - 800, 9999);
                        g.setColor(Color.orange);
                        g.drawLine(pox + v1, hiperfin.y, pox, hiperfin.y);
                        g.drawLine(pox + v1, this.getHeight() - hiperfin.y, pox, this.getHeight() - hiperfin.y);
                        g.setColor(Color.magenta);
                        g.fillOval(hiper.x - 3, this.getHeight() / 2 - 3, 6, 6);
                        g.drawLine(hiper.x, hiperfin.y, hiper.x, this.getHeight() - hiperfin.y);
                        if (hiper.x != 99999 && hiper.y != 99999 && hiperfin.x != 99998 && hiperfin.y != 99998) {
                            v.foco1.setText("Punto Vértice: x[" + (hiper.x - this.getWidth() / 2) / 10 + "] y[" + (hiper.y - this.getHeight() / 2) / -10 + "]");
                            v.foco2.setText("Punto Foco: x[" + (hiper.x - this.getWidth() / 2) / 10 + "] y[" + (hiperfin.y - this.getHeight() / 2) / -10 + "]");
                            v.tan.setText("Vértice Opuesto: x[" + (hiper.x - this.getWidth() / 2) /10 + "] y[" + (hiper.y - this.getHeight() / 2) / 10+ "]");
                            v.centro.setText("Foco Opuesto: x[" + (hiper.x - this.getWidth() / 2)/10 +"] y[" + (hiperfin.y - this.getHeight()/2)/10 +"]");
                        }
                    }
                } else {
                    if (hiper.y > this.getHeight() / 2) {
                        int v1 = da * 4;
                        int v2 = da * 2;
                        int pox = hiper.x + v1 / -2;
                        int poy = hiper.y + v2;
                        g.drawLine(hiper.x, hiper.y, hiper.x, hiperfin.y);
                        g.drawArc(pox, poy - v2, v1, v2, 0, 180);
                        g.drawLine(hiper.x, this.getHeight() - yl, hiper.x, this.getHeight() - hiperfin.y);
                        g.drawArc(pox, this.getHeight() - yl - v2, v1, v2, 180, 180);
                        g.drawLine(pox + v1, hiperfin.y, pox + 800, 9999);
                        g.drawLine(pox, hiperfin.y, pox + v1 - 800, 9999);
                        g.drawLine(pox + v1, this.getHeight() - hiperfin.y, pox + 800, -9999);
                        g.drawLine(pox, this.getHeight() - hiperfin.y, pox + v1 - 800, -9999);
                        g.setColor(Color.orange);
                        g.drawLine(pox + v1, this.getHeight() - hiperfin.y, pox, this.getHeight() - hiperfin.y);
                        g.drawLine(pox + v1, hiperfin.y, pox, hiperfin.y);
                        g.setColor(Color.magenta);
                        g.fillOval(hiper.x - 3, this.getHeight() / 2 - 3, 6, 6);
                        g.drawLine(hiper.x, hiperfin.y, hiper.x, this.getHeight() - hiperfin.y);
                        if (hiper.x != 99999 && hiper.y != 99999 && hiperfin.x != 99998 && hiperfin.y != 99998) {
                            v.foco1.setText("Punto Vértice: x[" + (hiper.x - this.getWidth() / 2) / 10 + "] y[" + (hiper.y - this.getHeight() / 2) / -10 + "]");
                            v.foco2.setText("Punto Foco: x[" + (hiper.x - this.getWidth() / 2) / 10 + "] y[" + (hiperfin.y - this.getHeight() / 2) / -10 + "]");
                            v.tan.setText("Vértice Opuesto: x[" + (hiper.x - this.getWidth() / 2) /10 + "] y[" + (hiper.y - this.getHeight() / 2) / 10+ "]");
                            v.centro.setText("Foco Opuesto: x[" + (hiper.x - this.getWidth() / 2)/10 +"] y[" + (hiperfin.y - this.getHeight()/2)/10 +"]");
                        }
                    }
                }
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Graficacion de la Elipse//////////////////////////////////////////////////////////////////////////////
        if (!v.Belipse.isEnabled() && puntoCentroE != null) {                                                 //
            int d1 = (int) Math.pow(puntoFinalE.x - puntoCentroE.x, 2);                                       //
            int d2 = (int) Math.pow(puntoFinalE.y - puntoCentroE.y, 2);                                       //
            al = (int) Math.sqrt(d2);                                                                     //
            an = (int) Math.sqrt(d1);                                                                     //
            g.setColor(Color.red);                                                                            //
            g.drawOval(puntoCentroE.x - an, puntoCentroE.y - al, an * 2, al * 2);                             //
            g.fillOval(puntoCentroE.x - 2, puntoCentroE.y - 2, 4, 4);                                         //
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////Calculacion de Ejes y Ubicacion de los Focos////////////////////////////////////////////////////////
            g.setColor(Color.CYAN);                                                                           //
            if (an > al) {                                                                                    //
                g.drawLine(puntoCentroE.x - (an), puntoCentroE.y, puntoCentroE.x + (an), puntoCentroE.y);     //
                g.setColor(Color.green);                                                                      //
                g.drawLine(puntoCentroE.x, puntoCentroE.y - al, puntoCentroE.x, puntoCentroE.y + al);         //
                g.setColor(Color.magenta);                                                                    //
                g.fillOval(puntoCentroE.x - (an / 2), puntoCentroE.y, 4, 4);                                  //
                if (puntoCentroE.x != 99999 && puntoCentroE.y != 99999) {
                    v.foco1.setText("Punto Foco 1: x[" + (puntoCentroE.x - (an / 2) - (this.getWidth() / 2)) / 10 //
                            + "] y[" + (puntoCentroE.y - (this.getHeight() / 2)) / -10 + "]");                    //
                    g.fillOval(puntoCentroE.x + (an / 2), puntoCentroE.y, 4, 4);                                  //
                    v.foco2.setText("Punto Foco 2: x[" + (puntoCentroE.x + (an / 2) - (this.getWidth() / 2)) / 10 //
                            + "] y[" + (puntoCentroE.y - (this.getHeight() / 2)) / -10 + "]");                    //
                    v.Emay.setText("Eje Mayor:" + an / 10);                                                       //
                    v.EMen.setText("Eje Menor:" + al / 10);
                }
            } else {                                                                                          //
                g.drawLine(puntoCentroE.x, puntoCentroE.y - al, puntoCentroE.x, puntoCentroE.y + al);         //
                g.setColor(Color.green);                                                                      //
                g.drawLine(puntoCentroE.x - an, puntoCentroE.y, puntoCentroE.x + an, puntoCentroE.y);         //
                g.setColor(Color.magenta);                                                                    //
                g.fillOval(puntoCentroE.x, puntoCentroE.y + (al / 2), 4, 4);                                  //
                if (puntoCentroE.x != 99999 && puntoCentroE.y != 99999) {
                    v.foco2.setText("Punto Foco 2: x[" + (puntoCentroE.x - this.getWidth() / 2) / 10 //
                            + "] y[" + ((puntoCentroE.y + (al / 2)) - (this.getHeight() / 2)) / -10 + "]");       //
                    g.fillOval(puntoCentroE.x, puntoCentroE.y - (al / 2), 4, 4);                                  //
                    v.foco1.setText("Punto Foco 1: x[" + (puntoCentroE.x - this.getWidth() / 2) / 10 //
                            + "] y[" + ((puntoCentroE.y - (al / 2)) - (this.getHeight() / 2)) / -10 + "]");       //
                    v.Emay.setText("Eje Mayor:" + al / 10);                                                       //
                    v.EMen.setText("Eje Menor:" + an / 10);                                                       //
                }                                                                                                 //
                if (puntoCentroE.x != 99999 && puntoCentroE.y != 99999) {
                    v.centro.setText("Punto Centro: x[" + (puntoCentroE.x - this.getWidth() / 2) / 10 //
                            + "] y[" + (puntoCentroE.y - this.getHeight() / 2) / -10 + "]");                          //
                }
            }
        }//
        ////////////////////////////////////////////////////////////////////////////////////////////////////////   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

    }//GEN-LAST:event_formMouseEntered

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (!v.Bcircu.isEnabled()) {
            puntoCentroC = evt.getPoint();
        }
        if (!v.Belipse.isEnabled()) {
            puntoCentroE = evt.getPoint();
        }
        if (!v.Bpara.isEnabled()) {
            paranto = evt.getPoint();
        }
        if (!v.Bhiper.isEnabled()) {
            hiper = evt.getPoint();
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (!v.Bcircu.isEnabled()) {
            puntoTanCM = evt.getPoint();
            v.getTan("Punto Tangente: x[" + (puntoTanCM.x - this.getWidth() / 2) / 10 + "] y[" + (puntoTanCM.y - this.getHeight() / 2) / -10 + "]");
            repaint();
        }
        if (!v.Belipse.isEnabled()) {
            puntoFinalE = evt.getPoint();
            repaint();
        }
        if (!v.Bpara.isEnabled()) {
            parafin = evt.getPoint();
            repaint();
        }
        if (!v.Bhiper.isEnabled()) {
            hiperfin = evt.getPoint();
            repaint();
        }
        v.cords.setText("Mouse en: x[" + (evt.getX() - this.getWidth() / 2) / 10 + "] y[" + (evt.getY() - this.getHeight() / 2) / -10 + "]");
    }//GEN-LAST:event_formMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        v.cords.setText("Mouse en: x[" + (evt.getX() - this.getWidth() / 2) / 10 + "] y[" + (evt.getY() - this.getHeight() / 2) / -10 + "]");
    }//GEN-LAST:event_formMouseMoved

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
