package tamboro.question.one;

import java.util.Objects;

/**
 *
 * @author webwerks
 */
public class HSV {
  private Integer hue;
  private Integer saturation;
  private Integer value;

  public HSV(Integer hue, Integer saturation, Integer value) {
    this.hue = hue;
    this.saturation = saturation;
    this.value = value;
  }

  public HSV() {
  }

  
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 97 * hash + Objects.hashCode(this.saturation);
    hash = 97 * hash + Objects.hashCode(this.value);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final HSV other = (HSV) obj;
    if (!Objects.equals(this.saturation, other.saturation)) {
      return false;
    }
    if (!Objects.equals(this.value, other.value)) {
      return false;
    }
    return true;
  }

  public Integer getHue() {
    return hue;
  }

  public void setHue(Integer hue) {
    this.hue = hue;
  }

  public Integer getSaturation() {
    return saturation;
  }

  public void setSaturation(Integer saturation) {
    this.saturation = saturation;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "HSV{" + "hue=" + hue + ", saturation=" + saturation + ", value=" + value + '}';
  }
  
  
}
