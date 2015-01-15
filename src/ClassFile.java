import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

class ClassFile extends SimpleJavaFileObject {
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	public ClassFile(URI uri, Kind kind) {
		super(uri, kind);
	}

	@Override
	public OutputStream openOutputStream() throws IOException {
		return outputStream;
	}
	
	public byte[] getBytes() {
		return outputStream.toByteArray();
	}
}