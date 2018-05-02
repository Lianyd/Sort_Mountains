import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortMountains {
    LinkedList<Moutain> mtn = new LinkedList<Moutain>();

    public static void main(String[] args){
        new SortMountains().go();
    }

    public void go() {
        mtn.add(new Moutain("Hua Shan","Shan Xi",1111));
        mtn.add(new Moutain("Tai Shan","Shan Dong",2222));
        mtn.add(new Moutain("Heng Shan","Hu Nan",3333));
        System.out.println("as entered:\n" + mtn);

        NameCompare nc = new NameCompare();
        Collections.sort(mtn,nc);
        System.out.println("by name:\n" + mtn);

        LocationCompare lc = new LocationCompare();
        Collections.sort(mtn,lc);
        System.out.println("by location:\n" + mtn);

        HeightCompare hc = new HeightCompare();
        Collections.sort(mtn,hc);
        System.out.println("by height:\n" + mtn);
    }

    class NameCompare implements Comparator<Moutain>{
        public int compare(Moutain one, Moutain two){
            return one.name.compareTo(two.name);
        }
    }

    class LocationCompare implements Comparator<Moutain>{
        public int compare(Moutain one, Moutain two){
            return one.location.compareTo(two.location);
        }
    }

    class HeightCompare implements Comparator<Moutain>{
        public int compare(Moutain one, Moutain two){
            return (two.height - one.height);   // 降序排列int
        }
    }

    class Moutain {
        String name;
        String location;
        int height;

        Moutain(String n, String l, int h){
            name = n;
            location = l;
            height = h;
        }
        public String toString(){
            return name + "--" + location + "--" + height;
        }
    }
}
