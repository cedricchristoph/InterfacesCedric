using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using modelo;


namespace controlador
{
    public class CrearPacienteController
    {
        Paciente pacienteCreado;
        public CrearPacienteController()
        {
            PacienteCreado = null;
        }

        public Paciente PacienteCreado { get => pacienteCreado; set => pacienteCreado = value; }

        public bool crearPaciente(string dni, string nombre, string apellidos, int nhc, string direccion, string poblacion)
        {
            PacienteCreado = new Paciente(dni, nombre, apellidos, nhc, direccion, poblacion);
            if (!PacienteCreado.isValid())
            {
                PacienteCreado = null;
                return false;
            }
            return true;
        }

        public bool guardar()
        {
            PacienteDAO dao = new PacienteDAO("pacientes.txt");
            return dao.insert(pacienteCreado);
        }

        public Boolean actualizarPaciente(String fechaNacimiento,
                Boolean male, String profecion, String email, String tlfPrincipal,
                List<String>tlf, String alergias, String enfermedades, 
                String grupoSanguineo, String entidadSanitaria,
                int numeroAsegurado)
        {
            try
            {
                pacienteCreado.FechaNacimiento = Convert.ToDateTime(fechaNacimiento).Millisecond;
                pacienteCreado.Male = male;
                pacienteCreado.Profecion = profecion;
                pacienteCreado.Email = email;
                pacienteCreado.Tlf = tlfPrincipal;
                pacienteCreado.OtrosTlf = tlf;
                pacienteCreado.Alergias = alergias;
                pacienteCreado.Enfermedades = enfermedades;
                pacienteCreado.GrupoSanguineo = GruposSanguineos.convertFromComboBox(grupoSanguineo);
                pacienteCreado.EntidadSanitaria = entidadSanitaria;
                pacienteCreado.NumAsegurado = numeroAsegurado;
                return true;
            } catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return false;
            }
        }
    }
}
