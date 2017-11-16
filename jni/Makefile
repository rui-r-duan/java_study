INCLUDES=-I/usr/lib/jvm/java-6-openjdk/include \
	-I/usr/lib/jvm/java-6-openjdk/include/linux

libHelloWorld.so: HelloWorld.c
	cc -shared -fPIC ${INCLUDES} HelloWorld.c -o libHelloWorld.so

libPrompt.so: Prompt.c
	cc -shared -fPIC ${INCLUDES} Prompt.c -o libPrompt.so