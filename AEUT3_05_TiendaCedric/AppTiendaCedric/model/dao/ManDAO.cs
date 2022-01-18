using model.contracts;
using model.entity;
using model.utils;
using System;
using System.Collections.Generic;

namespace model.dao
{
    public class ManDAO : ManEntry, CRUD<Element, int>
    {
        Connection conn;
        bool closeConnAfterOperation = true;
        public ManDAO()
        {
            conn = new Connection();
            conn.open();
        }

        public ManDAO(bool closeConnAfterOperation)
        {
            this.closeConnAfterOperation = closeConnAfterOperation;
            conn = new Connection();
            conn.open();
        }

        public int delete(Element entity)
        {
            throw new NotImplementedException();
        }

        public int insert(Element entity)
        {
            throw new NotImplementedException();
        }

        public List<Element> selectAll()
        {
            List<Element> elements = new List<Element>();
            try
            {
                string sql = "SELECT * FROM " + TABLE;
                MySql.Data.MySqlClient.MySqlDataReader reader = conn.ExecuteReader(sql);
                while (reader.Read())
                {
                    Element element = new Element();
                    element.Id = reader.GetInt32(0);
                    element.Name = reader.GetString(1);
                    element.Category = reader.GetString(2);
                    element.Description = reader.GetString(3);
                    element.Price = reader.GetDouble(4);
                    element.Quantity = reader.GetInt32(5);
                    elements.Add(element);
                }
                closeConnection();
                return elements;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
                return elements;
            }
        }

        public Element selectById(int id)
        {
            try
            {
                string sql = "SELECT * FROM " + TABLE + " WHERE " + ID + " = '" + id + "'";
                MySql.Data.MySqlClient.MySqlDataReader reader = conn.ExecuteReader(sql);
                if (reader.Read())
                {
                    Element element = new Element();
                    element.Id = reader.GetInt32(0);
                    element.Name = reader.GetString(1);
                    element.Category = reader.GetString(2);
                    element.Description = reader.GetString(3);
                    element.Price = reader.GetDouble(4);
                    element.Quantity = reader.GetInt32(5);
                    return element;
                }
                return null;
            }
            catch (Exception)
            {
                return null;
            }
        }

        public List<Element> selectByCategory(string category)
        {
            List<Element> elements = new List<Element>();
            try
            {
                string sql = "SELECT * FROM " + TABLE + " WHERE " + CATEGORY + " = '" + category + "'";
                MySql.Data.MySqlClient.MySqlDataReader reader = conn.ExecuteReader(sql);
                while (reader.Read())
                {
                    Element element = new Element();
                    element.Id = reader.GetInt32(0);
                    element.Name = reader.GetString(1);
                    element.Category = reader.GetString(2);
                    element.Description = reader.GetString(3);
                    element.Price = reader.GetDouble(4);
                    element.Quantity = reader.GetInt32(5);
                    elements.Add(element);
                }
                closeConnection();
                return elements;
            }
            catch (Exception e)
            {
                closeConnection();
                Console.WriteLine(e.StackTrace);
                return elements;
            }
        }

        public String[] selectCategories()
        {
            List<String> categories = new List<string>();
            try
            {
                string sql = "SELECT DISTINCT " + CATEGORY + " FROM " + TABLE;
                MySql.Data.MySqlClient.MySqlDataReader reader = conn.ExecuteReader(sql);
                while (reader.Read())
                    categories.Add(reader.GetString(0));
                closeConnection();
                return categories.ToArray();
            }
            catch (Exception)
            {

                closeConnection();
                return categories.ToArray();
            }
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

        public int update(Element entity)
        {
            string sql = "UPDATE " + TABLE + " SET " + QUANTITY + "='" + entity.Quantity + "' WHERE " + ID + "='" + entity.Id + "'";
            return conn.ExecuteNonQuery(sql);
        }
    }
}
