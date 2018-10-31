package cl.clubhipico.clubhipico_jcvargas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClubHipicoTestFinalJava7 extends JFrame implements ActionListener {

    private JLabel nombreLabel;       // etiqueta o texto no editable
    private JTextField nombreText;    // caja de texto, para insertar datos
    private JButton boton;            // boton con una determinada accion
    private JButton boton2;           // boton con una determinada accion
    private JButton botonExam;        // boton con una determinada accion
    private JButton botonExit;        // boton con una determinada accion
    private JTextArea consola;        //texto area de salida - simil consola
    
    public ClubHipicoTestFinalJava7() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentanaFinal();        // configuramos la ventana
        inicializarComponentesFinal();   // inicializamos los atributos o componentes
    }

    private void configurarVentanaFinal() {
        this.setTitle("Carga y creación de archivos");           // colocamos titulo a la ventana
        this.setSize(600, 500);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentesFinal() {
        // creamos los componentes
        nombreLabel = new JLabel();
        nombreText = new JTextField();
        boton = new JButton();
        boton2 = new JButton();
        botonExam = new JButton();
        botonExit = new JButton();
        consola = new JTextArea();
        // configuramos los componentes
        nombreLabel.setText("Ruta Archivo");    // colocamos un texto a la etiqueta
        nombreLabel.setBounds(50, 50, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        nombreText.setBounds(130, 50, 200, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        boton.setText("Cargar Archivo BD.");   // colocamos un texto al boton
        boton.setBounds(50, 130, 150, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        boton2.setText("Crear archivos csv");   // colocamos un texto al boton
        boton2.setBounds(250, 130, 150, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton2.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        botonExam.setText("Examinar");   // colocamos un texto al boton
        botonExam.setBounds(340, 45, 100, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        botonExam.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        botonExit.setText("Salir");   // colocamos un texto al boton
        botonExit.setBounds(505, 420, 80, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        botonExit.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
        // adicionamos los componentes a la ventana
        this.add(nombreLabel);
        this.add(nombreText);
        this.add(boton);
        this.add(boton2);
        this.add(botonExam);
        this.add(botonExit);
        this.add(consola);
        
        consola.setBounds(50, 180, 450, 270);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	if (e.getSource()==boton) {
    		
    		if (!nombreText.getText().equals("")) {
    			consola.append("\n"+"Control Final Curso Java 7"+"\n");
    			consola.append("\n"+"Cargando archivo, espere..."+"\n");
    			JOptionPane.showMessageDialog(this, "Se realizara carga de archivo...");    // mostramos un mensaje (frame, mensaje)
		        
		        ClubHipicoCargaArchivoFinal ca = new ClubHipicoCargaArchivoFinal();
		        try {
					consola.append(ca.CargaArchivo(nombreText.getText()));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        consola.append("\n"+"Archivo ya grabado en BD..."+"\n");
    		} else {
    			consola.append("Debe ingresar archivo a cargar...."+"\n");
    		}

    	}	
    	if (e.getSource()==boton2) {
    		if (!nombreText.getText().equals("")) {
	    		JOptionPane.showMessageDialog(this, "Se crearan archivos CSV a partir de BD...");
	    		ClubHipicoCreaArchivoFinal crea = new ClubHipicoCreaArchivoFinal();
	    		try {
					crea.creaArchivo();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		consola.append("\n"+"Archivos ya generados..."+"\n");
    		} else {
    			consola.append("Debe cargar archivo en BD..."+"\n");
    		}
    	}
    	if (e.getSource()==botonExam) {
    		consola.setText("");
            JFileChooser buscarArchivo = new JFileChooser();
            buscarArchivo.showOpenDialog(buscarArchivo);
	        String patch = buscarArchivo.getSelectedFile().getAbsolutePath();
	        nombreText.setText(patch);
    	}    	
    	if (e.getSource()==botonExit) {
    		JOptionPane.showMessageDialog(this, "Finalizará su programa...");
    		System.exit(0);
    	}
    }

    public static void main(String[] args) {
    	ClubHipicoTestFinalJava7 swing = new ClubHipicoTestFinalJava7();      // creamos una ventana
    	swing.setVisible(true);             // hacemos visible la ventana creada
    }
}