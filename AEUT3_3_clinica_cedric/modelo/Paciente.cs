using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo
{ 
    public enum GrupoSanguineo
    {
        O_NEGATIVO,
        O_POSITIVO,
        A_POSITIVO,
        A_NEGATIVO,
        B_POSITIVO,
        B_NEGATIVO,
        AB_POSITIVO,
        AB_NEGATIVO,
        DESCONOCIDO
    }

    public class GruposSanguineos
    {
        public static String convertToString(GrupoSanguineo g)
        {
            switch (g)
            {
                case GrupoSanguineo.O_NEGATIVO:
                    return "0negativo";
                case GrupoSanguineo.O_POSITIVO:
                    return "0positivo";
                case GrupoSanguineo.A_POSITIVO:
                    return "apositivo";
                case GrupoSanguineo.A_NEGATIVO:
                    return "anegativo";
                case GrupoSanguineo.B_POSITIVO:
                    return "bpositivo";
                case GrupoSanguineo.B_NEGATIVO:
                    return "bnegativo";
                case GrupoSanguineo.AB_POSITIVO:
                    return "abpositivo";
                case GrupoSanguineo.AB_NEGATIVO:
                    return "abnegativo";
                default:
                    return "desconocido";
            }
        }

        public static GrupoSanguineo convert(string value)
        {
            switch (value)
            {
                case "0negativo":
                    return GrupoSanguineo.O_NEGATIVO;
                case "0positivo":
                    return GrupoSanguineo.O_POSITIVO;
                case "apositivo":
                    return GrupoSanguineo.A_POSITIVO;
                case "anegativo":
                    return GrupoSanguineo.A_NEGATIVO;
                case "bpositivo":
                    return GrupoSanguineo.B_POSITIVO;
                case "bnegativo":
                    return GrupoSanguineo.B_NEGATIVO;
                case "abpositivo":
                    return GrupoSanguineo.AB_POSITIVO;
                case "abnegativo":
                    return GrupoSanguineo.AB_NEGATIVO;
                default:
                    return GrupoSanguineo.DESCONOCIDO;
            }
        }


        public static GrupoSanguineo convertFromComboBox(string value)
        {
            switch (value)
            {
                case "0 Negativo":
                    return GrupoSanguineo.O_NEGATIVO;
                case "0 Positivo":
                    return GrupoSanguineo.O_POSITIVO;
                case "A Positivo":
                    return GrupoSanguineo.A_POSITIVO;
                case "A Negativo":
                    return GrupoSanguineo.A_NEGATIVO;
                case "B Positivo":
                    return GrupoSanguineo.B_POSITIVO;
                case "B Negativo":
                    return GrupoSanguineo.B_NEGATIVO;
                case "AB Positivo":
                    return GrupoSanguineo.AB_POSITIVO;
                case "AB Negativo":
                    return GrupoSanguineo.AB_NEGATIVO;
                default:
                    return GrupoSanguineo.DESCONOCIDO;
            }
        }
    }
    public class Paciente
    {

        private string dni;
        private string nombre;
        private string apellidos;
        private int nhc;
        private string direccion;
        private string poblacion;
        private string tlf;
        private List<String> otrosTlf;
        private bool male;
        private long fechaNacimiento;
        private string email;
        private string profecion;
        private string alergias;
        private GrupoSanguineo grupoSanguineo;
        private string enfermedades;
        private string entidadSanitaria;
        private int numAsegurado;

        public Paciente()
        {
        }

        /**
         * Constructor con datos obligatorios 
         */
        public Paciente(string dni, string nombre, string apellidos, int nhc, string direccion, string poblacion)
        {
            this.Dni = dni;
            this.Nombre = nombre;
            this.Apellidos = apellidos;
            this.Nhc = nhc;
            this.Direccion = direccion;
            this.Poblacion = poblacion;
            this.otrosTlf = new List<string>();
            this.grupoSanguineo = GrupoSanguineo.DESCONOCIDO;
        }

        /**
         * Constructor completo para PacienteDAO
         */
        public Paciente(string dni, string nombre, string apellidos, int nhc, string direccion, string poblacion, string tlf, List<string> otrosTlf, bool male, long fechaNacimiento, string email, string profecion, string alergias, GrupoSanguineo grupoSanguineo, string enfermedades, string entidadSanitaria, int numAsegurado)
        {
            this.dni = dni;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.nhc = nhc;
            this.direccion = direccion;
            this.poblacion = poblacion;
            this.tlf = tlf;
            this.otrosTlf = otrosTlf;
            this.male = male;
            this.fechaNacimiento = fechaNacimiento;
            this.email = email;
            this.profecion = profecion;
            this.alergias = alergias;
            this.grupoSanguineo = grupoSanguineo;
            this.enfermedades = enfermedades;
            this.entidadSanitaria = entidadSanitaria;
            this.numAsegurado = numAsegurado;
        }


        public string Dni { get => dni; set => dni = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Apellidos { get => apellidos; set => apellidos = value; }
        public int Nhc { get => nhc; set => nhc = value; }
        public string Direccion { get => direccion; set => direccion = value; }
        public string Poblacion { get => poblacion; set => poblacion = value; }
        public string Tlf { get => tlf; set => tlf = value; }
        public List<string> OtrosTlf { get => otrosTlf; set => otrosTlf = value; }
        public bool Male { get => male; set => male = value; }
        public long FechaNacimiento { get => fechaNacimiento; set => fechaNacimiento = value; }
        public string Email { get => email; set => email = value; }
        public string Profecion { get => profecion; set => profecion = value; }
        public string Alergias { get => alergias; set => alergias = value; }
        public GrupoSanguineo GrupoSanguineo { get => grupoSanguineo; set => grupoSanguineo = value; }
        public string Enfermedades { get => enfermedades; set => enfermedades = value; }
        public string EntidadSanitaria { get => entidadSanitaria; set => entidadSanitaria = value; }
        public int NumAsegurado { get => numAsegurado; set => numAsegurado = value; }

        public void setGrupoSanguineo(string valor)
        {
            grupoSanguineo = GruposSanguineos.convert(valor);
        }
        public bool isValid()
        {
            if (checkDni() && !String.IsNullOrWhiteSpace(nombre) && !String.IsNullOrWhiteSpace(apellidos) && !String.IsNullOrWhiteSpace(direccion) && !String.IsNullOrWhiteSpace(poblacion))
            {
                return true;
            }
            return false;
        }

        private bool checkDni()
        {
            string dniNumeros = dni.Substring(0, dni.Length - 1);
            string dniLetra = dni.Substring(dni.Length - 1, 1);
            bool numbersValid = int.TryParse(dniNumeros, out int dniInteger);
            if (!numbersValid)
            {
                return false;
            }
            if (calcularLetraDni(dniInteger) != dniLetra)
            {
                return false;
            }
            return true;
        }

        private static string calcularLetraDni(int dniNumbers)
        {
            //Cargamos los digitos de control
            string[] control = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E" };
            var mod = dniNumbers % 23;
            return control[mod];
        }
    }
}
