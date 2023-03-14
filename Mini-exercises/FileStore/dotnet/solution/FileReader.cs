using System.IO;

namespace FileStoreApp
{
    public class FileReader : IFileReader
    {
        private const string FileExtension = ".txt";

        public string ReadFile(string directory, int fileName)
        {
            return File.ReadAllText(Path.Combine(directory, fileName + FileExtension));
        }
    }
}