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
        bool useFilter;

        public FileManager(string path)
        {
            this.Path = path;
            useFilter = true;
        }

        
        public FileManager(string path, bool filter)
        {
            this.Path = path;
            useFilter = filter;
        }

        public string Path { get => path; set => path = value; }

        /**
         * Funcion que devuelve las lineas separadas de un fichero con la opcion de filtrar lineas vacías o de comentario ( /* )
         */
        public String[] readLines()
        {
            StreamReader reader = new StreamReader(path);
            List<String> lines = new List<String>();
            while (!reader.EndOfStream)
            {
                if (!useFilter)
                    lines.Add(reader.ReadLine());
                else
                {
                    string line = reader.ReadLine();
                    if (!line.Contains("/*") || !String.IsNullOrEmpty(line))
                    {
                        lines.Add(line);
                    }
                }
            }
            reader.Close();
            return lines.ToArray();
        }

        /**
         * Funcion que devuelve el fichero entero sin filtrar nada y en un único string
         */
        public String readAll()
        {
            StreamReader reader = new StreamReader(path);
            String output = "";
            while (!reader.EndOfStream)
            {
                output += reader.ReadLine() + "\n";
            }
            reader.Close();
            return output;
        }

        public bool write(string value) 
        {
            try
            {
                StreamWriter file = new StreamWriter(path);
                file.Write(value);
                file.Flush();
                file.Close();
                return true;
            } catch (Exception e)
            {
                return false;
            }
        }

        public bool append(string value)
        {
            try
            {
                StreamWriter file = new StreamWriter(path, append: true);
                Console.WriteLine("Appending\n" + value);
                file.Write(value);
                file.Flush();
                file.Close();
                return true;
            }
            catch (Exception e)
            {
                return false;
            }
        }

        public bool remove(string line)
        {
            try
            {
                string[] oldLines = readLines();
                write("");
                foreach (string old in oldLines)
                {
                    Console.WriteLine(old + "\n" + line + "\n");
                    if (!old.Equals(line))
                    {
                        Console.WriteLine("The lines are different: " + !old.Equals(line));
                        append(old + "\n");
                    }
                }
                return true;
            } catch (Exception e)
            {
                return false;
            }
        }
    }
}
