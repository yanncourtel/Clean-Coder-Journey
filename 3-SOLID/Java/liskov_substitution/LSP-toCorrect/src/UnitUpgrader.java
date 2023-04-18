/**
 * Created by mrk on 4/8/14.
 */
public class UnitUpgrader {
    public void upgrade(Studio studio) {
        studio.squareFootage += 40;
    }

    public void upgrade(PenthouseSuite penthouse) {
        penthouse.squareFootage += 40;
        penthouse.numberOfBedrooms += 1;
    }
}
