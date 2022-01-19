using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo
{
    public enum AccessLevel
    {
        ADMIN,
        ADMINISTRATIVO,
        DIRECCION,
        PERSONAL_SANITARIO,
        UNKNOWN
    }

    static class AccessLevels
    {

        public static AccessLevel GetAccessLevel(string value)
        {
            switch(value.ToLower())
            {
                case "administrador":
                    return AccessLevel.ADMIN;
                case "administrativo":
                    return AccessLevel.ADMINISTRATIVO;
                case "direccion":
                    return AccessLevel.DIRECCION;
                case "personalsanitario":
                    return AccessLevel.PERSONAL_SANITARIO;
                default:
                    return AccessLevel.UNKNOWN;
            }
        }
    }

    public class User
    {
        private string username;
        private string password;
        private AccessLevel accessLevel;

        public User(string user, string password, string access)
        {
            this.username = user;
            this.password = password;
            this.accessLevel = AccessLevels.GetAccessLevel(access);
        }

        public User(string user, string password, AccessLevel accessLevel)
        {
            this.username = user;
            this.password = password;
            this.accessLevel = accessLevel;
        }

        public string Username { get => username; set => username = value; }
        public string Password { get => password; set => password = value; }
        public AccessLevel AccessLevel { get => accessLevel; set => accessLevel = value; }

    }
}
