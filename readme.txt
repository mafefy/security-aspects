this library provide security features out of the box for your spring  boot application
using aspect programming


in you spring boot main class add these to enable the features

@EnableScheduling
@SpringBootApplication( scanBasePackages = { "your package here", SecurityAspects.packageName} )
@EnableJpaRepositories( SecurityAspects.packageName)
@EntityScan(SecurityAspects.packageName)
public class MyApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
}


and in any rest controller if you want to enable just add on any function  

@SecurityOptions(roles = { enableBlocking = true, enableAuthorization = true,UserRole.ROOT })
@GetMapping("some-function")
public String someFunction( String param) {
	return param;
}

now you have security enabled out of the box for your function very simple

enableAuthorization = true :
will check if you pass valid jwt token in headers or in any class that extend from AuthenticatedRequest class
if token not valid the security will add violation and will block user if reached maximum violations for this type of operation

enableBlocking=true

if used exceeded maximum number of violation for specific operation 
he will be blocked for specific time , 

every error exception extends  from AppError had Violation information which specificy
maximum violations count for specific operation for example

AuthenticationError has Violations.LoginViolation which specificy 5 times as maximum violations and operation 'login'

if you throw any of these errors inside your code the security will start to add violation  depends on the the error


UserRole:

specificy which user allowed to enter this function based on his token payload user will be allowed or rejected


Configure the library :

AuthorizationService.configure("encryption key here",200000000L,  Arrays.asList("system 1", "system 2"));

this system is named: current system name 
allowed system to connect to this one : "system 1" ,  "system 2"  if set to null mean any system can connect



to install the libarary as maven local repository :

mvn install:install-file -Dfile=security-aspects-0.0.1.jar -DgroupId=com.lunatech -DartifactId=security-aspects -Dversion=1.0.0 -Dpackaging=jar  -DgeneratePom=true


and you can reference it from any project

<dependency>	
	<groupId>com.lunatech</groupId>
	<artifactId>security-aspects</artifactId>
	<version>1.0.0</version>
</dependency>


