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
    public class RoleDAO : RoleEntry, ICRUD<Role, int>
    {

        /* SQL COMMANDS */
        private static readonly string SELECT_BY_ID = "SELECT * FROM " + TABLE + " WHERE " + ROLE_ID + " = ?1";
        private static readonly string SELECT_ALL = "SELECT * FROM " + TABLE;

        Database db;
        public RoleDAO()
        {
            db = Database.getInstance();
        }

        public bool delete(Role entity)
        {
            throw new NotImplementedException();
        }

        public bool delete(int id)
        {
            throw new NotImplementedException();
        }

        public bool insert(Role entity)
        {
            throw new NotImplementedException();
        }

        public List<Role> selectAll()
        {
            throw new NotImplementedException();
        }

        public Role selectById(int id)
        {
            PreparedStatement ps = new PreparedStatement(SELECT_BY_ID);
            ps.setParameter(1, id.ToString());
            try
            {
                MySqlConnection conn = db.getConnection();
                conn.Open();
                MySqlCommand cmd = new MySqlCommand(ps.getStatement(), conn);
                MySqlDataReader reader = cmd.ExecuteReader();
                Role output = null;
                while (reader.Read())
                {
                    output = new Role(reader.GetInt32(ROLE_ID), reader.GetString(NAME));
                    return output;
                }
                return output;
            } catch (Exception e)
            {
                return null;
            }
        }

        public bool update(Role entity)
        {
            throw new NotImplementedException();
        }
    }
}
