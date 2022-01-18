using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace model.utils
{
    public class Connection
    {
        public static readonly string LOCAL_HOST = "localhost";
        public static readonly string DATABASE = "shop";
        public static readonly string USER = "root";
        public static readonly string PASSWORD = "1q2w3e4r";

        MySqlConnection conn;
        string connectionString;
        string host;
        string database;
        string user;
        string pwd;

        public Connection(string host, string database, string user, string pwd)
        {
            this.host = host;
            this.database = database;
            this.user = user;
            this.pwd = pwd;
            generateConnectionString();
        }

        public Connection(string user, string pwd)
        {
            this.host = LOCAL_HOST;
            this.database = DATABASE;
            this.user = user;
            this.pwd = pwd;
            generateConnectionString();
        }

        public Connection()
        {
            this.host = LOCAL_HOST;
            this.database = DATABASE;
            this.user = USER;
            this.pwd = PASSWORD;
            generateConnectionString();
        }

        private void generateConnectionString()
        {
            connectionString = string.Format("Server={0}; database={1}; UID={2}; password={3}; SslMode=none", host, database, user, pwd);
        }

        public bool open()
        {
            try
            {
                conn = new MySqlConnection(connectionString);
                conn.Open();
                return true;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                Console.WriteLine(e.StackTrace);
                return false;
            }
        }

        public void close()
        {
            conn.Close();
            conn.Dispose();
        }

        public DataSet ExecuteDataSet(string sql)
        {
            try
            {
                DataSet data = new DataSet();
                MySqlDataAdapter adapter = new MySqlDataAdapter(sql, conn);
                adapter.Fill(data, "result");
                return data;
            }
            catch (Exception)
            {
                return null;
            }
        }

        public MySqlDataReader ExecuteReader(string sql)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand(sql, conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                return reader;
            }
            catch (Exception e)
            {
                Console.WriteLine("EXCEPCION EN CONNECTION: \n" + e.StackTrace);
                return null;
            }
        }

        public int ExecuteNonQuery(string sql)
        {
            try
            {
                MySqlTransaction transaction = conn.BeginTransaction();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = sql;
                int affected = cmd.ExecuteNonQuery();
                transaction.Commit();
                return affected;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
                return -1;
            }
        }
    }
}
