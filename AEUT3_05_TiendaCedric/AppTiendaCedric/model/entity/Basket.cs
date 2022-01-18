using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model.entity
{
    public class Basket
    {

        private int id;
        private string name;
        private double total;

        public Basket()
        {
        }

        public Basket(int id, string name, double total)
        {
            this.id = id;
            this.name = name;
            this.total = total;
        }

        public int Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public double Total { get => total; set => total = value; }
    }
}
