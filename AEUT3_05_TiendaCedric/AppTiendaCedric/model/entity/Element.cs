using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model.entity
{
    public class Element
    {

        private int id;
        private string name;
        private string category;
        private string description;
        private double price;
        private int quantity;

        public Element()
        {
        }

        public Element(int id, string name, string category, string description, double price, int quantity)
        {
            this.id = id;
            this.name = name;
            this.category = category;
            this.description = description;
            this.price = price;
            this.quantity = quantity;
        }

        public int Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public string Category { get => category; set => category = value; }
        public string Description { get => description; set => description = value; }
        public double Price { get => price; set => price = value; }
        public int Quantity { get => quantity; set => quantity = value; }
    }
}
