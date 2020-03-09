package classes;

public class TalheresSingleton {

    private static Talher[] _instance;

    public static Talher[] getInstance(int size) {
        if (_instance == null) {
            _instance = new Talher[size];
            init(size);
        }
        return _instance;
    }

    public static Talher[] getInstance() {
        return getInstance(0);
    }

    private static void init(int quantidadeFilosofos) {
        for (int i = 0; i < quantidadeFilosofos; i++) {
            _instance[i] = new Talher();
        }
    }
}
