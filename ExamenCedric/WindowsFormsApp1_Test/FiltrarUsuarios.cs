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
    public partial class FiltrarUsuarios : Form
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

        public static User selectedUser;

        FiltrarUsuariosController controller;
        public FiltrarUsuarios()
        {
            InitializeComponent();
            controller = new FiltrarUsuariosController();
            foreach (Role role in Roles.ROLES)
            {
                cbxRoles.Items.Add(Roles.toString(role));
            }
            Location = new Point(100, 1500);
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void cbxRoles_SelectedIndexChanged(object sender, EventArgs e)
        {
            listView.Clear();
            List<User> users = controller.filterUsersByRol(cbxRoles.SelectedItem.ToString());
            foreach (User u in users)
            {
                listView.Items.Add(u.Username + ",  " + Roles.toString(u.Role) + ",  " + u.Active.ToString());
            }
            listView.Refresh();
        }

        private void listView_ItemSelectionChanged(object sender, ListViewItemSelectionChangedEventArgs e)
        {
            string[] split = listView.SelectedItems[0].Text.Split(',');
            UserDAO dao = new UserDAO();
            selectedUser = dao.selectById(split[0]);
        }

        private void listView_Click(object sender, EventArgs e)
        {
            string[] split = listView.SelectedItems[0].Text.Split(',');
            UserDAO dao = new UserDAO();
            selectedUser = dao.selectById(split[0]);
        }
    }
}
