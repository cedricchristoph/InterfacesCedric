using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model.entity
{
    public class Categoria
    {

        private int id;
        private string descripcion;

        public Categoria()
        {
        }

        public Categoria(int id, string descripcion)
        {
            this.id = id;
            this.descripcion = descripcion;
        }

        public int Id { get => id; set => id = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
    }
}
