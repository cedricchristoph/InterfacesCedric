using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using modelo;
namespace controlador
{
    public class EliminarPacienteController
    {
        PacienteDAO dao;
        public EliminarPacienteController()
        {
            dao = new PacienteDAO("pacientes.txt");
        }

        public List<Paciente> buscarParcial(string dni)
        {
            return dao.selectByDniParcial(dni);
        }

        public List<Paciente> buscarParcial(int nhc)
        {
            return dao.selectByNhcParcial(nhc);
        }

        public Paciente buscar(string dni)
        {
            return dao.selectByDni(dni);
        }

        public bool delete(Paciente paciente)
        {
            return dao.delete(paciente);
        }
    }
}
