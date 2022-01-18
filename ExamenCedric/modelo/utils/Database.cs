using System;
using MySql.Data.MySqlClient;

namespace WindowsFormsApp1_Test
{
    class Database
    {

        private readonly String HOST;
        private readonly String BD;
        private readonly String USER;
        private readonly String PASSWORD;
        private MySqlConnection sqlCon;
        private static Database instance = null;

        protected Database()
        {
            HOST = "localhost";
            BD = "gamification";
            USER = "root";
            PASSWORD = "";
        }

        public Database(String host, String ddbb, String user, String pwd)
        {
            HOST = host;
            BD = ddbb;
            USER = user;
            PASSWORD = pwd;
        }

        public static Database getInstance()
        {
            if (instance == null)
            {
                instance = new Database();
            }
            return instance;
        }

        public static Database getInstance(String host, String ddbb, String user, String pwd)
        {
            if (instance == null)
            {
                instance = new Database(host, ddbb, user, pwd);
            }
            return instance;
        }

        public MySqlConnection getConnection()
        {
            return sqlCon = new MySqlConnection("Server=" + HOST + ";Database=" + BD + ";Uid=" + USER + ";Pwd=" + PASSWORD + ";SSL Mode=None;Convert Zero Datetime=True");
        }
    }
}
