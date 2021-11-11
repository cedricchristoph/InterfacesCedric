using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using modelo;
namespace controlador
{
    public class LoginController 
    {
        private FileManager manager;
        public LoginController()
        {
            manager = new FileManager("users.txt");
        }

        public User login(string userStr, string pwdStr)
        {
            UserDAO userDao = new UserDAO(manager);
            User user = null;
            if (!String.IsNullOrEmpty(userStr))
            {
                user = userDao.select(userStr);
                if (user != null)
                    if (checkCredentials(user, pwdStr))
                        return user;
            }
            return null;
        }
        public Boolean checkCredentials(User user, string pwdStr)
        {
            if (!String.IsNullOrEmpty(pwdStr)) 
               if (user.Password.Equals(pwdStr))
                    return true; 
            return false;
        }
    }
}
