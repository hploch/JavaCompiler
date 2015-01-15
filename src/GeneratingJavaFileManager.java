import java.io.IOException;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;


public class GeneratingJavaFileManager extends ForwardingJavaFileManager<JavaFileManager> {
	
	private final ClassFile classFile;

	protected GeneratingJavaFileManager(JavaFileManager fileManager, ClassFile classFile) {
		super(fileManager);
		this.classFile = classFile;
	}

	@Override
	public JavaFileObject getJavaFileForOutput(Location location,
			String className, Kind kind, FileObject sibling) throws IOException {
		
		return classFile;
	}
}
