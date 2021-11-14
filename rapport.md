Thibault Choné - Novembre 2021 - Master 2 Informatique
## Tp3 Spring Boot - API Rest


Version de Java: 11
Adresse de l'api: localhost
Port de l'api: 8080

L'application utilise une base de donnée en mongoDB, je ne sais pas si c'était vraiment la bonne idée ou pas, en tout cas avec mongoDB d'installé sur votre machine ça devrait marcher.
(Pour avoir quelque chose de fonctionnel, au cas où, je dirai d'installer mongodb en ragardant ce lien: [Spring boot guide MongoDB][ec24358c])

Les données de la base de données sont remises à zéro à chaque redémarrage de l'application.

---------------

### Contenu de la base
C'est juste une base de données de cartes avec pour chaque carte:
- Une id
- Un niveau
- Un nom
- Un TypeCard (qui est juste un objet avec un String nommé type)

---------------

### Les points d'entrées

Les points d'entrées sont:
- 2 GET
- 1 POST
- 1 PUT
- 1 DELETE

GET
Pour récupérer toutes les cartes disponibles (/cards/)
Pour récupérer une carte disponible avec son id (/card/{id})

POST
Pour ajouter une carte à la base (/card/)
Exemple de contenu JSON d'ajout d'une carte:
```json
{
  "id": "0005",
  "niveau": 5,
  "nom": "Brigitte",
  "type": {
      "type": "PROFESSEUR"
  }
}
```

PUT
Pour modifier une carte existante (/card/{id})
Vous ne pouvez pas changer l'id d'une carte déjà présente dans la base de donnée, uniquement les autres champs.
Exemple JSON de modification d'une carte:
[http://localhost/card/0001][e42175ca]
```json
{
  "id": "need to be there but can be empty",
  "niveau": 1,
  "nom": "Thibault",
  "type": {
      "type": "ALTERNANT"
  }
}
```


DELETE
Pour supprimer une carte existante (/card/{id})


Je ne génère pas d'erreur pour ce qui est des éléments inconnus pour le PUT ou le GET (C'est un renvoie d'une carte vide dans le cas du GET et dans le cas du PUT je renvoie rien)

---------------

### Les p'tits soucis

En soit mes plus gros problèmes étaient liés au fait de mettre en place mongoDB et le fait que je doit rajouter `@NoRepositoryBean` pour l'interface du DAO.

Pour une raison que j'ignore je devais aussi rajouter le Media Type pour le POST et le PUT (Exemple: `@PostMapping(value = "/card", consumes = MediaType.ALL_VALUE)`) sinon j'avais une erreur 415.



[e42175ca]: http://localhost/card/0001 "POST Example"
[ec24358c]: https://spring.io/guides/gs/accessing-data-mongodb/ "Spring boot guide MongoDB"
