public class Video_39_Arithmetic_Number {
    static int inSequence(int a, int b, int c){
        if( c == 0)
            return  a == b ? 1 : 0;
        else
        {
            if((b-a)/c < 0)
                return 0;
            else
                return (b-a) % c == 0 ? 1 : 0;
        }

    }
}
