using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using modelo;
namespace controlador
{
    public class BuscarPacienteController
    {
        List<Paciente> resultados;
        PacienteDAO dao;
        public BuscarPacienteController()
        {
            dao = new PacienteDAO("pacientes.txt");
        }

        public List<Paciente> Resultados { get => resultados; set => resultados = value; }

        public List<Paciente> buscar()
        {
            Resultados = dao.selectAll();
            return Resultados;
        }

        public List<Paciente> buscar(string dni)
        {
            Resultados = new List<Paciente>();
            Resultados.Add(dao.selectByDni(dni));
            return Resultados;
        }

        public List<Paciente> buscar(int nhc)
        {
            Resultados = new List<Paciente>();
            Resultados.Add(dao.selectByNhc(nhc));
            return Resultados;
        }



    }
}
