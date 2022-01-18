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
    public class BasketDAO : BasketEntry, CRUD<Basket, int>
    {

        Connection conn;
        bool closeConnAfterOperation = true;
        public BasketDAO(bool closeConnAfterOperation)
        {
            this.closeConnAfterOperation = closeConnAfterOperation;
            conn = new Connection();
            conn.open();
        }

        public BasketDAO()
        {
            conn = new Connection();
            conn.open();
        }

        public int delete(Basket entity)
        {
            throw new NotImplementedException();
        }

        public int insert(Basket entity)
        {
            string sql = "INSERT INTO " + TABLE + " (" + ID + ", " + NAME + ", " + TOTAL + ") VALUES ('" + entity.Id + "', '" + entity.Name + "', '" + entity.Total + "')";
            return conn.ExecuteNonQuery(sql);
        }

        public List<Basket> selectAll()
        {
            throw new NotImplementedException();
        }

        public Basket selectById(int id)
        {
            throw new NotImplementedException();
        }

        public int update(Basket entity)
        {
            throw new NotImplementedException();
        }
    }
}
