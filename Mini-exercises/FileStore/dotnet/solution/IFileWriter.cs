namespace FileStoreApp
{
    public interface IFileWriter
    {
        void WriteFile(string path, string message);
    }
}