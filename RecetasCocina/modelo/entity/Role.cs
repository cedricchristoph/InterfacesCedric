using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo.entity
{
    public class Role
    {

        private int roleid;
        private string name;

        public Role()
        {
        }

        public Role(int roleid, string name)
        {
            this.Roleid = roleid;
            this.Name = name;
        }

        public int Roleid { get => roleid; set => roleid = value; }
        public string Name { get => name; set => name = value; }
    }
}
