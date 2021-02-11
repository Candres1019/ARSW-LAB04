package edu.eci.arsw.blueprints.ui;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bl = context.getBean(BlueprintsServices.class);

        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        Point[] pts1=new Point[]{new Point(40, 40),new Point(15, 15)};
        Blueprint bp1=new Blueprint("mack", "mypaint",pts1);

        try {
            bl.addNewBlueprint(bp0);
            bl.addNewBlueprint(bp1);
        } catch (BlueprintPersistenceException e) {
            e.printStackTrace();
        }



    }


}
