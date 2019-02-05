package lp.iem.tennis;

public enum Point {

   _15("15"),_30("30"),_40("40"),_A("A");

    private String point;

    Point(String p) {
        this.point = p;
    }

    public String getPoint() {
        return point;
    }



}
