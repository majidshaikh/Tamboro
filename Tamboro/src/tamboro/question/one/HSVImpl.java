package tamboro.question.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author webwerks
 */
public class HSVImpl {

  Map<String, HSV> map = new HashMap<String, HSV>();
  List<HSV[]> complimentoryColours = new ArrayList<HSV[]>();

  public static void main(String[] args) {

    HSVImpl impl = new HSVImpl();
    List<HSV[]> colours = impl.getComplimentoryColours(impl.getColours());

    for (HSV[] pair : colours) {
      System.out.print(pair[0] + " " + pair[1]);
      System.out.println("");
    }

  }

  public List<HSV[]> getComplimentoryColours(Vector<HSV> colours) {

    for (HSV colour : colours) {
      int min = colour.getHue() - 180;
      int max = colour.getHue() + 180;

      if (validateHue(min))
        searchColour(min, colour);
      else if (validateHue(max))
        searchColour(max, colour);    

    }
    return complimentoryColours;
  }

  public void searchColour(int hue, HSV colour) {
    String getKey = hue + "-" + colour.getSaturation() + "-" + colour.getValue();
    String putKey = colour.getHue() + "-" + colour.getSaturation() + "-" + colour.getValue();
    HSV pairs[] = new HSV[2];
    if (map.containsKey(getKey)) {
      HSV compVal = map.get(getKey);
      if (compVal.equals(colour)) {
        pairs[0] = compVal;
        pairs[1] = colour;
        complimentoryColours.add(pairs);
      } else
        map.put(putKey, colour);
      
    } else
      map.put(putKey, colour);
    
  }

  public boolean validateHue(int i) {
    return (i > -1 && i < 361);
  }

  public Vector<HSV> getColours() {
    Vector<HSV> input = new Vector<HSV>();
    input.add(new HSV(195, 11, 12));
    input.add(new HSV(15, 13, 76));
    input.add(new HSV(15, 11, 12));
    input.add(new HSV(195, 13, 76));
    input.add(new HSV(200, 13, 76));
    input.add(new HSV(20, 13, 76));
    return input;
  }
}
