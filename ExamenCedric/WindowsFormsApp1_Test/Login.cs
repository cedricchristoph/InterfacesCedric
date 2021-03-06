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

namespace WindowsFormsApp1_Test
{
    public partial class Login : Form
    {
        public const int WM_NCLBUTTONDOWN = 0xA1;
        public const int HT_CAPTION = 0x2;

        [System.Runtime.InteropServices.DllImport("user32.dll")]
        public static extern int SendMessage(IntPtr hWnd, int Msg, int wParam, int lParam);
        [System.Runtime.InteropServices.DllImport("user32.dll")]
        public static extern bool ReleaseCapture();

        private bool showPassword = false;
        
        MainLoginController controller;
        public Login()
        {
            this.SetStyle(ControlStyles.ResizeRedraw, true);
            controller = new MainLoginController();
            InitializeComponent();
        }

        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }

        private void panel2_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                ReleaseCapture();
                SendMessage(Handle, WM_NCLBUTTONDOWN, HT_CAPTION, 0);
            }


        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (WindowState == FormWindowState.Maximized)
                WindowState = FormWindowState.Normal;
            else
                WindowState = FormWindowState.Maximized;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (!showPassword)
            {
                showPassword = true;
                txtPassword.PasswordChar = '\0';
                btnLock.BackgroundImage = Properties.Resources.hide;
            } else
            {
                showPassword = false;
                txtPassword.PasswordChar = '•';
                btnLock.BackgroundImage = Properties.Resources.show;
            }
        }

        private void btnAcceder_Click(object sender, EventArgs e)
        {
            autenticar();
        }

        private void autenticar()
        {
                if (controller.authenticate(txtUser.Text, txtPassword.Text))
                {
                    new MenuPrincipal().Show();
                    Hide();
                } else
                {
                    new MessageBox("Credenciales incorrectos", "Usuario y/o contraseña no son correctos. Compruebe sus entradas e inténtelo de nuevo.").ShowDialog();
                    txtUser.Text = "";
                    txtPassword.Text = "";
                }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            new MessageBox("Versión Alpha", "Esta versión de la aplicación es una ALPHA. La aplicación esta en construcción").ShowDialog();
        }

        private void txtUser_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyValue == 13)
                autenticar();
        }
    }
}
