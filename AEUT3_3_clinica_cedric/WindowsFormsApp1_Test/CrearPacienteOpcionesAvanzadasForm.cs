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
using modelo;
namespace WindowsFormsApp1_Test
{
    public partial class CrearPacienteOpcionesAvanzadasForm : Form
    {
        CrearPacienteController controller;
        public CrearPacienteOpcionesAvanzadasForm(CrearPacienteController controller)
        {
            this.controller = controller;
            InitializeComponent();
        }

        private void btnMinimizar_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Seguro que quieres cerrar la ventana?", "¿Cerrar?",
                MessageBoxButtons.YesNo, MessageBoxIcon.Question,
                MessageBoxDefaultButton.Button1) == System.Windows.Forms.DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void btnAddTlf_Click(object sender, EventArgs e)
        {
            if (txtAddTlf.MaskCompleted)
            {
                listViewTelefonos.Items.Add(txtAddTlf.Text);
            }
        }

        private void CrearPacienteOpcionesAvanzadasForm_Load(object sender, EventArgs e)
        {
            txtNombre.Text = controller.PacienteCreado.Nombre + " " + controller.PacienteCreado.Apellidos;
        }

        private void btnCrear_Click(object sender, EventArgs e)
        {
            
            if (txtFechaNacimiento.MaskCompleted)
            {
                bool ok = int.TryParse(txtNumAsegurado.Text, out int numAsegurado);
                if (ok)
                    if (controller.actualizarPaciente(txtFechaNacimiento.Text, cbxSexo.SelectedItem.Equals("Hombre"),
                    txtProfecion.Text, txtEmail.Text, txtTlf.Text, listViewTelefonos.Items.Cast<ListViewItem>().Select(item => item.Text).ToList(),
                    txtAlergias.Text, txtEnfermedades.Text, cbxGrupoSanguineo.SelectedItem.ToString(), txtEntidadSanitaria.Text,
                    numAsegurado))
                    {
                        if (controller.guardar())
                            MessageBox.Show("Se guardó el paciente correctamente", "Guardado", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        else
                            MessageBox.Show("Ocurrió un error al guardar el paciente", "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    } else
                    {
                        MessageBox.Show("Ocurrió un error al intentar actualizar el objeto. Asegúrese de que todos los datos tienen el formato correcto", "ADVERTENCIA", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    }
                else
                    MessageBox.Show("Asegúrese que el valor de Numero Asegurado sea numérico", "ADVERTENCIA" , MessageBoxButtons.OK, MessageBoxIcon.Warning);
            } else
            {
                MessageBox.Show("Asegúrese que el valor de Fecha de Nacimiento sea correcto", "ADVERTENCIA", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }
    }
}
