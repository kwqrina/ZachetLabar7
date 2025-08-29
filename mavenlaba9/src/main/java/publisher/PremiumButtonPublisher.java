/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package publisher;

import javax.swing.JButton; 
/**
 *
 * @author ekate
 */

public class PremiumButtonPublisher extends JButton { //издатель событий, публикует событие

    private EventPublisher publisher = new EventPublisher();

   
    public PremiumButtonPublisher(String text) {   //конструктор кнопки
        super(text); //вызов конструктора родительского класса
    }

   
    public EventPublisher getPublisher() {
        return publisher; //возвращаю ссылку на издателя
    }
}