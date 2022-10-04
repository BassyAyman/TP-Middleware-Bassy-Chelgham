# TP-Middleware-Bassy-Chelgham
 

Description succinte du projet : 

Partie Serveur:
  - Pour gérer la "connexion" de l'utilisateur nous avons implementé "LogService" qui s'occupe de renvoyer le stub de VODservice au client si il est bien reconnu
  - On a pas gardé un tableau de client dans notre service de log car on n'en a pas eu besoin
  - On utilise un fichier CSV pour stocker les informations "log,mots_de_passe"

Partie Client:
  - Nous avons 2 interfaces pour notre objet client IClient qui gère la connexion et IClientBox pour le stream (Notre objet client implémente les 2 interfaces car on         trouvait ça plus simple et logique)
  - Les exceptions sont partiellement gérés

 
Ce que nous avons pas implémenté:
  - Chargement dynamique
  - Lancement d'un trailer pour un MovieDescExtended
  

