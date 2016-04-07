package com.hakim.data.lean.operator;

/**
 * Author : Shi Haijun <br/>
 * Email : haijun@okline.cn<br/>
 * Date : 2016/3/31 20:11<br/>
 * Desc :
 */
public class Counter {
    public static final String INCREMENT = "increment";
    public static final String DECREMENT = "decrement";


    private String field;

    public Counter(String field) {
        this.field = field;
    }

    public String increment() {
        return "{\"" + field
                + "\""
                + ":"
                + new Action(INCREMENT).toString()
                + "}";
    }

    public String decrement() {
        return "{'" + field
                + '\''
                + ":"
                + new Action(DECREMENT).toString()
                + "}";
    }

    private class Action {
        private String _op;
        private int amount = 1;

        Action(String op) {
            this._op = op;
        }

        Action amount(int amount) {
            this.amount = amount;
            return this;
        }

        @Override
        public String toString() {
            return "{" +
                    "_op='" + _op + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

}
