package main.model;

enum Effect {
    RIVER, TRAP, DEN, NORMAL
}

public class Square {
    private Animal animal;
    private Effect effect;

    public Square(Animal animal, Effect effect) {
        this.animal = animal;
        this.effect = effect;
    }

    public Square() { new Square(null, Effect.NORMAL); }
    public Square(Effect effect) { new Square(null, effect); }
}
