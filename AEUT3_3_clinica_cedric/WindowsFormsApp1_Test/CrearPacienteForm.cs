using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using controlador;

namespace WindowsFormsApp1_Test
{
    public partial class CrearPacienteForm : Form
    {
        CrearPacienteController controller;
        public CrearPacienteForm()
        {
            InitializeComponent();
            controller = new CrearPacienteController();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Seguro que quieres cancelar la creación del paciente?", "¿Cerrar?",
                MessageBoxButtons.YesNo, MessageBoxIcon.Question,
                MessageBoxDefaultButton.Button1) == System.Windows.Forms.DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void btnCrear_Click(object sender, EventArgs e)
        {
            bool nhcValido = int.TryParse(txtNhc.Text, out int nhc);
            if (nhcValido && txtNhc.Text.Length == 10)
            {
                if (controller.crearPaciente(txtDni.Text, txtNombre.Text, txtApellidos.Text, nhc, txtDireccion.Text, txtPoblacion.Text))
                {
                    btnMasOpciones.Enabled = true;
                    DialogResult result = MessageBox.Show("Se estableció la información obligatoria del paciente. \n¿Quiere introducir datos adicionales del paciente?\n\n 'Si' Abre ventana de informacion adicional\n'No' Guarda el paciente",
                        "¿Desea introducir datos adicionales?", MessageBoxButtons.YesNo, MessageBoxIcon.Question, MessageBoxDefaultButton.Button1);
                    if (result == DialogResult.Yes)
                    {
                        new CrearPacienteOpcionesAvanzadasForm(controller).ShowDialog();
                        Close();
                    } else if (result == DialogResult.No)
                    {
                        if (controller.guardar())
                            MessageBox.Show("Se guardó el paciente correctamente", "Guardado", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        else
                            MessageBox.Show("Ocurrió un error al guardar el paciente", "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        Close();
                    }
                } else
                {
                    MessageBox.Show("No se pudo crear el paciente. Compruebe las entradas");
                }
            } else
            {
                MessageBox.Show("El numero NHC no es válido");
            }
                   
        }

        private void btnMinimizar_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }

        private void CrearPacienteForm_Load(object sender, EventArgs e)
        {
            // Create the ToolTip and associate with the Form container.
            ToolTip toolTip1 = new ToolTip();

            // Set up the delays for the ToolTip.
            toolTip1.AutoPopDelay = 5000;
            toolTip1.InitialDelay = 1000;
            toolTip1.ReshowDelay = 500;
            // Force the ToolTip text to be displayed whether or not the form is active.
            toolTip1.ShowAlways = true;

            // Set up the ToolTip text for the Button and Checkbox.
            toolTip1.SetToolTip(this.txtDni, "Dni del paciente");
            toolTip1.SetToolTip(this.txtNombre, "Nombre del paciente");
            toolTip1.SetToolTip(txtApellidos, "Apellidos del paciente");
            toolTip1.SetToolTip(txtNhc, "Numero NHC del paciente");
            toolTip1.SetToolTip(txtPoblacion, "Poblacion del paciente");
            toolTip1.SetToolTip(txtDireccion, "Direccion del paciente");
            toolTip1.SetToolTip(btnCancelar, "Cancelar la creación del paciente");
            toolTip1.SetToolTip(btnExit, "Cancelar la creación del paciente");
            toolTip1.SetToolTip(btnMinimizar, "Minimizar la ventana");
            toolTip1.SetToolTip(btnCrear, "Crear el paciente");
        }

        private void btnMasOpciones_Click(object sender, EventArgs e)
        {
            new CrearPacienteOpcionesAvanzadasForm(controller).ShowDialog();
        }
    }
}
