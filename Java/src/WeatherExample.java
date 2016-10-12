public class WeatherExample {
    private enum Weather {
        Rainy,
        Sunny
    }

    private enum Activity {
        walk,
        shop,
        clean
    }

    static int[] states = new int[]{Weather.Rainy.ordinal(), Weather.Sunny.ordinal()};
    static int[] observations = new int[]{Activity.walk.ordinal(), Activity.shop.ordinal(), Activity.clean.ordinal()};
    static double[] startProb = new double[]{0.6, 0.4};
    static double[][] transProb = new double[][] {
            {0.7, 0.3},
            {0.4, 0.6}
    };
    static double[][] emissionProb = new double[][] {
            {0.1, 0.4, 0.5},
            {0.6, 0.3, 0.1}
    };

    public static void main(String[] args) {
        int[] result = Viterbi.comput(observations, states, startProb, transProb, emissionProb);
        for (int r : result) {
            System.out.print(Weather.values()[r] + " ");
        }
    }
}
