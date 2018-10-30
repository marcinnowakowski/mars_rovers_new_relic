com.websigni.mars.plane

public class Plane {
    
    final public int x;
    final public int y;

    final public List<Rower> rowers = new ArrayList<>();

    public Plane(int aX, int aY) {
        x = aX;
        y = aY;
    }

    public Plane addRower(Rower rower) {
        rowers.add(rower);
        return this;
    }

    public void launch() {
        throw new UnsupportedOperationException();
    }
}