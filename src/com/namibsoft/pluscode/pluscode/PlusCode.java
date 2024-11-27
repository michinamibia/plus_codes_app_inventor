package com.namibsoft.pluscode.pluscode;

import java.util.*;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.openlocationcode.*;


@DesignerComponent(
	version = 14,
	versionName = "1.0.2",
	description = "Convert between Google Plus Codes and GPS longitude and latitude positions.",
	iconName = "icon.png"
)
public class PlusCode extends AndroidNonvisibleComponent {

  public PlusCode(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleFunction(description = "Returns the plus code from latitude and logitude.")
  public String Encode(double latitude, double longitude) {
    OpenLocationCode code = new OpenLocationCode(latitude, longitude, 11);
    code.shorten(latitude, longitude);
    return code.getCode();
  }

  @SimpleFunction(description = "Returns a list of latitude and logitude from a plus code.")
  public List<String> Decode(String plusCode) {
    List<String> li = new ArrayList<>();
    OpenLocationCode code = new OpenLocationCode(plusCode);
    li.add(Double.toString(code.decode().getCenterLatitude()));
    li.add(Double.toString(code.decode().getCenterLongitude()));
    return li;
  }

}
