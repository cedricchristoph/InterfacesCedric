using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model.entity
{
    public class User
    {
        public static User loggedUser;

        private int id;
        private string password;
        private Rol role;

        public User()
        {

        }

        public User(int id, string password, Rol rol)
        {
            this.id = id;
            this.password = password;
            this.role = rol;
        }

        public User(int id, string password, string rol)
        {
            this.id = id;
            this.password = password;
            this.role = Roles.parseRol(rol);
        }

        public bool checkPwd (string pwd)
        {
            return (this.password.Equals(pwd));
        }

        public int Id { get => id; set => id = value; }
        public string Password { get => password; set => password = value; }
        public Rol Role { get => role; set => role = value; }
    }
}
