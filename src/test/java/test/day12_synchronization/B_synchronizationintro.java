package test.day12_synchronization;

public class B_synchronizationintro {
    /*
    what is synchronization?it means move,work,operation at same time

    why we need synchronization?
    becuase most time driver fatser than browser so if we gonna run the code the code become broken because the brower
    isnt ready still
    and we gonna get Exception like nosuchelementException

    what can we do? we have some different ways
    1-Thread.sleep
    thread gonna wait inside our driver it not gonna wait for a reason it isnt geneus
    actually we dont wanna use it because it isnt good practice but we need it
    at the interview question never use Thread.sleep
    if we have long term it gonna make our code heavy and slow
    it comes form java

    2- implicit wait
    -its not used for specific condition ,applies to many lines
    - its stops pollling codes as soon as the element is found
    - if the driver not found it gives us NoSuchElementException
    -we set this once.it isnt like Thread anywhere you want use it ,you should use once,then it applies
    ever time we are tring to find element
    -if we dont have findelemetn it not gonna work
    -it gonna wait if not found ,so if you change it to another number you not gonna see any different
    it means if the element found at the first second it not gonna wait for the rest


     */
}
