
namespace WindowsFormsApp1_Test
{
    partial class MenuPrincipal
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
            this.panel1 = new System.Windows.Forms.Panel();
            this.contentPanel = new System.Windows.Forms.Panel();
            this.toolStrip = new System.Windows.Forms.ToolStrip();
            this.mainMenuStrip = new System.Windows.Forms.MenuStrip();
            this.studentManagerToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.addToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.listToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.deleteToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.gamificationManagerToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.searchToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.usersManagerToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.listAllToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.addAUserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.deleteAUserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.modifyAUserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.panel2 = new System.Windows.Forms.Panel();
            this.btnMaximize = new System.Windows.Forms.Button();
            this.btnMinimize = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.btnExit = new System.Windows.Forms.Button();
            this.toolStripButton1 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton2 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton3 = new System.Windows.Forms.ToolStripButton();
            this.toolStripButton4 = new System.Windows.Forms.ToolStripButton();
            this.panel1.SuspendLayout();
            this.contentPanel.SuspendLayout();
            this.toolStrip.SuspendLayout();
            this.mainMenuStrip.SuspendLayout();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.panel1.BackColor = System.Drawing.Color.White;
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Controls.Add(this.contentPanel);
            this.panel1.Controls.Add(this.panel2);
            this.panel1.ForeColor = System.Drawing.Color.White;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(834, 111);
            this.panel1.TabIndex = 1;
            // 
            // contentPanel
            // 
            this.contentPanel.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.contentPanel.BackColor = System.Drawing.Color.Transparent;
            this.contentPanel.Controls.Add(this.toolStrip);
            this.contentPanel.Controls.Add(this.mainMenuStrip);
            this.contentPanel.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.contentPanel.Location = new System.Drawing.Point(-1, 40);
            this.contentPanel.Name = "contentPanel";
            this.contentPanel.Size = new System.Drawing.Size(834, 68);
            this.contentPanel.TabIndex = 6;
            // 
            // toolStrip
            // 
            this.toolStrip.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(238)))));
            this.toolStrip.ImageScalingSize = new System.Drawing.Size(32, 32);
            this.toolStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripButton1,
            this.toolStripButton2,
            this.toolStripButton3,
            this.toolStripButton4});
            this.toolStrip.Location = new System.Drawing.Point(0, 24);
            this.toolStrip.Name = "toolStrip";
            this.toolStrip.Size = new System.Drawing.Size(834, 39);
            this.toolStrip.TabIndex = 1;
            this.toolStrip.Text = "toolStrip";
            this.toolStrip.Visible = false;
            // 
            // mainMenuStrip
            // 
            this.mainMenuStrip.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(238)))));
            this.mainMenuStrip.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.mainMenuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.studentManagerToolStripMenuItem,
            this.gamificationManagerToolStripMenuItem,
            this.usersManagerToolStripMenuItem});
            this.mainMenuStrip.Location = new System.Drawing.Point(0, 0);
            this.mainMenuStrip.Name = "mainMenuStrip";
            this.mainMenuStrip.Size = new System.Drawing.Size(834, 24);
            this.mainMenuStrip.TabIndex = 0;
            this.mainMenuStrip.Text = "menuStrip1";
            // 
            // studentManagerToolStripMenuItem
            // 
            this.studentManagerToolStripMenuItem.BackColor = System.Drawing.Color.Transparent;
            this.studentManagerToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.addToolStripMenuItem,
            this.listToolStripMenuItem,
            this.deleteToolStripMenuItem});
            this.studentManagerToolStripMenuItem.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.studentManagerToolStripMenuItem.Name = "studentManagerToolStripMenuItem";
            this.studentManagerToolStripMenuItem.Size = new System.Drawing.Size(128, 23);
            this.studentManagerToolStripMenuItem.Text = "Student Manager";
            this.studentManagerToolStripMenuItem.Visible = false;
            // 
            // addToolStripMenuItem
            // 
            this.addToolStripMenuItem.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.addToolStripMenuItem.Name = "addToolStripMenuItem";
            this.addToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.A)));
            this.addToolStripMenuItem.Size = new System.Drawing.Size(168, 24);
            this.addToolStripMenuItem.Text = "Add";
            // 
            // listToolStripMenuItem
            // 
            this.listToolStripMenuItem.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.listToolStripMenuItem.Name = "listToolStripMenuItem";
            this.listToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.L)));
            this.listToolStripMenuItem.Size = new System.Drawing.Size(168, 24);
            this.listToolStripMenuItem.Text = "List";
            // 
            // deleteToolStripMenuItem
            // 
            this.deleteToolStripMenuItem.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.deleteToolStripMenuItem.Name = "deleteToolStripMenuItem";
            this.deleteToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.D)));
            this.deleteToolStripMenuItem.Size = new System.Drawing.Size(168, 24);
            this.deleteToolStripMenuItem.Text = "Delete";
            // 
            // gamificationManagerToolStripMenuItem
            // 
            this.gamificationManagerToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.searchToolStripMenuItem});
            this.gamificationManagerToolStripMenuItem.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.gamificationManagerToolStripMenuItem.Name = "gamificationManagerToolStripMenuItem";
            this.gamificationManagerToolStripMenuItem.Size = new System.Drawing.Size(156, 23);
            this.gamificationManagerToolStripMenuItem.Text = "Gamification Manager";
            this.gamificationManagerToolStripMenuItem.Visible = false;
            // 
            // searchToolStripMenuItem
            // 
            this.searchToolStripMenuItem.Name = "searchToolStripMenuItem";
            this.searchToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.S)));
            this.searchToolStripMenuItem.Size = new System.Drawing.Size(166, 24);
            this.searchToolStripMenuItem.Text = "Search";
            // 
            // usersManagerToolStripMenuItem
            // 
            this.usersManagerToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.listAllToolStripMenuItem,
            this.addAUserToolStripMenuItem,
            this.deleteAUserToolStripMenuItem,
            this.modifyAUserToolStripMenuItem});
            this.usersManagerToolStripMenuItem.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.usersManagerToolStripMenuItem.Name = "usersManagerToolStripMenuItem";
            this.usersManagerToolStripMenuItem.Size = new System.Drawing.Size(114, 23);
            this.usersManagerToolStripMenuItem.Text = "Users Manager";
            this.usersManagerToolStripMenuItem.Visible = false;
            // 
            // listAllToolStripMenuItem
            // 
            this.listAllToolStripMenuItem.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.listAllToolStripMenuItem.Name = "listAllToolStripMenuItem";
            this.listAllToolStripMenuItem.Size = new System.Drawing.Size(180, 24);
            this.listAllToolStripMenuItem.Text = "List all";
            this.listAllToolStripMenuItem.Click += new System.EventHandler(this.listAllToolStripMenuItem_Click);
            // 
            // addAUserToolStripMenuItem
            // 
            this.addAUserToolStripMenuItem.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.addAUserToolStripMenuItem.Name = "addAUserToolStripMenuItem";
            this.addAUserToolStripMenuItem.Size = new System.Drawing.Size(180, 24);
            this.addAUserToolStripMenuItem.Text = "Add a user";
            this.addAUserToolStripMenuItem.Click += new System.EventHandler(this.toolStripButton2_Click);
            // 
            // deleteAUserToolStripMenuItem
            // 
            this.deleteAUserToolStripMenuItem.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.deleteAUserToolStripMenuItem.Name = "deleteAUserToolStripMenuItem";
            this.deleteAUserToolStripMenuItem.Size = new System.Drawing.Size(180, 24);
            this.deleteAUserToolStripMenuItem.Text = "Delete a user";
            this.deleteAUserToolStripMenuItem.Click += new System.EventHandler(this.deleteAUserToolStripMenuItem_Click);
            // 
            // modifyAUserToolStripMenuItem
            // 
            this.modifyAUserToolStripMenuItem.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.modifyAUserToolStripMenuItem.Name = "modifyAUserToolStripMenuItem";
            this.modifyAUserToolStripMenuItem.Size = new System.Drawing.Size(180, 24);
            this.modifyAUserToolStripMenuItem.Text = "Modify a user";
            this.modifyAUserToolStripMenuItem.Click += new System.EventHandler(this.modifyAUserToolStripMenuItem_Click);
            // 
            // panel2
            // 
            this.panel2.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.panel2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(3)))), ((int)(((byte)(147)))), ((int)(((byte)(208)))));
            this.panel2.Controls.Add(this.btnMaximize);
            this.panel2.Controls.Add(this.btnMinimize);
            this.panel2.Controls.Add(this.label2);
            this.panel2.Controls.Add(this.btnExit);
            this.panel2.Location = new System.Drawing.Point(-1, -1);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(834, 41);
            this.panel2.TabIndex = 5;
            this.panel2.MouseDown += new System.Windows.Forms.MouseEventHandler(this.panel2_MouseDown);
            // 
            // btnMaximize
            // 
            this.btnMaximize.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnMaximize.BackColor = System.Drawing.Color.Transparent;
            this.btnMaximize.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnMaximize.FlatAppearance.BorderSize = 0;
            this.btnMaximize.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(3)))), ((int)(((byte)(114)))), ((int)(((byte)(160)))));
            this.btnMaximize.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(3)))), ((int)(((byte)(129)))), ((int)(((byte)(182)))));
            this.btnMaximize.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMaximize.Font = new System.Drawing.Font("Yu Gothic UI", 13.25F);
            this.btnMaximize.ForeColor = System.Drawing.Color.White;
            this.btnMaximize.Location = new System.Drawing.Point(737, 1);
            this.btnMaximize.Name = "btnMaximize";
            this.btnMaximize.Size = new System.Drawing.Size(48, 40);
            this.btnMaximize.TabIndex = 9;
            this.btnMaximize.Text = "◻";
            this.btnMaximize.UseVisualStyleBackColor = false;
            this.btnMaximize.Click += new System.EventHandler(this.btnMaximize_Click);
            // 
            // btnMinimize
            // 
            this.btnMinimize.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnMinimize.BackColor = System.Drawing.Color.Transparent;
            this.btnMinimize.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnMinimize.FlatAppearance.BorderSize = 0;
            this.btnMinimize.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(3)))), ((int)(((byte)(114)))), ((int)(((byte)(160)))));
            this.btnMinimize.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(3)))), ((int)(((byte)(129)))), ((int)(((byte)(182)))));
            this.btnMinimize.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMinimize.Font = new System.Drawing.Font("Yu Gothic Light", 11.25F);
            this.btnMinimize.ForeColor = System.Drawing.Color.White;
            this.btnMinimize.Location = new System.Drawing.Point(686, 1);
            this.btnMinimize.Name = "btnMinimize";
            this.btnMinimize.Size = new System.Drawing.Size(48, 40);
            this.btnMinimize.TabIndex = 8;
            this.btnMinimize.Text = "_";
            this.btnMinimize.UseVisualStyleBackColor = false;
            this.btnMinimize.Click += new System.EventHandler(this.btnMinimize_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Yu Gothic", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(10, 11);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(128, 20);
            this.label2.TabIndex = 6;
            this.label2.Text = "Gamification App";
            // 
            // btnExit
            // 
            this.btnExit.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btnExit.BackColor = System.Drawing.Color.Transparent;
            this.btnExit.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnExit.FlatAppearance.BorderSize = 0;
            this.btnExit.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Firebrick;
            this.btnExit.FlatAppearance.MouseOverBackColor = System.Drawing.Color.LightCoral;
            this.btnExit.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnExit.Font = new System.Drawing.Font("Yu Gothic Light", 11.25F);
            this.btnExit.ForeColor = System.Drawing.Color.White;
            this.btnExit.Location = new System.Drawing.Point(786, 1);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(48, 40);
            this.btnExit.TabIndex = 7;
            this.btnExit.Text = "✖";
            this.btnExit.UseVisualStyleBackColor = false;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // toolStripButton1
            // 
            this.toolStripButton1.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton1.Image = global::WindowsFormsApp1_Test.Properties.Resources.list;
            this.toolStripButton1.ImageTransparentColor = System.Drawing.Color.White;
            this.toolStripButton1.Name = "toolStripButton1";
            this.toolStripButton1.Size = new System.Drawing.Size(36, 36);
            this.toolStripButton1.Text = "toolStripButton1";
            this.toolStripButton1.Click += new System.EventHandler(this.listAllToolStripMenuItem_Click);
            // 
            // toolStripButton2
            // 
            this.toolStripButton2.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton2.Image = global::WindowsFormsApp1_Test.Properties.Resources.add;
            this.toolStripButton2.ImageTransparentColor = System.Drawing.Color.White;
            this.toolStripButton2.Name = "toolStripButton2";
            this.toolStripButton2.Size = new System.Drawing.Size(36, 36);
            this.toolStripButton2.Text = "toolStripButton2";
            this.toolStripButton2.Click += new System.EventHandler(this.toolStripButton2_Click);
            // 
            // toolStripButton3
            // 
            this.toolStripButton3.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton3.Image = global::WindowsFormsApp1_Test.Properties.Resources.delete;
            this.toolStripButton3.ImageTransparentColor = System.Drawing.Color.White;
            this.toolStripButton3.Name = "toolStripButton3";
            this.toolStripButton3.Size = new System.Drawing.Size(36, 36);
            this.toolStripButton3.Text = "toolStripButton3";
            this.toolStripButton3.Click += new System.EventHandler(this.deleteAUserToolStripMenuItem_Click);
            // 
            // toolStripButton4
            // 
            this.toolStripButton4.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripButton4.Image = global::WindowsFormsApp1_Test.Properties.Resources.update;
            this.toolStripButton4.ImageTransparentColor = System.Drawing.Color.White;
            this.toolStripButton4.Name = "toolStripButton4";
            this.toolStripButton4.Size = new System.Drawing.Size(36, 36);
            this.toolStripButton4.Text = "toolStripButton4";
            this.toolStripButton4.Click += new System.EventHandler(this.modifyAUserToolStripMenuItem_Click);
            // 
            // MenuPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.ClientSize = new System.Drawing.Size(834, 545);
            this.Controls.Add(this.panel1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.IsMdiContainer = true;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "MenuPrincipal";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Gamification App";
            this.panel1.ResumeLayout(false);
            this.contentPanel.ResumeLayout(false);
            this.contentPanel.PerformLayout();
            this.toolStrip.ResumeLayout(false);
            this.toolStrip.PerformLayout();
            this.mainMenuStrip.ResumeLayout(false);
            this.mainMenuStrip.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnMaximize;
        private System.Windows.Forms.Button btnMinimize;
        private System.Windows.Forms.Panel contentPanel;
        private System.Windows.Forms.MenuStrip mainMenuStrip;
        private System.Windows.Forms.ToolStripMenuItem studentManagerToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem addToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem listToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem deleteToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem gamificationManagerToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem searchToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem usersManagerToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem listAllToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem addAUserToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem deleteAUserToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem modifyAUserToolStripMenuItem;
        private System.Windows.Forms.ToolStrip toolStrip;
        private System.Windows.Forms.ToolStripButton toolStripButton1;
        private System.Windows.Forms.ToolStripButton toolStripButton2;
        private System.Windows.Forms.ToolStripButton toolStripButton3;
        private System.Windows.Forms.ToolStripButton toolStripButton4;
    }
}