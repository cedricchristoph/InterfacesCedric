using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using modelo.contracts;
using modelo.utils;
using modelo.entity;
using MySql.Data.MySqlClient;

namespace modelo.dao
{
    public class UserDAO : UserEntry, ICRUD<User, int>
    {
        /* SQL COMMANDS */
        private static readonly string SELECT_BY_ID = "SELECT * FROM " + TABLE + " WHERE " + USERID + " = ?1";
        private static readonly string SELECT_BY_USERNAME = "SELECT * FROM " + TABLE + " WHERE " + USERNAME + " = ?1";
        private static readonly string SELECT_ALL = "SELECT * FROM " + TABLE;


        Database db;
        public UserDAO()
        {
            db = Database.getInstance();
        }

        public bool delete(User entity)
        {
            throw new NotImplementedException();
        }

        public bool delete(int id)
        {
            throw new NotImplementedException();
        }

        public bool insert(User entity)
        {
            throw new NotImplementedException();
        }

        public List<User> selectAll()
        {
            PreparedStatement ps = new PreparedStatement(SELECT_ALL);
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
                MySqlCommand cmd = new MySqlCommand(ps.getStatement(), conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                List<User> output = new List<User>();
                while (reader.Read())
                {
                    RoleDAO roleDao = new RoleDAO();
                    output.Add(new User(reader.GetInt32(USERID), reader.GetString(USERNAME), reader.GetString(PASSWORD),
                        roleDao.selectById(reader.GetInt32(ROLEID))));
                }
                return output;
            }
            catch (Exception e)
            {
                return null;
            }
        }

        public User selectById(int id)
        {
            PreparedStatement ps = new PreparedStatement(SELECT_BY_ID);
            ps.setParameter(1, id.ToString());
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
                MySqlCommand cmd = new MySqlCommand(ps.getStatement(), conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                User output = null;
                while (reader.Read())
                {
                    RoleDAO roleDao = new RoleDAO();
                    output = new User(reader.GetInt32(USERID), reader.GetString(USERNAME), reader.GetString(PASSWORD),
                        roleDao.selectById(reader.GetInt32(ROLEID)));
                    return output;
                }
                return output;
            }
            catch (Exception e)
            {
                return null;
            }
        }

        public User selectByUser(string username)
        {
            PreparedStatement ps = new PreparedStatement(SELECT_BY_USERNAME);
            ps.setParameter(1, username);
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
                MySqlCommand cmd = new MySqlCommand(ps.getStatement(), conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                User output = null;
                while (reader.Read())
                {
                    RoleDAO roleDao = new RoleDAO();
                    output = new User(reader.GetInt32(USERID), reader.GetString(USERNAME), reader.GetString(PASSWORD),
                        roleDao.selectById(reader.GetInt32(ROLEID)));
                    return output;
                }
                return output;
            }
            catch (Exception e)
            {
                return null;
            }
        }

        public bool update(User entity)
        {
            throw new NotImplementedException();
        }
    }
}
