/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import co.com.quipux.ColegioQuipux.models.entity.AdministradorEntity;
import co.com.quipux.ColegioQuipux.models.entity.EstudianteEntity;
import co.com.quipux.ColegioQuipux.models.entity.ProfesorEntity;
import co.com.quipux.ColegioQuipux.models.dto.SesionDto;
import co.com.quipux.ColegioQuipux.dao.impl.AdministradorDaoImpl;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JButtonArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JComboboxArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JTextFieldHint;
import co.com.quipux.ColegioQuipux.util.Tiempo;
import co.com.quipux.ColegioQuipux.util.Colores;
import co.com.quipux.ColegioQuipux.util.Fonts;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sebas
 */
public class Pnl_registrosAd extends JPanel implements ActionListener{
    protected Control_Instancias pp;
    protected int width, heigth;
    /*JLABLE ARJE*/
    private JLabelArje lbl_titulo,lbl_codigo,lbl_nombre,lbl_apellidos,lbl_numeroDocumento,
        lbl_fechaNacimiento,lbl_sexo,lbl_ciudad,lbl_direccion,lbl_telefono,
        lbl_celular,lbl_correo,lbl_clave;
    /*JTextField*/
    private JTextFieldHint txt_Codigo,txt_nombre,txt_apellidos,txt_numeroDocumento,
        txt_fechaNacimiento,txt_direccion,txt_telefono,txt_celular,txt_correo,txt_clave;
    /*JCOMBOARJE*/
    private JComboboxArje cbx_tipoDocumento,cbx_sexo,cbx_ciudad;
        String[] TipoDocumento={"TI","CC"};
        String[] sexo={"Masculino","Femenino","Indefinido"};
        String[] ciudad={"Medellín","Bogotá","Armenia","Cali","Barranquilla","Cartagena",
            "Soledad","Cúcuta","Soacha"};
        String[] grados={"6","7","8","9","10","11"};
        String sexoItem,sexoEnviar;
        /* Departamento, país, y ciudad.*/
    /*JBUTTONARJE*/
    private JButtonArje btn_enviar;
    
    /*CODIGO*/
    Tiempo t = new  Tiempo();
    AdministradorDaoImpl dao = new AdministradorDaoImpl();
    
    public Pnl_registrosAd(Control_Instancias instancias,int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        pp=instancias;
        
        Arrays.sort(ciudad);
        
        lbl_titulo=new JLabelArje();
            lbl_titulo.setTexto("Sección: Registro - Administrador", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
            
        lbl_codigo=new JLabelArje();
            lbl_codigo.setTexto("Código: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_codigo);
            
        lbl_nombre=new JLabelArje();
            lbl_nombre.setTexto("Nombres: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_nombre);
            
        lbl_apellidos=new JLabelArje();
            lbl_apellidos.setTexto("Apellidos: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_apellidos);
            
        lbl_numeroDocumento=new JLabelArje();
            lbl_numeroDocumento.setTexto("Número documento: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_numeroDocumento);
            
        lbl_fechaNacimiento=new JLabelArje();
            lbl_fechaNacimiento.setTexto("Fecha de nacimiento: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_fechaNacimiento);    
            
        lbl_sexo=new JLabelArje();
            lbl_sexo.setTexto("Sexo: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_sexo);
            
        lbl_ciudad=new JLabelArje();
            lbl_ciudad.setTexto("Ciudad: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_ciudad);
            
        lbl_direccion=new JLabelArje();
            lbl_direccion.setTexto("Dirección: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_direccion);
            
        lbl_telefono=new JLabelArje();
            lbl_telefono.setTexto("Teléfono: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_telefono);
            
        lbl_celular=new JLabelArje();
            lbl_celular.setTexto("Celular: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_celular);
            
        lbl_correo=new JLabelArje();
            lbl_correo.setTexto("Correo: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_correo);
            
        lbl_clave=new JLabelArje();
            lbl_clave.setTexto("clave: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_clave);
        
        txt_Codigo = new JTextFieldHint(1);
            txt_Codigo.setHint(Integer.toString(dao.getCodigoAdministrador()));
            txt_Codigo.setEditable(false);
            this.add(txt_Codigo);   
            
        txt_nombre=new JTextFieldHint();
            txt_nombre.setHint("Nombres");
            this.add(txt_nombre);
            
        txt_apellidos=new JTextFieldHint();
            txt_apellidos.setHint("Apellidos");
            this.add(txt_apellidos);
            
        cbx_tipoDocumento=new JComboboxArje(TipoDocumento);
            this.add(cbx_tipoDocumento);
            
        txt_numeroDocumento=new JTextFieldHint();
            txt_numeroDocumento.setHint("#Documento");
            this.add(txt_numeroDocumento);
            
        txt_fechaNacimiento=new JTextFieldHint();
            txt_fechaNacimiento.setHint("DD/MM/AA");
            this.add(txt_fechaNacimiento);
            
        cbx_sexo=new JComboboxArje(sexo);
            this.add(cbx_sexo);
            
        cbx_ciudad=new JComboboxArje(ciudad);
            this.add(cbx_ciudad);
            
        txt_direccion=new JTextFieldHint();
            txt_direccion.setHint("Car ## AB ## - ### (apartamenteto ##)");
            this.add(txt_direccion);
            
        txt_telefono=new JTextFieldHint();
            txt_telefono.setHint("2521389");
            this.add(txt_telefono);
            
        txt_celular=new JTextFieldHint();
            txt_celular.setHint("5551113333");
            this.add(txt_celular);
            
        txt_correo=new JTextFieldHint();
            txt_correo.setHint("Ejemplo@gmail.com");
            this.add(txt_correo);
            
        txt_clave=new JTextFieldHint();
            txt_clave.setHint("Clave");
            this.add(txt_clave);
            
        btn_enviar=new JButtonArje("Enviar", 1, 16, 1, Colores.pantone319C, Colores.pantone276C);
            btn_enviar.addActionListener(this);
            this.add(btn_enviar);
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Colores.blanco);
        
        setSize(width,heigth);
        
        lbl_titulo.setBounds(10, 0, 500, 25);
        int x=20;
        
        lbl_codigo.setBounds(x, 50, 150, 25);
        txt_Codigo.setBounds(x, 75, 150, 25);
        
        lbl_nombre.setBounds(x, txt_Codigo.getY()+25, 150, 25);
        txt_nombre.setBounds(x, txt_Codigo.getY()+50, 150, 25);
        lbl_apellidos.setBounds(x+txt_nombre.getWidth()+10, txt_Codigo.getY()+25, 150, 25);
        txt_apellidos.setBounds(x+txt_nombre.getWidth()+10, txt_Codigo.getY()+50, 150, 25);
        
        cbx_tipoDocumento.setLocation(x, txt_nombre.getY()+45);
        lbl_numeroDocumento.setBounds(x+cbx_tipoDocumento.getWidth()+10, txt_nombre.getY()+25, 150, 25);
        txt_numeroDocumento.setBounds(x+cbx_tipoDocumento.getWidth()+10, txt_nombre.getY()+50, 150, 25);
        
        lbl_fechaNacimiento.setBounds(x, txt_numeroDocumento.getY()+25, 150, 25);
        txt_fechaNacimiento.setBounds(x, txt_numeroDocumento.getY()+50, 150, 25);
        lbl_sexo.setBounds(x+txt_fechaNacimiento.getWidth()+10, txt_numeroDocumento.getY()+25, 150, 25);
        cbx_sexo.setLocation(x+txt_fechaNacimiento.getWidth()+10, txt_numeroDocumento.getY()+45);
        
        lbl_ciudad.setBounds(x, cbx_sexo.getY()+35, 150, 25);
        cbx_ciudad.setLocation(x, cbx_sexo.getY()+60);
        lbl_direccion.setBounds(x+lbl_ciudad.getWidth()+10, cbx_sexo.getY()+35, 150, 25);
        txt_direccion.setBounds(x+lbl_ciudad.getWidth()+10, cbx_sexo.getY()+65, 300, 25);
        
        lbl_telefono.setBounds(x, cbx_ciudad.getY()+35, 150, 25);
        txt_telefono.setBounds(x, cbx_ciudad.getY()+60, 150, 25);
        lbl_celular.setBounds(x+txt_telefono.getWidth()+10, cbx_ciudad.getY()+35, 150, 25);
        txt_celular.setBounds(x+txt_telefono.getWidth()+10, cbx_ciudad.getY()+60, 150, 25);
        
        lbl_correo.setBounds(x, txt_celular.getY()+25, 300, 25);
        txt_correo.setBounds(x, txt_celular.getY()+50, 300, 25);
        
        lbl_clave.setBounds(x, txt_correo.getY()+25, 150, 25);
        txt_clave.setBounds(x, txt_correo.getY()+55, 150, 25);
        
        btn_enviar.setBounds(x, txt_clave.getY()+150, 150, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_enviar){
            
            AdministradorDaoImpl dao = new AdministradorDaoImpl();
            
            AdministradorEntity admin=new AdministradorEntity();
            
            sexoItem=(String)cbx_sexo.getSelectedItem();
            sexoEnviar=sexoItem.substring(0, 1);
            System.out.println("Sexo: "+sexoItem+" Sexo a enviar: "+sexoEnviar);
            
            String tipoDoc=(String)cbx_tipoDocumento.getSelectedItem();
            String ciu=(String)cbx_ciudad.getSelectedItem();
            
            /*es.setCodigo(txt_Codigo.getText());
            es.setNombre(txt_nombre.getText());
            es.setApellido(txt_apellidos.getText());
            es.setTipoDocumento(tipoDoc);
            es.setNumeroDocumento(txt_numeroDocumento.getText());
            es.setFechaNacimiento(txt_fechaNacimiento.getText());
            es.setSexo(sexoEnviar);
            es.setCiudad(ciu);
            es.setDireccion(txt_direccion.getText());
            es.setTelefono(txt_celular.getText());
            es.setCelular(txt_celular.getText());
            es.setCorreo(txt_correo.getText());
            es.setClave(txt_clave.getText());
            es.setEstado("1");*/
            
            if(dao.registrarAdministrador(admin)){
                JOptionPane.showMessageDialog(null, "Datos Correcos","Aviso",JOptionPane.INFORMATION_MESSAGE);
                txt_Codigo.setText(Integer.toString(dao.getCodigoAdministrador()));
            }else{
                JOptionPane.showMessageDialog(null, "Datos incorrectos, revise la información de nuevo por favor","Mensaje Error",JOptionPane.ERROR_MESSAGE);    
            }
            
        }
        
    }
}
