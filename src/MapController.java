/**
 * Created by Carlos on 12/03/2017.
 */
import java.awt.geom.Point2D;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MapController {
    private Map<Eetakemon, Point2D.Double> geoMap = new HashMap<Eetakemon, Point2D.Double>();
    private List<Location> zonesList = new ArrayList<>(10);

    public MapController() {
        zonesList.add(new Location(new Point2D.Double(41.275938, 1.983809),new Point2D.Double(41.275781, 1.985354)));
    }

    public void generateList(Controller pEetackemonController) {
        this.geoMap.clear();
        int max = pEetackemonController.getMap().size();
        for(int i = 0; i < this.zonesList.size(); i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, max);
            Eetakemon e = pEetackemonController.getEetakemonById(randomNum);
            Point2D.Double p = this.zonesList.get(i).getRandomLocation();
            this.geoMap.put(e, p);
        }
    }
}
