import java.io.IOException;
import java.net.URI;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;


public class JavaSourceFile extends SimpleJavaFileObject {

	protected JavaSourceFile() {
		super(URI.create("TestClassGenerated.java"), JavaFileObject.Kind.SOURCE);
	}
	
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors)
			throws IOException {
		return "public class TestClassGenerated implements TestClass {\r\n" + 
				"	public void test() {\r\n" + 
				"		System.err.println(\"nix\");\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"";
	}

}
