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
    public partial class EliminarPaciente : Form
    {

        EliminarPacienteController controller;
        List<Paciente> resultados;
        public EliminarPaciente()
        {
            controller = new EliminarPacienteController();
            InitializeComponent();
        }

        private void txtContent_TextChanged(object sender, EventArgs e)
        {
            search();
        }

        private void btnMinimizar_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Seguro que quieres salir de la ventana?", "¿Cerrar?",
                MessageBoxButtons.YesNo, MessageBoxIcon.Question,
                MessageBoxDefaultButton.Button1) == System.Windows.Forms.DialogResult.Yes)
            {
                Close();
            }
        }

        private void listView1_MouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                if (MessageBox.Show("Quieres eliminar el paciente?", "Eliminar paciente", MessageBoxButtons.YesNoCancel, MessageBoxIcon.Question) == DialogResult.Yes)
                {
                    Paciente seleccionado = controller.buscar(listView.SelectedItems[0].Text);
                    if (seleccionado != null)
                    {
                        controller.delete(seleccionado);
                        MessageBox.Show("Eliminado el paciente " + seleccionado.Dni, "Eliminado", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    }
                    else
                        MessageBox.Show("No se pudo eliminar " + seleccionado.Dni, "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void search()
        {
            switch (cbxType.SelectedItem.ToString())
            {
                case "DNI":
                    resultados = controller.buscarParcial(txtContent.Text);
                    break;
                case "NHC":
                    if (int.TryParse(txtContent.Text, out int nhc))
                        resultados = controller.buscarParcial(nhc);
                    break;
            }
            loadListView();
        }

        private void loadListView()
        {
            listView.Items.Clear();
            foreach (Paciente p in resultados)
            {
                if (p != null)
                    listView.Items.Add(new ListViewItem(new[] { p.Dni, p.Nhc.ToString(), p.Nombre, p.Apellidos }));
            }
        }
    }
}
