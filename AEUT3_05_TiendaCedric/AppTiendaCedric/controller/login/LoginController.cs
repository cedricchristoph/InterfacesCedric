using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using model.utils;
using model.dao;
using model.entity;
namespace controller
{
    public class LoginController
    {
        User staff;
        public bool login(int user, string password)
        {
            if (checkLogin(user, password))
            {
                User.loggedUser = staff;
                return true;
            }
            return false;            
        }
        private bool checkLogin(int user, string password)
        {
            UserDAO dao = new UserDAO();
            staff = dao.selectById(user);
            return staff != null && staff.checkPwd(password);
        }
    }
}
