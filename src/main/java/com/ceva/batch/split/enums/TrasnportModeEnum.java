package com.ceva.batch.split.enums;

import com.ceva.batch.split.enums.TrasnportModeEnum;

public enum TrasnportModeEnum {

  OCEAN("Ocean", "Sea"), GROUND("Ground", "Roa"), RAIL("Rail", "Rai");

  private final String sourceValue;
  private final String cfastBiValue;

  TrasnportModeEnum(String sourceValue, String cfastBiValue) {
    this.sourceValue = sourceValue;
    this.cfastBiValue = cfastBiValue;
  }


  public String getSourceValue() {
    return sourceValue;
  }


  public String getCfastBiValue() {
    return cfastBiValue;
  }


  /**
   * returnValue.
   * 
   * @return
   */
  public static String returnValue(String value) {
    TrasnportModeEnum result = null;

    for (TrasnportModeEnum obj : values()) {
      if (obj.getSourceValue().equalsIgnoreCase(value)) {
        result = obj;
        break;
      }
    }
    if (result != null) {
      return result.getCfastBiValue();
    } else {
      return value;
    }

  }

}
