L'ENT Esup/uPortal tel que livré et installé permet aux navigateurs-clients de spécifier eux mêmes leurs JSESSIONID, ce contrairement aux autres applications Java/Tomcat classiques. On peut donc réutiliser le même JSESSIONID éternellement sur un ENT Esup/uPortal.

Cette valve a pour effet de forcer le regénération d'un nouveau JSESSIONID à chaque authentification dans le portail .


# Compilation et Installation :

  mvn clean package
  
  cp target/changeSessionIdValve-xxx.jar tomcat/lib/

  conf/server.xml - ajouter la déclaration de la valve ainsi :

``` xml
<Valve className="org.esupportail.tomcat.ChangeSessionIdValve" loginPath="/uPortal/Login"/>
```
