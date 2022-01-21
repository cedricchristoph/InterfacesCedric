using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class NumberCalculation
    {

        Double A;
        Double B;
        Double result;
        Operation operation;

        public NumberCalculation(Double A, Double B, Operation operation)
        {
            this.A = A;
            this.B = B;
            this.operation = operation;
        }

        public NumberCalculation()
        {

        }

        public double NumberA { get => A; set => A = value; }
        public double NumberB { get => B; set => B = value; }
        public double Result { get => result; set => result = value; }
        public Operation Operation { get => operation; set => operation = value; }

        public Double calculate()
        {
            switch (operation)
            {
                case Operation.PLUS:
                    result = A + B;       
                    break;
                case Operation.MINUS:
                    result = A - B;
                    break;
                case Operation.MULTIPLY:
                    result = A * B;
                    break;
                case Operation.DIVIDE:
                    result = A / B;
                    break;
                case Operation.SQUARE_ROOT:
                    result = Math.Sqrt(A);
                    break;
            }
            return result;
        }

        public String toString()
        {
            string end;
            if (B == 0)
                end = "";
            else
                end = B + " =";
            switch (operation)
            {
                case Operation.PLUS:
                    return A + " + " + end;
                case Operation.MINUS:
                    return A + " - " + end;
                case Operation.MULTIPLY:
                    return A + " × " + end;
                case Operation.DIVIDE:
                    return A + " ÷ " + end;
                case Operation.SQUARE_ROOT:
                    return "√ " + A + " =";
                default:
                    return "";
            }
        }

    }
}
