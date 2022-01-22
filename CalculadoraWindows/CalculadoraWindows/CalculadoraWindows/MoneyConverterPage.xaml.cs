using Model;
using System;
using System.Collections.Generic;
using System.IO;
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
    /// Lógica de interacción para MoneyConverterPage.xaml
    /// </summary>
    public partial class MoneyConverterPage : Page
    {

        private Dictionary<string, Currency> currencies;
        CurrencyConverter converter = new CurrencyConverter();

        private bool Aselected = true;

        public MoneyConverterPage()
        {
            InitializeComponent();
            loadJson();
        }

        private void loadJson()
        {
            /*
            Currency A = new Currency("EUR", "EUR", 0, "Euro", float.Parse("0,88175741571417"), new DateTime(), float.Parse("1,1340987693197"));
            Currency B = new Currency("GPB", "GPB", 0, "Pound", float.Parse("0,73626994858886"), new DateTime(), float.Parse("1,3581974952483"));
            CurrencyConverter converter = new CurrencyConverter();
            converter.setACurrency(A);
            converter.setBCurrency(B);
            converter.addToAValue("4");
            Console.WriteLine("Value A: " + converter.AVal);
            Console.WriteLine(converter.convert() + " " + B.Name);
            */

            string json = File.ReadAllText("D:\\Programs\\Git\\Repositorios\\InterfacesCedric\\CalculadoraWindows\\CalculadoraWindows\\CalculadoraWindows\\usd.json");
            currencies = Newtonsoft.Json.JsonConvert.DeserializeObject<Dictionary<string, Currency>>(json);
            cbxCurrencyA.Items.Add(Currency.USD.Name + " (" + Currency.USD.AlphaCode + ")");
            cbxCurrencyB.Items.Add(Currency.USD.Name + " (" + Currency.USD.AlphaCode + ")");
            foreach (KeyValuePair<string, Currency> entry in currencies)
            {
                Currency c = entry.Value;
                cbxCurrencyA.Items.Add(c.Name + "(" + c.AlphaCode + ")");
                cbxCurrencyB.Items.Add(c.Name + "(" + c.AlphaCode + ")");
            }
            cbxCurrencyA.SelectedIndex = 1;
            cbxCurrencyB.SelectedIndex = 2;
        }

        private void addCharacterButtonClick(object sender, RoutedEventArgs e)
        {
            converter.addToAValue((string)((Button)sender).Content);
            refreshTexts();
        }

        private void removeOneChar(object sender, RoutedEventArgs e)
        {
            converter.removeLastNumb();
            refreshTexts();
        }

        private void clearStringNumber(object sender, RoutedEventArgs e)
        {
            converter.clear();
            refreshTexts();
        }

        private void cbxCurrencyA_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            string selected = cbxCurrencyA.SelectedItem.ToString();
            selected = selected.Split('(')[1];
            selected = selected.Replace(")", "");
            Console.WriteLine("Selected: " + selected);
            foreach (KeyValuePair<string, Currency> entry in currencies)
            {
                if (entry.Value.AlphaCode.Equals(selected))
                {
                    converter.setACurrency(entry.Value);
                    refreshTexts();
                    return;
                }
            }
        }

        private void cbxCurrencyB_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            string selected = cbxCurrencyB.SelectedItem.ToString();
            selected = selected.Split('(')[1];
            selected = selected.Replace(")", "");

            foreach (KeyValuePair<string, Currency> entry in currencies)
            {
                if (entry.Value.AlphaCode.Equals(selected))
                {
                    converter.setBCurrency(entry.Value);
                    refreshTexts();
                    return;
                }
            }
            
        }

        private void refreshTexts()
        {
            try
            {
                AValue.Text = converter.AVal + " " + converter.ACurrency1.AlphaCode;
            } catch (NullReferenceException e)
            {

            }
                try
            {
                BValue.Text = converter.convert() + " " + converter.BCurrency1.AlphaCode;

            } catch (NullReferenceException e)
            {

            }
        }
    }
}
