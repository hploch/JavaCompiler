import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		ClassFile classFile = new ClassFile(URI.create("generated.class"),
				JavaFileObject.Kind.CLASS);
		CompilationTask task = jc.getTask(
				new PrintWriter(System.out),
				new GeneratingJavaFileManager(jc.getStandardFileManager(null,
						null, null), classFile), null, null, null, Arrays
						.asList(new JavaSourceFile()));

		System.err.println(task.call());

		try {
			TestClass testClassGenerated = (TestClass)new ByteArrayClassLoader().defineClass(
					classFile.getBytes()).newInstance();
			testClassGenerated.test();
		} catch (InstantiationException | IllegalAccessException
				| SecurityException
				| IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
