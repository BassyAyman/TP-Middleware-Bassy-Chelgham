# TP-Middleware-Bassy-Chelgham
 

Description succinte du projet : 

- Pour gérer la "connexion" de l'utilisateur nous avons implementé un service supplémentaire (non demandé dans le sujet) qui s'occupe de renvoyer le stub de VODservice au client si il est bien reconnu
  
- On utilise un fichier CSV pour stocker les informations "log,mots_de_passe"

- Si des clients se connectent en même temps, la methode de logIn qui enclanche le processus de recuperation de l'objetVOD est mis en synchronized
  afin de pouvoir utiliser "plusieur threads"
