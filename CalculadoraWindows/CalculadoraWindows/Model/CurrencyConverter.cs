using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class CurrencyConverter
    {

        private double AValue;
        private Currency ACurrency;
        private Currency BCurrency;

        public double AVal { get => AValue; set => AValue = value; }
        public Currency ACurrency1 { get => ACurrency; set => ACurrency = value; }
        public Currency BCurrency1 { get => BCurrency; set => BCurrency = value; }

        /**
         * USD = 1
         * EUR = 0.88
         * GPB -> EUR
         * GPB * GPB_INVERSE * EUR_DOLLAR_RATE
        **/

        public CurrencyConverter()
        {
            
        }

        public void setACurrency(Currency c)
        {
            ACurrency = c;
            Console.WriteLine("Currency A set to " + c.Name);
        }

        public void setBCurrency(Currency c)
        {
            BCurrency = c;
            Console.WriteLine("Currency B set to " + c.Name);
        }


        public string addToAValue(string character)
        {
            String tmp = AVal.ToString();

            if (character.Equals(","))
                tmp += 0;
            
            tmp += character;
            Double.TryParse(tmp, out AValue);
            return AVal.ToString();
        }

        public void removeLastNumb()
        {
            string tmp = AVal.ToString();
            if (tmp.Length <= 1)
            {
                clear();
                return;
            }
            string newNumb = tmp.Substring(0, tmp.Length - 1);
            AVal = Double.Parse(newNumb);
        }

        public void clear()
        {
            AVal = 0;

        }

        public Decimal convert()
        {
            try
            {
                Console.WriteLine(AValue + " * " + ACurrency.InverseRate + " * " + BCurrency.Rate);
                double result = AValue * ACurrency.InverseRate * BCurrency.Rate;
                Decimal decimalResult = Decimal.Parse(result.ToString());
                Console.WriteLine(decimalResult.ToString());
                return Decimal.Round(decimalResult, 2);
            } catch (NullReferenceException e)
            {
                return Decimal.Parse("0");
            }
        }
    }
}
