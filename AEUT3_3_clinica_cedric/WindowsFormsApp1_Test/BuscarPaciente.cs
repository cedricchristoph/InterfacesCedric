using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using modelo;
using controlador;
namespace WindowsFormsApp1_Test
{
    public partial class BuscarPaciente : Form
    {

        BuscarPacienteController controller;
        List<Paciente> resultados;

        public BuscarPaciente()
        {
            controller = new BuscarPacienteController();
            InitializeComponent();
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

        private void btnMinimize_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            if (!String.IsNullOrWhiteSpace(txtDni.Text))
            {
                resultados = controller.buscar(txtDni.Text);
                loadListView();
            } else if (!String.IsNullOrWhiteSpace(txtNhc.Text))
            {
                if (int.TryParse(txtNhc.Text, out int nhc))
                {
                    resultados = controller.buscar(nhc);
                    loadListView();
                }
            } else
            {
                resultados = controller.buscar();
                loadListView();
            }
            txtDni.Text = "";
            txtNhc.Text = "";
        }

        private void BuscarPaciente_Load(object sender, EventArgs e)
        {
            resultados = controller.buscar();
            loadListView();
        }

        private void loadListView()
        {
            listView.Items.Clear();
            foreach (Paciente p in resultados)
            {
                if (p != null)
                    listView.Items.Add(new ListViewItem(new[] { p.Dni, p.Nombre, p.Apellidos }));
            }
        }
    }
}
