package com.base.innerClass;

// 例 2：定义于作用域内部
public class Parcel5 {
    private void internalTracking(boolean b) {
        int a = 1;

        if (b) {
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    // System.out.println(a);
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
            System.out.println(s);
        }
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        p.track();
    }
}
