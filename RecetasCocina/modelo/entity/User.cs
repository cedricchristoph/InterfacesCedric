using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo.entity
{
    public class User
    {

        private int userid;
        private string username;
        private string password;
        private Role role;

        public User()
        {
        }

        public User(int userid, string username, string password, Role role)
        {
            this.Userid = userid;
            this.Username = username;
            this.Password = password;
            this.Role = role;
        }

        public Boolean checkPwd(string pwd)
        {
            return pwd.Equals(password);
        }
        public int Userid { get => userid; set => userid = value; }
        public string Username { get => username; set => username = value; }
        public string Password { get => password; set => password = value; }
        public Role Role { get => role; set => role = value; }
    }
}
