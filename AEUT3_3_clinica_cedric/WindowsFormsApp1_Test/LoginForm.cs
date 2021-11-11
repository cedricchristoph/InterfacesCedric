using controlador;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using modelo;

namespace WindowsFormsApp1_Test
{
    public partial class LoginForm : Form
    {
        LoginController controller;
        public LoginForm(LoginController controller)
        {
            InitializeComponent();
            this.controller = controller;
        }

        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            User user = controller.login(txtUser.Text, txtPwd.Text);
            if (user == null)
            {
                txtUser.Text = "";
                txtPwd.Text = "";
                errorBox.Visible = true;
            } else
            {
                redirect(user);
                this.Hide();
            }
        }

        private void redirect(User user)
        {
            switch (user.AccessLevel)
            {
                case AccessLevel.ADMINISTRATIVO:
                    new PersonalAdministrativoForm().Visible = true;
                    break;
                case AccessLevel.PERSONAL_SANITARIO:
                    new PersonalSanitarioForm().Visible = true;
                    break;
                default:
                    MessageBox.Show("Bienvenido " + user.Username + "\nTe has registrado correctamente\n" +
                        "Lo lamentamos, esta sección está en construcción");
                    break;
            }
        }

        private void btnExit_Click(object sender, EventArgs e)
        {

        }
    }
}
