using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1_Test
{
    public partial class PersonalAdministrativoForm : Form
    {
        public PersonalAdministrativoForm()
        {
            InitializeComponent();
            // Create the ToolTip and associate with the Form container.
            ToolTip toolTip1 = new ToolTip();

            // Set up the delays for the ToolTip.
            toolTip1.AutoPopDelay = 5000;
            toolTip1.InitialDelay = 1000;
            toolTip1.ReshowDelay = 500;
            // Force the ToolTip text to be displayed whether or not the form is active.
            toolTip1.ShowAlways = true;

            // Set up the ToolTip text for the Button and Checkbox.
            toolTip1.SetToolTip(btnExit, "Salir del programa");
        }

        private void menuItemPacientes_Click(object sender, EventArgs e)
        {
            toolStripPacientesImg.Visible = !toolStripPacientesImg.Visible;
        }

        private void enConstruccion(string text)
        {
            MessageBox.Show("Esto se encuentra en construcción. Has clicado en " + text);
        }

        private void centroDeDíaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            enConstruccion("centro de dia");
        }

        private void citaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            enConstruccion("cita");
        }

        private void guardarActividadToolStripMenuItem_Click(object sender, EventArgs e)
        {
            enConstruccion("guardar actividad");
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Seguro que quieres salir del programa?", "¿Cerrar?",
                MessageBoxButtons.YesNo, MessageBoxIcon.Question,
                MessageBoxDefaultButton.Button1) == System.Windows.Forms.DialogResult.Yes)
            {
                System.Windows.Forms.Application.Exit();
            }
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            new CrearPacienteForm().ShowDialog();
        }

        private void btnMinimize_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            new BuscarPaciente().ShowDialog();
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            new EliminarPaciente().ShowDialog();
        }
    }
}
