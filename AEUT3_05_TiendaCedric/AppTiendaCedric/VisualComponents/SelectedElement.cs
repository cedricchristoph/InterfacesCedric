using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace VisualComponents
{
    public partial class SelectedElement : UserControl
    {
        public SelectedElement()
        {
            InitializeComponent();
        }

        public void setId(string id)
        {
            this.id.Text = id;
        }
        public void setName(string name)
        {
            this.name.Text = name;
        }
        public void setCategory(string cat)
        {
            category.Text = cat;
        }
        public void setQuantity(string quant)
        {
            quantity.Text = quant;
        }

    }
}
