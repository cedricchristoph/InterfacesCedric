using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using modelo.dao;
using modelo.entity;

namespace WindowsFormsApp1_Test
{
    public class MainLoginController
    {

        private User user;

        public MainLoginController()
        {

        }

        public User User { get => user; set => user = value; }

        /**
         * Verifica usuario, contraseña y activo
         */
        public bool authenticate(string username, string password)
        {
            UserDAO dao = new UserDAO();
            user = dao.selectByUsername(username);
            if ((user != null) && user.checkPwd(password) && user.Active)
            {
                User.loggedUser = user;
                return true;
            }
            return false;
        }

        public User getLoggedUser()
        {
            return user;
        }

    }
}
