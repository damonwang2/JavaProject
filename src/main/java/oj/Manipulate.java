package oj;

public enum Manipulate {
    CREATE {
        @Override
        public void manipulate() {

        }
    },

    DELETE {
        @Override
        public void manipulate() {

        }
    };
    public abstract void manipulate();
}
