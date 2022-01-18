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
    public partial class CrearUsuario : Form
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


        public CrearUsuario()
        {
            InitializeComponent();
            init();
        }

        private void init()
        {
            foreach (Role role in Roles.ROLES)
            {
                cbxRoles.Items.Add(Roles.toString(role));
            }
        }
        private void btnExit_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void btnAcceder_Click(object sender, EventArgs e)
        {
            // Comprobamos entradas
            if (!String.IsNullOrWhiteSpace(txtUser.Text) &&
                !String.IsNullOrWhiteSpace(txtPassword.Text) &&
                !String.IsNullOrWhiteSpace(txtRepetirPassword.Text) &&
                !String.IsNullOrEmpty(cbxRoles.SelectedItem.ToString())) 
            {
                if (txtPassword.Text.Equals(txtRepetirPassword.Text))
                {
                    UserDAO dao = new UserDAO();
                    if (dao.insert(new User(txtUser.Text, txtPassword.Text, Roles.parseRole(cbxRoles.SelectedItem.ToString()), true)))
                    {
                        new MessageBox("Usuario creado", "Se ha creado correctamente el usuario " + txtUser.Text).ShowDialog();
                        Close();
                    } else
                    {
                        new MessageBox("Error", "No se pudo crear el usuario");
                    }
                } else
                {
                    new MessageBox("Formulario incompleto", "Las contraseñas no coinciden");
                }
            } else
            {
                new MessageBox("Missing data", "Faltan datos por introducir").ShowDialog();
            }
        }
    }
}
