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
namespace AppTiendaCedric
{
    public partial class ViewElement : Form
    {
        Element element;
        public ViewElement(Element element)
        {
            this.element = element;
            InitializeComponent();
            load();
        }

        private void load()
        {
            selectedElement1.setId(element.Id.ToString());
            selectedElement1.setName(element.Name);
            selectedElement1.setCategory(element.Category);
            selectedElement1.setQuantity(element.Quantity.ToString());
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
