
namespace AppTiendaCedric
{
    partial class Login
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.mainpanel = new System.Windows.Forms.Panel();
            this.bodypanel = new System.Windows.Forms.Panel();
            this.btnLogin = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.txtPassword = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtUser = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.toppanel = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.btnExit = new System.Windows.Forms.Button();
            this.mainpanel.SuspendLayout();
            this.bodypanel.SuspendLayout();
            this.toppanel.SuspendLayout();
            this.SuspendLayout();
            // 
            // mainpanel
            // 
            this.mainpanel.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.mainpanel.BackColor = System.Drawing.Color.WhiteSmoke;
            this.mainpanel.BackgroundImage = global::AppTiendaCedric.Properties.Resources._4855443;
            this.mainpanel.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.mainpanel.Controls.Add(this.bodypanel);
            this.mainpanel.Controls.Add(this.toppanel);
            this.mainpanel.Location = new System.Drawing.Point(0, 0);
            this.mainpanel.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.mainpanel.Name = "mainpanel";
            this.mainpanel.Size = new System.Drawing.Size(436, 481);
            this.mainpanel.TabIndex = 0;
            // 
            // bodypanel
            // 
            this.bodypanel.BackColor = System.Drawing.Color.Transparent;
            this.bodypanel.Controls.Add(this.btnLogin);
            this.bodypanel.Controls.Add(this.label4);
            this.bodypanel.Controls.Add(this.txtPassword);
            this.bodypanel.Controls.Add(this.label3);
            this.bodypanel.Controls.Add(this.txtUser);
            this.bodypanel.Controls.Add(this.label2);
            this.bodypanel.Location = new System.Drawing.Point(11, 45);
            this.bodypanel.Name = "bodypanel";
            this.bodypanel.Size = new System.Drawing.Size(412, 419);
            this.bodypanel.TabIndex = 1;
            // 
            // btnLogin
            // 
            this.btnLogin.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnLogin.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(242)))));
            this.btnLogin.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(226)))), ((int)(((byte)(226)))), ((int)(((byte)(233)))));
            this.btnLogin.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(37)))), ((int)(((byte)(133)))), ((int)(((byte)(211)))));
            this.btnLogin.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(143)))), ((int)(((byte)(175)))), ((int)(((byte)(202)))));
            this.btnLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnLogin.Font = new System.Drawing.Font("Yu Gothic", 11F);
            this.btnLogin.Location = new System.Drawing.Point(225, 351);
            this.btnLogin.Name = "btnLogin";
            this.btnLogin.Size = new System.Drawing.Size(157, 34);
            this.btnLogin.TabIndex = 5;
            this.btnLogin.Text = "Acceder";
            this.btnLogin.UseVisualStyleBackColor = false;
            this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Yu Gothic", 10F);
            this.label4.Location = new System.Drawing.Point(28, 174);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(83, 18);
            this.label4.TabIndex = 4;
            this.label4.Text = "Contraseña";
            // 
            // txtPassword
            // 
            this.txtPassword.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtPassword.Location = new System.Drawing.Point(31, 195);
            this.txtPassword.Name = "txtPassword";
            this.txtPassword.PasswordChar = '•';
            this.txtPassword.Size = new System.Drawing.Size(351, 31);
            this.txtPassword.TabIndex = 3;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Yu Gothic", 10F);
            this.label3.Location = new System.Drawing.Point(28, 98);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(58, 18);
            this.label3.TabIndex = 2;
            this.label3.Text = "Usuario";
            // 
            // txtUser
            // 
            this.txtUser.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtUser.Location = new System.Drawing.Point(31, 119);
            this.txtUser.Name = "txtUser";
            this.txtUser.Size = new System.Drawing.Size(351, 31);
            this.txtUser.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Yu Gothic", 20F, System.Drawing.FontStyle.Bold);
            this.label2.Location = new System.Drawing.Point(25, 26);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(89, 35);
            this.label2.TabIndex = 0;
            this.label2.Text = "Login";
            // 
            // toppanel
            // 
            this.toppanel.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.toppanel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(242)))));
            this.toppanel.Controls.Add(this.label1);
            this.toppanel.Controls.Add(this.btnExit);
            this.toppanel.Location = new System.Drawing.Point(-1, -1);
            this.toppanel.Name = "toppanel";
            this.toppanel.Size = new System.Drawing.Size(436, 34);
            this.toppanel.TabIndex = 0;
            this.toppanel.MouseDown += new System.Windows.Forms.MouseEventHandler(this.topPanel_MouseDown);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Yu Gothic", 10F);
            this.label1.Location = new System.Drawing.Point(9, 8);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(130, 18);
            this.label1.TabIndex = 1;
            this.label1.Text = "Application Tienda";
            // 
            // btnExit
            // 
            this.btnExit.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnExit.FlatAppearance.BorderSize = 0;
            this.btnExit.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(37)))), ((int)(((byte)(133)))), ((int)(((byte)(211)))));
            this.btnExit.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(248)))), ((int)(((byte)(248)))), ((int)(((byte)(250)))));
            this.btnExit.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnExit.Font = new System.Drawing.Font("Yu Gothic", 10F);
            this.btnExit.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.btnExit.Location = new System.Drawing.Point(378, 0);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(57, 34);
            this.btnExit.TabIndex = 1;
            this.btnExit.Text = "✖";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.button1_Click);
            this.btnExit.MouseDown += new System.Windows.Forms.MouseEventHandler(this.btnExit_MouseDown);
            this.btnExit.MouseLeave += new System.EventHandler(this.btnExit_MouseLeave);
            this.btnExit.MouseUp += new System.Windows.Forms.MouseEventHandler(this.btnExit_MouseUp);
            // 
            // Login
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(436, 481);
            this.Controls.Add(this.mainpanel);
            this.Font = new System.Drawing.Font("Yu Gothic", 11F);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "Login";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.mainpanel.ResumeLayout(false);
            this.bodypanel.ResumeLayout(false);
            this.bodypanel.PerformLayout();
            this.toppanel.ResumeLayout(false);
            this.toppanel.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel mainpanel;
        private System.Windows.Forms.Panel bodypanel;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Panel toppanel;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Button btnLogin;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtPassword;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtUser;
    }
}

