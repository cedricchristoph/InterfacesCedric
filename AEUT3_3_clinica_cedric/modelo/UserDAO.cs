using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo
{
    public class UserDAO
    {
        private FileManager manager;

        public UserDAO(string rutaFichero)
        {
            manager = new FileManager(rutaFichero);
        }

        public UserDAO(FileManager manager)
        {
            this.manager = manager;
        }

        public List<User> selectAll()
        {
            List<User> users = new List<User>();
            foreach (string line in manager.readLines())
            {
                string[] data = line.Split(':');
                users.Add(new User(data[0], data[1], data[2]));
            }
            return users;
        }

        public User select(string user)
        {
            List<User> users = new List<User>();
            foreach (string line in manager.readLines())
            {
                string[] data = line.Split(':');
                if (data[0].Equals(user))
                    return new User(data[0], data[1], data[2]);
            }
            return null;
        }
    }
}
