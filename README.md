L'ENT Esup/uPortal tel que livré et installé permet aux navigateurs-clients de spécifier eux mêmes leurs JSESSIONID, ce contrairement aux autres applications Java/Tomcat classiques. On peut donc réutiliser le même JSESSIONID éternellement sur un ENT Esup/uPortal.

Cette valve a pour effet de forcer le regénération d'un nouveau JSESSIONID à chaque authentification dans le portail .


# Compilation :

  mvn clean package


# Mise ne place dans le Tomcat :

  conf/server.xml - ajouter la déclaration de la valve ainsi :

'''
<Valve className="org.esupportail.tomcat.ChangeSessionIdValve" loginPath="/uPortal/Login"/>
'''
