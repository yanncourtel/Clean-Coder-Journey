using System;

namespace FileStoreApp
{
    public class FileStore : IFileStore
    {
        private readonly IFileWriter _fileWriter;
        private readonly IFileReader _fileReader;

        public FileStore(IFileWriter fileWriter, IFileReader fileReader)
        {
            _fileWriter = fileWriter;
            _fileReader = fileReader;
        }

        public string WorkingDirectory { get; set; }

        public event EventHandler<MessageEventArgs> MessageRead;

        public string SaveAndReturnPath(int fileName, string message)
        {
            var createdFilePath = WorkingDirectory + fileName;
            _fileWriter.WriteFile(createdFilePath, message);
            return createdFilePath;
        }

        public void Read(int fileName)
        {
            var msg = _fileReader.ReadFile(WorkingDirectory, fileName);
            MessageRead?.Invoke(this, new MessageEventArgs { Message = msg });
        }
    }
}
