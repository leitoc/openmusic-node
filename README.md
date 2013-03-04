OpenMusic
=========

Como correr OpenMusic desde el eclipse?
=======================================

Al ejectuar el "Node" deberan pasarle como "Scala Application" deberan ir a "Run Configuration" y pasarle como "Program Arguments":

-p /ruta/absoluta/al/archivo/de/configuration.properties

El archivo de configuracion de ejemplo esta dentro de src/main/resources

Con eso deberia funcionar.

Como generar el JAR de OpenMusic Node?
======================================

* mvn compile assembly:single

Eso genera un archivo llamado node-0.0.1-SNAPSHOT-jar-with-dependencies.jar

Para correr el JAR debemos hacer:

* java -jar node-0.0.1-SNAPSHOT-jar-with-dependencies.jar -p /ruta/a/la/configuration.properties




SideEffect!deas 2013
