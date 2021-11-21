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
                pacientes.Add(Paciente.parsePaciente(line));
            }
            return pacientes;
        }

        public Paciente selectByDni(string dni)
        {
            foreach (string line in manager.readLines())
            {
                if (line.StartsWith(dni))
                    return Paciente.parsePaciente(line);
            }
            return null;
        }

        public List<Paciente> selectByDniParcial(string include)
        {
            List<Paciente> pacientes = new List<Paciente>();
            foreach (string line in manager.readLines())
            {
                if (line.StartsWith(include))
                    pacientes.Add(Paciente.parsePaciente(line));
            }
            return pacientes;
        }

        public Paciente selectByNhc(int nhc)
        {
            foreach (string line in manager.readLines())
            {
                Paciente paciente = Paciente.parsePaciente(line);
                if (paciente != null)
                    if (paciente.Nhc == nhc)
                        return paciente;
            }
            return null;
        }

        public List<Paciente> selectByNhcParcial(int include)
        {
            List<Paciente> pacientes = new List<Paciente>();
            foreach (string line in manager.readLines())
            {
                Paciente paciente = Paciente.parsePaciente(line);
                if (paciente != null)
                    if (paciente.Nhc.ToString().StartsWith(include.ToString()))
                        pacientes.Add(paciente);
            }
            return pacientes;
        }

        public bool insert(Paciente paciente)
        {
            return manager.append(paciente.toString());
        }

        public bool insertAll(List<Paciente> pacientes)
        {
            bool error = false;
            foreach (Paciente p in pacientes)
            {
                if (p != null)
                {
                    bool ok = manager.append(p.toString());
                    if (!ok)
                        error = true;
                }
            }
            return !error;
        }

        public bool delete(Paciente paciente)
        {
            List<Paciente> pacientes = selectAll();
            pacientes.Remove(paciente);
            bool nuked = nukeTable();
            bool inserted = insertAll(pacientes);
            return (nuked && inserted);
        }

        /**
         * Funcion que elemina el contenido entero de un fichero
         */
        public bool nukeTable()
        {
            return manager.write("");
        }
    }
}
