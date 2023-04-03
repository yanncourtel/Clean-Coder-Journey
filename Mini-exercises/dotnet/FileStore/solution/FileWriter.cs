using System.IO;

namespace FileStoreApp
{
    public class FileWriter : IFileWriter
    {
        public void WriteFile(string path, string message)
        {
            File.WriteAllText(path, message);
        }
    }
}