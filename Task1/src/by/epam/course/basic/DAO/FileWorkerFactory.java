package by.epam.course.basic.DAO;



public final class FileWorkerFactory {
	private static final FileWorker file = new FileWorker();
	private FileWorkerFactory(){
		
	}
	public static FileWorker getFileWorker(){
		return file;
	}
}
