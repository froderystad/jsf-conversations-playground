JSF Conversations Playground
============================

I created this small project to experiment with CDI scopes in JSF-applications. Other than that, it does nothing useful :)

It requires Java 1.7 (or higher) and Maven to build.

Build with:

    mvn clean package

If you have Wildfly 8 installed to `$JBOSS_HOME`, this command will deploy the application, so you can [access it here] (http://localhost:8180/jsf/).

    mvn cargo:run -P wildfly-8-final

