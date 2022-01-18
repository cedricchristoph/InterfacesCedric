using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using controller;
namespace AppTiendaCedric
{
    public partial class Login : Form
    {
        public const int WM_NCLBUTTONDOWN = 0xA1;
        public const int HT_CAPTION = 0x2;

        [DllImportAttribute("user32.dll")]
        public static extern int SendMessage(IntPtr hWnd, int Msg, int wParam, int lParam);
        [DllImportAttribute("user32.dll")]
        public static extern bool ReleaseCapture();

        private void topPanel_MouseDown(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                ReleaseCapture();
                SendMessage(Handle, WM_NCLBUTTONDOWN, HT_CAPTION, 0);
            }
        }


        LoginController controller;

        public Login()
        {
            InitializeComponent();
            controller = new LoginController();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            bool ok = int.TryParse(txtUser.Text, out int user);
            if (ok)
            {
                if (controller.login(user, txtPassword.Text))
                {
                    Hide();
                    clearBoxes();
                    new Categorias(this).Show();
                } else
                {
                    clearBoxes();
                    MessageBox.Show("Usuario y/o contraseña errónea", "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            } else
            {
                clearBoxes();
                MessageBox.Show("El formato del usuario es erróneo. Por favor solo introduzca valores numéricos", "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnExit_MouseDown(object sender, MouseEventArgs e)
        {
            btnExit.ForeColor = Color.White;
        }

        private void btnExit_MouseUp(object sender, MouseEventArgs e)
        {
            btnExit.ForeColor = Color.FromArgb(64, 64, 64);
        }

        private void btnExit_MouseLeave(object sender, EventArgs e)
        {
            btnExit.ForeColor = Color.FromArgb(64, 64, 64);
        }

        private void clearBoxes()
        {
            txtUser.Text = "";
            txtPassword.Text = "";
        }
    }
}
