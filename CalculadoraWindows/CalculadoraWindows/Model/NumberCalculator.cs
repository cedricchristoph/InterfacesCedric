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

        public Double calculate()
        {
            Double result = actual.calculate();
            newCalculationWithLastResult();
            return result;
        }

        public String getLastOperationString()
        {
            return historial[historial.Count - 1].toString();
        }

    }
}
