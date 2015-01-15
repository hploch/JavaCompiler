
public class ByteArrayClassLoader extends ClassLoader {
	public Class<?> defineClass(byte[] classAsByteArray) {
		return defineClass(null, classAsByteArray, 0, classAsByteArray.length);
	}
}
