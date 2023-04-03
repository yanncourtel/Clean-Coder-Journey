namespace FileStoreApp
{
    public interface IFileReader
    {
        string ReadFile(string directory, int fileName);
    }
}