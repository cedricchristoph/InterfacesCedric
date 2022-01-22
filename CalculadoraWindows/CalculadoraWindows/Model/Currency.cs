using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Currency
    {

        public static readonly Currency USD = new Currency("USD", "USD", 0, "US Dollar", 1, new DateTime(), 1);


        private string code;
        private string alphaCode;
        private int numericCode;
        private string name;
        private float rate;
        private DateTime date;
        private float inverseRate;

        public Currency()
        {
        }

        public Currency(string code, string alphaCode, int numericCode, string name, float rate, DateTime date, float inverseRate)
        {
            this.code = code;
            this.alphaCode = alphaCode;
            this.numericCode = numericCode;
            this.name = name;
            this.rate = rate;
            this.date = date;
            this.inverseRate = inverseRate;
        }

        public string Code { get => code; set => code = value; }
        public string AlphaCode { get => alphaCode; set => alphaCode = value; }
        public int NumericCode { get => numericCode; set => numericCode = value; }
        public string Name { get => name; set => name = value; }
        public float Rate { get => rate; set => rate = value; }
        public DateTime Date { get => date; set => date = value; }
        public float InverseRate { get => inverseRate; set => inverseRate = value; }


    }
}
