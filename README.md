# p6-Bibliot_V2

Ce projet nécessite :


                 
 -maven 3.6.0 installé dans votre environnement de développement (voir : https://maven.apache.org/install.html)


 
 -tomcat 8.5 installé dans votre environnement de développement (voir :https://tomcat.apache.org/tomcat-8.0-doc/setup.html)


   
 - glassfish 5.0 installé dans votre environnement de développement               
 - java jdk1.8





Telecharger le dossier

-------------------------------Build du projet-----------------------------------------------------


Ouvrir la console et aller à la source du dossier

Dans le module p3-parent Entrer la ligne de commande : mvn -clean -install
Repetez l'opération pour le module web-service.


-------------------------------Lancement du webservice---------------------------------------------


Allez dans le repertoire d'installation de votre glassfish \bin et lancer le script asadmin.bat
la console s'ouvre, lancez le serveur glassfish en tapant la commande "start-domain".

Dans votre navigateur rendez vous à l'adresse "http://localhost:4848/common/index.jsf"
Dans le menu Applications > Deploy > Selectionnez "web-service-0.0.1-SNAPSHOT.war" puis launch



-------------------------------Creation de la base de données--------------------------------------

la structure de la base de données est créee lors du déploiement du .war des webservices.

Sur votre interface de gestion de la base de données entrez les informations de connexion suivantes:
user:root
password:root

Faites un import du script "script-init-db.sql" dans la table "projet3"



-------------------------------Deploiement de l'application web------------------------------------

Dans le dossier du projet faire dans l'ordre:
- clean install du module web-service-client
- clean install du module bibliot-webapp

Copier le dossier webapp et le bibliot-webapp.war ainsi générés vers le sous-dossier webapps de votre installation tomcat

Ouvrir une autre console, aller au dossier d'installation tomcat/bin et ecrire en ligne de commande 
catalina.bat start

Le site est trouvable a l'adresse : localhost:8080/bibliot-webapp/

3 membres existent en base,
- Possibilité de tester les fonctions avec l'utilisateur : "babar",
Le mot de passe etant "babar38".
- Possibilité de tester les fonctions avec l'utilisateur : "jean",
Le mot de passe etant "jean38".
- Possibilité de tester les fonctions avec l'utilisateur : "pierre",
Le mot de passe etant "pierre38".




-------------------------------Lancement du batch---------------------------------------------------



Double cliquez sur le batch.bat (execution automatique)

Un seul mail s'enverra sur l'adresse gmail test.javaketut38@gmail.com mdp: 4HH7Q1pcrg toute les 20secondes 
(adresse crée pour tester le batch sur ce membre uniquement).
