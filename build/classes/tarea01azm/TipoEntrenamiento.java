/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea01azm;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;


/**
 * Interfaz ara la recogida de datos del entrenamiento
 *
 * @author Alexandre Zerva Moreno
 */
public class TipoEntrenamiento extends javax.swing.JDialog {

    private int MouseX, MouseY;
    private final int MAX_SESIONES = 30;
    boolean datavalid;
    StringBuilder report = new StringBuilder();

    /**
     * Creates new form TipoEntrenamiento
     *
     * @param parent
     * @param modal
     */
    public TipoEntrenamiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(this);
        //Libreria para escalar las imágenes
        rsscalelabel.RSScaleLabel.setScaleLabel(te_imagenLogo, "src/resources/logo.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(headerLogoFormulario, "src/resources/logo1.png");

        setIconImage(getIconImage());

        //Restricciones de caracteres en las cajas de jTextField
        RestrictedTextField restrictedCodigo = new RestrictedTextField(this.tf_codigo);
        restrictedCodigo.setOnlyNums(true);

        RestrictedTextField restrictedTelefono = new RestrictedTextField(this.tf_telefono);
        restrictedTelefono.setOnlyNums(true);

        RestrictedTextField restrictedNombreEntrenamiento = new RestrictedTextField(this.tf_nombre_entrenamiento);
        restrictedNombreEntrenamiento.setOnlyAlphaNumeric(true);
        restrictedNombreEntrenamiento.setAcceptSpace(true);
        restrictedNombreEntrenamiento.setLimit(20);

        RestrictedTextField restrictedNombreInstructor = new RestrictedTextField(this.tf_nombre_instructor);
        restrictedNombreInstructor.setOnlyAlphaNumeric(true);
        restrictedNombreInstructor.setAcceptSpace(true);
        restrictedNombreInstructor.setLimit(30);

        //Establecemos el formato de hora en el Spinner
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner_fecha, "dd/MM/yyyy");
        spinner_fecha.setEditor(dateEditor);

        //Seleccionamos tipo de entrenamiento por defecto
//        rbMuscular.setSelected(true);
        //Establecemos pago mensual por defecto
//        rbMensual.setSelected(true);
        //Inabilitamos por defecto la posibilidad de seleccionar número de sesiones
        cantidadSesiones.setEnabled(false);

        //Rellenamos la lista con la cantidad de sesiones disponibles
        for (int x = 0; x <= MAX_SESIONES; x++) {
            cantidadSesiones.addItem(x);
        }

//        //Establecemos el precio incial en 0
        tf_precio.setText("0.00");
        labelMonedaTipo.setText("€");

        //Establecemos el radioButton Sala Fitness seleccionado por defecto
//        rbSalaFitness.setSelected(true);
//        // Damos formato al campo PRECIO
//        // https://es.scribd.com/doc/75632135/Usos-Interesantes-de-JFormattedTextField
//        // Formato de visualización
//        NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
//        // Formato de edición: inglés (separador decimal: el punto)
//        //DecimalFormat decimalFormat = new DecimalFormat("0.00");
//        NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
//        // Para la edición, no queremos separadores de millares
//        editFormat.setGroupingUsed(false);
//        // Creamos los formateadores de números
//        NumberFormatter dFormat = new NumberFormatter(dispFormat);
//        NumberFormatter eFormat = new NumberFormatter(editFormat);
//        // Creamos la factoría de formateadores especificando los
//        // formateadores por defecto, de visualización y de edición
//        DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dFormat, dFormat, eFormat);
//        eFormat.setOverwriteMode(true);
//        // El formateador de edición admite caracteres incorrectos
//        eFormat.setAllowsInvalid(false);
//        //eFormat.setCommitsOnValidEdit(true);
//        if (rbSesion.isSelected()) {
//            eFormat.setMaximum(99.99);
//            jFormattedPrecio.setToolTipText("El precio no puede superar los 99.99€");
//        } else if(rbMensual.isSelected() || rbBono.isSelected()) {
//            eFormat.setMaximum(999.99);
//            jFormattedPrecio.setToolTipText("El precio no puede superar los 999.99€");
//        }
//        eFormat.setMinimum(0.00);
//        // Asignamos la factoría al campo
//        jFormattedPrecio.setFormatterFactory(currFactory);
//        jFormattedPrecio.setValue(new Double(0));
    }

    private Image getIconImage() {
        Image image = Toolkit.getDefaultToolkit().getImage(ClassLoader
                .getSystemResource("resources/logo.png"));
        return image;
    }

    private void hideShowTipoEntrenamiento() {
        if (rbMuscular.isSelected() || rbFisico.isSelected()) {
            cbCore.setEnabled(true);
            cbTrenInf.setEnabled(true);
            cbTrenSup.setEnabled(true);
            cbTronco.setEnabled(true);
        } else {
            cbCore.setEnabled(false);
            cbTrenInf.setEnabled(false);
            cbTrenSup.setEnabled(false);
            cbTronco.setEnabled(false);
            cbCore.setSelected(false);
            cbTrenInf.setSelected(false);
            cbTrenSup.setSelected(false);
            cbTronco.setSelected(false);
        }
    }

    private void formaDePago() {
        if (rbBono.isSelected()) {
            cantidadSesiones.setEnabled(true);
        } else {
            cantidadSesiones.setEnabled(false);
        }
    }

    private boolean verifyData() {
        String datoError = "Rellene el campo: ";
        Date dia = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(dia);

        if (tf_codigo.getText().isEmpty()) {
            setError(tf_codigo);
            JOptionPane.showMessageDialog(rootPane, datoError + "Código");
            datavalid = false;
        } else if (tf_nombre_entrenamiento.getText().isEmpty()) {
            setError(tf_nombre_entrenamiento);
            JOptionPane.showMessageDialog(rootPane, datoError + "Nombre entrendor");
            datavalid = false;
        } else if (tf_telefono.getText().isEmpty() || tf_telefono.getText().length() != 9) {
            setError(tf_telefono);
            JOptionPane.showMessageDialog(rootPane, datoError + "Teléfono incorrecto");
            datavalid = false;
        } else if (tf_nombre_instructor.getText().isEmpty()) {
            setError(tf_nombre_instructor);
            JOptionPane.showMessageDialog(rootPane, datoError + "Nombre del instructor");
            datavalid = false;
        } else if (spinner_fecha.equals(fecha)) {//No se si es correcto, pero es la única manera que me deja continuar
            JOptionPane.showMessageDialog(rootPane, datoError + "Introduzca la fecha actual");
            datavalid = false;
        } else {
            datavalid = true;
        }

        return datavalid;
    }

    private boolean verifyEntrenamientoTipo() {

        if (!rbMuscular.isSelected() && !rbFuncional.isSelected() && !rbFuerza.isSelected()
                && !rbCrossfit.isSelected() && !rbRunning.isSelected() && !rbFisico.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un tipo de entrenamiento.");
            datavalid = false;
        } else if ((rbMuscular.isSelected()) && (!cbTrenInf.isSelected() && !cbTrenSup.isSelected()
                && !cbTronco.isSelected() && !cbCore.isSelected())) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione zona de entrenamiento.");
            datavalid = false;
        } else if (rbFisico.isSelected() && (!cbTrenInf.isSelected() && !cbTrenSup.isSelected()
                && !cbTronco.isSelected() && !cbCore.isSelected())) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione zona de entrenamiento.");
            datavalid = false;
        } else {
            datavalid = true;
        }

        return datavalid;
    }

    private boolean verifyFormaPago() {
        //Capturamos el item seleccionado en el JComboBox
        int sesiones = cantidadSesiones.getSelectedIndex();

        if (!rbMensual.isSelected() && !rbBono.isSelected() && !rbSesion.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una forma de pago.");
            datavalid = false;
        } else if (rbBono.isSelected() && sesiones == 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione la cantidad de sesiones que desea.");
            datavalid = false;
        } else {
            datavalid = true;
        }

        return datavalid;
    }

    private boolean verifySelectMachines() {

        String maquinas = "Seleccione las máquinas de entrenamiento necesarias.";

        if (!rbSalaFitness.isSelected() && !rbSalaCross.isSelected() && !rbSalaMusculacion.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una sala de entrenamiento.");
            datavalid = false;
        } else if (rbSalaFitness.isSelected() && (!cbCinta.isSelected() && !cbBici.isSelected()
                && !cbMultifuncion.isSelected() && !cbPalancas.isSelected()
                && !cbPlacas.isSelected() && !cbBancos.isSelected())) {
            JOptionPane.showMessageDialog(rootPane, maquinas);
            datavalid = false;
        } else if (rbSalaCross.isSelected() && (!cbPalancas.isSelected()
                && !cbPlacas.isSelected())) {
            JOptionPane.showMessageDialog(rootPane, maquinas);
            datavalid = false;
        } else if (rbSalaMusculacion.isSelected() && (!cbMultifuncion.isSelected()
                && !cbBancos.isSelected())) {
            JOptionPane.showMessageDialog(rootPane, maquinas);
            datavalid = false;
        } else {
            datavalid = true;
        }

        return datavalid;

    }

    private boolean verifyPrice() {
        final double PRECIO_MAX_SESIONS = 100.00;
        final double PRECIO_MAX = 1000.00;
        final double PRECIO_INICIAL = 0.00;

        double precio = Double.parseDouble(tf_precio.getText());

        if (rbMensual.isSelected() && (precio >= PRECIO_MAX)) {
            JOptionPane.showMessageDialog(rootPane, "Los pagos Mensuales no pueden tener un precio superior a 999.99€");
            tf_precio.setText("00.00");
            setError(tf_precio);
            datavalid = false;
        } else if (rbBono.isSelected() && (precio >= PRECIO_MAX)) {
            JOptionPane.showMessageDialog(rootPane, "El precio del Bono no puede tener un precio superior a 999.99€");
            tf_precio.setText("00.00");
            setError(tf_precio);
            datavalid = false;
        } else if (rbSesion.isSelected() && (precio >= PRECIO_MAX_SESIONS)) {
            JOptionPane.showMessageDialog(rootPane, "El precio de las Sesiones no puede tener un precio superior a 99.99€");
            tf_precio.setText("00.00");
            setError(tf_precio);
            datavalid = false;
        } else if (precio == PRECIO_INICIAL) {
            JOptionPane.showMessageDialog(rootPane, "Introduzca el importe del entrenamiento.");
            setError(tf_precio);
            datavalid = false;
        } else {
            datavalid = true;
        }

        return datavalid;
    }

    private void setError(JTextField textField) {
        if (textField.getText().isEmpty()) {
            textField.setBorder(BorderFactory.createLineBorder(Color.RED, 3, true));
        }
    }

    private void showHideSalaMaquinas() {
        if (rbSalaFitness.isSelected()) {
            cbCinta.setEnabled(true);
            cbBici.setEnabled(true);
            cbMultifuncion.setEnabled(true);
            cbPalancas.setEnabled(true);
            cbPlacas.setEnabled(true);
            cbBancos.setEnabled(true);
            cbCinta.setSelected(false);
            cbBici.setSelected(false);
            cbMultifuncion.setSelected(false);
            cbPalancas.setSelected(false);
            cbPlacas.setSelected(false);
            cbBancos.setSelected(false);
        } else if (rbSalaCross.isSelected()) {
            cbCinta.setEnabled(false);
            cbBici.setEnabled(false);
            cbMultifuncion.setEnabled(false);
            cbPalancas.setEnabled(true);
            cbPlacas.setEnabled(true);
            cbBancos.setEnabled(false);
            cbCinta.setSelected(false);
            cbBici.setSelected(false);
            cbMultifuncion.setSelected(false);
            cbPalancas.setSelected(false);
            cbPlacas.setSelected(false);
            cbBancos.setSelected(false);
        } else if (rbSalaMusculacion.isSelected()) {
            cbCinta.setEnabled(false);
            cbBici.setEnabled(false);
            cbMultifuncion.setEnabled(true);
            cbPalancas.setEnabled(false);
            cbPlacas.setEnabled(false);
            cbBancos.setEnabled(true);
            cbCinta.setSelected(false);
            cbBici.setSelected(false);
            cbMultifuncion.setSelected(false);
            cbPalancas.setSelected(false);
            cbPlacas.setSelected(false);
            cbBancos.setSelected(false);
        }
    }

    private void dataDefaultState() {
        tf_codigo.setText("");
        tf_nombre_entrenamiento.setText("");
        tf_telefono.setText("");
        tf_nombre_instructor.setText("");
        cbCore.setSelected(false);
        cbTrenInf.setSelected(false);
        cbTrenSup.setSelected(false);
        cbTronco.setSelected(false);
        cbCinta.setSelected(false);
        cbBici.setSelected(false);
        cbMultifuncion.setSelected(false);
        cbPalancas.setSelected(false);
        cbPlacas.setSelected(false);
        cbBancos.setSelected(false);
        rbBono.setSelected(false);
        rbCrossfit.setSelected(false);
        rbFisico.setSelected(false);
        rbFuerza.setSelected(false);
        rbFuncional.setSelected(false);
        rbMensual.setSelected(false);
        rbMuscular.setSelected(false);
        rbRunning.setSelected(false);
        rbSalaCross.setSelected(false);
        rbSalaFitness.setSelected(false);
        rbSalaMusculacion.setSelected(false);
        rbSesion.setSelected(false);
        tf_precio.setText("");

    }

    private String report() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(spinner_fecha.getValue());
        
        report.append("Datos Entrenamiento:\n");
        report.append("Código: " + tf_codigo.getText() + "\n");
        report.append("Nombre entrenamiento: " + tf_nombre_entrenamiento.getText() + "\n");
        report.append("Teléfono: " + tf_telefono.getText() + "\n");
        report.append("Fecha registro: " + fecha + "\n\n");

        report.append("Datos Entrenamiento:\n");
        report.append("Nombre instructor: " + tf_nombre_instructor.getText() + "\n");
        report.append("Tipo entrenamiento: ");
        if (rbMuscular.isSelected()) {
            report.append("Muscular\n");
        } else if (rbFisico.isSelected()) {
            report.append("Físico\n");
        } else if (rbCrossfit.isSelected()) {
            report.append("Crossfit\n");
        } else if (rbFuncional.isSelected()) {
            report.append("Funcional\n");
        } else if (rbFuerza.isSelected()) {
            report.append("Fuerza\n");
        } else if (rbRunning.isSelected()) {
            report.append("Running\n");
        }

        report.append("   Zona de trabajo:");
        if (cbTrenSup.isSelected()) {
            report.append("  Tren Superior\n");
        } else if (cbTrenInf.isSelected()) {
            report.append("   Tren Inferior\n");
        } else if (cbTronco.isSelected()) {
            report.append("   Tronco\n");
        } else if (cbCore.isSelected()) {
            report.append("   Core\n");
        } else {
            report.append("   sin datos\n");
        }

        report.append("\nForma de pago: ");
        if (rbMensual.isSelected()) {
            report.append("Mensual\n");
        } else if (rbBono.isSelected()) {
            report.append("Bono\n");
        } else if (rbSesion.isSelected()) {
            report.append("Sesión\n");
        }
        if (rbBono.isSelected()) {
            report.append("Sesiones: " + cantidadSesiones.getSelectedItem().toString() + "\n");
        }

        report.append("\nSelección de las salas de entrenamiento:\n");
        report.append("Sala entrenamiento: ");
        if (rbSalaFitness.isSelected()) {
            report.append("Fitness\n");
        } else if (rbSalaCross.isSelected()) {
            report.append("Cross\n");
        } else if (rbSalaMusculacion.isSelected()) {
            report.append("Musculación\n");
        }
        report.append("Maquina/s seleccionada/s: \n");
        if (cbCinta.isSelected()) {
            report.append("   Cinta\n");
        }
        if (cbBici.isSelected()) {
            report.append("   Bicicleta\n");
        }
        if (cbPalancas.isSelected()) {
            report.append("   Palancas\n");
        }
        if (cbPlacas.isSelected()) {
            report.append("   Placas\n");
        }
        if (cbBancos.isSelected()) {
            report.append("   Bancos\n");
        }
        if (cbMultifuncion.isSelected()) {
            report.append("   Multifunción\n");
        }

        report.append("\nPrecio entrenamiento:\n");
        report.append("Precio: " + tf_precio.getText() + "€\n\n");

        return report.toString();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgselectEntrenamiento = new javax.swing.ButtonGroup();
        bgFormaPago = new javax.swing.ButtonGroup();
        bgSalas = new javax.swing.ButtonGroup();
        te_logoPanel = new javax.swing.JPanel();
        te_gym = new javax.swing.JLabel();
        te_empresaNombre = new javax.swing.JLabel();
        te_imagenLogo = new javax.swing.JLabel();
        te_formularioPanel = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        headerLogoFormulario = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        panelDatos = new javax.swing.JPanel();
        labelNombreEntrenamiento = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        tf_telefono = new javax.swing.JTextField();
        tf_nombre_entrenamiento = new javax.swing.JTextField();
        spinner_fecha = new javax.swing.JSpinner();
        tf_codigo = new javax.swing.JTextField();
        panelEntrenamientos = new javax.swing.JPanel();
        labelInstructor = new javax.swing.JLabel();
        tf_nombre_instructor = new javax.swing.JTextField();
        labelTipoEntrenamiento = new javax.swing.JLabel();
        rbMuscular = new javax.swing.JRadioButton();
        rbFisico = new javax.swing.JRadioButton();
        rbRunning = new javax.swing.JRadioButton();
        rbFuncional = new javax.swing.JRadioButton();
        rbFuerza = new javax.swing.JRadioButton();
        rbCrossfit = new javax.swing.JRadioButton();
        labelZonaEntrenamiento = new javax.swing.JLabel();
        cbTrenSup = new javax.swing.JCheckBox();
        cbTrenInf = new javax.swing.JCheckBox();
        cbTronco = new javax.swing.JCheckBox();
        cbCore = new javax.swing.JCheckBox();
        panelFormadePago = new javax.swing.JPanel();
        labelFormadePago = new javax.swing.JLabel();
        rbSesion = new javax.swing.JRadioButton();
        rbBono = new javax.swing.JRadioButton();
        rbMensual = new javax.swing.JRadioButton();
        labelNumSesions = new javax.swing.JLabel();
        cantidadSesiones = new javax.swing.JComboBox();
        panelSalas = new javax.swing.JPanel();
        LabelSelectSala = new javax.swing.JLabel();
        rbSalaFitness = new javax.swing.JRadioButton();
        rbSalaMusculacion = new javax.swing.JRadioButton();
        rbSalaCross = new javax.swing.JRadioButton();
        labelSelectMachine = new javax.swing.JLabel();
        cbCinta = new javax.swing.JCheckBox();
        cbBici = new javax.swing.JCheckBox();
        cbPlacas = new javax.swing.JCheckBox();
        cbPalancas = new javax.swing.JCheckBox();
        cbMultifuncion = new javax.swing.JCheckBox();
        cbBancos = new javax.swing.JCheckBox();
        panelPrecio = new javax.swing.JPanel();
        labelMonedaTipo = new javax.swing.JLabel();
        tf_precio = new javax.swing.JTextField();
        labelPrecio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        te_logoPanel.setBackground(new java.awt.Color(0, 31, 84));

        te_gym.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        te_gym.setForeground(new java.awt.Color(255, 255, 255));
        te_gym.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        te_gym.setText("Gimnasio ");

        te_empresaNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        te_empresaNombre.setForeground(new java.awt.Color(255, 255, 255));
        te_empresaNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        te_empresaNombre.setText("Al - Andalus");

        javax.swing.GroupLayout te_logoPanelLayout = new javax.swing.GroupLayout(te_logoPanel);
        te_logoPanel.setLayout(te_logoPanelLayout);
        te_logoPanelLayout.setHorizontalGroup(
            te_logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(te_logoPanelLayout.createSequentialGroup()
                .addGroup(te_logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(te_logoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(te_imagenLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(te_empresaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(te_logoPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(te_gym, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(299, 299, 299))
        );
        te_logoPanelLayout.setVerticalGroup(
            te_logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(te_logoPanelLayout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(te_gym, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(te_imagenLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(te_empresaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        getContentPane().add(te_logoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 1000));

        te_formularioPanel.setBackground(new java.awt.Color(51, 204, 255));
        te_formularioPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(0, 31, 84));
        btnSalir.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        te_formularioPanel.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 930, 103, 44));

        btnGuardar.setBackground(new java.awt.Color(0, 31, 84));
        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        te_formularioPanel.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 880, 103, 44));
        te_formularioPanel.add(headerLogoFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 100));

        labelTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Datos nuevo entrenamiento");
        te_formularioPanel.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, 100));

        labelCodigo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelCodigo.setForeground(new java.awt.Color(255, 102, 102));
        labelCodigo.setText("Código: ");
        te_formularioPanel.add(labelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 60, 20));

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Entrenamiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatos.setFont(new java.awt.Font("Comic Sans MS", 3, 16)); // NOI18N
        panelDatos.setOpaque(false);

        labelNombreEntrenamiento.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelNombreEntrenamiento.setForeground(new java.awt.Color(255, 102, 102));
        labelNombreEntrenamiento.setText("Nombre entrenamiento: ");

        labelTelefono.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelTelefono.setForeground(new java.awt.Color(255, 102, 102));
        labelTelefono.setText("Teléfono de contacto: ");

        labelFecha.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 102, 102));
        labelFecha.setText("Fecha de inicio: ");

        tf_telefono.setBackground(new java.awt.Color(51, 204, 255));
        tf_telefono.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        tf_telefono.setToolTipText("Teléfono de contacto");
        tf_telefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 31, 84), 2, true));
        tf_telefono.setOpaque(false);
        tf_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_telefonoKeyTyped(evt);
            }
        });

        tf_nombre_entrenamiento.setBackground(new java.awt.Color(51, 204, 255));
        tf_nombre_entrenamiento.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        tf_nombre_entrenamiento.setToolTipText("Introduzca el nombre del entrenamiento");
        tf_nombre_entrenamiento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 31, 84), 2, true));
        tf_nombre_entrenamiento.setOpaque(false);
        tf_nombre_entrenamiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_nombre_entrenamientoKeyTyped(evt);
            }
        });

        spinner_fecha.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        spinner_fecha.setModel(new javax.swing.SpinnerDateModel());
        spinner_fecha.setToolTipText("Fecha inicio del registro");
        spinner_fecha.setOpaque(false);

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(labelNombreEntrenamiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nombre_entrenamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTelefono)
                            .addComponent(labelFecha))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinner_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreEntrenamiento)
                    .addComponent(tf_nombre_entrenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(tf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFecha)
                    .addComponent(spinner_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spinner_fecha.getAccessibleContext().setAccessibleDescription("dd/MM/yyyy");

        te_formularioPanel.add(panelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 480, 160));

        tf_codigo.setBackground(new java.awt.Color(51, 204, 255));
        tf_codigo.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        tf_codigo.setToolTipText("Inserte código");
        tf_codigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 31, 84), 2, true));
        tf_codigo.setOpaque(false);
        tf_codigo.setSelectedTextColor(new java.awt.Color(51, 204, 255));
        tf_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_codigoKeyTyped(evt);
            }
        });
        te_formularioPanel.add(tf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 60, 30));

        panelEntrenamientos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo Entrenamiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        panelEntrenamientos.setOpaque(false);

        labelInstructor.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelInstructor.setForeground(new java.awt.Color(255, 102, 102));
        labelInstructor.setText("Instructor: ");

        tf_nombre_instructor.setBackground(new java.awt.Color(51, 204, 255));
        tf_nombre_instructor.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        tf_nombre_instructor.setToolTipText("Nombre del Instructor de los entrenamientos");
        tf_nombre_instructor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 31, 84), 2, true));
        tf_nombre_instructor.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_nombre_instructor.setOpaque(false);
        tf_nombre_instructor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_nombre_instructorKeyTyped(evt);
            }
        });

        labelTipoEntrenamiento.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelTipoEntrenamiento.setForeground(new java.awt.Color(255, 102, 102));
        labelTipoEntrenamiento.setText("Tipo de Entrenamiento: ");

        bgselectEntrenamiento.add(rbMuscular);
        rbMuscular.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbMuscular.setText("Muscular");
        rbMuscular.setOpaque(false);
        rbMuscular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMuscularActionPerformed(evt);
            }
        });

        bgselectEntrenamiento.add(rbFisico);
        rbFisico.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbFisico.setText("Físico");
        rbFisico.setOpaque(false);
        rbFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFisicoActionPerformed(evt);
            }
        });

        bgselectEntrenamiento.add(rbRunning);
        rbRunning.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbRunning.setText("Running");
        rbRunning.setOpaque(false);
        rbRunning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRunningActionPerformed(evt);
            }
        });

        bgselectEntrenamiento.add(rbFuncional);
        rbFuncional.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbFuncional.setText("Funcional");
        rbFuncional.setOpaque(false);
        rbFuncional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFuncionalActionPerformed(evt);
            }
        });

        bgselectEntrenamiento.add(rbFuerza);
        rbFuerza.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbFuerza.setText("Fuerza");
        rbFuerza.setOpaque(false);
        rbFuerza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFuerzaActionPerformed(evt);
            }
        });

        bgselectEntrenamiento.add(rbCrossfit);
        rbCrossfit.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbCrossfit.setText("Crossfit");
        rbCrossfit.setOpaque(false);
        rbCrossfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCrossfitActionPerformed(evt);
            }
        });

        labelZonaEntrenamiento.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelZonaEntrenamiento.setForeground(new java.awt.Color(255, 102, 102));
        labelZonaEntrenamiento.setText("Seleccione la zona de trabajo:");

        cbTrenSup.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbTrenSup.setText("Tren Superior");
        cbTrenSup.setOpaque(false);
        cbTrenSup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTrenSupMouseClicked(evt);
            }
        });

        cbTrenInf.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbTrenInf.setText("Tren Inferior");
        cbTrenInf.setOpaque(false);
        cbTrenInf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTrenInfMouseClicked(evt);
            }
        });

        cbTronco.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbTronco.setText("Tronco");
        cbTronco.setOpaque(false);
        cbTronco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTroncoMouseClicked(evt);
            }
        });

        cbCore.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbCore.setText("Core");
        cbCore.setOpaque(false);
        cbCore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCoreMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelEntrenamientosLayout = new javax.swing.GroupLayout(panelEntrenamientos);
        panelEntrenamientos.setLayout(panelEntrenamientosLayout);
        panelEntrenamientosLayout.setHorizontalGroup(
            panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntrenamientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelZonaEntrenamiento)
                    .addComponent(labelTipoEntrenamiento)
                    .addGroup(panelEntrenamientosLayout.createSequentialGroup()
                        .addComponent(labelInstructor)
                        .addGap(18, 18, 18)
                        .addComponent(tf_nombre_instructor, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEntrenamientosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTrenSup)
                            .addComponent(cbTrenInf)
                            .addGroup(panelEntrenamientosLayout.createSequentialGroup()
                                .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbMuscular)
                                    .addComponent(rbFuerza))
                                .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelEntrenamientosLayout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbCore)
                                            .addComponent(cbTronco))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntrenamientosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbCrossfit)
                                            .addComponent(rbFisico))
                                        .addGap(62, 62, 62)))
                                .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbRunning, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbFuncional))
                                .addGap(12, 12, 12)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEntrenamientosLayout.setVerticalGroup(
            panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntrenamientosLayout.createSequentialGroup()
                .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInstructor)
                    .addComponent(tf_nombre_instructor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTipoEntrenamiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEntrenamientosLayout.createSequentialGroup()
                        .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbFuncional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbMuscular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbRunning)
                            .addComponent(rbFuerza))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelZonaEntrenamiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTrenSup)
                            .addComponent(cbTronco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEntrenamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTrenInf)
                            .addComponent(cbCore))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelEntrenamientosLayout.createSequentialGroup()
                        .addComponent(rbCrossfit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbFisico)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        te_formularioPanel.add(panelEntrenamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 480, 250));

        panelFormadePago.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forma de pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        panelFormadePago.setOpaque(false);

        labelFormadePago.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelFormadePago.setForeground(new java.awt.Color(255, 102, 102));
        labelFormadePago.setText("Forma de pago: ");

        bgFormaPago.add(rbSesion);
        rbSesion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbSesion.setText("Sesión");
        rbSesion.setOpaque(false);
        rbSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSesionActionPerformed(evt);
            }
        });

        bgFormaPago.add(rbBono);
        rbBono.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbBono.setText("Bono");
        rbBono.setOpaque(false);
        rbBono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBonoActionPerformed(evt);
            }
        });

        bgFormaPago.add(rbMensual);
        rbMensual.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbMensual.setText("Mensual");
        rbMensual.setOpaque(false);
        rbMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMensualActionPerformed(evt);
            }
        });

        labelNumSesions.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        labelNumSesions.setForeground(new java.awt.Color(255, 102, 102));
        labelNumSesions.setText("Número de sesiones:");

        javax.swing.GroupLayout panelFormadePagoLayout = new javax.swing.GroupLayout(panelFormadePago);
        panelFormadePago.setLayout(panelFormadePagoLayout);
        panelFormadePagoLayout.setHorizontalGroup(
            panelFormadePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormadePagoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormadePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFormadePago)
                    .addGroup(panelFormadePagoLayout.createSequentialGroup()
                        .addGroup(panelFormadePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNumSesions)
                            .addGroup(panelFormadePagoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(rbMensual)))
                        .addGap(42, 42, 42)
                        .addGroup(panelFormadePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantidadSesiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelFormadePagoLayout.createSequentialGroup()
                                .addComponent(rbBono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addComponent(rbSesion)))))
                .addGap(74, 74, 74))
        );
        panelFormadePagoLayout.setVerticalGroup(
            panelFormadePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormadePagoLayout.createSequentialGroup()
                .addComponent(labelFormadePago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormadePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMensual)
                    .addComponent(rbBono)
                    .addComponent(rbSesion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormadePagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadSesiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumSesions))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        te_formularioPanel.add(panelFormadePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 480, 140));

        panelSalas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ubicación sala", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        panelSalas.setOpaque(false);

        LabelSelectSala.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        LabelSelectSala.setForeground(new java.awt.Color(255, 102, 102));
        LabelSelectSala.setText("Seleccione una Sala:");

        bgSalas.add(rbSalaFitness);
        rbSalaFitness.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbSalaFitness.setText("Sala Fitness");
        rbSalaFitness.setOpaque(false);
        rbSalaFitness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSalaFitnessActionPerformed(evt);
            }
        });

        bgSalas.add(rbSalaMusculacion);
        rbSalaMusculacion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbSalaMusculacion.setText("Sala Musculación");
        rbSalaMusculacion.setOpaque(false);
        rbSalaMusculacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSalaMusculacionActionPerformed(evt);
            }
        });

        bgSalas.add(rbSalaCross);
        rbSalaCross.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbSalaCross.setText("Sala Cross");
        rbSalaCross.setOpaque(false);
        rbSalaCross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSalaCrossActionPerformed(evt);
            }
        });

        labelSelectMachine.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        labelSelectMachine.setForeground(new java.awt.Color(255, 102, 102));
        labelSelectMachine.setText("Seleccione máquinas:");

        cbCinta.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbCinta.setText("Cinta");
        cbCinta.setOpaque(false);

        cbBici.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbBici.setText("Bicicleta");
        cbBici.setOpaque(false);

        cbPlacas.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbPlacas.setText("Placas");
        cbPlacas.setOpaque(false);

        cbPalancas.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbPalancas.setText("Palancas");
        cbPalancas.setOpaque(false);

        cbMultifuncion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbMultifuncion.setText("Multifunción");
        cbMultifuncion.setOpaque(false);

        cbBancos.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbBancos.setText("Bancos");
        cbBancos.setOpaque(false);

        javax.swing.GroupLayout panelSalasLayout = new javax.swing.GroupLayout(panelSalas);
        panelSalas.setLayout(panelSalasLayout);
        panelSalasLayout.setHorizontalGroup(
            panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSalasLayout.createSequentialGroup()
                        .addGroup(panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelSelectSala)
                            .addComponent(labelSelectMachine))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelSalasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSalasLayout.createSequentialGroup()
                                .addComponent(rbSalaFitness)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbSalaCross)
                                .addGap(36, 36, 36)
                                .addComponent(rbSalaMusculacion))
                            .addGroup(panelSalasLayout.createSequentialGroup()
                                .addGroup(panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCinta)
                                    .addComponent(cbPlacas))
                                .addGap(90, 90, 90)
                                .addGroup(panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbBici)
                                    .addComponent(cbBancos))
                                .addGap(79, 79, 79)
                                .addGroup(panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbPalancas)
                                    .addComponent(cbMultifuncion))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelSalasLayout.setVerticalGroup(
            panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalasLayout.createSequentialGroup()
                .addComponent(LabelSelectSala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSalaFitness)
                    .addComponent(rbSalaMusculacion)
                    .addComponent(rbSalaCross))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelSelectMachine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCinta)
                    .addComponent(cbBici)
                    .addComponent(cbPalancas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSalasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPlacas)
                    .addComponent(cbBancos)
                    .addComponent(cbMultifuncion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        te_formularioPanel.add(panelSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 480, 200));

        panelPrecio.setOpaque(false);
        panelPrecio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMonedaTipo.setBackground(new java.awt.Color(51, 204, 255));
        labelMonedaTipo.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        labelMonedaTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelMonedaTipo.setText("€");
        panelPrecio.add(labelMonedaTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 30, 20));

        tf_precio.setBackground(new java.awt.Color(51, 204, 255));
        tf_precio.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        tf_precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_precio.setToolTipText("Precio total del entrenamiento");
        tf_precio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        tf_precio.setOpaque(false);
        tf_precio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_precioMouseClicked(evt);
            }
        });
        panelPrecio.add(tf_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 180, 40));

        labelPrecio.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelPrecio.setForeground(new java.awt.Color(255, 102, 102));
        labelPrecio.setText("Precio: ");
        panelPrecio.add(labelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        te_formularioPanel.add(panelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 870, 260, 100));

        getContentPane().add(te_formularioPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 500, 1000));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        boolean dataEmpty = false;
        Date dia = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(dia);
        int sesiones = cantidadSesiones.getSelectedIndex();
        final double PRECIO_INICIAL = 0.00;
        double precio = Double.parseDouble(tf_precio.getText());

        if (!tf_codigo.getText().isEmpty()) {
            dataEmpty = true;
        }
        if (!tf_nombre_entrenamiento.getText().isEmpty()) {
            dataEmpty = true;
        }
        if (!tf_telefono.getText().isEmpty()) {
            dataEmpty = true;
        }
        if (!tf_nombre_instructor.getText().isEmpty()) {
            dataEmpty = true;
        }
        if ((cbTrenInf.isSelected() || cbTrenSup.isSelected()
                || cbTronco.isSelected() || cbCore.isSelected())) {
            dataEmpty = true;
        }
        if (!spinner_fecha.equals(fecha)) {
            datavalid = true;
        }
        if (rbBono.isSelected() && sesiones > 0) {
            dataEmpty = true;
        }
        if ((cbCinta.isSelected() || cbBici.isSelected()
                || cbMultifuncion.isSelected() || cbPalancas.isSelected()
                || cbPlacas.isSelected() || cbBancos.isSelected()
                || cbTrenInf.isSelected() || cbTrenSup.isSelected()
                || cbTronco.isSelected() || cbCore.isSelected())) {
            dataEmpty = true;
        }
        if (precio > PRECIO_INICIAL) {
            dataEmpty = true;
        }
        if (rbBono.isSelected() || rbCrossfit.isSelected() || rbFisico.isSelected() || rbFuerza.isSelected()
                || rbFuncional.isSelected() || rbMensual.isSelected() || rbMuscular.isSelected()
                || rbRunning.isSelected() || rbSalaCross.isSelected() || rbSalaFitness.isSelected()
                || rbSalaMusculacion.isSelected() || rbSesion.isSelected()) {
            dataEmpty = true;
        }

        int volver;
        if (dataEmpty) {
            volver = JOptionPane.showConfirmDialog(this, "Si sale perderá la información.\n¿Está segura de salir?", "SALIR", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (volver == 0) {
                this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        } else {
            this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }

//        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        //Establecemos las coordenadas del mouse en las variables
        MouseX = evt.getX();
        MouseY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - MouseX, y - MouseY);
    }//GEN-LAST:event_formMouseDragged

    private void tf_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_codigoKeyTyped
        if (tf_codigo.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "Máximo 4 caracteres");
        }
    }//GEN-LAST:event_tf_codigoKeyTyped

    private void tf_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_telefonoKeyTyped
        if (tf_telefono.getText().length() >= 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "Máximo 9 caracteres");
        }
    }//GEN-LAST:event_tf_telefonoKeyTyped

    private void tf_nombre_entrenamientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombre_entrenamientoKeyTyped
        if (tf_nombre_entrenamiento.getText().length() >= 20) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "Máximo 20 caracteres");

        }
    }//GEN-LAST:event_tf_nombre_entrenamientoKeyTyped

    private void tf_nombre_instructorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombre_instructorKeyTyped
        if (tf_nombre_instructor.getText().length() >= 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "Máximo 30 caracteres");
        }
    }//GEN-LAST:event_tf_nombre_instructorKeyTyped

    private void rbCrossfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCrossfitActionPerformed
        hideShowTipoEntrenamiento();
    }//GEN-LAST:event_rbCrossfitActionPerformed

    private void rbMuscularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMuscularActionPerformed
        hideShowTipoEntrenamiento();
    }//GEN-LAST:event_rbMuscularActionPerformed

    private void rbFuncionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFuncionalActionPerformed
        hideShowTipoEntrenamiento();
    }//GEN-LAST:event_rbFuncionalActionPerformed

    private void rbFuerzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFuerzaActionPerformed
        hideShowTipoEntrenamiento();
    }//GEN-LAST:event_rbFuerzaActionPerformed

    private void rbRunningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRunningActionPerformed
        hideShowTipoEntrenamiento();
    }//GEN-LAST:event_rbRunningActionPerformed

    private void rbFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFisicoActionPerformed
        hideShowTipoEntrenamiento();
    }//GEN-LAST:event_rbFisicoActionPerformed

    private void cbTrenSupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTrenSupMouseClicked
        if (cbTrenSup.isSelected()) {
            cbCore.setEnabled(false);
            cbTrenInf.setEnabled(false);
            cbTronco.setEnabled(false);
            cbCore.setSelected(false);
            cbTrenInf.setSelected(false);
            cbTronco.setSelected(false);
        } else {
            cbCore.setEnabled(true);
            cbTrenInf.setEnabled(true);
            cbTronco.setEnabled(true);
        }
    }//GEN-LAST:event_cbTrenSupMouseClicked

    private void cbTrenInfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTrenInfMouseClicked
        if (cbTrenInf.isSelected()) {
            cbCore.setEnabled(false);
            cbTrenSup.setEnabled(false);
            cbTronco.setEnabled(false);
            cbCore.setSelected(false);
            cbTrenSup.setSelected(false);
            cbTronco.setSelected(false);
        } else {
            cbCore.setEnabled(true);
            cbTrenSup.setEnabled(true);
            cbTronco.setEnabled(true);
        }
    }//GEN-LAST:event_cbTrenInfMouseClicked

    private void cbTroncoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTroncoMouseClicked
        if (cbTronco.isSelected()) {
            cbCore.setEnabled(false);
            cbTrenInf.setEnabled(false);
            cbTrenSup.setEnabled(false);
            cbCore.setSelected(false);
            cbTrenInf.setSelected(false);
            cbTrenSup.setSelected(false);
        } else {
            cbCore.setEnabled(true);
            cbTrenInf.setEnabled(true);
            cbTrenSup.setEnabled(true);
        }
    }//GEN-LAST:event_cbTroncoMouseClicked

    private void cbCoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCoreMouseClicked
        if (cbCore.isSelected()) {
            cbTrenSup.setEnabled(false);
            cbTrenInf.setEnabled(false);
            cbTronco.setEnabled(false);
            cbTrenSup.setSelected(false);
            cbTrenInf.setSelected(false);
            cbTronco.setSelected(false);
        } else {
            cbTrenSup.setEnabled(true);
            cbTrenInf.setEnabled(true);
            cbTronco.setEnabled(true);
        }
    }//GEN-LAST:event_cbCoreMouseClicked

    private void rbSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSesionActionPerformed
        formaDePago();
    }//GEN-LAST:event_rbSesionActionPerformed

    private void rbBonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBonoActionPerformed
        formaDePago();
    }//GEN-LAST:event_rbBonoActionPerformed

    private void rbMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMensualActionPerformed
        formaDePago();
    }//GEN-LAST:event_rbMensualActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        int confirmReport;
//        Icon icon = new ImageIcon(getClass().getResource("src/resources/logo1.png"));
        if (verifyData() == true && verifyEntrenamientoTipo() == true && verifyFormaPago() == true
                && verifySelectMachines() == true && verifyPrice() == true) {

            //Se intenta cambiar el color de fondo del JOptioPane sin resultados positivos
//            UIManager.put("OptionPane.backgroung",Color.decode("#303F9F"));
//            UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#303F9F"));
            confirmReport = JOptionPane.showConfirmDialog(rootPane, report(), "Confirme la información seleccionada.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            UIManager.put("OptionPane.backgroung", Color.decode("#303F9F"));
            UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#303F9F"));
            if (confirmReport == 0) {
                JOptionPane.showMessageDialog(this, "Registro realizado.", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);
                dataDefaultState();
                this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }

        }

//        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void rbSalaCrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSalaCrossActionPerformed
        showHideSalaMaquinas();
    }//GEN-LAST:event_rbSalaCrossActionPerformed

    private void rbSalaFitnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSalaFitnessActionPerformed
        showHideSalaMaquinas();
    }//GEN-LAST:event_rbSalaFitnessActionPerformed

    private void rbSalaMusculacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSalaMusculacionActionPerformed
        showHideSalaMaquinas();
    }//GEN-LAST:event_rbSalaMusculacionActionPerformed

    private void tf_precioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_precioMouseClicked
        // TODO add your handling code here:
        tf_precio.setText("");
    }//GEN-LAST:event_tf_precioMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TipoEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TipoEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TipoEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TipoEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(() -> {
//            TipoEntrenamiento dialog = new TipoEntrenamiento(new javax.swing.JFrame(), true);
//            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                @Override
//                public void windowClosing(java.awt.event.WindowEvent e) {
//                    System.exit(0);
//                }
//            });
//            dialog.setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSelectSala;
    private javax.swing.ButtonGroup bgFormaPago;
    private javax.swing.ButtonGroup bgSalas;
    private javax.swing.ButtonGroup bgselectEntrenamiento;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cantidadSesiones;
    private javax.swing.JCheckBox cbBancos;
    private javax.swing.JCheckBox cbBici;
    private javax.swing.JCheckBox cbCinta;
    private javax.swing.JCheckBox cbCore;
    private javax.swing.JCheckBox cbMultifuncion;
    private javax.swing.JCheckBox cbPalancas;
    private javax.swing.JCheckBox cbPlacas;
    private javax.swing.JCheckBox cbTrenInf;
    private javax.swing.JCheckBox cbTrenSup;
    private javax.swing.JCheckBox cbTronco;
    private javax.swing.JLabel headerLogoFormulario;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFormadePago;
    private javax.swing.JLabel labelInstructor;
    private javax.swing.JLabel labelMonedaTipo;
    private javax.swing.JLabel labelNombreEntrenamiento;
    private javax.swing.JLabel labelNumSesions;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelSelectMachine;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTipoEntrenamiento;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelZonaEntrenamiento;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelEntrenamientos;
    private javax.swing.JPanel panelFormadePago;
    private javax.swing.JPanel panelPrecio;
    private javax.swing.JPanel panelSalas;
    private javax.swing.JRadioButton rbBono;
    private javax.swing.JRadioButton rbCrossfit;
    private javax.swing.JRadioButton rbFisico;
    private javax.swing.JRadioButton rbFuerza;
    private javax.swing.JRadioButton rbFuncional;
    private javax.swing.JRadioButton rbMensual;
    private javax.swing.JRadioButton rbMuscular;
    private javax.swing.JRadioButton rbRunning;
    private javax.swing.JRadioButton rbSalaCross;
    private javax.swing.JRadioButton rbSalaFitness;
    private javax.swing.JRadioButton rbSalaMusculacion;
    private javax.swing.JRadioButton rbSesion;
    private javax.swing.JSpinner spinner_fecha;
    private javax.swing.JLabel te_empresaNombre;
    private javax.swing.JPanel te_formularioPanel;
    private javax.swing.JLabel te_gym;
    private javax.swing.JLabel te_imagenLogo;
    private javax.swing.JPanel te_logoPanel;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_nombre_entrenamiento;
    private javax.swing.JTextField tf_nombre_instructor;
    private javax.swing.JTextField tf_precio;
    private javax.swing.JTextField tf_telefono;
    // End of variables declaration//GEN-END:variables

}
