
namespace AppTiendaCedric
{
    partial class CategoriaDetalles
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
            this.btnView = new System.Windows.Forms.Button();
            this.btnAdd = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.cbxFilter = new System.Windows.Forms.ComboBox();
            this.dataGrid = new System.Windows.Forms.DataGridView();
            this.toppanel = new System.Windows.Forms.Panel();
            this.button1 = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.mainpanel.SuspendLayout();
            this.bodypanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGrid)).BeginInit();
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
            this.mainpanel.Size = new System.Drawing.Size(635, 481);
            this.mainpanel.TabIndex = 0;
            // 
            // bodypanel
            // 
            this.bodypanel.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.bodypanel.BackColor = System.Drawing.Color.Transparent;
            this.bodypanel.Controls.Add(this.btnView);
            this.bodypanel.Controls.Add(this.btnAdd);
            this.bodypanel.Controls.Add(this.label3);
            this.bodypanel.Controls.Add(this.cbxFilter);
            this.bodypanel.Controls.Add(this.dataGrid);
            this.bodypanel.Location = new System.Drawing.Point(11, 45);
            this.bodypanel.Name = "bodypanel";
            this.bodypanel.Size = new System.Drawing.Size(611, 419);
            this.bodypanel.TabIndex = 1;
            // 
            // btnView
            // 
            this.btnView.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.btnView.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(242)))));
            this.btnView.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(226)))), ((int)(((byte)(226)))), ((int)(((byte)(233)))));
            this.btnView.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(37)))), ((int)(((byte)(133)))), ((int)(((byte)(211)))));
            this.btnView.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(143)))), ((int)(((byte)(175)))), ((int)(((byte)(202)))));
            this.btnView.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnView.Font = new System.Drawing.Font("Yu Gothic", 11F);
            this.btnView.Location = new System.Drawing.Point(454, 363);
            this.btnView.Name = "btnView";
            this.btnView.Size = new System.Drawing.Size(157, 34);
            this.btnView.TabIndex = 7;
            this.btnView.Text = "View";
            this.btnView.UseVisualStyleBackColor = false;
            this.btnView.Click += new System.EventHandler(this.btnView_Click);
            // 
            // btnAdd
            // 
            this.btnAdd.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.btnAdd.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(242)))));
            this.btnAdd.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(226)))), ((int)(((byte)(226)))), ((int)(((byte)(233)))));
            this.btnAdd.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(37)))), ((int)(((byte)(133)))), ((int)(((byte)(211)))));
            this.btnAdd.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(143)))), ((int)(((byte)(175)))), ((int)(((byte)(202)))));
            this.btnAdd.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnAdd.Font = new System.Drawing.Font("Yu Gothic", 11F);
            this.btnAdd.Location = new System.Drawing.Point(454, 323);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(157, 34);
            this.btnAdd.TabIndex = 6;
            this.btnAdd.Text = "Add";
            this.btnAdd.UseVisualStyleBackColor = false;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // label3
            // 
            this.label3.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Yu Gothic", 10F);
            this.label3.Location = new System.Drawing.Point(1, 333);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(98, 18);
            this.label3.TabIndex = 3;
            this.label3.Text = "Cambiar filtro";
            // 
            // cbxFilter
            // 
            this.cbxFilter.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.cbxFilter.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbxFilter.FormattingEnabled = true;
            this.cbxFilter.Location = new System.Drawing.Point(3, 354);
            this.cbxFilter.Name = "cbxFilter";
            this.cbxFilter.Size = new System.Drawing.Size(222, 28);
            this.cbxFilter.TabIndex = 1;
            this.cbxFilter.SelectedIndexChanged += new System.EventHandler(this.cbxFilter_SelectedIndexChanged);
            // 
            // dataGrid
            // 
            this.dataGrid.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dataGrid.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(242)))));
            this.dataGrid.Location = new System.Drawing.Point(0, 0);
            this.dataGrid.Name = "dataGrid";
            this.dataGrid.ReadOnly = true;
            this.dataGrid.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGrid.ShowCellToolTips = false;
            this.dataGrid.ShowEditingIcon = false;
            this.dataGrid.Size = new System.Drawing.Size(611, 304);
            this.dataGrid.TabIndex = 0;
            this.dataGrid.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGrid_CellClick);
            // 
            // toppanel
            // 
            this.toppanel.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.toppanel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(242)))));
            this.toppanel.Controls.Add(this.button1);
            this.toppanel.Controls.Add(this.btnExit);
            this.toppanel.Controls.Add(this.label1);
            this.toppanel.Location = new System.Drawing.Point(-1, -1);
            this.toppanel.Name = "toppanel";
            this.toppanel.Size = new System.Drawing.Size(635, 34);
            this.toppanel.TabIndex = 0;
            this.toppanel.MouseDown += new System.Windows.Forms.MouseEventHandler(this.topPanel_MouseDown);
            // 
            // button1
            // 
            this.button1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.button1.FlatAppearance.BorderSize = 0;
            this.button1.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(37)))), ((int)(((byte)(133)))), ((int)(((byte)(211)))));
            this.button1.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(248)))), ((int)(((byte)(248)))), ((int)(((byte)(250)))));
            this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button1.Font = new System.Drawing.Font("Yu Gothic", 10.6F);
            this.button1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.button1.Location = new System.Drawing.Point(516, -2);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(57, 34);
            this.button1.TabIndex = 3;
            this.button1.Text = "🗖";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
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
            this.btnExit.Location = new System.Drawing.Point(578, -1);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(57, 34);
            this.btnExit.TabIndex = 2;
            this.btnExit.Text = "✖";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Yu Gothic", 10F);
            this.label1.Location = new System.Drawing.Point(9, 8);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(112, 18);
            this.label1.TabIndex = 1;
            this.label1.Text = "Categoria: MAN";
            // 
            // CategoriaDetalles
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(635, 481);
            this.Controls.Add(this.mainpanel);
            this.Font = new System.Drawing.Font("Yu Gothic", 11F);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "CategoriaDetalles";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.mainpanel.ResumeLayout(false);
            this.bodypanel.ResumeLayout(false);
            this.bodypanel.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGrid)).EndInit();
            this.toppanel.ResumeLayout(false);
            this.toppanel.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel mainpanel;
        private System.Windows.Forms.Panel bodypanel;
        private System.Windows.Forms.Panel toppanel;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DataGridView dataGrid;
        private System.Windows.Forms.ComboBox cbxFilter;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnView;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button btnExit;
    }
}