using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo.entity
{
    public enum Role
    {
        ADMIN, TEACHER, STUDENT, UNKNOWN
    }

    public class Roles
    {
        public static readonly Role[] ROLES = { Role.ADMIN, Role.TEACHER, Role.STUDENT };
        public static Role parseRole(String value)
        {
            switch(value)
            {
                case "admin":
                    return Role.ADMIN;
                case "student":
                    return Role.STUDENT;
                case "teacher":
                    return Role.TEACHER;
                default:
                    return Role.UNKNOWN;
            }
        }

        public static String toString(Role role)
        {
            switch (role)
            {
                case Role.ADMIN:
                    return "admin";
                case Role.TEACHER:
                    return "teacher";
                case Role.STUDENT:
                    return "student";
                default:
                    return "unknown";
            }
        }
    }

    public class User
    {

        public static User loggedUser;

        private string username;
        private string password;
        private Role role;
        private bool active;

        public User()
        {
        }

        public User(string username, string password, Role role, bool active)
        {
            this.Username = username;
            this.Password = password;
            this.Role = role;
            this.Active = active;
        }

        public string Username { get => username; set => username = value; }
        public string Password { get => password; set => password = value; }
        public Role Role { get => role; set => role = value; }
        public bool Active { get => active; set => active = value; }

        public Boolean checkPwd(string pwd)
        {
            return pwd.Equals(Password);
        }
        
        
    }
}
