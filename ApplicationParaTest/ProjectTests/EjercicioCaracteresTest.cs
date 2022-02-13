using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using ApplicationParaTest;

namespace ProjectTests
{
    [TestClass]
    public class EjercicioCaracteresTest
    {
        /// <summary>
        /// darVuelta
        /// 
        /// Queremos probar el correcto funcionamiento del metodo darVuelta, este método
        /// deberá invertir el orden de la cadena de texto que le proporcionemos.
        /// 
        /// Introduciremos la cadena 'abcd'
        /// 
        /// La función deberá devolver la cadena 'dcba'
        /// 
        /// </summary>
        [TestMethod]
        public void darVueltaTest()
        {
            string original = "abcd";
            string esperada = "dcba";
            string recibida = EjercicioCaracteres.darVuelta(original);
            Console.WriteLine("----- TEST darVuelta. \nCadena entrada: " + original + "\nSalida esperada: " + esperada + "\nSalida REAL: " + recibida + "\n----- TEST FINALIZADO");
            Assert.AreEqual(esperada, recibida);
        }

        /// <summary>
        /// sacarAcentos
        /// 
        /// Queremos probar el correcto funcionamiento de la función de sacarAcentos. La
        /// función deberá eliminar todo tipo de acentos de la cadena de texto que proporcionemos.
        /// 
        /// Introducimos la cadena 'áàéèíìóòúùäöüâêîôû'
        /// 
        /// La función deberá devolver la cadena 'aaeeiioouuaouaeiou'
        /// </summary>
        [TestMethod]
        public void sacarAcentosTest()
        {
            string original = "áàéèíìóòúùäöüâêîôû";
            string esperada = "aaeeiioouuaouaeiou";
            string recibida = EjercicioCaracteres.sacarAcentos(original); 
            Console.WriteLine("----- TEST sacarAcentos. \nCadena entrada: " + original + "\nSalida esperada: " + esperada + "\nSalida REAL: " + recibida + "\n----- TEST FINALIZADO");
            Assert.AreEqual(esperada, recibida);
        }

        /// <summary>
        /// transformaTexto
        /// 
        /// Queremos asegurarnos del correcto comportamiento de la función de transformaTexto.
        /// Esta deberá recibir una cadena de texto y elminar de ella los espacios, acentos y además
        /// invertir el orden de los caracteres.
        /// 
        /// Introduciremos la cadena 'hola qué tal' 
        /// 
        /// Nos deberá devolver 'lAtEUqAlOh'
        /// </summary>
        [TestMethod] 
        public void transformaTextoTest()
        {
            string original = "hola qué tal";
            string esperado = "lAtEUqAlOh";
            string recibido = EjercicioCaracteres.transformaTexto(original);
            Console.WriteLine("----- TEST transformaTexto. \nCadena entrada: " + original + "\nSalida esperada: " + esperado + "\nSalida REAL: " + recibido + "\n----- TEST FINALIZADO");
            Assert.AreEqual(esperado, recibido);
        }
    }
}
