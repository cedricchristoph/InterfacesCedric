using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class NumberCalculator
    {

        List<NumberCalculation> historial;
        NumberCalculation actual;
        String stringNumber;

        public List<NumberCalculation> Historial { get => historial; set => historial = value; }
        public NumberCalculation Actual { get => actual; set => actual = value; }
        public string StringNumber() {
            if (String.IsNullOrEmpty(stringNumber))
                return "0";
            return stringNumber;
        }

        public void StringNumber(string value)
        {
            stringNumber = value;
        }

        public NumberCalculator()
        {
            historial = new List<NumberCalculation>();
            newCalculation();
            stringNumber = "";
        }

        public void newCalculation()
        {
            actual = new NumberCalculation();
        }

        public void newCalculationWithLastResult()
        {
            actual = new NumberCalculation();
            actual.NumberA = historial[historial.Count - 1].Result;
        }

        public void addToNumber(String character)
        {
            stringNumber += character;
            if (!historial.Contains(actual))
                historial.Add(actual);
        }

        public void removeLastCharFromNumber()
        {
            try
            {
                stringNumber = stringNumber.Remove(stringNumber.Length - 1);
            }
            catch (Exception e)
            {

            }
        }

        public void switchSign()
        {
            if (stringNumber.StartsWith("-"))
            {
                stringNumber = stringNumber.Replace("-", "");
            } else
            {
                string tmp = "-" + stringNumber;
                stringNumber = tmp;
            }
        }

        public void establishNumber(Boolean first)
        {
            if (!historial.Contains(actual))
                historial.Add(actual);
            if (Double.TryParse(stringNumber, out double number))
            {
                if (first)
                    actual.NumberA = number;
                else
                    actual.NumberB = number;
                stringNumber = "";
            }
        }

        public void setOperation(Operation operation)
        {
            actual.Operation = operation;
        }

        public string calculate()
        {
            if (actual.Operation == Operation.DIVIDE && actual.NumberB == 0)
                return "No se puede dividir entre cero";
            Double result = actual.calculate();
            newCalculationWithLastResult();
            return result + "";
        }

        public String getLastOperationString()
        {
            return historial[historial.Count - 1].toString();
        }

    }
}
