using modelo.entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp1_Test
{
    public class EliminarUsuariosController
    {

        public EliminarUsuariosController()
        {

        }

        public List<User> getAllUsers()
        {
            UserDAO dao = new UserDAO();
            return dao.selectAll();
        }

        public bool eliminarUsuario(string usuario)
        {
            UserDAO dao = new UserDAO();
            return dao.delete(usuario);
        }
    }
}
