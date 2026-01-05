# API evalSpring

Documentation de l’API evalSpring.

Base URL :
http://localhost:8080/api

---

## Créer un produit

Endpoint :
POST /produit

Description :
Crée un nouveau produit.

Requête :
- Content-Type : application/json

Body :
{
"nom": "Fromage",
"prix": 4.68
}

Réponses possibles :
- 201 Created : produit créé
- 409 Conflict : données déja existante

---

## Récupérer tous les produits

Endpoint :
GET /produits

Description :
Retourne la liste de tous les produits.

Réponse exemple :
[
{
"id": 1,
"nom": "Patate",
"prix": 4,
"categorie": null
},
{
"id": 2,
"nom": "Fromage",
"prix": 4,
"categorie": {
"id": 1,
"libele": "Frais"
}
}
]

---

## Récupérer une catégorie par ID

Endpoint :
GET /categorie/{id}

Description :
Retourne une catégorie à partir de son identifiant.

Exemple :
GET /categorie/1

Note :
Un body sur une requête GET n’est pas recommandé en REST
(même si présent dans Postman).

Réponse exemple :
{
"id": 1,
"libele": "Frais"
}

---
