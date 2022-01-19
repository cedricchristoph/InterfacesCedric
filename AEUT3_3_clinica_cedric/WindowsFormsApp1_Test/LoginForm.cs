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

            // Create the ToolTip and associate with the Form container.
            ToolTip toolTip1 = new ToolTip();

            // Set up the delays for the ToolTip.
            toolTip1.AutoPopDelay = 5000;
            toolTip1.InitialDelay = 1000;
            toolTip1.ReshowDelay = 500;
            // Force the ToolTip text to be displayed whether or not the form is active.
            toolTip1.ShowAlways = true;

            // Set up the ToolTip text for the Button and Checkbox.
            toolTip1.SetToolTip(this.txtPwd, "Introducir password");
            toolTip1.SetToolTip(txtUser, "Introducir usuario");
            toolTip1.SetToolTip(btnAcceder, "Acceder");
            toolTip1.SetToolTip(btnExit, "Salir del programa");
            toolTip1.SetToolTip(btnMinimize, "Minimizar la ventana");
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
            System.Windows.Forms.Application.Exit();
        }

        private void btnMinimize_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }
    }
}
