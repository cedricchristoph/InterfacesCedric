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
using Model;
namespace CalculadoraWindows
{
    /// <summary>
    /// Lógica de interacción para CalculadoreNumerosPage.xaml
    /// </summary>
    public partial class CalculadoreNumerosPage : Page
    {

        NumberCalculator calc;

        public CalculadoreNumerosPage()
        {
            InitializeComponent();
            calc = new NumberCalculator();
        }

        private void addCharacterButtonClick(object sender, RoutedEventArgs e)
        {
            calc.addToNumber((string)((Button)sender).Content);
            showStringNumber();
        }

        private void showStringNumber()
        {
            resultBlock.Text = calc.StringNumber();
        }

        private void showLastOperationString()
        {
            lastOperationBlock.Text = calc.getLastOperationString();
        }

        private void showResultOperationString()
        {

        }

        private void setOperationButtonClick(object sender, RoutedEventArgs e)
        {
            if (calc.Actual.NumberA != 0)
            {
                calc.establishNumber(false);
            } else
            {
                calc.establishNumber(true);
            }
            switch ((string)((Button)sender).Content)
            {
                case "+":
                    calc.setOperation(Operation.PLUS);
                    break;
                case "−":
                    calc.setOperation(Operation.MINUS);
                    break;
                case "×":
                    calc.setOperation(Operation.MULTIPLY);
                    break;
                case "÷":
                    calc.setOperation(Operation.DIVIDE);
                    break;
            }
            showLastOperationString();
            showStringNumber();
        }

        public void runEquals()
        {
            resultBlock.Text = calc.calculate() + "";
            showLastOperationString();
        }

        private void equals(object sender, RoutedEventArgs e)
        {
            calc.establishNumber(false);
            runEquals();
        }
    }
}
