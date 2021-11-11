using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace modelo
{
    public class FileManager
    {
        private string path;

        public FileManager(string path)
        {
            this.Path = path;
        }
        public string Path { get => path; set => path = value; }

        public String[] readLines()
        {
            StreamReader reader = new StreamReader(path);
            List<String> lines = new List<String>();
            while (!reader.EndOfStream)
            {
                lines.Add(reader.ReadLine());
            }
            return lines.ToArray();
        }

        public String readAll()
        {
            StreamReader reader = new StreamReader(path);
            String output = "";
            while (!reader.EndOfStream)
            {
                output += reader.ReadLine() + "\n";
            }
            return output;
        }

        public void write(string value) 
        {

        }

        public void append(string value)
        {

        }
    }
}
