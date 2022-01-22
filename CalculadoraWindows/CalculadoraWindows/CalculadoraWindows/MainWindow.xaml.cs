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
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public MainWindow()
        {
            InitializeComponent();
            showStandardCalc();
        }

        public void showStandardCalc()
        {
            frame.Content = new CalculadoreNumerosPage();
        }

        public void showMoneyConverter()
        {
            frame.Content = new MoneyConverterPage();
        }

        private void onMinimize(object sender, RoutedEventArgs e)
        {

        }

        private void onMaximize(object sender, RoutedEventArgs e)
        {

        }

        private void onClose(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void onMaximizeRestore(object sender, RoutedEventArgs e)
        {

        }

        private void switchMenuView(object sender, RoutedEventArgs e)
        {
            frame.Content = new MyMenu(this);
        }
    }
}
