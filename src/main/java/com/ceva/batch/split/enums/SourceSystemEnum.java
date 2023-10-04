package com.ceva.batch.split.enums;

public enum SourceSystemEnum {

  OFS("OFS"), CSP("CSP"), CWO("CWO"), WORLDPORT("WORLDPORT");

  private String value;


  SourceSystemEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  /**
   * returnValue.
   * 
   * @param value String
   * @return
   */
  public static String returnValue(String value) {
    SourceSystemEnum result = null;
    String type = value.split("_")[0];
    for (SourceSystemEnum obj : values()) {
      if (obj.getValue().equalsIgnoreCase(type)) {
        result = obj;
        break;
      }
    }
    if (result != null) {
      return result.getValue();
    } else {
      return value;
    }
  }
}
