using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using modelo.entity;
namespace WindowsFormsApp1_Test
{
    public partial class MenuPrincipal : Form
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

        User loggedUser;
        MenuPrincipalController controller;

        public MenuPrincipal()
        {
            InitializeComponent();
            loggedUser = User.loggedUser;
            init();
        }

        public void init()
        {
            switch (loggedUser.Role)
            {
                case Role.ADMIN:
                    studentManagerToolStripMenuItem.Visible = true;
                    gamificationManagerToolStripMenuItem.Visible = true;
                    usersManagerToolStripMenuItem.Visible = true;
                    toolStrip.Visible = true;
                    break;
                case Role.TEACHER:
                    studentManagerToolStripMenuItem.Visible = true;
                    gamificationManagerToolStripMenuItem.Visible = true;
                    break;
                case Role.STUDENT:
                    studentManagerToolStripMenuItem.Visible = true;
                    addToolStripMenuItem.Visible = false;
                    deleteToolStripMenuItem.Visible = false;
                    break;
            }
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnMaximize_Click(object sender, EventArgs e)
        {
            if (WindowState == FormWindowState.Maximized)
                WindowState = FormWindowState.Normal;
            else
                WindowState = FormWindowState.Maximized;
        }

        private void btnMinimize_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }

        private void listAllToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FiltrarUsuarios filtrar = new FiltrarUsuarios();
            filtrar.MdiParent = this;
            filtrar.StartPosition = FormStartPosition.CenterScreen;
            filtrar.Show();
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            new CrearUsuario().ShowDialog();
        }

        private void deleteAUserToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new EliminarUsuario().ShowDialog();
        }

        private void modifyAUserToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                new EditarUsuario().ShowDialog();
            } catch (Exception ex)
            {

            }
        }
    }
}
