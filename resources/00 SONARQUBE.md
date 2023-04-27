:beginner: _**SET UP JAVA 11 & MAVEN**_  


:point_right: Preferred download  

https://www.oracle.com/webapps/redirect/signon?nexturl=https://download.oracle.com/otn/java/jdk/11.0.18%2B9/e9f4529b2fa84718a553a389cb2a6629/jdk-11.0.18_windows-x64_bin.zip

https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html#license-lightbox

https://www.oracle.com/webapps/redirect/signon?nexturl=https://download.oracle.com/otn/java/jdk/11.0.18%2B9/e9f4529b2fa84718a553a389cb2a6629/jdk-11.0.18_windows-x64_bin.exe

- JAVA_HOME C:\Program Files\Java\jdk-11.0.16
- PATH C:\Program Files\Java\jdk-11.0.16\bin
- CLASSPATH C:\Program Files\Java\jdk-11.0.16\lib;.

- MAVEN_HOME C:\Dev\apache-maven-3.8.6-bin\apache-maven-3.8.6
- CLASSPATH C:\Dev\apache-maven-3.8.6-bin\apache-maven-3.8.6\bin

:point_right: Preferred download

https://dlcdn.apache.org/maven/maven-3/3.9.1/source/apache-maven-3.9.1-src.zip


https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip

C:\Users\Collabera>mvn --version
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: C:\Dev\apache-maven-3.8.6-bin\apache-maven-3.8.6
Java version: 11.0.16, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-11.0.16
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"


:beginner: _**SETUP SONARQUBE**_  



:loudspeaker: **Open windows command prompt as an administrator**

C:\Dev\sonarqube-9.1.0.47736\bin\windows-x86-64

start sonarqube >C:\Dev\sonarqube-9.1.0.47736\bin\windows-x86-64\SonarQube.bat

:loudspeaker: *Access sonar qube*  

http://localhost:9000/account/security/ > Generate token
:point_right: Generated Token : 56b30c3ee11dec24e8830a060f4aa9e96d3ee8d5  


:beginner: _**PROJECT ACTIVTIY**_  



=========================================================

pom.xml

```
<plugin>
				<groupId>org.sonarsource.scanner.maven</groupId>
				<artifactId>sonar-maven-plugin</artifactId>
				<version>3.8.0.2131</version>
			</plugin>
			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.5</version>
				<executions>
					<execution>
						<id>prepare-agent</id>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>

```

project folder with pom.xml> mvn clean 
project folder with pom.xml> mvn test 




mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -f pom.xml 
(mnv clean org.jacoco:jacoco-maven-plugin:prepare-agent install)
mvn sonar:sonar -Dsonar.login=d41dc9f35e38d085b857c7e18f2bb6b8c17468cf -f pom.xml 
(sonar:sonar -Dsonar.login=d41dc9f35e38d085b857c7e18f2bb6b8c17468cf)

shorthand : mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install & mvn sonar:sonar -Dsonar.login=d41dc9f35e38d085b857c7e18f2bb6b8c17468cf

Verify coverage report : 
http://localhost:8080/PROJECT-REST-BE-V1/target/site/jacoco/index.html

ACCESS SONRAQUBE REPORTS TOO :)

POM WITH EXCLUSIONS OF PACKAGES

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.7.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<groupId>com.dss</groupId>
	<artifactId>DSS2-REST-BE-V1</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>DSS2-REST-BE-V1</name>
	<description>DSS2-REST-BE-V1</description>

	<properties>
		<java.version>11</java.version>
		<spring-cloud.version>2021.0.4</spring-cloud.version>
	</properties>
	<dependencies>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
	</dependencies>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<groupId>org.sonarsource.scanner.maven</groupId>
				<artifactId>sonar-maven-plugin</artifactId>
				<version>3.8.0.2131</version>
			</plugin>
			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.5</version>
				<executions>
					<execution>
						<id>prepare-agent</id>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<excludes>
						<exclude>com/dss/entity/*</exclude>
						<exclude>com/dss/model/*</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
```