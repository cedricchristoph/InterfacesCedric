using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using model.contracts;
using model.entity;
using model.utils;

namespace model.dao
{
    public class CategoryDAO : CategoryEntry, CRUD<Categoria, int>
    {
        Connection conn;
        bool closeConnAfterOperation = true;

        public CategoryDAO(bool closeConnAfterOperation)
        {
            this.closeConnAfterOperation = closeConnAfterOperation;
            conn = new Connection();
            conn.open();
        }

        public CategoryDAO()
        {
            conn = new Connection();
            conn.open();
        }

        public int delete(Categoria entity)
        {
            throw new NotImplementedException();
        }

        public int insert(Categoria entity)
        {
            throw new NotImplementedException();
        }

        public List<Categoria> selectAll()
        {
            try
            {
                string sql = "SELECT * FROM " + TABLE;
                MySql.Data.MySqlClient.MySqlDataReader reader = conn.ExecuteReader(sql);
                if (reader == null)
                    throw new Exception("Reader es null");
                List<Categoria> categorias = new List<Categoria>();
                while (reader.Read())
                {
                    Categoria c = new Categoria();
                    c.Id = reader.GetInt32(0);
                    c.Descripcion = reader.GetString(1);
                    categorias.Add(c);
                }
                closeConnection();
                return categorias;
            } catch (Exception)
            {
                return null;
            }
        }

        public Categoria selectById(int id)
        {
            throw new NotImplementedException();
        }

        public int update(Categoria entity)
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
