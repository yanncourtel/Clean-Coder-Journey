namespace FileStoreApp
{
    public interface IFileStore
    {
        string SaveAndReturnPath(int fileName, string message);

        void Read(int fileName);
    }
}