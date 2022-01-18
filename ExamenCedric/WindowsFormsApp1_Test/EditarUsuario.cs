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
    public partial class EditarUsuario : Form
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

        private User selectedUser;
        public EditarUsuario()
        {
            InitializeComponent();
            selectedUser = FiltrarUsuarios.selectedUser;
            if (selectedUser == null)
            {
                new MessageBox("Ninguna seleccion", "No ha seleccionado ningun usuario a editar previamente").ShowDialog();
                Close();
            }
            else
            {
                init();
            }
        }

        private void init()
        {
            txtUser.Text = selectedUser.Username;
            txtPassword.Text = selectedUser.Password;
            cbxRoles.SelectedItem = Roles.toString(selectedUser.Role);
        }

        private void btnAcceder_Click(object sender, EventArgs e)
        {
            // Comprobamos entradas
            if (!String.IsNullOrWhiteSpace(txtUser.Text) &&
                !String.IsNullOrWhiteSpace(txtPassword.Text) &&
                !String.IsNullOrEmpty(cbxRoles.SelectedItem.ToString()))
            {
                UserDAO dao = new UserDAO();
                if (dao.update(selectedUser))
                {
                    new MessageBox("Usuario actualizado", "Se ha actualizado correctamente el usuario " + txtUser.Text).ShowDialog();
                    Close();
                }
                else
                {
                    new MessageBox("Error", "No se pudo actualizar el usuario");
                }
            }
        }
    }
}
