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
    }
}
