package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.*;
import com.toedter.calendar.JCalendar;

public class Principal extends JApplet {

    JCalendar calendario;
    JTextField fecha;

    public void init() {
        calendario = new JCalendar();
        fecha = new JTextField(30);
        JButton b = new JButton("Aceptar");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String año = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
                String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
                String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
                fecha.setText(dia + " de " + mes + " del " + año);
            }

        });
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        JPanel pfecha = new JPanel();
        pfecha.add(new JLabel("Fecha Seleccionada"));
        pfecha.add(fecha);
        pfecha.add(b);
        p.add(pfecha);
        p.add(calendario);
        add(p);
        this.setSize(1920, 1050);
    }
}
