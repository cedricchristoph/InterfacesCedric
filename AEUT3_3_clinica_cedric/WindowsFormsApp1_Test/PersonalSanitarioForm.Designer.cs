
namespace WindowsFormsApp1_Test
{
    partial class PersonalSanitarioForm
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
            this.btnExit = new System.Windows.Forms.Button();
            this.btnMinimize = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label6 = new System.Windows.Forms.Label();
            this.panel2 = new System.Windows.Forms.Panel();
            this.label2 = new System.Windows.Forms.Label();
            this.button2 = new System.Windows.Forms.Button();
            this.menuStrip = new System.Windows.Forms.MenuStrip();
            this.menuItemPacientes = new System.Windows.Forms.ToolStripMenuItem();
            this.buscarPacienteToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.verFichaPacienteToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.sacarEtiquetasDelPacienteToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.verActasClínicosDelPacienteToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.notasToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.buscarNotaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.crearNotaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.modificarNotaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.eliminarNotaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.salirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.menuStrip.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnExit
            // 
            this.btnExit.BackColor = System.Drawing.Color.Transparent;
            this.btnExit.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.btnExit.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Firebrick;
            this.btnExit.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(204)))), ((int)(((byte)(204)))));
            this.btnExit.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnExit.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnExit.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.btnExit.Location = new System.Drawing.Point(890, -1);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(67, 76);
            this.btnExit.TabIndex = 1;
            this.btnExit.Text = "✖";
            this.btnExit.UseVisualStyleBackColor = false;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // btnMinimize
            // 
            this.btnMinimize.BackColor = System.Drawing.Color.Transparent;
            this.btnMinimize.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.btnMinimize.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(164)))), ((int)(((byte)(203)))), ((int)(((byte)(255)))));
            this.btnMinimize.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(235)))), ((int)(((byte)(235)))), ((int)(((byte)(235)))));
            this.btnMinimize.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMinimize.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F);
            this.btnMinimize.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.btnMinimize.Location = new System.Drawing.Point(751, -1);
            this.btnMinimize.Name = "btnMinimize";
            this.btnMinimize.Size = new System.Drawing.Size(70, 76);
            this.btnMinimize.TabIndex = 3;
            this.btnMinimize.Text = "▄";
            this.btnMinimize.UseVisualStyleBackColor = false;
            this.btnMinimize.Click += new System.EventHandler(this.btnMinimize_Click);
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.White;
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Controls.Add(this.label6);
            this.panel1.Controls.Add(this.panel2);
            this.panel1.ForeColor = System.Drawing.Color.White;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(957, 76);
            this.panel1.TabIndex = 1;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Yu Gothic UI", 10.25F);
            this.label6.Location = new System.Drawing.Point(12, 749);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(121, 19);
            this.label6.TabIndex = 11;
            this.label6.Text = "Downloading 58%";
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.panel2.Controls.Add(this.label2);
            this.panel2.Controls.Add(this.button2);
            this.panel2.Controls.Add(this.btnMinimize);
            this.panel2.Controls.Add(this.btnExit);
            this.panel2.Controls.Add(this.menuStrip);
            this.panel2.Location = new System.Drawing.Point(-1, -1);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(957, 75);
            this.panel2.TabIndex = 5;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Yu Gothic UI", 12F, System.Drawing.FontStyle.Bold);
            this.label2.ForeColor = System.Drawing.Color.Black;
            this.label2.Location = new System.Drawing.Point(13, 17);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(236, 21);
            this.label2.TabIndex = 6;
            this.label2.Text = "App Clinica - Personal Sanitario";
            // 
            // button2
            // 
            this.button2.BackColor = System.Drawing.Color.Transparent;
            this.button2.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.button2.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(164)))), ((int)(((byte)(203)))), ((int)(((byte)(255)))));
            this.button2.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(235)))), ((int)(((byte)(235)))), ((int)(((byte)(235)))));
            this.button2.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button2.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.button2.Location = new System.Drawing.Point(820, 0);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(70, 75);
            this.button2.TabIndex = 2;
            this.button2.Text = "🞑";
            this.button2.UseVisualStyleBackColor = false;
            // 
            // menuStrip
            // 
            this.menuStrip.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.menuStrip.Dock = System.Windows.Forms.DockStyle.None;
            this.menuStrip.Font = new System.Drawing.Font("Yu Gothic", 10F);
            this.menuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuItemPacientes,
            this.notasToolStripMenuItem,
            this.salirToolStripMenuItem});
            this.menuStrip.Location = new System.Drawing.Point(2, 47);
            this.menuStrip.Name = "menuStrip";
            this.menuStrip.RenderMode = System.Windows.Forms.ToolStripRenderMode.Professional;
            this.menuStrip.Size = new System.Drawing.Size(320, 26);
            this.menuStrip.TabIndex = 16;
            this.menuStrip.Text = "menuStrip";
            // 
            // menuItemPacientes
            // 
            this.menuItemPacientes.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.buscarPacienteToolStripMenuItem,
            this.verFichaPacienteToolStripMenuItem,
            this.sacarEtiquetasDelPacienteToolStripMenuItem,
            this.verActasClínicosDelPacienteToolStripMenuItem});
            this.menuItemPacientes.ForeColor = System.Drawing.Color.Black;
            this.menuItemPacientes.Name = "menuItemPacientes";
            this.menuItemPacientes.Size = new System.Drawing.Size(84, 22);
            this.menuItemPacientes.Text = "Pacientes";
            // 
            // buscarPacienteToolStripMenuItem
            // 
            this.buscarPacienteToolStripMenuItem.Name = "buscarPacienteToolStripMenuItem";
            this.buscarPacienteToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.B)));
            this.buscarPacienteToolStripMenuItem.Size = new System.Drawing.Size(318, 22);
            this.buscarPacienteToolStripMenuItem.Text = "Buscar paciente";
            this.buscarPacienteToolStripMenuItem.Click += new System.EventHandler(this.buscarPacienteToolStripMenuItem_Click);
            // 
            // verFichaPacienteToolStripMenuItem
            // 
            this.verFichaPacienteToolStripMenuItem.Name = "verFichaPacienteToolStripMenuItem";
            this.verFichaPacienteToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.F)));
            this.verFichaPacienteToolStripMenuItem.Size = new System.Drawing.Size(318, 22);
            this.verFichaPacienteToolStripMenuItem.Text = "Ver ficha paciente";
            // 
            // sacarEtiquetasDelPacienteToolStripMenuItem
            // 
            this.sacarEtiquetasDelPacienteToolStripMenuItem.Name = "sacarEtiquetasDelPacienteToolStripMenuItem";
            this.sacarEtiquetasDelPacienteToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.T)));
            this.sacarEtiquetasDelPacienteToolStripMenuItem.Size = new System.Drawing.Size(318, 22);
            this.sacarEtiquetasDelPacienteToolStripMenuItem.Text = "Sacar etiquetas del paciente";
            // 
            // verActasClínicosDelPacienteToolStripMenuItem
            // 
            this.verActasClínicosDelPacienteToolStripMenuItem.Name = "verActasClínicosDelPacienteToolStripMenuItem";
            this.verActasClínicosDelPacienteToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.A)));
            this.verActasClínicosDelPacienteToolStripMenuItem.Size = new System.Drawing.Size(318, 22);
            this.verActasClínicosDelPacienteToolStripMenuItem.Text = "Ver actas clínicos del paciente";
            // 
            // notasToolStripMenuItem
            // 
            this.notasToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.buscarNotaToolStripMenuItem,
            this.crearNotaToolStripMenuItem,
            this.modificarNotaToolStripMenuItem,
            this.eliminarNotaToolStripMenuItem});
            this.notasToolStripMenuItem.ForeColor = System.Drawing.Color.Black;
            this.notasToolStripMenuItem.Name = "notasToolStripMenuItem";
            this.notasToolStripMenuItem.Size = new System.Drawing.Size(58, 22);
            this.notasToolStripMenuItem.Text = "Notas";
            // 
            // buscarNotaToolStripMenuItem
            // 
            this.buscarNotaToolStripMenuItem.Name = "buscarNotaToolStripMenuItem";
            this.buscarNotaToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.N)));
            this.buscarNotaToolStripMenuItem.Size = new System.Drawing.Size(220, 22);
            this.buscarNotaToolStripMenuItem.Text = "Buscar nota";
            // 
            // crearNotaToolStripMenuItem
            // 
            this.crearNotaToolStripMenuItem.Name = "crearNotaToolStripMenuItem";
            this.crearNotaToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.R)));
            this.crearNotaToolStripMenuItem.Size = new System.Drawing.Size(220, 22);
            this.crearNotaToolStripMenuItem.Text = "Crear nota";
            // 
            // modificarNotaToolStripMenuItem
            // 
            this.modificarNotaToolStripMenuItem.Name = "modificarNotaToolStripMenuItem";
            this.modificarNotaToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.M)));
            this.modificarNotaToolStripMenuItem.Size = new System.Drawing.Size(220, 22);
            this.modificarNotaToolStripMenuItem.Text = "Modificar nota";
            // 
            // eliminarNotaToolStripMenuItem
            // 
            this.eliminarNotaToolStripMenuItem.Name = "eliminarNotaToolStripMenuItem";
            this.eliminarNotaToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.E)));
            this.eliminarNotaToolStripMenuItem.Size = new System.Drawing.Size(220, 22);
            this.eliminarNotaToolStripMenuItem.Text = "Eliminar nota";
            // 
            // salirToolStripMenuItem
            // 
            this.salirToolStripMenuItem.ForeColor = System.Drawing.Color.Black;
            this.salirToolStripMenuItem.Name = "salirToolStripMenuItem";
            this.salirToolStripMenuItem.Size = new System.Drawing.Size(50, 22);
            this.salirToolStripMenuItem.Text = "Salir";
            this.salirToolStripMenuItem.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // PersonalSanitarioForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.ClientSize = new System.Drawing.Size(955, 610);
            this.Controls.Add(this.panel1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuStrip;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "PersonalSanitarioForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Personal Sanitario";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.menuStrip.ResumeLayout(false);
            this.menuStrip.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Button btnMinimize;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.MenuStrip menuStrip;
        private System.Windows.Forms.ToolStripMenuItem menuItemPacientes;
        private System.Windows.Forms.ToolStripMenuItem buscarPacienteToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem verFichaPacienteToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem sacarEtiquetasDelPacienteToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem verActasClínicosDelPacienteToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem notasToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem buscarNotaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem crearNotaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem modificarNotaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem eliminarNotaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem salirToolStripMenuItem;
    }
}