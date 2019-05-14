package com.maruani.games.mylittleheroesgi.data.model;

public enum WeaponType {
  NONE("", ""),
  BOW("1", "bow"),
  SWORD("2", "sword"),
  AXE("3", "axe"),
  STAFF("4", "staff");

  private String id;
  private String name;

  WeaponType(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public static WeaponType getById(String id) {
    for (WeaponType value : values()) {
      if (value.id.equalsIgnoreCase(id)) return value;
    }
    return NONE;
  }

  @Override public String toString() {
    return name;
  }
}
