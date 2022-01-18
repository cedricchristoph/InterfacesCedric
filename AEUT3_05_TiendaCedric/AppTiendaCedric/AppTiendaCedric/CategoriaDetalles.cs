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
using model.dao;
using model.entity;
namespace AppTiendaCedric
{
    public partial class CategoriaDetalles : Form
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

        string selectedId;

        public CategoriaDetalles()
        {
            InitializeComponent();
            reloadAll();
        }

        private void reloadAll()
        {
            reloadFilterType(new ManDAO(true));
            reloadTable(new ManDAO(true));
        }

        private void reloadFilterType(ManDAO dao)
        {
            cbxFilter.Items.Clear();
            cbxFilter.Items.AddRange(dao.selectCategories());
            cbxFilter.Items.Add("ALL");
            cbxFilter.SelectedItem = "ALL";
        }

        private void reloadTable(ManDAO dao)
        {
            try
            {
                if (cbxFilter.SelectedItem.ToString().Equals("ALL"))
                    dataGrid.DataSource = dao.selectAll();
                else
                    dataGrid.DataSource = dao.selectByCategory(cbxFilter.SelectedItem.ToString());
            }
            catch (Exception) { }
            
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (WindowState == FormWindowState.Maximized)
                WindowState = FormWindowState.Normal;
            else
                WindowState = FormWindowState.Maximized;
        }

        private void cbxFilter_SelectedIndexChanged(object sender, EventArgs e)
        {
            reloadTable(new ManDAO(true));
        }

        private void btnView_Click(object sender, EventArgs e)
        {
            try
            {
                Element element = new ManDAO().selectById(int.Parse(selectedId));
                if (element == null) return;
                new ViewElement(element).ShowDialog();
            } catch (Exception ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
        }

        private void dataGrid_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            selectedId = ((int)dataGrid.Rows[e.RowIndex].Cells[0].Value).ToString();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            try
            {
                Element element = new ManDAO().selectById(int.Parse(selectedId));
                if (element == null) return;
                new Add(element).ShowDialog();
                reloadTable(new ManDAO());
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
        }
    }
}
