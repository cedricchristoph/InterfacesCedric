
namespace AppTiendaCedric
{
    partial class ViewElement
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
            this.toppanel = new System.Windows.Forms.Panel();
            this.btnExit = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.selectedElement1 = new VisualComponents.SelectedElement();
            this.mainpanel.SuspendLayout();
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
            this.mainpanel.Controls.Add(this.selectedElement1);
            this.mainpanel.Controls.Add(this.toppanel);
            this.mainpanel.Location = new System.Drawing.Point(0, 0);
            this.mainpanel.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.mainpanel.Name = "mainpanel";
            this.mainpanel.Size = new System.Drawing.Size(433, 242);
            this.mainpanel.TabIndex = 0;
            // 
            // toppanel
            // 
            this.toppanel.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.toppanel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(242)))));
            this.toppanel.Controls.Add(this.btnExit);
            this.toppanel.Controls.Add(this.label1);
            this.toppanel.Location = new System.Drawing.Point(-1, -1);
            this.toppanel.Name = "toppanel";
            this.toppanel.Size = new System.Drawing.Size(433, 34);
            this.toppanel.TabIndex = 0;
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
            this.btnExit.Location = new System.Drawing.Point(376, -1);
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
            // selectedElement1
            // 
            this.selectedElement1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(242)))));
            this.selectedElement1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.selectedElement1.Location = new System.Drawing.Point(-1, 32);
            this.selectedElement1.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.selectedElement1.Name = "selectedElement1";
            this.selectedElement1.Size = new System.Drawing.Size(432, 209);
            this.selectedElement1.TabIndex = 1;
            // 
            // ViewElement
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(433, 242);
            this.Controls.Add(this.mainpanel);
            this.Font = new System.Drawing.Font("Yu Gothic", 11F);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "ViewElement";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.mainpanel.ResumeLayout(false);
            this.toppanel.ResumeLayout(false);
            this.toppanel.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel mainpanel;
        private System.Windows.Forms.Panel toppanel;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnExit;
        private VisualComponents.SelectedElement selectedElement1;
    }
}