using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo
{
    public class PacienteDAO
    {
        private FileManager manager;

        public PacienteDAO(string rutaFichero)
        {
            this.manager = new FileManager(rutaFichero);
        }

        public List<Paciente> selectAll()
        {
            List<Paciente> pacientes = new List<Paciente>();
            foreach (string line in manager.readLines())
            {
                pacientes.Add(parsePaciente(line.Split(':')));
            }
            return pacientes;
        }

        public Paciente selectByDni(string dni)
        {
            foreach (string line in manager.readLines())
            {
                if (line.StartsWith(dni))
                    return parsePaciente(line.Split(':'));
            }
            return null;
        }

        public Paciente selectByNhc(int nhc)
        {
            foreach (string line in manager.readLines())
            {
                Paciente paciente = parsePaciente(line.Split(':'));
                if (paciente != null)
                    if (paciente.Nhc == nhc)
                        return paciente;
            }
            return null;
        }

        public bool insert(Paciente paciente)
        {
            return manager.append(parseString(paciente));
        }

        /**
         * Funcion que elemina el contenido entero de un fichero
         */
        public bool nukeTable()
        {
            return manager.write("");
        }

        protected Paciente parsePaciente(string[] data)
        {
            try
            {
                string dni = data[0];
                string nombre = data[1];
                string apellidos = data[2];
                int nhc = int.Parse(data[3]);
                string direccion = data[4];
                string poblacion = data[5];
                try
                {
                    string tlf = data[6];
                    string[] strTlfns = data[7].Split(',');
                    List<String> tlfns = new List<string>();
                    foreach (string strTlf in strTlfns)
                    {
                        tlfns.Add(strTlf);
                    }
                    bool male = bool.Parse(data[8]);
                    long fechaNacimiento = long.Parse(data[9]);
                    string email = data[10];
                    string profecion = data[11];
                    string alergias = data[12];
                    GrupoSanguineo grupoSanguineo = GruposSanguineos.convert(data[13]);
                    string enfermedades = data[14];
                    string entidadSanitaria = data[15];
                    int numAsegurado = int.Parse(data[16]);
                    return new Paciente(dni, nombre, apellidos, nhc, direccion, poblacion, tlf, tlfns,
                    male, fechaNacimiento, email, profecion, alergias, grupoSanguineo, enfermedades, entidadSanitaria,
                    numAsegurado);
                } catch (Exception e)
                {
                    return new Paciente(dni, nombre, apellidos, nhc, direccion, poblacion);
                }
            } catch (Exception e)
            {
                return null;
            }
        }

        protected String parseString(Paciente p)
        {
            String output = p.Dni + ":" + p.Nombre + ":" + p.Apellidos + ":" + p.Nhc + ":" + p.Direccion + ":"
                + p.Poblacion + ":" + p.Tlf + ":";
            for (int i = 0; i < p.OtrosTlf.Count; i++)
            {
                output += p.OtrosTlf[i];
                if (i != (p.OtrosTlf.Count - 1))
                {
                    output += ",";
                } else
                {
                    output += ":";
                }
            }
            output += p.Male + ":" + p.FechaNacimiento + ":" + p.Email + ":" + p.Profecion + ":" + p.Alergias + ":"
                + GruposSanguineos.convertToString(p.GrupoSanguineo) + ":" + p.Enfermedades + ":" + p.EntidadSanitaria + ":"
                + p.NumAsegurado + "\n";
            return output;
        }
    }
}
