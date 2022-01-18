using modelo.entity;
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


    public partial class EliminarUsuario : Form
    {

        public const int WM_NCLBUTTONDOWN = 0xA1;
        public const int HT_CAPTION = 0x2;

        [System.Runtime.InteropServices.DllImport("user32.dll")]
        public static extern int SendMessage(IntPtr hWnd, int Msg, int wParam, int lParam);
        [System.Runtime.InteropServices.DllImport("user32.dll")]
        public static extern bool ReleaseCapture();

        private void panel2_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                ReleaseCapture();
                SendMessage(Handle, WM_NCLBUTTONDOWN, HT_CAPTION, 0);
            }
        }

        EliminarUsuariosController controller;
        List<User> usuarios;
        public EliminarUsuario()
        {
            InitializeComponent();
            controller = new EliminarUsuariosController();
            reloadTreeView();
        }

        private void reloadTreeView()
        {
            treeview.Nodes.Clear();
            usuarios = controller.getAllUsers();
            foreach (User u in usuarios)
            {
                treeview.Nodes.Add(u.Username);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string username = null;
            try
            {
                username = treeview.SelectedNode.Text;
            } catch (NullReferenceException ex) { 
            
            }
            if (username != null)
            {
                DialogResult dialogResult = System.Windows.Forms.MessageBox.Show("¿Está seguro que quiere eliminar el usuario " + username + " ? ", "¿Seguro ?", MessageBoxButtons.YesNo);
                if (dialogResult == DialogResult.Yes)
                {
                    if (controller.eliminarUsuario(username))
                    {
                        reloadTreeView();
                    } else
                    {
                        new MessageBox("ERROR", "No se pudo eliminar el usuario").ShowDialog();
                    }
                }
            }
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
