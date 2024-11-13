public class Angle_between_hour_and_minute_hand {
    static int getAngle(int H , int M) {
        float a = (float) Math.abs(6*(5*H-M) + 0.5*M);
        if (a > 180){
            return (int) (360- a);
        }
        return (int) a;
    }
}
