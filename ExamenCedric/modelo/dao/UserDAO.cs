using System;
using System.Collections.Generic;
using modelo.contracts;
using modelo.entity;
using MySql.Data.MySqlClient;
using modelo.dao;

namespace WindowsFormsApp1_Test
{
    public class UserDAO : UserEntry, ICRUD<User, String>
    {
    
        Database db;
        public UserDAO()
        {
            db = Database.getInstance();
        }

        public bool delete(User entity)
        {
            throw new NotImplementedException();
        }

        public bool delete(String id)
        {
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
                MySqlCommand cmd = new MySqlCommand("DELETE FROM " + TABLE + " WHERE " + USERNAME + " = '" + id + "'", conn);
                return cmd.ExecuteNonQuery() > 0;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return false;
            }
        }

        public bool insert(User entity)
        {
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
                MySqlCommand cmd = new MySqlCommand("INSERT INTO " + TABLE + " (" + USERNAME + ", " + PASSWORD + ", "+ ROLE +", "+ ACTIVE +") " +
                    "VALUES ('"+entity.Username+"', '"+ entity.Password +"', '"+ Roles.toString(entity.Role)+"', "+ entity.Active +")", conn);
                return cmd.ExecuteNonQuery() > 0;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return false;
            }
        }

        public List<User> selectAll()
        {
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
               
                MySqlCommand cmd = new MySqlCommand(SELECT_ALL, conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                List<User> output = new List<User>();
                while(reader.Read())
                {
                    output.Add(new User(reader.GetString(USERNAME), reader.GetString(PASSWORD), Roles.parseRole(reader.GetString(ROLE)), reader.GetBoolean(ACTIVE)));
                }
                return output;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return null;
            }
        }

        public User selectById(string id)
        {
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
                MySqlCommand cmd = new MySqlCommand("SELECT * FROM " + TABLE + " WHERE " + USERNAME + " = '" + id + "'", conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    new User(reader.GetString(USERNAME), reader.GetString(PASSWORD), Roles.parseRole(reader.GetString(ROLE)), reader.GetBoolean(ACTIVE));
                }
                return null;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
                Console.WriteLine(e.Message);
                return null;
            }
        }

        public List<User> selectByRol(Role rol)
        {
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
                MySqlCommand cmd = new MySqlCommand("SELECT * FROM " + TABLE + " WHERE " + ROLE + " = '" + Roles.toString(rol) + "'", conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                List<User> users = new List<User>();
                while (reader.Read())
                {
                    users.Add(new User(reader.GetString(USERNAME), reader.GetString(PASSWORD), Roles.parseRole(reader.GetString(ROLE)), reader.GetBoolean(ACTIVE)));
                }
                return users;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
                Console.WriteLine(e.Message);
                return null;
            }
        }

        public User selectByUsername(string username)
        {
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
                MySqlCommand cmd = new MySqlCommand("SELECT * FROM " + TABLE + " WHERE " + USERNAME + " = '" + username + "'", conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    return new User(reader.GetString(USERNAME), reader.GetString(PASSWORD), Roles.parseRole(reader.GetString(ROLE)), reader.GetBoolean(ACTIVE));
                }
                return null;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
                Console.WriteLine(e.Message);
                return null;
            }
        }

        public bool update(User entity)
        {
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
                MySqlCommand cmd = new MySqlCommand("UPDATE " + TABLE + " SET " + USERNAME + " = '" + entity.Username + "', " +
                    PASSWORD + " = '" + entity.Password + "', " + ROLE + " = '" + Roles.toString(entity.Role) + "'", conn);
                return cmd.ExecuteNonQuery() > 0;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return false;
            }
        }
    }
}
