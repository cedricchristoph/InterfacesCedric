using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using modelo.dao;
using modelo.entity;
namespace controller.login
{
    public class MainLoginController
    {

        User user;

        public MainLoginController()
        {

        }

        public bool authenticate(string username, string password)
        {
            UserDAO dao = new UserDAO();
            user = dao.selectByUser(username);
            return (user != null) && user.checkPwd(password);
        }

        public int redirect()
        {
            if (user != null)
            {
                return user.Role.Roleid;
            }
            return -1;
        }

        public string getUsername()
        {
            return user.Username;
        }
    }
}
