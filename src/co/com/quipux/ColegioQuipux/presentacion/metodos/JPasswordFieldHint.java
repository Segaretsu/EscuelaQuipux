/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.metodos;

import co.com.quipux.ColegioQuipux.presentacion.util.Colores;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class JPasswordFieldHint extends JPasswordField implements FocusListener{
    private final Font fontLost = new Font("Lato", Font.BOLD, 17);
    private final Font fontGained = new Font("Lato", Font.BOLD, 18);
    private final Color colorLost = Color.LIGHT_GRAY;
    private final Color colorGained = Color.BLACK;
    private String hint;
 
    @SuppressWarnings("LeakingThisInConstructor")
    public JPasswordFieldHint() {
        addFocusListener(this);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colores.pantone276C));
    }
 
    public void setHint(String hint) {
        setForeground(colorLost);
        setFont(fontLost);
        setText(hint);
        this.hint = hint;
    }
 
    public String getHint() {
        return hint;
    }
    
    
    
    @Override
    public void focusGained(FocusEvent fe) {
        if (getText().equals(getHint())) {
            setText("");
            setFont(fontGained);
            setForeground(colorGained);
            setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Colores.pantone276C));
        } else {
            setForeground(colorGained);
            setFont(fontGained);
            setText(getText());
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if (getText().length() <= 0) {
            setHint(getHint());
            setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colores.pantone276C));
        } else {
            setForeground(colorGained);
            setFont(fontGained);
            setText(getText());
        }
    }
    
}
