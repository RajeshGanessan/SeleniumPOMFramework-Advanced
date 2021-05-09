package sampleTests;


public enum Severity {

        CRITICAL {
            @Override
            public String toLowerCase() {
                return Severity.CRITICAL.toString().toLowerCase();
            }
        },
        HIGH {
            @Override
            public String toLowerCase() {
                return Severity.HIGH.toString().toLowerCase();
            }
        },
        MEDIUM {
            @Override
            public String toLowerCase() {
                return null;
            }
        },
        LOW {
            @Override
            public String toLowerCase() {
                return null;
            }
        };

    public abstract String toLowerCase();
}

