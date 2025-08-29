/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package publisher;

import java.util.ArrayList;     
import java.util.List;          
import java.util.function.Consumer; 

/**
 *
 * @author ekate
 */
public class EventPublisher {
    
    private final List<Consumer<Void>> subscribers = new ArrayList<>(); //храним тут подписчиков

    
    public void subscribe(Consumer<Void> subscriber) {    //подписка на событие
        subscribers.add(subscriber); 
    }

   
    public void unsubscribe(Consumer<Void> subscriber) {  //отписка от события
        subscribers.remove(subscriber); 
    }

    
    public void publishEvent() {   //оповещаем всех подписчиков и очищаем список
        
        List<Consumer<Void>> currentSubscribers = new ArrayList<>(subscribers);
        
       
        for (Consumer<Void> subscriber : currentSubscribers) { //оповещаем всех подписчиков
            subscriber.accept(null); //вызываю лямбда выражение
        }
        
        subscribers.clear(); 
    }

    
    public int getSubscribersCount() {
        return subscribers.size(); 
    }
}