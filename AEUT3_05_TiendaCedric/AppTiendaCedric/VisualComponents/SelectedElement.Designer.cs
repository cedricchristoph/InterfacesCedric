
namespace VisualComponents
{
    partial class SelectedElement
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

        #region Código generado por el Diseñador de componentes

        /// <summary> 
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.label = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.id = new System.Windows.Forms.Label();
            this.name = new System.Windows.Forms.Label();
            this.category = new System.Windows.Forms.Label();
            this.quantity = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::VisualComponents.Properties.Resources.info_icon;
            this.pictureBox1.Location = new System.Drawing.Point(17, 37);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(67, 59);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // label
            // 
            this.label.AutoSize = true;
            this.label.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.label.Location = new System.Drawing.Point(96, 28);
            this.label.Name = "label";
            this.label.Size = new System.Drawing.Size(25, 17);
            this.label.TabIndex = 1;
            this.label.Text = "ID:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.label1.Location = new System.Drawing.Point(96, 48);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(49, 17);
            this.label1.TabIndex = 2;
            this.label1.Text = "Name:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.label2.Location = new System.Drawing.Point(96, 69);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(69, 17);
            this.label2.TabIndex = 3;
            this.label2.Text = "Category:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.label3.Location = new System.Drawing.Point(96, 90);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(65, 17);
            this.label3.TabIndex = 4;
            this.label3.Text = "Quantity:";
            // 
            // id
            // 
            this.id.AutoSize = true;
            this.id.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.id.Location = new System.Drawing.Point(119, 28);
            this.id.Name = "id";
            this.id.Size = new System.Drawing.Size(56, 17);
            this.id.TabIndex = 5;
            this.id.Text = "000000";
            // 
            // name
            // 
            this.name.AutoSize = true;
            this.name.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.name.Location = new System.Drawing.Point(144, 48);
            this.name.Name = "name";
            this.name.Size = new System.Drawing.Size(89, 17);
            this.name.TabIndex = 6;
            this.name.Text = "Lorem ipsum";
            // 
            // category
            // 
            this.category.AutoSize = true;
            this.category.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.category.Location = new System.Drawing.Point(164, 69);
            this.category.Name = "category";
            this.category.Size = new System.Drawing.Size(89, 17);
            this.category.TabIndex = 7;
            this.category.Text = "Lorem ipsum";
            // 
            // quantity
            // 
            this.quantity.AutoSize = true;
            this.quantity.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.quantity.Location = new System.Drawing.Point(158, 90);
            this.quantity.Name = "quantity";
            this.quantity.Size = new System.Drawing.Size(56, 17);
            this.quantity.TabIndex = 8;
            this.quantity.Text = "000000";
            // 
            // SelectedElement
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(242)))));
            this.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Controls.Add(this.quantity);
            this.Controls.Add(this.category);
            this.Controls.Add(this.name);
            this.Controls.Add(this.id);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.label);
            this.Controls.Add(this.pictureBox1);
            this.Name = "SelectedElement";
            this.Size = new System.Drawing.Size(317, 142);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label id;
        private System.Windows.Forms.Label name;
        private System.Windows.Forms.Label category;
        private System.Windows.Forms.Label quantity;
    }
}
