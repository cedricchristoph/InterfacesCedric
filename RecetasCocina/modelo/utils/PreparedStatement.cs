using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo.utils
{
    public class PreparedStatement
    {
        private string sqlcommand;
        private Dictionary<int, string> parameters;

        public PreparedStatement(string sql)
        {
            sqlcommand = sql;
            parameters = new Dictionary<int, string>();
        }

        public void setParameter(int position, string value)
        {
            parameters.Add(position, value);
        }

        public string getStatement()
        {
            foreach (KeyValuePair<int, string> entry in parameters)
            {
                if (sqlcommand.Contains("?" + entry.Key))
                    sqlcommand.Replace("?" + entry.Key, entry.Value);
            }
            return sqlcommand;
        }
    }
}
