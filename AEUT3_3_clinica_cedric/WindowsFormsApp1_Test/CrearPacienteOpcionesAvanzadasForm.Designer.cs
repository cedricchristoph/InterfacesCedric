
namespace WindowsFormsApp1_Test
{
    partial class CrearPacienteOpcionesAvanzadasForm
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
            this.panel3 = new System.Windows.Forms.Panel();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.txtAddTlf = new System.Windows.Forms.MaskedTextBox();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.label9 = new System.Windows.Forms.Label();
            this.cbxSexo = new System.Windows.Forms.ComboBox();
            this.txtFechaNacimiento = new System.Windows.Forms.MaskedTextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.txtProfecion = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.txtEmail = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.listViewTelefonos = new System.Windows.Forms.ListView();
            this.btnAddTlf = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.txtTlf = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.txtNumAsegurado = new System.Windows.Forms.TextBox();
            this.label14 = new System.Windows.Forms.Label();
            this.txtEntidadSanitaria = new System.Windows.Forms.TextBox();
            this.label13 = new System.Windows.Forms.Label();
            this.cbxGrupoSanguineo = new System.Windows.Forms.ComboBox();
            this.label12 = new System.Windows.Forms.Label();
            this.txtEnfermedades = new System.Windows.Forms.TextBox();
            this.label11 = new System.Windows.Forms.Label();
            this.txtAlergias = new System.Windows.Forms.TextBox();
            this.label10 = new System.Windows.Forms.Label();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.btnCrear = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.panel4 = new System.Windows.Forms.Panel();
            this.label7 = new System.Windows.Forms.Label();
            this.btnMinimizar = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.panel3.SuspendLayout();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.panel4.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel3
            // 
            this.panel3.BackColor = System.Drawing.Color.White;
            this.panel3.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel3.Controls.Add(this.tabControl1);
            this.panel3.Controls.Add(this.btnCancelar);
            this.panel3.Controls.Add(this.btnCrear);
            this.panel3.Controls.Add(this.label5);
            this.panel3.Controls.Add(this.panel4);
            this.panel3.ForeColor = System.Drawing.Color.White;
            this.panel3.Location = new System.Drawing.Point(0, 0);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(642, 511);
            this.panel3.TabIndex = 16;
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Font = new System.Drawing.Font("Yu Gothic", 11F);
            this.tabControl1.Location = new System.Drawing.Point(0, 50);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(637, 403);
            this.tabControl1.TabIndex = 28;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.txtAddTlf);
            this.tabPage1.Controls.Add(this.txtNombre);
            this.tabPage1.Controls.Add(this.label9);
            this.tabPage1.Controls.Add(this.cbxSexo);
            this.tabPage1.Controls.Add(this.txtFechaNacimiento);
            this.tabPage1.Controls.Add(this.label8);
            this.tabPage1.Controls.Add(this.txtProfecion);
            this.tabPage1.Controls.Add(this.label6);
            this.tabPage1.Controls.Add(this.label4);
            this.tabPage1.Controls.Add(this.txtEmail);
            this.tabPage1.Controls.Add(this.label3);
            this.tabPage1.Controls.Add(this.listViewTelefonos);
            this.tabPage1.Controls.Add(this.btnAddTlf);
            this.tabPage1.Controls.Add(this.label2);
            this.tabPage1.Controls.Add(this.txtTlf);
            this.tabPage1.Controls.Add(this.label1);
            this.tabPage1.Font = new System.Drawing.Font("Yu Gothic", 12F);
            this.tabPage1.ForeColor = System.Drawing.Color.Black;
            this.tabPage1.Location = new System.Drawing.Point(4, 29);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(629, 370);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Datos personales";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // txtAddTlf
            // 
            this.txtAddTlf.Font = new System.Drawing.Font("Verdana", 14F);
            this.txtAddTlf.Location = new System.Drawing.Point(384, 108);
            this.txtAddTlf.Mask = "+(99) 000 000 000";
            this.txtAddTlf.Name = "txtAddTlf";
            this.txtAddTlf.Size = new System.Drawing.Size(215, 30);
            this.txtAddTlf.TabIndex = 6;
            this.txtAddTlf.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // txtNombre
            // 
            this.txtNombre.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtNombre.Font = new System.Drawing.Font("Verdana", 12F);
            this.txtNombre.Location = new System.Drawing.Point(27, 43);
            this.txtNombre.MaxLength = 50;
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.ReadOnly = true;
            this.txtNombre.Size = new System.Drawing.Size(325, 27);
            this.txtNombre.TabIndex = 0;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.ForeColor = System.Drawing.Color.Black;
            this.label9.Location = new System.Drawing.Point(23, 19);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(247, 21);
            this.label9.TabIndex = 40;
            this.label9.Text = "Nombre y apellidos del paciente";
            // 
            // cbxSexo
            // 
            this.cbxSexo.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbxSexo.FormattingEnabled = true;
            this.cbxSexo.Items.AddRange(new object[] {
            "Mujer",
            "Hombre"});
            this.cbxSexo.Location = new System.Drawing.Point(205, 110);
            this.cbxSexo.Name = "cbxSexo";
            this.cbxSexo.Size = new System.Drawing.Size(147, 29);
            this.cbxSexo.TabIndex = 2;
            // 
            // txtFechaNacimiento
            // 
            this.txtFechaNacimiento.Font = new System.Drawing.Font("Verdana", 14F);
            this.txtFechaNacimiento.Location = new System.Drawing.Point(27, 110);
            this.txtFechaNacimiento.Mask = "00/00/0000";
            this.txtFechaNacimiento.Name = "txtFechaNacimiento";
            this.txtFechaNacimiento.PromptChar = '-';
            this.txtFechaNacimiento.Size = new System.Drawing.Size(159, 30);
            this.txtFechaNacimiento.TabIndex = 1;
            this.txtFechaNacimiento.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.txtFechaNacimiento.ValidatingType = typeof(System.DateTime);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.ForeColor = System.Drawing.Color.Black;
            this.label8.Location = new System.Drawing.Point(201, 86);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(46, 21);
            this.label8.TabIndex = 37;
            this.label8.Text = "Sexo";
            // 
            // txtProfecion
            // 
            this.txtProfecion.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtProfecion.Font = new System.Drawing.Font("Verdana", 12F);
            this.txtProfecion.Location = new System.Drawing.Point(27, 176);
            this.txtProfecion.MaxLength = 50;
            this.txtProfecion.Name = "txtProfecion";
            this.txtProfecion.Size = new System.Drawing.Size(325, 27);
            this.txtProfecion.TabIndex = 3;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.ForeColor = System.Drawing.Color.Black;
            this.label6.Location = new System.Drawing.Point(23, 152);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(81, 21);
            this.label6.TabIndex = 35;
            this.label6.Text = "Profeción";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.ForeColor = System.Drawing.Color.Black;
            this.label4.Location = new System.Drawing.Point(23, 87);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(163, 21);
            this.label4.TabIndex = 33;
            this.label4.Text = "Fecha de nacimiento";
            // 
            // txtEmail
            // 
            this.txtEmail.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtEmail.Font = new System.Drawing.Font("Verdana", 12F);
            this.txtEmail.Location = new System.Drawing.Point(27, 239);
            this.txtEmail.MaxLength = 50;
            this.txtEmail.Name = "txtEmail";
            this.txtEmail.Size = new System.Drawing.Size(325, 27);
            this.txtEmail.TabIndex = 4;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.ForeColor = System.Drawing.Color.Black;
            this.label3.Location = new System.Drawing.Point(23, 214);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(59, 21);
            this.label3.TabIndex = 31;
            this.label3.Text = "E-Mail";
            // 
            // listViewTelefonos
            // 
            this.listViewTelefonos.BackColor = System.Drawing.Color.White;
            this.listViewTelefonos.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.listViewTelefonos.HideSelection = false;
            this.listViewTelefonos.Location = new System.Drawing.Point(384, 187);
            this.listViewTelefonos.Name = "listViewTelefonos";
            this.listViewTelefonos.Size = new System.Drawing.Size(215, 166);
            this.listViewTelefonos.TabIndex = 30;
            this.listViewTelefonos.UseCompatibleStateImageBehavior = false;
            this.listViewTelefonos.View = System.Windows.Forms.View.List;
            // 
            // btnAddTlf
            // 
            this.btnAddTlf.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.btnAddTlf.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnAddTlf.FlatAppearance.BorderSize = 0;
            this.btnAddTlf.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(89)))), ((int)(((byte)(159)))), ((int)(((byte)(255)))));
            this.btnAddTlf.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(164)))), ((int)(((byte)(203)))), ((int)(((byte)(255)))));
            this.btnAddTlf.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnAddTlf.Font = new System.Drawing.Font("Yu Gothic", 10F);
            this.btnAddTlf.ForeColor = System.Drawing.Color.Black;
            this.btnAddTlf.Location = new System.Drawing.Point(384, 145);
            this.btnAddTlf.Name = "btnAddTlf";
            this.btnAddTlf.Size = new System.Drawing.Size(215, 29);
            this.btnAddTlf.TabIndex = 7;
            this.btnAddTlf.Text = "☎ Añadir teléfono";
            this.btnAddTlf.UseVisualStyleBackColor = false;
            this.btnAddTlf.Click += new System.EventHandler(this.btnAddTlf_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.ForeColor = System.Drawing.Color.Black;
            this.label2.Location = new System.Drawing.Point(380, 86);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(174, 21);
            this.label2.TabIndex = 23;
            this.label2.Text = "Teléfonos secundarios";
            // 
            // txtTlf
            // 
            this.txtTlf.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtTlf.Font = new System.Drawing.Font("Verdana", 12F);
            this.txtTlf.Location = new System.Drawing.Point(384, 43);
            this.txtTlf.MaxLength = 50;
            this.txtTlf.Name = "txtTlf";
            this.txtTlf.Size = new System.Drawing.Size(215, 27);
            this.txtTlf.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.ForeColor = System.Drawing.Color.Black;
            this.label1.Location = new System.Drawing.Point(380, 19);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(140, 21);
            this.label1.TabIndex = 0;
            this.label1.Text = "Teléfono principal";
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.txtNumAsegurado);
            this.tabPage2.Controls.Add(this.label14);
            this.tabPage2.Controls.Add(this.txtEntidadSanitaria);
            this.tabPage2.Controls.Add(this.label13);
            this.tabPage2.Controls.Add(this.cbxGrupoSanguineo);
            this.tabPage2.Controls.Add(this.label12);
            this.tabPage2.Controls.Add(this.txtEnfermedades);
            this.tabPage2.Controls.Add(this.label11);
            this.tabPage2.Controls.Add(this.txtAlergias);
            this.tabPage2.Controls.Add(this.label10);
            this.tabPage2.Location = new System.Drawing.Point(4, 29);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(629, 370);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Datos médicos";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // txtNumAsegurado
            // 
            this.txtNumAsegurado.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtNumAsegurado.Font = new System.Drawing.Font("Verdana", 12F);
            this.txtNumAsegurado.Location = new System.Drawing.Point(382, 175);
            this.txtNumAsegurado.MaxLength = 50;
            this.txtNumAsegurado.Name = "txtNumAsegurado";
            this.txtNumAsegurado.Size = new System.Drawing.Size(229, 27);
            this.txtNumAsegurado.TabIndex = 12;
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.ForeColor = System.Drawing.Color.Black;
            this.label14.Location = new System.Drawing.Point(378, 152);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(138, 20);
            this.label14.TabIndex = 47;
            this.label14.Text = "Numero asegurado";
            // 
            // txtEntidadSanitaria
            // 
            this.txtEntidadSanitaria.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtEntidadSanitaria.Font = new System.Drawing.Font("Verdana", 12F);
            this.txtEntidadSanitaria.Location = new System.Drawing.Point(382, 110);
            this.txtEntidadSanitaria.MaxLength = 50;
            this.txtEntidadSanitaria.Name = "txtEntidadSanitaria";
            this.txtEntidadSanitaria.Size = new System.Drawing.Size(229, 27);
            this.txtEntidadSanitaria.TabIndex = 11;
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.ForeColor = System.Drawing.Color.Black;
            this.label13.Location = new System.Drawing.Point(378, 87);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(125, 20);
            this.label13.TabIndex = 45;
            this.label13.Text = "Entidad sanitaria";
            // 
            // cbxGrupoSanguineo
            // 
            this.cbxGrupoSanguineo.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbxGrupoSanguineo.FormattingEnabled = true;
            this.cbxGrupoSanguineo.Items.AddRange(new object[] {
            "0 Negativo",
            "0 Positivo",
            "B Negativo",
            "B Positivo",
            "A Negativo",
            "A Positivo",
            "AB Negativo",
            "AB Positivo"});
            this.cbxGrupoSanguineo.Location = new System.Drawing.Point(382, 43);
            this.cbxGrupoSanguineo.Name = "cbxGrupoSanguineo";
            this.cbxGrupoSanguineo.Size = new System.Drawing.Size(229, 28);
            this.cbxGrupoSanguineo.TabIndex = 10;
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.ForeColor = System.Drawing.Color.Black;
            this.label12.Location = new System.Drawing.Point(378, 19);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(126, 20);
            this.label12.TabIndex = 43;
            this.label12.Text = "Grupo sanguíneo";
            // 
            // txtEnfermedades
            // 
            this.txtEnfermedades.Font = new System.Drawing.Font("Verdana", 12F);
            this.txtEnfermedades.Location = new System.Drawing.Point(27, 213);
            this.txtEnfermedades.MaxLength = 50;
            this.txtEnfermedades.Multiline = true;
            this.txtEnfermedades.Name = "txtEnfermedades";
            this.txtEnfermedades.Size = new System.Drawing.Size(340, 132);
            this.txtEnfermedades.TabIndex = 9;
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.ForeColor = System.Drawing.Color.Black;
            this.label11.Location = new System.Drawing.Point(23, 190);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(108, 20);
            this.label11.TabIndex = 41;
            this.label11.Text = "Enfermedades";
            // 
            // txtAlergias
            // 
            this.txtAlergias.Font = new System.Drawing.Font("Verdana", 12F);
            this.txtAlergias.Location = new System.Drawing.Point(27, 43);
            this.txtAlergias.MaxLength = 50;
            this.txtAlergias.Multiline = true;
            this.txtAlergias.Name = "txtAlergias";
            this.txtAlergias.Size = new System.Drawing.Size(340, 132);
            this.txtAlergias.TabIndex = 8;
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.ForeColor = System.Drawing.Color.Black;
            this.label10.Location = new System.Drawing.Point(23, 19);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(64, 20);
            this.label10.TabIndex = 39;
            this.label10.Text = "Alergias";
            // 
            // btnCancelar
            // 
            this.btnCancelar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.btnCancelar.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnCancelar.FlatAppearance.BorderSize = 0;
            this.btnCancelar.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Firebrick;
            this.btnCancelar.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(204)))), ((int)(((byte)(204)))));
            this.btnCancelar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnCancelar.Font = new System.Drawing.Font("Yu Gothic", 12F);
            this.btnCancelar.ForeColor = System.Drawing.Color.Black;
            this.btnCancelar.Location = new System.Drawing.Point(352, 464);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(94, 34);
            this.btnCancelar.TabIndex = 98;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.UseVisualStyleBackColor = false;
            this.btnCancelar.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // btnCrear
            // 
            this.btnCrear.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.btnCrear.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnCrear.FlatAppearance.BorderSize = 0;
            this.btnCrear.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(89)))), ((int)(((byte)(159)))), ((int)(((byte)(255)))));
            this.btnCrear.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(164)))), ((int)(((byte)(203)))), ((int)(((byte)(255)))));
            this.btnCrear.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnCrear.Font = new System.Drawing.Font("Yu Gothic", 12F);
            this.btnCrear.ForeColor = System.Drawing.Color.Black;
            this.btnCrear.Location = new System.Drawing.Point(452, 464);
            this.btnCrear.Name = "btnCrear";
            this.btnCrear.Size = new System.Drawing.Size(175, 34);
            this.btnCrear.TabIndex = 97;
            this.btnCrear.Text = "Guardar";
            this.btnCrear.UseVisualStyleBackColor = false;
            this.btnCrear.Click += new System.EventHandler(this.btnCrear_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Yu Gothic UI", 10.25F);
            this.label5.Location = new System.Drawing.Point(12, 749);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(121, 19);
            this.label5.TabIndex = 11;
            this.label5.Text = "Downloading 58%";
            // 
            // panel4
            // 
            this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.panel4.Controls.Add(this.label7);
            this.panel4.Controls.Add(this.btnMinimizar);
            this.panel4.Controls.Add(this.btnExit);
            this.panel4.Location = new System.Drawing.Point(-1, -1);
            this.panel4.Name = "panel4";
            this.panel4.Size = new System.Drawing.Size(642, 52);
            this.panel4.TabIndex = 5;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Yu Gothic UI", 12F, System.Drawing.FontStyle.Bold);
            this.label7.ForeColor = System.Drawing.Color.Black;
            this.label7.Location = new System.Drawing.Point(13, 17);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(156, 21);
            this.label7.TabIndex = 6;
            this.label7.Text = "Opciones avanzadas";
            // 
            // btnMinimizar
            // 
            this.btnMinimizar.BackColor = System.Drawing.Color.Transparent;
            this.btnMinimizar.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.btnMinimizar.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(164)))), ((int)(((byte)(203)))), ((int)(((byte)(255)))));
            this.btnMinimizar.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(235)))), ((int)(((byte)(235)))), ((int)(((byte)(235)))));
            this.btnMinimizar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMinimizar.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F);
            this.btnMinimizar.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.btnMinimizar.Location = new System.Drawing.Point(512, -1);
            this.btnMinimizar.Name = "btnMinimizar";
            this.btnMinimizar.Size = new System.Drawing.Size(70, 53);
            this.btnMinimizar.TabIndex = 99;
            this.btnMinimizar.Text = "▄";
            this.btnMinimizar.UseVisualStyleBackColor = false;
            this.btnMinimizar.Click += new System.EventHandler(this.btnMinimizar_Click);
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
            this.btnExit.Location = new System.Drawing.Point(579, -1);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(67, 53);
            this.btnExit.TabIndex = 100;
            this.btnExit.Text = "✖";
            this.btnExit.UseVisualStyleBackColor = false;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // CrearPacienteOpcionesAvanzadasForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.ClientSize = new System.Drawing.Size(642, 511);
            this.Controls.Add(this.panel3);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.25F);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "CrearPacienteOpcionesAvanzadasForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Opciones Avanzadas";
            this.Load += new System.EventHandler(this.CrearPacienteOpcionesAvanzadasForm_Load);
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            this.panel4.ResumeLayout(false);
            this.panel4.PerformLayout();
            this.ResumeLayout(false);

            }

            #endregion
            private System.Windows.Forms.Panel panel3;
            private System.Windows.Forms.Label label5;
            private System.Windows.Forms.Panel panel4;
            private System.Windows.Forms.Label label7;
            private System.Windows.Forms.Button btnMinimizar;
            private System.Windows.Forms.Button btnExit;
            private System.Windows.Forms.Button btnCancelar;
            private System.Windows.Forms.Button btnCrear;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ListView listViewTelefonos;
        private System.Windows.Forms.Button btnAddTlf;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtTlf;
        private System.Windows.Forms.TextBox txtEmail;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtProfecion;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtNombre;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.ComboBox cbxSexo;
        private System.Windows.Forms.MaskedTextBox txtFechaNacimiento;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.TextBox txtEnfermedades;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.TextBox txtAlergias;
        private System.Windows.Forms.ComboBox cbxGrupoSanguineo;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.TextBox txtNumAsegurado;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.TextBox txtEntidadSanitaria;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.MaskedTextBox txtAddTlf;
    }




    
}