using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using model.entity;
using model.dao;
using System.Activities;
using System.Runtime.InteropServices;

namespace AppTiendaCedric
{
    public partial class Categorias : Form
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



        List<Button> categoryButtons;
        Login login;
        public Categorias(Login loginForm)
        {
            this.login = loginForm;
            InitializeComponent();
            cargarBotonesCategorias();
        }

        private void cargarBotonesCategorias()
        {
            CategoryDAO dao = new CategoryDAO();
            List<Categoria> categorias = dao.selectAll();

            Point point = new Point(31, 81);
            categoryButtons = new List<Button>();
            foreach (Categoria c in categorias)
            {
                Button btn = new Button();
                btn.Text = c.Descripcion;
                btn.Margin = new Padding(4, 3, 4, 3);
                btn.BackColor = Color.Black;
                btn.Size = new Size(125, 54);
                btn.ForeColor = Color.White;
                btn.Click += categoryButtonClick;
                btn.Location = new Point(point.X, point.Y);
                categoryButtons.Add(btn);
                bodypanel.Controls.Add(btn);
                //btn.Refresh();
                point.Y += 60;
            }
        }

        private void categoryButtonClick(object sender, EventArgs e)
        {
            if (((Button)sender).Text.Equals("man"))
            {
                new CategoriaDetalles().ShowDialog();
            }
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            login.Show();
            Close();
        }
    }
}
