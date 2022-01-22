using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace CalculadoraWindows
{
    /// <summary>
    /// Lógica de interacción para Menu.xaml
    /// </summary>
    public partial class MyMenu : Page
    {

        private MainWindow parent;

        public MyMenu(MainWindow parent)
        {
            InitializeComponent();
            this.parent = parent;
        }

        private void showStandard(object sender, RoutedEventArgs e)
        {
            parent.showStandardCalc();
        }

        private void showMonedas(object sender, RoutedEventArgs e)
        {
            parent.showMoneyConverter();
        }
    }
}
