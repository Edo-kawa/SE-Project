package main.model;


import main.model.Chesses.Animal;

public class Square {
    private Animal animal;
    private Type type;

    public Square(Animal animal, Type type) {
        this.animal = animal;
        this.type = type;
    }

    public Square() { new Square(null, type.NORMAL); }
    public Square(Type type) {

        new Square(null, type);
    }
}
