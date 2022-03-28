package com.oracle.truffle.espresso.perf;

public abstract class InstrCounter {
        private InstrCounter() {
        }

        public abstract long get();

        public abstract void inc();

        public static InstrCounter create(String name) {
            return InstrCounterImpl.createImpl(name);
        }

        private static final class InstrCounterImpl extends InstrCounter {
                private final String name;
                private long value;

                private InstrCounterImpl(String name) {
                    this.name = name;
                    //this.value = new AtomicLong();
                    this.value = 0;
                }

                private static InstrCounter createImpl(String name) {
                    return new InstrCounterImpl(name);
                }

                @Override
                public long get() {
                    return value;
                }

                @Override
                public void inc() {
                    value++;
                }
        }
}
