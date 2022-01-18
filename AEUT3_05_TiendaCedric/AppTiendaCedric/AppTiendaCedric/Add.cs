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
    public partial class Add : Form
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




        Element element;
        int quantity;
        public Add(Element element)
        {
            this.element = element;
            InitializeComponent();
        }

        private void btnConfirm_Click(object sender, EventArgs e)
        {
            if (!checkValidOperation())
            {
                MessageBox.Show("No hay suficiente Stock del item", "Out of stock", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            } else
            {
                BasketDAO baskets = new BasketDAO();
                ManDAO manDao = new ManDAO();
                baskets.insert(new Basket(element.Id, element.Name, (element.Price * quantity)));
                element.Quantity -= quantity;
                manDao.update(element);
                MessageBox.Show("Compra realizada");
                Close();
            }
        }

        private bool checkValidOperation()
        {
            if (!int.TryParse(txtQuantity.Text, out int cantidad)) return false;
            if (element.Quantity < cantidad) return false;
            quantity = cantidad;
            return true;
        }
    }
}
