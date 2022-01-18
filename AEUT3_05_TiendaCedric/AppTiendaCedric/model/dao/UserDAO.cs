using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using model.entity;
using model.utils;
namespace model.dao
{
    public class UserDAO : UserEntry, CRUD<User, int>
    {
        Connection conn;
        bool closeConnAfterOperation = true;
        public UserDAO(bool closeConnAfterOperation)
        {
            this.closeConnAfterOperation = closeConnAfterOperation;
            conn = new Connection();
            conn.open();
        }

        public UserDAO()
        {
            conn = new Connection();
            conn.open();
        }

        public int delete(User entity)
        {
            throw new NotImplementedException();
        }

        public int insert(User entity)
        {
            throw new NotImplementedException();
        }

        public List<User> selectAll()
        {
            throw new NotImplementedException();
        }

        public User selectById(int id)
        {
            try
            {
                string sql = "SELECT * FROM " + TABLE + " WHERE " + STAFF_ID + " = " + id;
                MySql.Data.MySqlClient.MySqlDataReader reader = conn.ExecuteReader(sql);
                if (reader == null)
                    throw new Exception("Reader es null");
                User user = null;
                if (reader.Read())
                {
                    user = new User();
                    user.Id = reader.GetInt32(0);
                    user.Password = reader.GetString(1);
                    user.Role = Roles.parseRol(reader.GetString(2));
                    return user;
                }
                closeConnection();
                return user;
            } catch (Exception)
            {
                return null;
            }
        }

        public int update(User entity)
        {
            throw new NotImplementedException();
        }

        private void closeConnection()
        {
            if (closeConnAfterOperation)
                close();
        }

        public void close()
        {
            try
            {
                conn.close();
            }
            catch (Exception) { }
        }
    }
}
