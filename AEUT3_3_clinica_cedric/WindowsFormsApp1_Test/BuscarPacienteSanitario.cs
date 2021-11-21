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
    public partial class BuscarPacienteSanitario : Form
    {

        BuscarPacienteController controller;
        List<Paciente> resultados;

        public BuscarPacienteSanitario()
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
            treeView.Nodes.Clear();
            foreach (Paciente p in resultados)
            {
                if (p != null) {
                    TreeNode node = new TreeNode();
                    TreeNode tlfns = new TreeNode();
                    tlfns.Text = "Otros telefonos";
                    node.Text = p.Nombre + " " + p.Apellidos;
                    node.Nodes.Add("Dni: " + p.Dni);
                    node.Nodes.Add("Nhc: " + p.Nhc);
                    node.Nodes.Add("Direccion: " + p.Direccion);
                    node.Nodes.Add("Poblacion: " + p.Poblacion);
                    node.Nodes.Add("Tlf: " + p.Tlf);
                    foreach (string t in p.OtrosTlf)
                        tlfns.Nodes.Add(t);
                    node.Nodes.Add(tlfns);
                    if (p.Male)
                        node.Nodes.Add("Sexo: Hombre");
                    else
                        node.Nodes.Add("Sexo: Mujer");
                    node.Nodes.Add("Fecha nacimiento: " + new DateTime(p.FechaNacimiento).Date);
                    node.Nodes.Add("Email: " + p.Email);
                    node.Nodes.Add("Profecion: " + p.Profecion);
                    treeView.Nodes.Add(node);
                }
            }
            treeView.Refresh();
        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {

        }
    }
}
