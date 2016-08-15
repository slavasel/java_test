/*
 Entering point.
 */
//интересный пекедж. Де ло в том, что src/main/java это зарезервированый мавеном путь к джава коду. http://ru.eduarea.com/course/edu1a00h/view/%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5_%D0%BF%D1%80%D0%BE%D1%81%D1%82%D0%B5%D0%B9%D1%88%D0%B5%D0%B3%D0%BE_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B0/%D0%A1%D1%82%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%D1%82%D0%BD%D0%B0%D1%8F_%D1%81%D1%85%D0%B5%D0%BC%D0%B0_%D0%B4%D0%B8%D1%80%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%B8%D0%B9
// у меня после импрота проекта сразу начались проблеммы с путями, интересно, как ты его настроил что он у тебя собрался

package src.main.java.flowers;

import src.main.java.flowers.classes.*;

public class Index {
    public static void main (String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}
