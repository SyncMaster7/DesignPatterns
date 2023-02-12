package AdapterPackage;

public class DemoClient {
    public static void main(String[] args) {

        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);

        if (hole.fits(rpeg)) {
            System.out.println("Round peg " + rpeg.getRadius() + " fits round hole " + hole.getRadius() + ".");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile.

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg " + smallSqPeg.getWidth() + " fits round hole " + hole.getRadius() + ".");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg " + largeSqPeg.getWidth() + " does not fit into round hole " + hole.getRadius() + ".");
        }
    }
}
