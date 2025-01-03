package DesignPrinciples.SOLIDPrinciple.DependencyInversion.solution;

//# Abstraction for the light source
public interface Switchable {
    void turnOn();
    void turnOff();
}
