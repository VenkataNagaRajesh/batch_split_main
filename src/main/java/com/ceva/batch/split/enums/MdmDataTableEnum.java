package com.ceva.batch.split.enums;

public enum MdmDataTableEnum {

  cfast_bi_party_role_shipment("cfast_bi_party_role_shipment"), cfast_bi_trade_country(
      "cfast_bi_trade_country"), cfast_bi_trade_lane("cfast_bi_trade_lane"), cfast_bi_service_level(
          "cfast_bi_service_level"), location("location"), ofs_visibility_country_codes(
              "ofs_visibility_country_codes"), cfast_bi_packing_type(
                  "cfast_bi_packing_type"), cfast_bi_delivery_type(
                      "cfast_bi_delivery_type"), cfast_bi_fcl_lcl(
                          "cfast_bi_fcl_lcl"), cfast_bi_commodity(
                              "cfast_bi_commodity"), cfast_bi_container_type(
                                  "cfast_bi_container_type"), country(
                                      "country"), cfast_bi_party_role_console(
                                          "cfast_bi_party_role_console"), cfast_bi_transport_id2CID(
                                              "cfast_bi_transport_id2cid"), cfast_bi_milestone(
                                                  "cfast_bi_milestone"), cfast_bi_milestone_code_conv(
                                                      "cfast_bi_milestone_code_conv");

  private String name;

  private MdmDataTableEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
