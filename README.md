# TP-Middleware-Bassy-Chelgham
 
Dans le cadre de notre projet : 

- pour l'ecriture dans un fichier nous avons implementer un service a par, en plus du VODservice exiger, pour que cela soit plus clair dans les methodes de demande.
  le type de fichier utiliser est le CSV afin d'avoir un aspect "log,mots_de_passe" dans le fichier. Cela nous facilite la lecture du fichier et la recuperation des       String.

- les methodes appeler coté client , classe clientObjet, affiche via system.out les textes visible coté client.

- Dans le cadre ou plusieur client se connexte en meme temps, la methode de logIn qui enclanche le processus de recuperation de l'objetVOD est mis en synchronized
  afin de pouvoir utiliser "plusieur threads".
