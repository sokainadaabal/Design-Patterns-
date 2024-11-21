# Design Patterns

## Introduction

Les design patterns (ou patrons de conception) sont des solutions éprouvées à des problèmes récurrents rencontrés lors de la conception de logiciels. Ils représentent des approches standardisées et reconnues pour répondre à des besoins spécifiques dans le développement.

Dans ce TP, nous allons explorer plusieurs design patterns courants à travers un exemple de système de notification. Ce système permet d’ajouter des observateurs qui seront notifiés lorsqu’un événement se produit.

---

## Le Singleton

Le **Singleton** est un patron de conception qui garantit qu’une classe n’a qu’une seule instance et fournit un point d’accès global à cette instance.

### Exemple en Java

```java
public class Singleton {
    private static Singleton instance;

    // Constructeur privé pour empêcher l'instanciation directe
    private Singleton() {}

    // Méthode pour récupérer l'instance unique
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### Quand utiliser le Singleton ?

- Lorsque vous avez besoin d’une seule instance d’une classe (exemple : une classe de configuration ou un gestionnaire de services).
- Pour centraliser l’accès à une ressource partagée.
- ⚠️ Évitez d’utiliser le Singleton pour contourner l’injection de dépendances ou comme solution à des problèmes d’architecture.

---

## Observer

Le **Observer** est un patron de conception comportemental qui permet à certains objets (les *observateurs*) de réagir aux événements qui se produisent dans un autre objet (le *sujet*). Ce pattern facilite une relation entre un sujet et ses observateurs sans les coupler de manière rigide.

### Exemple en Java

Interface de l'observateur :

```java
public interface Observer {
    void update(String message);
}
```

Interface du sujet (optionnel) :

```java
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}
```

### Quand utiliser l’Observer ?

- Lorsqu’il s’agit de systèmes pilotés par des événements (exemple : réseaux sociaux, marchés boursiers).
- Lorsqu’il existe une relation de type *un-à-plusieurs* (1-n) entre objets.
- ⚠️ Pensez à bien nettoyer vos observateurs (évitez les références inutiles).

---

## Strategy

Le **Strategy** est un patron de conception comportemental qui permet de définir une famille d’algorithmes, de les encapsuler et de les rendre interchangeables. Ce pattern permet de changer dynamiquement le comportement d’un objet à l'exécution.

### Exemple en Java

Interface de la stratégie :

```java
public interface Strategy {
    int doOperation(int num1, int num2);
}
```

Classe client :

```java
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
```

### Quand utiliser la Strategy ?

- Lorsque vous avez plusieurs classes qui ne diffèrent que par leur comportement.
- Lorsque vous avez besoin de changer dynamiquement le comportement d’un objet à l'exécution.
- Lorsque vous voulez éviter d’utiliser un grand nombre de conditions (`if` ou `switch`) dans une classe.

---

## Factory

Le **Factory** (ou fabrique) est un patron de conception de création qui fournit une interface pour créer des objets sans spécifier leur classe concrète. Ce pattern permet à des sous-classes de déterminer les types d’objets à instancier.

### Exemple en Java

Interface pour les objets créés :

```java
public interface Shape {
    void draw();
}
```

Classe fabrique :

```java
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}
```

### Quand utiliser la Factory ?

- Lorsque la classe principale ne peut pas anticiper le type exact des objets qu’elle doit créer.
- Lorsqu’une classe veut déléguer la responsabilité de création d’objets à ses sous-classes.
- Lorsque le choix de l’objet à instancier doit être laissé aux classes parentes ou dépend d’un paramètre.

---

## Conclusion

Les design patterns sont des outils puissants qui, bien utilisés, améliorent la maintenabilité, la flexibilité et la robustesse des applications. Ce TP illustre comment certains des design patterns les plus populaires peuvent résoudre des problèmes courants en programmation orientée objet. 

🚀