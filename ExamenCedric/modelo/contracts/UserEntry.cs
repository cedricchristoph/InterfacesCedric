using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo.contracts
{
    public class UserEntry
    {
        public static readonly string TABLE = "users";
        public static readonly string USERNAME = "username";
        public static readonly string PASSWORD = "password";
        public static readonly string ROLE = "role";
        public static readonly string ACTIVE = "active";

        /* SQL COMMANDS */
        public static readonly string SELECT_BY_ID = "SELECT * FROM " + TABLE + " WHERE " + USERNAME + " = ?1";
        public static readonly string SELECT_ALL = "SELECT * FROM " + TABLE;

    }
}
