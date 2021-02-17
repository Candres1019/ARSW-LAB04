package edu.eci.arsw.blueprints.ui;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bl = context.getBean(BlueprintsServices.class);

        Point[] pts0 = new Point[]{new Point(40, 40),new Point(40, 40), new Point(15, 15)};
        Blueprint bp0 = new Blueprint("mack", "mypaint", pts0);
        Point[] pts1 = new Point[]{new Point(40, 40), new Point(15, 15),new Point(15, 15),new Point(16, 16)};
        Point[] pts2 = new Point[]{new Point(40, 40), new Point(15, 15),new Point(15, 15)};
        Blueprint bp1 = new Blueprint("riot", "lolcito", pts1);
        Blueprint bp2 = new Blueprint("riot", "valorant", pts2);
        try {
            System.out.println("---------------------------------------------");
            //registrar planos
            bl.addNewBlueprint(bp0);
            bl.addNewBlueprint(bp1);
            bl.addNewBlueprint(bp2);
            //consultar planos
            System.out.println("getBlueprintsByAuthor(riot) : " + bl.getBlueprintsByAuthor("riot"));
            //consultar especificos
            System.out.println("getBlueprint(mack, mypaint) : " + bl.getBlueprint("mack", "mypaint"));
            //consultar todos
            System.out.println("getAllBlueprints() : " + bl.getAllBlueprints());


        } catch (BlueprintPersistenceException | BlueprintNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------");
        System.out.println(bp0.getName());
        System.out.println("Puntos Antes: " + bp0.getPointsString());
        System.out.println("Despues" +bl.filterBlueprint(bp0).getPointsString());
        System.out.println("---------------------------------------------");
        System.out.println(bp1.getName());
        System.out.println("Puntos Antes: " + bp1.getPointsString());
        System.out.println("Despues" +bl.filterBlueprint(bp1).getPointsString());
        System.out.println("---------------------------------------------");
        System.out.println(bp2.getName());
        System.out.println("Puntos Antes: " + bp2.getPointsString());
        System.out.println("Despues" +bl.filterBlueprint(bp2).getPointsString());
        System.out.println("---------------------------------------------");
    }

}