using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using modelo.entity;
namespace WindowsFormsApp1_Test
{
    public class FiltrarUsuariosController
    {

        public FiltrarUsuariosController()
        {

        }

        public List<User> filterUsersByRol(string selectedrol)
        {
            Role role = Roles.parseRole(selectedrol);
            UserDAO dao = new UserDAO();
            return dao.selectByRol(role);
        }

    }
}
