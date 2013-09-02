
package Frame;

import java.awt.Color;
import javax.swing.*;


public class gasclass extends Thread
{   JTextField cliente;
    JTextField solic;
    JTextField disp;
    JTextField queda;
    JTextField total; 
    JTextField precio;
    JTextField todo;
    JSlider SLD;
    JSlider sld2;
    JComboBox tipopag;
    JComboBox tipocombustible;
    JButton mensaje;
    String Clientes []=new String[10];
    String razones []=new String[3];
    JRadioButton boleta;
    JRadioButton factura;
    JTextField ruc;
    JTextField dni;
    JTextField razon;
    JTextField numbol;
    JTextField numfact;
    double prc;
    
    public gasclass(JTextField cliente, JSlider SLD, JTextField solic, JTextField disp, JTextField queda,
            JSlider sld2,JComboBox tipopag,JTextField precio,JComboBox tipocombustible, JTextField total,
            JTextField todo, JButton mensaje, JRadioButton boleta, JRadioButton factura,JTextField ruc,
            JTextField dni,JTextField razon,JTextField numbol,JTextField numfact){
        this.cliente=cliente;
        this.SLD=SLD;
        this.solic=solic;
        this.disp=disp;
        this.queda=queda;
        this.sld2=sld2;
        this.tipopag=tipopag;
        this.precio=precio;
        this.tipocombustible=tipocombustible;
        this.total=total;
        this.todo=todo;
        this.mensaje=mensaje;
        this.boleta=boleta;
        this.factura=factura;
        this.ruc=ruc;
        this.dni=dni;
        this.razon=razon;
        this.numbol=numbol;
        this.numfact=numfact;
    }
     public void limpieza()
    {
        mensaje.setBackground(new Color(255,255,255));
         mensaje.setText("Atendiendo Cliente");
    }
     public void iluminacionmensaje () {
               
        mensaje.setBackground(new Color(255,255,0));
    }
    public void run(){
        int i = 1;
        int h = autogenerar(30,20);
        Clientes[0]="Harold Hernandez";
        Clientes[1]="Jose Ranilla";
        Clientes[2]="Kathi De La Cruz";
        Clientes[3]="Gian Herrera";
        Clientes[4]="Kattya Cuevas";
        Clientes[5]="Rolando Chavez";
        Clientes[6]="Lino Quispe";
        Clientes[7]="Edgar Peña";
        Clientes[8]="Alvaro Fajardo";
        Clientes[9]="Jerson Aybar";
        razones[0]="Propietario de Empresa";
        razones[1]="Gerente";
        razones[2]="Jefe de Area";
        tipopag.addItem("");
        tipopag.addItem("Efectivo");
        tipopag.addItem("Tarjeta Débito");
        tipopag.addItem("Otros");
        tipocombustible.addItem("");
        tipocombustible.addItem("Diesel Pro");
        tipocombustible.addItem("Gasolina 98 octanos");
        tipocombustible.addItem("Gasolina 97 octanos");
        tipocombustible.addItem("Gasolina 95 octanos");
        tipocombustible.addItem("Gasolina 84 octanos");
        tipocombustible.addItem("GNV"); // gas natural vehicular
        tipocombustible.addItem("GLP"); //gas licuado de petróleo
        tipocombustible.addItem("Petróleo");
        precio.setText("");
        todo.setText(""+0);
        
double recauda=Double.parseDouble(todo.getText());
     
        while(true){
         dni.setText(""+autogenerar(99999999,11111111));
            mensaje.setText("Ha ingresado un nuevo cliente");
            iluminacionmensaje();
            razon.setText(razones[autogenerar(2,0)]);
           int b = autogenerar(2,1);
                if ( b==1) {
                boleta.setEnabled(true);
                boleta.setSelected(true);
                factura.setSelected(false);
                factura.setEnabled(false);
                numbol.setText(""+autogenerar(999999999,100000000));
                numbol.setEnabled(true);
                numfact.setText("");
                numfact.setEnabled(false);
                ruc.setEnabled(false);
                ruc.setText("");
                razon.setEnabled(false);
                razon.setText("");
                
            }else{ 
                factura.setEnabled(true);
                boleta.setSelected(false);
                factura.setSelected(true);
                boleta.setEnabled(false);
                numfact.setText(""+autogenerar(999999999,100000000));
                numbol.setEnabled(false);
                numbol.setText("");
                numfact.setEnabled(true);
                ruc.setEnabled(true);
                ruc.setText(""+autogenerar(9999999,1000000));
                razon.setEnabled(true);
        }
            cliente.setText(Clientes[i-1]);
            
            try{sleep(800);}catch(Exception ex){}
            
            SLD.setValue(i);
            disp.setText("" +h);
            solic.setText(""+autogenerar(9,3));
            tipopag.setSelectedIndex(autogenerar(3,1));
            tipocombustible.setSelectedIndex(autogenerar(7,1));
            
            int indice = tipocombustible.getSelectedIndex();
            switch(indice){
            case 0:
                prc = 0;
                break;
            case 1: 
                prc=14.5;
                break;
            case 2:
                prc=14.05;
                break;
            case 3:
                prc=13.15;
                break;
            case 4:
                prc=12.50;
                break;
            case 5:
                prc=11.35;
                        break;
            case 6:
                prc=6.50;
                      break;
            case 7:
                prc=5.50;
                      break;
            case 8:
                prc=8.9;
                      break;
        }
        precio.setText(""+prc);
            if (Integer.parseInt(disp.getText())<Integer.parseInt(solic.getText())){
                mensaje.setText("Cant. insuficiente le daremos cant. disponible");
                iluminacionmensaje();
                try{sleep(2000);}catch(Exception ex){}
                solic.setText(disp.getText());
            }
            h=Integer.parseInt(disp.getText())-Integer.parseInt(solic.getText());
            queda.setText(""+ h);
            int sol=Integer.parseInt(solic.getText());
            double pago =prc*sol;
            recauda=pago+recauda;
            total.setText(""+pago);
            todo.setText(""+recauda);
         
            limpieza();
            i++;
         
            for(int j=1;j<Integer.parseInt(solic.getText())+1;j++){
                sld2.setValue(j); 
                try{sleep(500);}catch(Exception ex){}
           
            }
            
            try{sleep(2000);}catch(Exception ex){}
            
            if (Integer.parseInt(queda.getText())==0){
                 JOptionPane.showMessageDialog(null,  " Se ha acabado la reserva\n " +
                                                    "\tNO SE ACEPTAN MAS CLIENTES");
                 cliente.setText(" ");
                 solic.setText(" ");
                 total.setText(" ");
                 mensaje.setText("No se aceptan mas clientes");
                 sld2.setValue(1);
                 tipocombustible.setSelectedIndex(0);
                 tipopag.setSelectedIndex(0);
                 disp.setText(String.valueOf(0));
                 precio.setText("");
                 boleta.setSelected(false);
                 factura.setSelected(false);
                 factura.setEnabled(false);
                 boleta.setEnabled(false);  
                 cliente.setEnabled(false);
                 solic.setEnabled(false);
                 total.setEnabled(false);
                 tipocombustible.setEnabled(false);
                 tipopag.setEnabled(false);
                 precio.setEnabled(false);
                 disp.setEnabled(false);
                 sld2.setEnabled(false);
                 ruc.setText("");
                 ruc.setEnabled(false);
                 dni.setText("");
                 dni.setEnabled(false);
                 boleta.setEnabled(false);
                 factura.setEnabled(false);
                 numbol.setText("");
                 numbol.setEnabled(false);
                 numfact.setText("");
                 numfact.setEnabled(false);
                 razon.setText("");
                 razon.setEnabled(false);
                 
               break;
            }
           
        }
    }
    int autogenerar(int max, int min){return (int)((max-min+1)*Math.random()+min);}

}
 