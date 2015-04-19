.PHONY:all clean

all:ReferenceData.class

ReferenceData.class:ReferenceData.java bloomberg.jks client.p12
	javac ReferenceData.java

client.p12:hackru_spring_2015_084.crt bloomberg.crt
	openssl pkcs12 -export -password pass:secure -in hackru_spring_2015_084.crt -CAfile bloomberg.crt -inkey hackru_spring_2015_084.key -out client.p12

bloomberg.jks:bloomberg.crt
	$(RM) bloomberg.jks
	keytool -import -keystore bloomberg.jks -storepass secure2 -trustcacerts -file bloomberg.crt -noprompt

clean:
	$(RM) ReferenceData.class client.p12 bloomberg.jks